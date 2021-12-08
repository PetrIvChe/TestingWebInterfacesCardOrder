package ru.netology.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CarOrderCallbackTest {
    private ChromeDriver driver;
    private ChromeOptions options;


    @BeforeAll
    public static void setUpAll() {


       System.setProperty("webdriver.chrome.driver", "E:/QA/AutomatedTesting/TestingWebInterfacesCardOrder/driver/win32/chromedriver.exe");
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
    public void shouldReturnForm () {
         driver.get("http://localhost:999");

    }

}


