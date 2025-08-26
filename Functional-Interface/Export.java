interface Exporter {
    void export(String data);
    default void exportToJSON(String data) { System.out.println("Exporting to JSON: " + data); }
}

class CSVExporter implements Exporter {
    public void export(String data) { System.out.println("Exporting to CSV: " + data); }
}

class PDFExporter implements Exporter {
    public void export(String data) { System.out.println("Exporting to PDF: " + data); }
}

public class ExportDemo {
    public static void main(String[] args) {
        Exporter e1 = new CSVExporter();
        Exporter e2 = new PDFExporter();
        e1.export("Report");
        e2.export("Report");
        e1.exportToJSON("Report");
    }
}
