package calculator;


import calculator.pages.CalcHomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class OperationYaCalcTest_1 extends ParallelStartBaseClass {
    public static CalcHomePage calcHomePage;

    @Test
    @Description("Выполнение операции cos(Pi/2) = 0, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
    public void clickElementSearchCoinPiOperation() {
        final String valueOperation= "cp/2)";
        final String expectedResult = "0";

        calcHomePage = new CalcHomePage();
        calcHomePage.clickEscapeButton();

        calcHomePage.fillValidValueLineCalc(valueOperation);
        calcHomePage.clickButtonCalcEquals();
        calcHomePage.clickRadioButtonCalcRad();
        String actualResult = calcHomePage.clickResult();
        calcHomePage.clickEscapeButton();

        assertEquals(actualResult, expectedResult); //проверяем актуальное значение с ожидаемым результатом
    }

}
