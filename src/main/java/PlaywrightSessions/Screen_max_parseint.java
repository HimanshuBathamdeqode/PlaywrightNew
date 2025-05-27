package PlaywrightSessions;

import com.microsoft.playwright.*;

import java.awt.*;

public class Screen_max_parseint {

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();


        Playwright playwright =  Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int) width, (int) height));
      Page page = browserContext.newPage();
      page.navigate("https://www.amazon.com");
      page.close();
      playwright.close();

    }



}
