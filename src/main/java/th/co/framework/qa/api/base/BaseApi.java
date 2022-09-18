package th.co.framework.qa.api.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.itextpdf.text.DocumentException;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import th.co.framework.qa.api.util.LogsFilter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseApi {

    public static ExtentSparkReporter sparkHtmlReporter;
    public static ExtentReports extent;
    public static ExtentTest parentReport;
    public static ExtentTest childReport;
    public static String apiReportName = "";
    public static String baseUrlApi = "";

    protected final String REQUEST_BODY = "Request Body:";
    protected final String RESPONSE_BODY = "Response Body:";


    @Parameters({"suite_name", "service_name"})
    @BeforeTest
    public void beforeTestBase(String suiteName,@Optional("API") String serviceName) throws DocumentException, IOException {
        baseUrlApi = "https://restful-booker.herokuapp.com";
        LogsFilter logsFilter = new LogsFilter();
        RestAssured.baseURI = baseUrlApi;
        RestAssured.requestSpecification = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
                .build().filters(logsFilter)
                .log().uri();
        String date = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss_a").format(new Date());
        apiReportName = "API-" + serviceName.toUpperCase() + "-" + suiteName.toUpperCase() + "-" + date + ".html";
        sparkHtmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + apiReportName);
        sparkHtmlReporter.config().setTheme(Theme.STANDARD);
        sparkHtmlReporter.config().setCss("css-string");
        sparkHtmlReporter.config().setEncoding("utf-8");
        sparkHtmlReporter.config().setJs("js-string");
        sparkHtmlReporter.config().setTimelineEnabled(true);
        sparkHtmlReporter.config().setProtocol(Protocol.HTTPS);
        sparkHtmlReporter.config().setDocumentTitle(Setting.TEAM_NAME + " Application Report build: " + Setting.DATE_TIME);
        sparkHtmlReporter.config().setReportName("Report name: " + Setting.TEAM_NAME + " Application Report build: " + Setting.DATE_TIME);
        extent = new ExtentReports();
        extent.attachReporter(sparkHtmlReporter);
        extent.setSystemInfo("OS", System.getProperty("os.name").toLowerCase());
        extent.setSystemInfo("Project", Setting.PROJECT_NAME);
        extent.setSystemInfo("Team", Setting.TEAM_NAME);
        extent.setSystemInfo("URL", baseUrlApi);
        extent.setSystemInfo("Build number", System.getProperty("buildNumber"));
        extent.setSystemInfo("Test Version", "1.1.0");
        extent.setSystemInfo("Date Time", Setting.DATE_TIME);
        extent.setSystemInfo("Service", serviceName.toUpperCase());
        sparkHtmlReporter.config().setProtocol(Protocol.HTTPS);
        sparkHtmlReporter.config().setReportName(Setting.TEAM_NAME + " Application Report build: " + Setting.DATE_TIME);
        sparkHtmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
        extent.attachReporter(sparkHtmlReporter);
    }


    @AfterTest
    public void afterTestBase() {
        extent.flush();
        RestAssured.reset();
    }


    @Parameters({"service_name",})
    @AfterMethod
    public void getResult(ITestResult result, ITestContext context,@Optional("API") String serviceName) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            childReport.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            childReport.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            childReport.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
        } else {
            childReport.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            childReport.skip(result.getThrowable());
        }
    }
}
