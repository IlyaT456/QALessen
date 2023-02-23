import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.BaseTest;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BasePage;

public class SberBankTests extends BaseTest {
    Selectors selector = new Selectors();
    @Test
    @DisplayName("�������� ������ ������ ������ '������� �� �����������'")
    public void sberBankMortgagTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        selector.openMainPage()
                .categoryPanel("�������")
                .subcategoryMortgage("������� �� �����������")
                .cheakButtonApplication();
    }

    @Test
    @DisplayName("�������� �������� �� �������� '������ ����� ���'")
    public void sberBankPaymentServices() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        selector.openMainPage()
                .categoryPanel("�������")
                .paymentServicesCategory()
                .searchTab("���")
                .cheakText("������ ����� ���");
    }

    @Test
    @DisplayName("�������� ������ � �������")
    public void consoleShouldNotHaveErrorsTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        selector.openMainPage()
                .consoleShouldNotHaveErrorsTest();
    }

    @Test
    @DisplayName("�������� ����������� �������� ����")
    public void �heckComplianceMainMenu() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        selector.openMainPage()
                .�heckingComplianceMainMenu();
    }

    @Test
    @DisplayName("�������� ����������� ��� ���� ������ '�������'")
    public void �heckComplianceSubstitutions() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        selector.openMainPage()
                .categoryPanel("�������")
                .�heckingComplianceSubstitutionsMortgage();
    }
}
