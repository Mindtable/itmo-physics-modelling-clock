module ru.itmo.clockmodelling {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;

    opens ru.itmo.clockmodelling to javafx.fxml;
    exports ru.itmo.clockmodelling;
}