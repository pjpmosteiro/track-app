package com.journaldev.gpslocationtracking;

import java.util.HashMap;
import java.util.Map;

public class SendMessage {

    public void sendMessage(String longitude, String latitude, String url, String token) {
        try {
            // Headers
            Map<String, String> headers = new HashMap<>();
            headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
            HttpPostForm httpPostForm = new HttpPostForm("https://msg.redp.icu/message?token="+token, "utf-8", headers);
            // Add form field
            httpPostForm.addFormField("title", "Información de ubicación");
            httpPostForm.addFormField("message", "Longitud: " +longitude+" . Latitud: "+latitude+". ||| URL MAPS: "+url);
            httpPostForm.addFormField("priority", "5");
            // Result
            String response = httpPostForm.finish();
            //System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessageWithoutCoordinates(String message, String url, String token) {
        try {
            // Headers
            Map<String, String> headers = new HashMap<>();
            headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
            HttpPostForm httpPostForm = new HttpPostForm("https://msg.redp.icu/message?token="+token, "utf-8", headers);
            // Add form field
            httpPostForm.addFormField("title", "Mensaje");
            httpPostForm.addFormField("message", message);
            httpPostForm.addFormField("priority", "5");
            // Result
            String response = httpPostForm.finish();
            //System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
