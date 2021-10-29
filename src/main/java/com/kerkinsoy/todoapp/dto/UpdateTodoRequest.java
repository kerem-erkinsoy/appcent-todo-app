package com.kerkinsoy.todoapp.dto;

public class UpdateTodoRequest {

    private String content;

    private boolean completed;

    public UpdateTodoRequest(String content, boolean isCompleted) {
        this.content = content;
        this.completed = isCompleted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
