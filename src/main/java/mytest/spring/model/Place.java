package mytest.spring.model;


public class Place {
	private Integer _id;

	private String key;

	private String name;

	private String fullName;

	private String iata_airport_code;

	private String type;

	private String country;

	private GeoPosition geo_position;

	private String locationId;

	private Boolean inEurope;

	private String countryCode;

	private Boolean coreCountry;

	private String distance;

	
	public static String[] HEADERS = { "Id", "Name", "Full Name", "Iata Airport Code",
			"Type", "Country", "In Europe", "Country Code", "Latitude",  "Longitude"};
	
	public static String[] FIELDS_MAPPING = { "_Id", "Name", "FullName", "Iata_Airport_Code",
		"Type", "Country", "InEurope", "CountryCode", "geo_position.latitude",  "geo_position.longitude"};
	

	public Integer get_id() {
		return _id;
	}

	public void set_id(Integer _id) {
		this._id = _id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public Boolean getInEurope() {
		return inEurope;
	}

	public void setInEurope(Boolean inEurope) {
		this.inEurope = inEurope;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Boolean getCoreCountry() {
		return coreCountry;
	}

	public void setCoreCountry(Boolean coreCountry) {
		this.coreCountry = coreCountry;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getIata_airport_code() {
		return iata_airport_code;
	}

	public void setIata_airport_code(String iata_airport_code) {
		this.iata_airport_code = iata_airport_code;
	}

	public GeoPosition getGeo_position() {
		return geo_position;
	}

	public void setGeo_position(GeoPosition geo_position) {
		this.geo_position = geo_position;
	}

	@Override
	public String toString() {
		return "Place [_id=" + _id + ", key=" + key + ", name=" + name
				+ ", fullName=" + fullName + ", iata_airport_code="
				+ iata_airport_code + ", type=" + type + ", country=" + country
				+ ", geo_position=" + geo_position + ", locationId="
				+ locationId + ", inEurope=" + inEurope + ", countryCode="
				+ countryCode + ", coreCountry=" + coreCountry + ", distance="
				+ distance + "]";
	}

	

	
	
}


