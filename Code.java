import java.util.ArrayList;

public class Code {
    // directions = {"up", "right", "down", "left"};
    // direction is the index of the direction in directions
    static int direction = 1;
    static long x = 0;
    static long y = 0;
    public static void main(String[] args) {
        ArrayList<String> lines = Utility.getFileData("test.txt");
        
        for (int i = 0; i < lines.size(); i++) {
            part1(lines.get(i));
        }

        System.out.println("Final position is: (" + x + ", " + y + ")");
        System.out.println("Product is: " + x * y);

        // part 2
        direction = 1;
        x = 0;
        y = 0;
        
        
    }

    public static void part1(String line) {
        String firstChar = line.substring(0, 1);
        int numbers = Integer.parseInt(line.substring(1));
        if (firstChar.equals("L") || firstChar.equals("R")) {
            rotate(firstChar);
            movement(numbers);

        } else {
            movement(numbers);
        }   
    }

    public static int part2() {
        return 0;
    }

    // changes the direction the direction follower is facing
    public static void rotate(String letter) {
        if (letter.equals("L")) {
            if (direction == 0) {
                direction = 3;
            } else {
                direction--;
            }
        }

        else if (letter.equals("R")) {
            if (direction == 3) {
                direction = 0;
            } else {
                direction++;
            }
        }
    }

    public static void movement(int amount) {
        if (direction == 0) {y += amount;} 
        else if (direction == 1) {x += amount;} 
        else if (direction == 2) {y -= amount;} 
        else if (direction == 3) {x -= amount;}
    }
}
