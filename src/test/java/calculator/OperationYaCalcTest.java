package calculator;

import calculator.config.TLDriverFactory;
import calculator.pages.CalcHomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class OperationYaCalcTest extends ParallelStartBaseClass {
    public static CalcHomePage calcHomePage;

    @Test
    @Description("Выполнение операции sqrt(144) = 12, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
        public void clickElementSearchSquareRootOperation() {
        final String valueOperation = "144";
        final String expectedResult = "12";

        calcHomePage = new CalcHomePage(TLDriverFactory.getTLDriver());
        calcHomePage.clickEscapeButton();

        calcHomePage.fillValidValueLineCalc(valueOperation);
        calcHomePage.clickSquareRoot();
        calcHomePage.clickButtonCalcEquals();
        String actualResult = calcHomePage.clickResult();
        calcHomePage.clickEscapeButton();

        assertEquals(actualResult, expectedResult); //проверяем актуальное значение с ожидаемым результатом
        }


}
