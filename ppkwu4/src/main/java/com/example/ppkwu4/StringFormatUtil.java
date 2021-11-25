package com.example.ppkwu4;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class StringFormatUtil {

    public static String formatString(String from, String to, String text) {
        if (from.toLowerCase().equals(to.toLowerCase())) {
            return text;
        }
        String jsonText = covertStringToJsonFormat(from, text);
        System.out.println(jsonText);
        return "";
    }

    //chcemy zkonwertowac z csv lub xml lub txt na jsona
    private static String covertStringToJsonFormat(String from, String text) {
        String jsonString = null;
        switch (from) {
            case "csv":
                JSONArray jsonArray = CDL.toJSONArray(text);
                jsonString = jsonArray.get(0).toString();
                break;
            case "xml":
                JSONObject json = XML.toJSONObject(text);
                jsonString = json.toString();
                break;
            case "txt":
                String[] textToParse = text.split("\n");
                JSONObject jsonObject = new JSONObject();
                for (String line : textToParse) {
                    String key = line.substring(0,line.indexOf(":"));
                    
                }

                break;
            default:
                break;
        }
        return jsonString;
    }

}
