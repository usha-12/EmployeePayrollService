package com.brideglabz.employeepayrollservice;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NIOFileAPITest {
    private static String HOME = System.getProperty("user.home");
    private static String pLAY_WITH_NIOString = "TempPlayGround";
    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
        Path homePath = Paths.get(HOME);
        assertTrue(Files.exists(homePath));

        Path playPath = Paths.get(HOME + "/" + pLAY_WITH_NIOString);
        if (Files.exists(playPath))
            Files.delete(playPath);
        assertTrue(Files.notExists(playPath));

        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFile = Paths.get(playPath + "/temp" + cntr);
            assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            assertFalse(Files.exists(tempFile));
        });
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
                .forEach(System.out::println);

    }@Test
    public void givenADirectoryWatchedListsAllActivities() throws IOException{
        Path dir = Paths.get(HOME+"/"+pLAY_WITH_NIOString);
        Files.list(dir).filter(Files :: isRegularFile).forEach(System.out :: println);
        new Java8WatchServiceExample(dir).processEvents();
    }
}
