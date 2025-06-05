package PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingJavaScriptDialogs {
    public static void main(String[] args) throws InterruptedException {
       Playwright playwright =  Playwright.create();
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://mail.rediff.com/cgi-bin/login.cgi");

        page.onDialog(dialog -> {
                    try {

                        Thread.sleep(2000);

                    } catch (InterruptedException e) {

                        // TODO Auto-generated catch block

                        e.printStackTrace();

                    }

            dialog.accept();
                    System.out.println(dialog.message());
        }
        );
        page.locator("[type='submit']").click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        page.close();
        browser.close();
        playwright.close();

    }
}
