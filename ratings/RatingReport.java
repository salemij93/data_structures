package ratings;

import stdlib.*;
import java.util.*;


public class RatingReport {

	public static void main(String[] args) {
		StdIn.fromFile("data/restaurantratings.txt");
		ArrayList<RestaurantRating> allRatings = new ArrayList<>();
		
		while(!StdIn.isEmpty()) {
			
			String line = StdIn.readLine();
			String[] fields = line.split("\\s+");
			String name = fields[0];
			String priceRange = fields[1];
			String cuisine = fields[2];
			Integer rating = Integer.parseInt(fields[3]);
			allRatings.add(new RestaurantRating(name, priceRange, cuisine, rating));
						
		}
		
		Collections.sort(allRatings);
		StdOut.println("Restaurants ordered by name:");
		for(RestaurantRating newrating: allRatings) {
			StdOut.println(newrating);
		}
		StdOut.println();
		
		Collections.sort(allRatings, RestaurantRating.byRating);
		StdOut.println("Restaurants ordered by rating:");
		
		for(RestaurantRating newrating: allRatings) {
			StdOut.println(newrating);
		}
		

	}

}
