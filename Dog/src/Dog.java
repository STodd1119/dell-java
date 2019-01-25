
public class Dog {
	//Attributes
	public String breed;
	public String coatType;
	public int age;
	public int weight;
	public String size;
	
	//Constructors
	public Dog() {
		
	}
	//Methods
	//Getters and Setters
	public String getBreed() {
		return breed;
	}

	public void setBreed(String myBreed) {
		this.breed = myBreed;
	}

	public String getCoatType() {
		return coatType;
	}

	public void setCoatType(String myCoatType) {
		this.coatType = myCoatType;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int myAge) {
		this.age = myAge;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int myWeight) {
		this.weight = myWeight;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String mySize) {
		this.size = mySize;
	}
	
	//My Methods
	public boolean walkDog() {
		return true;
	}
	
	public boolean bathDog() {
		return true;
	}
	
	public boolean feedDog() {
		return true;
	}
	
	
}
