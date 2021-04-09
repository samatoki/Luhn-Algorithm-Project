import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
class CustomerSystem{
    public static void main(String[] args) throws FileNotFoundException {
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below


        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)){
                
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                enterCustomerInfo();
            }
            else if (userInput.equals(generateCustomerOption)) {
                System.out.println("Now creating a data file for customer.");
                generateCustomerDataFile();
            }
            else{
                System.out.println("Please type in a valid option (A number from 1-9)");
            }

        } while (!userInput.equals(exitCondition));         // Exits once the user types 
        
        reader.close();
        System.out.println("Program Terminated");
    }
    public static void printMenu(){
        System.out.println("Customer and Sales System\n"
        .concat("1. Enter Customer Information\n")
        .concat("2. Generate Customer data file\n")
        .concat("3. Report on total Sales (Not done in this part)\n")
        .concat("4. Check for fraud in sales data (Not done in this part)\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void enterCustomerInfo() {
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validatePostalCode(String postal) {
        
        // All the veriable i used in this method.
        Path path = path.get(C:/Users/Carter/Downloads/postal_code.csv);
        BufferedReader reader = new BufferedReader(path);
        boolean valid = false;

        // For loop the postal code
        for (int i = 0; i < postal.length(); i++){

            if (i == 0 || i == 2 || i == 5){
                if (postal.charAt(i) >= 65 && postal.charAt(i) <= 90){
                    
                }
                else
                    valid = true;

            }    
            if(i == 1 || i == 4 || i == 6){
                if (postal.charAt(i) >= 48 && postal.charAt(i) <= 57){
                    

                }
                else
                    valid = true;
            }
        }
        // Valid section.
        if (valid == true){
            System.out.println("Your postal code is not valid. Please try again.");
        }
        else
            System.out.println("That code is valid!");
        
        if (valid = path){
            System.out.println("That code is valid!");
        }
        else
            System.out.println("Your postal code is not valid. Please try again.");
            
            reader.close();
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void generateCustomerDataFile() throws FileNotFoundException {
        
        // All the varible I used in this program.
        Scanner in = new Scanner(System.in);
        File file1 = new File("Customerdata.txt");
        PrintWriter file2 = new PrintWriter(file1);
        
        // While looping the file until it was done.
        while(in.hasNextLine()){
            String line = in.nextLine();
            file2.println("First Name:" + line);
            file2.println("Last Name:" + line);
            file2.println("city:" + line);
            file2.println("Address:" + line);
            file2.println("Postal Code:" + line);
            file2.println("Card Num:" + line);
        }  
        // A program to avoid an existing file.
        if (file1.exists()){
            System.out.println("File already exists, ok to overwrite (y/n)? ");
            if (!in.nextLine().startsWith("y")){
              return;
            } 
        }
        // Close the System.
        System.out.println("All the data are done");
        file2.close();
    }

}
