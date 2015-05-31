package net.moznion.gimei.name;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;
import net.moznion.gimei.Gimei;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

class NounDataSupplier {
    public static final NounData NOUN_DATA;

    static {
        ClassLoader classLoader = Gimei.class.getClassLoader();
        Path path = Paths.get(classLoader.getResource("nouns.yml").getFile());
        try {
            byte[] nounSource = Files.readAllBytes(path);
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            NOUN_DATA = mapper.readValue(nounSource, NounData.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load nouns.yml file.");
        }
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class NounData {
        private List<NameUnit> nouns;

        @JsonProperty("nouns")
        public void setNouns(List<List<String>> data) {
            this.nouns = data.stream()
                    .map(NameUnit::new)
                    .collect(Collectors.toList());
        }
    }
}
