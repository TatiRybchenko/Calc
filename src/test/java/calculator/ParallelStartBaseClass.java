package calculator;

import calculator.config.TLDriverFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public abstract class ParallelStartBaseClass {
    protected WebDriverWait wait;

    @BeforeMethod
        public void setupMethod ()  {

        TLDriverFactory.setTLDriver();
        wait = new WebDriverWait(TLDriverFactory.getTLDriver(), 10);
    }

    @AfterMethod (alwaysRun = true)
    public synchronized void tearDown()  {
        TLDriverFactory.getTLDriver().quit();
           }
}
