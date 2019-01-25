
public class LicenseProgram {

	public static void main(String[] args) {
		// Using the DriversLicense class create two
		
		DriversLicense dl1 = new DriversLicense();
		dl1.setFirstName("Bob");
		dl1.setLastName("Jones");
		dl1.setYearDOB(1973);
		dl1.setMonthDOB(11);
		dl1.setDayDOB(12);
		dl1.setHeight(6);
		dl1.setGender("Male");
			

		DriversLicense dl2 = new DriversLicense();
		dl2.setFirstName("Mary");
		dl2.setLastName("Jones");
		dl2.setMonthDOB(01);
		dl2.setDayDOB(12);
		dl2.setHeight(6);
		dl2.setYearDOB(1950);
		dl2.setGender("Female");
		
		DriversLicense dl3 = new DriversLicense();
		dl3.setFirstName("Ralph");
		dl3.setLastName("Stanly");
		dl3.setMonthDOB(05);
		dl3.setDayDOB(22);
		dl3.setHeight(5);
		dl3.setYearDOB(1933);
		dl3.setGender("Male");
		
		
		System.out.println("Full Name Drivers License 1: " + dl1.getFullName());	
		System.out.println("Age Drivers License 1: " + dl1.getAge());	
		
		System.out.println();
		System.out.println();
		System.out.println("Full Name Drivers License 2: " + dl2.getFullName());
		System.out.println("Age Drivers License 2: " + dl2.getAge());
		
		System.out.println();
		System.out.println();
		System.out.println("Full Name Drivers License 3: " + dl3.getFullName());
		System.out.println("Age Drivers License 3: " + dl3.getAge());
			
	}

}
