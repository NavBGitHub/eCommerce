package StepDefinitions;

import CommonAttributes.Constants;
import SelenidePageObjects.CommonComponentPage;
import Utilities.ConfigurationProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.*;

public class CommonStepDefinitions {

    private final CommonComponentPage commonComponentPage;

    public CommonStepDefinitions(){
        commonComponentPage=new CommonComponentPage(CommonStepData.driver);
    }

    @Given("I have the URL of E-commerce webpage")
    public void iHaveTheURLOfECommerceWebpage() {
        String url;
        String titleOfWebpage;
        open(ConfigurationProperties.getPropertyValueByKey("guiURL"));
        url = getWebDriver().getCurrentUrl();
        titleOfWebpage = title();
        assertEquals("URL does not matched...", ConfigurationProperties.getPropertyValueByKey("guiURL"), url);
        assertEquals("Title of Page does not matched...", Constants.TITLE_AUTOMATION_BRO, titleOfWebpage);
    }

    @And("I login as User")
    public void iLoginAsUser() {
        commonComponentPage.LoginToMyAccount();
    }
}
