package ru.praktikum_services.qa_scooter.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FaqHomePage {
    private WebDriver driver;
    // Элементы текста ответов
    private By answerTextFaqElement = By.xpath (".//div[@class = 'accordion__button']/parent::div/parent::div/div[@class = 'accordion__panel' and not(@hidden)]/p");
    // Элементы вопросов
    private By elementsFaqButtons =By.xpath(".//div[@class = 'accordion__button']");
    // хранилище ответов в виде массива строк
    private String[] textAnswersFaqArray = new String[8];

    public FaqHomePage (WebDriver driver){
        this.driver = driver;
    }
    public String [] getTextAnswersFaq () {
        List<WebElement> elements = driver.findElements(elementsFaqButtons);
        int i = 0;
        for (WebElement element : elements) {
            new WebDriverWait(driver, 2)
                    .until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            textAnswersFaqArray[i] = driver.findElement(answerTextFaqElement).getText();
            i += 1;
        }
        return textAnswersFaqArray;
    }
}
