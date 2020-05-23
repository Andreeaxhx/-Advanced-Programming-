package res;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Messages_ro {

	public static void main(String[] args) {
		try (OutputStream output = new FileOutputStream("Messages_ro.properties")) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("prompt", "Comanda ta:");
            prop.setProperty("locales", "Localizarile disponibile sunt:");
            prop.setProperty("locale.set", "Localizarea curenta este {0}");
            prop.setProperty("info", "Informatii despre localizarea {0}:");
            prop.setProperty("invalid", "Comanda necunoascuta");

            // save properties to project root folder
            prop.store(output, null);

            prop.forEach((key, value) -> System.out.println(key + " = " + value));

        } catch (IOException io) {
            io.printStackTrace();
        }

	}
}