package calculator;

import calculator.config.TLDriverFactory;
import calculator.pages.CalcHomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class OperationYaCalcTest_2 extends ParallelStartBaseClass {
    public static CalcHomePage calcHomePage;

    @Test
    @Description("Выполнение операции 1,5 * 100 = 150, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
    public void clickElementSearchMultiplicationOperation() {
        final String valueOperation = "1,5*100";
        final String expectedResult = "150";

        calcHomePage = new CalcHomePage(TLDriverFactory.getTLDriver());
        calcHomePage.clickEscapeButton();

        calcHomePage.fillValidValueLineCalc(valueOperation);
        calcHomePage.clickButtonCalcEquals();
        String actualResult = calcHomePage.clickResult();
        calcHomePage.clickEscapeButton();

        assertEquals(actualResult, expectedResult); //проверяем актуальное значение с ожидаемым результатом
    }


}
