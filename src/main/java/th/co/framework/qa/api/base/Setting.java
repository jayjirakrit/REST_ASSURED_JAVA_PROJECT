package th.co.framework.qa.api.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Setting {

    public static final String DATE_TIME = new SimpleDateFormat("yyyy-MM-dd hh mm:ss").format(new Date());
    public static String SERVER = "dev";
    public static AUTOMATE_TYPE AUTOMATE = AUTOMATE_TYPE.API;
    public static String PROJECT_NAME = "ARV Project";
    public static String TEAM_NAME = "ARV QA Team";
    public static final String KEY_REPORT_EXPECTED_RESULT = "Expected Result: ";
    public static final String KEY_REPORT_INPUT_DATA = "Input data: ";
    public static final String KEY_REPORT_SCREEN_CAPTURE = "Screen capture: ";
    public static final String FIREBASE_KEY = "ewogICJ0eXBlIjogInNlcnZpY2VfYWNjb3VudCIsCiAgInByb2plY3RfaWQiOiAiYXV0b21hdGV0dGIiLAogICJwcml2YXRlX2tleV9pZCI6ICI3NTVkYjM4OTY3NDg0Njk5NGEzMDdlYTBiNTk0YTMxMTNlOWY2YzdiIiwKICAicHJpdmF0ZV9rZXkiOiAiLS0tLS1CRUdJTiBQUklWQVRFIEtFWS0tLS0tXG5NSUlFdlFJQkFEQU5CZ2txaGtpRzl3MEJBUUVGQUFTQ0JLY3dnZ1NqQWdFQUFvSUJBUUN6d1g3bkJYUjR6MXZtXG5aV1J1S1QzNkt1L2svRkxjd3h2elV4d1pkT2VmTzY1TXVJZ3VDb2p6V1VvUFlYUUdFZWhYd2lnd0hkeHkyY0Z2XG5vQUdNV1YvTjNTS0RkT2l4ZjRrRUV5TWcvbkFVbnd3WEFLSTRQWkRWa2d0M2c2eWh0OFBYSlJ4Vkc4WXBkZU1SXG5YMGh1SW91aUR6U2xMOTVscm5rSG1Da1NiQm9sNUtSaFo4MWF5S2lQQ2VoYzRSQkdWczBkbzVCK24yWUJ2R3FSXG44YXlqc3ZSdkhCSGI0anJndVBrcUxxbUQ1RlNpbTNmMDZGbkRMdHIzSWdWVjBJY0Q0UmpmVHZWTXIvVU11dXBtXG5qK3c5N2FYMEViYkhwb1d3bW90dUp4V3dNVGtMYkN2cDBOQm9TVmlYYWtxL2kzSmtPeUdueUE4cmZFQlhvdDJKXG5oWWNMWWZ1UkFnTUJBQUVDZ2dFQUFnMitJaXdQQ0ZsUUlybjZVNExmblNYVDcxRU5yazJCV242UzFkeWV6OVFwXG4rZURxMTJIUjdqdlJLNHRRdk1nRUdFcVUxSFhtNEo0SnhubDB3eEo3VkhvSURLbnZoYVdnSGw2TW1uSWx2Q3FVXG5CQWhERWpMcjNuRElka0ZZSGRIZ2FDc1puNFJOZDRoTUE1VUwyZ3hGZmFEQVdIbkxSK3llSDk3V2EwbzJZMFBzXG5TSWsrUHozNFJFSmVLQlNKRmRFNHovNWdGU2JPVGxSbGZEd1h6NGdjM2J0Y3k3ZEFiaU1HS3lXNHBVK3RnY0hJXG5TR3R3TFVURzQxVnpHdXpJa0V4VXEzTkUycmFyNXZnMnFkZlVZL2VKUmtWSFVrOWpTQXoyNWZ5U2lFeVQ5R2lTXG5nRWMzaGZSa1BWUTBreW1CTUtzb1pzMVF6RldtTzNtN2U3K1J5c3gxdFFLQmdRRHc4MW1TWjlMUTRSdVY5UTJaXG5DdldadWZvdE5iL0FPaFlCMGY0bjhTVXNQQTYySjQvbG5KN0krS2FIdlBLeFN2NVRGbzhxRFpNeU9kYmtBbGN4XG5lTHlwOGVvMlhwL3RCNjZwVXc3Z2tCN2tmZGxjRFNrSEpWajR1WTd6SFhDU0diOUYrcWlkNEh3c1g0d2ROKzRQXG44WHRZSGlGT1JzZC9FbWV0RHJqRTN5a0N0UUtCZ1FDKys2NFBCUUhPWHFZZnBwWEgrTEJrZHRSYko3OUVTb2VkXG5uVTZJMTlqelB6SngvSjR2aGhyd1NOR2dXd3hlWXJaWWd5ZlZkak5wRzRzV1FkR01qK0Vzd2lucmVBTC8yZTJ4XG5vT0ltMkNTcGJIVXVnZFZxNTlQczBFeGxvVlRIeFhta3hHNFpWNGxvMUtZNVh1YXdGaVU1R091RytaU0IrY1NtXG5BL2hzT3FyUzdRS0JnRTUySC92aDNTOXhya2IxcG5qb3JiTmljVW9aajVoc0VkQ0Q3aXhaaFU1VFBFTXF2TnY3XG5WV1dDT3RCR3dnempxOCtvci9QMHViTUlUS2F3OEczR3NFRHk2dDdMajI1akt3Z3VhTkROZlpIUVBXQ1JWSVBrXG5NSVhGL3Z2QjRXOWgvUHd2dElxOG1CTG5CanhaZ3ljajdwTnlORXhHRmg2V0FyYkM3WDRHWVZkbEFvR0FQRVVjXG50dXl6bHpiVFlpV21Hd2RtVXk0VThmZG5LdHdDVkVFeWFZa0VsQzhiY2xGd2NqcjJBV0pabFN0bWlkckpCTUhQXG5MbFF4QVRpSitpb25RUjZleHdzM1EzSUtNRWZMOVVSNldodlg1Z2V1SzFFWjByVDZjaitCL0lpZlFyUVZJV1JFXG5Bb2RYZTlldjVXY0hrZ1pMRk92Q1dFUW5FNldJNDROWlFINTdMamtDZ1lFQXNJYWxsRCtsMWlNbEN0aFRodGorXG5Nc3loRUN5WW9IaWthWG9zUzVUZ0wvazBqMzR5QUs3dzYvWk1QS0NBWldlRTZTU0xFbVpCQVBmbEhxTWo5emkrXG5ER1NaS2QvUEFONlFONkQzOGV1cUdyL0xidmE0eDlQUVRUaFZ6YlMyQWpMSEh0OG14REpVR1A5RFBaL09lVG1xXG54b2NWWjkwU0dEVU9aOEZaeHNBM1JlND1cbi0tLS0tRU5EIFBSSVZBVEUgS0VZLS0tLS1cbiIsCiAgImNsaWVudF9lbWFpbCI6ICJmaXJlYmFzZS1hZG1pbnNkay05dmc1MUBhdXRvbWF0ZXR0Yi5pYW0uZ3NlcnZpY2VhY2NvdW50LmNvbSIsCiAgImNsaWVudF9pZCI6ICIxMTU2MzQzMDU1OTIzMjUyNDQyODkiLAogICJhdXRoX3VyaSI6ICJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20vby9vYXV0aDIvYXV0aCIsCiAgInRva2VuX3VyaSI6ICJodHRwczovL29hdXRoMi5nb29nbGVhcGlzLmNvbS90b2tlbiIsCiAgImF1dGhfcHJvdmlkZXJfeDUwOV9jZXJ0X3VybCI6ICJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9vYXV0aDIvdjEvY2VydHMiLAogICJjbGllbnRfeDUwOV9jZXJ0X3VybCI6ICJodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9yb2JvdC92MS9tZXRhZGF0YS94NTA5L2ZpcmViYXNlLWFkbWluc2RrLTl2ZzUxJTQwYXV0b21hdGV0dGIuaWFtLmdzZXJ2aWNlYWNjb3VudC5jb20iCn0K";


    public enum RESULT_TYPE {
        PASS,
        FAILED,
        SKIP
    }

    public enum AUTOMATE_TYPE {
        WEB,
        APP,
        API
    }

    public class ExportPdfKey {
        public static final String TITLE_FILE = "ARV TCS Test Results & Evaluation Report of QA";
        public static final String SUBJECT = "Automate testing for ARV";
        public static final String KEYWORDS = "ARV,PPT, AT, QA, Automate, Testing, Automation, Automate Testing";
        public static final String AUTHOR = "ARV QA Team";
        public static final String CREATOR = "ARV QA Team";

    }

    public class WebBrowser {
        public  static final String IE = "ie";
        public  static final String CHROME = "chrome";
        public  static final String FIREFOX = "firefox";
        public static final String OPERA = "opera";
        public  static final String SAFARI = "safari";
        public  static final String MICROSOFT_EDGE = "edge";
    }

    public class AddLogsParameter {
        public static final String DESCRIPTION = "description";
        public static final String EXPECTED_RESULT = "expected_result";
        public static final String TEST_CASE_ID = "test_case_id";

    }

    public static class Config {
        public static Boolean IS_EXPORT_EXCEL = false;
        public static Boolean IS_EXPORT_PDF = false;
        public static Boolean IS_SEND_EMAIL = false;
        public static Boolean IS_SAVE_LOGS = false;

    }

    public static class EmailConfig {
        public static String SMTP_SERVER = "";
        public static String USER_NAME = "";
        public static String PASSWORD = "";
        public static String EMAIL_FROM = "";
    }


}


