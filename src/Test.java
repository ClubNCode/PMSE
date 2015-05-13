import org.apache.commons.lang.StringUtils;

public class Test {

	public static void main(String[] args) throws Exception {




		String firstname1 = "Gachibowli, Hyatt Hyderabad is set in acres of naturally beautiful landscape, complete with lush foliage, natural rock formations, and tranquil water features. Hyatt Hyderabad Gachibowli offers 166 rooms including 9 suites, featuring pool or garden views as well as the latest in-room technology for the corporate traveler. Luxury rooms offer a spacious outdoor private balcony while suites are expansive with a private garden area, separate meeting area and a pantry. The hotel features also two restaurants offering authentic cuisine and one lounge as well as a world class spa spread over 10,000 square feet, combining the integration of yoga, ayurveda, meditation and international treatments. Hyatt Hyderabad Gachibowli also offers indoor and outdoor meeting and special events facilities for medium-sized events including two private meeting rooms ideal for small group gatherings";
	    firstname1 = firstname1.replaceAll("[0-9]","");
	    System.out.println(firstname1);
	}

}