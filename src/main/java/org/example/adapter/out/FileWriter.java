package org.example.adapter.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.application.port.out.CalculateMetricsFileWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Slf4j
public class FileWriter implements CalculateMetricsFileWriter {

    @Override
    public void write(Object o, String fileName) {
        String filePath = Paths.get("src/main/resources/"+fileName+".json").toString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(new File(filePath), o);
            log.info("JSON file written successfully to: {}", filePath);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
