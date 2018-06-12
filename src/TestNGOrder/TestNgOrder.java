package TestNGOrder;

import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import application.Model;
import application.Order;

public class TestNgOrder {
	private Model model = new Model();
	float bill = 25.55f;
	float money1 = 25.55f;
	float money2 = 30f;
	float money3 = 20f;
	float money = 0f;
	float change;
	boolean digitalPay = true;
	
	@Test
	public void testCalcBill(){
		List<Order> orders = new ArrayList<>();
		orders.add(new Order("Wasser", 0.99f));
		orders.add(new Order("Gesamtbetrag", 0.99f));
		orders.add(new Order("Wasser", 0.99f));
		orders.add(new Order("Vorspeise", 0.99f));
		orders.add(new Order("Gesamtbetrag", 1.98f));
		
		
		//model.calcBill(orders), (samePropertyValuesAs(orders.get(orders.size()-1).getPrice()))
		Assert.assertEquals(model.calcBill(orders), orders.get(orders.size()-1).getPrice());
	}
	
	@Test
	public void testPayMethodWithDigitalPay() throws Exception {
		change = model.pay(this.bill, this.money, this.digitalPay);
		Assert.assertEquals(change, 0f);
	}
	@Test
	public void testPayMethodNullsumWithoutDigPay() throws Exception {
		change = model.pay(bill, money1, !digitalPay);
		Assert.assertEquals(change, 0f);
	}
	@Test
	public void testPayMethodWithPosChange() throws Exception {
		change = model.pay(bill, money2, !digitalPay);
		Assert.assertEquals(change, (bill-money2));
	}
	@Test(expectedExceptions = Exception.class)
	public void testPayMethodWithNegChange() throws Exception {
		change = model.pay(bill, money3, !digitalPay);
	}
}
