package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement bannerBlock = $(".top-banner-module-content-Q1f85");
    private final SelenideElement bannerText = bannerBlock.$("span");
    private final SelenideElement moreDetailsLink = bannerBlock.$("a[data-marker='title']");
    private final SelenideElement inputField = $("[data-marker='search-form/suggest/input']");
    private final SelenideElement searchButton = $("[data-marker='search-form/submit-button']");
    private final SelenideElement pageTitleText = $(".page-title-text-CBgaH.page-title-inline-LU8GK");
    private final SelenideElement pageTitleCount = $(".page-title-count-yKVwK");
    private final SelenideElement cookieBanner = $("[class*='styles-module-root-_yNxQ'][role='status']");
    private final SelenideElement bannerCountry = $$("span.styles-module-size_s-nEvE8")
            .findBy(text("Мы не смогли определить ваш город"));

    private final SelenideElement changeButton = $("[data-marker='location/tooltip-change']");
    private final SelenideElement regionSearchInput = $("[data-marker='popup-location/region/search-input']");
    private final SelenideElement tbilisiButton = $("button[data-marker='popup-location/region/custom-option([object Object])'] .suggest-suggest_content-Gr5Vf");
    private final SelenideElement showMoreButtonForTbilisi = $("button[data-marker='popup-location/save-button']");
    private final SelenideElement okayButton = $("button.styles-module-root-EEwdX");
    private final SelenideElement avitoLogo = $("a[data-marker='search-form/logo']");
    private final SelenideElement helpButton = $("a[href*='support.avito.ru']");
    private final SelenideElement searchHelpInput = $x("//input[@data-marker='search-form/select/search-input']");
    // Ввод текста в поле поиска
    private final SelenideElement searchInput = $x("//input[@data-marker='search-form/select/search-input']");

    private final SelenideElement resultsMoney = $x("//div[contains(@class, 'two-columns-layout-redesign-left-mSm5x')]");
    private SelenideElement firstCard = $x("//div[@class='items-items-pZX46' and @data-marker='catalog-serp']/div[1]");

    public MainPage openFirstItemAndCheckTitle() {
        firstCard = $$("[data-marker='item']").first();
        firstCard.shouldBe(visible, Duration.ofSeconds(1000));

        String title = firstCard.$("[itemprop='name']").text();
        String price = firstCard.$("[itemprop='price']").text();

        firstCard.shouldBe(visible, Duration.ofSeconds(1000));

        $("[data-marker='item-title']").should(appear, Duration.ofSeconds(1005));

        actions().moveToElement(firstCard).doubleClick().perform();

        $("[data-marker='item-title']").shouldHave(text(title), Duration.ofSeconds(10));
        $("[data-marker='item-price']").shouldHave(text(price), Duration.ofSeconds(10));

        return this;
    }

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage resultsMoney() {
        resultsMoney.shouldHave(text("деньги за заказ"));
        return this;
    }

    public MainPage searchHelpInput() {
        searchHelpInput.should(appear, Duration.ofSeconds(10))
                .shouldBe(visible)
                .setValue("деньги за заказ").pressEnter();
        return this;
    }

    public MainPage switchToNewTab() {
        String mainWindow = WebDriverRunner.getWebDriver().getWindowHandle();
        for (String windowHandle : WebDriverRunner.getWebDriver().getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                WebDriverRunner.getWebDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }

    public MainPage helpButton() {
        helpButton.should(appear, Duration.ofSeconds(10))
                .shouldBe(visible)
                .shouldHave(text("Помощь"))
                .click();
        return this;
    }

    @Step("Проверка наличия логотипа Avito")
    public MainPage avitoLogo() {
        avitoLogo.shouldBe(visible);
        return this;
    }

    public MainPage okayButton() {
        okayButton.click();
        return this;
    }

    public MainPage showMoreButtonForTbilisi() {
        showMoreButtonForTbilisi.shouldHave(text("оказать больше 1 тыс. объявлений"))
                .shouldBe(visible)
                .scrollTo().click();
        return this;
    }

    public MainPage tbilisiButton() {
        tbilisiButton.shouldBe(visible)
                .shouldHave(text("Тбилиси"))
                .click();
        return this;
    }

    public MainPage bannerCountry() {
        bannerCountry.should(appear, Duration.ofSeconds(12))
                .shouldHave(text("Мы не смогли определить ваш город"));
        return this;
    }

    public MainPage regionSearchInput() {
        regionSearchInput.shouldBe(visible);
        regionSearchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        regionSearchInput.setValue("Тбилиси");
        return this;
    }

    public MainPage changeButton() {
        changeButton.shouldBe(visible)
                .shouldHave(text("Изменить")).click();
        return this;
    }

    public MainPage reloadAndEnterTextAndClick() {
        openPage();
        sleep(5000);
        refresh();
        sleep(5000);
        inputField.setValue("машина");
        searchButton.click();
        return this;
    }

    public MainPage checkSearchResults() {
        pageTitleText.shouldBe(visible)
                .shouldHave(exactText("Объявления по запросу «машина»"));
        pageTitleCount.shouldBe(visible);
        String resultCountText = pageTitleCount.getText().replaceAll("\\s+", "");
        int resultCount = Integer.parseInt(resultCountText);
        if (resultCount > 0) {
            System.out.println("Результатов найдено: " + resultCount);
        } else {
            throw new AssertionError("Результаты поиска не были найдены.");
        }
        return this;
    }

    public MainPage checkBannerText() {
        bannerText.shouldBe(visible)
                .shouldHave(exactText("Авито недоступен в GooglePlay. Не удаляйте приложение."));
        return this;
    }

    public MainPage checkMoreDetailsLink() {
        moreDetailsLink.shouldBe(visible)
                .shouldHave(text("Подробнее"))
                .shouldHave(attributeMatching("href",
                        "https://(www\\.)?avito.ru/apps\\?utm_source=avito_banner&utm_medium=referral&utm_campaign=avito_banner.*"));
        return this;
    }

    public MainPage clickMoreDetailsLink() {
        moreDetailsLink.click();
        return this;
    }
}

