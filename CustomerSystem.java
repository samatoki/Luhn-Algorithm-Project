/*
 * Date: Apr 2, 2021
 * Name: Yuyang Liu
 * Teacher: Mr. Ho
 * Description: To setup the customer information and sales analysis system for a retail company
*/

import java.util.Scanner;

public class CustomerSystem {
    public static void main(String[] args){
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
                String generalInfo = "blank";   //initialize the variable
                System.out.println("Dear Customer, the personal information you entered is: " + enterCustomerInfo(generalInfo));
            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
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
     * Description: Prompt the user to enter valid personal information
     * 
     * @param generalInfo - string value to store customer info
     * @return - a string composed of customer's name, city, postal code & credit card number
     * */
    public static String enterCustomerInfo(String generalInfo) {
        Scanner readCustomerInfo = new Scanner(System.in);
        String firstName, lastName, city;
        String postalCode = "blank", creditCardNum = "blank";  // initialize the variables

        // name input
        System.out.print("First Name: ");
        firstName = readCustomerInfo.nextLine();
        System.out.println();

        System.out.print("Last Name: ");
        lastName = readCustomerInfo.nextLine();
        System.out.println();

        // location input
        System.out.print("City: ");
        city = readCustomerInfo.nextLine();
        System.out.println();

/*      // input postal code & check for validity
        boolean PCValidityCheck;
        while(PCValidityCheck = true){
            System.out.print("Postal Code: ");
            postalCode = readCustomerInfo.nextLine();
            System.out.println();
            validatePostalCode();
        }
*/
        // input credit card number & check for validity
        boolean CCValidity;
        while(CCValidity = true){
            System.out.print("Credit Card Number: ");
            creditCardNum = readCustomerInfo.nextLine();
            if(creditCardNum.length()<9){
                System.out.println("Invalid credit card number. Must be at least 9 characters in length. Please try again.");
                CCValidity = true;
            }
            else{
                CCValidity = validateCreditCard(creditCardNum);
                break;
            }
        }

        // synthesize the individual information
        String space = " ";
        generalInfo = firstName + space + lastName + space + city + space + postalCode + space + creditCardNum;
        

        readCustomerInfo.close();
        return generalInfo;
    }

    public static void validatePostalCode(){

    }

    /*
     * Description: Check the validity of customers' credit card (Luhn Algorithm Test)
     * 
     * @param creditCardNum - a string that stores the customer's credit card number
     * @return - a boolean that indicates the validity
     * */
    public static boolean validateCreditCard(String creditCardNum){
        int len = creditCardNum.length();

        // reverse the order of the digits
        String reversedNum = String.valueOf(creditCardNum.charAt(len-1));
        for (int i = (len - 2); i >= 0; i--){
            reversedNum += String.valueOf(creditCardNum.charAt(i));
        }

        // sum odd digits
        int sum1 = 0;

        // double and sum the even digits
        int sum2 = 0;

        // find for odd and even digits & caculate the partial sum
        for (int i = 0; i< len; i++){
            if (i % 2 != 0){
                int evenDigit = Character.getNumericValue(reversedNum.charAt(i));
                sum2 += evenDigit * 2;
                if (sum2 > 9){
                    sum2 -= evenDigit * 2;
                    int unit = (evenDigit * 2) % 10;
                    int decade = (evenDigit * 2 - unit) / 10;
                    evenDigit = unit + decade;
                    sum2 += evenDigit;
                }
            }
            else{
                int oddDigit = Character.getNumericValue(reversedNum.charAt(i));
                sum1 += oddDigit;
            }
        }

        // add sum1 and sum2 to check the validity of the original number
        int sum = sum1 + sum2;
        String CCValidityKey = String.valueOf(sum); 
        int keyLen = CCValidityKey.length();
        int key = Character.getNumericValue(CCValidityKey.charAt(keyLen-1));

        // to check if the sum ends in zero
        if (key != 0){
            System.out.println("Invalid credit card number. Please try again.");
            return true;
        }
        else{
            System.out.println();
            System.out.println("Please wait for the system to upload your personal information.");
            return false;
        }
    }

    public static void generateCustomerDataFile(){
    }
}
