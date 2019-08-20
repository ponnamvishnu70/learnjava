package learnjava.practice.springweb.custompropertyeditor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateCustomPropertyEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy*MM*dd");
		LocalDate ld= LocalDate.parse(text, dtf );
		setValue(ld);	
	}

}
