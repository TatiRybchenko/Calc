package calculator;

import calculator.block.SearchBlock;
import calculator.config.TLDriverFactory;
import calculator.config.pages.CalcHomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static calculator.config.pages.SearchYaHomePage.URL;
import static org.testng.Assert.assertEquals;

public class OperationYaCalcTest_2 extends ParallelStartBaseClass {
    public static SearchBlock searchPage;
    public static CalcHomePage calcHomePage;

    @Test
    @Description("Выполнение операции 1,5 * 100 = 150, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
    public void clickElementSearchMultiplicationOperation() {
        final String valueOperation = "1,5*100";
        final String expectedResult = "150";
        final String requestCalculator = "калькулятор";

        TLDriverFactory.getTLDriver().navigate().to(URL);
        searchPage = new SearchBlock(TLDriverFactory.getTLDriver());
        searchPage.search(requestCalculator);
        calcHomePage = new CalcHomePage(TLDriverFactory.getTLDriver());
        calcHomePage.clickButtonCalcC();

        calcHomePage.fillValidValueLineCalc(valueOperation);
        calcHomePage.clickButtonCalcEquals();
        String actualResult = calcHomePage.clickResult();
        calcHomePage.clickButtonCalcC();

        assertEquals(actualResult, expectedResult); //проверяем актуальное значение с ожидаемым результатом
    }


}
