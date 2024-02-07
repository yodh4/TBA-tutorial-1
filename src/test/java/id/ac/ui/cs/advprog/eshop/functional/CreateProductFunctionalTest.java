package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.concurrent.TimeUnit;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void testCreateProduct(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/list");

        WebElement createProduct = driver.findElement(By.id("create-button"));
        createProduct.click();

        WebElement nameInput = driver.findElement(By.id("nameInput"));
        String name = "Tes-auto";
        nameInput.sendKeys(name);

        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        String num = "10";
        quantityInput.sendKeys(num);

        WebElement submitBtn = driver.findElement(By.id("submit-product"));
        submitBtn.click();

// Add a sleep for a couple of seconds (optional)
        Thread.sleep(10000);
    }
}
