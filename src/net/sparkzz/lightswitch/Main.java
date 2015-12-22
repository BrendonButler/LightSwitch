package net.sparkzz.lightswitch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	private static boolean running = false;

	private static Image[] images;
	private static ImageView image;

	public static void main(String[] args) {
		running = true;

		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
		images = new Image[2];

		images[0] = new Image(getClass().getResource("/images/off.png").toExternalForm());
		images[1] = new Image(getClass().getResource("/images/on.png").toExternalForm());

		image = new ImageView();
		image.setImage(images[0]);
		image.setFitWidth(384);
		image.setFitHeight(595);
		image.setCache(true);
		image.setOnMouseClicked(event -> changeState());

		HBox box = new HBox();
		box.getChildren().add(image);

		root.getChildren().add(box);

		Scene scene = new Scene(root);
		scene.setFill(Color.BLACK);
		
		stage.setTitle("Light Switch");
		stage.setWidth(384);
		stage.setHeight(595);
		stage.setScene(scene);
		stage.show();
	}

	private void changeState() {
		System.out.println("CLICK!");

		if (image.getImage().equals(images[0]))
			image.setImage(images[1]);
		else image.setImage(images[0]);
	}
}
