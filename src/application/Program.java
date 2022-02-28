package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
//		Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data
//		de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em
//		dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar
//		novamente a reserva com os dados atualizados. O programa não deve aceitar dados
//		inválidos para a reserva, conforme as seguintes regras:
//				- Alterações de reserva só podem ocorrer para datas futuras
//				- A data de saída deve ser maior que a data de entrada
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {	
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			reservation.updateDates(checkin, checkout);
	
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation " + e.getMessage());
		}
		sc.close();
	}
}
