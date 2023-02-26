package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.PageObject.HomePage;

import static org.junit.Assert.assertEquals;

public class CheckInputErrorNumberOfOrderTest {
    WebDriver driver = new ChromeDriver();
    @Test
    public void checkInputErrorNumberOfOrderTest () {
        driver.get("https://qa-scooter.praktikum-services.ru");
        HomePage objHomePage = new HomePage(driver);
        String errorNumber = "err222";
        objHomePage.clickErrorNumberOrder(errorNumber);
        assertEquals("Ошибка сравнения", "https://qa-scooter.praktikum-services.ru/track?t="+ errorNumber, driver.getCurrentUrl());
        assertEquals("Ошибка сравнения", "https://qa-scooter.praktikum-services.ru/assets/not-found.png", objHomePage.getValueAttributeSrcErrorStatus ());
        assertEquals("Ошибка сравнения", "Not found", objHomePage.getValueAttributeSrcErrorAlt());
    }
    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
