package th.co.framework.qa.api.endpoint;

public class Framework {

    //------------- Endpoint --------------//

    public static String requestCreateToken() {
        String requestRoute = "/auth";
        return requestRoute;
    }

    public static String requestGetBooks() {
        String requestRoute = "/booking";
        return requestRoute;
    }

    public static String requestGetBook() {
        String requestRoute = "/booking/{id}";
        return requestRoute;
    }

    public static String requestCreateBook() {
        String requestRoute = "/booking";
        return requestRoute;
    }

    public static String requestUpdateBook() {
        String requestRoute = "/booking/{id}";
        return requestRoute;
    }

    public static String requestDeleteBook() {
        String requestRoute = "/booking/{id}";
        return requestRoute;
    }

}
