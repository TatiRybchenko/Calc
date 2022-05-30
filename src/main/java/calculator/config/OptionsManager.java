package calculator.config;
import org.openqa.selenium.chrome.ChromeOptions;


public class OptionsManager {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        return options;
          }
}
