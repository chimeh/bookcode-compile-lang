
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;



public class List12Tester extends junit.framework.TestCase
{

 
   public static void main(String args[])
   {

      //junit is called to test methods (gui version)
      junit.swingui.TestRunner.main(new String[] {"List12Tester"});
   
   }

   
 

   public void testAddBoolean()
   {

      //new List is created called myList
      List<String> myList = new List12<String>();

      //condition is true if element is added successfully
      assertTrue(myList.add("a"));
      assertTrue(myList.add("b"));
      assertTrue(myList.add("c"));

   }

   
   public void testAddWithParameters()
   {
      //new list is created called myList
      List<String> myList = new List12<String>();

      //Elements are added in myList at specified index
      myList.add(0, "A");
      myList.add(1, "B");
      myList.add(2, "C");

      //If the following elements are added successfully,
      //condition should return true
      assertTrue(myList.contains("A"));
      assertTrue(myList.contains("B"));
      assertTrue(myList.contains("C")); 
      
      //"D" is not in myList so condition is false
      assertTrue(!(myList.contains("D"))); 

      //Index Out of Bounds exception handled
      //when add method is used using illegal indeces
      //if index is 0 < index < list.size();
      try
      {
         myList.add(-1,"Z");
         myList.add( 9,"K"); 
         fail(" Index out of bounds. ");
      }
      catch ( IndexOutOfBoundsException e)
      {
         assertTrue(true);
      }

   }



   public void testRemove()
   {
      //new List is created
      List<String> myList = new List12<String>();

      //elements are added in list
      myList.add(0, "A");
      myList.add(1, "B");
      myList.add(2, "C");

      //element "C" is removed
      myList.remove("C");
     
      //condition is false if "C" is still in list
      assertFalse(myList.contains("C"));
      assertTrue(myList.contains("B"));
      assertTrue(myList.contains("A"));

   }

  /**
    * Short Description: removes all elements stored in list
    * Long Description: a new List is created called myList.
    * elements are added in it using add method. clear method is then
    * used with myList to remove its elements. and contains method is 
    * used to check if they were successfully removed.
    * Pre-condition: before clear method is called, myList
    * is assumed to be blank starting with index 0
    * Post-condition: after clear method is called, myList
    * is assumed to be blank and starting with index 0
    // @param  			None				 		
    // @return			None	                   
    *  @throws Exception	IndexOutOfBoundsException	
    *                   Incase an illegal index is used to add
    *			elements in myList	
    */
  
   public void testClear()
   {
      //new List created
      List<String> myList = new List12<String>();

      //elements are added in myList
      myList.add(0, "A");
      myList.add(1, "B");
      myList.add(2, "C");
    
      //myList is wiped
      myList.clear();
  
      //if specified elements are still in myList,
      //condition is false 
      assertFalse(myList.contains("A"));
      assertFalse(myList.contains("B"));
      assertFalse(myList.contains("C"));
     
      //IndexOutOfBoundsException is handled using
      //Try/Catch blocks 
      try
      { 
         myList.add(-1, "R");
         myList.add(5, "Z");
         fail(" Index ouf of bounds. ");
      } 
      catch ( IndexOutOfBoundsException e )
      {
         assertTrue(true);
      }
   }

  /**
    * Short Description: This test case method tests the equals method
    * which compares to List objects if they are equal.
    * Long Description: 3 List are created and used to test
    * the equals method. the first 2 lists (myList1 and myList2)
    * have equal length and have the same elements stored in them. the 
    * third list object (myList3) is different. equals method is used
    * to compare myList1 and myList2 and should return true. and myList3
    * is also compared to myList1 and should return false 
    * Pre-condition:  before equals method is called, myList
    * is assumed to be blank starting with index 0 
    * Post-condition: after equals method is called, the length and the
    * elements in each of the list objects should not change
    // @param 			None 			
    // @return			None	                   
    // @throws Exception	None				
    */

