package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.PageObject.FaqHomePage;
import ru.praktikum_services.qa_scooter.PageObject.HomePage;

import static org.junit.Assert.assertEquals;

public class OtherTests {
    WebDriver driver = new ChromeDriver();
    private final String[] expected = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."};

    // Тест проверки Лого Самокат
    @Test
    public void logoSamokatTest(){
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
    public void logoYandexTest (){
        driver.get("https://qa-scooter.praktikum-services.ru");
        //Создаем объекты классов
        HomePage objHomePage = new HomePage(driver);
        String actual = objHomePage.getAttributeHrefLogoYandex();
        assertEquals("Ошибка сравнения", "https://yandex.ru/", actual);
    }
    // Тест проверки раздела FAQ
    @Test
    public void checkFaqListTest () {
        driver.get("https://qa-scooter.praktikum-services.ru");
        HomePage objHomePage = new HomePage(driver);
        FaqHomePage objFaqHomePage = new FaqHomePage(driver);

        objHomePage.clickButtonClickAcceptCookies();
        String[] result = objFaqHomePage.getTextAnswersFaq();

        Assert.assertArrayEquals("Ошибка в разделе FAQ", expected, result);
    }
    // Тест  поиска ошибочного номера заказа
    @Test
    public void checkErrorNumberOrderTest () {
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
