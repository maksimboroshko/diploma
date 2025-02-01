package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;

public class AvitoTests extends TestBase {

    String urlButton = "https://www.avito.ru/apps?utm_source=avito_banner&utm_medium=referral&utm_campaign=avito_banner";

    @Test
    public void testBannerTextAndLink() {
        openPageAndCheckBanner();
        checkMoreDetailsLink();
        clickMoreDetailsLinkAndSwitchWindow();

        // Переключаемся на новое окно и проверяем URL
        verifyUrl();
    }

    @Step("Открываем страницу и проверяем баннер")
    public void openPageAndCheckBanner() {
        mainPage
                .checkBannerText();
        Allure.step("Проверка баннера прошла успешно");
    }

    @Step("Проверка ссылки 'Подробнее'")
    public void checkMoreDetailsLink() {
        mainPage.checkMoreDetailsLink();
        Allure.step("Ссылка 'Подробнее' проверена успешно");
    }

    @Step("Кликаем по ссылке и переключаемся на новое окно")
    public void clickMoreDetailsLinkAndSwitchWindow() {
        mainPage.clickMoreDetailsLink();
        Selenide.switchTo().window(1);
        Allure.step("Переключились на новое окно");
    }

    @Step("Проверка правильности URL")
    public void verifyUrl() {
        String expectedUrl = urlButton;
        assert url().equals(expectedUrl) : "Ожидался переход на " + expectedUrl + ", но открылась " + url();
        Allure.step("Переход по ссылке на правильный URL был выполнен");
    }

    @Test
    @Step("Проверка работы поиска товаров")
    public void testSearchFunctionality() {
        mainPage
                .reloadAndEnterTextAndClick()
                .checkSearchResults();
    }
    @Step("поиск страны тбилиси")
    @Test
    public void testCheckCountryBanner() {
        mainPage
                .bannerCountry()
                .changeButton()
                .regionSearchInput()
                .tbilisiButton()
                .okayButton()
                .showMoreButtonForTbilisi();
    }
    @Step("проверка наличие логотипа на главной странице сайта")
    @Test
    public void CheckLogo() {
        mainPage
                .avitoLogo();
    }
    @Step("проверка раздела помощь")
    @Test
    public void CheckHelpPage() {
        mainPage
                .helpButton() // gg
                .switchToNewTab()
                .helpWord();
    }
}

