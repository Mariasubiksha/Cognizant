package factory;

interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word document.");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document.");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel document.");
    }
}

abstract class DocumentFactory {
    abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}
