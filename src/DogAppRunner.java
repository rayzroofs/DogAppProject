package DogApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*TEXT FILE FORMAT:
Breed 		String
KidFriendly bool 0-1
DogFriendly bool 0-1
Sheds 		bool 0-1
bark level  int 1-3 
trainable   int 1-3 
lifespan 	int 
size 		int 1-4
active      int 1-3
*/
public class DogAppRunner {
	protected static final int ATTRIBUTES_FOR_MATCHING = 7; //not using lifespan and breed name to generate matches
	private ArrayList<DogBreed> dogList = new ArrayList<DogBreed>();
	private ArrayList<DogBreed> bestDogList = new ArrayList<DogBreed>();	//list of best matches for user
	private DogBreed searchResult;				//will be a reference to the search result in dogBreedArray
	
	private DogBreed dogMatch = new DogBreed();  //user's match preferences
	
	//default constructor calls method that reads the text file
	public DogAppRunner() throws FileNotFoundException {
		readDogFile();
	}


	public DogAppRunner(ArrayList<DogBreed> dogList, ArrayList<DogBreed> bestDogList, DogBreed searchResult,
			DogBreed dogMatch) {
		this.dogList = dogList;
		this.bestDogList = bestDogList;
		this.searchResult = searchResult;
		this.dogMatch = dogMatch;
	}



	public ArrayList<DogBreed> getDogList() {
		return dogList;
	}



	public void setDogList(ArrayList<DogBreed> dogList) {
		this.dogList = dogList;
	}



	public DogBreed getDogMatch() {
		return dogMatch;
	}


	public void setDogMatch(DogBreed dogMatch) {
		this.dogMatch = dogMatch;
	}



	public ArrayList<DogBreed> getBestDogList() {
		return bestDogList;
	}


	public void setBestDogList(ArrayList<DogBreed> bestDogList) {
		this.bestDogList = bestDogList;
	}
	
	

	public DogBreed getSearchResult() {
		return searchResult;
	}


	public void setSearchResult(DogBreed searchResult) {
		this.searchResult = searchResult;
	}

	public void readDogFile() throws FileNotFoundException{
		
		
		FileReader dogFileReader = new FileReader("DogFile.txt"); 
		Scanner dogScan = new Scanner(dogFileReader);
				
		//Will fill ARRAY with all the dog Breeds in the file, size of the array will be the number of dogs in file

		int intPars; 
		boolean kidFriendly;
		boolean dogFriendly;
		boolean sheds;
		
		while (dogScan.hasNextLine()) {
					
						DogBreed tempDog = new DogBreed();
						//ATTRIBUTE # 1
						
						tempDog.setBreedName(dogScan.nextLine());
						
						//ATTRIBUTE # 2
							
						intPars = Integer.parseInt(dogScan.nextLine());
						kidFriendly = (intPars == 1) ? true : false;			
						
						tempDog.setKidFriendly(kidFriendly);
						
						//ATTRIBUTE # 3
									
						intPars = Integer.parseInt(dogScan.nextLine());
						dogFriendly = (intPars == 1) ? true : false;								
						tempDog.setDogFriendly(dogFriendly);
											
						//ATTRIBUTE # 4
								
						intPars = Integer.parseInt(dogScan.nextLine());
						sheds = (intPars == 1) ? true : false;			
						tempDog.setShedsMuch(sheds);
											
						//ATTRIBUTE # 5
							
						 intPars = Integer.parseInt(dogScan.nextLine());
						 tempDog.setBarkingTendencies(intPars);
						
						//ATTRIBUTE # 6
						
						intPars = Integer.parseInt(dogScan.nextLine());
						tempDog.setTrainability(intPars);
							
						//ATTRIBUTE # 7
							
						intPars = Integer.parseInt(dogScan.nextLine());
						tempDog.setLifeSpan(intPars);
						
						//ATTRIBUTE # 8
							
						intPars = Integer.parseInt(dogScan.nextLine());
						tempDog.setSize(intPars);
						
						//ATTRIBUTE # 9
							
						intPars = Integer.parseInt(dogScan.nextLine());
						tempDog.setActiveLevel(intPars);
						
				
						
						dogList.add(tempDog);
						
		}
		
	
		dogScan.close();

		
		
	}
	public void fillBestDogList(){
		//empty previous list
		bestDogList.clear();
		
		//the DogAppRunner object that uses this method will clear past match results
		for (int i = 0; i < this.getDogList().size();i++) {
			this.getDogList().get(i).setMatches(0);
		}
		
		//incrementing match # counter if an attribute matches a user's preference
		for (int i = 0; i < dogList.size(); i++) {					
			dogList.get(i).matches+= (dogList.get(i).isDogFriendly()==dogMatch.isDogFriendly()) ? 1 : 0;
			dogList.get(i).matches+= (dogList.get(i).isKidFriendly()==dogMatch.isKidFriendly()) ? 1 : 0;
			dogList.get(i).matches+= (dogList.get(i).isShedsMuch()==dogMatch.isShedsMuch()) ? 1 : 0;
			dogList.get(i).matches+= (dogList.get(i).getBarkingTendencies()==dogMatch.getBarkingTendencies()) ? 1 : 0;
			dogList.get(i).matches+= (dogList.get(i).getTrainability()==dogMatch.getTrainability()) ? 1 : 0;
			dogList.get(i).matches+= (dogList.get(i).getSize()==dogMatch.getSize()) ? 1 : 0;
			dogList.get(i).matches+= (dogList.get(i).getActiveLevel()==dogMatch.getActiveLevel()) ? 1 : 0;
			
		}
		
	
		//filling best list
		//4 or more matching traits will be considered a match
		//using iterator through list
		for (DogBreed currentBreed : dogList) {
		    if (currentBreed.getMatches() >= ATTRIBUTES_FOR_MATCHING-3) {
		        bestDogList.add(currentBreed);
		    }
		}
		//sorting ascending
		Collections.sort(bestDogList, new Comparator<DogBreed>(){
			@Override
			public int compare(DogBreed o1, DogBreed o2) {
				return Double.compare(o1.getMatches(), o2.getMatches());
			}
		});
		
	
	}

	
	
	public boolean getBreedSearch(String searchInput) {
		
		boolean result = false;
		searchInput = searchInput.replaceAll("\\s+", ""); //removing whitespace from input
	
		if (dogList == null) {		
				System.out.println("missing file, search result is empty");
				return result; 	//will return an empty search result
		}
		
		
		String tempMatch = new String();  //originally had this in loop. Better to not declare it for each check in loop
		for (int i = 0; i < dogList.size(); i++) {
			//String tempMatch = new String(); //should probably declare this outside of loop? test later
			tempMatch = dogList.get(i).getBreedName();		//tempMatch required because will be removing whitespace, and do not want to do that to original list
			tempMatch = tempMatch.replaceAll("\\s+", "");
			
			if (searchInput.toLowerCase().equals(tempMatch.toLowerCase()) || tempMatch.toLowerCase().contains(searchInput.toLowerCase()) ) {
				searchResult = dogList.get(i);			//reference to the DogBreed object that matches
				result = true;
			}

		
		}
		

		return result;


	}
	

	
	/*
	public static void main(String[] args) throws FileNotFoundException{
		
		if (args.length == 0) {
		//method can be defined later if something wants to run without a GUI
		//we didn't take in any input here and relied on getting it all through the GUI	
		
		//DogAppRunner testApp = new DogAppRunner();
		
		//System.out.println(testApp.getSearch("PUg", testApp).getBreedName());
		
		}
	}
	*/
	
}
