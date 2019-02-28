
public class ToDoItem {
	
	//attributes
	private int id;
	private String description;
	private int completeFlag;
	
	//constructors
	public ToDoItem(int myid, String mydescription, int mycompleteFlag) {
		this.id = myid;
		this.description = mydescription;
		this.completeFlag = mycompleteFlag;
		
	}

	
	//getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCompleteFlag() {
		return completeFlag;
	}

	public void setCompleteFlag(int completeFlag) {
		this.completeFlag = completeFlag;
	}
	
	//methods
	
	
	

}
