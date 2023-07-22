package StepDefinitions;

import Utilities.ConfigurationProperties;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SetUpTearDown {

    public static Logger log=LogManager.getLogger(SetUpTearDown.class);

    public static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
        log.info("Allure Report added");
    }

    @Before(order = 1)
    public void beforeLocal() throws IOException {
        log.info("Hi Welcome to Web Automation");
        setUpLocal();
        setupAllureReports();
    }

    public void setUpLocal() throws IOException {
        Configuration.browser = "chrome";
        log.info("Browser:: "+Configuration.browser);
        Configuration.headless = true;
        log.info("HeadlessMode:: "+Configuration.headless);
        Configuration.holdBrowserOpen = false;
        log.info("Is Browser Holds Open:: "+Configuration.holdBrowserOpen);
        Configuration.screenshots = true;
        log.info("Is Screenshot Captured:: "+Configuration.screenshots);
        Configuration.timeout = 8000;
        log.info("Timeout choosen is:: "+Configuration.timeout);
        Configuration.baseUrl = ConfigurationProperties.getPropertyValueByKey("guiURL");
        log.info("Base URL is:: "+Configuration.baseUrl);
        open(ConfigurationProperties.getPropertyValueByKey("guiURL"));
        log.info("Opened Web application is:: "+ConfigurationProperties.getPropertyValueByKey("guiURL"));
    }

    @After
    public void after(){
        closeWebDriver();
        log.info("Quitting WebDriver...");
    }
}
