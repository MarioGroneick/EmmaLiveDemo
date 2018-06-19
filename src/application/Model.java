package application;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	
	public float calcBill(List<Order> orders){
		float sum = 0;
		int counter = 0;
		for (int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getName().equals("Gesamtbetrag"))
			 counter = i;
		}
		for (int i = counter; i< orders.size(); i++ ){
			sum += orders.get(i).getPrice();
		}
		return sum;
	}
			
	public ArrayList<Order> createOrders(){
		ArrayList<Order> list = new ArrayList<>();
		return list;
	}
	
	public float pay(float bill, float money, boolean digitalPaid) throws Exception{
		float sum = bill -money;
		if(digitalPaid){
			return 0;
		} else if(sum > 0) {
			throw new Exception("zu wenig Geld bezahlt, bitte überprüfen.");
		} 
		return sum;
	}
	
	public float calcSalatPrice(List<salatAuswahl> auswahl) {
		float price = 0;
		for (salatAuswahl salatAuswahl : auswahl) {
			price += salatAuswahl.getPrice();
		}
		return price;
	}
}
