package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer rommNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Reservation(Integer rommNumber, Date checkIn, Date checkOut) {
		this.rommNumber = rommNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRommNumber() {
		return rommNumber;
	}
	public void setRommNumber(Integer rommNumber) {
		this.rommNumber = rommNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); // pega o valor em milesegundos 
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converte para dias
	}
	
	public String updateDates (Date checkIn, Date checkOut) {
		if (checkIn.before(new Date()) || !checkOut.after(new Date())) {
			return "Reservation dates for update mus be future dates.";
		}

		if (!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date.";
		} 
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Room " 
		      + rommNumber 
		      + ", check-in: "
			  + sdf.format(checkIn)
		      + ", check-out: "+sdf.format(checkOut)
		      + ", " 
		      + duration()
		      + " night(s).";
	}
	
}
