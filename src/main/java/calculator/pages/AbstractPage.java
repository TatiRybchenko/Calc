package calculator.pages;

import calculator.config.TLDriverFactory;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


public abstract class AbstractPage {
    protected AbstractPage() {
        HtmlElementLoader.populatePageObject(this, TLDriverFactory.getTLDriver());
    }
}




