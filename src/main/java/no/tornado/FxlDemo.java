package no.tornado;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.SegmentedButton;

/**
 * A simple JavaFX application with a dependency on ControlsFX. Nothing interesting here :)
 */
public class FxlDemo extends Application {
	public void start(Stage stage) throws Exception {
		stage.setTitle("Hello World");
		stage.initStyle(StageStyle.UNDECORATED);

		Label label = new Label(stage.getTitle());
		label.setStyle("-fx-font-size: 25");

		// Alibi for including ControlsFX Dependency :)
		SegmentedButton fxcontrol = new SegmentedButton(new ToggleButton("One"), new ToggleButton("Two"), new ToggleButton("Three"));

        // Did we get any arguments?
        getParameters().getNamed().forEach((name, value) -> System.out.println(String.format("%s=%s", name, value)));

		Button fxmlButton = new Button("Open FXML View");
		fxmlButton.setOnAction(this::openFxmlView);

		Button exitButton = new Button("Exit");
		exitButton.setStyle("-fx-font-weight: bold");
		exitButton.setOnAction(event -> Platform.exit());

        HBox buttons = new HBox(10, fxmlButton, exitButton);

        VBox root = new VBox(label, fxcontrol, buttons);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		root.setPadding(new Insets(25));
        root.setStyle("-fx-border-color: lightblue");

		stage.setScene(new Scene(root));
		stage.show();
	}

	private void openFxmlView(ActionEvent event) {
		try {
			BorderPane view = FXMLLoader.load(getClass().getResource("/views/MyView.fxml"));
			Stage stage = new Stage();
			stage.setTitle("FXML View");
			stage.setScene(new Scene(view));
			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
			new Alert(AlertType.ERROR, "Failed to open FXML View!").show();
		}
	}
}
