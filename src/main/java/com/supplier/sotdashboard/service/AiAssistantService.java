package com.supplier.sotdashboard.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.supplier.sotdashboard.dto.AiAskRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AiAssistantService {

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String askGemini(AiAskRequest request) {
        try {
            String prompt = buildPrompt(request);

            Map<String, Object> textPart = new LinkedHashMap<>();
            textPart.put("text", prompt);

            Map<String, Object> content = new LinkedHashMap<>();
            content.put("parts", List.of(textPart));

            Map<String, Object> requestBody = new LinkedHashMap<>();
            requestBody.put("contents", List.of(content));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

            String url = geminiApiUrl + "?key=" + geminiApiKey;

            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    String.class
            );

            return extractAnswer(response.getBody());

        } catch (HttpClientErrorException.TooManyRequests ex) {
            return """
                    Gemini quota exceeded for the current project.

                    Recommended next step:
                    1. Check API usage and billing for the Gemini project
                    2. Retry after a short wait
                    3. If needed, switch to a supported model and ensure quota is available
                    """;
        } catch (HttpClientErrorException ex) {
            ex.printStackTrace();
            return "Gemini API error: " + ex.getStatusCode() + " - " + ex.getResponseBodyAsString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error while calling Gemini API: " + ex.getMessage();
        }
    }

    private String extractAnswer(String responseBody) {
        try {
            JsonNode root = objectMapper.readTree(responseBody);

            JsonNode textNode = root.path("candidates")
                    .path(0)
                    .path("content")
                    .path("parts")
                    .path(0)
                    .path("text");

            if (!textNode.isMissingNode() && !textNode.isNull()) {
                return textNode.asText();
            }

            JsonNode finishReason = root.path("candidates").path(0).path("finishReason");
            if (!finishReason.isMissingNode()) {
                return "Gemini did not return a text response. Finish reason: " + finishReason.asText();
            }

            return "No answer returned by Gemini.";
        } catch (Exception ex) {
            return "Unable to parse Gemini response: " + ex.getMessage();
        }
    }

    private String buildPrompt(AiAskRequest request) {
        return """
            You are an AI assistant inside an automotive supplier risk dashboard.

            Your role:
            - Act like a business dashboard analyst and product advisor
            - Answer using the provided module, route, filters, and data context
            - Never invent counts, metrics, suppliers, sites, or trends not supported by the data
            - If the question is about chart meaning, summary, risk, filters, or operational insight, answer strictly from the available data
            - If the question is about feature suggestions, UX improvements, dashboard enhancements, or recommended additions, you may make reasonable product suggestions based on the current module and current visible metrics
            - For feature suggestions, do not claim they already exist; clearly present them as recommendations
            - Only say "insufficient data" when the question cannot be answered at all from either the visible context or reasonable module-based product thinking
            - Keep answers concise, structured, and professional

            Interpretation guidance:
            - If the user asks what a chart or distribution represents, explain:
              1. what it measures
              2. what the current values indicate
            - If the user asks for feature suggestions, recommend practical enterprise dashboard features relevant to the current module
            - If the user asks for recommendations, prioritize operational usability, drill-downs, filters, alerts, trends, benchmarks, and actionability
            - If the user asks about filters, use only the filtered context provided

            Domain guidance:
            - "Open" means unresolved or in-progress items
            - "Green" means stable / low-risk items
            - "Yellow" means moderate-risk items needing monitoring
            - "Red" means critical / high-risk items needing immediate attention
            - "Supplier Portfolio" focuses on supplier risk, KPI trends, SOT breakdown, release planning, freight impact, and supplier health

            Output rules:
            - Do not mention raw JSON
            - Do not say "based on the provided JSON"
            - Do not repeat the user's question
            - Use plain business language
            - Keep answer in this format:

            1. Direct answer
            2. Key observations
            3. Recommended next step

            Current module:
            %s

            Current route:
            %s

            Applied filters:
            %s

            Data context:
            %s

            User question:
            %s
            """.formatted(
                safeValue(request.getModule()),
                safeValue(request.getRoute()),
                safeJson(request.getFilters()),
                safeJson(request.getDataContext()),
                safeValue(request.getQuestion())
        );
    }

    private String safeValue(Object value) {
        return value == null ? "N/A" : String.valueOf(value);
    }

    private String safeJson(Object value) {
        try {
            if (value == null) {
                return "N/A";
            }
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
        } catch (Exception ex) {
            return String.valueOf(value);
        }
    }
}