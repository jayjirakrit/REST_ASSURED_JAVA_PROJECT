package th.co.framework.qa.api.util;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.itextpdf.text.DocumentException;
import org.apache.commons.codec.binary.Base64;
import org.testng.ITestContext;
import th.co.framework.qa.api.base.Setting;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Common {

    public static String decodeJWTToken(String token) {
        String[] chunks = token.split("\\.");
        java.util.Base64.Decoder decoder = java.util.Base64.getUrlDecoder();
        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));
        System.out.println(payload);
        return payload;
    }

    public void addInputDataToReport(Map<String, Object> mapData,ExtentTest childReport) throws IOException, DocumentException {
        for (Map.Entry<String, Object> inputData : mapData.entrySet()) {
            if (inputData.getValue() != null) {
                childReport.log(Status.INFO, "Input: "+inputData.getKey() + ": " + TextColor.blueColor(inputData.getValue() == null ? "" : inputData.getValue().toString()));
            }
        }
    }

    public void addJsonDataToReport(String jsonString, String bodyType, ExtentTest childReport) {
        childReport.log(Status.INFO, bodyType);
        childReport.log(Status.INFO, MarkupHelper.createCodeBlock(jsonString, CodeLanguage.JSON));
    }

    public void addLogs(ITestContext context,String description, String expectedResult) throws IOException, DocumentException {
        context.getCurrentXmlTest().addParameter(Setting.AddLogsParameter.DESCRIPTION, description);
        context.getCurrentXmlTest().addParameter(Setting.AddLogsParameter.EXPECTED_RESULT, expectedResult);
    }

    public void addExpectedResultToReport(ArrayList<String> expectedResult,ExtentTest childReport) throws IOException, DocumentException {
        for (String actualResult : expectedResult) {
            childReport.log(Status.INFO, Setting.KEY_REPORT_EXPECTED_RESULT + TextColor.greenColor(actualResult.replace("<br>", "")));
        }
    }


    public static String isPass(boolean pass) {
        return pass ? "PASS" : "FAILED";
    }

    public static String getDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm ss a").format(new Date());
    }


    private String rootEncodeFileToBase64Binary() throws IOException, AWTException {
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "png", os);
        byte[] encoded = Base64.encodeBase64(os.toByteArray());
        return new String(encoded, StandardCharsets.US_ASCII);
    }

}
