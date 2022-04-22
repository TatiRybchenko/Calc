package calculator;

import calculator.pages.CalcHomePage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

public class OperationYaCalcTest extends ParallelStartBaseClass {

    @Test
    @Description("Выполнение операции sqrt(144) = 12, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
        public void clickElementSearchSquareRootOperation() {
        final String valueOperation = "144";
        final String expectedResult = "12";

        calcHomePage.fillValidValueLineCalc(valueOperation);
        calcHomePage.clickSquareRoot();
        calcHomePage.clickButtonCalcEquals();
        String actualResult = calcHomePage.clickResult();
        calcHomePage.clickButtonCalcC();

        assertEquals(actualResult, expectedResult); //проверяем актуальное значение с ожидаемым результатом
        }

    @Test
    @Description("Выполнение операции cos(Pi/2) = 0, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
        public void clickElementSearchCoinPiOperation() {
        final String valueOperation= "cp/2)";
        final String expectedResult = "0";

        calcHomePage.fillValidValueLineCalc(valueOperation);
        calcHomePage.clickButtonCalcEquals();
        calcHomePage.clickRadioButtonCalcRad();
        String actualResult = calcHomePage.clickResult();
        calcHomePage.clickButtonCalcC();

        assertEquals(actualResult, expectedResult); //проверяем актуальное значение с ожидаемым результатом
    }

    @Test
    @Description("Выполнение операции 1,5 * 100 = 150, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
        public void clickElementSearchMultiplicationOperation() {
        final String valueOperation = "1,5*100";
        final String expectedResult = "150";

        calcHomePage.fillValidValueLineCalc(valueOperation);
        calcHomePage.clickButtonCalcEquals();
        String actualResult = calcHomePage.clickResult();
        calcHomePage.clickButtonCalcC();

        assertEquals(actualResult, expectedResult); //проверяем актуальное значение с ожидаемым результатом
    }

    @Test
    @Description("Выполнение операции 58(% = Ошибка. Некорректные значения для создания вводятся через клавиатуру")
        public void clickElementErrorOperation() {
        final String valueOperation = "58(%";
        final String expectedResult = "Ошибка";

        calcHomePage.fillValidValueLineCalc(valueOperation);
        String actualResult = calcHomePage.errorMessage();
        calcHomePage.clickButtonCalcC();

        assertEquals(actualResult, expectedResult); //проверяем актуальное значение с ожидаемым результатом
    }
}
