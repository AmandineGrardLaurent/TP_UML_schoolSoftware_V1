package uml.fms.my.sdf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The Lesson class represents a single lesson in a training program.
 *
 * Each lesson has:
 * - a name
 * - a start date
 * - an end date
 * - the name of the training it belongs to
 * - the name of the teacher in charge
 *
 * You can create a lesson with or without assigning a teacher.
 * It provides methods to update the teacher and the lesson dates.
 * The class ensures that the end date is always after the start date.
 */
public class Lesson {

	// Attributes
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;

	// Associations
	private Training training;
	private Teacher teacher;

	private final List<Student> students = new ArrayList<>();

	// Constant
	private static final String DEFAULT_TEACHER = "unknown";

	// Constructors -----------------------------------------------------------------------------------

	/**
	 * Creates a Lesson with a teacher assigned.
	 *
	 * @param name      : The name of the lesson
	 * @param startDate : The start date of the lesson
	 * @param endDate   : The end date of the lesson
	 * @param training  : The training this lesson belongs to
	 * @param teacher   : The teacher responsible for this lesson
	 */
	public Lesson(String name,
			LocalDate startDate,
			LocalDate endDate,
			Training training,
			Teacher teacher) {
		this.name = name;
		this.training = training;
		this.teacher = teacher;
		setDates(startDate, endDate);

		if (training != null) {
			training.addLesson(this); // training <-> lesson
		}
	}

	/**
	 * Creates a Lesson without a teacher (default teacher will be "unknown").
	 *
	 * @param name      : The name of the lesson
	 * @param startDate : The start date of the lesson
	 * @param endDate   : The end date of the lesson
	 * @param training  : The training this lesson belongs to
	 */
	public Lesson(String name,
			LocalDate startDate,
			LocalDate endDate,
			Training training) {
		this(name, startDate, endDate, training, null);
	}

	// Getters - Setters
	// -----------------------------------------------------------------------------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		if (startDate == null) {
			throw new IllegalArgumentException("Start date cannot be null");
		}

		if (endDate != null && startDate.isAfter(endDate)) {
			throw new IllegalArgumentException("The start date cannot be after the end date!");
		}
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		// Throws an exception if the new end date is before the current start date.
		if (endDate == null) {
			throw new IllegalArgumentException("End date cannot be null");
		}

		if (startDate != null && endDate.isBefore(startDate)) {
			throw new IllegalArgumentException("The end date cannot be before the start date!");
		}
		this.endDate = endDate;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * Updates the teacher of this lesson.
	 *
	 * @param teacher : The new teacher
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/**
	 * Updates both the start and end dates of this lesson.
	 * Throws an exception if the end date is before the start date.
	 *
	 * @param startDate : The new start date
	 * @param endDate   : The new end date
	 */
	public void setDates(LocalDate startDate, LocalDate endDate) {
		if (startDate == null || endDate == null) {
			throw new IllegalArgumentException("Start and end dates cannot be null");
		}
		if (endDate.isBefore(startDate)) {
			throw new IllegalArgumentException("The lesson end date cannot be before the lesson start date!");
		}
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public void addStudent(Student student) {
		if (student == null) {
			throw new IllegalArgumentException("Student cannot be null");
		}
		if (!students.contains(student)) {
			students.add(student);
		}
	}

	public List<Student> getStudents() {
		return new ArrayList<>(students);
	}

	@Override
	public String toString() {
		String trainingName = (training != null) ? training.getTrainingName() : "no training";
		String teacherName = (teacher != null) ? teacher.getFullName() : DEFAULT_TEACHER;

		return String.format(
				"Lesson '%s' of training '%s' from %s to %s with teacher %s",
				this.name,
				trainingName,
				this.startDate,
				this.endDate,
				teacherName);
	}
}
