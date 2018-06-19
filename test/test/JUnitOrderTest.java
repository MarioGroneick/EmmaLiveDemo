package test;

import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.loadui.testfx.GuiTest;

import application.Model;
import application.Order;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;


public class JUnitOrderTest extends GuiTest{
	private Model model = new Model();
	float bill = 25.55f;
	float money1 = 25.55f;
	float money2 = 30f;
	float money3 = 20f;
	float money = 0f;
	float change;
	boolean digitalPay = true;
	@Rule
	  public final ExpectedException exception = ExpectedException.none();
	/**
	 * Anweisungsüberdeckender Test für das Zusammenrechnen einer Bestellung
	 * 
	 */
	@Test
	public void testCalcBill(){
		List<Order> orders = new ArrayList<>();
		orders.add(new Order("Wasser", 0.99f));
		orders.add(new Order("Gesamtbetrag", 0.99f));
		orders.add(new Order("Wasser", 0.99f));
		orders.add(new Order("Vorspeise", 0.99f));
		orders.add(new Order("Gesamtbetrag", 1.98f));
		
		assertThat(model.calcBill(orders), (samePropertyValuesAs(orders.get(orders.size()-1).getPrice())));
	}
	@Test
	public void testPayMethodWithDigitalPay() throws Exception {
		change = model.pay(this.bill, this.money, this.digitalPay);
		assertTrue((change == 0));
	}
	@Test
	public void testPayMethodNullsumWithoutDigPay() throws Exception {
		change = model.pay(bill, money1, !digitalPay);
		assertTrue((change == 0));
	}
	@Test
	public void testPayMethodWithPosChange() throws Exception {
		change = model.pay(bill, money2, !digitalPay);
		assertTrue((change == (bill-money2)));
	}
	@Test
	public void testPayMethodWithNegChange() throws Exception {
		exception.expect(Exception.class);
		change = model.pay(bill, money3, !digitalPay);
	}
	
/**
 * UI Tests mit TestFX Framework 
 * 
 * Pfadüberdeckung -> Jede Anweisung der UI wird über diese UI Tests mindestens einmal durchgeführt
 */
	@Override
	protected Parent getRootNode() {
		Parent parent = null;
		try {
			parent = FXMLLoader.load(getClass().getResource("/application/GUI_Demo.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parent;
	}
	@Test
	public void testFirstOrder(){
		Order testorder = new Order("Wasser", 0.99f);
		Button firstOrderButton = find("#firstOrder");
		click(firstOrderButton);
		TableView<Order> tableView = find("#table");
		Order order = tableView.getItems().get(0);
		assertThat(order, (samePropertyValuesAs(testorder)));
	}
	@Test
	public void testSecondOrder(){
		Order testorder = new Order("Vorspeise", 1.99f);
		Button firstOrderButton = find("#secondOrder");
		click(firstOrderButton);
		TableView<Order> tableView = find("#table");
		Order order = tableView.getItems().get(0);
		assertThat(order, (samePropertyValuesAs(testorder)));
	}
	@Test
	public void testThirdOrder(){
		Order testorder = new Order("Angebotsmenu", 5.00f);
		Button firstOrderButton = find("#thirdOrder");
		click(firstOrderButton);
		TableView<Order> tableView = find("#table");
		Order order = tableView.getItems().get(0);
		assertThat(order, (samePropertyValuesAs(testorder)));
	}
	@Test
	public void testFourthOrder(){
		Order testorder = new Order("Menu 1", 12.99f);
		Button firstOrderButton = find("#fourthOrder");
		click(firstOrderButton);
		TableView<Order> tableView = find("#table");
		Order order = tableView.getItems().get(0);
		assertThat(order, (samePropertyValuesAs(testorder)));
	}
	@Test
	public void testFithOrder(){
		Order testorder = new Order("Menu 2", 10.50f);
		Button firstOrderButton = find("#fithOrder");
		click(firstOrderButton);
		TableView<Order> tableView = find("#table");
		Order order = tableView.getItems().get(0);
		assertThat(order, (samePropertyValuesAs(testorder)));
	}
	@Test
	public void testSixthOrder(){
		Order testorder = new Order("Menu 3", 9.99f);
		Button firstOrderButton = find("#sixthOrder");
		click(firstOrderButton);
		TableView<Order> tableView = find("#table");
		Order order = tableView.getItems().get(0);
		assertThat(order, (samePropertyValuesAs(testorder)));
	}
	@Test
	public void testSeventhOrder(){
		Order testorder = new Order("Nachspeise 1",  5.25f);
		Button firstOrderButton = find("#seventhOrder");
		click(firstOrderButton);
		TableView<Order> tableView = find("#table");
		Order order = tableView.getItems().get(0);
		assertThat(order, (samePropertyValuesAs(testorder)));
	}
	@Test
	public void testEightOrder(){
		Order testorder = new Order("Nachspeise 2", 10.00f);
		Button firstOrderButton = find("#eightOrder");
		click(firstOrderButton);
		TableView<Order> tableView = find("#table");
		Order order = tableView.getItems().get(0);
		assertThat(order, (samePropertyValuesAs(testorder)));
	}
	@Test
	public void testNinthOrder(){
		Order testorder = new Order("Nachspeise 3",12.99f);
		Button firstOrderButton = find("#ninthOrder");
		click(firstOrderButton);
		TableView<Order> tableView = find("#table");
		Order order = tableView.getItems().get(0);
		assertThat(order, (samePropertyValuesAs(testorder)));
	}
	@Test
	public void testBestaetigen(){
		Order gesamtBetrag = new Order("Gesamtbetrag", 2.98f);
		Button firstOrderButton = find("#firstOrder");
		Button secondOrderButton = find("#secondOrder");
		click(firstOrderButton);
		click(secondOrderButton);
		Button bestaetigenButton = find("#bestaetigen");
		click(bestaetigenButton);
		TableView<Order> tableView = find("#table");
		Order order = tableView.getItems().get(tableView.getItems().size()-1);
		assertThat(order, (samePropertyValuesAs(gesamtBetrag)));
	}
	@Test
	public void testTrinkgeld(){
		Order testorder = new Order("Nachspeise 3",12.99f);
		Button firstOrderButton = find("#ninthOrder");
		click(firstOrderButton);
		Button tipButton = find("#zeroButton");
		click(tipButton);
		TableView<Order> tableView = find("#table");
		Order order = tableView.getItems().get(tableView.getItems().size()-1);
		assertThat((float)order.getPrice(), (samePropertyValuesAs((float)(testorder.getPrice()*0.1))));
	}
	
	/**
	 * Ende der Anweisungsüberdeckung
	 */
}
