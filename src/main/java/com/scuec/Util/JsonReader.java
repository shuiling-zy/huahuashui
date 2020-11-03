package com.scuec.Util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JsonReader {

    /**
     * 从request中获取json数据
     *
     * @param request
     * @return
     */
    public static String getJsonRequest(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String string = sb.toString();
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                request.getInputStream().close();
            } catch (IOException e) {
                return null;
            }
        }
    }
}
