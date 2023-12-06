package com.example.buy;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable{
    @FXML
    private TableView<Customer> tableView;

    //Columns
    @FXML
    private TableColumn<Customer, String> idColumn;

    @FXML
    private TableColumn<Customer, String> nameColumn;

    @FXML
    private TableColumn<Customer, String> typeColumn;
    @FXML
    private TableColumn<Customer, String> priceColumn;

    @FXML
    private TableColumn<Customer, String> statusColumn;

    //Text input
    @FXML
    private TextField idInput;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField typeInput;
    @FXML
    private TextField priceInput;

    @FXML
    private TextField statusInput;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    //Submit button
    @FXML
    void submit(ActionEvent event) {
        Customer customer = new Customer(
                idInput.getText(),
                nameInput.getText(),
                typeInput.getText(),
                priceInput.getText(),
                statusInput.getText());
        ObservableList<Customer> customers = tableView.getItems();
        customers.add(customer);
        tableView.setItems(customers);

        // Clear input fields
        idInput.clear();
        nameInput.clear();
        typeInput.clear();
        priceInput.clear();
        statusInput.clear();
    }

    @FXML
    void removeCustomer(ActionEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tableView.getItems().remove(selectedIndex);
        }
    }
}
