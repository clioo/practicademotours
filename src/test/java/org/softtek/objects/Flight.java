package org.softtek.objects;

public class Flight {
	private String type;
	private String numberOfPassengers;
	private String departingFrom;
	private String onDateMonth;
	private String onDateDay;
	private String arrivingIn;
	private String returningDateMonth;
	private String returningDateDay;
	private String serviceClass;
	private String airLinePreference;
	private String selectedDepartAirline;
	private String selectedReturnAirline;
	private String selectedDepartPrice;
	private String selectedReturnPrice;

	public Integer getTotalPrice(){
		Integer departPrice =  Integer.parseInt(selectedDepartPrice);
		Integer returnPrice =  Integer.parseInt(selectedReturnPrice);
		return (departPrice + returnPrice) * Integer.parseInt(numberOfPassengers);
	}
	public Integer getTotalPrice(Integer taxes){
		Integer departPrice =  Integer.parseInt(selectedDepartPrice);
		Integer returnPrice =  Integer.parseInt(selectedReturnPrice);
		System.out.println("en flight: " + selectedDepartPrice);
		System.out.println("en flight: " + selectedReturnPrice);
		return ((departPrice + returnPrice) * Integer.parseInt(numberOfPassengers)) + taxes;
	}

	public String getSelectedReturnPrice() {
		return selectedReturnPrice;
	}

	public void setSelectedReturnPrice(String selectedReturnPrice) {
		this.selectedReturnPrice = selectedReturnPrice;
	}

	public String getSelectedDepartPrice() {
		return selectedDepartPrice;
	}

	public void setSelectedDepartPrice(String selectedDepartPrice) {
		this.selectedDepartPrice = selectedDepartPrice;
	}


	
	public String getSelectedReturnAirline() {
		return selectedReturnAirline;
	}

	public void setSelectedReturnAirline(String selectedReturnAirline) {
		this.selectedReturnAirline = selectedReturnAirline;
	}

	public String getSelectedDepartAirline() {
		return selectedDepartAirline;
	}

	public void setSelectedDepartAirline(String selectedDepartAirline) {
		this.selectedDepartAirline = selectedDepartAirline;
	}

	
	public Flight(String type, String numberOfPassengers, String departingFrom, String onDateMonth, String onDateDay,
			String arrivingIn, String returningDateMonth, String returningDateDay, String serviceClass,
			String airLinePreference) {
		super();
		this.type = type;
		this.numberOfPassengers = numberOfPassengers;
		this.departingFrom = departingFrom;
		this.onDateMonth = onDateMonth;
		this.onDateDay = onDateDay;
		this.arrivingIn = arrivingIn;
		this.returningDateMonth = returningDateMonth;
		this.returningDateDay = returningDateDay;
		this.serviceClass = serviceClass;
		this.airLinePreference = airLinePreference;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(String numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	public String getDepartingFrom() {
		return departingFrom;
	}
	public void setDepartingFrom(String departingFrom) {
		this.departingFrom = departingFrom;
	}
	public String getOnDateMonth() {
		return onDateMonth;
	}
	public void setOnDateMonth(String onDateMonth) {
		this.onDateMonth = onDateMonth;
	}
	public String getOnDateDay() {
		return onDateDay;
	}
	public void setOnDateDay(String onDateDay) {
		this.onDateDay = onDateDay;
	}
	public String getArrivingIn() {
		return arrivingIn;
	}
	public void setArrivingIn(String arrivingIn) {
		this.arrivingIn = arrivingIn;
	}
	public String getReturningDateMonth() {
		return returningDateMonth;
	}
	public void setReturningDateMonth(String returningDateMonth) {
		this.returningDateMonth = returningDateMonth;
	}
	public String getReturningDateDay() {
		return returningDateDay;
	}
	public void setReturningDateDay(String returningDateDay) {
		this.returningDateDay = returningDateDay;
	}
	public String getServiceClass() {
		return serviceClass;
	}
	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}
	public String getAirLinePreference() {
		return airLinePreference;
	}
	public void setAirLinePreference(String airLinePreference) {
		this.airLinePreference = airLinePreference;
	}
}
