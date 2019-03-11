import java.time.*;

public class DriversLicense {
	//Attributes 
	 public String FirstName;
	 public String LastName;
	 public int yearDOB;
	 public int monthDOB;
	 public int dayDOB;
	 public int Height;
	 public String Gender;
    
	 //Constructor
	public DriversLicense() {
		
	}
	
	//Getters and Setters
	public String getFirstName() {
		return FirstName;
	}

	public int getYearDOB() {
		return yearDOB;
	}

	public void setYearDOB(int myYearDOB) {
		this.yearDOB = myYearDOB;
	}

	public int getMonthDOB() {
		return monthDOB;
	}

	public void setMonthDOB(int myMonthDOB) {
		this.monthDOB = myMonthDOB;
	}

	public int getDayDOB() {
		return dayDOB;
	}

	public void setDayDOB(int myDayDOB) {
		this.dayDOB = myDayDOB;
	}

	public void setFirstName(String myFirstName) {
		FirstName = myFirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String myLastName) {
		LastName = myLastName;
	}

	public int getHeight() {
		return Height;
	}

	public void setHeight(int myHeight) {
		Height = myHeight;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String myGender) {
		Gender = myGender;
	}

	//Methods
	public String getFullName() {
		/////////////////////////////////////////////////////////////////
		// Method returns: String
		// Concatenate the first and last name separated by a space.
		//
        ////////////////////////////////////////////////////////////////
		return FirstName + " " + LastName;
	}
	
	public int getAge() {
		////////////////////////////////////////////////////////////////////////////////
		//Method returns: Integer
		//Get the local date and compare to the Birthday of the License holder
		//Calculate the difference between the number of years and return the age of the
		//License holder.
		////////////////////////////////////////////////////////////////////////////////
		
		LocalDate today = LocalDate.now(); // today's date
		  LocalDate birthday = LocalDate.of(yearDOB, monthDOB, dayDOB); // date of birth

		  Period period = Period.between(birthday, today);

		  int age = period.getYears(); // calculate the period between DOB and today in years
		  
		return age;
	}
	
}
