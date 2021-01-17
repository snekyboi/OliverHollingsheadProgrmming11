import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Teacher {
    String firstName =  new String();
    String lastName =  new String();
    String subject =  new String();

    Teacher(String firstName, String lastName, String subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }
    public String description(){
        return "Name: " + firstName + " " + lastName + " Subject: " + subject;
    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
}
