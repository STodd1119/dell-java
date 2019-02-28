import java.util.ArrayList;
import java.util.List;

public class ToDoList {
	//class that stores time sheet entries "database"
	
		//Attributes
		List<ToDoItem> database;
		
		//constructors
		public ToDoList() {
			database = new ArrayList<>();
		}

		//getters and setters
		public List<ToDoItem> getDatabase() {
			return database;
		}

		public void setDatabase(List<ToDoItem> database) {
			this.database = database;
		}
		
	    //Methods
		public List<ToDoItem> list() {
			//return a listing of the entire contents of the database.
			
			
			return getDatabase();
		}
		
		
		public ToDoItem get(int id){
			//get an entry by id
			List<ToDoItem> ToDoList = this.getDatabase();
			ToDoItem retToDoList = new ToDoItem(id, null, 0);
			for (int i = 0; i < database.size(); i++) {
				ToDoItem currToDoList = ToDoList.get(i);
				if (currToDoList.getId() == id) {
					retToDoList = currToDoList;
					break;
				}else {
					retToDoList = null;
				}
			}
			return retToDoList;
		}
		public ToDoItem getListByStatus (int completeFlag) {
			//get an entry by id
			List<ToDoItem> ToDoList = this.getDatabase();
			ToDoItem retToDoList = new ToDoItem(completeFlag, null, 0);
			for (int i = 0; i < database.size(); i++) {
				ToDoItem currToDoList = ToDoList.get(i);
				if (currToDoList.getId() == completeFlag) {
					retToDoList = currToDoList;
					break;
				}else {
					retToDoList = null;
				}
			}
			return retToDoList;
		}
		
		public void delete(ToDoItem entry) {
			//delete the entry passed from the database
			database.remove(entry);
		}
		
		
		


	}


