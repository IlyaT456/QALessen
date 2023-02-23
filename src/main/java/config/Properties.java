package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Properties {
    public static void settingsSelenoid() {
        //��������� selenoid
        Configuration.driverManagerEnabled = true;
        Configuration.browserCapabilities = new DesiredCapabilities();
        Configuration.browserCapabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities.setCapability("enableVideo", true);
        Configuration.browserSize = "1920x1080";
        //        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    public static void settingsJenkins() {
        // ����������� property � ���� �� ��������� ������ ��� ������
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
    }

    public static void settingAllure() {
        // ��� ����������� Allure ������
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


}
