package SelenidePageObjects;

import Base.Constants;
import Utilities.ConfigurationProperties;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.*;

public class CommonComponentPage {

    public static Logger log=LogManager.getLogger(CommonComponentPage.class);

//    @FindBy(how = How.XPATH, using = "Xpath")
//    private SelenideElement element;

    public SelenideElement buttonMyAccount(){
        return $(By.xpath("//a[text()='My account']"));
    }

//    By buttonMyAccount =By.xpath("//a[text()='My account']");
    private final By inputUserName=By.xpath("//input[@id='username']");
    private final By inputPassword= By.xpath("//input[@id='password']");
    private final By buttonLogIn = By.xpath("//button[@name='login']");
    private final By userName = By.xpath("//article//strong");

    public CommonComponentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openUrl(){
        maximizeWindow()
                .assertUrlAndTitle();
    }

    public CommonComponentPage maximizeWindow(){
        getWebDriver().manage().window().maximize();
        log.info("Window maximized:: which is not a good practice...");
        return this;
    }

    public CommonComponentPage assertUrlAndTitle(){
        String url = WebDriverRunner.url();
        String titleOfWebpage = title();

        assertEquals("URL does not matched...", ConfigurationProperties.getPropertyValueByKey("guiURL"), url);
        assertEquals("Title of Page does not matched...", Constants.TITLE_AUTOMATION_BRO, titleOfWebpage);
        log.info("URL and Title matched");
        return this;
    }

    public void loginToMyAccount() {
        clickOnMyAccount()
                .enterUserName()
                .enterPassword()
                .clickOnLogInButton()
                .assertUserName();
    }

    public CommonComponentPage clickOnMyAccount(){
        String titleMyAccount;
        //different type of implementation
        buttonMyAccount()
                .should(exist)
                .shouldBe(visible).click();
        log.info("Clicked on My Account");
        titleMyAccount = getWebDriver().getTitle();
        assertEquals("My Account Title not Matched...", Constants.TITLE_MY_ACCOUNT, titleMyAccount);
        log.info("My Account title matched");
        return this;
    }

    public CommonComponentPage enterUserName() {
        $(inputUserName)
                .should(exist)
                .shouldBe(visible)
                .setValue(ConfigurationProperties.getPropertyValueByKey("UserName"));
        log.info("Set Username");
        return this;
    }

    public CommonComponentPage enterPassword() {
        $(inputPassword)
                .should(exist)
                .shouldBe(visible)
                .setValue(ConfigurationProperties.getPropertyValueByKey("Password"));
        log.info("Set Password");
        return this;
    }

    public CommonComponentPage clickOnLogInButton() {
        $(buttonLogIn)
                .should(exist)
                .shouldBe(visible).click();
        log.info("Clicked on Log In Button");
        return this;
    }

    public CommonComponentPage assertUserName(){
        String username = $(userName)
                .should(exist)
                .shouldBe(visible).getText();
        assertTrue("Username does not matched...",ConfigurationProperties.getPropertyValueByKey("UserName").contains(username));
//        assertEquals("Username does not matched...", "hiii", username);
        log.info("Username matched");
        return this;
    }

}
