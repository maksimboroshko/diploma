package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

public class HelpPageTest extends TestBase {

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
}
