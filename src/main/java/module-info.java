module com.example.final3 {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                        
    opens com.example.final3 to javafx.fxml;
    exports com.example.final3;
}