package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class ResultPage {

    private static SelenideElement firstCard = $x("//div[@class='items-items-pZX46' and @data-marker='catalog-serp']/div[1]");

    public ResultPage openFirstItemAndCheckTitle() {
        firstCard = $$("[data-marker='item']").first();
        firstCard.shouldBe(Condition.visible, Duration.ofSeconds(10));

        String title = firstCard.$("[itemprop='name']").text();
        String price = firstCard.$("[itemprop='price']").text();

        // Убедимся, что элемент появился на странице
        $("[data-marker='item-title']").should(Condition.appear, Duration.ofSeconds(5));

        // Дважды кликаем на карточку
        actions().moveToElement(firstCard).doubleClick().perform();

        // Проверяем, что на открывшейся странице правильно отображаются данные
        $("[data-marker='item-title']").shouldHave(Condition.text(title), Duration.ofSeconds(5));
        $("[data-marker='item-price']").shouldHave(Condition.text(price), Duration.ofSeconds(5));

        return this;
    }
}
