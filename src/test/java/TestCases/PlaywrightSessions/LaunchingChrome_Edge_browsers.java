package TestCases.PlaywrightSessions;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class LaunchingChrome_Edge_browsers {
    public static void main(String[] args) throws InterruptedException {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        System.out.println(width+"---"+height);

        Playwright playwright = Playwright.create();
     //   Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width, (int)height));
        Page page = browserContext.newPage();
        page.navigate("http://way2automation.com");
        System.out.println(page.title());
        Thread.sleep(2000);
        page.close();
        playwright.close();
    }
}
