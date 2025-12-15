package se.chasacademy.databaser.jpastart;

import Entity.Course;
import Entity.Student;
import Entity.Teacher;
import Repository.CourseRepository;
import Repository.StudentRepository;
import Repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "Repository")

public class JPAStartApplication implements CommandLineRunner {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public JPAStartApplication(
            TeacherRepository teacherRepository,
            StudentRepository studentRepository,
            CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JPAStartApplication.class, args);
    }

    // Factory method kept for potential manual wiring/testing scenarios
    public static JPAStartApplication createJPAStartApplication(
            TeacherRepository teacherRepository,
            StudentRepository studentRepository,
            CourseRepository courseRepository) {
        return new JPAStartApplication(teacherRepository, studentRepository, courseRepository);
    }

    @Override
    public void run(String... args) {
        // Skapa lärare
        Teacher t1 = new Teacher(null, "Anna Andersson");
        Teacher t2 = new Teacher(null, "Björn Berg");
        teacherRepository.save(t1);
        teacherRepository.save(t2);

        // Skapa studenter
        Student s1 = new Student(null, "Carl Carlsson", "carl@example.com");
        Student s2 = new Student(null, "Disa Dahl", "disa@example.com");
        studentRepository.save(s1);
        studentRepository.save(s2);

        // Skapa kurs och koppla lärare + studenter (anpassa efter dina relationer)
        Course c1 = new Course();
        c1.setTitle("Java Grund");
        c1.setTeacher(t1);           // om Course har en @ManyToOne Teacher
        c1.getStudents().add(s1);    // om Course har @ManyToMany List/Set<Student>
        c1.getStudents().add(s2);

        courseRepository.save(c1);
    }
}
