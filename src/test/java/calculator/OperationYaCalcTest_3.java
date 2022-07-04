package calculator;

import calculator.pages.CalcHomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class OperationYaCalcTest_3 extends ParallelStartBaseClass {
    public static CalcHomePage calcHomePage;

    @Test
    @Description("Выполнение операции 58(% = Ошибка. Некорректные значения для создания вводятся через клавиатуру")
    public void clickElementErrorOperation() {
        final String valueOperation = "58(%";
        final String expectedResult = "Ошибка";

        calcHomePage = new CalcHomePage();
        calcHomePage.clickEscapeButton();

        calcHomePage.fillValidValueLineCalc(valueOperation);
        String actualResult = calcHomePage.errorMessage();
        calcHomePage.clickEscapeButton();

        assertEquals(actualResult, expectedResult); //проверяем актуальное значение с ожидаемым результатом
    }
}
