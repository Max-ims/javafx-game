package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.text.Text;


public class Main extends Application {
	
	private static Stage stage;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private Button stylizeButton(Button button) {
		String buttonName = button.getText();
		if(buttonName.equals("New Game")) {
			System.out.println(buttonName);
			button.setMinWidth(100);
	        button.setMinHeight(50);
		}
		else {
			button.setMinWidth(70);
			button.setMinHeight(40);
		}
		
        button.setTranslateY(-85);
        return button;
	}
	// main interface
	private VBox createMainInterface() {
		VBox vbox = new VBox();
		// Create an ImageView with an image
        Image image = new Image("/gameTitle.png"); // Replace with the actual path to your image
        ImageView gameTitleimageView = new ImageView(image);
        gameTitleimageView.setTranslateY(-120);
        gameTitleimageView.setFitWidth(400); // Adjust the width of the image
        gameTitleimageView.setFitHeight(200); // Adjust the height of the image
		
		//create 4 buttons (play,about,credits,shop) /optional: settings
		List<Node> initialList = new ArrayList<>();
		Button playBtn = new Button("New Game");
		Button aboutBtn = new Button("About");
		Button creditsBtn = new Button("Credits");
		Button shopBtn = new Button("Shop");
		Button optionsBtn = new Button("Options");
		
		initialList.add(playBtn);
		initialList.add(aboutBtn);
		initialList.add(creditsBtn);
		initialList.add(shopBtn);
		initialList.add(optionsBtn);
		
		for (Node node : initialList) {
            if (node instanceof Button) {
                stylizeButton((Button) node); // You can adjust the boolean value based on your needs
            }
        }
		vbox.getChildren().add(gameTitleimageView);
		vbox.getChildren().addAll(initialList);
		
		vbox.setSpacing(20);
		vbox.setTranslateX(0);
		vbox.setAlignment(Pos.CENTER);
		vbox.getStyleClass().add("background-vbox");
		
		//playBtn.setOnAction(e -> createGame());
		//aboutBtn.setOnAction(e -> createAbout());
		return vbox;
	}
	private Parent create(Stage stage) {
		VBox vbox1 = createMainInterface();
		createScene(vbox1, stage);
		return vbox1;
		
	}
	
	private Scene createScene(Parent root, Stage stage) {
		Scene scene = new Scene(root,600,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//setting scene color
		Color light_purple = Color.web("#ae57de", 1.0);
		scene.setFill(light_purple);
		
		
		
		
		
		stage.setScene(scene);
		stage.show();
		return scene;
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
			stage = primaryStage;
			create(stage);
			//setting icon
			stage.getIcons().add(new Image(Main.class.getResourceAsStream("/crystal.png")));
			
			
			
	}
	
	
	
}
