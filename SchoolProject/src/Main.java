import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> courses = new ArrayList<>();
        School vanTech = new School( "Van Tech", true,"narrow-way and 999th north street",
    courses);

        // this block of code creates all the teachers
        System.out.println("Teachers:");
        Teacher mrKane = new Teacher("Elias", "Kane" , "Math");
        Teacher msBurns = new Teacher("Elissa", "Burns" , "Science");
        Teacher mrEden = new Teacher("Cal", "Eden" , "English");

        // this block of code adds all the new teachers to the list of students
        vanTech.teacherAdder(mrKane);
        vanTech.teacherAdder(msBurns);
        vanTech.teacherAdder(mrEden);

        // and this block of code prints out the info of all the teachers in the list
        System.out.println(mrKane.description());
        System.out.println(msBurns.description());
        System.out.println(mrEden.description());

        // this line tells you how many teachers there are
        System.out.println("there are " + vanTech.teachers.size() + " teachers");

        // this block removes a teacher then says that there is 1 less teacher in the list, then prints the new list
        vanTech.teacherDeleter(mrKane);
        System.out.println("the target has been eliminated, there are now " + vanTech.teachers.size() + " teachers, they are:");
        vanTech.teacherPrinter();

        // this line is just to make the output look nicer
        System.out.println("\n\n");

        // this block of code creates all the students
        System.out.println("Students:");
        Student gregJames = new Student("Jefferey", "James", 8);
        Student alfredoGreen = new Student("Alfredo", "Green", 8);
        Student jesseMcKnight = new Student("Jesse", "McKnight", 8);
        Student alexVegh = new Student("Ali", "Vegh", 8);
        Student simonCambell = new Student("Simon", "Cambell", 8);
        Student niallGilron = new Student("Niall", "Gilron", 8);
        Student dominicReiter = new Student("Dominic", "Reiter", 8);
        Student solJohnstonYu = new Student("Sol", "Johnston-Yu", 8);
        Student torrenWoolard = new Student("Torren", "Woolard", 8);
        Student jaySinclair = new Student("Jay", "Sinclair", 8);

        // this block of code adds all the new students to the list of students
        vanTech.studentAdder(gregJames);
        vanTech.studentAdder(alfredoGreen);
        vanTech.studentAdder(jesseMcKnight);
        vanTech.studentAdder(alexVegh);
        vanTech.studentAdder(simonCambell);
        vanTech.studentAdder(niallGilron);
        vanTech.studentAdder(dominicReiter);
        vanTech.studentAdder(solJohnstonYu);
        vanTech.studentAdder(torrenWoolard);
        vanTech.studentAdder(jaySinclair);

        // and this block of code prints out the info of all the students in the list
        System.out.println(gregJames.studentDescription());
        System.out.println(alfredoGreen.studentDescription());
        System.out.println(jesseMcKnight.studentDescription());
        System.out.println(alexVegh.studentDescription());
        System.out.println(simonCambell.studentDescription());
        System.out.println(niallGilron.studentDescription());
        System.out.println(dominicReiter.studentDescription());
        System.out.println(solJohnstonYu.studentDescription());
        System.out.println(torrenWoolard.studentDescription());
        System.out.println(jaySinclair.studentDescription());

        // this line tells you how many students there are
        System.out.println("there are " + vanTech.students.size() + " students");

        // this block removes two students then says that there are 2 less students in the list, then prints the new list
        vanTech.studentDeleter(gregJames);
        vanTech.studentDeleter(alfredoGreen);
        System.out.println("the targets have been eliminated, there are now " + vanTech.students.size() + " students, they are:");
        vanTech.studentPrinter();
    }
}
