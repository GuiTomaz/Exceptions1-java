package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.printf("Room number: ");
			int number = sc.nextInt();
			System.out.printf("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.printf("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
		
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println(" ");
			System.out.println("Enter data to update the reservation: ");
			System.out.printf("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.printf("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			

			reservation.updateDates(checkIn, checkOut);
		
			System.out.println("Reservation: " + reservation);
		}catch(ParseException e) {
			System.out.println("Invalid date format");
		}catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch(RuntimeException e) {
			//Impede que o programa quebre em caso de erros n?o tratados
			System.out.println("Unexpected error. ");
		}
		
	
			
			
		
		
		sc.close();
	}

}
