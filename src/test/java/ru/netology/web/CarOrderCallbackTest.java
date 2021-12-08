package ru.netology.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarOrderCallbackTest {
    private ChromeDriver driver;
    private ChromeOptions options;


    @BeforeAll
    public static void setUpAll() {


        System.setProperty("webdriver.chrome.driver", "./driver/win32/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "./driver/win32/chromedriver.exe");

    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldSendFormByFindElements() {
        driver.get("http://localhost:9999");
        List<WebElement> textFields = driver.findElements(By.className("input__control"));
        textFields.get(0).sendKeys("Йохан Иванов");
        textFields.get(1).sendKeys("+74584628475");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();
        String actualText = driver.findElement(By.id("root")).getText();
        String expectedText = "Заявка на дебетовую карту\n" +
                "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expectedText, actualText, "Текст сообщения не совпадает");
    }

    @Test
    public void shouldSendFormByCssSelector() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Пекка Ложкин");
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("+74465828475");
        driver.findElement(By.cssSelector(".checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();
        String actualText = driver.findElement(By.id("root")).getText();
        String expectedText = "Заявка на дебетовую карту\n" +
                "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expectedText, actualText, "Текст сообщения не совпадает");
    }
}


