//package Mini_Assignment_A1_solution;

//Created by: Joseph Vybihal
//Javadoc Commenting : Richard Gao
//Created on: September 2018
//
//Purpose - to create a map class that is safe to share with other developers
//
/**
 * <h1> Map Class</h1> The Map Class implements a Map consisting of three elements:
 * G, ~ and #. 
 * @author Rgao
 *
 */
public class Map {
 public static final int MAXINT = 2147483647;
 private char array[][];
 private int width, height;

 //
 // public static methods to be used by external software to validate their data
 // without the need to instantiate an object
 //
/**
 * This method is used to check if the input size is valid.
 * @param n This is the integer being checked as size
 * @return True or false if n is greater than 0
 */
 public static boolean validSize(int n) {
     return n > 0; // cannot create an array of size zero or less

 }
/**
 * This method checks if the input char is a valid one
 * @param c This is the terrain parameter
 * @return True or False if terrain parameter is a valid one
 */
 public static boolean validTerrain(char c) {
     // A char array of all valid symbols and a loop could have also be used
     return (c == '~' || c == 'G' || c == '#');
 }

 //
 // Constructor builds a safe world.
 // Throws error if it cannot be created.
 //
/**
 * This is the Constructor for a Map instance
 * @param width Is the integer value assigned to the map's width
 * @param height Is the inter value assigned to the map's height
 * @throws Exception Is thrown if one of the parameters are invalid in size using validSize method.
 */
 Map(int width, int height) throws Exception {
     int i, j;

     if (Map.validSize(width)) this.width = width;
     else throw new Exception("Incorrect width: "+width);

     if (Map.validSize(height)) this.height = height;
     else throw new Exception("Incorrect height: "+height);

     array = new char[width][height];

     for(i=0; i<height; i++)
         for(j=0;j<width;j++)
             array[j][i] = '~';
 }

 //
 // Safe public method to populate the map.
 //
/**
 * This method sets a terrain given coordinates
 * @param row Row to add terrain in
 * @param col Column to add terrain in 
 * @param terrain Terrain to add
 * @throws Exception Thrown if invalid size using validSize method and if row or column invalid.
 */
 public void setTerrain(int row, int col, char terrain) throws Exception {
     if ((validSize(row) || row==0) && row < height && (validSize(col) || col==0) && col < width && validTerrain(terrain))
         array[col][row] = terrain;
     else
         throw new Exception("Incorrect information");
 }

 //
 // Returns a formatted string representing all the values in the map.
 //
/**
 * ToString Method
 * @return String version of Map and its terrain.
 */
 public String toString() {
     String result = "Terrain:\n\n";
     int i, j;

     for(i=0;i<height;i++) {
         for (j = 0; j < width; j++)
             result += " " + array[j][i];

         result += "\n";
     }

     return result;
 }
}
