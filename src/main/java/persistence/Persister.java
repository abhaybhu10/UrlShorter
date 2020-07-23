package persistence;

import pojo.UrlMapping;

public interface Persister {
    void persist(final UrlMapping urlMapping);
    UrlMapping loadData(final String url);
}
