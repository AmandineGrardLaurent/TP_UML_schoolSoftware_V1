package uml.fms.my.sdf;
import java.util.Date;

public class Lesson {
	private String name;
	private Date startDate;
	private Date endDate;
	private String training;
	private String teacherName;
	
	private String DEFAULT_TEACHER = "unknown";

	public Lesson(String name, Date startDate, Date endDate, Training training, Teacher teacher) {
		setName(name);
		setStartDate(startDate);
		setEndDate(endDate);
		this.training = training.getTrainingName();
		this.teacherName = teacher.getFullName();
	}
	
	public Lesson(String name, Date startDate, Date endDate, Training training) {
		setName(name);
		setStartDate(startDate);
		setEndDate(endDate);
		this.training = training.getTrainingName();
		this.teacherName = DEFAULT_TEACHER;
	}
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	public String toString() {
		return "Cours de " 
				+ this.name + " de la formation " 
				+ this.training + " : du " 
				+ this.startDate + " au "
				+ this.endDate + " avec "
				+ this.teacherName;
	}
	
}
