package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ResultPage;

@Epic("Поиск товаров")
@Feature("Функциональность поиска")
public class SearchFunctionalityTest extends TestBase {

    ResultPage resultPage = new ResultPage();

    @Test
    @Story("Открытие карточки товара")
    @DisplayName("Должна открыться карточка товара с корректными названием и ценой")
    @Owner("Maksim Boroshko")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Тест: Открытие карточки и проверка, что открылся нужный товар")
    void openRequestPage() {
        mainPage.reloadAndEnterTextAndClick()
                .checkSearchResults();
        resultPage.openFirstItemAndCheckTitle();
    }

    @Test
    @Story("Поиск товара")
    @DisplayName("Проверка работы поиска товаров")
    @Owner("Maksim Boroshko")
    @Severity(SeverityLevel.NORMAL)
    @Step("Тест: Проверка работы поиска товаров")
    public void testSearchFunctionality() {
        performSearch();
    }

    @Step("Тест: Выполняем поиск товара")
    public void performSearch() {
        mainPage.reloadAndEnterTextAndClick()
                .checkSearchResults();
    }
}
