package PlaywrightSessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class TestHandlingDropdowns {
    public static void main(String[] args) {
           Playwright playwright  = Playwright.create();
           Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
           Page page = browser.newPage();
           page.navigate("https://www.wikipedia.org/");

           //Select by value
            page.selectOption("select","et" );

            //Select By Text
            page.selectOption("select", new SelectOption().setLabel("Eesti"));

            // Select By Index
             page.selectOption("select", new SelectOption().setIndex(1));

            Locator values = page.locator("select>option");
            System.out.println(values.count());

            for(int i=0; i< values.count(); i++){

                System.out.println(values.nth(i).innerText()+"-----"+values.nth(i).getAttribute("lang"));

// prefer locator method always..above one


//            List<ElementHandle> values =  page.querySelectorAll("select>option");
//                System.out.println(values.size());
//                for (ElementHandle value: values){
//                    System.out.println(value.innerText()+"-----"+value.getAttribute("lang"));
//

                    page.close();
                    playwright.close();


                }


        }
        }



