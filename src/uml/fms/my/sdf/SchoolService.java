package uml.fms.my.sdf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SchoolService {

    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Training> trainings = new ArrayList<>();
    private final List<Lesson> lessons = new ArrayList<>();

    ///////////// STUDENT MANAGEMENT ///////////////////////////////////

    /**
     * Create new student
     */
    public Student createStudent(int number,
            String firstName,
            String lastName,
            int age,
            String road,
            String city,
            int zipCode) {

        if (findStudentByNumber(number) != null) {
            throw new IllegalArgumentException("Student number already exists : " + number);
        }

        Student student = new Student(number, firstName, lastName, age, road, city, zipCode);
        students.add(student);
        return student;
    }

    /**
     * Find student by number
     *
     * @param number
     * @return Student or null
     */
    public Student findStudentByNumber(int number) {
        for (Student student : students) {
            if (student.getNumber() == number) {
                return student;
            }
        }
        return null;
    }

    /**
     * Returns all students
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    //////////// TEACHER MANAGEMENT ////////////////////////////////

    /**
     * Create new teacher
     */
    public Teacher createTeacher(String firstName,
            String lastName,
            int age,
            LocalDate hireDate,
            String road,
            String city,
            int zipCode) {

        Teacher teacher = new Teacher(firstName, lastName, age, hireDate, road, city, zipCode);
        teachers.add(teacher);
        return teacher;
    }

    /**
     * Find teacher by fullName
     *
     * @param fullName
     * @return Teacher or null
     */
    public Teacher findTeacherByFullName(String fullName) {
        for (Teacher teacher : teachers) {
            if (teacher.getFullName().equals(fullName)) {
                return teacher;
            }
        }
        return null;
    }

    /**
     * Returns all teachers
     */
    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teachers);
    }

    ////////////// TRAINING MANAGEMENT ///////////////////////////

    /**
     * Create new training
     */
    public Training createTraining(String trainingName,
            LocalDate startDate,
            LocalDate endDate) {

        if (findTrainingByName(trainingName) != null) {
            throw new IllegalArgumentException("Training name already exists : " + trainingName);
        }

        Training training = new Training(trainingName, startDate, endDate);
        trainings.add(training);
        return training;
    }

    /**
     * Find training by name
     *
     * @param trainingName
     * @return Training or null
     */
    public Training findTrainingByName(String trainingName) {
        for (Training training : trainings) {
            if (training.getTrainingName().equals(trainingName)) {
                return training;
            }
        }
        return null;
    }

    /**
     * Returns all trainings
     */
    public List<Training> getAllTrainings() {
        return new ArrayList<>(trainings);
    }

    /////////// LESSON MANAGEMENT ////////////////////////////////

    /**
     * Create new lesson : training & teacher
     */
    public Lesson createLesson(String lessonName,
            LocalDate startDate,
            LocalDate endDate,
            Training training,
            Teacher teacher) {

        if (training == null) {
            throw new IllegalArgumentException("Training cannot be null");
        }

        Lesson lesson = new Lesson(lessonName, startDate, endDate, training, teacher);
        // Add Lesson to training in Lesson constructor
        lessons.add(lesson);

        return lesson;
    }

    /**
     * Create new lesson : training - !teacher
     */
    public Lesson createLesson(String lessonName,
            LocalDate startDate,
            LocalDate endDate,
            Training training) {

        if (training == null) {
            throw new IllegalArgumentException("Training cannot be null");
        }

        Lesson lesson = new Lesson(lessonName, startDate, endDate, training);
        lessons.add(lesson);
        return lesson;
    }

    /**
     * Find lesson by name
     *
     * @param lessonName
     * @return Lesson or null
     */
    public Lesson findLessonByName(String lessonName) {
        for (Lesson lesson : lessons) {
            if (lesson.getName().equals(lessonName)) {
                return lesson;
            }
        }
        return null;
    }

    /**
     * Returns all lessons
     */
    public List<Lesson> getAllLessons() {
        return new ArrayList<>(lessons);
    }

    ////////// ENROLLMENT MANAGEMENT (Student <-> Lesson) /////////////////////////

    /**
     * Enroll student to Lesson
     */
    public void enrollStudentToLesson(int studentNumber, String lessonName) {

        Student student = findStudentByNumber(studentNumber);
        if (student == null) {
            throw new IllegalArgumentException("Student not found with number : " + studentNumber);
        }

        Lesson lesson = findLessonByName(lessonName);
        if (lesson == null) {
            throw new IllegalArgumentException("Lesson not found with name : " + lessonName);
        }

        lesson.addStudent(student);

        student.addLesson(lesson);
    }

    /////////// ADDRESSES MANAGEMENT ////////////////////////////////////

    /**
     * Returns all addresses
     */
    public Set<Address> getAllAddresses() {
        Set<Address> addresses = new HashSet<>();

        for (Student student : students) {
            addresses.add(student);
        }

        for (Teacher teacher : teachers) {
            addresses.add(teacher);
        }

        return addresses;
    }

    ///////////// REGISTER MOCK DATA //////////////////////////////////////

    public void registerStudent(Student student) {
        if (student == null) {
            return;
        }
        if (findStudentByNumber(student.getNumber()) != null) {
            throw new IllegalArgumentException("Student number already exists : " + student.getNumber());
        }
        students.add(student);
    }

    public void registerTeacher(Teacher teacher) {
        if (teacher == null) {
            return;
        }
        teachers.add(teacher);
    }

    public void registerTraining(Training training) {
        if (training == null) {
            return;
        }
        trainings.add(training);
    }

    public void registerLesson(Lesson lesson) {
        if (lesson == null) {
            return;
        }
        lessons.add(lesson);
    }

    //////// SEARCH PERSONS BY CITY / ZIP / DEPARTMENT ///////////////

    /**
     * Find all persons from a city
     *
     * @param city
     * @return List<Person> Teacher & Student
     */
    public List<Person> findPersonsByCity(String city) {
        List<Person> result = new ArrayList<>();

        if (city == null) {
            return result;
        }

        for (Student student : students) {
            if (city.equalsIgnoreCase(student.getCity())) {
                result.add(student);
            }
        }

        for (Teacher teacher : teachers) {
            if (city.equalsIgnoreCase(teacher.getCity())) {
                result.add(teacher);
            }
        }

        return result;
    }

    /**
     * Find all persons by zip code.
     *
     * @param zipCode
     * @return List<Person> Teacher & Student
     */
    public List<Person> findPersonsByZipCode(int zipCode) {
        List<Person> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getZipCode() == zipCode) {
                result.add(student);
            }
        }

        for (Teacher teacher : teachers) {
            if (teacher.getZipCode() == zipCode) {
                result.add(teacher);
            }
        }

        return result;
    }

    /**
     * Find all persons from a department
     *
     * @param department
     * @return List<Person> Teacher & Student
     */
    public List<Person> findPersonsByDepartment(int department) {
        List<Person> result = new ArrayList<>();

        if (department < 1 || department > 99) {
            throw new IllegalArgumentException("Invalid department code : " + department);
        }

        String deptToString = String.format("%02d", department);

        for (Student student : students) {
            String studentDept = String.valueOf(student.getZipCode()).substring(0, 2);
            if (studentDept.equals(deptToString)) {
                result.add(student);
            }
        }

        for (Teacher teacher : teachers) {
            String teacherDept = String.valueOf(teacher.getZipCode()).substring(0, 2);
            if (teacherDept.equals(deptToString)) {
                result.add(teacher);
            }
        }

        return result;
    }

}
