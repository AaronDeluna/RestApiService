package com.example.start_upp_rest_api.util.file;

import java.io.*;

public class FileWriterUtils {

    /**
     * Записывает объект в файл.
     *
     * @param fileName имя файла, в который нужно записать данные
     * @param item объект, который нужно записать в файл
     * @throws RuntimeException если возникает ошибка ввода-вывода
     */
    public static void writeToFile(String fileName, Object item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(item.toString());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
