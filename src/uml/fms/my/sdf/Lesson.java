package uml.fms.my.sdf;
import java.time.LocalDate;

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
	private String trainingName;
	private String teacherName;
	
	// Constant
	private static final String DEFAULT_TEACHER = "unknown";
	
	// Constructors -----------------------------------------------------------------------------------

	/**
	 * Creates a Lesson with a teacher assigned.
	 * 
	 * @param name : The name of the lesson
	 * @param startDate : The start date of the lesson
	 * @param endDate : The end date of the lesson
	 * @param training : The training this lesson belongs to
	 * @param teacher : The teacher responsible for this lesson
	 */
	public Lesson(String name, LocalDate startDate, LocalDate endDate, Training training, Teacher teacher) {
		setName(name);
		setStartDate(startDate);
		setEndDate(endDate);
		this.trainingName = training.getTrainingName();
		this.teacherName = teacher.getFullName();
	}
	
	/**
	 * Creates a Lesson without a teacher (default teacher will be "unknown").
	 * 
	 * @param name : The name of the lesson
	 * @param startDate : The start date of the lesson
	 * @param endDate : The end date of the lesson
	 * @param training : The training this lesson belongs to
	 */
	public Lesson(String name, LocalDate startDate, LocalDate endDate, Training training) {
		setName(name);
		setStartDate(startDate);
		setEndDate(endDate);
		this.trainingName = training.getTrainingName();
		this.teacherName = DEFAULT_TEACHER;
	}
	
	// Getters - Setters -----------------------------------------------------------------------------------

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
	// Throws an exception if the new start date is after the current end date.
		if (startDate.isAfter(this.endDate)) {
	        throw new IllegalArgumentException("The start date cannot be after the end date!");
	    }
	    this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
	// Throws an exception if the new end date is before the current start date.
		if (endDate.isBefore(this.startDate)) {
	        throw new IllegalArgumentException("The end date cannot be before the start date!");
	    }
	    this.endDate = endDate;
	}
	
	// Methods -----------------------------------------------------------------------------------
	
	/**
	 * Returns a string representation of the lesson with all its details.
	 */
	@Override
	public String toString() {
		return String.format("The %s lesson of the %s training program will take place from %s to %s with %s.",
		        this.name, this.trainingName, this.startDate, this.endDate, this.teacherName);
	}
	
	/**
	 * Updates the teacher of this lesson.
	 * 
	 * @param teacher : The new teacher
	 */
	public void setTeacher(Teacher teacher) {
	    this.teacherName = teacher.getFullName();
	}
	
	/**
	 * Updates both the start and end dates of this lesson.
	 * Throws an exception if the end date is before the start date.
	 * 
	 * @param startDate : The new start date
	 * @param endDate : The new end date
	 */
	public void setDates(LocalDate startDate, LocalDate endDate) {
		if (endDate.isBefore(startDate)) {
	        throw new IllegalArgumentException("The lesson end date cannot be before the lesson start date!");
	    }
	    this.startDate = startDate;
	    this.endDate = endDate;
	}
	
}
