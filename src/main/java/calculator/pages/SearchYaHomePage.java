package calculator.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class SearchYaHomePage {

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

        @Step("В строке поиска «Яндекса», вводим значение: {request}. Нажимаем на кнопку {@Name.searchButton{.")
        //метод ввода значений для выполнения запроса на поиск по кнопке "Найти"
        public void search(String request) {
            requestInput.sendKeys(request);
            searchButton.click();
        }
    }

}
