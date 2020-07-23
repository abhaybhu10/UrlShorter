package driver;

import app.UrlShortner;
import app.UrlShortnerImpl;
import org.apache.commons.lang3.Validate;
import persistence.Persister;
import persistence.json.JsonPersistor;
import strategy.Encoder;
import strategy.RandomEncoder;

public class Runner {
    public static void main(String args[]) {
        Persister persister = new JsonPersistor();
        Encoder encoder = new RandomEncoder();
        UrlShortner urlShortner = new UrlShortnerImpl(encoder, persister);
        String url = "www.google.com";

        String tinyUrl = urlShortner.shortenUrl(url);
        System.out.println(tinyUrl + " " + urlShortner.getUrl(tinyUrl));

        Validate.isTrue(url.equals(urlShortner.getUrl(tinyUrl)));
    }
}
