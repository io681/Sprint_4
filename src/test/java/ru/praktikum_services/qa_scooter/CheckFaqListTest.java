package ru.praktikum_services.qa_scooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.PageObject.FaqHomePage;
import ru.praktikum_services.qa_scooter.PageObject.HomePage;

public class CheckFaqListTest {
    WebDriver driver = new ChromeDriver();
    private final String[] expected = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."};

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
    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}
