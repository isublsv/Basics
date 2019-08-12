package by.epam.code_review.module6.task03.entity;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private String zip;
	private String city;
	private String street;
	private String building;
	private String apartment;

	public Address() {
		this.zip = "";
		this.city = "";
		this.street = "";
		this.building = "";
		this.apartment = "";
	}

	public Address(String zip, String city, String street, String building, String apartment) {
		this.zip = zip;
		this.city = city;
		this.street = street;
		this.building = building;
		this.apartment = apartment;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Address address = (Address) o;

		if (!zip.equals(address.zip)) {
			return false;
		}
		if (!city.equals(address.city)) {
			return false;
		}
		if (!street.equals(address.street)) {
			return false;
		}
		if (!building.equals(address.building)) {
			return false;
		}
		return apartment.equals(address.apartment);
	}

	@Override
	public int hashCode() {
		int result = zip.hashCode();
		result = 31 * result + city.hashCode();
		result = 31 * result + street.hashCode();
		result = 31 * result + building.hashCode();
		result = 31 * result + apartment.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return String.format("Address: %s, %s, %s, %s/%s", zip, city, street, building, apartment);
	}
}
