package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-In date (dd/MM/YYY)");
		Date checkIn =  sdf.parse(sc.next());
		System.out.print("Check-Out date (dd/MM/YYY)");
		Date checkOut =  sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro i nreservation: check-out date must be after check-in date.");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-In date (dd/MM/YYY)");
			checkIn =  sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/YYY)");
			checkOut =  sdf.parse(sc.next());
			
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			}
		
			
			sc.close();
		
	}
		
		
		

	

}

