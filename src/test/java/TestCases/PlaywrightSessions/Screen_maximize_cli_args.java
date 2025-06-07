package TestCases.PlaywrightSessions;

import com.microsoft.playwright.*;

import java.util.Arrays;
public class Screen_maximize_cli_args {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(Arrays.asList("--start-maximized"))
        );

        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions().setViewportSize(null)
        );

        Page page = context.newPage(); // ✅ Create a Page object from context
        page.navigate("https://www.amazon.com"); // ✅ Now call navigate on Page

        // Optional: Print page title to confirm it loaded
        System.out.println("Title: " + page.title());

        // Close resources
        browser.close();
        playwright.close();
    }
}
