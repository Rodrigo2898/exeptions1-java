package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
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
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		
		//verificando se a data de check-out é posterior a data de check-in
		if(!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
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
			
			String error = reservation.updateDates(checkin, checkout);
			if(error != null) {
				System.out.println("Error in reservation: " + error);
			}
			else {
				System.out.println("Reservation: " + reservation);
			}
		}
		sc.close();
	}
}
