package com.kerkinsoy.todoapp.dto;

public class CreateTodoRequest {

    private String content;

    public CreateTodoRequest(){
    }

    public CreateTodoRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
