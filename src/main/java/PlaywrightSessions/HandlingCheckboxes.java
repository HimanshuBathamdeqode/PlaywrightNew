package PlaywrightSessions;

import com.microsoft.playwright.*;

public class HandlingCheckboxes {
    public static void main(String[] args) {
       Playwright playwright =  Playwright.create();
       Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
       Page page = browser.newPage();
       page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php");

      //Locator block =  page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"); //abs xpath
        Locator block = page.locator("//tbody//tr//div[4]");    // from selector's hub
        Locator checkboxes = block.locator("[type = 'checkbox']");

      for(int i = 0; i<checkboxes.count();i++){
          checkboxes.nth(i).click();
      }
        System.out.println(checkboxes.count());
        page.close();

        browser.close();

        playwright.close();

    }
}
