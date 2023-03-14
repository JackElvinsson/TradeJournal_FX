package com.example.tradejournal_fx;

import java.io.*;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class TradingJournalGUIController {
    @FXML
    private TableView<Trade> table;
    @FXML
    private TableColumn<Trade, String> symbolColumn;
    @FXML
    private TableColumn<Trade, Double> priceColumn;
    @FXML
    private TableColumn<Trade, Integer> quantityColumn;
    @FXML
    private TableColumn<Trade, LocalDate> dateColumn;
    @FXML
    private TableColumn<Trade, Double> stopLossColumn;
    @FXML
    private TableColumn<Trade, Double> takeProfitColumn;
    @FXML
    private TextField symbolInput;
    @FXML
    private TextField priceInput;
    @FXML
    private TextField quantityInput;
    @FXML
    private DatePicker dateInput;
    @FXML
    private TextField stopLossInput;
    @FXML
    private TextField takeProfitInput;
    @FXML
    private Button recordButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField screenshotURLInput;
    @FXML
    private TableColumn<Trade, String> screenshotURLColumn;

    ArrayList<Trade> trades = new ArrayList<>();
    ObservableList<Trade> data = FXCollections.observableArrayList();

    public void initialize() {
        symbolColumn.setCellValueFactory(new PropertyValueFactory<>("symbol"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        stopLossColumn.setCellValueFactory(new PropertyValueFactory<>("stopLoss"));
        takeProfitColumn.setCellValueFactory(new PropertyValueFactory<>("takeProfit"));
        screenshotURLColumn.setCellValueFactory(new PropertyValueFactory<>("screenshotURL"));

        screenshotURLColumn.setCellFactory(tc -> {
            TableCell<Trade, String> cell = new TableCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(screenshotURLColumn.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell;
        });

        table.setItems(data);

        File file = new File("trades.txt");
        if(file.length() > 0) {
            loadTrades();
        } else {
            System.out.println("No trades to load");
        }

        recordButton.setOnAction(e -> recordTrade());
        deleteButton.setOnAction(e -> deleteTrade());
        saveButton.setOnAction(e -> saveTrades());
    }

    @FXML
    private void recordTrade() {
        String symbol = symbolInput.getText();
        double price = Double.parseDouble(priceInput.getText());
        int quantity = Integer.parseInt(quantityInput.getText());
        LocalDate date = dateInput.getValue();
        double stopLoss = Double.parseDouble(stopLossInput.getText());
        double takeProfit = Double.parseDouble(takeProfitInput.getText());
        String screenshotURL = screenshotURLInput.getText();

        Trade trade = new Trade(symbol, price, quantity, date, stopLoss, takeProfit, screenshotURL);
        trade.setScreenshotURL(screenshotURLInput.getText());
        trades.add(trade);
        data.add(trade);
        symbolInput.clear();
        priceInput.clear();
        quantityInput.clear();
        dateInput.setValue(null);
    }


    @FXML
    private void deleteTrade() {
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Trade selectedTrade = table.getSelectionModel().getSelectedItem();
            trades.remove(selectedTrade);
            data.remove(selectedTrade);
        } else {
            // Show an error message
        }
    }

    @FXML
    public void saveTrades() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("trades.txt"));
            for (Trade trade : trades) {
                bw.write(trade.getSymbol() + "," + trade.getPrice() + "," + trade.getQuantity() + "," + trade.getDate() + "," + trade.getStopLoss() + "," + trade.getTakeProfit() + "," + trade.getScreenshotURL() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void loadTrades() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("trades.txt"));
            String line;
            while((line = br.readLine()) != null) {
                String[] tradeData = line.split(",");
                Trade trade = new Trade(tradeData[0],
                        Double.parseDouble(tradeData[1]),
                        Integer.parseInt(tradeData[2]),
                        LocalDate.parse(tradeData[3]),
                        Double.parseDouble(tradeData[4]),
                        Double.parseDouble(tradeData[5]),
                        tradeData[6]);
                trades.add(trade);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}




