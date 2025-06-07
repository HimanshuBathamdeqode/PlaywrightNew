package TestCases.PlaywrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class UploadingFiles {
    public static void main(String[] args) {



        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

       // page.locator("#register_form > fieldset:nth-child(9) > input[type=file]").setInputFiles(Paths.get("C:\\Users\\himan\\Pictures\\Screenshots\\Screenshot 2025-06-05 121245.png"));
        page.locator("#register_form > fieldset:nth-child(9) > input[type=file]").setInputFiles(Paths.get("src/test/resources/Screenshot 2025-06-05 121245.png"));

    }


}
