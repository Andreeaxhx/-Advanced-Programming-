package res;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Messages {

	public static void main(String[] args) {
		try (OutputStream output = new FileOutputStream("Messages.properties")) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("prompt", "Input command:");
            prop.setProperty("locales", "The available locales are:");
            prop.setProperty("locale.set", "The current locale is {0}");
            prop.setProperty("info", "Information about {0}:");
            prop.setProperty("invalid", "Unknown command");

            // save properties to project root folder
            prop.store(output, null);

            prop.forEach((key, value) -> System.out.println(key + " = " + value));

        } catch (IOException io) {
            io.printStackTrace();
        }

	}

}
