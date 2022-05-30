package calculator;

import calculator.block.SearchBlock;
import calculator.config.TLDriverFactory;
import calculator.config.pages.CalcHomePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static calculator.config.pages.SearchYaHomePage.URL;
import static org.testng.Assert.assertEquals;

public class OperationYaCalcTest_1 extends ParallelStartBaseClass {
    public static SearchBlock searchPage;
    public static CalcHomePage calcHomePage;

    @Test
    @Description("Выполнение операции cos(Pi/2) = 0, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
    public void clickElementSearchCoinPiOperation() {
        final String valueOperation= "cp/2)";
        final String expectedResult = "0";
        final String requestCalculator = "калькулятор";

        TLDriverFactory.getTLDriver().navigate().to(URL);
        searchPage = new SearchBlock(TLDriverFactory.getTLDriver());
        searchPage.search(requestCalculator);
        calcHomePage = new CalcHomePage(TLDriverFactory.getTLDriver());
        calcHomePage.clickButtonCalcC();

        calcHomePage.fillValidValueLineCalc(valueOperation);
        calcHomePage.clickButtonCalcEquals();
        calcHomePage.clickRadioButtonCalcRad();
        String actualResult = calcHomePage.clickResult();
        calcHomePage.clickButtonCalcC();

        assertEquals(actualResult, expectedResult); //проверяем актуальное значение с ожидаемым результатом
    }

}
