package StepDefinitions;

import CommonAttributes.Constants;
import SelenidePageObjects.CommonComponentPage;
import Utilities.CommonStepData;
import Utilities.ConfigurationProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.*;

public class CommonStepDefinitions {

    public static Logger log;

    private final CommonComponentPage commonComponentPage;

    public CommonStepDefinitions(){
        commonComponentPage=new CommonComponentPage(CommonStepData. driver);
        LogManager.getLogger(CommonComponentPage.class);
        LogManager.getLogger(CommonStepDefinitions.class);
    }

    @Given("I have the URL of E-commerce webpage")
    public void iHaveTheURLOfECommerceWebpage() throws IOException {
        String url;
        String titleOfWebpage;
        getWebDriver().manage().window().maximize();
        open(ConfigurationProperties.getPropertyValueByKey("guiURL"));
        url = getWebDriver().getCurrentUrl();
        titleOfWebpage = title();
        assertEquals("URL does not matched...", ConfigurationProperties.getPropertyValueByKey("guiURL"), url);
        assertEquals("Title of Page does not matched...", Constants.TITLE_AUTOMATION_BRO, titleOfWebpage);
    }

    @And("^I login as User$")
    public void iLoginAsUser() throws IOException {
        commonComponentPage.LoginToMyAccount();
    }
}
