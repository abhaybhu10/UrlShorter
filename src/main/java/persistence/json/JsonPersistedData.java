package persistence.json;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class JsonPersistedData {
    private String id;
    private String tinyUrl;
    private String actualUrl;
    private String creationTime;
    private String expirationTime;
    private String user;
}
