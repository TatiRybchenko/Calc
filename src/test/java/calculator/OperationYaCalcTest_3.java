package calculator;

import calculator.block.SearchBlock;
import calculator.config.TLDriverFactory;
import calculator.config.pages.CalcHomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static calculator.config.pages.SearchYaHomePage.URL;
import static org.testng.Assert.assertEquals;

public class OperationYaCalcTest_3 extends ParallelStartBaseClass {
    public static SearchBlock searchPage;
    public static CalcHomePage calcHomePage;

    @Test
    @Description("Выполнение операции 58(% = Ошибка. Некорректные значения для создания вводятся через клавиатуру")
    public void clickElementErrorOperation() {
        final String valueOperation = "58(%";
        final String expectedResult = "Ошибка";
        final String requestCalculator = "калькулятор";

        TLDriverFactory.getTLDriver().navigate().to(URL);
        searchPage = new SearchBlock(TLDriverFactory.getTLDriver());
        searchPage.search(requestCalculator);
        calcHomePage = new CalcHomePage(TLDriverFactory.getTLDriver());
        calcHomePage.clickButtonCalcC();

        calcHomePage.fillValidValueLineCalc(valueOperation);
        String actualResult = calcHomePage.errorMessage();
        calcHomePage.clickButtonCalcC();

        assertEquals(actualResult, expectedResult); //проверяем актуальное значение с ожидаемым результатом
    }
}
