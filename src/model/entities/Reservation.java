package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer rommNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Reservation(Integer rommNumber, Date checkIn, Date checkOut) throws DomainException{
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date.");
		}
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
	
	public void updateDates (Date checkIn, Date checkOut) throws DomainException {
		if (checkIn.before(new Date()) || !checkOut.after(new Date())) {
			throw new DomainException("Reservation dates for update must be future dates.");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date.");
		} 
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
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
