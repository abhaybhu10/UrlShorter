package app;

import lombok.RequiredArgsConstructor;
import persistence.Persister;
import pojo.UrlMapping;
import strategy.Encoder;

@RequiredArgsConstructor
public class UrlShortnerImpl implements UrlShortner {
    final Encoder encoder;
    final Persister persister;
    @Override
    public String shortenUrl(String url) {
        String encodedString = encoder.encode(url);
        persister.persist(UrlMapping.builder().url(url).tinyUrl(encodedString).build());
        return encodedString;
    }

    @Override
    public String getUrl(String shortenedUrl) {
        return persister.loadData(shortenedUrl).getUrl();
    }
}
