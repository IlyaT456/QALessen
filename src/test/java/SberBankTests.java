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
    @DisplayName("Проверка работы кнопки заявки 'Ипотека на новостройки'")
    public void sberBankMortgagTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        selector.openMainPage()
                .categoryPanel("Ипотека")
                .subcategoryMortgage("Ипотека на новостройки")
                .cheakButtonApplication();
    }

    @Test
    @DisplayName("Проверка перехода на страницу 'Оплата услуг ЖКХ'")
    public void sberBankPaymentServices() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        selector.openMainPage()
                .categoryPanel("Платежи")
                .paymentServicesCategory()
                .searchTab("ЖКХ")
                .cheakText("Оплата услуг ЖКХ");
    }

    @Test
    @DisplayName("Проверка ошибок в консоле")
    public void consoleShouldNotHaveErrorsTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        selector.openMainPage()
                .consoleShouldNotHaveErrorsTest();
    }

    @Test
    @DisplayName("Проверка соответсвие главного меню")
    public void сheckComplianceMainMenu() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        selector.openMainPage()
                .сheckingComplianceMainMenu();
    }

    @Test
    @DisplayName("Проверка соответсвие под меню вклади 'Ипотеки'")
    public void сheckComplianceSubstitutions() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        selector.openMainPage()
                .categoryPanel("Ипотека")
                .сheckingComplianceSubstitutionsMortgage();
    }
}
