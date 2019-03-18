//package Mini_Assignment_A1_solution;

import org.junit.Test;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

//Created by: Joseph Vybihal
//Created on: September 2018
//
//Purpose: To exhaustively validate the Map.java class methods.
//
public class MapTest extends TestCase{
/* public static void main(String args[]) {
     testValidSize();
     testValidTerrain();
     testConstructor();
     testSetTerrain();
     testToString();
 }*/

 // The expectation is that a valid size is greater than or equal to zero
 // Assumes integer range, therefore testing -1, 0, and 1 is enough.
@Test
public void testValidSize1(){
     //System.out.println("TESTING VALID SIZE");
     //if (Map.validSize(-1)) System.out.println("Error! -1 is not a valid size ******");
     //if (Map.validSize(0) ) System.out.println("Error! 0 is not a valid size  ******");
     //if (!Map.validSize(1)) System.out.println("Error! 1 IS a valid size      ******");
     //System.out.println("TEST END\n\n");
	 //assertSize(-1);
	 //assertSize(0);
	 //assertSize(1);
	 //String name = this.getName();
	 //this.setName("testValidSize-1");
	 Assert.assertFalse("Input -1. Result True. Expected False",Map.validSize(-1));
}
@Test
public void testValidSize2(){
	 Assert.assertFalse("Input 0. Result True. Expected False",Map.validSize(0));
}
@Test
public void testValidSize3(){
	Assert.assertTrue("Input 1. Result False. Expected True",Map.validSize(1));
}

 
// The expectation is that a valid terrain is only these characters: ~ G #
// Assume ASCII range of characters, therefore testing 34=" 35=# 36=$ 71=G 72=H 126=~ 127={DEL]
@Test
public void testValidTerrain1(){
     /*System.out.println("TESTING VALID TERRAIN");
     if (Map.validTerrain((char) 34) ) System.out.println("Error! Character 34 is not valid     ******");
     if (!Map.validTerrain('#')   ) System.out.println("Error! # IS valid but marked invalid ******");
     if (Map.validTerrain('$')    ) System.out.println("Error! Character $ is not valid      ******");
     if (!Map.validTerrain('G')   ) System.out.println("Error! G is valid but marked invalid ******");
     if (Map.validTerrain('H')    ) System.out.println("Error! Character H is not valid      ******");
     if (!Map.validTerrain('~')   ) System.out.println("Error! ~ is valid but marked invalid ******");
     if (Map.validTerrain((char) 127)) System.out.println("Error! Character 127 is not valid    ******");
     System.out.println("TEST END\n\n");*/
	Assert.assertFalse("Error! Character 34 is not valid",Map.validTerrain((char) 34));
}
@Test
public void testValidTerrain2(){
	Assert.assertTrue("Error! # IS valid but marked invalid",Map.validTerrain(('#')));
}
@Test
public void testValidTerrain3(){
	Assert.assertFalse("Error! Character $ is not valid",Map.validTerrain(('$')));
}
@Test
public void testValidTerrain4(){
	Assert.assertTrue("Error! G IS valid but marked invalid",Map.validTerrain(('G')));
}
@Test
public void testValidTerrain5(){
	Assert.assertFalse("Error! Character 127 is not valid",Map.validTerrain((char) 127));
}
@Test
public void testValidTerrain6(){
	Assert.assertTrue("Error! ~ IS valid but marked invalid",Map.validTerrain(('~')));
}
 // The expectation is that an array is created and no errors are thrown
 // Test if array is NULL and if error thrown
 // Test negative boundary and too large integer boundary
@Test
public void testConstructor1() {
	
     /*Map theMap;

     System.out.println("TESTING CONSTRUCTOR");

     try {
         theMap = new Map(-1,-1);
         System.out.println("Error! Width=-1 and Height=-1 not valid *****");
     } catch(Exception e) {
         // This throw is expected. If thrown then good. No error message
     }

     try {
         theMap = new Map(5,-1);
         System.out.println("Error! Height=-1 not valid *****");
     } catch(Exception e) {
         // This throw is expected. If thrown then good. No error message
     }

     try {
         theMap = new Map(10,10);
         // No message printed out since this is expected and correct.
     } catch(Exception e) {
         System.out.println("Error! Width 10 and height 10 are valid but flagged invalid ******");
     }

     try {
         theMap = new Map(Map.MAXINT+1,Map.MAXINT+1);
         System.out.println("Error! Height and Width too large, was not captured *****");
     } catch(Exception e) {
         // This throw is expected. If thrown then good. No error message
     }

     //System.out.println("TEST END\n\n");*/
	Map theMap;
	try{
		theMap = new Map(-1,-1);
		assertTrue("Error! Width=-1 and Height=-1 not valid ",false);
	}catch(Exception e){
	}

}
@Test
public void testConstructor2(){
	Map theMap;
	try{
		theMap = new Map(5,-1);
		assertTrue("Error! Width=5 and Height=-1 not valid ",false);
	}catch(Exception e){
	}
}
@Test
public void testConstructor3(){
	Map theMap;
	try{
		theMap = new Map(10,10);
		
	}catch(Exception e){
		assertTrue("Error! Width= 10 and Height= 10 is valid ",false);
	}
}
@Test
public void testConstructor4(){
	Map theMap;
	try{
		theMap = new Map(Map.MAXINT+1,Map.MAXINT+1);
		assertTrue("Error! Width and Height is too large and not valid ",false);
	}catch(Exception e){
		
	}
}



