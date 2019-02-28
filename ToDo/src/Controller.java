//import java.util.List;

public class Controller {

	/* Member variables */
	
    ConsoleUtils consoleUtils;
    ToDoList todoList;
    
    /* Constructor */
    
    public Controller(){
    	this.todoList = new ToDoList();
    	this.consoleUtils = new ConsoleUtils();
  
    }
    
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
            	//System.out.println("Perform the list action");
            	processListAction(actionParts);

            } else if (action.equals("listc")) {

               //perform list only items with completed status
            	System.out.println("Perform the list only completed items action");

            } else if (action.equals("listnc")) {

               //perform list only items with status of NOT completed.
            	System.out.println("Perform the list NOT completed items action");

            } else if (action.equals("add")) {

                //perform add item action.
            	//System.out.println("Perform the add item action");
            	processAddItem();
            	
            } else if (action.equals("del")) {

                //perform delete action and passing the second item in the response
            	//System.out.println("Perform the delete item action");
            	processDeleteAction(actionParts);
            	
            } else if (action.equals("mc")) {

                //perform mark item as complete passing the second item in the response.
            	System.out.println("Perform the mark complete action");
	
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
                
            } // end of 
            
        }
        
    }
	
    public void processListAction(String[] actionParts){
        
        if(actionParts.length > 3){
            consoleUtils.error("Too many inputs to list command");
            return;
        }

		consoleUtils.printList(todoList.list());
    }
    
    
	public void processAddItem() {
		String stringId = consoleUtils.promptString("Please enter the id:");
		int id = Integer.parseInt(stringId);
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

        int id = Integer.parseInt(actionParts[1]);
		
        todoList.delete(todoList.get(id));
    }
	
}
