package uml.fms.my.sdf;
import java.time.LocalDate;

public class Lesson {
	
	// Attributes
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private String trainingName;
	private String teacherName;
	
	// Constant
	private static final String DEFAULT_TEACHER = "unknown";
	
	// Constructors
	public Lesson(String name, LocalDate startDate, LocalDate endDate, Training training, Teacher teacher) {
		setName(name);
		setStartDate(startDate);
		setEndDate(endDate);
		this.trainingName = training.getTrainingName();
		this.teacherName = teacher.getFullName();
	}
	
	public Lesson(String name, LocalDate startDate, LocalDate endDate, Training training) {
		setName(name);
		setStartDate(startDate);
		setEndDate(endDate);
		this.trainingName = training.getTrainingName();
		this.teacherName = DEFAULT_TEACHER;
	}
	

	// Getters Setters
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
		// vérifier format localdate
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		// vérifier que la date est bien après le début de la formation
		// vérifier format localdate
		this.endDate = endDate;
	}
	
	
	// Methods
	@Override
	public String toString() {
		return "Cours de " 
				+ this.name + " de la formation " 
				+ this.trainingName + " : du " 
				+ this.startDate + " au "
				+ this.endDate + " avec "
				+ this.teacherName;
	}
	
	public void setTeacher(Teacher teacher) {
	    this.teacherName = teacher.getFullName();
	}
	
	public void setDates(LocalDate startDate, LocalDate endDate) {
	    this.startDate = startDate;
	    this.endDate = endDate;
	}
	
	

	
}