   public void testEquals()
   {
      // new List called myList1
      List<String> myList1 = new List12<String>();
      
      // elements are added in myList1
      myList1.add(0, "Hi");
      myList1.add(1, "There");
      myList1.add(2, "I'm");
      myList1.add(3, "John");

      // new List called myList2
      List<String> myList2 = new List12<String>();

      // elements are added in myList2
      myList2.add(0, "Hi");
      myList2.add(1, "There");
      myList2.add(2, "I'm");
      myList2.add(3, "John");

      //if myList1 is equal to myList2, condition is true
      assertTrue(myList1.equals(myList2));

      // new List called myList3
      List<String> myList3 = new List12<String>();
     
      // elements are added in myList3
      myList3.add(0, "Should");
      myList3.add(1, "Not");
      myList3.add(2, "Match");

      //if myList1 is not equal to myList3, condition is false
      assertFalse(myList1.equals(myList3));

   }
  /**
    * Short Description: this test method is used to test the 
    * get indexOf method.
    * Long Description: Returns the index of the first occurance of 
    * the element the user specified. If it does not exist, the method
    * returns -1. 
    * Pre-condition:  before equals method is called, myList
    * is assumed to be blank starting with index 0 
    * Post-condition:  after equals method is called, the length and the
    * elements in each of the list objects should not change. the equals
    * method should return the index of the element if it is found and 
    * should be equal to the index where it was initially added.
    // @param 			None					 
    // @return 			None	                   
    // @throws Exception	None		
    */

   public void testIndexOf()
   {

       //new List object
       List<String> myList = new List12<String>();

       //elements are added in myList 
       myList.add("J");
       myList.add("O");
       myList.add("H");
       myList.add("N");
    
       //if the index of the specified elements are equal
       // to the index value, condition is true
       assertTrue(myList.indexOf("J") == 0);
       assertTrue(myList.indexOf("O") == 1);
       assertTrue(myList.indexOf("H") == 2);
       assertTrue(myList.indexOf("N") == 3);

       //if the element is not found, the method should
       //return -1
       assertTrue(myList.indexOf("K") == -1);

   }

  /**
    * Short Description: this test method checks if the method
    * size works.
    * Long Description: this method creates a list. elements are added
    * into the list using the add method. the size of list should be equal
    * to the number of elements added to list. 
    * Pre-condition:  before the size method is called, list is empty and
    * index starts with 0
    * Post-condition: after running the method, the size of lize should equal
    * to the amount of elements added into it
    // @param	 		None	
    // @return			None	                
    // @throws Exception	None						
    */

   public void testSize()
   {
       //new list is created called myList
       List<String> myList = new List12<String>();
       

       //4 elements are added into myList
       myList.add(0, "A");
       myList.add(1, "B");
       myList.add(2, "C");
       myList.add(3, "D");
       
       // if the size of list is equal to the amount of elements added
       assertTrue(myList.size() == 4 );
       // test that size of list is not 0 anymore
       assertFalse(myList.size() == 0);
   

   }

  /**
    * Short Description: this test method checks ifthe set method works
    * by calling to replace the elements inside List.
    * Long Description: this method replaces the element at the specified
    * position with the specified element.
    * Pre-condition: before calling the method, list should have values
    * stored in it. the amount of elements is equal to list size
    * Post-condition: after calling the method with valid parameters,
    * the value of the element at a specified index should change
    * to the specified value.
    // @param			None
    // @return			None	                  
    *  @throws Exception	IndexOutOfBoundsException
    *			if the specified index is less than or
    *			equal/greater than the size of the list			
    */

