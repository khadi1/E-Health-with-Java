module com.example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.demo3 to javafx.fxml;
    opens com.example.demo3.Modeles to javafx.base;
    exports com.example.demo3;

}