 // Assumes: testConstructor passed !
 // The expectation is that the value stored in the location in the map is actually there
 // Will do a visual test in this case (to be different from the above)
@Test
public void testSetTerrain(){
     /*Map theMap;

     System.out.println("TESTING SET TERRAIN (visually)\nAssumes test constructor passed.");

     try {
         theMap = new Map(10, 10);

         System.out.println("Assume array size 10,10");
         System.out.println("Set -1, -1, G  == should not show");
         System.out.println("Set  5, -1, G  == should not show");
         System.out.println("Set -1,  5, G  == should not show");
         System.out.println("Set  5,  5, G  == shows");
         System.out.println("Set  5,  6, T  == should not show");
         System.out.println("Set  0,  0, G  == shows");
         System.out.println("Set  9,  9, G  == shows");
         System.out.println("Set  5,  6, #  == shows");
         System.out.println("Set  5,  7, ~  == shows");

         try { theMap.setTerrain(-1,-1,'G');} catch(Exception e){}
         try { theMap.setTerrain(5,-1,'G');} catch(Exception e){}
         try { theMap.setTerrain(-1,5,'G');} catch(Exception e){}
         try { theMap.setTerrain(5,5,'G');} catch(Exception e){}
         try { theMap.setTerrain(5,6,'T');} catch(Exception e){}
         try { theMap.setTerrain(0,0,'G');} catch(Exception e){}
         try { theMap.setTerrain(9,9,'G');} catch(Exception e){}
         try { theMap.setTerrain(5,6,'#');} catch(Exception e){}
         try { theMap.setTerrain(5,7,'~');} catch(Exception e){}

         System.out.println("\n\n" + theMap.toString() + "\n\n\n");
     } catch (Exception e) {
         System.out.println("Unable to execute test!!");
     }

     System.out.println("TEST END\n\n");*/
	Map theMap;
	try {
		 theMap = new Map(10, 10);
		 try { 
			 theMap.setTerrain(-1,-1,'G');
			 assertTrue("-1 -1 G should not be added",false);
			 //System.out.println("\n\n" + theMap.toString() + "\n\n\n");
		 } catch(Exception e){
			 
		 }
		 
	}catch(Exception e){
		assertTrue("Unable to execute test", false);
	}
	
 }
@Test
public void testSetTerrain2(){
	Map theMap;
	try {
		 theMap = new Map(10, 10);
		 try { 
			 theMap.setTerrain(-1,5,'G');
			 assertTrue("-1 5 G should not be added",false);
			 //System.out.println("\n\n" + theMap.toString() + "\n\n\n");
		 } catch(Exception e){
			 
		 }
		 
	}catch(Exception e){
		assertTrue("Unable to execute test", false);
	}
}
@Test
public void testSetTerrain3(){
	Map theMap;
	try {
		 theMap = new Map(10, 10);
		 try { 
			 theMap.setTerrain(5,-1,'G');
			 assertTrue("5 -1 G should not be added",false);
			 //System.out.println("\n\n" + theMap.toString() + "\n\n\n");
		 } catch(Exception e){
			 
		 }
		 
	}catch(Exception e){
		assertTrue("Unable to execute test", false);
	}
}
@Test
public void testSetTerrain4(){
	Map theMap;
	try {
		 theMap = new Map(10, 10);
		 try { 
			 theMap.setTerrain(5,5,'G');
			 
		 } catch(Exception e){
			 assertTrue("5 5 G should be added",false);
			 //System.out.println("\n\n" + theMap.toString() + "\n\n\n");
		 }
		
	}catch(Exception e){
		assertTrue("Unable to execute test", false);
	}
}
@Test
public void testSetTerrain5(){
	Map theMap;
	try {
		 theMap = new Map(10, 10);
		 try { 
			 theMap.setTerrain(5,  6, 'T');
			 assertTrue("5 5 G should not be added",false);
			 //System.out.println("\n\n" + theMap.toString() + "\n\n\n");
		 } catch(Exception e){
		 }
		
	}catch(Exception e){
		assertTrue("Unable to execute test", false);
	}
}
@Test
public void testSetTerrain6(){
	Map theMap;
	try {
		 theMap = new Map(10, 10);
		 try { 
			 theMap.setTerrain(0,0,'G');
			 
		 } catch(Exception e){
			 assertTrue("0 0  G should be added",false);
			 //System.out.println("\n\n" + theMap.toString() + "\n\n\n");
		 }
		
	}catch(Exception e){
		assertTrue("Unable to execute test", false);
	}
}
@Test
public void testSetTerrain7(){
	Map theMap;
	try {
		 theMap = new Map(10, 10);
		 try { 
			 theMap.setTerrain(9,9,'G');
			 
		 } catch(Exception e){
			 assertTrue("9 9 G should be added",false);
			 //System.out.println("\n\n" + theMap.toString() + "\n\n\n");
		 }
		
	}catch(Exception e){
		assertTrue("Unable to execute test", false);
	}
}
@Test
public void testSetTerrain8(){
	Map theMap;
	try {
		 theMap = new Map(10, 10);
		 try { 
			 theMap.setTerrain(5,6,'#');
			 
		 } catch(Exception e){
			 assertTrue("5 5 # should be added",false);
			 //System.out.println("\n\n" + theMap.toString() + "\n\n\n");
		 }
		
	}catch(Exception e){
		assertTrue("Unable to execute test", false);
	}
}
@Test
public void testSetTerrain9(){
	Map theMap;
	try {
		 theMap = new Map(10, 10);
		 try { 
			 theMap.setTerrain(5,7,'~');
			 
		 } catch(Exception e){
			 //System.out.println("\n\n" + theMap.toString() + "\n\n\n");
			 assertTrue("5 7 ~ should be added",false);
			 
		 }
		
	}catch(Exception e){
		assertTrue("Unable to execute test", false);
	}
}


 // Assumes: test set terrain passed
 // The expectation is that the full array displays
 // No special testing, expecting to see all water.
@Test
public void testToString1(){
     /*Map theMap;

     System.out.println("TESTING TO STRING (visually)\nAssumes test set terrain passed.");

     try {
         theMap = new Map(10, 10);

         System.out.println("Assume array size 10,10");
         System.out.println("We should see 100 water cells in 10 by 10");
         System.out.println("\n\n" + theMap.toString() + "\n\n\n");
     } catch (Exception e) {
         System.out.println("Unable to execute test!!");
     }

     System.out.println("TEST END\n\n");*/
	Map theMap;
	try {
		theMap = new Map(10,10);
		String refMap = "Terrain:\n\n";
		for (int k = 0; k < 10; k ++){//Create the map to be compared
			for (int l = 0; l < 10; l++){
				refMap = refMap + " " +'~';
			}
			refMap = refMap + "\n";
		}
		
		assertTrue("toString not giving exepected value: " + refMap ,theMap.toString().equals(refMap));
		
	}catch(Exception e){
		assertTrue("Unable to execute test",false);
	}
}

}