   public void testSet()
   {
       //new list is created called myList
       List<Integer> myList = new List12<Integer>();

       //elements are added to myList
       myList.add(0, 1);
       myList.add(1, 2);
       myList.add(2, 3);
       
       //elements are changed using set method
       myList.set(0,  4);
       myList.set(1,  5);
       myList.set(2,  6);
    
       //if the index of the specified elements are inside
       //the specified index, condition is true
       assertTrue(myList.indexOf(4) == 0);
       assertTrue(myList.indexOf(5) == 1);
       assertTrue(myList.indexOf(6) == 2);

   
       // IndexOutOfBoundsException is handled using
       // Try/Catch blocks. this exception can be thrown
       // when the specified index is less than zeor or equal or
       // greater than the size
      try
      { 

         myList.set(-1, 5);
 
         myList.set(4,10);

         myList.set(-1,20);
	
         fail("Out of bounds exception. ");

      }
      catch ( IndexOutOfBoundsException e)
      {

         assertTrue(true);

      }

   }
  /**
    * Short Description: This test method checks is the isempty
    * method works.
    * Long Description: a new list is created call myList. myList
    * should be empty and is verified using the isEmpty method. an
    * element is added into myList. once again, isEmpty is called to
    * see if myList is empty. This time it should return zero.
    * Pre-condition: before the method is called myList is empty and
    * index starting at zero.	
    * Post-condition: after the method is called, myList should still be
    * the same and the method should return true
    // @param			None
    // @return			None
    // @throws	Exception	None			
    */

   public void testIsEmpty()
   {
      //new List is created called myList
      List<String> myList = new List12<String>();

       //if myList is empty, condition is true
       assertTrue(myList.isEmpty() == true);
     
       //element is added to myList
       myList.add("CSE");

       //if myList is not empty condition is true
       assertTrue(myList.isEmpty() == false);

   }

  /**
    * Short Description: This test method checks if remove, next and
    * hasNext method works .
    * Long Description: a new List is created call myList, elements are
    * added to it using the add method, an Iterator called it is called
    * that is used to traverse myList if remove method is called when
    * iterator has yet to go through the list IllegalStateException is
    * handled using Try/Catch is used. hasNext method is then used to check
    * myList if elements exist. next method is then used to move along myList
    * from beginning to end.
    * Pre-condition: before using the following methods. a List is created
    * and elements are added to it starting from index 0. 
    * Post-condition: after calling hasNext, it should return true until
    * it reaches the end of the list. next should move along the list from
    * left to right. and remove should remove the element specified by the 
    * user
    // @param		 	None				 
    // @return			 None		                   
    *  @throws Exception 	IllegalStateException
    *		          calling remove method when list is empty and,	
    *			  when calling remove twice consecutively
    *  @throws Exception	NoSuchElementException	
    *                     calling next method beyond the last element					
    */

   public void testIterator()
   {
       //new List is created call myList
       List<String> myList = new List12<String>();
  
       //elements are added to myList
       myList.add("B");
       myList.add("E");
       myList.add("E");
       myList.add("T");
       myList.add("H");
       myList.add("O");
       myList.add("V");
       myList.add("E");
       myList.add("N");


       //Iterator is created called it
       Iterator it = myList.iterator();

       // if remove method is called even before the iterator goes through
       // the list, IllegalStateException is handled using Try/Catch block
       try
       {
          
          it.remove();
          fail( "Trying to remove an element, before next method is called" );

       }

       catch (IllegalStateException e)
       {

           assertTrue(true);
       }  
    
       //hasNext method checks if elements in myList exist until it reaches
       //the end of the list 
       assertTrue(it.hasNext());

       
       //next method is used to check the values inside myList
       assertTrue((it.next()).equals("B"));
       assertTrue((it.next()).equals("E"));
       assertTrue((it.next()).equals("E"));
       assertTrue((it.next()).equals("T"));
       assertTrue((it.next()).equals("H"));
       assertTrue((it.next()).equals("O"));
       assertTrue((it.next()).equals("V"));
       assertTrue((it.next()).equals("E"));
       assertTrue((it.next()).equals("N"));
       
       //remove method is used to remove last element
       it.remove();

       //verifies that the last element is now "E"
       assertTrue(myList.get(myList.size()-1).equals("E"));

       //verifies that "N" does not exist anymore in the list
       assertTrue(myList.indexOf("N") == -1);

       //end of the list is reached.
       assertFalse(it.hasNext());

       //Exception is handled when remove method is called twice
       //in a row
       try
       {

          it.remove();
          it.remove();
          fail( "Remove method called twice" );

       }

       catch ( IllegalStateException e )
       {

           assertTrue(true);
       }

       //Exception is handled when next method is used after reaching
       //the end of list
       try
       {

          assertTrue((it.next()).equals("N"));
          fail("Trying to access element beyond List size");
    
       }

       catch ( NoSuchElementException e)
       {

          assertTrue(true);

       }

   }

