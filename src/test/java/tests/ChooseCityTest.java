package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

@Epic("Выбор города")
@Feature("Функциональность смены города")
public class ChooseCityTest extends TestBase {

    @Test
    @Story("Выбор города Тбилиси")
    @DisplayName("Должен корректно сменить город на Тбилиси")
    @Owner("Maksim Boroshko")
    @Severity(SeverityLevel.NORMAL)
    @Step("Тест: Поиск страны Тбилиси")
    public void testCheckCountryBanner() {
        selectCountryTbilisi();
    }

    @Step("Тест: Выбираем страну Тбилиси")
    public void selectCountryTbilisi() {
        mainPage.bannerCountry()
                .changeButton()
                .regionSearchInput()
                .tbilisiButton()
                .okayButton()
                .showMoreButtonForTbilisi();
    }
}
