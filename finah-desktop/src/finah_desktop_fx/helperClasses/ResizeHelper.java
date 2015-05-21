//package finah_desktop_fx.helperClasses;
//
//import javafx.collections.ObservableList;
//import javafx.event.Event;
//import javafx.event.EventHandler;
//import javafx.event.EventType;
//import javafx.scene.Cursor;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.input.MouseEvent;
//import javafx.stage.Stage;
//
//public class ResizeHelper {
//
//	public static void addResizeListener(Stage stage, Node noot) {
//		ResizeListener resizeListener = new ResizeListener(stage, noot);
//		stage.getScene()
//				.addEventHandler(MouseEvent.MOUSE_MOVED, resizeListener);
//		stage.getScene().addEventHandler(MouseEvent.MOUSE_PRESSED,
//				resizeListener);
//		stage.getScene().addEventHandler(MouseEvent.MOUSE_DRAGGED,
//				resizeListener);
//		ObservableList<Node> children = stage.getScene().getRoot()
//				.getChildrenUnmodifiable();
//		for (Node child : children) {
//			addListenerDeeply(child, resizeListener);
//		}
//	}
//
//	public static void addListenerDeeply(Node node, EventHandler listener) {
//		node.addEventHandler(MouseEvent.MOUSE_MOVED, listener);
//		node.addEventHandler(MouseEvent.MOUSE_PRESSED, listener);
//		node.addEventHandler(MouseEvent.MOUSE_DRAGGED, listener);
//		if (node instanceof Parent) {
//			Parent parent = (Parent) node;
//			ObservableList<Node> children = parent.getChildrenUnmodifiable();
//			for (Node child : children) {
//				addListenerDeeply(child, listener);
//			}
//		}
//	}
//
//	
//	static class ResizeListener implements EventHandler {
//		private Stage stage;
//		private Cursor cursorEvent = Cursor.DEFAULT;
//		private int border = 4;
//		private double startX = 0;
//		private double startY = 0;
//		final Delta dragDelta = new Delta();
//		private Node byNode;
//
//		public ResizeListener(Stage stage, final Node noot) {
//			this.stage = stage;
//			byNode = noot;
//		}
//
//		@Override
//		public void handle(Event event) {
//			MouseEvent mouseEvent = (MouseEvent) event;
//			EventType mouseEventType = mouseEvent.getEventType();
//			Scene scene = stage.getScene();
//
//			double mouseEventX = mouseEvent.getSceneX(), mouseEventY = mouseEvent
//					.getSceneY(), sceneWidth = scene.getWidth(), sceneHeight = scene
//					.getHeight();
//			if (MouseEvent.DRAG_DETECTED.equals(mouseEventType)){
//				byNode.startFullDrag();
//			}else
//			if (MouseEvent.MOUSE_MOVED.equals(mouseEventType) == true) {
//				if (mouseEventX > sceneWidth - border
//						&& mouseEventY > sceneHeight - border) {
//					cursorEvent = Cursor.SE_RESIZE;
//				} else if (mouseEventX > sceneWidth - border) {
//					cursorEvent = Cursor.E_RESIZE;
//				} else if (mouseEventY > sceneHeight - border) {
//					cursorEvent = Cursor.S_RESIZE;
//				} else {
//					cursorEvent = Cursor.DEFAULT;
//				}
//				scene.setCursor(cursorEvent);
//			}  else if (MouseEvent.MOUSE_DRAGGED.equals(mouseEventType) == true) {
//				if (Cursor.DEFAULT.equals(cursorEvent) == false) {
//
//					if (Cursor.W_RESIZE.equals(cursorEvent) == false
//							&& Cursor.E_RESIZE.equals(cursorEvent) == false) {
//						double minHeight = stage.getMinHeight() > (border * 2) ? stage
//								.getMinHeight() : (border * 2);
//						if (Cursor.NW_RESIZE.equals(cursorEvent) == true
//								|| Cursor.S_RESIZE.equals(cursorEvent) == true
//								|| Cursor.NE_RESIZE.equals(cursorEvent) == true) {
//							if (stage.getHeight() > minHeight
//									|| mouseEventY > minHeight
//									|| mouseEventY + startY - stage.getHeight() > 0) {
//								stage.setHeight(mouseEventY + startY);
//							}
//						}
//					}
//					if (Cursor.N_RESIZE.equals(cursorEvent) == false
//							&& Cursor.S_RESIZE.equals(cursorEvent) == false) {
//						double minWidth = stage.getMinWidth() > (border * 2) ? stage
//								.getMinWidth() : (border * 2);
//						if (Cursor.NW_RESIZE.equals(cursorEvent) == true
//								|| Cursor.E_RESIZE.equals(cursorEvent) == true
//								|| Cursor.SW_RESIZE.equals(cursorEvent) == true) {
//							if (stage.getWidth() > minWidth
//									|| mouseEventX > minWidth
//									|| mouseEventX + startX - stage.getWidth() > 0) {
//								stage.setWidth(mouseEventX + startX);
//							}
//						}
//					}
//				} else {
//					stage.setX(mouseEventX - dragDelta.x);
//					stage.setY(mouseEventY - dragDelta.y);
//				
//				}
//
//			}else if (MouseEvent.MOUSE_PRESSED.equals(mouseEventType) == true) {
//					startX = stage.getWidth() - mouseEventX;
//					startY = stage.getHeight() - mouseEventY;
//					dragDelta.x = mouseEventX - stage.getX();
//					dragDelta.y = mouseEventY - stage.getY();
//					scene.setCursor(Cursor.MOVE);
//				}
//		}
//	}
//
//
//	/** records relative x and y co-ordinates. */
//	private static class Delta {
//		double x, y;
//	}
//}
