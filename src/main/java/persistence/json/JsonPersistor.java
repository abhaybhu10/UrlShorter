package persistence.json;

import com.google.gson.Gson;
import persistence.Persister;
import pojo.UrlMapping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonPersistor implements Persister {
    final static String PATH = "/Users/kuabhay/Personal/dropwizard/urlsortner/src/main/resources/data";
    @Override
    public void persist(UrlMapping urlMapping) {
        JsonPersistedData jsonPersistedData = JsonPersistedData.builder()
                .actualUrl(urlMapping.getUrl())
                .tinyUrl(urlMapping.getTinyUrl())
                .build();

        String json = new Gson().toJson(jsonPersistedData, JsonPersistedData.class);
        try {
            writeToFile(json, urlMapping.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public UrlMapping loadData(String url) {
        try {
            Optional<JsonPersistedData> mappingData = readDataFromFile().stream()
                    .map(e -> deser(e))
                    .filter(jsonPersistedData -> jsonPersistedData.getTinyUrl().equals(url))
                    .findFirst();

            if (mappingData.isPresent()) {
                return UrlMapping.builder()
                        .url(mappingData.get().getActualUrl())
                        .tinyUrl(mappingData.get().getTinyUrl())
                        .build();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private void writeToFile(final String content, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH +"/"+fileName))) {
            writer.write(content);
        }
    }

    private JsonPersistedData deser(String jsonData) {
        JsonPersistedData data = new Gson().fromJson(jsonData, JsonPersistedData.class);
        return data;
    }

    private List<String> readDataFromFile() throws IOException {
        List<String> dataList = new ArrayList<>();
        File dir = new File(PATH);
        for (File file : dir.listFiles()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
               dataList.add(reader.readLine());
            }
        }
        return dataList;
    }
}
