import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Utility {

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
       
    }

    public static void writeInput(String fileToWriteTo) {
        String puzzleInput = "";
        for (int i = 0; i < 10; i++) {
            String firstChar = "";

            int rand = (int)(Math.random() * 3);
            //generating the first character
            if (rand == 0) {firstChar = "L";} 
            else {firstChar = "R";} 

            rand = (int)(Math.random() * 200) + 1;
            puzzleInput += firstChar + rand + "\n";
        }

        for (int i = 0; i < 980; i++) {
            String firstChar = "";

            int rand = (int)(Math.random() * 4);
            //generating the first character
            if (rand == 0) {firstChar = "L";} 
            else if (rand == 1) {firstChar = "R";} 
            else if (rand == 2) {firstChar = "I";} 
            else {firstChar = "A";}
        
            // much smaller numbers for line swith 'I' and 'A' as the number for them dictates how many lines they apply to.
            if (rand == 2 || rand == 3) {
                rand = (int)(Math.random() * 9) + 1;
            } else {
                rand = (int)(Math.random() * 200) + 1;
            }

            puzzleInput += firstChar + rand + "\n";
        }

        for (int i = 0; i < 10; i++) {
            String firstChar = "";

            int rand = (int)(Math.random() * 3);
            //generating the first character
            if (rand == 0) {firstChar = "L";} 
            else {firstChar = "R";} 

            rand = (int)(Math.random() * 200) + 1;
            puzzleInput += firstChar + rand + "\n";
        }

        puzzleInput = puzzleInput.substring(0, puzzleInput.length() - 1);
        try (FileWriter fileWriter = new FileWriter(fileToWriteTo);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(puzzleInput);

            } catch (IOException e) {
                System.err.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
        }
    }
}
