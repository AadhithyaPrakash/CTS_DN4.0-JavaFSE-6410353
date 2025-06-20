interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word Document");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF Document");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel Document");
    }
}

class DocumentFactory {
    public static Document createDocument(String type) {
        switch (type.toLowerCase()) {
            case "word": return new WordDocument();
            case "pdf": return new PdfDocument();
            case "excel": return new ExcelDocument();
            default: return null;
        }
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Document doc1 = DocumentFactory.createDocument("word");
        Document doc2 = DocumentFactory.createDocument("pdf");
        Document doc3 = DocumentFactory.createDocument("excel");

        if (doc1 != null) doc1.open();
        if (doc2 != null) doc2.open();
        if (doc3 != null) doc3.open();
    }
}
