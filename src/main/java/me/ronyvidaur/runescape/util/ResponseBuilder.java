package me.ronyvidaur.runescape.util;

import java.util.HashMap;


public class ResponseBuilder {

    public static Object build(Object entity, String type ,String method, String uri) {

        HashMap response = (HashMap) ResponseBuilder.build(type, method, uri);
        response.put("data", entity);
        response.put("message", response.get("message") + " " + entity.getClass());
        return response;
    }

    public static Object build(String type, String method, String uri) {
        String message;
        if (type.equals("error")) {
            message = "failed to ";
        } else {
            message = "success at ";
        }

        HashMap response = new HashMap();
        response.put("state", type);
        response.put("message", message + method);
        response.put("path", uri);
        return response;

    }

}
