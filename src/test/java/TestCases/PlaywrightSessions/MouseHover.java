package TestCases.PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MouseHover {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.way2automation.com/");

        page.locator("//li[@id='menu-item-27580']//span[@class='menu-text'][normalize-space()='All Courses']").hover();
        page.locator("//li[@id='menu-item-27592']//a[contains(@class,'menu-link')]").click();

        page.close();
        playwright.close();

    }

}
