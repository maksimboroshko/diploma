package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {

    // Локаторы
    private static final SelenideElement bannerBlock = $(".top-banner-module-content-Q1f85");
    private static final SelenideElement bannerText = bannerBlock.$("span");
    private static final SelenideElement moreDetailsLink = bannerBlock.$("a[data-marker='title']");
    private static final SelenideElement inputField = $("[data-marker='search-form/suggest/input']");
    private static final SelenideElement searchButton = $("[data-marker='search-form/submit-button']");
    private static final SelenideElement pageTitleText = $(".page-title-text-CBgaH.page-title-inline-LU8GK");
    private static final SelenideElement pageTitleCount = $(".page-title-count-yKVwK");
    private static final SelenideElement cookieBanner = $("[class*='styles-module-root-_yNxQ'][role='status']");


    // Открытие страницы
    public MainPage openPage() {
        open("/");
        return this;
    }

    public void checkBannerTextCookies() {
        // Используем селектор для нахождения баннера, который содержит нужный текст
        SelenideElement bannerText = $x("//div[contains(@class, 'styles-module-root-_yNxQ')]//span[contains(text(), 'Пользуясь сайтом, вы принимаете')]");

        // Ожидаем, что элемент будет видим на странице
        bannerText.shouldBe(Condition.visible);

        // Проверяем, что текст баннера содержит ожидаемую строку
        String actualText = bannerText.getText().trim();
        String expectedText = "Пользуясь сайтом, вы принимаете политику куки. Так Авито становится удобнее 🍪";

        // Сравниваем фактический текст с ожидаемым
        assert actualText.equals(expectedText) : "Ожидаемый текст не найден. Найден: " + actualText;

        // Проверяем правильность ссылки на политику куки
        SelenideElement cookiePolicyLink = $x("//a[contains(@href, '/legal/rules/cookies')]");
        cookiePolicyLink.shouldHave(Condition.attribute("href", "/legal/rules/cookies"));
    }





    // Метод для перезагрузки страницы, ввода текста и клика по кнопке
    public MainPage reloadAndEnterTextAndClick() {
        // Открываем страницу
        openPage();

        // Перезагружаем страницу через 5 секунд
        Selenide.sleep(5000);
        Selenide.refresh();

        // Через 5 секунд после перезагрузки вводим слово "машина"
        Selenide.sleep(5000);
        inputField.setValue("машина");

        // Нажимаем кнопку "Найти"
        searchButton.click();

        return this;  // Возвращаем объект MainPage, чтобы цепочка методов продолжалась
    }

    // Проверка результатов поиска
    public MainPage checkSearchResults() {
        // Проверяем, что текст в заголовке содержит фразу "Объявления по запросу «машина»"
        pageTitleText.shouldBe(Condition.visible)
                .shouldHave(Condition.exactText("Объявления по запросу «машина»"));

        // Проверяем, что количество результатов больше нуля
        pageTitleCount.shouldBe(Condition.visible);
        String resultCountText = pageTitleCount.getText().replaceAll("\\s+", "");
        int resultCount = Integer.parseInt(resultCountText);

        if (resultCount > 0) {
            System.out.println("Результатов найдено: " + resultCount);
        } else {
            throw new AssertionError("Результаты поиска не были найдены.");
        }
        return this;
    }

    // Проверка текста на баннере
    public MainPage checkBannerText() {
        bannerText.shouldBe(Condition.visible)
                .shouldHave(Condition.exactText("Авито недоступен в GooglePlay. Не удаляйте приложение."));
        return this;
    }

    // Проверка ссылки "Подробнее"
    public MainPage checkMoreDetailsLink() {
        moreDetailsLink.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Подробнее"))
                .shouldHave(Condition.attributeMatching("href",
                        "https://(www\\.)?avito.ru/apps\\?utm_source=avito_banner&utm_medium=referral&utm_campaign=avito_banner.*"));
        return this;
    }

    // Клик по ссылке
    public MainPage clickMoreDetailsLink() {
        moreDetailsLink.click();
        return this;
    }
}
