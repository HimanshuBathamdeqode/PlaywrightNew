package TestCases.PlaywrightSessions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/properties/locator.properties");
        prop.load(fis);

        System.out.println(prop.get("browser"));
        System.out.println(prop.get("username_XPATH"));

        //this code will not work...this is for log4j 1 but after this i have configured it for log4j2



    }
}
