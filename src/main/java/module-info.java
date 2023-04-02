module com.example.semesc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.semesc to javafx.fxml;
    exports com.example.semesc;
    exports com.example.semesc.strom;
    opens com.example.semesc.strom to javafx.fxml;
    exports com.example.semesc.enums;
    opens com.example.semesc.enums to javafx.fxml;
    exports com.example.semesc.halda;
    opens com.example.semesc.halda to javafx.fxml;
    exports com.example.semesc.queu;
    opens com.example.semesc.queu to javafx.fxml;
    exports com.example.semesc.stack;
    opens com.example.semesc.stack to javafx.fxml;
    exports com.example.semesc.model;
    opens com.example.semesc.model to javafx.fxml;
}