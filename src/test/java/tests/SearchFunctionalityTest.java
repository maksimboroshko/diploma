package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import pages.ResultPage;

public class SearchFunctionalityTest extends TestBase  {

    ResultPage resultPage = new ResultPage();

    @Test
    @Step("Тест: Открытие карточки и проверка, что открылся нужный товар")
    void openRequestPage() {
        mainPage
                .reloadAndEnterTextAndClick()
                .checkSearchResults();
        resultPage.openFirstItemAndCheckTitle();
    }

    @Test
    @Step("Тест: Проверка работы поиска товаров")
    public void testSearchFunctionality() {
        performSearch();
    }

    @Step("Тест: Выполняем поиск товара")
    public void performSearch() {
        mainPage.reloadAndEnterTextAndClick().checkSearchResults();
    }

}
