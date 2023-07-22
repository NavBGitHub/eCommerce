package SelenidePageObjects;

import CommonAttributes.Constants;
import Utilities.ConfigurationProperties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.*;

public class CommonComponentPage {

    public static Logger log=LogManager.getLogger(CommonComponentPage.class);


    @FindBy(how = How.XPATH, using = "Xpath")
    private WebElement element;

    By buttonMyAccount =By.xpath("//a[text()='My account']");
    By inputUserName=By.xpath("//input[@id='username']");
    By inputPassword= By.xpath("//input[@id='password']");
    By buttonLogIn = By.xpath("//button[@name='login']");
    By userName = By.xpath("//article//strong");

    public CommonComponentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



    public void LoginToMyAccount() throws IOException {
        this.clickOnMyAccount();
        this.enterUserName();
        this.enterPassword();
        this.clickOnLogInButton();
    }

    public void clickOnMyAccount(){
        log.info("ewwwwwwwwwwwww started");
        String titleMyAccount;
        $(buttonMyAccount)
                .shouldBe(visible).click();


        titleMyAccount = getWebDriver().getTitle();
        assertEquals("My Account Title Matched...", Constants.TITLE_MY_ACCOUNT, titleMyAccount);
    }

    public void enterUserName() {
        $(inputUserName)
                .shouldBe(visible)
                .val(ConfigurationProperties.getPropertyValueByKey("UserName"));
    }

    public void enterPassword() throws IOException {
        $(inputPassword)
                .shouldBe(visible)
                .val(ConfigurationProperties.getPropertyValueByKey("Password"));
    }

    public void clickOnLogInButton() throws IOException {

        String a="Priti";
        String b="Priti";



        $(buttonLogIn)
                .shouldBe(visible).click();

        String username = $(userName)
                .shouldBe(visible).getText();

        assertTrue(ConfigurationProperties.getPropertyValueByKey("UserName").contains(username));
    }

}
