package com.example.project1_0;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class Line {

    private double start;
    public Line(NodeList properties, ArrayList<Object> Blocks) {
        for (int i = 0; i < properties.getLength(); i++) {
            Element currentElement = (Element)properties.item(i);

            if (currentElement.getAttribute("Name").equals("Src")) {
                int source = currentElement.getTextContent().charAt(0) - 48;

                for (Object block : Blocks) {
                    if (((Block)block).getID() == source ) {
                        start = ((Block)block).getX();
                    }
                }
            }

            if (currentElement.getParentNode().getNodeName().equals("Branch")) {

                System.out.println("Branched");
            }
        }
    }
}
