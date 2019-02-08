import java.time.LocalDateTime;

public class TimesheetEntry {

	private static int NEXTID = 1;
	
	//attributes
	private String projectName;
	private String task;
	private int id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	//constructor
	public TimesheetEntry (String myProject, String myTask) {
		//initialize all attributes and assigne passed values
		//increment the static ID variable so the next instance of this class will
		//have a unique ID.
		this.projectName = myProject;
		this.task = myTask;
		this.startTime = LocalDateTime.now();
		this.id = NEXTID;
		NEXTID++;
	}
	
	//getters and setters
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public static int getNEXTID() {
		return NEXTID;
	}

	
	//methods
	public void updateEndTime() {
		//if the end time is not set set it to current time.
		if (this.getEndTime() == null) {
			this.setEndTime(LocalDateTime.now());
		} else {
			//do nothing for now.
		}

	}
	
	
}
