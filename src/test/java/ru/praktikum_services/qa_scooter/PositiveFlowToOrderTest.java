package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.PageObject.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PositiveFlowToOrderTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String numberPhone;
    private final String comment;
    private final boolean isPlaceButtonToOrder;
    WebDriver driver = new ChromeDriver();

    public PositiveFlowToOrderTest(boolean isPlaceButtonToOrder, String name, String surname, String address, String numberPhone, String comment) {
        this.isPlaceButtonToOrder=isPlaceButtonToOrder;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.numberPhone = numberPhone;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { true,"Василий", "Петров","Москва, ул. Пришвина, д.3","89994443322","Коммент"},
                { false,"Джеймс", "Бонд","Улан-Батор, ул. Юпитера, д.777","89994443322","Комментище1111"},
        };
    }
    @Test
    public void positiveFlowToOrderTest (){
        driver.get("https://qa-scooter.praktikum-services.ru");
        //Создаем объекты классов
        HomePage objHomePage = new HomePage(driver);
        OrderPageStep1 objOrderPageStep1= new OrderPageStep1(driver);
        OrderPageStep2 objOrderPageStep2= new OrderPageStep2(driver);

        // Шаги теста
        objHomePage.clickButtonToOrder(isPlaceButtonToOrder);
        objOrderPageStep1.setFormStep1 (name, surname, address, numberPhone);
        objOrderPageStep2.setFormStep2(comment);
        String actual = objOrderPageStep2.getMessageOkAfterConfirm().replaceAll("\\r\\n|\\r|\\n", " ");

        assertEquals("Ошибка позитивного флоу заказа", "Заказ оформлен  ", actual);
    }
    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
