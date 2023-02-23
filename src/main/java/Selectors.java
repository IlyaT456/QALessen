import com.codeborne.selenide.Selenide;
import config.BaseTest;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.BasePage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Selectors {

    BasePage page = new BasePage();

    @Step("�������� ������� ��������")
    public Selectors openMainPage() {
        open("https://www.sberbank.com/ru/certificates");
        return this;
    }

    @Step("� ������� ���� �������� ������ �������")
    public Selectors categoryPanel(String text) {
        page.mainMenu(text).shouldBe(exist, Duration.ofSeconds(30)).click();
        return this;
    }

    @Step("����� ������������ �������")
    public Selectors subcategoryMortgage(String text) {
        page.subcategoryMortgage(text).hover().click();
        Set<String> handles = getWebDriver().getWindowHandles();
        Selenide.switchTo().window(handles.size() - 1);
        return this;
    }

    @Step("����� ������������ ������ �����")
    public Selectors paymentServicesCategory() {
        page.paymentServicesCategory().findBy(text("������ �����")).click();
        Set<String> handles = getWebDriver().getWindowHandles();
        Selenide.switchTo().window(handles.size() - 1);
        return this;
    }

    @Step("��������� ������� ������ Text ������� �� �����������")
    public Selectors cheakText(String text) {
        page.mainPage().shouldBe(text(text));
        return this;
    }

    @Step("���� ������� ���")
    public Selectors searchTab(String text) {
        page.searchTab(text).findBy(text(text)).click();
        return this;
    }

    @Step("�������� ������ ������ ������ ������")
    public Selectors cheakButtonApplication() {
        page.applicationButton().shouldBe(visible).click();
        Set<String> handles = getWebDriver().getWindowHandles();
        Selenide.switchTo().window(handles.size() - 1);
        return this;
    }

    @Step("������� ������� �� ������ ��������� ����� 'SEVERE'")
    public Selectors consoleShouldNotHaveErrorsTest() {
        List<String> consoleLogs = Selenide.getWebDriverLogs(BROWSER);
        String errorText = "SEVERE";
        Assertions.assertFalse(consoleLogs.contains(errorText));
        return this;
    }

    @Step("�������� ����������� �������� ����")
    public Selectors �heckingComplianceMainMenu() {
        List<String> elements = Arrays.asList("SberPay", "���������+", "�������", "�������", "�����", "�������", "����������", "�������", "��������", "�����������", "���������");
        for (String element : elements) {
            page.elementsMenu(element).shouldBe(exist);
        }
        return this;
    }

    @Step("�������� ����������� ��� ���� ������� '�������'")
    public Selectors �heckingComplianceSubstitutionsMortgage() {
        List<String> elements = Arrays.asList("��� ��������� �������", "������� �� ��������� �����", "������� �� �����������", "������� �� ���� ����������", "������� � �������������");
        for (String element : elements) {
            page.subcategoryMortgage(element).shouldBe(exist);
        }
        return this;
    }

}
