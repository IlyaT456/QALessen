package steps;

import com.codeborne.selenide.Selenide;
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

    @Step("Открытие гравной страницы")
    public Selectors openMainPage() {
        open("https://www.sberbank.com/ru/certificates");
        return this;
    }

    @Step("В главном меню выбираем нужную вкладку")
    public Selectors categoryPanel(String text) {
        page.mainMenu(text).shouldBe(exist, Duration.ofSeconds(30)).click();
        return this;
    }

    @Step("Выбор подкатегорию ипотека")
    public Selectors subcategoryMortgage(String text) {
        page.subcategoryMortgage(text).hover().click();
        Set<String> handles = getWebDriver().getWindowHandles();
        Selenide.switchTo().window(handles.size() - 1);
        return this;
    }

    @Step("Выбор подкатегорию оплата услуг")
    public Selectors paymentServicesCategory() {
        page.paymentServicesCategory().findBy(text("Оплата услуг")).click();
        Set<String> handles = getWebDriver().getWindowHandles();
        Selenide.switchTo().window(handles.size() - 1);
        return this;
    }

    @Step("Проверяем наличие текста Text Ипотека на новостройку")
    public Selectors cheakText(String text) {
        page.mainPage().shouldBe(text(text));
        return this;
    }

    @Step("Ищем вкладку ЖКХ")
    public Selectors searchTab(String text) {
        page.searchTab(text).findBy(text(text)).click();
        return this;
    }

    @Step("Проверка работы кнопка подать заявку")
    public Selectors cheakButtonApplication() {
        page.applicationButton().shouldBe(visible).click();
        Set<String> handles = getWebDriver().getWindowHandles();
        Selenide.switchTo().window(handles.size() - 1);
        return this;
    }

    @Step("Журналы консоли не должны содержать текст 'SEVERE'")
    public Selectors consoleShouldNotHaveErrorsTest() {
        List<String> consoleLogs = Selenide.getWebDriverLogs(BROWSER);
        String errorText = "SEVERE";
        Assertions.assertFalse(consoleLogs.contains(errorText));
        return this;
    }

    @Step("Проверка соответсвие главного меню")
    public Selectors сheckingComplianceMainMenu() {
        List<String> elements = Arrays.asList("SberPay", "СберПрайм+", "Кредиты", "Ипотека", "Карты", "Премиум", "Инвестиции", "Платежи", "Переводы", "Страхование", "Поддержка");
        for (String element : elements) {
            page.elementsMenu(element).shouldBe(exist);
        }
        return this;
    }

    @Step("Проверка соответсвие под меню вкладке 'Ипотеки'")
    public Selectors сheckingComplianceSubstitutionsMortgage() {
        List<String> elements = Arrays.asList("Все ипотечные кредиты", "Ипотека на вторичное жильё", "Ипотека на новостройки", "Ипотека по двум документам", "Ипотека с господдержкой");
        for (String element : elements) {
            page.subcategoryMortgage(element).shouldBe(exist);
        }
        return this;
    }

}
