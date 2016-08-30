package edu.mylonestar.gjgraves.cosc1336;

/**
 * Created by Gjvon on 8/29/16.
 * <p>
 * Currently, this class has many Warnings through IntelliJ and I am working on getting those fixed. However can
 * be ignored.
 *
 * This class does not allow directly building an instance of Payroll. Instead, a static factory method is used.
 * This is built to keep code from indirectly being accessed and to keep an instance of Payroll from being created if
 * data is wrong.
 */
public class Payroll {
    private String id;
    private String name;
    private int hours;
    private double rate;

    // Constructor is never used. Currently here for class flavor: grade requirements
    public Payroll() {

    }

    /*
    * Default implemented constructor takes four arguments that will directly access and modify private values.
    */
    public Payroll(String n, String id, int h, double r) {
        name = n;
        this.id = id;
        hours = h;
        rate = r;
    }

    /*Static factory method that will build an instance of our Payroll class. This instance will be returned;
    given to a variable created in our Main class: Main.java
    Note that this instance will not be built unless all data is correct. */
    public static Payroll doPayroll(String name, String id, int h, double r) {
        //call to default constructor and create an indirect instance of Payroll.
        Payroll myPayroll = new Payroll(name, id, h, r);
        //return instance
        return myPayroll;
    }

    /*Static method that does not run with an instance of our Payroll object.
    * This method returns true if the name our user entered is empty. This concludes that his/her name is invalid,
    * thus forcing them to retype information. */
    public static boolean nameIsInvalid(String name) {
        if (name.isEmpty()) {
            return true;
        } else {
            //if the name is not empty, allow the user to proceed by returning false.
            return false;
        }
    }

    /*Check if user entered numbers that we are "okay" with. We are not okay with:
    * A: Numbers less than 0
    * B: Hours greater than 80.
    * C: Pay-rates greater than 25. (We are not that wealthy)
    * If everything falls within our constraints, returning true allows the user to proceed. */
    public static boolean numbersAreLegit(int hours, double payRate) {
        if (hours < 0 || hours > 80) {
            return false;
        } else if (payRate < 0 || payRate > 25) {
            return false; //We do not pay the user this much.
        } else {
            return true;
        }
    }

    /*This is a fun way of checking if the name entered is actually a name. We do not want none of that #hashtag
    * and underscore mess.*/
    public static boolean hasInvalidCharacters(String s) {
        /* Here we create a char array that will only hold the length of the elements upon the string.
        * for instance, let us assume we pass the string "Gjvon" (not including quotations) to our hasInvalidCharacters
        * method. Our char array will hold 5 values: [G][J][V][O][N] but start from index = 0.
        * Our method returns false after looping through our array and finding no invalid characters.*/
        char[] array = s.toCharArray();
        int length = array.length;
        /* Loop through the entire array checking if there is an invalid character. If an invalid character is ever
         * found, we do not care about the rest of the name, the name is false.  */
        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(array[i])) {
                return true;
            }
        }
        return false;
    }

    /*This method checks if our user has entered an invalid ID. His/Her ID should be in the format LLNNNN
    * Where L = Letter and N = Number. Example: Gjvon1234
    * The ID will be passed to our method. Our method will return true if the ID is invalid. */
    public static boolean hasInvalidId(String s) {
        /// We first check if the length of our string is more (or less) than our format allows. Do not proceed
        ///otherwise. Returning true will stop the function from going further. Below makes our code unnecessary,
        ///but this if statement could sometimes make our program run faster, albeit rare.
        if (s.length() != 6) {
            return true; //invalid size of string
        }
        ///Char array to hold characters in ID.
        char[] array = s.toCharArray();
        int length = array.length;
        /* For loop that lets us loop through our array of characters. It may seem bad on processing but if we look
        * closely, our code still runs in constant time O(n) because we only work(do comparisons) on each array element
        * once.
        * This is what we mean by, the if statement above this code could be useless. But it makes no sense to run
        * our for loop if the user entered a million characters. */
        for (int i = 0; i < 2; i++) {
            //Check for [L][L] Format
            if (!Character.isLetter(array[i])) {
                return true;
            }
            for (int j = 2; j < s.length(); j++) {
                //Check for NNNN Format
                // if character is not a digit, anywhere in our "wanted" format, return true. There is no need to go on.
                if (!Character.isDigit(array[j])) {
                    return true;
                }
            }

        }
        /// Everything is fine and format is good.
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


}
