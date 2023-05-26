package com.example.project1_0;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class ConnectorLine {
    private int count = 0;
    private ArrayList<Double> destArrayX;
    private ArrayList<Double> destArrayY;
    private ArrayList<Line> LinesArray;
    private double startX;
    private double startY;
    private double sourceWidth;
    private double sourceHeight;
    public ConnectorLine(NodeList properties, ArrayList<Block> Blocks) {
        this.destArrayX = new ArrayList<Double>();
        this.destArrayY = new ArrayList<Double>();
        this.LinesArray = new ArrayList<Line>();

        for (int i = 0; i < properties.getLength(); i++) {
            Element currentElement = (Element)properties.item(i);

            if (currentElement.getAttribute("Name").equals("Src")) {
                int source = currentElement.getTextContent().charAt(0) - 48;

                for (Block block : Blocks) {
                    if (block.getID() == source ) {
                        this.startX = block.getX();
                        this.startY = block.getY();
                        this.sourceWidth = block.getWidth();
                        this.sourceHeight = block.getHeight();
                    }
                }
            } else if (currentElement.getAttribute("Name").equals("Dst")) {
                int dest = currentElement.getTextContent().charAt(0) - 48;
                this.count++;
                for (Block block : Blocks) {
                    if (block.getID() == dest ) {
                        block.destinationCount++;

                        double destinationPosY = block.getY() + (block.getHeight()) / 2;

                        this.destArrayX.add(block.getX());
                        this.destArrayY.add(destinationPosY);
                    }
                }
            }
        }

        for (int i = 0; i < this.count; i++) {

            double space = sourceHeight / (1 + count);

            double lineStartX = startX + sourceWidth;
            double lineStartY = startY + space * (i + 1);
            System.out.println("Line X; " + lineStartX + "Line Y: " + lineStartY);

            Line line = new Line(lineStartX, lineStartY, this.destArrayX.get(i), this.destArrayY.get(i));
            this.LinesArray.add(line);
        }
    }

    public void drawLine(Parent root) {
        //NOTE: The root object in the fxml file must be AnchorPane
        for (Line line : LinesArray) {
            ((AnchorPane)root).getChildren().add(line);
        }
    }
}
