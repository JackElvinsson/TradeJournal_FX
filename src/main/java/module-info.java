module com.example.tradejournal_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tradejournal_fx to javafx.fxml;
    exports com.example.tradejournal_fx;
}