package pojo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class UrlMapping {
    String tinyUrl;
    String url;
}
