module com.example.fluganzeigetafel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.apache.pdfbox;
    requires asciitable;



    opens com.example.fluganzeigetafel to javafx.fxml;
    exports com.example.fluganzeigetafel;
}