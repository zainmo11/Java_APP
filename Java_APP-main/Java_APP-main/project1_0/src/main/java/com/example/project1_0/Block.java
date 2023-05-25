package com.example.project1_0;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import org.w3c.dom.*;

public class Block {
    private Rectangle block;

    private String data;
    private String name;

    private Text nameText;

    private int posX;
    private int posY;
    private int width;
    private int height;

    private int ID;

    public Block(NodeList properties, String name, int ID) {
        this.name = name;
        this.ID = ID;

        for (int i = 0; i < properties.getLength(); i++) {
            Element currentElement = (Element)properties.item(i);
            if (currentElement.getAttribute("Name").equals("Position")) {
                this.extractData(currentElement.getTextContent());
            }

        }

        double newX = this.posX - SimulinkApplication.WIDTH * .7;
        double newY = this.posY + SimulinkApplication.HEIGHT * .1;

        this.nameText = new Text(this.name);
        this.nameText.setX(newX + 10);
        this.nameText.setY(newY + this.height * 0.8);

        double textWidth = this.nameText.getLayoutBounds().getWidth();

        this.block = new Rectangle(newX, newY, textWidth + 20, this.height * 1.4);
        this.block.setStroke(Color.BLACK);
        this.block.setFill(Color.TRANSPARENT);

        System.out.println("Block name: " + this.name + ", x:" + this.posX + ", Block y: " + this.posY + ", Width: " + this.width + ", Height: " + this.height + ", ID: " + this.ID);

    }

    public void drawBlock(Parent root) {
        //NOTE: The root object in the fxml file must be AnchorPane

        ((AnchorPane)root).getChildren().add(this.block);
        ((AnchorPane)root).getChildren().add(this.nameText);
    }

    public int getID() {
        return this.ID;
    }

    public double getX() {
        return (this.posX - SimulinkApplication.WIDTH * .7);
    }
    public double getY() {
        return (this.posY + SimulinkApplication.HEIGHT * .1);
    }

    private void extractData(String data) {
        this.data = data.replaceAll("[^\\d,-]", "");
        String[] cleanData = this.data.split(",");

        this.posX = Integer.parseInt(cleanData[0]);
        this.posY = Integer.parseInt(cleanData[1]);

        this.width = Integer.parseInt(cleanData[2]) -  Integer.parseInt(cleanData[0]);
        this.height = Integer.parseInt(cleanData[3]) -  Integer.parseInt(cleanData[1]);
    }
}
