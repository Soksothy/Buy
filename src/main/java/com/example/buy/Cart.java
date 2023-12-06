package com.example.buy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Cart implements Initializable
{
    @FXML
    private TableColumn<coffe, Integer> cost;

    @FXML
    private TableColumn<coffe, String> name;

    @FXML
    private TableColumn<coffe, String> no;

    @FXML
    private TableColumn<coffe ,Integer> price;

    @FXML
    private TableColumn<coffe, Integer> qty;

    @FXML
    private TableColumn<coffe, String> size;

    @FXML
    private TableView <coffe> table;

   ObservableList<coffe> list = FXCollections.observableArrayList(
        new coffe(1,"Macha",1,3,6,"Small")
   );
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        no.setCellValueFactory(new PropertyValueFactory<coffe,String>("no"));
        name.setCellValueFactory(new PropertyValueFactory<coffe,String>("name"));
        qty.setCellValueFactory(new PropertyValueFactory<coffe,Integer>("qty"));
       size.setCellValueFactory(new PropertyValueFactory<coffe,String>("size"));
        qty.setCellValueFactory(new PropertyValueFactory<coffe,Integer>("qty"));
        cost.setCellValueFactory(new PropertyValueFactory<coffe,Integer>("cost"));
        price.setCellValueFactory(new PropertyValueFactory<coffe,Integer>("price"));
        table.setItems(list);

    }
}
