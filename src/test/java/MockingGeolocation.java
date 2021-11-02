import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.emulation.Emulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class MockingGeolocation {
    public static void main(String[] args){
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(35.8235),
                Optional.of(-78.8256),
                Optional.of(100)));
        driver.get("https://mycurrentlocation.net/");
    }
}
