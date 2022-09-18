package th.co.framework.qa.api.util;

import org.json.simple.JSONObject;

public class GetApiJsonTestCase {

    public static JSONObject getEnvironment() {
        return ReadApiJson.readJson("api/json/framework/login_api_testcase.json");
    }
    public static JSONObject getLoginTestCase() {
        return ReadApiJson.readJson("api/json/framework/login_api_testcase.json");
    }

    public static String createBookSchema() {
        return ReadApiJson.readJsonSchema("api/json/framework/create_book_schema.json");
    }

    public static JSONObject createBookTestCase() {
        return ReadApiJson.readJson("api/json/framework/create_book_testcase.json");
    }

    public static JSONObject getBookTestCase() {
        return ReadApiJson.readJson("api/json/framework/get_book_testcase.json");
    }

    public static JSONObject updateBookTestCase() {
        return ReadApiJson.readJson("api/json/framework/update_book_testcase.json");
    }

    public static JSONObject deleteBookTestCase() {
        return ReadApiJson.readJson("api/json/framework/delete_book_testcase.json");
    }

}
