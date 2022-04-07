package calculator;

import calculator.block.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static calculator.SearchYaHomePage.URL;
import static org.testng.Assert.assertEquals;

public class OperationYaCalcTest {

   private final static WebDriver driver = new ChromeDriver();
   private final static SearchPage searchPage = new SearchPage(driver);
   private final static CalcHomePage calcHomePage = new CalcHomePage(driver);

    @BeforeTest
    public static void beforeTest() {
        final String requestCalculator = "калькулятор";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        searchPage.search(requestCalculator);
        calcHomePage.clickButtonCalcC();

    }


    @Description("Выполнение операции sqrt(144) = 12, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
    @Test (priority = 1)
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


    @Description("Выполнение операции cos(Pi/2) = 0, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
    @Test (priority = 2)
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


    @Description("Выполнение операции 1,5 * 100 = 150, с корректными значениями. Корректные значения для создания вводятся через клавиатуру")
    @Test (priority = 3)
    public void clickElementSearchMultiplicationOperation() {
        final String valueOperation = "1,5*100";
        final String expectedResult = "150";

        calcHomePage.fillValidValueLineCalc(valueOperation);
        calcHomePage.clickButtonCalcEquals();
        String actualResult = calcHomePage.clickResult();
        calcHomePage.clickButtonCalcC();

        assertEquals(actualResult, expectedResult); //проверяем актуальное значение с ожидаемым результатом
}
    @AfterTest
    public static void afterTest() {
        driver.quit();
    }

}