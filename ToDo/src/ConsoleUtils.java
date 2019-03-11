import java.util.List;
import java.util.Scanner;

public class ConsoleUtils {

	/* Member variables */
	
    private Scanner scanner;

    
    /* Constructor */
    
    public ConsoleUtils(){
        scanner = new Scanner(System.in);

    }

	/* Methods */
	
	/*
	 * Prints the menu of actions to the console
	 */
    public void printHelp(){
        System.out.println("Valid commands: ");
        System.out.println("list               list out all items in the todo list.");
        System.out.println("listc              list out only completed items in the todo list.");
        System.out.println("listnc             list out items that are NOT completed in the todo list.");
        System.out.println("add                add item to the todo list");
        System.out.println("del <item num>     delete an item from the todo list by supplying the item number.");
        System.out.println("mc <item num>      mark an item number complete.");
        System.out.println("q                  quit the app");
        System.out.println();

    }

	/*
	 * Prints an informational message to the console
	 */
    public void info(String msg){
        System.out.println("["+msg+"]");
        System.out.println();
    }

	/*
	 * Prints an error message to the console
	 */
    public void error(String msg){
        System.out.println("[ERROR: "+msg+"]");
        System.out.println();
        }

	/*
	 * Prompts the user to enter input
	 * Returns the text entered by the user
	 */
    public String promptString(String label){
        System.out.print(label+" ");
        return scanner.nextLine();
    }

	/*
	 * Prints a list of ToDoItem objects in a pretty table
	 */
    public void printList(List<ToDoItem> entries){
        int longestDescription =  11;
        int longestCompleteFlag = 11;
      

        for(ToDoItem entry : entries){
            if(entry.getDescription().length() > longestDescription){
            	longestDescription = entry.getDescription().length();
            }
            
        }

        String descriptonHeader = String.format("%"+longestDescription+"s", "Description");
        String descriptionUnderline = "";
        for(int i=0;i<longestDescription;i++){
        	descriptionUnderline+="-";
        }
        
        System.out.println(" ID | "+descriptonHeader   +" | Complete ? ");
        System.out.println("----+-"+descriptionUnderline+"-+------------");

        for(ToDoItem entry : entries){
            String description = String.format("%-"+longestDescription+"s", entry.getDescription());
            String completeFlag = "";
            if (entry.getCompleteFlag() == 1) {
            	completeFlag = String.format("%-"+longestCompleteFlag+"s", "YES");
            }else {
            	completeFlag = String.format("%-"+longestCompleteFlag+"s", "NO");
            }

            String line = String.format(" %2s | %s | %s  ", entry.getId(), description, completeFlag);
            System.out.println(line);
        }

        if(entries.size() == 1){
            System.out.println("[1 entry]");
        } else {
            System.out.println("["+entries.size()+" entries]");
        }

        System.out.println();
    }
}