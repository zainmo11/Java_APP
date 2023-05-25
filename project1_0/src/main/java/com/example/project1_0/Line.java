package com.example.project1_0;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Line {

    private int start;
    public Line(NodeList properties) {
        for (int i = 0; i < properties.getLength(); i++) {
            Element currentElement = (Element)properties.item(i);

            if (currentElement.getAttribute("Name").equals("Src")) {
                int source = currentElement.getTextContent().charAt(0) - 48;
            }

            if (currentElement.getParentNode().getNodeName().equals("Branch")) {

                System.out.println("Branched");
            }
        }
    }
}
