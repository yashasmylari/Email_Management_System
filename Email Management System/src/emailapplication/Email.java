package emailapplication;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "yscompany.com";

    // Constructor to receive the first name and lat name
    public Email(String firstname, String lastName){
        this.firstname = firstname;
        this.lastName = lastName;
        System.out.println("Email created" + " " + this.firstname + " " + this.lastName);

        // call a method asking for the department  - return the department
        this.department = setDepartment();
        //System.out.println("Department: "+ this.department);

        // call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        // combine elements to generate email
        email = firstname.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "."+ companySuffix;
        //System.out.println("Your email is:" + email);
    }

    // Ask for the Department
    private String setDepartment() {
        System.out.println("Department Codes\n1 for sales\n2 for Development\n3 for Account\n0 for none\nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }
        // Generate a random password
        private String randomPassword(int length){
            String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";  // to get the 2 capitals , 2 non capitals , one digit and one Special character , we need to assgin it to different strings individually and put those in for loop , how do you split the length?
            char[] password = new char[length];
            for (int i=0; i<length; i++){
                int rand = (int) (Math.random() * passwordSet.length());
                password[i] = passwordSet.charAt(rand);
            }
            return new String(password);
        }

        // Set the mailbox Capactiy

    public void setMailboxCapacity(int capacit){
        this.mailBoxCapacity = capacit;

    }

        // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

        // Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailBoxCapacity(){ return mailBoxCapacity;}
    public String getAlternateEmail(){ return alternateEmail;}
    public String getPassword(){ return password;}

    public String showInfo(){
        return "Display Name:" + firstname + " " + lastName + "\nCompany email:" + email + "\nMailbox Capacity:" + mailBoxCapacity;
    }
}
