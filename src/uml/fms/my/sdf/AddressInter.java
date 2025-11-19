package uml.fms.my.sdf;

public class Address {
	
	private String road;
    private String city;
    private int zipCode;

	
	/**
	 * @param road
	 * @param city
	 * @param zipCode
	 */
	public Address(String road, String city, int zipCode) {
		super();
		this.road = road;
		this.city = city;
		this.zipCode = zipCode;
	}
		

	/**
	 * @return the road
	 */
	public String getRoad() {
		return road;
	}

	/**
	 * @param road the road to set
	 */
	public void setRoad(String road) {
		this.road = road;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}



}
