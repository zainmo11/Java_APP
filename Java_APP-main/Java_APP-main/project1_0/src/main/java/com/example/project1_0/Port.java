package com.example.project1_0;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Port {
    private int num;

    private ArrayList<Boolean> connected;
    private ArrayList<Circle> connectors;

    private Block src;

    public Port(int num, Block src) {
        this.src = src;
        this.num = num;

        this.connectors = new ArrayList<Circle>();
        this.connected = new ArrayList<Boolean>();

        double srcHeight = this.src.getHeight();
        double space = srcHeight / (1 + num);

        for (int i = 0; i < num; i++) {
            this.connectors.add(new Circle(this.src.getX(), this.src.getY() + ((1 + i) * space), 2, Color.BLACK));
            this.connected.add(false);
        }
    }

    public void drawPort(Parent root) {
        //NOTE: The root object in the fxml file must be AnchorPane

        for (Circle dot : this.connectors) {
            ((AnchorPane) root).getChildren().add(dot);
            dot.toFront();
        }
    }

    public Circle getFreeConnector() {
        for (int i = 0; i < num; i++) {
            if (!this.connected.get(i)) {
                this.connected.set(i, true);
                return this.connectors.get(i);
            }
        }

        System.err.println("No free connectors found");
        return null;
    }
}
