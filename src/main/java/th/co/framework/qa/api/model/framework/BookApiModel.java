package th.co.framework.qa.api.model.framework;

import com.google.gson.annotations.SerializedName;
import th.co.framework.qa.api.model.BaseApiModel;

import java.util.Date;

public class BookApiModel extends BaseApiModel {

    @SerializedName("test_data")
    public
    TestData testData;

    public class TestData {
        public Body body;
        public String id;
    }

    public class Body {
        public String firstname;
        public String lastname;
        public Integer totalprice;
        public Boolean depositpaid;
        public BookDate bookingdates;
        public String additionalneeds;
    }

    public class BookDate {
        public Date checkin;
        public Date checkout;
    }

}
