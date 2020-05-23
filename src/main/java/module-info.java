module com.andrea.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.xml.bind;
    requires java.base;

    opens com.andrea.proyectofinal.controller to javafx.fxml;
    opens com.andrea.proyectofinal.model to java.xml.bind;
    exports com.andrea.proyectofinal;
}