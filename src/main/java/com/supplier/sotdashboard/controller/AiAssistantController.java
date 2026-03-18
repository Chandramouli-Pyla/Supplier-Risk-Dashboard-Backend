package com.supplier.sotdashboard.controller;

import com.supplier.sotdashboard.dto.AiAskRequest;
import com.supplier.sotdashboard.dto.AiAskResponse;
import com.supplier.sotdashboard.service.AiAssistantService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
public class AiAssistantController {

    private final AiAssistantService aiAssistantService;

    public AiAssistantController(AiAssistantService aiAssistantService) {
        this.aiAssistantService = aiAssistantService;
    }

    @PostMapping("/ask")
    public AiAskResponse ask(@RequestBody AiAskRequest request) {
        String answer = aiAssistantService.askGemini(request);

        return new AiAskResponse(
                answer,
                List.of(
                        "Summarize current view",
                        "Highlight high-risk items",
                        "Explain filter result",
                        "Suggest next action"
                )
        );
    }
}