package uml.fms.my.sdf;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;


public class Main {


    Map<String, Person> persons = new HashMap<String, Person>() {{

        // Ajouter des teachers
        put("T1", new Teacher("Dupont", "Jean", 35, LocalDate.parse("2025-05-25"), "rue du code", "Code city", 33450));
        put("T2", new Teacher("Bertrand", "Paul", 35, LocalDate.parse("2024-07-12"), "rue des hortensias", "Bruges", 64530));
        put("T3", new Teacher("Ali", "Mohamed", 40, LocalDate.parse("2025-06-14"), "rue du Louvre", "Paris", 75056));
        
        //Ajouter des élèves
        put("S1", new Student(1, "Dubois", "Sophie", 31, "avenue de Java", "Java Valley", 75001));
        put("S2", new Student(2, "Lefebvre", "Antoine", 45, "boulevard Python", "Snake City", 69000));
        put("S3", new Student(3, "Martinez", "Camille", 24, "rue du Script", "Node Town", 44000));
        put("S4", new Student(4, "Rousseau", "Nicolas", 38, "impasse Git", "Commit City", 33000));
        put("S5", new Student(5, "Garnier", "Isabelle", 52, "allée du Debug", "Bug Free", 13000));
        put("S6", new Student(6, "Nakamura", "Sakura", 28, "avenue de Java", "Java Valley", 75001));
        put("S7", new Student(7, "Patel", "Priya", 26, "rue du Script", "Node Town", 44000));
        put("S8", new Student(8, "El Amrani", "Yasmine", 31, "impasse Git", "Commit City", 33000));
        put("S9", new Student(9, "Diop", "Amadou", 29, "place de l'API", "Rest City", 59000));
        put("S10", new Student(10, "Rodriguez", "Valentina", 27, "avenue Spring", "Framework City", 67000));

    }};

    
    List<Training> trainings = new ArrayList<Training>(){{
        Training t1 = new Training("Java", LocalDate.parse("2025-10-10"), LocalDate.parse("2025-11-26"));
        add(t1);
        Training t2 = new Training("Python", LocalDate.parse("2025-09-22"), LocalDate.parse("2025-11-26"));
        add(t2);
        Training t3 = new Training("Angular", LocalDate.parse("2025-12-15"), LocalDate.parse("2025-12-31"));
        add(t3);
    }};

    List<Lesson> lessons = new ArrayList<Lesson>(){{
        Lesson l1 = new Lesson("AlgoPython", LocalDate.parse("2025-09-22"), LocalDate.parse("2025-09-29"), trainings.get(1), (Teacher) persons.get("T1"));
        add(l1);
        Lesson l2 = new Lesson("PooPython", LocalDate.parse("2025-10-01"), LocalDate.parse("2025-10-08"), trainings.get(1), (Teacher) persons.get("T2"));
        add(l2);
        Lesson l3 = new Lesson("AlgoJava", LocalDate.parse("2025-11-01"), LocalDate.parse("2025-11-08"), trainings.get(0), (Teacher) persons.get("T1"));
        add(l3);
    }};
    
   
        public void main (String[] args) {
             

        }
}
