package PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingTabsandPopups {
    public static void main(String[] args) {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");

            Page popup =   page.waitForPopup(()->{
            page.locator("text=Privacy Policy").nth(0).click();

        });

      popup.locator("//a[@id='header-sign-up-btn']").click();
      popup.locator("//input[@id='name']").fill("Himanshu batham");
      popup.close();
      page.close();
      browser.close();

    }
}