package uml.fms.my.sdf;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {

    Map<String, Person> persons = new HashMap<String, Person>() {
        {
            // Teachers
            put("T1", new Teacher("Dupont", "Jean", 35,
                    LocalDate.parse("2025-05-25"),
                    "rue du code", "Code city", 33450));

            put("T2", new Teacher("Bertrand", "Paul", 35,
                    LocalDate.parse("2024-07-12"),
                    "rue des hortensias", "Bruges", 64530));

            put("T3", new Teacher("Ali", "Mohamed", 40,
                    LocalDate.parse("2025-06-14"),
                    "rue du Louvre", "Paris", 75056));

            // Students
            put("S1", new Student(1, "Dubois", "Sophie", 31,
                    "avenue de Java", "Java Valley", 75001));
            put("S2", new Student(2, "Lefebvre", "Antoine", 45,
                    "boulevard Python", "Snake City", 69000));
            put("S3", new Student(3, "Martinez", "Camille", 24,
                    "rue du Script", "Node Town", 44000));
            put("S4", new Student(4, "Rousseau", "Nicolas", 38,
                    "impasse Git", "Commit City", 33000));
            put("S5", new Student(5, "Garnier", "Isabelle", 52,
                    "allée du Debug", "Bug Free", 13000));
            put("S6", new Student(6, "Nakamura", "Sakura", 28,
                    "avenue de Java", "Java Valley", 75001));
            put("S7", new Student(7, "Patel", "Priya", 26,
                    "rue du Script", "Node Town", 44000));
            put("S8", new Student(8, "El Amrani", "Yasmine", 31,
                    "impasse Git", "Commit City", 33000));
            put("S9", new Student(9, "Diop", "Amadou", 29,
                    "place de l'API", "Rest City", 59000));
            put("S10", new Student(10, "Rodriguez", "Valentina", 27,
                    "avenue Spring", "Framework City", 67000));
        }
    };

    // Trainings
    List<Training> trainings = new ArrayList<Training>() {
        {
            Training t1 = new Training("Java",
                    LocalDate.parse("2025-10-10"),
                    LocalDate.parse("2025-11-26"));
            add(t1);

            Training t2 = new Training("Python",
                    LocalDate.parse("2025-09-22"),
                    LocalDate.parse("2025-11-26"));
            add(t2);

            Training t3 = new Training("Angular",
                    LocalDate.parse("2025-12-15"),
                    LocalDate.parse("2025-12-31"));
            add(t3);

            Training t4 = new Training("Sport",
                    LocalDate.parse("2025-12-15"),
                    LocalDate.parse("2025-12-31"));
            add(t4);
        }
    };

    // Lessons
    List<Lesson> lessons = new ArrayList<Lesson>() {
        {
            Lesson l1 = new Lesson("AlgoPython",
                    LocalDate.parse("2025-09-22"),
                    LocalDate.parse("2025-09-29"),
                    trainings.get(1), // Python
                    (Teacher) persons.get("T1")); // Dupont Jean
            add(l1);

            Lesson l2 = new Lesson("PooPython",
                    LocalDate.parse("2025-10-01"),
                    LocalDate.parse("2025-10-08"),
                    trainings.get(1), // Python
                    (Teacher) persons.get("T2")); // Bertrand Paul
            add(l2);

            Lesson l3 = new Lesson("AlgoJava",
                    LocalDate.parse("2025-11-01"),
                    LocalDate.parse("2025-11-08"),
                    trainings.get(0), // Java
                    (Teacher) persons.get("T1")); // Dupont Jean
            add(l3);

            Lesson l4 = new Lesson("PooJava",
                    LocalDate.parse("2025-11-15"),
                    LocalDate.parse("2025-11-22"),
                    trainings.get(0), // Java
                    (Teacher) persons.get("T2")); // Bertrand Paul
            add(l4);

            Lesson l5 = new Lesson("firstJavaProgram",
                    LocalDate.parse("2025-11-23"),
                    LocalDate.parse("2025-11-30"),
                    trainings.get(0), // Java
                    (Teacher) persons.get("T2")); // Bertrand Paul
            add(l5);

            Lesson l6 = new Lesson("shadowBoxing",
                    LocalDate.parse("2025-11-23"),
                    LocalDate.parse("2025-11-30"),
                    trainings.get(3), // Sport
                    (Teacher) persons.get("T3")); // Ali Mohamed
            add(l6);

            Lesson l7 = new Lesson("introductionToAngular",
                    LocalDate.parse("2025-10-01"),
                    LocalDate.parse("2025-10-08"),
                    trainings.get(2), // Angular
                    (Teacher) persons.get("T1")); // Dupont Jean
            add(l7);
        }
    };

    public static void main(String[] args) {

        Main data = new Main();
        SchoolService schoolService = new SchoolService();

        /////////////////// REGISTER STUDENTS & TEACHERS //////////////////////

        for (Person p : data.persons.values()) {
            if (p instanceof Student) {
                schoolService.registerStudent((Student) p);
            } else if (p instanceof Teacher) {
                schoolService.registerTeacher((Teacher) p);
            }
        }

        /////////////////// REGISTER TRAININGS ////////////////////////////////

        for (Training t : data.trainings) {
            schoolService.registerTraining(t);
        }

        /////////////////// REGISTER LESSONS //////////////////////////////////

        for (Lesson l : data.lessons) {
            schoolService.registerLesson(l);
        }

        /////////////////// ENROLL STUDENTS TO LESSONS ////////////////////////

        // AlgoPython : S1, S2, S3
        schoolService.enrollStudentToLesson(1, "AlgoPython");
        schoolService.enrollStudentToLesson(2, "AlgoPython");
        schoolService.enrollStudentToLesson(3, "AlgoPython");

        // PooPython : S4, S5
        schoolService.enrollStudentToLesson(4, "PooPython");
        schoolService.enrollStudentToLesson(5, "PooPython");

        // AlgoJava : S6, S7
        schoolService.enrollStudentToLesson(6, "AlgoJava");
        schoolService.enrollStudentToLesson(7, "AlgoJava");

        // PooJava : S8
        schoolService.enrollStudentToLesson(8, "PooJava");

        // firstJavaProgram : S9, S10
        schoolService.enrollStudentToLesson(9, "firstJavaProgram");
        schoolService.enrollStudentToLesson(10, "firstJavaProgram");

        // shadowBoxing : S1, S2, S3, S4
        schoolService.enrollStudentToLesson(1, "shadowBoxing");
        schoolService.enrollStudentToLesson(2, "shadowBoxing");
        schoolService.enrollStudentToLesson(3, "shadowBoxing");
        schoolService.enrollStudentToLesson(4, "shadowBoxing");

        // introductionToAngular : S5, S6, S7
        schoolService.enrollStudentToLesson(5, "introductionToAngular");
        schoolService.enrollStudentToLesson(6, "introductionToAngular");
        schoolService.enrollStudentToLesson(7, "introductionToAngular");

        /////////////////// ALL TRAININGS /////////////////////////////////////

        System.out.println("=== All trainings ===");
        for (Training t : schoolService.getAllTrainings()) {
            System.out.println(t);
        }

        /////////////////// ALL LESSONS ///////////////////////////////////////

        System.out.println("\n=== All lessons ===");
        for (Lesson lesson : schoolService.getAllLessons()) {
            System.out.println(lesson);
            System.out.println("  -> Etudiants inscrits :");
            for (Student s : lesson.getStudents()) {
                System.out.println("     - " + s.getFullName() + " (n° " + s.getNumber() + ")");
            }
            System.out.println();
        }

        /////////////////// ALL STUDENTS & LESSONS ////////////////////////////

        System.out.println("\n=== All students & lessons ===");
        for (Student s : schoolService.getAllStudents()) {
            System.out.println(s);
            System.out.println("  -> Cours :");
            for (Lesson l : s.getLessons()) {
                System.out.println("     - " + l.getName());
            }
            System.out.println();
        }

        /////////////////// ALL ADDRESSES /////////////////////////////////////

        System.out.println("\n=== All addresses ===");
        Set<Address> addresses = schoolService.getAllAddresses();
        for (Address address : addresses) {
            System.out.println(
                    address.getRoad() + ", " +
                            address.getZipCode() + " " +
                            address.getCity());
        }

        /////////////////// ADDRESSES SEARCH EXAMPLES ///////////////////////////////

        System.out.println("\n=== Persons living in 'Java Valley' ===");
        List<Person> cityResult = schoolService.findPersonsByCity("Java Valley");
        for (Person p : cityResult) {
            System.out.println(p.getFullName() + " - " +
                    p.getRoad() + ", " + p.getZipCode() + " " + p.getCity());
        }

        System.out.println("\n=== Persons with zip code 33000 ===");
        List<Person> zipResult = schoolService.findPersonsByZipCode(33000);
        for (Person p : zipResult) {
            System.out.println(p.getFullName() + " - " +
                    p.getRoad() + ", " + p.getZipCode() + " " + p.getCity());
        }
        System.out.println("\n=== Persons living in Gironde ===");
        List<Person> departmentResult = schoolService.findPersonsByDepartment(33);
        for (Person p : departmentResult) {
            System.out.println(p.getFullName() + " - " +
                    p.getRoad() + ", " + p.getZipCode() + " " + p.getCity());
        }
    }
}
