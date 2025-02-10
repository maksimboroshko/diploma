package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;

public class AvitoTests extends TestBase {

    String urlButton = "https://www.avito.ru/apps?utm_source=avito_banner&utm_medium=referral&utm_campaign=avito_banner";

    @Test
    @Step("Тест: Проверка текста баннера и ссылки")
    public void testBannerTextAndLink() {
        openPageAndCheckBanner();
        checkMoreDetailsLink();
        clickMoreDetailsLinkAndSwitchWindow();
        verifyUrl();
    }

    @Step("Тест: Открываем страницу и проверяем баннер")
    public void openPageAndCheckBanner() {
        mainPage.checkBannerText();
        Allure.step("Проверка баннера прошла успешно");
    }

    @Step("Тест: Проверка ссылки 'Подробнее'")
    public void checkMoreDetailsLink() {
        mainPage.checkMoreDetailsLink();
        Allure.step("Ссылка 'Подробнее' проверена успешно");
    }

    @Step("Тест: Кликаем по ссылке и переключаемся на новое окно")
    public void clickMoreDetailsLinkAndSwitchWindow() {
        mainPage.clickMoreDetailsLink();
        Selenide.switchTo().window(1);
        Allure.step("Переключились на новое окно");
    }

    @Step("Тест: Проверка правильности URL")
    public void verifyUrl() {
        String expectedUrl = urlButton;
        assert url().equals(expectedUrl) : "Ожидался переход на " + expectedUrl + ", но открылась " + url();
        Allure.step("Переход по ссылке на правильный URL был выполнен");
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

    @Test
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

    @Test
    @Step("Тест: Проверка наличия логотипа на главной странице")
    public void checkLogo() {
        verifyLogo();
    }

    @Step("Тест: Проверяем логотип Avito")
    public void verifyLogo() {
        mainPage.avitoLogo();
    }

    @Test
    @Step("Тест: Проверка раздела 'Помощь'")
    public void checkHelpPage() {
        openAndVerifyHelpPage();
    }

    @Step("Тест: Открываем раздел 'Помощь' и проверяем")
    public void openAndVerifyHelpPage() {
        mainPage.helpButton()
                .switchToNewTab()
                .searchHelpInput()
                .resultsMoney();
    }

    @Test
    @Step("Тест: Поиск товара")
    public void searchPage() {
        mainPage
                .reloadAndEnterTextAndClick()
                .checkSearchResults();

    }

    @Step("Тест: Открытие карточки и проверка , что открылась нужный товар")
    public void openRequestPage() {
        mainPage
                .openFirstItemAndCheckTitle();

    }
}


