package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    public SelenideElement mainMenu(String text) {
        return $("a[aria-label='" + text + "']");
    }

    public SelenideElement elementsMenu(String text) {
        return $x("//nav[@aria-label='�������� ����']//a[. = '" + text + "']");
    }

    public SelenideElement subcategoryMortgage(String text) {
        return $("a[data-cga_click_top_menu='�������_" + text + "_type_important']");
    }

    public ElementsCollection paymentServicesCategory() {
        return $$("a[class='kitt-top-menu__link kitt-top-menu__link_second']");
    }

    public SelenideElement mainPage() {
        return $("#main-page");
    }

    public ElementsCollection searchTab(String text) {
        return $$(".uc-full__header");
    }

    public SelenideElement applicationButton() {
        return $(".analytics-button");
    }

    public SelenideElement panelMainMenu() {
        return $("nav[aria-label='�������� ����']");
    }

    public List<String> collectionPanelMainMenu() {
        List<String> mainMenu = Arrays.asList("SberPay, ���������, �������, �������, �����, �������, ����������, �������, ��������, �����������, ���������");
        return mainMenu;
    }


}
