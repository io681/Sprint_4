package ru.praktikum_services.qa_scooter.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    private WebDriver driver;
    // Логотип Яндекс
    private By logoYandex = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");
    // Логотип Самокат
    private By logoSamokat = By.xpath(".//img[@alt='Scooter']");
    // Верхняя кнопка "Заказать"
    private By buttonToOrderUp = By.xpath(".//button[@class='Button_Button__ra12g']");
    // Нижняя кнопка заказать
    private By buttonToOrderLow = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка "Статус заказа"
    private By buttonStatusOrder = By.xpath(".//button[@class='Header_Link__1TAG7']");
    //кнопка подтвеждения согласия обработки куков
    private By buttonAcceptCookies = By.xpath(".//button[contains(text(),'да все привыкли')]");
    //поле 'Введите номер заказа'
    private  By numberOrderInputField = By.xpath(".//input[@placeholder = 'Введите номер заказа']");
    //кнопка "Go!" рядом с полем 'Введите номер заказа'
    private  By buttonGo = By.xpath(".//button[contains(text(),'Go!')]");
    //элемент картинки "Такого заказа нет"
    private By pictureNotFound = By.xpath(".//div[contains(@class,'Track_NotFound')]/img");


    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public void clickButtonClickAcceptCookies (){

        if (driver.findElements(buttonAcceptCookies).size() > 0) {
            driver.findElement(buttonAcceptCookies).click();
        }
    }
    public void clickButtonToOrder (boolean isPlaceButtonToOrder) {
        if (isPlaceButtonToOrder){
            driver.findElement(buttonToOrderUp).click();

        } else {
            clickButtonClickAcceptCookies ();
            driver.findElement(buttonToOrderLow).click();
        }
    }
    public void clickLogoSamokat (){
        driver.findElement(logoSamokat).click();
    }
    public String getAttributeHrefLogoYandex (){
        return driver.findElement(logoYandex).getAttribute("href");
    }
    public void clickErrorNumberOrder (String errorNumber){
        driver.findElement(buttonStatusOrder).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(numberOrderInputField));
        driver.findElement(numberOrderInputField).sendKeys(errorNumber);
        driver.findElement(buttonGo).click();
    }
    //методы для проверки лого Яндекс
    public String getValueAttributeSrcErrorStatus (){
        return driver.findElement(pictureNotFound).getAttribute("src");
    }
    public String getValueAttributeSrcErrorAlt (){
        return driver.findElement(pictureNotFound).getAttribute("alt");
    }

}
