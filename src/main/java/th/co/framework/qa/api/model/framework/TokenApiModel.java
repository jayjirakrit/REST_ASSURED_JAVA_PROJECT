package th.co.framework.qa.api.model.framework;

import com.google.gson.annotations.SerializedName;
import th.co.framework.qa.api.model.BaseApiModel;

public class TokenApiModel extends BaseApiModel {

    @SerializedName("test_data")
    public
    TestData testData;

    public class TestData {
        public Body body;
    }

    public class Body {
        public String username;
        public String password;
    }

}
