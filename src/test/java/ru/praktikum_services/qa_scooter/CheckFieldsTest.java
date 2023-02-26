package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.PageObject.HomePage;
import ru.praktikum_services.qa_scooter.PageObject.OrderPageStepOne;
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
    public void checkFieldsTest () {
        driver.get("https://qa-scooter.praktikum-services.ru");
        //Создаем объекты классов
        HomePage objHomePage = new HomePage(driver);
        OrderPageStepOne objOrderPageStepOne = new OrderPageStepOne(driver);

        // Шаги теста
        objHomePage.clickButtonClickAcceptCookies();
        objHomePage.clickButtonToOrder(true);
        objOrderPageStepOne.setFormStepOne(name, surname, address, numberPhone);

        String textWarningName = objOrderPageStepOne.getTextInputErrorMessagesName();
        String textWarningSurname = objOrderPageStepOne.getTextInputErrorMessagesSurname();
        String textWarningAddress = objOrderPageStepOne.getTextInputErrorMessagesAddress();
        String textWarningPhoneNumber = objOrderPageStepOne.getTextInputErrorMessagesPhoneNumber();
        String textWarningMetro = objOrderPageStepOne.getTextInputErrorMessagesMetro();

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
