import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class DownloadingFiles {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.selenium.dev/downloads/");

        Download file =page.waitForDownload(() ->{

            page.locator("a[href*='selenium-server']").first().click();


        });
        file.saveAs(Paths.get("src/test/resources/selenium.jar"));

    }
}
