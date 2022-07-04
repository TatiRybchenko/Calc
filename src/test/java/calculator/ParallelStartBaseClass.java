package calculator;


import calculator.config.TLDriverFactory;
import calculator.pages.AbstractPage;
import calculator.pages.CalcHomePage;
import calculator.pages.SearchYaHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static calculator.block.SearchBlock.URL;
import static calculator.config.TLDriverFactory.getTLDriver;

public abstract class ParallelStartBaseClass {
    protected WebDriverWait wait;
    public static SearchYaHomePage searchPage;
    public static CalcHomePage calcHomePage;
    final String requestCalculator = "калькулятор";


    @BeforeMethod
        public void setupMethod ()  {

        TLDriverFactory.setTLDriver();
        wait = new WebDriverWait(TLDriverFactory.getTLDriver(), 10);
        TLDriverFactory.getTLDriver().navigate().to(URL);
        searchPage = new SearchYaHomePage();
        searchPage.search(requestCalculator);


    }

    @AfterMethod (alwaysRun = true)
    public synchronized void tearDown()  {
        getTLDriver().quit();
           }
}
