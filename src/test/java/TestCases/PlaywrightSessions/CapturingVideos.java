package TestCases.PlaywrightSessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.nio.file.Paths;
import java.util.List;

public class CapturingVideos {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
        Page page = context.newPage();
        page.navigate("https://www.wikipwdia.org/");
        //select by value

        page.selectOption("select", "hi");


//select by text

        page.selectOption("select", new SelectOption().setLabel("Eesti"));


//select by index

        page.selectOption("select", new SelectOption().setIndex(1));


/*

Locator values = page.locator("select > option");

System.out.println(values.count());



for(int i=0; i<values.count(); i++) {


System.out.println(values.nth(i).innerText()+"----"+values.nth(i).getAttribute("lang"));



}*/


        List<ElementHandle> values = page.querySelectorAll("select > option");


        System.out.println(values.size());


        for (ElementHandle value : values) {


            System.out.println(value.innerText() + "----" + value.getAttribute("lang"));


        }


        page.close();

        context.close();

        playwright.close();
    }
};

