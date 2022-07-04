package calculator.block;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name(value = "СТРАНИЦА ЯНДЕКСА")
public class SearchBlock  {
   public static final String URL = "https://yandex.ru/";

    //локатор поисковой строки
    @Name("ПОИСКОВАЯ ФОРМА ЯНДЕКСА")
    @FindBy(className = "search2__input")
    public static class SearchArrowYa extends HtmlElement {

        //локатор поля для ввода значений запроса на поиск
        @Name("ПОЛЕ ВВОДА ЗНАЧЕНИЙ")
        @FindBy(xpath = "//input[@id='text']")
        private TextInput requestInput;

        //локатор кнопки "Найти"
        @Name("НАЙТИ")
        @FindBy(xpath = "//button[@type='submit']")
        private Button searchButton;

        @Step("В строке поиска «Яндекса», вводим значение: {request}.")
        public void search(String request) {
            Allure.step("Нажимаем на " +  this.getName());
            Allure.step("Нажимаем на " +  requestInput.getName());
            requestInput.sendKeys(request);
            Allure.step("Нажимаем на " + searchButton.getName());
            searchButton.click();
        }
    }

}
