import java.util.ArrayList;

public class School {
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList <String> courses = new ArrayList<>();
    String schoolName = "";
    boolean isPublic = true;
    String location = "";

    School(String schoolName, boolean isPublic, String location, ArrayList courses){
        this.location = location;
        this.schoolName = schoolName;
        this.isPublic = isPublic;
        this.courses = courses;
    }







    public void teacherAdder(Teacher newTeacher){
        teachers.add(newTeacher);
    }
    public void teacherDeleter(Teacher teacherToBeRemoved){
        teachers.remove(teacherToBeRemoved);
    }


    public void studentAdder(Student newStudent){
        students.add(newStudent);
    }
    public void studentDeleter(Student studentToBeRemoved){
        students.remove(studentToBeRemoved);
    }
}
