package com.citi.portfolio.util;

import com.csvreader.CsvReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    private String file_path;
    ReadCSV(){}
    public ReadCSV(String file_path){
        this.file_path = file_path;
    }
    public String getFile_path() {
        return file_path;
    }
    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public List<String> read() {

        List<String> result = new ArrayList<>();

        try {
            CsvReader csvReader = new CsvReader(file_path);
            while (csvReader.readRecord()){
                result.add(csvReader.getRawRecord());
            }
            csvReader.close();
            return result;

        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }
    }
}
