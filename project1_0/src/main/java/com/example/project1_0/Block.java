package com.example.project1_0;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Block {

    private Rectangle block;

    private String data;
    private String name;

    private Text nameText;

    private int posX;
    private int posY;
    private int width;
    private int height;

    public Block(NodeList properties, String name) {
        this.name = name;

        for (int i = 0; i < properties.getLength(); i++) {
            Element currentElement = (Element)properties.item(i);
            if (currentElement.getAttribute("Name").equals("Position")) {
                this.extractData(currentElement.getTextContent());
            }

        }

        this.block = new Rectangle(this.posX * 0.5, this.posY * 0.5, this.width, this.height);
        this.nameText = new Text(this.name);
        this.nameText.setX(this.posX / 2 + this.width / 2 - 10);
        this.nameText.setY(this.posY / 2 + this.height + 10);
        System.out.println("Block name: " + this.name + ", x:" + this.posX + ", Block y: " + this.posY + ", Width: " + this.width + ", Height: " + this.height);
    }

    public void drawBlock(Parent root) {
        //NOTE: The root object in the fxml file must be AnchorPane

        ((AnchorPane)root).getChildren().add(this.block);
        ((AnchorPane)root).getChildren().add(this.nameText);
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
