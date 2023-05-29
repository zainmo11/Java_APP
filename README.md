# Simulink MDL File Viewer

The **Simulink MDL File Viewer** is a software tool developed to read Simulink MDL files and display their contents in a user-friendly way using a Java-based graphical user interface (GUI). The tool aims to provide users with an intuitive interface to navigate through Simulink models.

## Introduction

Simulink is a widely-used simulation and modeling environment in various industries such as automotive, aerospace, and electronics. Simulink MDL files contain crucial model information that is utilized to simulate and analyze system behavior. This project aims to enhance the usability of Simulink models by providing a tool that offers a visual representation of the model structure, and connections.

## Features

The Simulink MDL File Viewer offers the following features:

1. **Loading and Parsing**: The tool allows users to load Simulink MDL files and parses them to extract the model information.

2. **Connection Visualization**: The tool visualizes the connections between blocks, making it easier for users to understand the flow of data within the model.

### Features in devel`opment

1. File modification using our GUI

2. Add block functionality

## Usage

To use the Simulink MDL File Viewer, follow these steps:

1. Launch the application.

2. Click on the "Import" button to select and load a Simulink MDL file.

3. Once the file is loaded, the GUI will display the structure of the model.

## Development

The Simulink MDL File Viewer is developed using Java and JavaFX. The project consists of two main components:

1. **Simulink MDL File Parser**: This component is responsible for parsing Simulink MDL files and extracting the model information, including the block diagram, parameters, and connections. It utilizes the parsing logic to convert the file contents into a structured representation.

2. **Java-based GUI**: The GUI component provides an intuitive user interface to display the model structure and properties. It enables users to interact with the model, modify its components, and visualize the changes in real-time.

## Dependencies

The Simulink MDL File Viewer has the following dependencies:

- Java Development Kit (JDK) version 8 or later.
- JavaFX library.

## Preview

![](https://github.com/abdlrhman08/MDL-File-Viewer/blob/main/preview/preview.png?raw=true)


## Contributors

- Abdelrahman Atef Saad 2101645
- Abdelrahman Zain Mohammed 2101646
