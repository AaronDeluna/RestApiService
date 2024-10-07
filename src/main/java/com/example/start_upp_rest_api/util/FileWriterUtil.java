package com.example.start_upp_rest_api.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {
    public static void writeToFile(String fileName, Object item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(item.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
