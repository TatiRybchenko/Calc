package calculator.block;

import calculator.SearchYaHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class SearchPage {
    public SearchYaHomePage.SearchArrowYa searchArrowYa;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public void search(String request) {
        searchArrowYa.search(request);
    }


    }

