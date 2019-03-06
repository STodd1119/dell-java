//import java.util.List;

public class Controller {

	/* Member variables */	
    ConsoleUtils consoleUtils;  //Create a variable to hold ConsoleUtils class
    ToDoList todoList;          //Create a variable to hold to do list class
    
    /* Constructor */
    public Controller(){
    	this.todoList = new ToDoList();
    	this.consoleUtils = new ConsoleUtils();
  
    }
    
    /* Methods */
    public void start() {

        consoleUtils.printHelp(); // Print the action menu
        
        boolean quit = false;
        while(!quit) {
			// Prompt the user for input, collect input, parse into parts
            String input = consoleUtils.promptString("> ");
            String[] actionParts = input.split(" ");
            String action = actionParts[0].trim(); // Primary action

			// Figure out what to do depending on the user's primary action
            if (action.equals("list")) {
                //perform list action
            	processListAction(actionParts);

            } else if (action.equals("listc")) {
               //perform list only items with completed status
            	processListCompleteAction(actionParts);

            } else if (action.equals("listnc")) {
               //perform list only items with status of NOT completed.
            	processListNotCompleteAction(actionParts);

            } else if (action.equals("add")) {
                //perform add item action.
            	processAddItem();
            	
            } else if (action.equals("del")) {
                //perform delete action and passing the second item in the response
            	processDeleteAction(actionParts);
            	
            } else if (action.equals("mc")) {
                //perform mark item as complete passing the second item in the response.
            	processMarkCompleteAction(actionParts);
	
            } else if (action.equals("q")) {
                System.out.println("Thanks for using the Todo List.  Good bye!");
            	quit = true;

            } else if (action.equals("help")) {
            	consoleUtils.printHelp();

            } else if(action.length() == 0 ){
            
                // do nothing.
                
            } else {
                // your input is not valid please try again 
            	consoleUtils.error("Your input was not valid.  Please try again!");
            	consoleUtils.printHelp();
            } 
        } // end of While loop
    }
	
    public void processListAction(String[] actionParts){
        
        if(actionParts.length > 3){
            consoleUtils.error("Too many inputs to list command");
            return;
        }

		consoleUtils.printList(todoList.list());
    }
    
    public void processListCompleteAction(String[] actionParts){
        
        if(actionParts.length > 3){
            consoleUtils.error("Too many inputs to list command");
            return;
        }
        //call get list by status method passing 1 for complete
        consoleUtils.printList(todoList.getListByStatus(1));
    }
    
    public void processListNotCompleteAction(String[] actionParts){
        
        if(actionParts.length > 3){
            consoleUtils.error("Too many inputs to list command");
            return;
        }
        //call get list by status method passing 1 for complete
        consoleUtils.printList(todoList.getListByStatus(0));
    }
    
    
    public void processMarkCompleteAction(String[] actionParts){
    	//Pass an id number and mark it complete.
    	//check actions passed
        if(actionParts.length > 2){
            consoleUtils.error("Too many inputs to stop command");
            return;
        }
        //set id requested.
        int id = Integer.parseInt(actionParts[1]);
        
        //todoList.changeStatus(id);
        todoList.database.get(id -1).setCompleteFlag(1);
 
      
    }
    
	public void processAddItem() {
		int id = 0;
		try {
			String stringId = consoleUtils.promptString("Please enter the id:");
			id = Integer.parseInt(stringId);
		}
		catch (Exception e) {
			System.out.println("Your entry needs to be a number. Please enter Help for proper syntax.  Enter add to retry.");
			return;
		}
		
	    String description = consoleUtils.promptString("Please enter a description:");
		int completeFlag = 0;
		
		ToDoItem entry = new ToDoItem(id, description, completeFlag);
		
		todoList.database.add(entry);

		
	}
    public void processDeleteAction(String[] actionParts){

        if(actionParts.length > 2){
            consoleUtils.error("Too many inputs to delete command");
            return;
        }
        int id = 0;
        try {
        	id = Integer.parseInt(actionParts[1]);
        	todoList.delete(todoList.get(id));
        }
        catch (Exception e) {
        	System.out.println("ERROR: " + e);
        	consoleUtils.error("System error.  Please check the Help command for proper syntax.");
        }
       
    }
	
}
