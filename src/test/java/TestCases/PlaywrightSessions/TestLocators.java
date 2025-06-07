package TestCases.PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestLocators {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://gmail.com");
       // page.locator("#identifierId").type("trainer@way2automation.com");
        page.type("#identifierId", "trainer@way2automation.com", new Page.TypeOptions().setDelay(100));
      //  page.click("text=Next");
        page.click("button:has-text('Next')");

        page.locator("[type=password]").fill("abc");
        page.click("text=Next");
        System.out.println( page.locator("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div/form/span/section[2]/div/div/div[1]/div[2]/div[2]/span").innerText());
    }
}
