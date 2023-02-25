package ru.praktikum_services.qa_scooter.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OrderPageStep1 {
    private WebDriver driver;
    // Поле "Имя"
    private By inputFieldName = By.xpath(".//input[@placeholder = '* Имя']");
    // Поле "Фамилия"
    private By inputFieldSurname = By.xpath(".//input[@placeholder = '* Фамилия']");
    // Поле "Адрес"
    private By inputFieldAddress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    // Список "Станция метро"
    private By inputFieldMetro = By.xpath(".//input[@placeholder = '* Станция метро']");
    private By inputFieldMetroStation = By.xpath(".//div[@class= 'select-search__select']");
    // Поле "Телефон"
    private By inputFieldPhone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private By buttonNext = By.xpath(".//button[contains(text(),'Далее')]");
    // элемент с текстом ошибки поля "Имя"
    private By inputErrorMessagesName = By.xpath(".//input[@placeholder ='* Имя']/parent::div/div[contains(@class, 'ErrorMessage') and contains(@class, 'Input_Visible')]");
    // элемент с текстом ошибки поля "Фамилия"
    private By inputErrorMessagesSurname = By.xpath(".//input[@placeholder ='* Фамилия']/parent::div/div[contains(@class, 'ErrorMessage') and contains(@class, 'Input_Visible')]");
    // элемент с текстом ошибки поля "Адрес"
    private By inputErrorMessagesAddress = By.xpath(".//input[@placeholder ='* Адрес: куда привезти заказ']/parent::div/div[contains(@class, 'ErrorMessage') and contains(@class, 'Input_Visible')]");
    // элемент с текстом ошибки поля "Номер телефона "
    private By inputErrorMessagesPhoneNumber = By.xpath(".//input[@placeholder ='* Телефон: на него позвонит курьер']/parent::div/div[contains(@class, 'ErrorMessage') and contains(@class, 'Input_Visible')]");
    private By inputErrorMessagesMetro = By.xpath(".//div[contains(@class, 'MetroError')]");
    // тело страницы
    private By body = By.xpath(".//div[contains(text(), 'Для кого самокат')]");

    public OrderPageStep1 (WebDriver driver){
        this.driver = driver;
    }

    //методы для позитивного флоу
    public void setInputFieldName(String name) {

        driver.findElement(inputFieldName).sendKeys(name);
    }
    public void setInputFieldSurname(String surname) {
        driver.findElement(inputFieldSurname).sendKeys(surname);
    }
    public void setInputFieldAddress(String address) {
        driver.findElement(inputFieldAddress).sendKeys(address);
    }
    public void clickFieldMetro (){
        driver.findElement(inputFieldMetro).click();
    }
    public void clickFieldMetroStation (){
        driver.findElement(inputFieldMetroStation).click();
    }
    public void setInputFieldPhone (String numberPhone){
        driver.findElement(inputFieldPhone).sendKeys(numberPhone);
    }
    public void clickButtonNext (){
        driver.findElement(buttonNext).click();
    }
    public  void setFormStep1 (String name, String surname, String address,String numberPhone){
        setInputFieldName (name);
        setInputFieldSurname (surname);
        setInputFieldAddress (address);
        clickFieldMetro();
        clickFieldMetroStation();
        setInputFieldPhone(numberPhone);
        clickButtonNext();
    }

    // методы для проверки полей
    public boolean isElementPresent(By by)
    {
        return driver.findElements(by).size() > 0;
    }
    public String getTextInputErrorMessagesName (){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if (isElementPresent(inputErrorMessagesName)) {
            return driver.findElement(inputErrorMessagesName).getText();
        } else {return "Имя  валидно";}
    }
    public String getTextInputErrorMessagesSurname (){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if (isElementPresent(inputErrorMessagesSurname)) {
            return driver.findElement(inputErrorMessagesSurname).getText();
        } else return "Фамилия  валидна";
    }
    public String getTextInputErrorMessagesAddress (){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if (isElementPresent(inputErrorMessagesAddress)) {
            return driver.findElement(inputErrorMessagesAddress).getText();
        } else return "Адрес  валидный";
    }
    public String getTextInputErrorMessagesPhoneNumber (){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if (isElementPresent(inputErrorMessagesPhoneNumber)) {
            return driver.findElement(inputErrorMessagesPhoneNumber).getText();
        } else return "Номер телефона  валиден";
    }
    public String getTextInputErrorMessagesMetro (){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if (isElementPresent(inputErrorMessagesMetro)) {
            return driver.findElement(inputErrorMessagesMetro).getText();
        } else return "Метро  валидно";
    }


}
