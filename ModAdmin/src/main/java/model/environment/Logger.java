package model.environment;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private final String summoner;
    private final String packages;

    public Logger(String summoner) {
        this.summoner = summoner;
        packages = "M.s.";
    }

    public void info(String message) {
        String fileName = getFileName();
        String date = getDateOfTheCall();

        try (FileWriter fileWriter = new FileWriter("ModAdmin/src/main/resources/Model/LoggerFiles/" + fileName, true)) {
            fileWriter.write(date + " INFO " + packages + summoner + " " + message + "\n");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private String getFileName() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter) + ".txt";
    }

    private String getDateOfTheCall() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return date.format(formatter);
    }

}
