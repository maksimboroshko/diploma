package tests;

import org.junit.jupiter.api.DisplayName;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;

@Epic("Футер страницы")
@Feature("Проверка баннера и ссылки хедера")
public class FooterTest extends TestBase {
    private final String urlButton = "https://www.avito.ru/apps?utm_source=avito_banner&utm_medium=referral&utm_campaign=avito_banner";

    @Test
    @Story("Проверка баннера и ссылки хедера")
    @DisplayName("Должна корректно отображаться и работать ссылка на баннере хедера")
    @Owner("Maksim Boroshko")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Тест: Проверка текста баннера и ссылки")
    public void testBannerTextAndLink() {
        openPageAndCheckBanner();
        checkMoreDetailsLink();
        clickMoreDetailsLinkAndSwitchWindow();
        verifyUrl();
    }

    @Step("Открываем страницу и проверяем баннер")
    public void openPageAndCheckBanner() {
        mainPage.checkBannerText();
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
        assert url().equals(urlButton) : "Ожидался переход на " + urlButton + ", но открылась " + url();
        Allure.step("Переход по ссылке на правильный URL был выполнен");
    }
}
