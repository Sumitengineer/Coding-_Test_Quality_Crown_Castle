package example.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import example.example.factory.PageinstancesFactory;
import example.example.pages.*;
import example.example.util.LoggerUtil;

/**
 * The Class Crown_Castle_gamesforthebrain_game_checkers.
 *
 * @author Sumit
 */
@Test(testName = "Gamesforthebrain - Game : Checkers test", description = "Test description")
public class Crown_Castle_gamesforthebrain_game_checkers extends BaseTest {

	/**
	 * Gamesforthebrain - Game : Checkers test.
	 * @throws InterruptedException 
	 */
	@Test
	public void GamesforthebrainTest() throws InterruptedException {
		//1.	Navigate to https://www.gamesforthebrain.com/game/checkers/
		String Url = "https://www.gamesforthebrain.com/game/checkers/";
		driver.get(Url);
		Crown_Castle_gamesforthebrain_game_checkersPage game_checkersPage = PageinstancesFactory.getInstance(Crown_Castle_gamesforthebrain_game_checkersPage.class);
		LoggerUtil.log("Navigate to : Url " + Url );
		System.out.println("Navigate to : Url " + Url );
		
		//2.	Confirm that the site is up
		Assert.assertTrue(driver.getTitle().contains("Checkers"), "Title doesn't contain Checkers : Test Failed");
		LoggerUtil.log("Confirm that the site is up : " + driver.getTitle() );
		System.out.println("Confirm that the site is up : " + driver.getTitle() );
		
		//3.	Make 1 legal moves as orange:			
				
		game_checkersPage.makeaMoveAsOrange("62","53");
		
		//a) Include taking a blue piece capture the move 
		
		game_checkersPage.takingaMoveAsblue("15","24");
		
		//3.	Make Next 3 legal moves as orange:	
		game_checkersPage.makeaMoveAsOrange("42","33");
		game_checkersPage.makeaMoveAsOrange("22","33");
		
		
		
		//Check if Restart Link Exist and click Restart
		//c)	Restart the game after five moves	
		//d) Confirm that the restarting had been successful 		
		game_checkersPage.RestartandConfirm("Restart...");
		
	}
}
