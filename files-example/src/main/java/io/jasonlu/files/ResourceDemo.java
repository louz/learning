package io.jasonlu.files;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Properties;

/**
 * Created by Louz on 2016/1/6.
 */
public class ResourceDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("relative path:" + ResourceDemo.class.getResource(".").getPath());
        System.out.println("absolute path:" + ResourceDemo.class.getResource("/").getPath());

        System.out.println(Paths.get("sss").toFile().getPath());

        System.out.println(Paths.get("aaa.txt").toAbsolutePath().toFile().getAbsolutePath());

//        try (InputStream in = ResourceDemo.class.getResourceAsStream("aa.properties")) {
//            Properties prop = new Properties();
//            prop.load(in);
//        }

        // 遍历
        Path path = Paths.get("/");
        Files.walkFileTree(path, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("dir:" + dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("file:" + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
