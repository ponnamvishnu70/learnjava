package learnjava.practice.springwebmvc.controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import learnjava.practice.springweb.custompropertyeditor.LocalDateCustomPropertyEditor;
import learnjava.practice.springweb.exceptionhandlers.CustomException;
import learnjava.practice.springweb.form.FileUploadForm;
import learnjava.practice.springweb.model.Person;
import learnjava.practice.springweb.model.Student;
import learnjava.practice.springwebmvc.validators.CustomValidator;

@Controller
public class HelloController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		if (binder.getTarget() instanceof Person) {
			//this way we can have different kinds of validations			
		}
	
		System.out.println("inside webdatabinder1");
		//binder.setDisallowedFields("lname");
		//this is global place for validation .every request will be validate if the modelattribute is present 
		//binder.setValidator(new CustomValidator());
		binder.registerCustomEditor(LocalDate.class, "dob", new LocalDateCustomPropertyEditor());
	}
	
	
	@RequestMapping("/hello/{name}")
	public String greet(Map<String, Object> model,@PathVariable("name") String name) {
		System.out.println(name);
		model.put("msg", "Hellooooo.............."+name);
		System.out.println("inside controller");
		Integer count = jdbcTemplate.queryForObject("select count(*) from hist_eod_data", Integer.class); 
		model.put("count", "count from hist_eod_data is "+ count);
		return "hello";	
	}
	
	//@modelattribute to get form objecct from front end
	//EX front end from will have modelattribute as an <form:form method="post" modelAttribute="fileUploadForm">
	//Model(I) and ModelMap a class to carry data to front ends
	//modelandview container of both view name and data
	//all the method arguments will be passed by spring container
	@RequestMapping("/hello1")
	public String greet1(Map<String, Object> model,@Valid @ModelAttribute Person person,BindingResult result,@ModelAttribute Student student,BindingResult result1, HttpServletRequest req) {
		//just an example. do not write code validating multiples models in same class. write separate class for each custom validator
		CustomValidator cv = new CustomValidator();
		cv.validate(person, result1);
		if(result.hasErrors()) {
		model.put("msg", "errors in form");
		return "hello";
	}
	
	cv.validate(student, result1);
	if(result1.hasErrors()) {
		model.put("msg", "errors in form");
		return "hello";
	}
		System.out.println(req.getContextPath());
		System.out.println(model);
		System.out.println(person.getFname() +"  "+person.getLname());		
		model.put("msg", "Hellooooo1.............."+person.getDob());
		System.out.println("inside controller");
	return "hello";	
	}
	
	
	@RequestMapping("/hello2")
	public String greet2(HttpServletRequest req) {
		if(req.getContextPath()!="vishnu") {//this code is just satisfy compiler 
		throw new CustomException("Exception from greet2");
		}
		return "hello";	
	}
	
	/*1. To use with Apache Commons . Spring CommonsMultipartResolver is a
	 MultipartResolver implementation for use with Apache Commons FileUpload. It
	 requires apache commons-fileupload.jar to be present on classpath. It’s not
	 specific to Servlet 3 environment but it works equally well with Servlet 3.x
	 containers.
	<dependency>
	    <groupId>commons-fileupload</groupId>
	    <artifactId>commons-fileupload</artifactId>
	    <version>1.3.1</version>
	</dependency>
	2. To use with Servlet 3.0 multipart request. Depends on which setup you are using[XML or JavaConfig].
	For XML setup, you need to mark the DispatcherServlet with a "multipart-config" section in web.xml.
	For Annoataion/JavaConfig setup, registering javax.servlet.MultipartConfigElement with DispatcherServlet. OR using @MultipartConfig on a custom servlet.
	*/
	@RequestMapping("/hello5")
	public String fileUpload(@ModelAttribute("fileUploadForm") FileUploadForm fileUploadForm) {		
		System.out.println(fileUploadForm.getFile().getOriginalFilename());
		try (FileOutputStream fo = new FileOutputStream("C:\\Resources\\inbound\\"+fileUploadForm.getFile().getOriginalFilename())){
			fo.write(fileUploadForm.getFile().getBytes());
			fo.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hello";
	}

	
	//This method will always return string that will be used by internalviewresolver
	//if the url has a .json or .pdf extension spring will figure our which bean to invoke for view resolution based on set content type on class
	//for example look at AbstractITextPdfView and MappingJackson2JsonView 
	@RequestMapping("/hello6")
	public String pdfDownload(Map<String, Object> model) {		
		Person p=  new Person("vishnu", "Ponnam", 26);
		model.put("person", p);
		return "person";
	}

	//download a existing file
	@RequestMapping("/downloadpdf")
	public void downloadpdf(Map<String, Object> model,HttpServletRequest req, HttpServletResponse res) throws IOException {		
		File f = new File("C:\\Users\\AA0534\\Desktop\\SpringBatch.pdf");
		FileInputStream fi = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fi);
		res.setContentType("application/pdf");
		//if you want download the file directly set Content-Disposition attachment
		//res.setHeader("Content-Disposition", String.format("inline; filename=SpringBatch.pdf"));
		//if you want download the file directly set Content-Disposition attachment
		res.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", f.getName()));
        res.setContentLength((int)f.length());
		FileCopyUtils.copy(bis, res.getOutputStream());	
	
	}

	@ResponseBody
	@RequestMapping(value = "/jsonTest", produces = "application/json; charset=UTF-8")
	public List<Person> persons(){
		Person p1 = new Person();
		p1.setAge(28);
		Person p2 = new Person();
		p2.setAge(29);
		Person p3 = new Person();
		p3.setAge(27);
		
		List<Person> l = new ArrayList<Person>();
		l.add(p1);
		l.add(p2);
		l.add(p3);
		return l;
	}
	
}
