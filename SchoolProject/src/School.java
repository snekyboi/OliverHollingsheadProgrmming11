import java.util.ArrayList;

    // this class creates all the initial variables to make a school
public class School {
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList <String> courses = new ArrayList<>();
    String schoolName = "";
    boolean isPublic = true;
    String location = "";

    // this is my constructor
    School(String schoolName, boolean isPublic, String location, ArrayList courses){
        this.location = location;
        this.schoolName = schoolName;
        this.isPublic = isPublic;
        this.courses = courses;
    }

    // this is the function we use in main to add a new teacher
    public void teacherAdder(Teacher newTeacher){
        teachers.add(newTeacher);
    }
    // this is the function we use in main to delete a teacher
    public void teacherDeleter(Teacher teacherToBeRemoved){
        teachers.remove(teacherToBeRemoved);
    }

    // this shows all of the elements in the teachers Arraylist
    public void teacherPrinter(){
        for ( int i = 0; i < teachers.size(); i++){
            String teacher = teachers.get(i).description();
            System.out.println(teacher);
        }
    }

    // this is the function we use in main to add a new student
    public void studentAdder(Student newStudent){
        students.add(newStudent);
    }
    // this is the function we use in main to delete a student
    public void studentDeleter(Student studentToBeRemoved){
        students.remove(studentToBeRemoved);
    }

    // this shows all of the elements in the students Arraylist
    public void studentPrinter(){
        for ( int i = 0; i < students.size(); i++){
            String student = students.get(i).studentDescription();
            System.out.println(student);
        }
    }
}
