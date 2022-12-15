package com.noah.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Main extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    MultipleBallPane ballPane = new MultipleBallPane();
    ballPane.setStyle("-fx-border-color: yellow");
    Button btAdd = new Button("+");
    Button btSubtract = new Button("-");
    HBox hBox = new HBox(10);
    hBox.getChildren().addAll(btAdd, btSubtract);
    hBox.setAlignment(Pos.CENTER);
    // Add or remove a ball
    btAdd.setOnAction(e -> ballPane.add());
    btSubtract.setOnAction(e -> ballPane.subtract());
    // Pause and resume animation
    ballPane.setOnMousePressed(e -> ballPane.pause());
    ballPane.setOnMouseReleased(e -> ballPane.play());
    // Use a scroll bar to control animation speed
    ScrollBar sbSpeed = new ScrollBar();
    sbSpeed.setMax(20);
    sbSpeed.setValue(10);
    ballPane.rateProperty().bind(sbSpeed.valueProperty());
    
    BorderPane pane = new BorderPane();
    pane.setCenter(ballPane);
    pane.setTop(sbSpeed);
    pane.setBottom(hBox);
    // Create a scene and place the pane in the stage
    Scene scene = new Scene(pane, 250, 150);
    primaryStage.setTitle("MultipleBounceBall"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  private class MultipleBallPane extends Pane {
    private Timeline animation;
    private int radius;
    
    public MultipleBallPane() {
      // Create an animation for moving the ball
      radius = 0;
      
      animation = new Timeline(
        new KeyFrame(Duration.millis(50), e -> moveBall()));
      animation.setCycleCount(Timeline.INDEFINITE);
      animation.play(); // Start animation
    }
    
    public void add() {
      
      radius = (int)(Math.random() * 20) + 2;
      
      Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
      getChildren().add(new Ball(30, 30, radius, color)); 
      
      List<Object> newChildrenList = Arrays.asList(getChildren().toArray());
    }
    
    public void subtract() {
      if (getChildren().size() > 0) {
    	ArrayList<Double> rList = new ArrayList<Double>();
    	int currR = 0;  
    	
        for(int i = 0; i < getChildren().size(); i++) {
        	
        	rList.add(((Ball) getChildren().get(i)).getRadius());
        	Collections.sort(rList);
        	
        	
        	if(((Ball) getChildren().get(i)).getRadius() == rList.get(rList.size() - 1)) {
        		//getChildren().remove(getChildren().get(i));
        		
        		currR = i;
        	}
        	
        }
        getChildren().remove(getChildren().get(currR));
      }
    }
    public void play() {
      animation.play();
    }
    public void pause() {
      animation.pause();
    }
    public void increaseSpeed() {
      animation.setRate(animation.getRate() + 0.1);
    }
    public void decreaseSpeed() {
      animation.setRate(
        animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }
    public DoubleProperty rateProperty() {
      return animation.rateProperty();
    }
    protected void moveBall() {
      for (Node node: this.getChildren()) {
        Ball ball = (Ball)node;
        // Check boundaries
        if (ball.getCenterX() < ball.getRadius() || 
            ball.getCenterX() > getWidth() - ball.getRadius()) {
          ball.dx *= -1; // Change ball move direction
        }
        if (ball.getCenterY() < ball.getRadius() || 
            ball.getCenterY() > getHeight() - ball.getRadius()) {
          ball.dy *= -1; // Change ball move direction
        }
        // Adjust ball position
        ball.setCenterX(ball.dx + ball.getCenterX());
        ball.setCenterY(ball.dy + ball.getCenterY());
      }
    }
    
    public int getRadius() {
    	return radius;
    }
    public void setRadius(int radius) {
    	this.radius = radius;
    }
  }
  class Ball extends Circle {
    private double dx = 1, dy = 1;
    Ball(double x, double y, double radius, Color color) {
      super(x, y, radius);
      setFill(color); // Set ball color
    }
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}