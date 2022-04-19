package calculator;

import calculator.block.SearchBlock;
import calculator.pages.CalcHomePage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static calculator.pages.SearchYaHomePage.URL;

public class ParallelStartBaseClass {
    public static WebDriver driver;
    public static  CalcHomePage calcHomePage;
    public static SearchBlock searchPage;

    @BeforeMethod
    @Description("Выполнения запроса поиска онлайн-калькулятора на странице яндекса")
    public void beforeMethod() {
        final String requestCalculator = "калькулятор";
        driver = new ChromeDriver();
        searchPage = new SearchBlock(driver);
        calcHomePage = new CalcHomePage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        searchPage.search(requestCalculator);
        calcHomePage.clickButtonCalcC();
    }
    @AfterMethod
    @Description("Закрытие браузера")
    public void afterMethod() {
         driver.quit();
    }

}
