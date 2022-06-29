package application;



//import java.util.ResourceBundle;

//import javax.print.DocFlavor.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
	
	@FXML 
	private TableView<Person> tableView;
	
	@FXML 
	private TableColumn<Person, String> columnName;
	
	@FXML 
	private TableColumn<Person, String> columnLastName;
	
	@FXML
	private TableColumn<Person, String> columnNumber;
	
	@FXML
	private TextField firstName;
	
	@FXML 
	private TextField lastName;
	
	@FXML
	private TextField number;
	
	@FXML
	private Button Add;
	
	@FXML
	private Button Remove;
	
	ObservableList<Person> observableList = FXCollections.observableArrayList(
			        new Person("Ismar", "Begic", "061070471")
	);
	
	
	
	@Override 
	public void initialize(URL url, ResourceBundle resourceBundle) {
		columnName.setCellValueFactory(cellData -> cellData.getValue().firstName());
		columnLastName.setCellValueFactory(cellData -> cellData.getValue().lastName());
		columnNumber.setCellValueFactory(cellData -> cellData.getValue().number());
		tableView.setItems(observableList);
		tableView.setEditable(true);
		columnName.setCellFactory(TextFieldTableCell.forTableColumn());
		columnLastName.setCellFactory(TextFieldTableCell.forTableColumn());
		columnNumber.setCellFactory(TextFieldTableCell.forTableColumn());
	}
	
	
	public void Submit(ActionEvent actionEvent) {
		Person person = new Person(firstName.getText(), lastName.getText(), number.getText());
		tableView.getItems().add(person);
	}
	
	public void Delete(ActionEvent actionEvent) {
		ObservableList<Person> allPerson, singlePerson;
		allPerson = tableView.getItems();
		singlePerson = tableView.getSelectionModel().getSelectedItems();
		singlePerson.forEach(allPerson::remove);
	}
	
	public void onEditChangedName(TableColumn.CellEditEvent<Person, String> personStringCellEditEvent) {
		Person person = tableView.getSelectionModel().getSelectedItem();
		person.setName(personStringCellEditEvent.getNewValue());
	}
	
	
	public void onEditChangedLastName(TableColumn.CellEditEvent<Person, String> personStringCellEditEvent) {
		Person person = tableView.getSelectionModel().getSelectedItem();
		person.setLastName(personStringCellEditEvent.getNewValue());
	}
	
	
	public void onEditChangedNumber(TableColumn.CellEditEvent<Person, String> personStringCellEditEvent) {
		Person person = tableView.getSelectionModel().getSelectedItem();
		person.setNumber(personStringCellEditEvent.getNewValue());
	}
	

	
}
