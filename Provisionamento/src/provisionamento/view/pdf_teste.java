/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package provisionamento.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Lucas
 */
public class pdf_teste {
    
    public static void main(String[] args) throws Exception {
        Document doc = null;
        OutputStream os = null;

    try {
        //cria o documento tamanho A4, margens de 2,54cm
        doc = new Document(PageSize.A4, 72, 72, 72, 72);

        //cria a stream de saída
        os = new FileOutputStream("C:\\Temp\\out.pdf");

        //associa a stream de saída ao
        PdfWriter.getInstance(doc, os);

        //abre o documento
        doc.open();

        //adiciona o texto ao PDF
        Paragraph p = new Paragraph("Meu primeiro arquivo PDF!");
        doc.add(p);
        } finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
               //fechamento da stream de saída
               os.close();
            }
        }
    }

    
}
