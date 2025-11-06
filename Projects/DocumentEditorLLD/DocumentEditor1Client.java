package Projects.DocumentEditorLLD;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DocumentEditor1 {

    private List<String> elements = new ArrayList<>();
    private String renderedDocument;

    public void addText(String text) {
        elements.add(text);
    }

    public void addImage(String path) {
        elements.add(path);
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("document.txt");
            writer.write(renderDocument());
            writer.close();
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }

    public String renderDocument() {
        if (!elements.isEmpty()) {
            StringBuilder result = new StringBuilder("");
            for (String ele : elements) {
                if (ele.length() > 4 && (ele.endsWith(".jpg") || ele.endsWith(".png"))) {
                    result.append("Image with path: " + ele + " rendered." + "\n");
                } else {
                    result.append(ele + "\n");
                }
            }

            renderedDocument = result.toString();
        }
        return renderedDocument;

    }

}

public class DocumentEditor1Client {
    public static void main(String[] args) {
        DocumentEditor1 doceditor = new DocumentEditor1();

        doceditor.addImage("https://himi.png");
        doceditor.addText("Hello himi");

        String doc = doceditor.renderDocument();
        System.out.println(doc);

        doceditor.saveToFile();
    }
}


// Problems in this architecture
// this is breaking srp as document editor class is handling multiple responsibilities like
// 1. storing elements
// 2. rendering document
// 3. saving document to file
// to follow srp we can create separate classes for each responsibility
// 1. DocumentStorage class for storing elements
// 2. DocumentRenderer class for rendering document
// 3. DocumentSaver class for saving document to file
// DocumentEditor class will use these classes to perform its operations
// this will make the code more modular and easier to maintain

// breaking ocp as if we want to add new type of element like video or audio
// we will have to modify the renderDocument method in DocumentEditor class
// to follow ocp we can create an interface Element with a method render()
// and create classes TextElement and ImageElement that implement the Element interface
// DocumentEditor class will have a list of Element objects instead of String
// this way we can add new types of elements without modifying the DocumentEditor class  