package Mini_Assignment_A1_solution;

import java.util.Scanner;

public class MapMain {
    static Scanner in;

    //
    // Helper methods to make main() easy to read and debug since code-reuse was employed.
    //

    // Inputs:
    //  max    : The input integer must be greater than zero and less than max
    //  prompt : the specific prompt to ask the user for input
    //  errMsg : the specific error message if the input was wrong
    //  isZero : Modifies the condition to allow inputs of zero
    // Returns:
    //  The valid integer number
    public static int validateCoordinate(int max, String prompt, String errMsg, boolean isZero) {
        String input;
        int n = -1;

        do  {
            System.out.print(prompt);
            input = in.nextLine();
            try {
                n = Integer.parseInt(input);
                if (isZero && n==0) return 0;
                if (!Map.validSize(n) || n>=max) System.out.println(errMsg);
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        } while (!Map.validSize(n) || n>=max);

        return n;
    }

    // Inputs:
    //  Similar to validateCoordinate() method
    // Output:
    //  The valid input terrain symbol
    public static char validateTerrain(String prompt, String errMsg) {
        String input;
        char c = ' ';

        do  {
            System.out.print(prompt);
            input = in.nextLine();
            try {
                c = input.charAt(0);
            } catch (Exception e) {
                c = ' ';
            } finally {
                if (!Map.validTerrain(c)) System.out.println(errMsg);
            }
        } while (!Map.validTerrain(c));

        return c;
    }

    //
    // The primary UI control method
    //

    public static void main(String args[]) {
        Map theMap = null;
        String input = "";
        int maxRow = -1, maxWidth = -1, row, col;
        char terrain;

        in = new Scanner(System.in);

        System.out.println("Welcome to Map!\n");

        //
        // Build the map
        //

        while (theMap == null) {
            maxRow   = validateCoordinate(Map.MAXINT,"Please input the maximum number of rows: ","A row must be greater than 0.", false);
            maxWidth = validateCoordinate(Map.MAXINT,"Please input the maximum number of columns: ","A column must be greater than 0.", false);

            try {
                theMap = new Map(maxWidth, maxRow);
                System.out.println("Map has been created.");
            } catch (Exception e) {
                System.out.println("ERROR: Unable to create map.");
            }
        }

        //
        // Populate the map
        //

        do {
            System.out.println("Please add an object to the map (~ for water, G for grass, # for tree)");

            row     = validateCoordinate(maxRow,"Row: ", "Invalid row! It must be between 0 and "+maxRow, true);
            col     = validateCoordinate(maxWidth,"Column: ","Invalid column! It must be between 0 and "+maxWidth, true);
            terrain = validateTerrain("Character: ","Invalid character! It must be wither ~ or G or #.");

            try {
                theMap.setTerrain(row, col, terrain);
                System.out.println("Your "+terrain+" was added to "+row+", "+col+" in the map.");
            } catch (Exception e) {
                System.out.println("Error: unable to add your terrain to the map");
            }

            System.out.print("Would you like to enter another character (Y/N): ");
            input = in.nextLine();
        } while(input.toUpperCase().equals("Y"));

        //
        // Ending the application:
        // 1. Display the map
        // 2. terminate with message
        //
        System.out.println(theMap.toString());

        System.out.println("The program has now terminated.");
    }
}