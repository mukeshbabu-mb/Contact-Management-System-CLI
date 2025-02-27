import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // Your Code goes here!
        Contact.start();
    }
}

// This Contact class is the Entry point for all the Features 
class Contact{

    public static void start(){
        boolean key = true;
        while(key){
            String value = UserInput.input();
            switch(value){
                case "add" : ContactManagement.add();
                    break;
                case "view" : ContactManagement.view();
                    break;
                case "exit" : key = false;
                    break;
                default : System.out.println("---- Wrong Keyword ----");
            }
        }
    }

}

// This ContactManagement class is Responsible for Contact Management( CURD Operation ) 
class ContactManagement extends ContactDB {

    public static void add(){
        String contactName = UserInput.userName();
        long contactNumber = UserInput.userNumber();
        contacts.add(new Person(contactName, contactNumber));
        System.out.println("---- Contact Added ----\n");
    }
    
    public static void view(){
        System.out.println("        Contact List        ");
        if(!contacts.isEmpty()){
            for(Person person : contacts){
                System.out.println(person.toString());
            }
        }else{
            System.out.println("   ---- Contact Empty ----\n");
        }
    }
}

// ContactDB class is act as Database
class ContactDB{
  static ArrayList<Person> contacts = new ArrayList<Person>();
}

// UserInput class is Responsible for all User Input Opertion.
class UserInput{
    private static Scanner scan = new Scanner(System.in);
    
    public static String input(){
        System.out.print(">> ");
        String value = scan.next();
        return value;
    }

    public static String userName(){
        System.out.print("Name : ");
        String value = scan.next();
        return value;
    }

    public static long userNumber(){
        System.out.print("Number : ");
        long value = scan.nextLong();
        return value;
    }
}


// Person POJO class
class Person{

    private String personName;
    private long personPhoneNumber;

    public Person(){ }

    public Person(String personName, long personPhoneNumber){
        this.personName = personName;
        this.personPhoneNumber = personPhoneNumber;
    }

    // Getters and Setters
    public void setpersonName(String personName){
        this.personName = personName;
    }

    public String getpersonName(){
        return personName;
    }

    public void setpersonPhoneNumber(long personPhoneNumber){
        this.personPhoneNumber = personPhoneNumber;
    }

    public long getpersonPhoneNumber(){
        return this.personPhoneNumber;
    }

    public String toString(){
        return "Name : "+personName+" , Phone Number : "+personPhoneNumber;
    }

}