package calculator;

import calculator.block.SearchBlock;
import calculator.config.TLDriverFactory;
import calculator.config.pages.CalcHomePage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import static calculator.config.pages.SearchYaHomePage.URL;
import static org.testng.Assert.assertEquals;

public class OperationYaCalcTest extends ParallelStartBaseClass {
    public static SearchBlock searchPage;
    public static CalcHomePage calcHomePage;

    @Test
    @Description("Выполнение операции sqrt(144) = 12, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
        public void clickElementSearchSquareRootOperation() {
        final String valueOperation = "144";
        final String expectedResult = "12";
        final String requestCalculator = "калькулятор";

        TLDriverFactory.getTLDriver().navigate().to(URL);
        searchPage = new SearchBlock(TLDriverFactory.getTLDriver());
        searchPage.search(requestCalculator);
        calcHomePage = new CalcHomePage(TLDriverFactory.getTLDriver());
        calcHomePage.clickButtonCalcC();

        calcHomePage.fillValidValueLineCalc(valueOperation);
        calcHomePage.clickSquareRoot();
        calcHomePage.clickButtonCalcEquals();
        String actualResult = calcHomePage.clickResult();
        calcHomePage.clickButtonCalcC();

        assertEquals(actualResult, expectedResult); //проверяем актуальное значение с ожидаемым результатом
        }


}
