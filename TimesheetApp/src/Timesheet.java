import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Timesheet {
	//class that stores time sheet entries "database"
	
	//Attributes
	List<TimesheetEntry> database;
	
	//constructors
	public Timesheet() {
		database = new ArrayList<>();
	}

	//getters and setters
	public List<TimesheetEntry> getDatabase() {
		return database;
	}

	public void setDatabase(List<TimesheetEntry> database) {
		this.database = database;
	}
	
    //Methods
	public List<TimesheetEntry> list() {
		//return a listing of the entire contents of the database.
		
		
		return getDatabase();
	}
	
	
	public TimesheetEntry get(int id){
		//get an entry by id
		List<TimesheetEntry> timesheet = this.getDatabase();
		TimesheetEntry retTimesheet = new TimesheetEntry(null, null);
		for (int i = 0; i < database.size(); i++) {
			TimesheetEntry currTimesheet = timesheet.get(i);
			if (currTimesheet.getId() == id) {
				retTimesheet = currTimesheet;
				break;
			}else {
				retTimesheet = null;
			}
		}
		return retTimesheet;
	}
	
	public void delete(TimesheetEntry entry) {
		//delete the entry passed from the database
		database.remove(entry);
	}
	
	public void stop(TimesheetEntry entry) {
		//add stop time to time sheet
		LocalDateTime endTime = LocalDateTime.now();
		entry.setEndTime(endTime);
		
	}

}
