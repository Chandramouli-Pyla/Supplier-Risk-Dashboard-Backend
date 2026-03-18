package com.supplier.sotdashboard.dto;

import java.util.Map;

public class AiAskRequest {

    private String question;
    private String module;
    private String route;
    private Map<String, Object> filters;
    private Object dataContext;

    public AiAskRequest() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Map<String, Object> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, Object> filters) {
        this.filters = filters;
    }

    public Object getDataContext() {
        return dataContext;
    }

    public void setDataContext(Object dataContext) {
        this.dataContext = dataContext;
    }
}