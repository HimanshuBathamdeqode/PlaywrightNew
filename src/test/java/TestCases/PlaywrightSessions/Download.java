package TestCases.PlaywrightSessions;

import com.microsoft.playwright.Playwright;

public class Download {

        public static void main(String[] args) {
            try (Playwright playwright = Playwright.create()) {
                playwright.chromium().launch();
                System.out.println("Chromium browser installed and launched successfully.");
            }
        }
    }



