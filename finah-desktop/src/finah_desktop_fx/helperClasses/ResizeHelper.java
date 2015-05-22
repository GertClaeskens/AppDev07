package finah_desktop_fx.helperClasses;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ResizeHelper {

	  public static void makeDraggable(final Stage stage, final BorderPane borderPane) {
	    final Delta dragDelta = new Delta();
	    borderPane.setOnMousePressed(new EventHandler<MouseEvent>() {
	      @Override public void handle(MouseEvent mouseEvent) {
	        // record a delta distance for the drag and drop operation.
	        dragDelta.x = stage.getX() - mouseEvent.getScreenX();
	        dragDelta.y = stage.getY() - mouseEvent.getScreenY();
	        borderPane.setCursor(Cursor.MOVE);
	      }
	    });
	    borderPane.setOnMouseReleased(new EventHandler<MouseEvent>() {
	      @Override public void handle(MouseEvent mouseEvent) {
	        borderPane.setCursor(Cursor.HAND);
	      }
	    });
	    borderPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
	      @Override public void handle(MouseEvent mouseEvent) {
	        stage.setX(mouseEvent.getScreenX() + dragDelta.x);
	        stage.setY(mouseEvent.getScreenY() + dragDelta.y);
	      }
	    });
	    borderPane.setOnMouseEntered(new EventHandler<MouseEvent>() {
	      @Override public void handle(MouseEvent mouseEvent) {
	        if (!mouseEvent.isPrimaryButtonDown()) {
	          borderPane.setCursor(Cursor.HAND);
	        }
	      }
	    });
	    borderPane.setOnMouseExited(new EventHandler<MouseEvent>() {
	      @Override public void handle(MouseEvent mouseEvent) {
	        if (!mouseEvent.isPrimaryButtonDown()) {
	          borderPane.setCursor(Cursor.DEFAULT);
	        }
	      }
	    });
	  }
	 
	  /** records relative x and y co-ordinates. */
	  private static class Delta {
	    double x, y;
	  }
	}


