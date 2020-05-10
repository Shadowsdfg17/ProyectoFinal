module com.andrea.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.andrea.proyectofinal.controller to javafx.fxml;
    exports com.andrea.proyectofinal;
}