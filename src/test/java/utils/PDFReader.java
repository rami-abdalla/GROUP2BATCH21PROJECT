package utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class PDFReader {

    public static void main(String[] args) {
        try {

            URL resource = PDFReader.class.getClassLoader().getResource("InvalidPDFfile/invalid_pdf.pdf");
            if (resource == null) {
                throw new IllegalArgumentException("File not found!");
            }


            File file = new File(resource.toURI());


            PDDocument document = PDDocument.load(file);


            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);


            System.out.println(text);


            document.close();

        } catch (IOException e) {
            System.err.println("An error occurred while reading the PDF: " + e.getMessage());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
