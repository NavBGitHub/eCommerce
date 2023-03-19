package StepDefinitions;

import Utilities.ConfigurationProperties;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.open;

public class SetUpTearDown {

    @Before
    public void beforeLocal(){
        setUpLocal();
    }

    public void setUpLocal(){
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = true;
        Configuration.timeout = 8000;
        Configuration.baseUrl = ConfigurationProperties.getPropertyValueByKey("guiURL");
        open(ConfigurationProperties.getPropertyValueByKey("guiURL"));
    }
}
