package TestCases.PlaywrightSessions;

import com.microsoft.playwright.*;

public class TestHandlingLinks {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");

         Locator links = page.locator("a");
       // Locator links = page.locator("a:visible");   //for only visible  links


        System.out.println(links.count());

        for(int i=0; i< links.count();i++){
            System.out.println(links.nth(i).innerText()+"----"+ links.nth(i).getAttribute("href"));

        }

       Locator block = page.locator("//*[@id=\"www-wikipedia-org\"]/footer/nav");
       Locator blocklinks =  block.locator("a");
       System.out.println("---printing links from the blocks");
       System.out.println(blocklinks.count());

        for (int i = 0; i< blocklinks.count(); i++){
            System.out.println(blocklinks.nth(i).innerText()+"------"+ blocklinks.nth(i).getAttribute("href"));
        }
        page.close();
        playwright.close();


    }
}
