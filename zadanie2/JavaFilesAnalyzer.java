package zadanie2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaFilesAnalyzer {
    public static void main(String[] args) {

        try {
            Map<DayOfWeek, Long> filesByDayOfWeek = countJavaFilesByDayOfWeek("/Users/gaczor/IdeaProjects/untitled1/src");
            filesByDayOfWeek.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach((entry -> System.out.println(entry.getKey() + " -> " + entry.getValue())));
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
    /*
    TUESDAY -> 83
    WEDNESDAY -> 45
    THURSDAY -> 67
    FRIDAY -> 3
    SATURDAY -> 45
    SUNDAY -> 23
     */

}

