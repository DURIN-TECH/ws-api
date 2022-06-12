package com.websecure.wsapi.Response;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorResponse extends Response{
    private Map<String, List<String>> errorMap;

    public ErrorResponse(String error) {
        errorMap = new HashMap<>();
        errorMap.put("body", Collections.singletonList(error));
    }

    public Map<String, List<String>> getError() {
        return errorMap;
    }
}
