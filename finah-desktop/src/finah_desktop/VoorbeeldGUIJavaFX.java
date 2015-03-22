package finah_desktop;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class VoorbeeldGUIJavaFX extends Application{
	Label lblBoven;
	Button btnAccount,btnNieuweBevraging, btnBeheer,btnResultaten,btnUitloggen, btnHome;
	ArrayList<Button> buttons; 
	BorderPane root;
	TilePane tPane;
	VBox content,navBar;
	HBox boven;
	
	
public static void main(String[] args){
	launch(args);
}

@Override
public void init(){
	
}

@Override
public void start(Stage stage) throws Exception {
	lblBoven = new Label();
	btnAccount = new Button("Account");
	btnNieuweBevraging = new Button("Nieuwe Bevraging");
	btnBeheer = new Button("Beheer");
	btnResultaten = new Button("Resultaten");
	btnUitloggen = new Button("Uitloggen");
	btnHome = new Button("Finah");
	root = new BorderPane();
	tPane = new TilePane();
	boven = new HBox();
	content = new VBox();
	navBar = new VBox();
	buttons  = new ArrayList<Button>();


	btnHome.getStyleClass().add("homeButton");
	
	boven.setStyle("-fx-background-color :linear-gradient(#029ACC 0%, #66CCCC 75%);");
	
	btnHome.setMinSize(200, 100);
	btnHome.setMaxSize(200, 100);
	btnHome.setPrefSize(200, 100);
	lblBoven.setMinSize(770, 35);
	lblBoven.setMaxSize(770, 35);
	lblBoven.setPrefSize(770, 35);
	navBar.setMinSize(800,100);
	navBar.setMaxSize(800,100);
	navBar.setPrefSize(800,100);
	boven.setMinSize(1000, 100);
	boven.setMaxSize(1000, 100);
	boven.setPrefSize(100, 100);
	tPane.setMinSize(800, 50);
	tPane.setMaxSize(800, 50);
	tPane.setPrefSize(800,50);

	
	buttons.add(btnAccount);
	buttons.add(btnNieuweBevraging);
	buttons.add(btnBeheer);
	buttons.add(btnResultaten);
	buttons.add(btnUitloggen);
		
	tPane.setHgap(25);
	for (Button b : buttons){
		b.setMaxSize(140, 30);
		b.setMinSize(140, 30);
		b.setPrefSize(140,30);
		tPane.getChildren().add(b);
	}
	
	
	navBar.getChildren().addAll(lblBoven,tPane);
	boven.getChildren().addAll(btnHome,navBar);
	root.setTop(boven);

	
	
	

	Scene scene = new Scene(root,1000,800);
	scene.getStylesheets().add("Style.css");
	stage.setScene(scene);
	
	stage.show();
}
}
