package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Раздел помощи")
@Feature("Функциональность раздела 'Помощь'")
public class HelpPageTest extends TestBase {

    @Test
    @Story("Проверка раздела 'Помощь'")
    @DisplayName("Должен открыться раздел 'Помощь' с корректными элементами")
    @Owner("Maksim Boroshko")
    @Severity(SeverityLevel.NORMAL)
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
