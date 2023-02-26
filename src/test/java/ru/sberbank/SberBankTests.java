package ru.sberbank;

import config.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.Selectors;

public class SberBankTests extends BaseTest {
    Selectors selector = new Selectors();

    @Test
    @DisplayName("�������� ������ ������ ������ '������� �� �����������'")
    public void sberBankMortgagTest() {
        selector.openMainPage()
                .categoryPanel("�������")
                .subcategoryMortgage("������� �� �����������")
                .cheakButtonApplication();
    }

    @Test
    @DisplayName("�������� �������� �� �������� '������ ����� ���'")
    public void sberBankPaymentServices() {
        selector.openMainPage()
                .categoryPanel("�������")
                .paymentServicesCategory()
                .searchTab("���")
                .cheakText("������ ����� ���");
    }

    @Test
    @DisplayName("�������� ������ � �������")
    public void consoleShouldNotHaveErrorsTest() {
        selector.openMainPage()
                .consoleShouldNotHaveErrorsTest();
    }

    @Test
    @DisplayName("�������� ����������� �������� ����")
    public void �heckComplianceMainMenu() {
        selector.openMainPage()
                .�heckingComplianceMainMenu();
    }

    @Test
    @DisplayName("�������� ����������� ��� ���� ������ '�������'")
    public void �heckComplianceSubstitutions() {
        selector.openMainPage()
                .categoryPanel("�������")
                .�heckingComplianceSubstitutionsMortgage();
    }
}
