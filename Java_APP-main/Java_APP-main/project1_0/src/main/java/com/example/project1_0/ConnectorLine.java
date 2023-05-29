package com.example.project1_0;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class ConnectorLine {

    private ArrayList<Block> destinationBlocks;

    private ArrayList<Line> LinesArray;

    private double startX;
    private double startY;
    private double sourceWidth;
    private double sourceHeight;

    public ConnectorLine(NodeList properties, ArrayList<Block> Blocks) {
        this.destinationBlocks = new ArrayList<Block>();
        this.LinesArray = new ArrayList<Line>();

        for (int i = 0; i < properties.getLength(); i++) {
            Element currentElement = (Element)properties.item(i);

            if (currentElement.getAttribute("Name").equals("Src")) {
                int source = currentElement.getTextContent().charAt(0) - 48;

                Block srcBlock = Block.getBlockByID(source);

                this.startX = srcBlock.getX();
                this.startY = srcBlock.getY();
                this.sourceWidth = srcBlock.getWidth();
                this.sourceHeight = srcBlock.getHeight();

            } else if (currentElement.getAttribute("Name").equals("Dst")) {
                int dest = currentElement.getTextContent().charAt(0) - 48;

                Block destBlock = Block.getBlockByID(dest);

                this.destinationBlocks.add(destBlock);

            }
        }

        for (int i = 0; i < this.destinationBlocks.size(); i++) {

            double space = sourceHeight / (1 + this.destinationBlocks.size());

            double lineStartX = startX + sourceWidth;
            double lineStartY = startY + sourceHeight / 2;
            System.out.println("Line X; " + lineStartX + "Line Y: " + lineStartY);

            Block destBLock = this.destinationBlocks.get(i);

            double xDistance = destBLock.getX() - lineStartX;
            double firstLineDestX = lineStartX + (xDistance * 2/3);

            double destBlockY = destBLock.getConnectorPosY();

            //First line horizontal
            Line line = new Line(lineStartX, lineStartY, firstLineDestX, lineStartY);
            this.LinesArray.add(line);

            if (this.startY != destBLock.getY()) {

                //Second line vertical
                line = new Line(firstLineDestX, lineStartY, firstLineDestX, destBlockY);
                this.LinesArray.add(line);

                //Third line vertical
                line = new Line(firstLineDestX, destBlockY, destBLock.getX(), destBlockY);
                this.LinesArray.add(line);
            } else {

                line = new Line(firstLineDestX, lineStartY, destBLock.getX(), destBlockY);
                this.LinesArray.add(line);
            }

        }
    }

    public void drawLine(Parent root) {
        //NOTE: The root object in the fxml file must be AnchorPane
        for (Line line : LinesArray) {
            ((AnchorPane)root).getChildren().add(line);
        }
    }
}
