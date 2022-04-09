package calculator.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class CalcHomePage {

    //перегружаем селектор самого блока для поисковой формы яндекса
    @FindBy(className = "serp-header__search2")
    private SearchYaHomePage.SearchArrowYa searchArrow;

    public CalcHomePage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void search(String request) {
        searchArrow.search(request);
    }

    //локатор поля для ввода значений запроса на поиск
    @FindBy(xpath = "//input[@id='text']")
    private TextInput requestInput;

    //локатор линии вввода значений калькулятора
    @FindBy(xpath = "//input[@placeholder='0']")
    private TextInput lineInputCalc;

    //локатор кнопки С у  калькулятора
    @FindBy(xpath = "//button[contains(@data-bem,'{\"button2\":{},\"calculator__btn\":{\"action\":\"ce\",\"arg\":null}}')]")
    private Button buttonCalcC;

    //локатор кнопки корень квадратный
    @FindBy(xpath = "//button[contains(@data-bem,'{\"button2\":{},\"calculator__btn\":{\"action\":\"cmd\",\"arg\":\"√\"}}')]")
    private Button squareRoot;

    //локатор кнопки = у  калькулятора
    @FindBy(xpath = "//button[contains(@data-bem,'{\"button2\":{},\"calculator__btn\":{\"action\":\"equal\",\"arg\":null}}')]")
    private Button buttonCalcEquals;

    //локатор радиокнопки Rad у калькулятора
    @FindBy(xpath = "//*[@class='radio-button__radio radio-button__radio_side_right']")
    private Button radioButtonCalcRad;

    @Step("Нажимаем на строку ввода в калькуляторе")
    //метод клика по окну калькулятора и по строке ввода
    public void clickLineCalc() {
        lineInputCalc.click();
    }

    @Step("Вводим значения с клавиатуры: {valueOperation}, для вычисления выражения на калькуляторе")
    //метод ввода данных
    public void fillValidValueLineCalc(String valueOperation) {
        lineInputCalc.sendKeys(valueOperation);
    }

    @Step("Нажимаем на кнопку в калькуляторе (квадратный корень): sqrt")
    //метод клика по кнопке корень квадратный
    public void clickSquareRoot() {
        squareRoot.click();
    }

    @Step("Нажимаем на кнопку в калькуляторе (сброс) введенных значений: С")
    //метод клика по кнопке C
    public void clickButtonCalcC() {
        buttonCalcC.click();
    }

    @Step("Нажимаем на кнопку в калькуляторе (равно): =")
    //метод клика по кнопке =
    public void clickButtonCalcEquals() {
        buttonCalcEquals.click();
    }

    @Step("Нажимаем на радиокнопку в калькуляторе (радианы): Rad")
    //метод клика по кнопке Rad =
    public void clickRadioButtonCalcRad() {
        radioButtonCalcRad.click();
    }

    @Step("Извлекаем полученное значение, в результате выполнения операции и сравниваем с ожидаемым результатом")
    //метод извлечения результата выполнения операций, возвращает полученное значение
    public String clickResult() {
        lineInputCalc.click();
        return lineInputCalc.getText();
    }


}
