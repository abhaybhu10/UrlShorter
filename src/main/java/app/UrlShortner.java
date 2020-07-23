package app;

public interface UrlShortner {
    String shortenUrl(final String url);
    String getUrl(final String shortenedUrl);
}
