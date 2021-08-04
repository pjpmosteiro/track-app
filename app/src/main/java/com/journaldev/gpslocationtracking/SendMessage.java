package com.journaldev.gpslocationtracking;

import java.util.HashMap;
import java.util.Map;

public class SendMessage {

    public void sendMessage(String longitude, String latitude) {
        try {
            // Headers
            Map<String, String> headers = new HashMap<>();
            headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
            HttpPostForm httpPostForm = new HttpPostForm("https://msg.redp.icu/message?token=A9K-dBtytwSmJ-b", "utf-8", headers);
            // Add form field
            httpPostForm.addFormField("title", "Control");
            httpPostForm.addFormField("message", "longitud: " +longitude+" . Latitud: "+latitude);
            httpPostForm.addFormField("priority", "5");
            // Result
            String response = httpPostForm.finish();
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
