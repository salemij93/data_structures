package ratings;

import java.util.Comparator;

public class RestaurantRating implements Comparable<RestaurantRating>{
	private String name;
	private String priceRange;
	private String cuisine;
	private Integer rating;
	public static final Comparator<RestaurantRating> byRating = new ByRating(); 
	
	public RestaurantRating(String name, String priceRange, String cuisine, Integer rating) {
		this.name = name;
		this.priceRange = priceRange;
		this.cuisine = cuisine;
		this.rating = rating;
	}
	
	public String name() {return name;}
	public String priceRange() {return priceRange;}
	public String cuisine() {return cuisine;}
	public int rating() {return rating;}
	
	public String toString() {
		return name + " " + priceRange + " " + cuisine + " " + rating;
	}

	
	public int compareTo(RestaurantRating that) {
		return this.name.compareTo(that.name);
	}
	
	private static class ByRating implements Comparator<RestaurantRating>{
		public int compare(RestaurantRating rr1, RestaurantRating rr2) {
			return rr1.rating.compareTo(rr2.rating);
		}
	}

}
