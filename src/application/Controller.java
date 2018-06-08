package application;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

	private Model model;
	private List<Order> orders;
	private ObservableList<Order> data;
    @FXML
    private Button bestaetigen;
    @FXML
    private Button firstOrder;
    @FXML
    private Button secondOrder;
    @FXML
    private Button thirdOrder;
    @FXML
    private Button fourthOrder;
    @FXML
    private Button fithOrder;
    @FXML
    private Button sixthOrder;
    @FXML
    private Button seventhOrder;
    @FXML
    private Button eightOrder;
    @FXML
    private Button ninthOrder;
    @FXML
    private Button zeroButton;
    @FXML
    private TableView<Object> table;
    
    public Controller() {
		this.model = new Model();
		orders = model.createOrders();
		data = FXCollections.observableArrayList(orders);
		
	}
    
    @FXML
    public void bestaetigen(ActionEvent event) {
    	float sum = model.calcBill(this.data);
    	data.add(new Order("Gesamtbetrag", sum));
    	setTableView(data);
    }
    
    private void setTableView(ObservableList<Order> data){
    	table.getItems().setAll(data);
    }
    
    @FXML
    private void getFirstOrder(ActionEvent event){
    	data.add(new Order("Wasser", 0.99f));
    	
    	setTableView(data);
    	
    }
    @FXML
    private void getSecondOrder(ActionEvent event){
    	data.add(new Order("Vorspeise", 1.99f));
    	setTableView(data);
    }
    @FXML
    private void getThirdOrder(ActionEvent event){
    	data.add(new Order("Angebotsmenu", 5.00f));
    	setTableView(data);
    }
    @FXML
    private void getFourthOrder(ActionEvent event){
    	data.add(new Order("Menu 1", 12.99f));
    	setTableView(data);
    }
    @FXML
    private void getFithOrder(ActionEvent event){
    	data.add(new Order("Menu 2", 10.50f));
    	setTableView(data);
    }
    @FXML
    private void getSixthOrder(ActionEvent event){
    	data.add(new Order("Menu 3", 9.99f));
    	setTableView(data);
    }
    @FXML
    private void getSeventhOrder(ActionEvent event){
    	data.add(new Order("Nachspeise 1",  5.25f));
    	setTableView(data);
    }
    @FXML
    private void getEightOrder(ActionEvent event){
    	data.add(new Order("Nachspeise 2", 10.00f));
    	setTableView(data);
    }
    @FXML
    private void getNinthOrder(ActionEvent event){
    	data.add(new Order("Nachspeise 3",12.99f));
    	setTableView(data);
    }
    @FXML
    private void getZeroButton(ActionEvent event){
    	float tip = model.calcBill(data) * 0.1f;
    	data.add(new Order("Trinkgeld", tip));
    	setTableView(data);
    }
    

}