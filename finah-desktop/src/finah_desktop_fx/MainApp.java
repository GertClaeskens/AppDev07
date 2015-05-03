package finah_desktop_fx;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import finah_desktop_fx.view.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("FinahDesktopApp");

        initRootLayout();

        showAccountLayout();
    }


    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void toonAandoeningen(ActionEvent actionEvent){
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AandoeningenLayout.fxml"));
            AnchorPane aandoeningView = (AnchorPane) loader.load();
            // Set person overview into the center of root layout.
            rootLayout.setCenter(aandoeningView);

            // Give the controller access to the main app.
            //RootController controller = loader.getController();
            //controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the account layout inside the root layout.
     */
    public void showAccountLayout() {
        try {
            // Load account layout.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AccountLayout.fxml"));
            //loader.setLocation(MainApp.class.getResource("view/AandoeningenLayout.fxml"));
            //loader.setLocation(MainApp.class.getResource("view/PathologieAanpassenLayout.fxml"));
            //loader.setLocation(MainApp.class.getResource("view/NieuweBevragingLayout.fxml"));
            AnchorPane accountLayout = (AnchorPane) loader.load();

            // Set account layout into the center of root layout.
            rootLayout.setCenter(accountLayout);
            // Give the controller access to the main app.
            AandoeningController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }


	public BorderPane getRootLayout() {
		return rootLayout;
	}


	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}
}