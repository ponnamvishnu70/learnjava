package learnjava.practice.springweb.view;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class PdfViewResolver implements ViewResolver{
	 
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        PDFBuilder view = new PDFBuilder();
        return view;
      }
}
