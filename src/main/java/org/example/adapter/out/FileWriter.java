package org.example.adapter.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.example.application.domain.Metrics;
import org.example.application.port.out.CalculateMetricsFileWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
public class FileWriter implements CalculateMetricsFileWriter {

    @Override
    public void write(List<Metrics> metrics) {
        String filePath = Paths.get("src/main/resources/metrics.json").toString();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(new File(filePath), metrics);
            log.info("JSON file written successfully to: {}", filePath);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
