import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> courses = new ArrayList<>();
        School vanTech = new School( "Van Tech", true,"narrow-way and 999th north street",
    courses);
        System.out.println(vanTech);

        Teacher mrBob = new Teacher("Fred", "Smith" , "Math");
        vanTech.teacherAdder(mrBob);
        vanTech.teacherAdder(mrBob);
        vanTech.teacherAdder(mrBob);
        vanTech.teacherAdder(mrBob);
        vanTech.teacherAdder(mrBob);
        System.out.println(mrBob.description());
        System.out.println("there are " + vanTech.teachers.size() + " teachers");

        vanTech.teacherDeleter(mrBob);
        System.out.println("the target has been eliminated, there are now " + vanTech.teachers.size() + " teachers");


        System.out.println("\n\n");


        Student jefferyJames = new Student("Jefferey", "James", 8);
        Student alfredoGreen = new Student("Alfredo", "Green", 8);
        vanTech.studentAdder(jefferyJames);
        vanTech.studentAdder(alfredoGreen);
        vanTech.studentAdder(jefferyJames);
        vanTech.studentAdder(alfredoGreen);
        vanTech.studentAdder(jefferyJames);
        System.out.println(jefferyJames.studentDescription());
        System.out.println("there are " + vanTech.students.size() + " students");

        vanTech.studentDeleter(jefferyJames);
        System.out.println("the target has been eliminated, there are now " + vanTech.students.size() + " students");
    }
}
