class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getId() { return id; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("Student ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Grade: " + student.getGrade());
    }
}

class StudentController {
    private Student student;
    private StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    public void updateView() {
        view.displayStudentDetails(student);
    }

    public void setStudentName(String name) {
        student.setName(name);
    }

    public void setStudentGrade(String grade) {
        student.setGrade(grade);
    }
}

public class MVCPattern {
    public static void main(String[] args) {
        Student student = new Student("Ravi", 101, "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();

        controller.setStudentName("Rakesh");
        controller.setStudentGrade("A+");

        System.out.println("\nAfter update:");
        controller.updateView();
    }
}
