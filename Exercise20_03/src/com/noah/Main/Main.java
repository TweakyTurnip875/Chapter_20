package com.noah.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {

  	public static String[][] stateCapital = {
    	      {"Alabama", "Montgomery"},
    	      {"Alaska", "Juneau"},
    	      {"Arizona", "Phoenix"},
    	      {"Arkansas", "Little Rock"},
    	      {"California", "Sacramento"},
    	      {"Colorado", "Denver"},
    	      {"Connecticut", "Hartford"},
    	      {"Delaware", "Dover"},
    	      {"Florida", "Tallahassee"},
    	      {"Georgia", "Atlanta"},
    	      {"Hawaii", "Honolulu"},
    	      {"Idaho", "Boise"},
    	      {"Illinois", "Springfield"},
    	      {"Indiana", "Indianapolis"},
    	      {"Iowa", "Des Moines"},
    	      {"Kansas", "Topeka"},
    	      {"Kentucky", "Frankfort"},
    	      {"Louisiana", "Baton Rouge"},
    	      {"Maine", "Augusta"},
    	      {"Maryland", "Annapolis"},
    	      {"Massachusettes", "Boston"},
    	      {"Michigan", "Lansing"},
    	      {"Minnesota", "Saint Paul"},
    	      {"Mississippi", "Jackson"},
    	      {"Missouri", "Jefferson City"},
    	      {"Montana", "Helena"},
    	      {"Nebraska", "Lincoln"},
    	      {"Nevada", "Carson City"},
    	      {"New Hampshire", "Concord"},
    	      {"New Jersey", "Trenton"},
    	      {"New York", "Albany"},
    	      {"New Mexico", "Santa Fe"},
    	      {"North Carolina", "Raleigh"},
    	      {"North Dakota", "Bismarck"},
    	      {"Ohio", "Columbus"},
    	      {"Oklahoma", "Oklahoma City"},
    	      {"Oregon", "Salem"},
    	      {"Pennsylvania", "Harrisburg"},
    	      {"Rhode Island", "Providence"},
    	      {"South Carolina", "Columbia"},
    	      {"South Dakota", "Pierre"},
    	      {"Tennessee", "Nashville"},
    	      {"Texas", "Austin"},
    	      {"Utah", "Salt Lake City"},
    	      {"Vermont", "Montpelier"},
    	      {"Virginia", "Richmond"},
    	      {"Washington", "Olympia"},
    	      {"West Virginia", "Charleston"},
    	      {"Wisconsin", "Madison"},
    	      {"Wyoming", "Cheyenne"}

  	  };

	  public static void main(String[] args) {

		  List<List<String>> arr = new ArrayList<List<String>>();  

		  

		  for(int i = 0; i < stateCapital.length; i++) {

			  arr.add(Arrays.asList(stateCapital[i]));  

		  }
		  Collections.shuffle(arr);

		  Scanner sc = new Scanner(System.in);
		  
		  int correct = 0;
		  
		  for(int i = 0; i < stateCapital.length; i++) {
			  
			  System.out.println("What is the capital of " + arr.get(i).get(0));
			  String cap = sc.nextLine().trim().toLowerCase();
			  
			  if(cap.equals(arr.get(i).get(1).toLowerCase())) {
				  System.out.println("Your answer is correct.");
				  correct++;
			  } else {
				  System.out.println("The correct answer should be " + arr.get(i).get(1));
			  }
		  }
		  
		  System.out.println("The correct count is " + correct);
	  }
}