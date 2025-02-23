package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import pages.FooterPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class FooterTest extends TestBase {

    private final FooterPage footerPage = new FooterPage();
    private final String urlButton = "https://www.avito.ru/apps?utm_source=avito_banner&utm_medium=referral&utm_campaign=avito_banner";

    @Test
    @Step("Тест: Проверка текста баннера и ссылки")
    public void testBannerTextAndLink() {
        openPageAndCheckBanner();
        checkMoreDetailsLink();
        clickMoreDetailsLinkAndSwitchWindow();
        verifyUrl();
    }

    @Step("Открываем страницу и проверяем баннер")
    public void openPageAndCheckBanner() {
        open("https://www.avito.ru"); // Открываем страницу Авито
        footerPage.checkBannerText();
        Allure.step("Проверка баннера прошла успешно");
    }

    @Step("Проверка ссылки 'Подробнее'")
    public void checkMoreDetailsLink() {
        footerPage.checkMoreDetailsLink();
        Allure.step("Ссылка 'Подробнее' проверена успешно");
    }

    @Step("Кликаем по ссылке и переключаемся на новое окно")
    public void clickMoreDetailsLinkAndSwitchWindow() {
        footerPage.clickMoreDetailsLink();
        Selenide.switchTo().window(1);
        Allure.step("Переключились на новое окно");
    }

    @Step("Проверка правильности URL")
    public void verifyUrl() {
        assert url().equals(urlButton) : "Ожидался переход на " + urlButton + ", но открылась " + url();
        Allure.step("Переход по ссылке на правильный URL был выполнен");
    }
}
