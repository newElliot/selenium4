import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium4 {
    static ChromeDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        above();
        below();
        near();

        driver.get("https://www.python.org/");
        toLeftOf();
        toRightOf();

        driver.quit();
    }

    public static void above() {
        WebElement input_password = driver.findElement(By.id("password"));
        WebElement input_username = driver.findElement(with(By.tagName("input"))
                .above(input_password));

        highlightElement(input_username);
    }

    public static void below() {
        WebElement input_username = driver.findElement(By.id("username"));
        WebElement input_password = driver.findElement(with(By.tagName("input"))
                .below(input_username));

        highlightElement(input_password);
    }

    public static void toLeftOf() {
        WebElement link_downloads = driver.findElement(By.id("downloads"));
        WebElement link_about = driver.findElement(with(By.tagName("li"))
                .toLeftOf(link_downloads));

        highlightElement(link_about);
    }

    public static void toRightOf() {
        WebElement link_downloads = driver.findElement(By.id("downloads"));
        WebElement link_documentation = driver.findElement(with(By.tagName("li"))
                .toRightOf(link_downloads));

        highlightElement(link_documentation);
    }

    public static void near() {
        WebElement label_username = driver.findElement(By.xpath("//label[@for='username']"));
        WebElement input_username = driver.findElement(with(By.tagName("input"))
                .near(label_username));

        highlightElement(input_username);
    }

    private static WebElement highlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
        return element;
    }
}