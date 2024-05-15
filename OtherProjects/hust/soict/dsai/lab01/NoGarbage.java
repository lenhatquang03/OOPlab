package lab01;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws IOException{
        String filename = "C:\\Users\\Lenovo\\OneDrive - Hanoi University of Science and Technology\\Java\\OtherProjects\\lab1\\garbage.txt";
        long startTime, endTime;
        
        List<String> inputLines = Files.readAllLines(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();

        for (String line: inputLines) {
            sb.append(line);
        }

        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
