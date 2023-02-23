package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;

public class BaseTest {


    Attachments attachments = new Attachments();
    Properties properties = new Properties();

    @BeforeAll
    static void configure() {
        Properties.settingsSelenoid();
        Properties.settingsJenkins();
        Properties.settingAllure();
    }

    @AfterEach
    void addAttachments() {
        attachment("Source", webdriver().driver().source());
        attachments.takeScreenshot();
        attachments.pageSource();
        attachments.browserConsoleLogs();
        attachments.addVideo();

    }


}
