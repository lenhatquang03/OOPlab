package OtherProjects.lab1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GarbageCreator {
    public static void main(String[] args) throws IOException{
        String filename = "C:\\Users\\LENOVO\\OneDrive - Hanoi University of Science and Technology\\Java\\OtherProjects\\lab1\\garbage.txt";
        long startTime, endTime;
        
        List<String> inputLines =  Files.readAllLines(Paths.get(filename));
        startTime = System.
        currentTimeMillis();
        String outputString = "";
        
        for (String line: inputLines) {
            outputString += line;
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
