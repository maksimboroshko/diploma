package pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.qameta.allure.Allure;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ResultPage {

    // Первая карточка в списке результатов
    private final SelenideElement firstCard = $$("[data-marker='item']").first();
    // Название и цена внутри первой карточки
    private final SelenideElement firstCardTitle = firstCard.$("[data-marker='item-title']");
    private final SelenideElement firstCardPrice = firstCard.$("[data-marker='item-price']");

    @Step("Открываем первую карточку из списка и проверяем название/цену")
    public ResultPage openFirstItemAndCheckTitle() {
        Allure.step("Убедиться, что первая карточка видима и взять название и цену");
        firstCard.shouldBe(visible, Duration.ofSeconds(10)).scrollTo();

        // Считываем данные до клика
        String title = firstCardTitle.shouldBe(visible).text();
        String price = firstCardPrice.shouldBe(visible).text();

        Allure.step("Кликаем по карточке, чтобы открыть детальную страницу");
        actions().moveToElement(firstCard).click().perform();


        Selenide.switchTo().window(1);

        Allure.step("Убедиться, что на странице товара появились элементы заголовка и цены");
        SelenideElement detailTitle = $("[data-marker='item-title']")
                .should(appear, Duration.ofSeconds(10));
        SelenideElement detailPrice = $("[data-marker='item-price']")
                .should(appear, Duration.ofSeconds(10));

        Allure.step("Проверяем, что заголовок и цена совпадают");
        detailTitle.shouldHave(text(title));
        detailPrice.shouldHave(text(price));

        return this;
    }
}

