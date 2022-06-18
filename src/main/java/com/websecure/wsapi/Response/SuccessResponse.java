package com.websecure.wsapi.Response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class SuccessResponse extends Response{
    private Object body;

    public SuccessResponse() {
        setStatus(true);
    }

    public SuccessResponse(Object body) {
        this.body = body;
        setStatus(true);
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Object getData() {
        return body;
    }
}
