package persistence.mysql;

import lombok.Data;

@Data
public class UrlData {
    final String id;
    final String tinyUrl;
    final String actualUrl;
    final String creationTime;
    final String expirationTime;
    final String user;
}
