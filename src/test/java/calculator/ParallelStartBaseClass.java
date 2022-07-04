package calculator;


import calculator.config.TLDriverFactory;
import calculator.pages.CalcHomePage;
import calculator.pages.SearchYaHomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static calculator.block.SearchBlock.URL;

public abstract class ParallelStartBaseClass {
    protected WebDriverWait wait;
    public static SearchYaHomePage searchPage;
    final String requestCalculator = "калькулятор";

    @BeforeMethod
        public void setupMethod ()  {

        TLDriverFactory.setTLDriver();
        wait = new WebDriverWait(TLDriverFactory.getTLDriver(), 10);
        TLDriverFactory.getTLDriver().navigate().to(URL);
        searchPage = new SearchYaHomePage(TLDriverFactory.getTLDriver());
        searchPage.search(requestCalculator);

    }

    @AfterMethod (alwaysRun = true)
    public synchronized void tearDown()  {
        TLDriverFactory.getTLDriver().quit();
           }
}
