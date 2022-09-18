package th.co.framework.qa.api.util;

import com.google.gson.Gson;
import org.testng.annotations.Optional;
import th.co.framework.qa.api.base.Setting;
import th.co.framework.qa.api.model.EnvironmentApiModel;


public class ConfigurationAPI {
    public static String setup(@Optional String serviceName) {
        String baseUrlApi = "";
        EnvironmentApiModel dataModel = new Gson().fromJson(String.valueOf(GetApiJsonTestCase.getEnvironment()), EnvironmentApiModel.class);

        final String SERVER = System.getProperty("environment").toLowerCase();

        switch (SERVER.toLowerCase().toString()) {
            case "dev":
                System.setProperty("server", "dev");
                    baseUrlApi = dataModel.server.dev;
                break;
            case "qa":
                System.setProperty("server", "qa");
                baseUrlApi = dataModel.server.qa;
                break;
            case "staging":
                System.setProperty("server", "staging");
                baseUrlApi = dataModel.server.staging;
                break;
        }

        Setting.Config.IS_SEND_EMAIL = Boolean.parseBoolean(System.getProperty("sendExportEmail"));
        Setting.Config.IS_EXPORT_EXCEL = Boolean.parseBoolean(System.getProperty("generateExportExcelFile"));
        Setting.Config.IS_EXPORT_PDF = Boolean.parseBoolean(System.getProperty("generateExportPdfFile"));
        Setting.Config.IS_SAVE_LOGS = Boolean.parseBoolean(System.getProperty("saveLogs"));
        return baseUrlApi;
    }
}
