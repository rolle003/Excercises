import java.util.*;
 
//  arraylist övningar
public class Practice10_1 {
   Practice10_1() {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "utf-8");

         ArrayList<String> myList = new ArrayList<>(); 
         String textinput = new String() ;		
         		 

        //Fill ArrayList with textstrings

	     int i=0;
	     boolean stopinput = false;
	     while(!stopinput)  {

              System.out.print("Sträng " + (i+1) + " > ");
//            myList[i] = sc.nextLine();
              textinput = sc.nextLine();
			  if (textinput.equals("STOPP"))  {
		     	  stopinput = true; }
       		  else    {
				  myList.add(textinput);
				  i++;
			  }
//        }
}
		
		System.out.println("Ange önskat tecken: ");
		char searchChar;
		searchChar = sc.nextLine().charAt(0);
		
// Create object
        Practice10_1 practice = new Practice10_1();
		
		practice.findArrayStrings(myList, searchChar);  //Practice 10


    }
	
	   // Find array strings 
  public void findArrayStrings(ArrayList<String> args, char searchChar) {

       int foundCounter = 0; 


	   
//  Check if searchChar exist in ArrayList	   
         boolean foundString = false;
		 boolean writeHeader = true;
		   for ( int i = 0; i < args.size() ; i++) {
		   
		     String checkString = args.get(i);
             int intAnswer = checkString.indexOf(searchChar);
		     if (intAnswer>=0)  {
				 foundString = true;
			   if (writeHeader)  {    //Check if write of header
				   
                 System.out.println("Strängarna som innehåller " + searchChar + " :");  //Write header
         	     writeHeader = false;
		  }
		  System.out.println(args.get(i)); 

      }
	 
   }
// Check if no strings found   
        if (foundString==false)  {
//          if (!foundString)  {      //Another way of setting false
         System.out.println("Ingen av strängarna innehåller " + searchChar);
		}
  


	}

}









