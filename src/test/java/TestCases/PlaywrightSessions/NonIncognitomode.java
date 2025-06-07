package TestCases.PlaywrightSessions;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class NonIncognitomode {
    public static void main(String[] args) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setExecutablePath(Paths.get("/usr/bin/google-chrome")));

        Page page = browserContext.newPage();
        page.navigate("https://www.amazon.in");
        browser.close();
        playwright.close();

    }
}
