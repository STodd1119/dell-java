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
			ToDoItem retToDoItem = new ToDoItem(id, null, 0);
			for (int i = 0; i < database.size(); i++) {
				ToDoItem currToDoList = ToDoList.get(i);
				if (currToDoList.getId() == id) {
					retToDoItem = currToDoList;
					break;
				}else {
					retToDoItem = null;
				}
			}
			return retToDoItem;
		}
		
		public ToDoItem changeStatus(int id) {
			List<ToDoItem> ToDoList = this.getDatabase();
			ToDoItem retToDoItem = new ToDoItem(id,null, 0);
			for (int i = 0; i < database.size(); i++) {
				ToDoItem currToDoList = ToDoList.get(i);
				if (currToDoList.getId() == id) {
					retToDoItem.setCompleteFlag(1);
					//NEED TO SET THE VALUE IN THE DATABASE.  I NEED TO RETURN THE MODIFIED VALUE TO THE CALLER
					//retToDoItem = currToDoList;
					break;
				}else {
				//	retToDoItem = null;
				}
			}
			
			
			return retToDoItem;
		}
		
		
		
		public List<ToDoItem> getListByStatus (int completeFlag) {
			//get an entry by complete flag
			List<ToDoItem> retToDoList = new ArrayList<ToDoItem>();
			for (int i = 0; i < database.size(); i++) {
				ToDoItem currToDoItem = database.get(i);
				if (currToDoItem.getCompleteFlag() == completeFlag) {
					//retToDoItem = currToDoList;
					//add the item to the return list
					retToDoList.add(currToDoItem);
				}
			}
			return retToDoList;


		}
		
		public void delete(ToDoItem entry) {
			//delete the entry passed from the database
			database.remove(entry);
		}
		
		
		


	}


