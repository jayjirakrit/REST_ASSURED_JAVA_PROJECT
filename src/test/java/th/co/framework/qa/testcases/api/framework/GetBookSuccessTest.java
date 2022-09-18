package th.co.framework.qa.testcases.api.framework;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import th.co.framework.qa.api.base.BaseApi;
import th.co.framework.qa.api.model.framework.BookApiModel;
import th.co.framework.qa.api.model.framework.TokenApiModel;
import th.co.framework.qa.api.service.AuthService;
import th.co.framework.qa.api.service.BookService;
import th.co.framework.qa.api.util.Common;
import th.co.framework.qa.api.util.GetApiJsonTestCase;

import java.io.IOException;
import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetBookSuccessTest extends BaseApi {

    public String token;
    private ITestContext context;
    private BookService bookService;
    private AuthService authService;
    public Integer bookId;

    @BeforeClass
    public void constructor(ITestContext context) {
        this.context = context;
        this.authService = new AuthService();
    }

    public GetBookSuccessTest(ITestContext context) {
        this.context = context;
        this.authService = new AuthService();
    }

    @Test(priority = 0)
    public void getTokenTest() throws DocumentException, IOException {
        String testCaseId = "login_id_0001";
        TokenApiModel model = new Gson().fromJson(String.valueOf(GetApiJsonTestCase.getLoginTestCase().get(testCaseId)), TokenApiModel.class);
        parentReport = extent.createTest(this.getClass().getSimpleName(), this.getClass().getSimpleName());
        childReport = parentReport.createNode(model.description);
        new Common().addLogs(context, model.description, Arrays.toString(model.expectedResult.toArray()));
        new Common().addExpectedResultToReport(model.expectedResult, childReport);
        new Common().addJsonDataToReport(new Gson().toJson(model.testData.body), REQUEST_BODY, childReport);
        // Prepare Request Specification
        RequestSpecification requestSpec = authService.preparePostToken();
        childReport.log(Status.INFO, SpecificationQuerier.query(requestSpec).getURI());
        // Send Request to Call API
        Response response = authService.callPostService(requestSpec, new Gson().toJson(model.testData.body));
        new Common().addJsonDataToReport(response.asString(), RESPONSE_BODY, childReport);
        // Validate Status Code
        assertThat(response.statusCode()).isIn(Integer.valueOf(model.expectedResultKey.get(0)));
        token = response.path("token");
        // Validate Token is not Null
        Assert.assertNotNull(token, "Username or Password is invalid");
        this.bookService = new BookService(token);
    }

    @Test(priority = 1)
    public void getBooksTest() throws DocumentException, IOException {
        String testCaseId = "get_books_id_0001";
        BookApiModel model = new Gson().fromJson(String.valueOf(GetApiJsonTestCase.getBookTestCase().get(testCaseId)), BookApiModel.class);
        childReport = parentReport.createNode(model.description);
        new Common().addLogs(context, model.description, Arrays.toString(model.expectedResult.toArray()));
        new Common().addExpectedResultToReport(model.expectedResult, childReport);
        // Prepare Request Specification
        RequestSpecification requestSpec = bookService.prepareGetBooks();
        childReport.log(Status.INFO, SpecificationQuerier.query(requestSpec).getURI());
        // Send Request to Call API
        Response response = bookService.callGetService(requestSpec);
        // Validate Status Code
        assertThat(response.statusCode()).isIn(Integer.valueOf(model.expectedResultKey.get(0)));
        bookId = response.path("[0].bookingid");
    }

    @Test(priority = 2)
    public void getBookTest() throws DocumentException, IOException {
        String testCaseId = "get_book_id_0001";
        BookApiModel model = new Gson().fromJson(String.valueOf(GetApiJsonTestCase.getBookTestCase().get(testCaseId)), BookApiModel.class);
        childReport = parentReport.createNode(model.description);
        new Common().addLogs(context, model.description, Arrays.toString(model.expectedResult.toArray()));
        new Common().addExpectedResultToReport(model.expectedResult, childReport);
        model.testData.id = String.valueOf(bookId);
        // Prepare Request Specification
        RequestSpecification requestSpec = bookService.prepareGetBook(model.testData.id);
        childReport.log(Status.INFO, SpecificationQuerier.query(requestSpec).getURI());
        // Send Request to Call API
        Response response = bookService.callGetService(requestSpec);
        // Validate Status Code
        assertThat(response.statusCode()).isIn(Integer.valueOf(model.expectedResultKey.get(0)));
    }


}
