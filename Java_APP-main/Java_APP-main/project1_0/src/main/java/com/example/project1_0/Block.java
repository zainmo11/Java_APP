package com.example.project1_0;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import org.w3c.dom.*;

import java.util.ArrayList;

public class Block {

    private static ArrayList<Block> CreatedBlocks = new ArrayList<Block>();

    private Rectangle block;

    private String data;
    private String name;

    private Text nameText;

    private Port input;

    private int posX;
    private int posY;
    private int inputs = 1;

    private double width;
    private double height;

    private int ID;

    public Block(NodeList properties, String name, int ID) {
        this.name = name;
        this.ID = ID;

        for (int i = 0; i < properties.getLength(); i++) {
            Element currentElement = (Element)properties.item(i);
            if (currentElement.getAttribute("Name").equals("Position")) {
                this.extractData(currentElement.getTextContent());
            }

            if (currentElement.getAttribute("Name").equals("Ports")) {
                String portsData = currentElement.getTextContent().replaceAll("[^\\d,-]", "");

                this.inputs = portsData.charAt(0) - 48;
            }


        }

        double newX = this.posX - SimulinkApplication.WIDTH * .7;
        double newY = this.posY + SimulinkApplication.HEIGHT * .1;

        this.nameText = new Text(this.name);
        this.nameText.setX(newX + 10);
        this.nameText.setY(newY + this.height * 0.8);

        double textWidth = this.nameText.getLayoutBounds().getWidth();
        this.width = textWidth + 20;
        this.height = this.height * 1.4;

        this.block = new Rectangle(newX, newY, this.width, this.height);
        this.block.setStroke(Color.BLACK);
        this.block.setFill(Color.WHITE);

        Block.CreatedBlocks.add(this);

        input = new Port(this.inputs, this);

        System.out.println("Block name: " + this.name + ", x:" + this.getX() + ", Block y: " + this.getY() + ", Width: " + this.width + ", Height: " + this.height + ", ID: " + this.ID);

    }

    public void drawBlock(Parent root) {
        //NOTE: The root object in the fxml file must be AnchorPane

        ((AnchorPane)root).getChildren().add(this.block);
        ((AnchorPane)root).getChildren().add(this.nameText);
        input.drawPort(root);
    }

    public void renderFront() {
        this.block.toFront();
        this.nameText.toFront();
    }

    public double getConnectorPosY() {
        return input.getFreeConnector().getCenterY();
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

    public double getWidth() { return width; }
    public double getHeight() { return height; }

    private void extractData(String data) {
        this.data = data.replaceAll("[^\\d,-]", "");
        String[] cleanData = this.data.split(",");

        this.posX = Integer.parseInt(cleanData[0]);
        this.posY = Integer.parseInt(cleanData[1]);

        this.width = Integer.parseInt(cleanData[2]) -  Integer.parseInt(cleanData[0]);
        this.height = Integer.parseInt(cleanData[3]) -  Integer.parseInt(cleanData[1]);
    }

    public static Block getBlockByID(int ID) {
        for (Block block : CreatedBlocks) {
            if (block.getID() == ID)
                return block;
        }

        return null;
    }
}
