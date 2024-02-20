package zadanie2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaFilesAnalyzer {
    public static void main(String[] args) {

        try {
            Map<DayOfWeek, Long> filesByDayOfWeek = countJavaFilesByDayOfWeek("/Users/gaczor/IdeaProjects/untitled1/src");
            Arrays.stream(DayOfWeek.values())
                    .forEach(dayOfWeek -> {
                        Long fileCount = filesByDayOfWeek.getOrDefault(dayOfWeek, 0L);
                        displayWorkSummary(dayOfWeek, fileCount);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Map<DayOfWeek, Long> countJavaFilesByDayOfWeek(String directoryPath) throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get(directoryPath), Integer.MAX_VALUE)) {
            return stream
                    .filter(path -> path.toString().endsWith(".java"))
                    .map(path -> {
                        try {
                            BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
                            return LocalDate.ofInstant(fileAttributes.creationTime().toInstant(), ZoneId.systemDefault()).getDayOfWeek();
                        } catch (IOException e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        }
    }


    private static void displayWorkSummary(DayOfWeek dayOfWeek, Long fileCount) {
        if (fileCount > 0) {
            System.out.println(getDayOfWeekInPolish(dayOfWeek) + " -> " + fileCount);
        } else {
            System.out.println(getDayOfWeekInPolish(dayOfWeek) + " -> W ten dzień nie pracowałeś leniuszku ;)");
        }
    }

    private static String getDayOfWeekInPolish(DayOfWeek day) {
        return day.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pl-PL"));
    }
    /*
    poniedziałek -> W ten dzień nie pracowałeś leniuszku ;)
    wtorek -> 83
    środa -> 45
    czwartek -> 67
    piątek -> 3
    sobota -> 45
    niedziela -> 23
     */

}

