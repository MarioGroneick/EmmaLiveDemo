package application;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

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
    @FXML
    private Button salatButton;
    @FXML
    private Button rukola;
    @FXML
    private Button bergsalat;
    @FXML
    private Button eissalat;
    @FXML
    private Button balsamiko;
    @FXML
    private Button joghurt;
    @FXML
    private Button kraeuter;
    @FXML
    private Button parmesan;
    @FXML
    private Button croutons;
    @FXML
    private Button schinken;
    @FXML
    private HBox salatBox;
    
    private ArrayList<salatAuswahl> salatAuswahl = new ArrayList<>();
    
    public Controller() {
		this.model = new Model();
		orders = model.createOrders();
		data = FXCollections.observableArrayList(orders);
	}
    protected void setSalatBoxInvisible() {
    	this.salatBox.setVisible(false);
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
    public void korrigieren() {
    	Object selectedItem = table.getSelectionModel().getSelectedItem();
    	table.getItems().remove(selectedItem);
    	data.remove(selectedItem);
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
    @FXML
    private void salatOptionen(ActionEvent event) {
    	salatBox.setVisible(true);
    }
    @FXML
    private void addRukola(ActionEvent event) {
    	this.salatAuswahl.add(new salatAuswahl("Rukola", 0.50f));
    }
    @FXML
    private void addBergsalat(ActionEvent event) {
    	this.salatAuswahl.add(new salatAuswahl("Bergsalat", 0.25f));
    }
    @FXML
    private void addEissalat(ActionEvent event) {
    	this.salatAuswahl.add(new salatAuswahl("Eissalat", 0.25f));
    }
    @FXML
    private void addBalsamiko(ActionEvent event) {
    	this.salatAuswahl.add(new salatAuswahl("Balsamiko", 0.50f));
    }
    @FXML
    private void addJoguhrt(ActionEvent event) {
    	this.salatAuswahl.add(new salatAuswahl("Joghurt", 0.35f));
    }
    @FXML
    private void addKraeuter(ActionEvent event) {
    	this.salatAuswahl.add(new salatAuswahl("Kraeuter", 0.25f));
    }
    @FXML
    private void addParmesan(ActionEvent event) {
    	this.salatAuswahl.add(new salatAuswahl("Parmesan", 0.50f));
    }
    @FXML
    private void addCroutons(ActionEvent event) {
    	this.salatAuswahl.add(new salatAuswahl("Croutons", 0.25f));
    }
    @FXML
    private void addSchinken(ActionEvent event) {
    	this.salatAuswahl.add(new salatAuswahl("Schinken", 0.75f));
    }
    @FXML
    private void bestaetigeSalat(ActionEvent event) {
    	
    	Salat salat = new Salat("Salat", model.calcSalatPrice(salatAuswahl), this.salatAuswahl);
    	data.add(salat);
    	setTableView(data);
    	salatAuswahl.clear();
    }
    @FXML
    private void salatZuruecksetzen(ActionEvent event) {
    	salatAuswahl.clear();
    }
    

}