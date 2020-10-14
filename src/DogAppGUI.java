package DogApp;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Scale;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

public class DogAppGUI {
	private static final int displayNum = 12;	//to limit displayed results in this GUI	
	protected Shell shlDoggoSelector;
	private Text searchBox;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DogAppGUI window = new DogAppGUI();				
			DogAppRunner dogApp = new DogAppRunner();		//new instance of dogApp
			window.open(dogApp);							//opening GUI window, passing our instance of DogAppRunner
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open(DogAppRunner dogApp) {
		Display display = Display.getDefault();
		createContents(dogApp);								//passing our instance of DogAppRunner 
		shlDoggoSelector.open();
		shlDoggoSelector.layout();
		while (!shlDoggoSelector.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(DogAppRunner dogApp) {
		shlDoggoSelector = new Shell();
		shlDoggoSelector.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		shlDoggoSelector.setSize(1316, 1062);
		shlDoggoSelector.setText("Doggo Selector");
		
		Scale scaleBark = new Scale(shlDoggoSelector, SWT.NONE);
		scaleBark.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		scaleBark.setForeground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		scaleBark.setBounds(52, 100, 290, 42);
		scaleBark.setMaximum(3);
		scaleBark.setMinimum(1);
		scaleBark.setSelection(2);
		dogApp.getDogMatch().setBarkingTendencies(scaleBark.getSelection());
				
		Label lblNewLabel = new Label(shlDoggoSelector, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblNewLabel.setFont(SWTResourceManager.getFont("Calibri", 20, SWT.BOLD));
		lblNewLabel.setBounds(52, 33, 175, 33);
		lblNewLabel.setText("Bark Level");
		
		Label lblNotVery = new Label(shlDoggoSelector, SWT.NONE);
		lblNotVery.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblNotVery.setFont(SWTResourceManager.getFont("Calibri", 13, SWT.NORMAL));
		lblNotVery.setAlignment(SWT.CENTER);
		lblNotVery.setBounds(22, 148, 94, 42);
		lblNotVery.setText("low");
		
		Label lblVery = new Label(shlDoggoSelector, SWT.NONE);
		lblVery.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblVery.setFont(SWTResourceManager.getFont("Calibri", 13, SWT.NORMAL));
		lblVery.setAlignment(SWT.CENTER);
		lblVery.setBounds(296, 148, 73, 42);
		lblVery.setText("high");
		
		Label lblTheAmountOf = new Label(shlDoggoSelector, SWT.NONE);
		lblTheAmountOf.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblTheAmountOf.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblTheAmountOf.setBounds(52, 72, 376, 22);
		lblTheAmountOf.setText("How much noise are you okay with?");
		
		Label lblModerate = new Label(shlDoggoSelector, SWT.NONE);
		lblModerate.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblModerate.setFont(SWTResourceManager.getFont("Calibri", 13, SWT.NORMAL));
		lblModerate.setAlignment(SWT.CENTER);
		lblModerate.setBounds(157, 148, 85, 22);
		lblModerate.setText("moderate");
		
		Label lblKidFriendly = new Label(shlDoggoSelector, SWT.NONE);
		lblKidFriendly.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblKidFriendly.setText("Kid Friendly");
		lblKidFriendly.setFont(SWTResourceManager.getFont("Calibri", 20, SWT.BOLD));
		lblKidFriendly.setBounds(447, 33, 175, 33);
		
		Label lblHowFriendlyThe = new Label(shlDoggoSelector, SWT.NONE);
		lblHowFriendlyThe.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblHowFriendlyThe.setText("Does your dog need to be good with kids?");
		lblHowFriendlyThe.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblHowFriendlyThe.setBounds(447, 72, 376, 22);
		
		Combo comboKidFriendly = new Combo(shlDoggoSelector, SWT.NONE);
		comboKidFriendly.setItems(new String[] {"Yes", "No"});		
		comboKidFriendly.setBounds(447, 100, 73, 23);
		comboKidFriendly.setText("No");
		
		Label lblDogFriendly = new Label(shlDoggoSelector, SWT.NONE);
		lblDogFriendly.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDogFriendly.setText("Dog Friendly");
		lblDogFriendly.setFont(SWTResourceManager.getFont("Calibri", 20, SWT.BOLD));
		lblDogFriendly.setBounds(447, 157, 175, 33);
		
		Label lblDoesYourDog = new Label(shlDoggoSelector, SWT.NONE);
		lblDoesYourDog.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDoesYourDog.setText("Does your dog need to get along with other dogs?");
		lblDoesYourDog.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblDoesYourDog.setBounds(447, 196, 376, 22);
		
		Combo comboDogFriendly = new Combo(shlDoggoSelector, SWT.NONE);
		comboDogFriendly.setItems(new String[] {"Yes", "No"});
		comboDogFriendly.setBounds(447, 224, 73, 23);
		comboDogFriendly.setText("No");
		
		Label lblShedLevel = new Label(shlDoggoSelector, SWT.NONE);
		lblShedLevel.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblShedLevel.setText("Heavy Shedding");
		lblShedLevel.setFont(SWTResourceManager.getFont("Calibri", 20, SWT.BOLD));
		lblShedLevel.setBounds(447, 279, 188, 33);
		
		Label lblAreYouOkay = new Label(shlDoggoSelector, SWT.NONE);
		lblAreYouOkay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblAreYouOkay.setText("Can you tolerate sheddy behavior?");
		lblAreYouOkay.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblAreYouOkay.setBounds(447, 318, 399, 22);
		
		Combo comboSheds = new Combo(shlDoggoSelector, SWT.NONE);
		comboSheds.setItems(new String[] {"Yes", "No"});
		comboSheds.setBounds(447, 346, 73, 23);
		comboSheds.setText("No");
		
		Label lblTrainability = new Label(shlDoggoSelector, SWT.NONE);
		lblTrainability.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblTrainability.setText("Trainability");
		lblTrainability.setFont(SWTResourceManager.getFont("Calibri", 20, SWT.BOLD));
		lblTrainability.setBounds(52, 213, 175, 33);
		
		Label lblHowEasyIt = new Label(shlDoggoSelector, SWT.NONE);
		lblHowEasyIt.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblHowEasyIt.setText("Do you want a fast learner or is stubborn okay?");
		lblHowEasyIt.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblHowEasyIt.setBounds(52, 252, 376, 22);
		
		Scale scaleTrain = new Scale(shlDoggoSelector, SWT.NONE);
		scaleTrain.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		scaleTrain.setMaximum(3);
		scaleTrain.setMinimum(1);
		scaleTrain.setSelection(2);
		scaleTrain.setBounds(52, 279, 290, 42);
		dogApp.getDogMatch().setTrainability(scaleTrain.getSelection());
		
		Label lblDumb = new Label(shlDoggoSelector, SWT.NONE);
		lblDumb.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDumb.setText("dumb");
		lblDumb.setFont(SWTResourceManager.getFont("Calibri", 13, SWT.NORMAL));
		lblDumb.setAlignment(SWT.CENTER);
		lblDumb.setBounds(22, 327, 94, 42);
		
		Label lblAverage = new Label(shlDoggoSelector, SWT.NONE);
		lblAverage.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblAverage.setText("average");
		lblAverage.setFont(SWTResourceManager.getFont("Calibri", 13, SWT.NORMAL));
		lblAverage.setAlignment(SWT.CENTER);
		lblAverage.setBounds(157, 327, 85, 22);
		
		Label lblSmart = new Label(shlDoggoSelector, SWT.NONE);
		lblSmart.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSmart.setText("smart");
		lblSmart.setFont(SWTResourceManager.getFont("Calibri", 13, SWT.NORMAL));
		lblSmart.setAlignment(SWT.CENTER);
		lblSmart.setBounds(290, 327, 73, 42);
		
		Label lblSize = new Label(shlDoggoSelector, SWT.NONE);
		lblSize.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSize.setText("Size");
		lblSize.setFont(SWTResourceManager.getFont("Calibri", 20, SWT.BOLD));
		lblSize.setBounds(52, 577, 175, 33);
		
		Label lblDoYouWant = new Label(shlDoggoSelector, SWT.NONE);
		lblDoYouWant.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDoYouWant.setText("Would you like a small boy or a big boy (or girl)?");
		lblDoYouWant.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblDoYouWant.setBounds(52, 616, 376, 22);
		
		Scale scaleSize = new Scale(shlDoggoSelector, SWT.NONE);
		scaleSize.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		scaleSize.setMaximum(4);
		scaleSize.setMinimum(1);
		scaleSize.setSelection(2);
		scaleSize.setBounds(52, 644, 290, 42);
		dogApp.getDogMatch().setSize(scaleSize.getSelection());		//in case no slider moved
		
		Label lblSmall = new Label(shlDoggoSelector, SWT.NONE);
		lblSmall.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSmall.setText("small");
		lblSmall.setFont(SWTResourceManager.getFont("Calibri", 13, SWT.NORMAL));
		lblSmall.setAlignment(SWT.CENTER);
		lblSmall.setBounds(27, 692, 73, 42);
		
		Label lblMedium = new Label(shlDoggoSelector, SWT.NONE);
		lblMedium.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblMedium.setText("medium");
		lblMedium.setFont(SWTResourceManager.getFont("Calibri", 13, SWT.NORMAL));
		lblMedium.setAlignment(SWT.CENTER);
		lblMedium.setBounds(116, 692, 85, 33);
		
		Label lblLarge = new Label(shlDoggoSelector, SWT.NONE);
		lblLarge.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblLarge.setText("large");
		lblLarge.setFont(SWTResourceManager.getFont("Calibri", 13, SWT.NORMAL));
		lblLarge.setAlignment(SWT.CENTER);
		lblLarge.setBounds(215, 692, 66, 42);
		
		Label lblGiant = new Label(shlDoggoSelector, SWT.NONE);
		lblGiant.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblGiant.setText("giant");
		lblGiant.setFont(SWTResourceManager.getFont("Calibri", 13, SWT.NORMAL));
		lblGiant.setAlignment(SWT.CENTER);
		lblGiant.setBounds(296, 692, 73, 42);
		
		Label lblActivityLevel = new Label(shlDoggoSelector, SWT.NONE);
		lblActivityLevel.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblActivityLevel.setText("Activity Level");
		lblActivityLevel.setFont(SWTResourceManager.getFont("Calibri", 20, SWT.BOLD));
		lblActivityLevel.setBounds(52, 396, 175, 33);
		
		Label lblDoYouWant_1 = new Label(shlDoggoSelector, SWT.NONE);
		lblDoYouWant_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDoYouWant_1.setText("Do you want a lazy or high energy dog?");
		lblDoYouWant_1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblDoYouWant_1.setBounds(52, 435, 376, 22);
		
		Scale scaleActivity = new Scale(shlDoggoSelector, SWT.NONE);
		scaleActivity.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		scaleActivity.setMaximum(3);
		scaleActivity.setMinimum(1);
		scaleActivity.setSelection(2);
		scaleActivity.setBounds(52, 463, 290, 42);
		dogApp.getDogMatch().setActiveLevel(scaleActivity.getSelection());
		
		Label lblLazy = new Label(shlDoggoSelector, SWT.NONE);
		lblLazy.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblLazy.setText("lazy");
		lblLazy.setFont(SWTResourceManager.getFont("Calibri", 13, SWT.NORMAL));
		lblLazy.setAlignment(SWT.CENTER);
		lblLazy.setBounds(22, 511, 94, 42);
		
		Label lblAverage_1 = new Label(shlDoggoSelector, SWT.NONE);
		lblAverage_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblAverage_1.setText("average");
		lblAverage_1.setFont(SWTResourceManager.getFont("Calibri", 13, SWT.NORMAL));
		lblAverage_1.setAlignment(SWT.CENTER);
		lblAverage_1.setBounds(157, 511, 85, 22);
		
		Label lblHigh = new Label(shlDoggoSelector, SWT.NONE);
		lblHigh.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblHigh.setText("super active");
		lblHigh.setFont(SWTResourceManager.getFont("Calibri", 13, SWT.NORMAL));
		lblHigh.setAlignment(SWT.CENTER);
		lblHigh.setBounds(284, 511, 85, 22);
		
		Label lblBreedHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblBreedHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblBreedHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblBreedHeader.setBounds(510, 465, 73, 22);
		
		Label lblBreedResultsDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblBreedResultsDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblBreedResultsDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblBreedResultsDisplay.setBounds(510, 491, 152, 217);
		
		Label lblMatchNumDisplay = new Label(shlDoggoSelector, SWT.CENTER);
		lblMatchNumDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblMatchNumDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblMatchNumDisplay.setBounds(447, 491, 57, 217);
		
		Label lblBarkDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblBarkDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblBarkDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblBarkDisplay.setBounds(667, 489, 67, 217);
		
		Label lblYourBestDog = new Label(shlDoggoSelector, SWT.NONE);
		lblYourBestDog.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblYourBestDog.setFont(SWTResourceManager.getFont("Calibri", 20, SWT.BOLD));
		lblYourBestDog.setBounds(447, 428, 274, 36);
		
		
		
		Label lblMatchNum = new Label(shlDoggoSelector, SWT.NONE);
		lblMatchNum.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblMatchNum.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblMatchNum.setBounds(447, 465, 61, 22);
		
		Label lblBarkHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblBarkHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblBarkHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblBarkHeader.setBounds(667, 463, 57, 22);
		
		Label lblTrainHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblTrainHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblTrainHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblTrainHeader.setBounds(749, 463, 73, 22);
		
		Label lblTrainDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblTrainDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblTrainDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblTrainDisplay.setBounds(749, 489, 73, 217);
		
		Label lblActiveHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblActiveHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblActiveHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblActiveHeader.setBounds(828, 463, 57, 22);
		
		Label lblSizeHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblSizeHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblSizeHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSizeHeader.setBounds(896, 463, 50, 22);
		
		Label lblKFHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblKFHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblKFHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblKFHeader.setBounds(952, 463, 75, 22);
		
		Label lblDFHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblDFHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblDFHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDFHeader.setBounds(1041, 463, 85, 22);
		
		Label lblShedHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblShedHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblShedHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblShedHeader.setBounds(1141, 463, 50, 22);
		
		Label lblLifeSpanHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblLifeSpanHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblLifeSpanHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblLifeSpanHeader.setBounds(1202, 463, 73, 22);
		
		Label lblActiveDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblActiveDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblActiveDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblActiveDisplay.setBounds(828, 491, 57, 217);
		
		Label lblSizeDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblSizeDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblSizeDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSizeDisplay.setBounds(896, 489, 60, 217);
		
		Label lblKFDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblKFDisplay.setAlignment(SWT.CENTER);
		lblKFDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblKFDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblKFDisplay.setBounds(962, 489, 50, 217);
		
		Label lblDFDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblDFDisplay.setAlignment(SWT.CENTER);
		lblDFDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblDFDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDFDisplay.setBounds(1041, 491, 66, 217);
		
		Label lblShedDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblShedDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblShedDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblShedDisplay.setBounds(1151, 489, 50, 217);
		
		Label lblLifeSpanDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblLifeSpanDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblLifeSpanDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblLifeSpanDisplay.setBounds(1202, 489, 73, 217);
		
		Label lblSearchResults = new Label(shlDoggoSelector, SWT.NONE);
		lblSearchResults.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSearchResults.setFont(SWTResourceManager.getFont("Calibri", 18, SWT.BOLD));
		lblSearchResults.setBounds(460, 753, 274, 23);
		
		Label lblBreedSHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblBreedSHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblBreedSHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblBreedSHeader.setBounds(510, 775, 73, 22);
		
		Label lblBarkSHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblBarkSHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblBarkSHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblBarkSHeader.setBounds(667, 775, 57, 22);
		
		Label lblTrainSHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblTrainSHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblTrainSHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblTrainSHeader.setBounds(749, 775, 73, 22);
		
		Label lblActiveSHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblActiveSHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblActiveSHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblActiveSHeader.setBounds(828, 775, 57, 22);
		
		Label lblSizeSHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblSizeSHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblSizeSHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSizeSHeader.setBounds(896, 775, 50, 22);
		
		Label lblKFSHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblKFSHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblKFSHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblKFSHeader.setBounds(952, 775, 75, 22);
		
		Label lblDFSHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblDFSHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblDFSHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDFSHeader.setBounds(1041, 775, 85, 22);
		
		Label lblShedSHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblShedSHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblShedSHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblShedSHeader.setBounds(1141, 775, 50, 22);
		
		Label lblLifeSpanSHeader = new Label(shlDoggoSelector, SWT.NONE);
		lblLifeSpanSHeader.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblLifeSpanSHeader.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblLifeSpanSHeader.setBounds(1202, 775, 73, 22);
		
		Label lblOr = new Label(shlDoggoSelector, SWT.NONE);
		lblOr.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblOr.setAlignment(SWT.CENTER);
		lblOr.setText("or");
		lblOr.setBounds(666, 726, 55, 15);
		
		Label lblBreedSDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblBreedSDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblBreedSDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblBreedSDisplay.setBounds(510, 801, 152, 20);
		
		Label lblBarkSDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblBarkSDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblBarkSDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblBarkSDisplay.setBounds(667, 801, 67, 20);
		
		Label lblTrainSDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblTrainSDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblTrainSDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblTrainSDisplay.setBounds(750, 801, 73, 20);
		
		Label lblActiveSDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblActiveSDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblActiveSDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblActiveSDisplay.setBounds(828, 801, 57, 20);
		
		Label lblSizeSDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblSizeSDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblSizeSDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblSizeSDisplay.setBounds(896, 801, 60, 20);
		
		Label lblKFSDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblKFSDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblKFSDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblKFSDisplay.setAlignment(SWT.CENTER);
		lblKFSDisplay.setBounds(962, 801, 50, 20);
		
		Label lblDFSDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblDFSDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblDFSDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblDFSDisplay.setAlignment(SWT.CENTER);
		lblDFSDisplay.setBounds(1041, 801, 66, 20);
		
		Label lblShedSDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblShedSDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblShedSDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblShedSDisplay.setBounds(1151, 801, 50, 20);
		
		Label lblLifeSpanSDisplay = new Label(shlDoggoSelector, SWT.NONE);
		lblLifeSpanSDisplay.setFont(SWTResourceManager.getFont("Calibri", 11, SWT.NORMAL));
		lblLifeSpanSDisplay.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblLifeSpanSDisplay.setBounds(1202, 801, 73, 20);
		
		searchBox = new Text(shlDoggoSelector, SWT.BORDER);
		searchBox.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		searchBox.setBounds(732, 723, 175, 21);
		
		comboKidFriendly.addSelectionListener(new SelectionAdapter() {
			 @Override
	            public void widgetSelected(SelectionEvent e) {            					 	
				 	String choice = comboKidFriendly.getItem(comboKidFriendly.getSelectionIndex());
	                        	 	     
	                dogApp.getDogMatch().setKidFriendly((choice.equals("Yes")) ? true : (choice.equals("No")) ? false : false);
	            }
		});
		
	
		
		comboDogFriendly.addSelectionListener(new SelectionAdapter() {
			 @Override
	            public void widgetSelected(SelectionEvent e) {            					 	
				 	String choice = comboDogFriendly.getItem(comboDogFriendly.getSelectionIndex());
	             ;	          	 
	             dogApp.getDogMatch().setDogFriendly((choice.equals("Yes")) ? true : (choice.equals("No")) ? false : false);              

	            }
		});
		
		comboSheds.addSelectionListener(new SelectionAdapter() {
			 @Override
	            public void widgetSelected(SelectionEvent e) {            					 	
				 	String choice = comboSheds.getItem(comboSheds.getSelectionIndex());
	          	          	 
				 	dogApp.getDogMatch().setShedsMuch( (choice.equals("Yes")) ? true : (choice.equals("No")) ? false : false);              

	            }
		});
		   
		
		scaleBark.addSelectionListener(new SelectionAdapter() {
	          @Override
	           public void widgetSelected(SelectionEvent e) {
			                     	 
	        	  dogApp.getDogMatch().setBarkingTendencies(scaleBark.getSelection());   
			   }
	    });
		
		
		
		scaleTrain.addSelectionListener(new SelectionAdapter() {
	          @Override
	           public void widgetSelected(SelectionEvent e) {
			         	          	 
	        	  dogApp.getDogMatch().setTrainability(scaleTrain.getSelection());   
			   }
	    });
		
		;
		
		scaleSize.addSelectionListener(new SelectionAdapter() {
	          @Override
	           public void widgetSelected(SelectionEvent e) {
	        	  		          	 
	        	  dogApp.getDogMatch().setSize(scaleSize.getSelection());   
   
			   }
	    });
		
		
		
		scaleActivity.addSelectionListener(new SelectionAdapter() {
	          @Override
	           public void widgetSelected(SelectionEvent e) {
	        	   
	        	  		          	 
	        	  dogApp.getDogMatch().setActiveLevel(scaleActivity.getSelection());  
	        	  		
			   }
	    });
		
		//SUBMIT BUTTON - for submitting dog preferences
		Button btnSubmit = new Button(shlDoggoSelector, SWT.NONE);
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
	
				try {
				dogApp.fillBestDogList();  	//populating the list of best dogs for the user
				
				//RESULTS TO BE DISPLAYED
				String resultsBreed = new String();
				String resultsMatches = new String();
				String resultsBark = new String();
				String resultsTrain = new String();
				String resultsActive = new String();
				String resultsSize = new String();
				String resultsShed = new String();
				String resultsKidFriendly = new String();
				String resultsDogFriendly = new String();
				String resultsLifespan = new String();
				

				for (int i = dogApp.getBestDogList().size()-1, j = 0;  j < displayNum && i >=0 ; i--, j++) { 																									
					resultsBreed+= dogApp.getBestDogList().get(i).getBreedName()  + "\n";
					resultsMatches+=dogApp.getBestDogList().get(i).getMatches() + "\n";
					
					
					//TRANSLATING: attributes -> text Strings
					//this could potentially be done in a separate class or DogAppRunner
					//but the format I laid out for this GUI is specific to this GUI, so I coded it here. 
					//one column is essentially one String
					resultsBark += dogApp.getBestDogList().get(i).getBarkingTendencies() == 1 ? "Low" : dogApp.getBestDogList().get(i).getBarkingTendencies() == 2 ? "Moderate" : dogApp.getBestDogList().get(i).getBarkingTendencies() == 3 ? "Frequent" : "error";
					resultsBark += "\n";
					resultsTrain += dogApp.getBestDogList().get(i).getTrainability() == 1 ? "Low" : dogApp.getBestDogList().get(i).getTrainability() == 2 ? "Average" : dogApp.getBestDogList().get(i).getTrainability() == 3 ? "Highly" : "error";
					resultsTrain += "\n";
					resultsActive += dogApp.getBestDogList().get(i).getActiveLevel() == 1 ? "Lazy" : dogApp.getBestDogList().get(i).getActiveLevel() == 2 ? "Average" : dogApp.getBestDogList().get(i).getActiveLevel() == 3 ? "Highly" : "error";
					resultsActive += "\n";
					resultsSize += dogApp.getBestDogList().get(i).getSize() == 1 ? "Small" : dogApp.getBestDogList().get(i).getSize() == 2 ? "Medium" : dogApp.getBestDogList().get(i).getSize() == 3 ? "Large" : dogApp.getBestDogList().get(i).getSize() == 4 ?  "Giant" : "error";
					resultsSize += "\n";
					resultsShed += dogApp.getBestDogList().get(i).isShedsMuch() == true ? "Yes" : dogApp.getBestDogList().get(i).isShedsMuch() == false ? "No" : "error";
					resultsShed += "\n";
					resultsKidFriendly +=  dogApp.getBestDogList().get(i).isKidFriendly() == true ? "Yes" : dogApp.getBestDogList().get(i).isKidFriendly() == false ? "No" : "error";
					resultsKidFriendly += "\n";
					resultsDogFriendly += dogApp.getBestDogList().get(i).isDogFriendly() == true ? "Yes" : dogApp.getBestDogList().get(i).isDogFriendly() == false ? "No" : "error";
					resultsDogFriendly += "\n";
					resultsLifespan += dogApp.getBestDogList().get(i).getLifeSpan();
					resultsLifespan += "\n";
				}
				
				
				lblYourBestDog.setText("Your Best Dog Matches:");
				lblBreedHeader.setText("Breed");
				lblMatchNum.setText("Matches");
				lblBarkHeader.setText("Barking");
				lblActiveHeader.setText("Active");
				lblTrainHeader.setText("Trainable");
				lblKFHeader.setText("Kid Friendly");
				lblDFHeader.setText("Dog Friendly");
				lblShedHeader.setText("Shed");
				lblSizeHeader.setText("Size");
				lblLifeSpanHeader.setText("Lifespan");
				
				lblBreedResultsDisplay.setText(resultsBreed);
				lblMatchNumDisplay.setText(resultsMatches);
				lblBarkDisplay.setText(resultsBark);
				lblTrainDisplay.setText(resultsTrain);
				lblActiveDisplay.setText(resultsActive);
				lblSizeDisplay.setText(resultsSize);
				lblShedDisplay.setText(resultsShed);
				lblKFDisplay.setText(resultsKidFriendly);
				lblDFDisplay.setText(resultsDogFriendly);
				lblLifeSpanDisplay.setText(resultsLifespan);
				
				}
				catch (Exception exc) {
					//error if no results are found
					MessageDialog.openError(shlDoggoSelector, "Selector Error", "No dog breed matches this criteria. Try altering your preferences, or perhaps get a cat instead.");
					return;
				}
			}
		});
		btnSubmit.setToolTipText("submit your answers");
		btnSubmit.setFont(SWTResourceManager.getFont("Calibri", 17, SWT.NORMAL));
		btnSubmit.setBounds(447, 714, 213, 33);
		btnSubmit.setText("Submit Answers");
		
		//SEARCH BUTTON
		Button btnSearch = new Button(shlDoggoSelector, SWT.NONE);
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				//GETTING SEARCH RESULTS by calling the appropriate method
				try {
					
				//SEARCH METHOD called
				if (dogApp.getBreedSearch(searchBox.getText()) == false) {
						MessageDialog.openError(shlDoggoSelector, "Search Error", "No dog breed matches this search. Try another breed search, or perhaps check your spelling.");
						return;				
				}
				
				
				//SEARCH RESULT VARIABLES TO BE DISPLAYED
				String searchBark= new String();
				String searchTrain= new String();
				String searchActive= new String();
				String searchSize= new String();
				String searchShed= new String();
				String searchKF= new String();
				String searchDF= new String();
				String searchLifeSpan= new String();
				
				//SEARCH RESULT ATTRIBUTE STRINGS
				searchBark = dogApp.getSearchResult().getBarkingTendencies() == 1 ? "Low" :  dogApp.getSearchResult().getBarkingTendencies() == 2 ? "Moderate" :  dogApp.getSearchResult().getBarkingTendencies() == 3 ? "Frequent" : "error";
				searchTrain =  dogApp.getSearchResult().getTrainability() == 1 ? "Low" :  dogApp.getSearchResult().getTrainability() == 2 ? "Average" :  dogApp.getSearchResult().getTrainability() == 3 ? "Highly" : "error";
				searchActive =  dogApp.getSearchResult().getActiveLevel() == 1 ? "Lazy" :  dogApp.getSearchResult().getActiveLevel() == 2 ? "Average" :  dogApp.getSearchResult().getActiveLevel() == 3 ? "Highly" : "error";
				searchSize =  dogApp.getSearchResult().getSize() == 1 ? "Small" :  dogApp.getSearchResult().getSize() == 2 ? "Medium" :  dogApp.getSearchResult().getSize() == 3 ? "Large" :  dogApp.getSearchResult().getSize() == 4 ?  "Giant" : "error";
				searchShed =  dogApp.getSearchResult().isShedsMuch() == true ? "Yes" :  dogApp.getSearchResult().isShedsMuch() == false ? "No" : "error";
				searchKF =  dogApp.getSearchResult().isKidFriendly() == true ? "Yes" :  dogApp.getSearchResult().isKidFriendly() == false ? "No" : "error";
				searchDF =  dogApp.getSearchResult().isDogFriendly() == true ? "Yes" :  dogApp.getSearchResult().isDogFriendly() == false ? "No" : "error";
				searchLifeSpan +=  dogApp.getSearchResult().getLifeSpan();
				
				
				//DISPLAYING SEARCH RESULT
				lblBreedSDisplay.setText(dogApp.getSearchResult().getBreedName());			
				lblBarkSDisplay.setText(searchBark);
				lblTrainSDisplay.setText(searchTrain);
				lblActiveSDisplay.setText(searchActive);
				lblSizeSDisplay.setText(searchSize);
				lblShedSDisplay.setText(searchShed);
				lblKFSDisplay.setText(searchKF);
				lblDFSDisplay.setText(searchDF);
				lblLifeSpanSDisplay.setText(searchLifeSpan);
				
				//DISPLAY SEARCH RESULT CATEGORIES
				lblSearchResults.setText("Search Results");
				lblBreedSHeader.setText("Breed");
				lblBarkSHeader.setText("Barking");
				lblTrainSHeader.setText("Trainability");
				lblActiveSHeader.setText("Active");
				lblSizeSHeader.setText("Size");
				lblShedSHeader.setText("Shed");
				lblKFSHeader.setText("Kid Friendly");
				lblDFSHeader.setText("Dog Friendly");
				lblLifeSpanSHeader.setText("Lifespan");
				
				}
				
				catch (Exception exc) {
					// try catch will display an error message if no match is found, and searchResult is null
					System.out.println("ERRORRRR");
					MessageDialog.openError(shlDoggoSelector, "Search Error", "No dog breed matches this search. Try another breed search, or perhaps check your spelling.");
					return;
				}
				
			
				
			}
		});
		btnSearch.setToolTipText("submit your answers");
		btnSearch.setText("Breed Search");
		btnSearch.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		btnSearch.setBounds(921, 723, 186, 21);
		
		
	
		
	}
}
