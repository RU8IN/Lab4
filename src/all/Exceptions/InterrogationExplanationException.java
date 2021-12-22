package all.Exceptions;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

public class InterrogationExplanationException extends Exception {

    public InterrogationExplanationException() throws URISyntaxException {
        super("Коротышка не смог объясниться!");
        URI uri = new URI("https://imgur.com/L6TNO4Z");
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


