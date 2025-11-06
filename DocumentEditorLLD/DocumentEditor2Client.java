package DocumentEditorLLD;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//**************************************************//
interface DocElement {
    String render();
}

class TextElement implements DocElement {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        System.out.println("rendering text");
        return text;
    }
}

class ImageElement implements DocElement {
    private String path;

    public ImageElement(String path) {
        this.path = path;
    }

    @Override
    public String render() {
        return "[Image: " + path + "]";
    }
}

class TabElement implements DocElement {
    @Override
    public String render() {
        return "\t";
    }
}
// **************************************************//

class Document {
    private List<DocElement> elements = new ArrayList<>();

    void addElement(DocElement ele) {
        elements.add(ele);
    }

    public String render() {
        StringBuilder result = new StringBuilder();
        for (DocElement ele : elements) {
            result.append(ele.render());
        }
        return result.toString();
    }
}

// **************************************************//

interface Persistence {
    void save(String doc);
}

class SaveToFile implements Persistence {
    @Override
    public void save(String doc) {
        try {
            FileWriter writer = new FileWriter("doc1.txt");
            writer.write(doc);
            writer.close();
            System.out.println("Saved to file");
        } catch (IOException e) {
            System.out.println("Error while saving: " + e);
        }
    }
}

class SaveToDB implements Persistence {
    @Override
    public void save(String doc) {
        System.out.println("Saved to database: " + doc);
    }
}

// **************************************************//

class DocumentEditor2 {
    private Document document;
    private Persistence persistence;
    private String renderedDocument = "";

    public DocumentEditor2(Document document, Persistence storage) {
        this.document = document;
        this.persistence = storage;
    }

    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    public void addImage(String path) {
        document.addElement(new ImageElement(path));
    }

    public void addTab() {
        document.addElement(new TabElement());
    }

    public String renderDocument() {
        renderedDocument = document.render();
        return renderedDocument;
    }

    public void save() {
        persistence.save(renderDocument());
    }
}

// **************************************************//

public class DocumentEditor2Client {
    public static void main(String[] args) {
        Document document = new Document();
        Persistence persistence = new SaveToFile();
        DocumentEditor2 docEditor = new DocumentEditor2(document, persistence);

        docEditor.addText("Hello, world!");
        docEditor.addTab();
        docEditor.addText("This is a real-world document editor example.");
        docEditor.addTab();
        docEditor.addTab();
        docEditor.addText("Indented text after a tab space.");
        docEditor.addTab();
        docEditor.addImage("picture.jpg");

        System.out.println(docEditor.renderDocument());
        docEditor.save();
    }
}
