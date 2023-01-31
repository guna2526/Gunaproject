package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.ReusableMethods;
public class SearchHotelPage extends ReusableMethods {
	
		public SearchHotelPage() {
			PageFactory.initElements(driver, this);
		}
		@FindBy(id="location")
		private WebElement ddLocation;
		@FindBy(id="hotels")
		private WebElement ddHotels;
		@FindBy(id="room_type")
		private WebElement ddRoomType;
		@FindBy(id="room_nos")
		private WebElement ddRoomNos;
		@FindBy(id="datepick_in")
		private WebElement txtCheckIn;
		@FindBy(id="datepick_out")
		private WebElement txtCheckOut;
		@FindBy(id="adult_room")
		private WebElement ddadults;
		@FindBy(id="child_room")
		private WebElement ddChild;
		@FindBy(id="Submit")
		private WebElement btnSubmit;
		@FindBy(id="location_span")
		private WebElement locError;
		@FindBy(id="checkin_span")
		private WebElement checkInError;
		@FindBy(id="checkout_span")
		private WebElement checkOutError;
		@FindBy(className="login_title")
		private WebElement afterSearchSuccess;
		
		
		
		public WebElement getAfterSearchSuccess() {
			return afterSearchSuccess;
		}
		public WebElement getLocError() {
			return locError;
		}
		public WebElement getCheckInError() {
			return checkInError;
		}
		public WebElement getCheckOutError() {
			return checkOutError;
		}
		public WebElement getDdLocation() {
			return ddLocation;
		}
		public WebElement getDdHotels() {
			return ddHotels;
		}
		public WebElement getDdRoomType() {
			return ddRoomType;
		}
		public WebElement getDdRoomNos() {
			return ddRoomNos;
		}
		public WebElement getTxtCheckIn() {
			return txtCheckIn;
		}
		public WebElement getTxtCheckOut() {
			return txtCheckOut;
		}
		public WebElement getDdadults() {
			return ddadults;
		}
		public WebElement getDdChild() {
			return ddChild;
		}
		public WebElement getBtnSubmit() {
			return btnSubmit;
		}
public void SearchHotelCommonStep(String location,String noOfRooms,String checkInDate,String checkOutDate,String adultsPerRoom){
ddSelectOptionByAttribute(getDdLocation(), location);
ddSelectOptionByAttribute(getDdRoomNos(), noOfRooms);
clear(getTxtCheckIn());
elementSendkeys(getTxtCheckIn(), checkInDate);
clear(getTxtCheckOut());
elementSendkeys(getTxtCheckOut(), checkOutDate);
ddSelectOptionByAttribute(getDdadults(), adultsPerRoom);
	   }
public void searchButton() {
elementClick(getBtnSubmit());
		}
public void searchHotel(String location,String hotels,String roomType,
				String noOfRooms,String checkInDate,String checkOutDate,String adultsPerRoom,
				String childrensPerRoom) {
SearchHotelCommonStep(location,noOfRooms,checkInDate, checkOutDate,adultsPerRoom);	
ddSelectOptionByAttribute(getDdHotels(), hotels);
ddSelectOptionByAttribute(getDdRoomType(), roomType);
ddSelectOptionByAttribute(getDdChild(), childrensPerRoom);
searchButton();
}
public void SearchHotelMantatoryFields(String location,String noOfRooms,String checkInDate,String checkOutDate,String adultsPerRoom){
	SearchHotelCommonStep(location,noOfRooms,checkInDate,checkOutDate,adultsPerRoom);
	searchButton();
	
}
public void searchHotelInvalidDate(String location,String hotels,String roomType,
		String roomNos,String checkIn,String checkOut,String adults,
		String childs) {
	searchHotel(location,hotels,roomType,roomNos,checkIn,checkOut,adults,childs);
}

}
