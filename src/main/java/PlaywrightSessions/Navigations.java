package PlaywrightSessions;

import com.microsoft.playwright.*;

import java.awt.*;

public class Navigations {
    public static void main(String[] args) throws InterruptedException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        System.out.println(width + "---" + height);

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int) width, (int) height));
        Page page = browserContext.newPage();
        page.navigate("http://way2automation.com");
        System.out.println(page.title());

        page.navigate("http://google.com");
        page.goBack(new Page.GoBackOptions().setTimeout(500));
        Thread.sleep(1000);

        page.goForward(new Page.GoForwardOptions().setTimeout(400));

        Thread.sleep(1000);

        page.reload();
        browser.close();
        playwright.close();
        

    }
}
