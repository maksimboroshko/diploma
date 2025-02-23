package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

public class LogoTest extends TestBase {

    @Test
    @Step("Тест: Проверка наличия логотипа на главной странице")
    public void checkLogo() {
        verifyLogo();
    }

    @Step("Тест: Проверяем логотип Avito")
    public void verifyLogo() {
        mainPage.avitoLogo();
    }
}
