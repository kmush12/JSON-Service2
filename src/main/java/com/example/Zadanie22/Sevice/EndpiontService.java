package com.example.Zadanie22.Sevice;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.Zadanie22.Converters.JSONToSCVConverter.CsvReader;
import static com.example.Zadanie22.Converters.JSONToSCVConverter.JsonToCsv;
import static com.example.Zadanie22.DataGetter.GetData.Data;

@Service
public class EndpiontService {
    public static String end1(int x) throws IOException {

       JsonToCsv(Data(x));
        List<String> list1 = new ArrayList<>();
        list1.add("type");
        list1.add("_id");
        list1.add("name");
        list1.add("type");
        list1.add("latitude");
        list1.add("longitude");

        return CsvReader(list1);
    }
    public static String end2(int x, List<String> list) throws IOException {

        JsonToCsv(Data(x));
        return CsvReader(list);
    }

}
