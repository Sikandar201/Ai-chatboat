package com.example.devops_project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FrontendWebDriverTest {

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Run in headless mode
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testChatInterface() {
        // 1. Navigate to the chat page
        driver.get("http://localhost:" + port + "/");

        // 2. Find the input field and send button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message-input")));
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("send-button")));

        // 3. Type a message and send it
        messageInput.sendKeys("Hello, this is an automated UI test!");
        sendButton.click();

        // 4. Wait for the new user message to appear in the DOM
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".message.user"), 0));

        // 5. Wait for the bot response to appear (we initially have 1 hardcoded bot message in index.html)
        // So we wait until there are at least 2 elements with class .message.bot
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".message.bot"), 1));

        // 6. Verify that the response text is not empty
        java.util.List<WebElement> botMessages = driver.findElements(By.cssSelector(".message.bot"));
        WebElement latestBotResponse = botMessages.get(botMessages.size() - 1);
        
        String responseText = latestBotResponse.getText();
        System.out.println("Bot Response Received: " + responseText);
        
        assertTrue(responseText != null && !responseText.trim().isEmpty(), "The bot response should not be empty");
    }
}
