package com.example.ppkwu4;

import org.json.CDL;
import org.json.JSONArray;

public class FormatUtil {

    public static String formatString(String from, String to, String text) {
        if (from.toLowerCase().equals(to.toLowerCase())) {
            return text;
        }
        String jsonText = covertStringToJsonFormat(from, text);
        return "";
    }

    //chcemy zkonwertowac z csv lub xml lub txt na jsona
    private static String covertStringToJsonFormat(String from, String text) {
        String jsonString = null;
        switch (from) {
            case "csv":
                JSONArray jsonArray = CDL.toJSONArray(text);
                Object o = jsonArray.get(0).toString();
                break;
            case "xml":
                break;
            case "txt":
                break;
            default:
                break;
        }
        return jsonString;
    }

}
