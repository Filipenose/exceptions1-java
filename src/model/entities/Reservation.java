package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkInDate;
	private Date checkOutDate;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	
	
	public Reservation(Integer roomNumber, Date checkInDate, Date checkOutDate) {
		
		this.roomNumber = roomNumber;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}


	public Integer getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	public Date getCheckInDate() {
		return checkInDate;
	}


	public Date getCheckOutDate() {
		return checkOutDate;
	}


	public long duration() {
		long diff = checkOutDate.getTime() - checkInDate.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if (checkIn.before(now) || checkOut.before(now)) {
			return "The dates must be in the future!";
		}
		if (!checkOut.after(checkIn)) {
			return "Erro in nreservation: check-out date must be after check-in date.";
		}
		
		this.checkInDate = checkIn;
		this.checkOutDate = checkOut;
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Room: "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkInDate)
				+ ", check-out"
				+ sdf.format(checkOutDate)
				+ ","
				+ duration()
				+ " nigths: ";
	}
	
	
	
	
}
