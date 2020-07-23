package strategy;

import java.util.UUID;

public class RandomEncoder implements Encoder {
    @Override
    public String encode(String url) {
        return UUID.randomUUID().toString();
    }
}
