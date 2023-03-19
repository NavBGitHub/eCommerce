package SelenidePageObjects;

import CommonAttributes.Constants;
import Utilities.ConfigurationProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.*;

public class CommonComponentPage {

    By buttonMyAccount =By.xpath("//a[text()='My account']");
    By inputUserName=By.xpath("//input[@id='username']");
    By inputPassword= By.xpath("//input[@id='password']");
    By buttonLogIn = By.xpath("//button[@name='login']");
    By userName = By.xpath("//article//strong");

    public CommonComponentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void LoginToMyAccount(){
        this.clickOnMyAccount();
        this.enterUserName();
        this.enterPassword();
        this.clickOnLogInButton();
    }

    public void clickOnMyAccount(){
        String titleMyAccount;
        $(buttonMyAccount)
                .shouldBe(visible).click();

        titleMyAccount = getWebDriver().getTitle();
        assertEquals("My Account Title Matched...", Constants.TITLE_MY_ACCOUNT, titleMyAccount);
    }

    public void enterUserName(){
        $(inputUserName)
                .shouldBe(visible)
                .val(ConfigurationProperties.getPropertyValueByKey("UserName"));
    }

    public void enterPassword(){
        $(inputPassword)
                .shouldBe(visible)
                .val(ConfigurationProperties.getPropertyValueByKey("Password"));
    }

    public void clickOnLogInButton(){
        $(buttonLogIn)
                .shouldBe(visible).click();

        String username = $(userName)
                .shouldBe(visible).getText();

        assertTrue(ConfigurationProperties.getPropertyValueByKey("UserName").contains(username));
    }

}
