package example.example.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.CookieManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.lang3.math.NumberUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import example.example.factory.PageinstancesFactory;
import example.example.pages.Crown_Castle_gamesforthebrain_game_checkersPage;
import example.example.pages.GooglePage;
import example.example.util.LoggerUtil;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * The Class deckofcardsapi.
 *
 * @author Sumit
 */
@Test(testName = "deckofcardsapi test", description = "Test description")
public class deckofcardsapi extends BaseTest {

	/**
	 * deckofcardsapi test.
	 * @throws InterruptedException 
	 */
	public static int finaltotalvalueint,totalvalueint;
	@Test
	public void deckofcardsapiTest() throws InterruptedException {
		
		//1.	Navigate to https://deckofcardsapi.com/
		//2.	Confirm the site is up
		
				String Url = "https://deckofcardsapi.com/";
				driver.get(Url);				
				LoggerUtil.log("Navigate to : Url " + Url );
				System.out.println("Navigate to : Url " + Url );
				
				//2. Confirm that the site is up
				Assert.assertTrue(driver.getTitle().contains("Deck of Cards API"), "Title doesn't contain Checkers : Test Failed");
				LoggerUtil.log("Confirm that the site is up : " + driver.getTitle() );
				System.out.println("Confirm that the site is up : " + driver.getTitle() );
		
		//3.	Get a new deck
		
		RestAssured.baseURI = "https://deckofcardsapi.com/api/deck/new/"; 		 
		RequestSpecification httpRequest1 = RestAssured.given(); 		  
		Response response1 = httpRequest1.request(Method.GET, "");		 
		//System.out.println("Status received => " + response1.getStatusLine()); 
		//System.out.println("Response=>" + response1.prettyPrint());	
		
		JsonPath j = response1.jsonPath();		
		Object deck_id=j.get("deck_id");
		Object shuffled=j.get("shuffled");
		System.out.println("================================================================");
		System.out.println("deck ID   is  : " + deck_id);
		LoggerUtil.log("deck ID   is  : " + deck_id);
		System.out.println("shuffled Status is  : " + shuffled);
		LoggerUtil.log("shuffled Status is  : " + shuffled);
		
		System.out.println("================================================================");
		
		//4.	Shuffle it
		
		RestAssured.baseURI = "https://deckofcardsapi.com/api/deck/"+ deck_id + "/shuffle/"; 		 
		RequestSpecification httpRequest2 = RestAssured.given(); 		  
		Response response2 = httpRequest2.request(Method.GET, "");		 
		//System.out.println("Status received => " + response2.getStatusLine()); 
		//System.out.println("Response=>" + response2.prettyPrint());	
		
		JsonPath j1 = response2.jsonPath();		
		Object deck_id1=j1.get("deck_id");
		Object shuffled1=j1.get("shuffled");
		System.out.println("================================================================");
		System.out.println("deck ID   is  : " + deck_id1);
		LoggerUtil.log("deck ID   is  : " + deck_id1);
		System.out.println("shuffled Status is  : " + shuffled1);
		LoggerUtil.log("shuffled Status is  : " + shuffled1);
		System.out.println("================================================================");
		TimeUnit.SECONDS.sleep(2);
		//5.	Deal three cards to each of two players
		//int i=0;
		for (int i=0; i<=5 ;i++) {
		RestAssured.baseURI = "https://deckofcardsapi.com/api/deck/"+ deck_id1 + "/draw/?count=1"; 		 
		RequestSpecification httpRequest3 = RestAssured.given(); 		  
		Response response3 = httpRequest3.request(Method.GET, "");		 
		//System.out.println("Status received => " + response2.getStatusLine()); 
		//System.out.println("Response=>" + response2.prettyPrint());
		
		JsonPath j2 = response3.jsonPath();	
			
		Object deck_id3=j2.get("deck_id");
		Object remaining=j2.get("remaining");
		Object value=j2.get("value");
		JSONObject jsonObject = new JSONObject(response3.prettyPrint());
		List<String> list = new ArrayList<String>();
	      JSONArray jsonArray = jsonObject.getJSONArray("cards");
	      for(int k = 0 ; k < jsonArray.length(); k++) {
	         list.add(jsonArray.getJSONObject(k).getString("value"));
	         String totalvalue = list.get(k);
	         System.out.println("value  of card is : " +jsonArray.getJSONObject(k).getString("value"));
	         LoggerUtil.log("value  of card is : " +jsonArray.getJSONObject(k).getString("value"));
	        if (NumberUtils.isParsable(totalvalue) ) {
	        	totalvalueint=Integer.parseInt(totalvalue);
	        	finaltotalvalueint=finaltotalvalueint+totalvalueint;
	        	System.out.println("Final card value is  : " + finaltotalvalueint);
	        	 LoggerUtil.log("Final card value is  : " + finaltotalvalueint);
	        	//6.	Check whether either has blackjack
				// Add the Total value of cards 
	        	
	        	if (finaltotalvalueint==24) {
					System.out.println("================================================================");
					 
					System.out.println("Blackjack Yes or No   : " + "True");
					LoggerUtil.log("Blackjack Yes or No   : " + "True");
					
					System.out.println("================================================================");
					
				}
	        	else {System.out.println("Blackjack Yes or No   : " + "False");
	        	LoggerUtil.log("Blackjack Yes or No   : " + "True");}
	        	
	        }       
	        
	
	       }	         
	         
	    //int totalvalueint= 24; 
		if (i==5) {
		System.out.println("================================================================");
		System.out.println("deck ID   is  : " + deck_id3);
		LoggerUtil.log("deck ID   is  : " + deck_id3);
		
		System.out.println("remaining Cards are  : " + remaining);
		LoggerUtil.log("deck ID   is  : " + deck_id3);
		//System.out.println("value  : " + value);
		System.out.println("================================================================");
		
		
				
		} }
		
		
		
		//7.	If either has, write out which one does
		

		
	}	
}
