package calculator;

import calculator.block.SearchBlock;
import calculator.pages.CalcHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static calculator.pages.SearchYaHomePage.URL;
import static org.testng.Assert.assertEquals;




public class OperationYaCalcTest {

   private final static WebDriver driver = new ChromeDriver();
   private final static SearchBlock searchPage = new SearchBlock(driver);
   private final static CalcHomePage calcHomePage = new CalcHomePage(driver);

    @BeforeClass
    public static void beforeTest() {
        final String requestCalculator = "калькулятор";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        searchPage.search(requestCalculator);
        calcHomePage.clickButtonCalcC();

    }

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

    @AfterClass
    public static void afterTest() {
        driver.quit();
    }
}
