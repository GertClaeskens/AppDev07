//package finah_desktop_fx;
//
//import java.io.IOException;
//
//import finah_desktop_fx.helperClasses.ResizeHelper;
//import finah_desktop_fx.view.AccountAanpassenLayoutController;
//import finah_desktop_fx.view.RootController;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//import javafx.application.Application;
//
//public class LoginManager {
//	
//	private Stage primaryStage;
//    private BorderPane rootLayout;
//    private Scene scene;
//    
//	public void authenticated() {
//	    initRootLayout();
//	    showAccountLayout();  
//	  }
//	
//	public void initRootLayout() {
//		try {
//			// Load root layout from fxml file.
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
//	            
//	            rootLayout = (BorderPane) loader.load();
//	            primaryStage.initStyle(StageStyle.TRANSPARENT);
//	            //primaryStage.initStyle(StageStyle.UNDECORATED);
//	            // Show the scene containing the root layout.
//	            RootController controller = loader.getController();
//	            controller.setMainApp(this);
//	            scene = new Scene(rootLayout);
//	            
//	            primaryStage.setMinWidth(750);
//	            primaryStage.setMinHeight(500);
//	            this.primaryStage.getIcons().add(new Image("file:resources/images/finah.png"));
//	            //scene.getStylesheets().add("finah_desktop_fx.css/finah.css");
//	            primaryStage.setScene(scene);
//	            ResizeHelper.addResizeListener(primaryStage,rootLayout);
//	            //ResizeHelper.makeDraggable(primaryStage, rootLayout);
//	            primaryStage.show();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	
//	 public void showAccountLayout() {
//		 try {
//			 // Load account layout.
//			 FXMLLoader loader = new FXMLLoader();
//			 loader.setLocation(MainApp.class.getResource("view/AccountAanpassenLayout.fxml"));
//			 AnchorPane accountLayout = (AnchorPane) loader.load();
//
//			 // Set account layout into the center of root layout.
//			 rootLayout.setCenter(accountLayout);
//			 // Give the controller access to the main app.
//			 AccountAanpassenLayoutController controller = loader.getController();
//			 controller.setMainApp(this);
//			 }
//		 catch (IOException e) {
//			 e.printStackTrace();
//		 }
//	 }
//}
