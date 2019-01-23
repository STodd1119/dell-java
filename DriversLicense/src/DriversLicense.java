
public class DriversLicense {
	
	 String FirstName;
	 String LastName;
	 String DateOfBirth;
	 int Height;
	 String Gender;

	
	public static void getFullName(String FirstName, String LastName) {
		System.out.println(FirstName + " " + LastName);
	}
	
	public static void getAge(String DateOfBirth) {
		int caculatedAge = 0;
		
		System.out.println("Persons Age: " + caculatedAge);
	}
	
	public static void main(String[] args) {
		
		DriversLicense dl1 = new DriversLicense();
		dl1.FirstName = "Bob";
		dl1.LastName = "Jones";
		dl1.DateOfBirth = "11/12/2013";
		dl1.Height = 6;
		dl1.Gender = "Male";
		
		DriversLicense dl2 = new DriversLicense();
		dl2.FirstName = "Mary";
		dl2.LastName = "Jones";
		dl2.DateOfBirth = "1/12/2011";
		dl2.Height = 6;
		dl2.Gender = "Female";
		
		
		dl1.getFullName();
		dl2.getFullName();
		
		System.out.println("We are done here!");
	}

}
