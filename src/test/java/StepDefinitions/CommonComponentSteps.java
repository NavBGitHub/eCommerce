package StepDefinitions;

import Base.Constants;
import SelenidePageObjects.CommonComponentPage;
import Utilities.CommonAttribute;
import Utilities.ConfigurationProperties;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.*;

public class CommonComponentSteps {

    public static Logger log=LogManager.getLogger(CommonComponentSteps.class);

    private final CommonComponentPage commonComponentPage;

    public CommonComponentSteps(){
        commonComponentPage=new CommonComponentPage(CommonAttribute. driver);
    }

    @Given("I have the URL of E-commerce webpage")
    public void iHaveTheURLOfECommerceWebpage() throws IOException {
        commonComponentPage.openUrl();
    }

    @And("^I login as User$")
    public void iLoginAsUser() throws IOException {
        commonComponentPage.loginToMyAccount();
    }
}
