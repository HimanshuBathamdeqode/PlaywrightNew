package TestCases.PlaywrightSessions;

import com.microsoft.playwright.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PlaywrightBasics {

    private static final Logger logger = LoggerFactory.getLogger(PlaywrightBasics.class);
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @BeforeMethod
    public void setUp() {
        try {
            logger.info("Launching Playwright and initializing browser...");
            playwright = Playwright.create();
            browser = playwright.firefox().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            context = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(1920, 937)
            );
            page = context.newPage();
            logger.info("Browser launched and context created successfully.");
        } catch (Exception e) {
            logger.error("Setup failed: {}", e.getMessage(), e);
            Assert.fail("Browser setup failed.");
        }
    }

    @Test
    public void testAmazonTitleAndUrl() {
        try {
            logger.info("Navigating to Amazon...");
            page.navigate("https://www.amazon.com");

            String title = page.title();
            logger.info("Page title: {}", title);
            Assert.assertTrue(title.contains("Amazon"), "Page title does not contain 'Amazon'");

            String url = page.url();
            logger.info("Page URL: {}", url);
            Assert.assertTrue(url.startsWith("https://www.amazon.com"), "Unexpected URL loaded");

        } catch (Exception e) {
            logger.error("Test execution failed: {}", e.getMessage(), e);
            Assert.fail("Test execution threw exception.");
        }
    }

    @AfterMethod
    public void tearDown() {
        try {
            logger.info("Closing browser and Playwright...");
            if (browser != null) browser.close();
            if (playwright != null) playwright.close();
            logger.info("Cleanup done.");
        } catch (Exception e) {
            logger.warn("Exception during teardown: {}", e.getMessage(), e);
        }
    }
}
