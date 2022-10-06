package ru.itmo.clockmodelling.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itmo.clockmodelling.model.ClockHand;

public class ConfigReader {

    private static final String CONFIG_FILE_NAME = "config/vectors.config";
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigReader.class);


    public static List<ClockHand> readConfig() {
        try (var scanner = new Scanner(new File(CONFIG_FILE_NAME))) {
            return parseFile(scanner);
        } catch (FileNotFoundException e) {
            LOGGER.warn("File with full path: " + new File(CONFIG_FILE_NAME).getAbsolutePath() + " is not found");
            return getDefaultConfig();
        }
    }

    private static List<ClockHand> parseFile(Scanner scanner) {
        var result = new ArrayList<ClockHand>();

        while (scanner.hasNext()) {
            var radius = scanner.nextLong();
            var period = scanner.nextLong();

            result.add(new ClockHand(radius, period));
        }

        return result;
    }

    private static List<ClockHand> getDefaultConfig() {
        return List.of(
            new ClockHand(50, 3600),
            new ClockHand(50, 60)
        );
    }
}
