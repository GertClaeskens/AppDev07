package finah_desktop_fx;

import java.io.IOException;

//import finah_desktop_fx.helperClasses.ResizeHelper;
import finah_desktop_fx.helperClasses.ResizeTest;
import finah_desktop_fx.view.AccountAanpassenLayoutController;
import finah_desktop_fx.view.LoginController;
import finah_desktop_fx.view.NieuwAccountController;
import finah_desktop_fx.view.RootController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {
	
	private Stage primaryStage;
    private AnchorPane loginLayout, nieuwAccountLayout, wachtwoordVergetenLayout;
    private BorderPane rootLayout;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("FinahDesktopApp");

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        showLogin();
        
    }
    
    public void showLogin() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Login.fxml"));
            loginLayout = (AnchorPane) loader.load();
	               
            // Show the scene containing the root layout.
            LoginController controller = loader.getController();
            controller.setMainApp(this);
            Scene scene = new Scene(loginLayout);
            primaryStage.setScene(scene);
            primaryStage.setX(825); //hardcoded nog
            primaryStage.setY(300); //hardcoded nog
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void authenticated() {
    
    	initRootLayout();
	    showAccountLayout();
	}
    
    public void close(){
    	Platform.exit();
    }
	
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
	            
	        rootLayout = (BorderPane) loader.load();
	        // Show the scene containing the root layout.
	        RootController controller = loader.getController();
	        controller.setMainApp(this);
	        scene = new Scene(rootLayout);
	            
	        primaryStage.setWidth(1200);
	        primaryStage.setHeight(600);
	        primaryStage.setX(500);
	        primaryStage.setY(300);
	        this.primaryStage.getIcons().add(new Image("file:resources/images/finah.png"));
	        primaryStage.setScene(scene);
	        ResizeTest.makeDraggable(primaryStage, rootLayout);
	        //ResizeHelper.addResizeListener(primaryStage,rootLayout);
	        primaryStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	 public void showAccountLayout() {
		 try {
			 // Load account layout.
			 FXMLLoader loader = new FXMLLoader();
			 loader.setLocation(MainApp.class.getResource("view/AccountAanpassenLayout.fxml"));
			 AnchorPane accountLayout = (AnchorPane) loader.load();

			 // Set account layout into the center of root layout.
			 rootLayout.setCenter(accountLayout);
			 // Give the controller access to the main app.
			 AccountAanpassenLayoutController controller = loader.getController();
			 controller.setMainApp(this);
			 }
		 catch (IOException e) {
			 e.printStackTrace();
		 }
	}
	 
	
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
