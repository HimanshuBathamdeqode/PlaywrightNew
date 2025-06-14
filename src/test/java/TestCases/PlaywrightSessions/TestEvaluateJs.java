package TestCases.PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestEvaluateJs {
    public static void main(String[] args) {
        Playwright playwright =Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://google.com");

        System.out.println( page.evaluate("document.location.href"));
        page.evaluate("() => {"
                + "const textarea = document.createElement('textarea');"  //Is JS se ek textarea banega UI pe
                + "document.body.append(textarea);"
                + "textarea.focus();"
                +"}");

        String text = "Hello World !!";  //locator nai diya kyunki abhi focus area new textarea deke rakha he..line 19
        page.keyboard().type(text);
    }
}
