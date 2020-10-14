package DogApp;
//http://www.dogbreedslist.info/all-dog-breeds.html
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DogBreed {
	
	private String breedName;
	
	private boolean kidFriendly; // how well the dog is around kid/family 
	// yes = true
	// no = false
	private boolean dogFriendly; // how the dog treat other dogs
	// yes = true
	// no = false
	private boolean shedsMuch; // how much fur the dog sheds/ grooming
	//yes = true
	//no = false
	private int barkingTendencies ; // does the dog bark or howl often 
	//no noise   1
	//some noise 2
	//loud noise 3

	private int trainability;  // how well the dog can be trained 
	//easy training 3
	//average train 2
	//stubborn      1

	private int lifeSpan; // average life span of the dog breed
	
	private int size; // small , med or large  in pounds.
	//small : 2 TO 22 pounds 1
	//medium : 24 to 57 pounds 2
	//large : 59 to 98 pounds 3
	//giant : 99 or more pounds 4
	
	private int activeLevel; // energy level of the dog 
	// calm 	 1
	// regular   2
	// energetic 3 

	
	protected int matches;	 //to count matching attributes
	
	//CONSTRUCTORS
	public DogBreed() {
		
	}
	
	public DogBreed(String breedName, boolean kidFriendly, boolean dogFriendly, int lifeSpan, boolean shedsMuch,
			int barkingTendencies, int trainability, int size, int activeLevel, int matches) {
		this.breedName = breedName;
		this.kidFriendly = kidFriendly;
		this.dogFriendly = dogFriendly;
		this.lifeSpan = lifeSpan;
		this.shedsMuch = shedsMuch;
		this.barkingTendencies = barkingTendencies;
		this.trainability = trainability;
		this.size = size;
		this.activeLevel = activeLevel;	
		this.matches = matches;
	}
	
	public int getMatches() {
		return matches;
	}
	public String getBreedName() {
		return breedName;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}

	public boolean isKidFriendly() {
		return kidFriendly;
	}

	public void setKidFriendly(boolean kidFriendly) {
		this.kidFriendly = kidFriendly;
	}

	public boolean isDogFriendly() {
		return dogFriendly;
	}

	public void setDogFriendly(boolean dogFriendly) {
		this.dogFriendly = dogFriendly;
	}

	public int getLifeSpan() {
		return lifeSpan;
	}

	public void setLifeSpan(int lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public boolean isShedsMuch() {
		return shedsMuch;
	}

	public void setShedsMuch(boolean shedsMuch) {
		this.shedsMuch = shedsMuch;
	}

	public int getBarkingTendencies() {
		return barkingTendencies;
	}

	public void setBarkingTendencies(int barkingTendencies) {
		this.barkingTendencies = barkingTendencies;
	}

	public int getTrainability() {
		return trainability;
	}

	public void setTrainability(int trainability) {
		this.trainability = trainability;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getActiveLevel() {
		return activeLevel;
	}

	public void setActiveLevel(int activeLevel) {
		this.activeLevel = activeLevel;
	}

	
	

	public static void main(String[] args) throws FileNotFoundException {
		
		//tests
		//DogBreed []testDog = new DogBreed[6];
	
		
	}
	
}
