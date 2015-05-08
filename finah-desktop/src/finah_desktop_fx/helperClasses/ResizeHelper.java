package finah_desktop_fx.helperClasses;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ResizeHelper {

	public static void addResizeListener(Stage stage, Node noot) {
		ResizeListener resizeListener = new ResizeListener(stage, noot);
		stage.getScene()
				.addEventHandler(MouseEvent.MOUSE_MOVED, resizeListener);
		stage.getScene().addEventHandler(MouseEvent.MOUSE_PRESSED,
				resizeListener);
		stage.getScene().addEventHandler(MouseEvent.MOUSE_DRAGGED,
				resizeListener);
		ObservableList<Node> children = stage.getScene().getRoot()
				.getChildrenUnmodifiable();
		for (Node child : children) {
			addListenerDeeply(child, resizeListener);
		}
	}

	public static void addListenerDeeply(Node node, EventHandler listener) {
		node.addEventHandler(MouseEvent.MOUSE_MOVED, listener);
		node.addEventHandler(MouseEvent.MOUSE_PRESSED, listener);
		node.addEventHandler(MouseEvent.MOUSE_DRAGGED, listener);
		if (node instanceof Parent) {
			Parent parent = (Parent) node;
			ObservableList<Node> children = parent.getChildrenUnmodifiable();
			for (Node child : children) {
				addListenerDeeply(child, listener);
			}
		}
	}

	static class ResizeListener implements EventHandler {
		private Stage stage;
		private Cursor cursorEvent = Cursor.DEFAULT;
		private int border = 4;
		private double startX = 0;
		private double startY = 0;
		final Delta dragDelta = new Delta();
		private Node byNode;

		public ResizeListener(Stage stage, final Node noot) {
			this.stage = stage;
			byNode = noot;
		}

		@Override
		public void handle(Event event) {
			MouseEvent mouseEvent = (MouseEvent) event;
			EventType mouseEventType = mouseEvent.getEventType();
			Scene scene = stage.getScene();

			double mouseEventX = mouseEvent.getSceneX(), mouseEventY = mouseEvent
					.getSceneY(), sceneWidth = scene.getWidth(), sceneHeight = scene
					.getHeight();

			if (MouseEvent.MOUSE_MOVED.equals(mouseEventType) == true) {
				// if (mouseEventX > sceneWidth - border) {
				// cursorEvent = Cursor.SW_RESIZE;
				// } else
				if (mouseEventX > sceneWidth - border
						&& mouseEventY > sceneHeight - border) {
					cursorEvent = Cursor.SE_RESIZE;
				} else if (mouseEventX > sceneWidth - border) {
					cursorEvent = Cursor.E_RESIZE;
				} else if (mouseEventY > sceneHeight - border) {
					cursorEvent = Cursor.S_RESIZE;
				} else {
					cursorEvent = Cursor.DEFAULT;
				}
				scene.setCursor(cursorEvent);
			} else if (MouseEvent.MOUSE_PRESSED.equals(mouseEventType) == true) {
				System.out.println("pressed");
				startX = stage.getWidth() - mouseEventX;
				startY = stage.getHeight() - mouseEventY;
				dragDelta.x = stage.getX() - mouseEventX;
				dragDelta.y = stage.getY() - mouseEventY;
				scene.setCursor(Cursor.MOVE);
			} else if (MouseEvent.MOUSE_DRAGGED.equals(mouseEventType) == true) {
				if (Cursor.DEFAULT.equals(cursorEvent) == false) {

					if (Cursor.W_RESIZE.equals(cursorEvent) == false
							&& Cursor.E_RESIZE.equals(cursorEvent) == false) {
						System.out.println("dragged 1");
						double minHeight = stage.getMinHeight() > (border * 2) ? stage
								.getMinHeight() : (border * 2);
						if (Cursor.NW_RESIZE.equals(cursorEvent) == true
								|| Cursor.S_RESIZE.equals(cursorEvent) == true
								|| Cursor.NE_RESIZE.equals(cursorEvent) == true) {
							System.out.println("dragged 1a");
							if (stage.getHeight() > minHeight
									|| mouseEventY > minHeight
									|| mouseEventY + startY - stage.getHeight() > 0) {
								System.out.println("dragged 1b");
								stage.setHeight(mouseEventY + startY);
							}
						}
					}

					if (Cursor.N_RESIZE.equals(cursorEvent) == false
							&& Cursor.S_RESIZE.equals(cursorEvent) == false) {
						System.out.println("dragged 2");
						double minWidth = stage.getMinWidth() > (border * 2) ? stage
								.getMinWidth() : (border * 2);
						if (Cursor.NW_RESIZE.equals(cursorEvent) == true
								|| Cursor.E_RESIZE.equals(cursorEvent) == true
								|| Cursor.SW_RESIZE.equals(cursorEvent) == true) {
							if (stage.getWidth() > minWidth
									|| mouseEventX > minWidth
									|| mouseEventX + startX - stage.getWidth() > 0) {
								stage.setWidth(mouseEventX + startX);
							}
						}
					}
				} else {
					System.out.println(startX);
					System.out.println(startY);
					System.out.println(dragDelta.x);
					System.out.println(dragDelta.y);
					stage.setX(startX + dragDelta.x);
					stage.setY(startY + dragDelta.y);
//					stage.setX(mouseEvent.getScreenX() + dragDelta.x);
//					stage.setY(mouseEvent.getScreenY() + dragDelta.y);
				}

			}
		}

	}

	public static void makeDraggable(final Stage stage, final Node byNode) {
		final Delta dragDelta = new Delta();
		byNode.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				// record a delta distance for the drag and drop operation.
				dragDelta.x = stage.getX() - mouseEvent.getScreenX();
				dragDelta.y = stage.getY() - mouseEvent.getScreenY();
				byNode.setCursor(Cursor.MOVE);
			}
		});
		byNode.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				byNode.setCursor(Cursor.HAND);
			}
		});
		byNode.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				stage.setX(mouseEvent.getScreenX() + dragDelta.x);
				stage.setY(mouseEvent.getScreenY() + dragDelta.y);
			}
		});
		byNode.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (!mouseEvent.isPrimaryButtonDown()) {
					byNode.setCursor(Cursor.HAND);
				}
			}
		});
		byNode.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (!mouseEvent.isPrimaryButtonDown()) {
					byNode.setCursor(Cursor.DEFAULT);
				}
			}
		});
	}

	/** records relative x and y co-ordinates. */
	private static class Delta {
		double x, y;
	}
}
