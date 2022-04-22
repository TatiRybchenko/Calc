package calculator;


import calculator.block.SearchBlock;
import calculator.config.TLDriverFactory;
import calculator.pages.CalcHomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import static calculator.pages.SearchYaHomePage.URL;


public abstract class ParallelStartBaseClass {

    public static CalcHomePage calcHomePage;
    public static SearchBlock searchPage;
    protected WebDriverWait wait;


    @BeforeMethod
        public void setupMethod ()  {
        final String requestCalculator = "калькулятор";

        TLDriverFactory.setTLDriver();
        wait = new WebDriverWait(TLDriverFactory.getTLDriver(), 10);

        TLDriverFactory.getTLDriver().navigate().to(URL);
       searchPage = new SearchBlock(TLDriverFactory.getTLDriver());
       searchPage.search(requestCalculator);
       calcHomePage = new CalcHomePage(TLDriverFactory.getTLDriver());
       calcHomePage.clickButtonCalcC();
    }

    @AfterMethod
    public synchronized void tearDown()  {
        TLDriverFactory.getTLDriver().quit();
           }
}
