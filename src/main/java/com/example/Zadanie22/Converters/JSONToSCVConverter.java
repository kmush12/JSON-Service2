package com.example.Zadanie22.Converters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static com.example.Zadanie22.Converters.Flattener.flatten;


public class JSONToSCVConverter {

    public static void JsonToCsv(JSONArray json) throws IOException {
        File csvFile = new File("src/main/resources/dane.csv");
        JsonNode jsonTreeH = new ObjectMapper().readTree(String.valueOf(json));
        JsonNode jsonTree = new ObjectMapper().readTree(String.valueOf(flatten(jsonTreeH)));
        Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstObject = jsonTree.elements().next();
        firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
        CsvSchema csvSchema = csvSchemaBuilder
                .build()
                .withHeader();
        //System.out.println(csvSchema.size());
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValue(csvFile, jsonTree);
    }

    public static String CsvReader(List<String> headerlist){
        StringBuilder string = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources//dane.csv"));
            CSVParser parser = CSVFormat.DEFAULT.withDelimiter(',').withHeader().parse(br)) {
            int x = headerlist.size();

            for(String header : headerlist) {
                if(!Objects.equals(header, headerlist.get(x - 1))){
                    string.append(header).append(", ");
                }else{
                    string.append(header);
                }
            }
            string.append("\n");
            for(CSVRecord record : parser) {
                for(String header : headerlist){
                    if(!Objects.equals(header, headerlist.get(x - 1))) {
                        string.append(record.get(header)).append(",");
                    }else {
                        string.append(record.get(header));
                    }
                }
                string.append("\n");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return string.toString();
    }
}

