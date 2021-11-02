import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class ChromeDevTools {
    public static void main(String[] args){
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        Map deviceMetrics = new HashMap()
        {{
            put("width", 411);
            put("height", 731);
            put("mobile", true);
            put("deviceScaleFactor", 100);
        }};
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
        driver.get("https://www.google.com");
//        driver.quit();
    }
}
