import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.devtools.v95.network.model.Headers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SetAuthHeader {
    private static final String USERNAME = "guest";
    private static final String PASSWORD = "guest";

    public static void main(String[] args){
        ChromeDriver driver = new ChromeDriver();

        //Create DevTools session and enable Network
        DevTools chromeDevTools = driver.getDevTools();
        chromeDevTools.createSession();
        chromeDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //Open website
        driver.get("https://jigsaw.w3.org/HTTP/");

        //Send authorization header
        Map<String, Object> headers = new HashMap<>();
        String basicAuth ="Basic " + new String(new Base64().encode(String.format("%s:%s", USERNAME, PASSWORD).getBytes()));
        headers.put("Authorization", basicAuth);
        chromeDevTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        //Click authentication test - this normally invokes a browser popup if unauthenticated
        driver.findElement(By.linkText("Basic Authentication test")).click();

        String loginSuccessMsg = driver.findElement(By.tagName("html")).getText();
        if(loginSuccessMsg.contains("Your browser made it!")){
            System.out.println("Login successful");
        }else{
            System.out.println("Login failed");
        }

        driver.quit();
    }
}
