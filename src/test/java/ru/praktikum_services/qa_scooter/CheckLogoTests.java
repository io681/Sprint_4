package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.PageObject.HomePage;

import static org.junit.Assert.assertEquals;

public class CheckLogoTests {
    WebDriver driver = new ChromeDriver();
    // Тест проверки Лого Самокат
    @Test
    public void checkLogoSamokatTest(){
        driver.get("https://qa-scooter.praktikum-services.ru");
        //Создаем объекты классов
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickButtonToOrder(true);
        objHomePage.clickLogoSamokat();
        String actual = driver.getCurrentUrl();
        assertEquals("Ошибка сравнения", "https://qa-scooter.praktikum-services.ru/", actual);
    }
    // Тест проверки Лого Яндекс
    @Test
    public void checkLogoYandexTest (){
        driver.get("https://qa-scooter.praktikum-services.ru");
        //Создаем объекты классов
        HomePage objHomePage = new HomePage(driver);
        String actual = objHomePage.getAttributeHrefLogoYandex();
        assertEquals("Ошибка сравнения", "https://yandex.ru/", actual);
    }
    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
