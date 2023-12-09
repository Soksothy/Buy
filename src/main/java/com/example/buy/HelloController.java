package com.example.buy;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController   implements Initializable{
    @FXML
    ImageView caffe;
    @FXML
    Image cc = new Image(getClass().getResourceAsStream("gh.jpg"));


    public void displayimg() {
        caffe.setImage(cc);


    }

    @FXML
    private ChoiceBox <String> sugar;
    private String[] suga ={"0%","25%","50%","75%","100%"};
    @FXML
    private ChoiceBox <String> size;
    private String[] sie ={"Small","Medium","Large"};

    @FXML
    private ChoiceBox <String> sugar1;
    private String[] su ={"0%","25%","50%","75%","100%"};
    @FXML
    private ChoiceBox <String> size1;
    private String[] si ={"Small","Medium","Large"};

    @FXML
    private ChoiceBox <String> sugar11;
    private String[] suu ={"0%","25%","50%","75%","100%"};
    @FXML
    private ChoiceBox <String> size11;
    private String[] sii ={"Small","Medium","Large"};

    @FXML
    private ChoiceBox <String> sugarf1;
    private String[] suf1 ={"0%","25%","50%","75%","100%"};
    @FXML
    private ChoiceBox <String> sizef1;
    private String[] sif1 ={"Small","Medium","Large"};

    @FXML
    private ChoiceBox <String> sugarf2;
    private String[] suf2 ={"0%","25%","50%","75%","100%"};
    @FXML
    private ChoiceBox <String> sizef2;
    private String[] sif2 ={"Small","Medium","Large"};

    @FXML
    private ChoiceBox <String> sugarf3;
    private String[] suf3 ={"0%","25%","50%","75%","100%"};
    @FXML
    private ChoiceBox <String> sizef3;
    private String[] sif3 ={"Small","Medium","Large"};

    @FXML
    private ChoiceBox <String> sugart1;
    private String[] sut1 ={"0%","25%","50%","75%","100%"};
    @FXML
    private ChoiceBox <String> sizet1;
    private String[] sit1 ={"Small","Medium","Large"};

    @FXML
    private ChoiceBox <String> sugart11;
    private String[] sut11 ={"0%","25%","50%","75%","100%"};
    @FXML
    private ChoiceBox <String> sizet11;
    private String[] sit11 ={"Small","Medium","Large"};

    @FXML
    private ChoiceBox <String> sugart111;
    private String[] sut111 ={"0%","25%","50%","75%","100%"};
    @FXML
    private ChoiceBox <String> sizet111;
    private String[] sit111 ={"Small","Medium","Large"};







    @FXML
    private Spinner<Integer> spin;
    @FXML
    private Spinner<Integer> spin1;
    @FXML
    private Spinner<Integer> spin11;
    @FXML
    private Spinner<Integer> spinf1;
    @FXML
    private Spinner<Integer> spinf2;
    @FXML
    private Spinner<Integer> spinf3;
    @FXML
    private Spinner<Integer> spint1;
    @FXML
    private Spinner<Integer> spint11;
    @FXML
    private Spinner<Integer> spint111;
    int cv;
    @FXML
    TextArea c1;
    @FXML
    ComboBox <String> cc1;

 public String [] six ={"S","M","L"};




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sugar.getItems().addAll(suga);
        size.getItems().addAll(sie);
        sugar1.getItems().addAll(su);
        size1.getItems().addAll(si);
        sugar11.getItems().addAll(suu);
        size11.getItems().addAll(sii);
        sugarf1.getItems().addAll(suf1);
        sizef1.getItems().addAll(sif1);
        sugarf2.getItems().addAll(suf2);
        sizef2.getItems().addAll(sif2);
        sugarf3.getItems().addAll(suf3);
        sizef3.getItems().addAll(sif3);
        sugart1.getItems().addAll(sut1);
        sizet1.getItems().addAll(sit1);
        sugart11.getItems().addAll(sut11);
        sizet11.getItems().addAll(sit11);
        sugart111.getItems().addAll(sut111);
        sizet111.getItems().addAll(sit111);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        valueFactory.setValue(0);
        spin.setValueFactory(valueFactory);
        SpinnerValueFactory<Integer> s1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        s1.setValue(0);
        spin1.setValueFactory(s1);
        SpinnerValueFactory<Integer> s11 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        s11.setValue(0);
        spin11.setValueFactory(s11);
        SpinnerValueFactory<Integer> sf1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        s11.setValue(0);
        spinf1.setValueFactory(sf1);
        SpinnerValueFactory<Integer> sf2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        s11.setValue(0);
        spinf2.setValueFactory(sf2);
        SpinnerValueFactory<Integer> sf3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        s11.setValue(0);
        spinf3.setValueFactory(sf3);
        SpinnerValueFactory<Integer> st1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        st1.setValue(0);
        spint1.setValueFactory(st1);
        SpinnerValueFactory<Integer> st2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        st1.setValue(0);
        spint11.setValueFactory(st2);
        SpinnerValueFactory<Integer> st3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100);
        st1.setValue(0);
        spint111.setValueFactory(st3);

        /*try
        {

                Scanner s = new Scanner(new File("Stock.txt")).useDelimiter("\\s+");
                while (s.hasNext())
                {
                    if(s.hasNextInt()){
                        c1.appendText(s.nextInt()+"");
                    }else {
                        c1.appendText(s.next()+"");
                    }
                }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }*/


        //2
        try
        {

            Scanner s = new Scanner(new File("Stock.txt")).useDelimiter("\\s+");
            while (s.hasNext())
            {
                if(s.hasNextInt()){
                    c1.appendText(s.nextInt()+"");
                }else {
                    c1.appendText(s.next()+"");
                }
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }



}
