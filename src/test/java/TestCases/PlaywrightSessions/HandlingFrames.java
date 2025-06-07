package TestCases.PlaywrightSessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

public class HandlingFrames {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
//        page.navigate("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");    //by me with different frames
//        page.frameLocator("//*[@id='iframeResult']").locator("//a[@title=\'CSS Tutorial\'][normalize-space()=\'CSS\']").click(new Locator.ClickOptions().setTimeout(2000));

        page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get",
                new Page.NavigateOptions()
                        .setTimeout(60000)
                        .setWaitUntil(WaitUntilState.LOAD));  // ye timeout gpt se lagaya he..page 30 sec me load nai ho rha tha to timeout error aa rha tha.


        page.frameLocator("[name='iframeResult']")
                .locator("body > button")
                .click(new Locator.ClickOptions().setTimeout(2000));

        page.frameLocator("//*[@id='iframeResult']").locator("//a[@title=\'CSS Tutorial\'][normalize-space()=\'CSS\']").click(new Locator.ClickOptions().setTimeout(2000));

        Locator frames = page.locator("iframe");
        System.out.println(frames.count());

        for (int i = 0; i < frames.count(); i++) {
            System.out.println(frames.nth(i).getAttribute("id"));
        }
    }
}
