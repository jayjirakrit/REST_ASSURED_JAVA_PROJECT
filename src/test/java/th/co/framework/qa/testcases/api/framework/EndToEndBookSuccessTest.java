package th.co.framework.qa.testcases.api.framework;

import com.itextpdf.text.DocumentException;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import th.co.framework.qa.api.base.BaseApi;

import java.io.IOException;

public class EndToEndBookSuccessTest extends BaseApi  {
    String token;
    private ITestContext context;
    public Integer bookId;
    GetBookSuccessTest getBookSuccess;
    CreateBooksSuccessTest createBooksSuccess;
    UpdateBooksSuccessTest updateBooksSuccess;
    DeleteBooksSuccessTest deleteBooksSuccess;

    @BeforeClass
    public void constructor(ITestContext context) {
        this.context = context;
        this.getBookSuccess = new GetBookSuccessTest(context);
        this.createBooksSuccess = new CreateBooksSuccessTest(context);
        this.updateBooksSuccess = new UpdateBooksSuccessTest(context);
        this.deleteBooksSuccess = new DeleteBooksSuccessTest(context);
    }

    @Test
    public void getBookSuccessTest() throws DocumentException, IOException {
        getBookSuccess.getTokenTest();
        getBookSuccess.getBooksTest();
        getBookSuccess.getBookTest();
    }

    @Test(priority = 1)
    public void createBookSuccessTest() throws DocumentException, IOException {
        createBooksSuccess.getTokenTest();
        createBooksSuccess.createBookTest();
        bookId = createBooksSuccess.bookId;
    }

    @Test(priority = 2)
    public void updateBookSuccessTest() throws DocumentException, IOException {
        updateBooksSuccess.getTokenTest();
        updateBooksSuccess.updateFullBook(bookId);
        updateBooksSuccess.updatePartialBook(bookId);
    }

    @Test(priority = 3)
    public void deleteBookSuccessTest() throws DocumentException, IOException {
        deleteBooksSuccess.getTokenTest();
        deleteBooksSuccess.deleteBook(bookId);
    }


}
