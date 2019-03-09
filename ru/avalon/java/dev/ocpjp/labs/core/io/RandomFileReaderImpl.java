package ru.avalon.java.dev.ocpjp.labs.core.io;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static java.util.Objects.nonNull;

final class RandomFileReaderImpl implements RandomFileReader {

    private FileReader reader;
    private int linesCountInFile;
    private Random random = new Random();

    RandomFileReaderImpl(File file) throws IOException {
        reader = FileReader.getInstance(file);
        linesCountInFile = reader.getLinesCount();
    }

    @Override
    public String readLine() {
        try {
            // выбирает номер случайной строки
            int line = random.nextInt(linesCountInFile);
            // считывает эту строку из файла
            return reader.readLines(line);
        } catch (IOException e) {
            e.printStackTrace(System.err);
            return null;
        }
    }

    @Override
    public void close() throws IOException {
        assert nonNull(reader);
        reader.close();
        reader = null;
    }
}