  /**
    * Short Description: This test method check is the contains
    * method works.
    * Long Description: This method returns true if the list
    * contains the element specified by the user. 
    * Pre-condition: before the method is called, elements are stored
    * in list and the size of list should be equal to the amount of 
    * elements added to it.
    * Post-condition: after the method is called, list should still
    * be the same and remains unchanged, but constains should return
    * true if the specified element exist in list
    // @param		None
    // @return		None                
    // @trows Exception	None			
    */

   public void testContains()
   {

       //new list is created called myList
       List<String> myList = new List12<String>();
     
       // elements are added to myList
       myList.add("B");
       myList.add("E");
       myList.add("E");
       myList.add("T");
       myList.add("H");
       myList.add("O");
       myList.add("V");
       myList.add("E");
       myList.add("N");

       //if the specified elements exist, the condition is true
       assertTrue(myList.contains("B"));
       assertTrue(myList.contains("E"));
       assertTrue(myList.contains("T"));
       assertTrue(myList.contains("H"));
       assertTrue(myList.contains("O"));
       assertTrue(myList.contains("V"));
       assertTrue(myList.contains("N"));
       assertFalse(myList.contains("Z"));
     
   }

   /**
    * Short Description: This test method checks if the method
    * hashCode works This returns the hashcode value for the List
    * the formula for hashCode is given in the API.
    * Long Description: a new List object called myList is created. 
    * the function to calculate hashCode is written and was taken from
    * hashCode API. the value is stored in the variable called hashValue.
    * hashValue is then compared to the hashCode method. If they are equal,
    * the hashCode method is correct. 
    * Pre-condition: before calculating the hashValue for myList, list object 
    * myList is empty and the starting index is 0
    * Post-condition: after calculating the hashValue, the length and the elements
    * stored in myList is unchanged. and if calculated correctly, HashValue should
    * equal the value returned by hashCode
    // @param			None			
    // @return			None                   
    // @throws Exception	None	
    */  

   public void testHashcode()
   {
      //new List object called myList
      List<String> myList = new List12<String>();
     
      //elements are added to myList
      myList.add("A");
      myList.add("B");
      myList.add("C");
      myList.add("D");

      //hashCode value is stored in HashValue
      int hashValue = 1;

      //formula for hashCode
      Iterator<String> iterate = myList.iterator();
      
      while(iterate.hasNext())
      {
       
         String s = iterate.next();
         hashValue = 31*hashValue + (s == null ? 0 : s.hashCode());

      }
       
      //is hashvalue is equal to the value returned by hashCode method
      //condition is true
      assertTrue(hashValue == (myList.hashCode()));

   }

  /**
    * Short Description: this test method tests the get method
    * which is used to get a specific element in a list.
    * Long Description: a new List  is created called myList.
    * elements are added to myList using the add method. these elements
    * are then retrieved using the get method. the index of these elements
    * are passed ase parameters when the method is called. and exception 
    * IndexOutOfBoundsException is handled using try/cath blocks. 
    * Pre-condition: before using the get method to myList, list object 
    * myList is empty and the starting index is 0 
    * Post-condition: after calling the get method, myList should be unchanged
    * and should return the element associated with that index
    // @param			None			
    // @return			None                   
    // @throws Exception	IndexOutOfBoundsException
    *			If the index used as a parameter is out of range
    *			0 < index < = myList.size();		
    */

   public void testGet()
   {
    
      // new List called myList
      List<String> myList = new List12<String>();

      // elements are added to myList
      myList.add("C");
      myList.add("S");
      myList.add("E");
      myList.add("1");
      myList.add("2");

      //if the element is equal to element inside the specified index,
      //condition is true
      assertTrue(myList.get(0).equals("C"));
      assertTrue(myList.get(1).equals("S"));
      assertTrue(myList.get(2).equals("E"));
      assertTrue(myList.get(3).equals("1"));
      assertTrue(myList.get(4).equals("2"));
      assertFalse(myList.get(0).equals("Z"));
   
   }

}//end class
