package calculator.pages;

import calculator.block.SearchBlock;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


@Name(value = "СТРАНИЦА ОНЛАЙН КАЛЬКУЛЯТОРА")
public class CalcHomePage {

    //перегружаем селектор самого блока для поисковой формы яндекса
    @Name("ПОИСКОВАЯ ФОРМА ЯНДЕКСА")
    @FindBy(className = "serp-header__search2")
    private SearchBlock.SearchArrowYa searchArrow;

    public CalcHomePage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void search(String request) {
        searchArrow.search(request);
    }

    //локатор поля для ввода значений запроса на поиск
    @Name("ПОЛЕ ВВОДА ЗАПРОСА НА ПОИСК")
    @FindBy(xpath = "//input[@id='text']")
    private TextInput requestInput;

    //локатор линии вввода значений калькулятора
    @Name("ПОЛЕ ВВОДА ЗНАЧЕНИЙ КАЛЬКУЛЯТОРА")
    @FindBy(xpath = "//input[@placeholder='0']")
    private TextInput lineInputCalc;

    //локатор кнопки корень квадратный
    @Name("КОРЕНЬ КВАДРАТНЫЙ")
    @FindBy(xpath = "//button[contains(@data-bem,'{\"button2\":{},\"calculator__btn\":{\"action\":\"cmd\",\"arg\":\"√\"}}')]")
    private Button squareRoot;

    //локатор кнопки = у калькулятора
    @Name("РАВНО")
    @FindBy(xpath = "//button[contains(@data-bem,'{\"button2\":{},\"calculator__btn\":{\"action\":\"equal\",\"arg\":null}}')]")
    private Button buttonCalcEquals;

    //локатор радиокнопки Rad у калькулятора
    @Name("RAD")
    @FindBy(xpath = "//*[@class='radio-button__radio radio-button__radio_side_right']")
    private Button radioButtonCalcRad;

    //локатор сообщения об ошибке у калькулятора
    @Name("СООБЩЕНИЕ ОШИБКА")
    @FindBy(xpath = "//*[@class='calculator-display__error']")
    private WebElement errorMessage;

  @Step("Нажимаем на строку ввода  в калькуляторе")
    //метод клика по окну калькулятора и по строке ввода
    public void clickLineCalc() {
      Allure.step("Нажимаем на " + lineInputCalc.getName());
        lineInputCalc.click();
    }

    @Step("Вводим значения с клавиатуры: {valueOperation}, для вычисления выражения на калькуляторе и нажимаем")
    //метод ввода данных
    public void fillValidValueLineCalc(String valueOperation) {
        Allure.step("Нажимаем на " +   lineInputCalc.getName());
        lineInputCalc.sendKeys(valueOperation);
    }

    @Step("Нажимаем на кнопку в калькуляторе (квадратный корень): sqrt")
    //метод клика по кнопке корень квадратный
    public void clickSquareRoot() {
        Allure.step("Нажимаем на " +   squareRoot.getName());
        squareRoot.click();
    }

    @Step("Нажимаем на кнопку в калькуляторе (равно): =")
    //метод клика по кнопке =
    public void clickButtonCalcEquals() {
        Allure.step("Нажимаем на " +   buttonCalcEquals.getName());
        buttonCalcEquals.click();
    }

    @Step("Нажимаем на кнопку ESCAPE, СБРОС")
    public void clickEscapeButton() {
        Allure.step("Нажимаем на кнопку ESCAPE");
        lineInputCalc.sendKeys(Keys.ESCAPE);
    }

    @Step("Нажимаем на радиокнопку в калькуляторе (радианы): Rad")
    //метод клика по кнопке Rad =
    public void clickRadioButtonCalcRad() {
        Allure.step("Нажимаем на " +    radioButtonCalcRad.getName());
        radioButtonCalcRad.click();
    }

    @Step("Извлекаем полученное значение, в результате выполнения операции")
    //метод извлечения результата выполнения операций, возвращает полученное значение
    public String clickResult() {
        Allure.step("Нажимаем на " +    lineInputCalc.getName());
        lineInputCalc.click();
        return lineInputCalc.getText();
    }
    @Step("Проверяем наличие сообщения на экране, в результате выполнения некорректной операции")
    //метод извлечения результата выполнения операций, возвращает полученное значение
    public String errorMessage() {
       errorMessage.click();
        return errorMessage.getText();
    }

}
