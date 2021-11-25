package com.example.ppkwu4;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class StringFormatUtil {

    public static String formatString(String from, String to, String text) {
        if (from.equalsIgnoreCase(to)) {
            return text;
        }
        String jsonText = covertStringToJsonFormat(from, text);
        String response = jsonText;
        switch (to) {
            case "xml":
                JSONObject jsonObject = new JSONObject(jsonText);
                StringBuilder res = new StringBuilder("<response>");
                res.append(XML.toString(jsonObject));
                res.append("</response>");
                response = res.toString();
                break;
            case "csv":
                JSONArray jsonArray = new JSONArray();
                jsonArray.put(new JSONObject(jsonText));
                response = CDL.toString(jsonArray);
                break;
            case "txt":
                System.out.println("jsON:  "+jsonText);
                jsonObject = new JSONObject(jsonText);
                response = String.format("Text: %s\nupperCase: %s\nlowerCase: %s\ndigits: %s\nwhiteCharacters: %s\nspecialCharacters: %s",
                        jsonObject.get("textToProcess"), jsonObject.get("upperCaseCounter"), jsonObject.get("lowerCaseCounter"), jsonObject.get("digitCounter"),
                        jsonObject.get("whiteSpaceCounter"), jsonObject.get("specialCharacterCounter"));
                break;
            default:
                break;
        }
        System.out.println(response);
        return response;
    }

    private static String covertStringToJsonFormat(String from, String text) {
        String jsonString = text;
        switch (from) {
            case "csv":
                text= text.replaceAll("\\r", "");
                JSONArray jsonArray = CDL.toJSONArray(text);
                jsonString = jsonArray.get(0).toString();
                break;
            case "xml":
                JSONObject json = XML.toJSONObject(text);
                jsonString = json.getJSONObject("response").toString();
                break;
            case "txt":
                final int SPACE_SIZE = 2;
                String[] textToParse = text.split("\n");
                JSONObject jsonObject = new JSONObject();
                for (String line : textToParse) {
                    String key = line.substring(0, line.indexOf(":"));
                    String valueLine = line.substring(line.indexOf(":") + SPACE_SIZE);
                    String value=valueLine.trim();

                    jsonObject.put(key, value);
                }
                jsonString = jsonObject.toString();
                break;
            default:
                break;
        }
        return jsonString;
    }

}
