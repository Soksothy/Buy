package com.example.buy;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SecondController implements Initializable {

    @FXML
    private TableView<Customer> tableView;

    // Columns
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

    // Text input
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
    @FXML
    Button logout_btn;
    @FXML
    private Button updateBtn;
    @FXML
    private Alert alert;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    public void switchToDetele(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin-delete.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAdd(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin-add.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToUpdate(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin-update.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToReport(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admin-report.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void logout() {
        try {
            alert = new Alert((Alert.AlertType.CONFIRMATION));
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                logout_btn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void AddPerformed() {
        Customer customer = new Customer(
                idInput.getText(),
                nameInput.getText(),
                typeInput.getText(),
                priceInput.getText(),
                statusInput.getText());
        ObservableList<Customer> customers = tableView.getItems();
        customers.add(customer);
        tableView.setItems(customers);
        int id = Integer.parseInt(idInput.getText());
        String name = nameInput.getText();
        double price = Double.parseDouble(priceInput.getText());
        String type = typeInput.getText();
        String status = statusInput.getText();
        try {
            FileWriter writer = new FileWriter("Stock.txt", true);
            writer.write("" + id + "," + name + "," + price + "," + type + "," + status);
            writer.write(System.getProperty("line.separator"));
            writer.close();
            JOptionPane.showMessageDialog(null, "Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Clear input fields
        idInput.clear();
        nameInput.clear();
        typeInput.clear();
        priceInput.clear();
        statusInput.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        loadExistingData();
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Populate input fields with selected data
                if (idInput != null) {
                    idInput.setText(newSelection.getId());
                }
                if (nameInput != null) {
                    nameInput.setText(newSelection.getName());
                }
                if (typeInput != null) {
                    typeInput.setText(newSelection.getType());
                }
                if (priceInput != null) {
                    priceInput.setText(newSelection.getPrice());
                }
                if (statusInput != null) {
                    statusInput.setText(newSelection.getStatus());
                }
            }
        });
    }

    private void loadExistingData() {
        try {
            File file = new File("Stock.txt");
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] data = line.split(",");
                    if (data.length == 5) {
                        Customer customer = new Customer(data[0], data[1], data[3], data[2], data[4]);
                        tableView.getItems().add(customer);
                    }
                }
                scanner.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deletePerformed() {
        ObservableList<Customer> selectedItems = tableView.getSelectionModel().getSelectedItems();
        if (!selectedItems.isEmpty()) {
            Customer selectedCustomer = selectedItems.get(0);
            tableView.getItems().remove(selectedCustomer);
            updateFileData();
        }
    }

    public void updateFileData() {
        try {
            FileWriter writer = new FileWriter("Stock.txt");
            ObservableList<Customer> customers = tableView.getItems();
            for (Customer customer : customers) {
                writer.write(customer.getId() + "," + customer.getName() + "," +
                        customer.getPrice() + "," + customer.getType() + "," +
                        customer.getStatus());
                writer.write(System.getProperty("line.separator"));
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Delete Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void updatePerformed() {
        ObservableList<Customer> selectedItems = tableView.getSelectionModel().getSelectedItems();
        if (!selectedItems.isEmpty()) {
            Customer selectedCustomer = selectedItems.get(0);

            // Show a dialog with the current values and allow the user to update them
            Dialog<Customer> dialog = createUpdateDialog(selectedCustomer);
            Optional<Customer> result = dialog.showAndWait();

            // If the user clicks "Update" in the dialog, update the data
            result.ifPresent(updatedCustomer -> {
                int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
                tableView.getItems().set(selectedIndex, updatedCustomer);
                updateFileData();  // Update the data in the file
            });

            // Clear the input fields after the update
            clearInputFields();
        }
    }


    private void clearInputFields() {
        idInput.clear();
        nameInput.clear();
        typeInput.clear();
        priceInput.clear();
        statusInput.clear();
    }
    private Dialog<Customer> createUpdateDialog(Customer selectedCustomer) {
        Dialog<Customer> dialog = new Dialog<>();
        dialog.setTitle("Update Customer");
        dialog.setHeaderText("Update Customer Information");

        // Set the button types
        ButtonType updateButtonType = new ButtonType("Update", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(updateButtonType, ButtonType.CANCEL);

        // Create input fields and labels
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // Use TextFields instead of idInput, nameInput, etc.
        TextField idField = new TextField(selectedCustomer.getId());
        TextField nameField = new TextField(selectedCustomer.getName());
        TextField typeField = new TextField(selectedCustomer.getType());
        TextField priceField = new TextField(selectedCustomer.getPrice());
        TextField statusField = new TextField(selectedCustomer.getStatus());

        grid.add(new Label("ID:"), 0, 0);
        grid.add(idField, 1, 0);
        grid.add(new Label("Name:"), 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(new Label("Type:"), 0, 2);
        grid.add(typeField, 1, 2);
        grid.add(new Label("Price:"), 0, 3);
        grid.add(priceField, 1, 3);
        grid.add(new Label("Status:"), 0, 4);
        grid.add(statusField, 1, 4);

        dialog.getDialogPane().setContent(grid);

        // Enable/Disable the update button depending on whether the input fields are empty
        Node updateButton = dialog.getDialogPane().lookupButton(updateButtonType);
        updateButton.setDisable(true);

        // Add listener to enable/disable the update button
        idField.textProperty().addListener((observable, oldValue, newValue) -> {
            updateButton.setDisable(newValue.trim().isEmpty());
        });

        // Convert the result to a Customer object when the update button is clicked
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == updateButtonType) {
                return new Customer(idField.getText(), nameField.getText(), typeField.getText(),
                        priceField.getText(), statusField.getText());
            }
            return null;
        });

        return dialog;
    }
}
