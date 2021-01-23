

// this is where i define all the variables i will need to make a student
public class Student {
    String firstName;
    String lastName;
    int grade;
    static int studentNum = 1;
    private int studentID;

    // this is my constructor
    Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.studentID = studentNum;
        studentNum ++;
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
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    // this prints out the student's info in the specified format
    public String studentDescription(){
        return "Name: " + firstName + " " + lastName + "    " + "Grade: " + grade;
    }
}
