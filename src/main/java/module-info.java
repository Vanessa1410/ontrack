module com.example.todo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    opens com.example.todo to javafx.fxml;
    exports com.example.todo;
}