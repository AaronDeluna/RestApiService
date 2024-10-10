package com.example.start_upp_rest_api.util;

import java.io.*;

public class FileWriterUtils {
    public static void writeToFile(String fileName, Object item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(item.toString());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
