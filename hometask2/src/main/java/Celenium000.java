import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Celenium000 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com/");

        WebElement s_input = driver.findElement(By.className("b_searchbox"));
        s_input.sendKeys("automation");

        WebElement s_button = driver.findElement(By.className("b_searchboxSubmit"));
        s_button.click();

        System.out.println("Заголовок страницы: " + driver.getTitle() + "\n");
        System.out.println("Заголовки всех отображаемых результатов поиска:");

        List<WebElement> results = driver.findElements(By.className("b_title"));

        for(int i = 0; i < results.size(); i++){

            int j = i + 1;
            System.out.println(j + ". " + results.get(i).findElement(By.tagName("a")).getText());
        }

        if (driver.getWindowHandles().size() > 1) {
            driver.close();
        }
        else {
            driver.quit();
        }
    }
}
