package th.co.framework.qa.api.util;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class ReadApiJson {
    public static JSONObject readJson(String patch) {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream(patch);
            Object obj = parser.parse(new InputStreamReader(is));
            jsonObject = (JSONObject) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public static String readJsonSchema(String path) {
        String schemaContent = "";
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream(path);
            schemaContent = IOUtils.toString(is, StandardCharsets.UTF_8.name());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schemaContent;
    }

}
