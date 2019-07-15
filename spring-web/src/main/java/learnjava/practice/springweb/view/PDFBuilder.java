package learnjava.practice.springweb.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import learnjava.practice.springweb.model.Person;

@Component
public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Person person = (Person) model.get("person");

		doc.add(new Paragraph("Personal Details"));
		doc.add(new Paragraph(person.getFname() + ", " + person.getLname() + ", " + person.getAge()));

	}

}