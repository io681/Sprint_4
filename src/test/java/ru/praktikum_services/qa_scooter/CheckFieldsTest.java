package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.PageObject.HomePage;
import ru.praktikum_services.qa_scooter.PageObject.OrderPageStep1;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckFieldsTest {
    private String name;
    private String surname;
    private String address;
    private String numberPhone;
    WebDriver driver = new ChromeDriver();

    public CheckFieldsTest(String name, String surname, String address, String numberPhone){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.numberPhone = numberPhone;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {"Александр","А","89101112233","english"},
                {"english","Волков","Адрес","89101112233"},
                {"89101112233","89101112233","89101112233","89101112233"},
                {"Петр","english","улица Вавилова, 5, Москва, Центральный федеральный округ Москва, Россия, 8888444","89101112233"},
                {"Петр","Волков","Адрес","89101112233"},
        };
    }
    @Test
    public void approbeTest () {
        driver.get("https://qa-scooter.praktikum-services.ru");
        //Создаем объекты классов
        HomePage objHomePage = new HomePage(driver);
        OrderPageStep1 objOrderPageStep1 = new OrderPageStep1(driver);

        // Шаги теста
        objHomePage.clickButtonClickAcceptCookies();
        objHomePage.clickButtonToOrder(true);
        objOrderPageStep1.setFormStep1(name, surname, address, numberPhone);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        String textWarningName = objOrderPageStep1.getTextInputErrorMessagesName();
        String textWarningSurname = objOrderPageStep1.getTextInputErrorMessagesSurname();
        String textWarningAddress = objOrderPageStep1.getTextInputErrorMessagesAddress();
        String textWarningPhoneNumber = objOrderPageStep1.getTextInputErrorMessagesPhoneNumber();
        String textWarningMetro = objOrderPageStep1.getTextInputErrorMessagesMetro();

        assertEquals(textWarningName, "Имя  валидно", textWarningName);
        assertEquals(textWarningSurname, "Фамилия  валидна", textWarningSurname);
        assertEquals(textWarningAddress, "Адрес  валидный", textWarningAddress);
        assertEquals(textWarningPhoneNumber, "Номер телефона  валиден", textWarningPhoneNumber);
        assertEquals(textWarningMetro, "Метро  валидно", textWarningMetro);
        }
    @After
    public void teardown() {
        // Закрыть браузер
        this.driver.quit();
    }
}
