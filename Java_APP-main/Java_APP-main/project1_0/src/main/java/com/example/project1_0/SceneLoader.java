package com.example.project1_0;

import javafx.scene.Parent;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class SceneLoader {
    private File mdlFile;
    private File tempFile;

    private FileWriter writer;

    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder Builder;
    private Document ParsedXML;

    private Parent root;

    private ArrayList<Block> BlocksArray;
    private ArrayList<ConnectorLine> LinesArray;

    private NodeList Blocks;
    private NodeList Lines;

    private String filename;

    private boolean StartOfFile = false;

    public SceneLoader(String filename, Parent root) {
        this.BlocksArray = new ArrayList<Block>();
        this.LinesArray = new ArrayList<ConnectorLine>();
        this.root = root;

        try {
            this.filename = filename;
            this.mdlFile = new File(this.filename);
            this.writer = new FileWriter(this.filename + ".temp");

            FileReader reader = new FileReader(this.mdlFile);
            BufferedReader bfReader = new BufferedReader(reader);

            String line;

            while ((line = bfReader.readLine()) != null) {
                if (StartOfFile) {this.writer.write(line + "\n");}

                if (line.equals("__MWOPC_PART_BEGIN__ /simulink/systems/system_root.xml")) { StartOfFile = true; }
                if (line.equals("</System>")) break;
            }

            this.writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseFile() {
        try {
            this.tempFile = new File(this.filename + ".temp");
            this.dbFactory = DocumentBuilderFactory.newInstance();
            this.Builder = dbFactory.newDocumentBuilder();
            this.ParsedXML = Builder.parse(tempFile);

            this.Blocks = this.ParsedXML.getElementsByTagName("Block");
            this.Lines = this.ParsedXML.getElementsByTagName("Line");

            for (int i = 0; i < this.Blocks.getLength(); i++) {
                Element currentBlock = (Element)this.Blocks.item(i);
                NodeList properties = currentBlock.getElementsByTagName("P");

                int id = Integer.parseInt(currentBlock.getAttribute("SID"));

                Block block = new Block(properties, currentBlock.getAttribute("Name"), id);
                this.BlocksArray.add(block);
            }

            for (int i = 0; i < this.Lines.getLength(); i++) {
                Element readLine = (Element)this.Lines.item(i);
                NodeList properties = readLine.getElementsByTagName("P");

                ConnectorLine line = new ConnectorLine(properties, this.BlocksArray);
                this.LinesArray.add(line);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void close() {
        this.tempFile.delete();
    }

    public void drawScene() {
        for (Block block : this.BlocksArray)
            block.drawBlock(this.root);

        for (ConnectorLine line : this.LinesArray)
            line.drawLine(this.root);

        //for (Block block : this.BlocksArray)
         //   block.renderFront();
    }
}
