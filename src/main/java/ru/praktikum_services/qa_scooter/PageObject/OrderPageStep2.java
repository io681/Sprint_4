package ru.praktikum_services.qa_scooter.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Класс страницы заказа, форма №2 - "Про аренду"
public class OrderPageStep2 {
    private WebDriver driver;
    // Поле "Когда привезти самокат"
    private By inputFieldDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    // элемент выбора текущей даты в календаре
    private By inputFieldDateToday = By.xpath(".//div[contains(@class,'today')]");
    // Поле "Срок аренды"
    private By inputFieldPeriod = By.xpath(".//div[contains(text(),'* Срок аренды')]");
    // элемент из выпадающего спика "Срок аренды"
    private By inputFieldPeriodTwoDays = By.xpath(".//div[contains(text(),'двое суток')]");
    // Чек-бокс  "Цвет самоката"
    private By inputCheckBoxColor = By.xpath(".//input[@id = 'black']");
    // Поле "Комментарий"
    private By inputFieldComment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    // кнопка "Заказать" в форме
    private By buttonToOrder = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(),'Заказать')]");
    // кнопка "Да" в попапе подтверждения
    private By buttonOrderConfirm = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and contains(text(),'Да')]");
    // Элемент с текстом в попапе после успешного заказа
    private By messageOkAfterConfirm = By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ']");

    public OrderPageStep2 (WebDriver driver){
        this.driver = driver;
    }
    // Методы для позитивного флоу

    public  void clickInputFieldDate (){
        driver.findElement(inputFieldDate).click();
    }
    public  void clickInputFieldToday (){
        driver.findElement(inputFieldDateToday).click();
    }
    public void clickInputFieldPeriod(){
        driver.findElement(inputFieldPeriod).click();
    }
    public void ClickInputFieldPeriodTwoDays (){
        driver.findElement(inputFieldPeriodTwoDays).click();
    }
    public void clickInputCheckBoxColor (){
        driver.findElement(inputCheckBoxColor).click();
    }
    public void setInputFieldComment (String comment){
        driver.findElement(inputFieldComment).sendKeys(comment);
    }
    public void clickButtonToOrder (){
        driver.findElement(buttonToOrder).click();
    }
    public void clickButtonOrderConfirm (){
        driver.findElement(buttonOrderConfirm).click();
    }
    public String getMessageOkAfterConfirm (){
        return driver.findElement(messageOkAfterConfirm).getText();
    }
    public void setFormStep2 (String comment){
        clickInputFieldDate ();
        clickInputFieldToday ();
        clickInputFieldPeriod ();
        ClickInputFieldPeriodTwoDays();
        clickInputCheckBoxColor();
        setInputFieldComment (comment);
        clickButtonToOrder();
        clickButtonOrderConfirm();
    }
}
