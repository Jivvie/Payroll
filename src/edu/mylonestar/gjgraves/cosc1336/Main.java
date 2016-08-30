package edu.mylonestar.gjgraves.cosc1336;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Payroll myPayRoll;
        final String ERROR = "Your data is incorrect. Please make sure all data is correct. Check Documentation for " +
                "questions, concerns, or help. Program is restarting...";
        final String MISMATCH_ERROR = "You did not enter a number.";
        /*This boolean variable makes sure our data is fine. If our data is okay and no errors were found
        * we can set this to true.*/
        boolean dataIsFine = false;
        boolean numbersAreValid = true;
        int hours;
        double payRate;
        ///If user enters invalid data, we allow them to retry.
        while (!dataIsFine) {
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Enter your Name: ");
            String name = myScanner.nextLine();
            System.out.println("Enter your ID Number: ");
            String id = myScanner.nextLine();
            System.out.println("Enter your number of Hours: ");
            /* Our try and catch blocks below makes sure our user does not enter a letter for an INT or a DOUBLE.
            * If the user does this, our program sets the numerical data to be -1.
            * If you assumed this would make our loop repeat, you would be correct. Even if the user did this for hours
            * by accident, data for pay-rate would have to be entered. This means the user still has to input necessary
            * data after; which is an inconvenience for them. I will be working on a workaround implementation. */
            try {
                hours = myScanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(MISMATCH_ERROR);
                hours = -1;
            }
            System.out.println("Enter your Rate Of Pay: ");
            try {
                payRate = myScanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println(MISMATCH_ERROR);
                payRate = -1;
            }
            ///check if numbers are valid and let this variable equals the boolean value.
            ///For questions: (See Main.Java)
            numbersAreValid = Payroll.numbersAreLegit(hours, payRate);
            /*If everything is fine and all data is legit, run the if statement, creating an instance of our Payroll
            * class.
            * we want:
            * hasInvalidCharacters = false
            * hasInvalidId = false
            * nameIsInvalid = false
            * numbersAreValid = true
            * If the above constraints are not met, the Payroll instance will not be created and
            * dataIsFine will be false. The program will restart. */
            if (!Payroll.hasInvalidCharacters(name) && !Payroll.hasInvalidId(id) && !Payroll.nameIsInvalid(name)
                    && numbersAreValid) {
                final JPanel panel = new JPanel();
                dataIsFine = true;
                /// Static method application for our Payroll instance. (See Main.Java for documentation)
                myPayRoll = Payroll.doPayroll(name, id, hours, payRate);
                ///Show the information via a Java panel
                JOptionPane.showMessageDialog(panel, "Name: " + myPayRoll.getName() +
                        " \nID: " + myPayRoll.getId() + " \nHours: " + myPayRoll.getHours() + " " +
                        "\nPay Rate: " + myPayRoll.getRate());
            } else {
                System.out.println(ERROR);
                //final JPanel panel = new JPanel();
                //JOptionPane.showMessageDialog(panel, ERROR, "Error", JOptionPane.ERROR_MESSAGE);
                //panel.setVisible(false);
            }

        }
    }
}
