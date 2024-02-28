package example.example.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import example.example.util.LoggerUtil;

/**
 * The Class represents Crown_Castle_gamesforthebrain_game_checkersPage.
 *
 * @author Sumit
 */
public class Crown_Castle_gamesforthebrain_game_checkersPage extends BasePage {
	
	/** The viewText. */
	//@FindBy(name = "q")
	@FindBy(id = "message")
	
	
	private WebElement viewText_checkerspage;
	private WebElement makeaMoveFrom;
	private WebElement makeaMoveTo;
	private WebElement checkmakeaMovesucess;	
	public static String makeaMoveLinkFromBoxValue;
	public static String makeaMoveLinkToBoxValue;

	/**
	 * Instantiates a new checkers page.
	 *
	 * @param driver the driver
	 */
	public Crown_Castle_gamesforthebrain_game_checkersPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Searches the given text.
	 *
	 * @param key the key
	 * @throws InterruptedException 
	 */
	public void makeaMoveAsOrange(String makeaMoveLinkFromBox,String makeaMoveLinkToBox) throws InterruptedException {
		
		viewText_checkerspage = driver.findElement(By.xpath("//*[@id=\"message\"]")) ;
		String Selectanorangeval = viewText_checkerspage.getText();
		 
		if (Selectanorangeval.equals("Select an orange piece to move.")) {
			
			System.out.println("Ready to make a move : " + Selectanorangeval );
			LoggerUtil.log("Ready to make a move  : " + Selectanorangeval );
		}
		
		//Check if makeaMove box Exists
		String makeaMoveLinkFromBoxValue = "space" + makeaMoveLinkFromBox;
		String makeaMoveLinkToBoxValue = "space" + makeaMoveLinkToBox;
		
		makeaMoveFrom = driver.findElement(By.xpath("//img[@name='" + makeaMoveLinkFromBoxValue + "']")) ;	
		makeaMoveTo = driver.findElement(By.xpath("//img[@name='" + makeaMoveLinkToBoxValue + "']")) ;	
		if (makeaMoveFrom.isDisplayed()) {
			makeaMoveFrom.click();
			TimeUnit.SECONDS.sleep(2);
			System.out.println("================================================================");
			
			System.out.println("Make a legal move FROM as orange : - Success : " + "Box ID : " + makeaMoveLinkFromBox);
			LoggerUtil.log("Make a legal move FROM as orange : - Success : " + "Box ID : " + makeaMoveLinkFromBox);}	
		
			
			makeaMoveTo.click();	
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Make a legal move TO as orange : - Success : " + "Box ID : " + makeaMoveLinkToBox);
			LoggerUtil.log("Make a legal move TO as orange : - Success : " + "Box ID : " + makeaMoveLinkToBox);
			
			System.out.println("================================================================");
		
		checkmakeaMovesucess = driver.findElement(By.xpath("//*[@id=\"message\"]")) ;
		String checkmakeaMovesucessmsg = checkmakeaMovesucess.getText();
		
		//b)	Use “Make a move” as confirmation that you can take the next step
		if (checkmakeaMovesucessmsg.equals("Make a move.")) {
			
			System.out.println("verified a legal move AS orange : - Success : " + checkmakeaMovesucessmsg );
			LoggerUtil.log("verified a legal move AS orange : - Success : " + checkmakeaMovesucessmsg );
			System.out.println("================================================================");
		}
	}
	
public void takingaMoveAsblue(String makeaMoveLinkFromBox,String makeaMoveLinkToBox) throws InterruptedException {
		
		viewText_checkerspage = driver.findElement(By.xpath("//*[@id=\"message\"]")) ;
		String VerifyBlueMove = viewText_checkerspage.getText();
		 
		if (VerifyBlueMove.equals("Select an orange piece to move.")) {
			
			System.out.println("Ready to make a move : " + VerifyBlueMove );
			LoggerUtil.log("Ready to make a move  : " + VerifyBlueMove );
		}
		
		//Check if makeaMove box Exists
		String makeaMoveLinkFromBoxValue = "space" + makeaMoveLinkFromBox;
		String makeaMoveLinkToBoxValue = "space" + makeaMoveLinkToBox;
		
		makeaMoveFrom = driver.findElement(By.xpath("//img[@name='" + makeaMoveLinkFromBoxValue + "']")) ;	
		makeaMoveTo = driver.findElement(By.xpath("//img[@name='" + makeaMoveLinkToBoxValue + "']")) ;	
		if (makeaMoveFrom.isDisplayed()) {
			//makeaMoveFrom.click();
			System.out.println("================================================================");
			
			System.out.println("Verify a legal move FROM as Blue : - Success : " + "Box ID : " + makeaMoveLinkFromBox);
			LoggerUtil.log("Verify a legal move FROM as Blue : - Success : " + "Box ID : " + makeaMoveLinkFromBox);}	
		
			
			//makeaMoveTo.click();	
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Verify a legal move TO as Blue : - Success : " + "Box ID : " + makeaMoveLinkToBox);
			LoggerUtil.log("Verify a legal move TO as Blue : - Success : " + "Box ID : " + makeaMoveLinkToBox);
			
			System.out.println("================================================================");
		
		checkmakeaMovesucess = driver.findElement(By.xpath("//*[@id=\"message\"]")) ;
		String checkmakeaMovesucessmsg = checkmakeaMovesucess.getText();
		
		//b)	Use “Make a move” as confirmation that you can take the next step
		if (checkmakeaMovesucessmsg.equals("Make a move.")) {
			
			System.out.println("verified a legal move AS Blue : - Success : " + checkmakeaMovesucessmsg );
			LoggerUtil.log("verified a legal move AS Blue : - Success : " + checkmakeaMovesucessmsg );
			System.out.println("================================================================");
		}
	}
	
	public void RestartandConfirm(String RestartLink) {
		//Check if Restart Link Exists
		viewText_checkerspage = driver.findElement(By.xpath("//a[contains(text(),'Restart...')]")) ;
		
		String Restart_Link_text = viewText_checkerspage.getText();
		System.out.println("Restart Link Exists : " + Restart_Link_text);
		if (Restart_Link_text.equals("Restart...")) {
			viewText_checkerspage.click();
			System.out.println("Restart Link Clicked : - Success " );
			LoggerUtil.log("Restart Link Clicked : - Success ");
		}
		viewText_checkerspage = driver.findElement(By.xpath("//*[@id=\"message\"]")) ;
		String restarting_sccess = viewText_checkerspage.getText();
		 
		if (restarting_sccess.equals("Select an orange piece to move.")) {
			
			System.out.println("Confirm that the restarting had been successful : " + restarting_sccess );
			LoggerUtil.log("Confirm that the restarting had been successful : " + restarting_sccess );
		}
	}

}
