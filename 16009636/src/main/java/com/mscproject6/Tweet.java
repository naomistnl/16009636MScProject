package com.mscproject6;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tweet {

private String Tweet;
private String place__fullName;
private String geoLocation__longitude;
private String geoLocation__latitude;


	public String getTweet() {
		return Tweet;
	}

	public void setTweet(String tweet) {
		Tweet = tweet;
	}

	public String getPlace__fullName() {
		return place__fullName;
	}

	public void setPlace__fullName(String place__fullName) {
		this.place__fullName = place__fullName;
	}

	public String getGeoLocation__longitude() {
		return geoLocation__longitude;
	}

	public void setGeoLocation__longitude(String geoLocation__longitude) {
		this.geoLocation__longitude = geoLocation__longitude;
	}

	public String getGeoLocation__latitude() {
		return geoLocation__latitude;
	}

	public void setGeoLocation__latitude(String geoLocation__latitude) {
		this.geoLocation__latitude = geoLocation__latitude;
	}

	@Override
	public String toString() {
		return "Text: " + getGeoLocation__longitude()+  "Location: " + place__fullName + "Longitude: " + geoLocation__longitude + "Latitude: " + geoLocation__latitude;
	}
}
