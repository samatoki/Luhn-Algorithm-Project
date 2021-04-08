/*
 * Date: Apr 2, 2021
 * Name: Yuyang Liu, Carter Li
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
                String generalInfo = "blank";
                System.out.println(enterCustomerInfo(generalInfo));
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
     * Description: stores customers information into the system
     * 
     * @param generalInfo
    */
    public static String enterCustomerInfo(String generalInfo) {
        Scanner readCustomerInfo = new Scanner(System.in);
        String firstName, lastName, city;
        String postalCode = "blank", creditCardNum = "blank";  // initialize the variables

        System.out.print("First Name: ");
        firstName = readCustomerInfo.nextLine();
        System.out.println();

        System.out.print("Last Name: ");
        lastName = readCustomerInfo.nextLine();
        System.out.println();

        System.out.print("City: ");
        city = readCustomerInfo.nextLine();
        System.out.println();
/*
        boolean PCValidityCheck = true;
        while(PCValidityCheck = true){
            System.out.print("Postal Code: ");
            postalCode = readCustomerInfo.nextLine();
            System.out.println();
            validatePostalCode();
        }
*/

        boolean reinputRequir = true;
        while(reinputRequir = true){
            System.out.print("Credit Card Number: ");
            creditCardNum = readCustomerInfo.nextLine();
            System.out.println();
            validateCreditCard(creditCardNum, reinputRequir);
        }

        String space = " ";
        generalInfo = firstName + space + lastName + space + city + space + postalCode + space + creditCardNum;

        readCustomerInfo.close();
        return generalInfo;
    }

    public static void validatePostalCode(){

    }

    public static void validateCreditCard(String creditCardNum, boolean reinputRequir){
        boolean invalidInput = false;
        int len = creditCardNum.length();

        // reverse the order of the digits
        String reversedCardNum = reverseDigits(creditCardNum);

        // sum odd digits
        String sum1 = reversedCardNum;
        sum1 = sumOdd(sum1);

        // double and sum the even digits
        String sum2 = reversedCardNum;
        sum2 = sumEven(sum2);

        // add sum1 and sum2 to check the validity of the original number
        int sum = Integer.parseInt(sum1) + Integer.parseInt(sum2);
        String CCValidityKey = String.valueOf(sum);
        int keyLen = CCValidityKey.length();


        do{
            if(len < 9){
                System.out.println("Invalid credit card number. Must be at least 9 characters in length. Please try again.");
                reinputRequir = true;
                invalidInput = true;
            }
            else{
                if (CCValidityKey.charAt(keyLen) != 0){
                    System.out.println("Invalid credit card number. Please try again.");
                    reinputRequir = true;
                    invalidInput = true;
                }
                else{
                    reinputRequir = false;
                    invalidInput = true;
                }
            }
        }while(invalidInput = false);
        
    }

    public static void generateCustomerDataFile(){
    }

    public static String reverseDigits(String creditCardNum){
        String oriD, newD, reversedNum;
        int len = creditCardNum.length();

        char oriDigit = creditCardNum.charAt(0);
        oriDigit = creditCardNum.charAt(len-1);
        oriD = String.valueOf(oriDigit);

        reversedNum = oriD;
        
        for (int i = (len - 2); i > 0; i--){
            char newDigit = creditCardNum.charAt(i);
            newD = String.valueOf(newDigit);
            reversedNum += newD;
        }
        creditCardNum = reversedNum;
        return creditCardNum;
    }

    public static String sumOdd(String sum1){
        int sum = 0;
        for (int i = 0; i < (sum1.length()-1); i++){
            char digit = sum1.charAt(i);
            int unknownDigit = Integer.valueOf(digit);
            if (unknownDigit %2 != 0){
                sum += unknownDigit;
            }
        }
        sum1 = String.valueOf(sum);
        return sum1;
    }

    public static String sumEven(String sum2){
        int sum = 0;
        for (int i = 0; i< (sum2.length()-1); i++){
            if (i % 2 != 0){
                char digit = sum2.charAt(i);
                int evenDigit = Integer.valueOf(digit);
                sum += evenDigit * 2;

                if (sum > 9){
                    sum -= evenDigit * 2;
                    int unit = (evenDigit * 2) % 10;
                    int decade = (evenDigit * 2 - unit) / 10;
                    evenDigit = unit + decade;
                    sum += evenDigit;
                }
            }
        }
        sum2 = String.valueOf(sum);
        return sum2;
    }
}