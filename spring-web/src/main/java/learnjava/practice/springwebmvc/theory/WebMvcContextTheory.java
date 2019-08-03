package learnjava.practice.springwebmvc.theory;

public class WebMvcContextTheory {
	/*
	 * Spring WEB MVC
	 * 
	 * ApplicationContext is child interface of BeanFactory. ApplicationContext
	 * creates and manages all the beans defined in the configuration file.
	 * ApplicationContext = Bean Factory + more features (wiring, event
	 * publishing………) In standalone application if your configuration file is xml
	 * use ApplicationContext appcontext = new
	 * ClassPathXmlApplicationContext("Beans.xml"); And if your configuration file
	 * is a java class ApplicationContext ctx = new
	 * AnnotationConfigApplicationContext(JavaBasedConfigExample.class); In WEB
	 * Applications beans are created internally using
	 * ClassPathXmlApplicationContext(for XML) OR
	 * AnnotationConfigApplicationContext(for java based configuration) In web
	 * applications we have web.xml <!—DefaultAnnotationHandlerMapping/
	 * RequestMappingHandlerMapping(3.2 or later) will be used as default handler
	 * for mapping by DispatcherServlet on java 5 onwards--> <!-- Dispatcher servlet
	 * defined below will take all the request and uses default handler and forward
	 * the request to the controllers -- > <!—dispatcher servlet will look for xml
	 * with springwebmvc-servlet.xml and if you want to use custom name for your
	 * file then add your file name as init aram to dispatcher servlet-- >
	 * <!—dispatcher servlet will have its own application context with context
	 * beans and view resolver beans defined. This context can be one for dispatcher
	 * servlet. This is the child context of root application context. The beans
	 * that are defined in root application can be referred here in dispatcher
	 * servlet context but vice versa not possible-- > <servlet>
	 * <servlet-name>springwebmvc</servlet-name> <servlet-class>
	 * org.springframework.web.servlet.DispatcherServlet </servlet-class>
	 * <load-on-startup>1</load-on-startup> </servlet>
	 * 
	 * <servlet-mapping> <servlet-name>springwebmvc</servlet-name>
	 * <url-pattern>/</url-pattern> </servlet-mapping>
	 * 
	 * <!—This is the Root Context. This is one per web application. Usually beans
	 * defined here are service, daos.. T-- >
	 * 
	 * <!--1) Below tag is not neccessary is your beans file is
	 * ApplicationContext.xml because this default for spring webmvc. Don’t just add
	 * Context Loader Listener listener class.this will throw an error --> <!--2)
	 * below Listener tag should be in conjuction with context param with param name
	 * contextConfigLocation and location of the beans file--> <listener>
	 * <listener-class> org.springframework.web.context.ContextLoaderListener
	 * </listener-class> </listener> <context-param>
	 * <param-name>contextConfigLocation</param-name>
	 * <param-value>/WEB-INF/rootApplicationContext.xml</param-value>
	 * </context-param>
	 * 
	 * <context:component-scan
	 * base-package="learnjava.practice"></context:component-scan> Component scan
	 * will specify spring container to look for the packages mentioned for classes
	 * annotated and loaded them as beans. If you are using java based configuration
	 * the equivalent will be
	 * 
	 * @ComponentScan <context:annotation-config/> Annotation on the registered bean
	 * will be activated. Even component scan can do this. Not required to used this
	 * when using component scan <mvc:annotation-driven /> This annotation is for
	 * web mvc functionality to application Java config @EnableWebMvc ==
	 * <context:annotation-config/> XML config
	 * 
	 * 
	 * WebApplicationInitializer Is the programmatic way of writing web.xml
	 * 
	 * 
	 * Java EE provides ServletContainerInitializer interface, which allows
	 * libraries to be notified of a web application startup. Since Spring 3.1 we
	 * have SpringServletContainerInitializer class which
	 * handlesWebApplicationInitializer by instantiating all found classes
	 * implementing this interface, sorting them basing on @Order annotation
	 * (non-annotated classes gets the highest possible order, so they are processed
	 * at the end) and invoking onStartup() method.
	 * 
	 * 
	 * Spring since version 3.2 provides us a few classes implementing
	 * WebApplicationInitializer interface, from which first is
	 * AbstractContextLoaderInitializer. This class included in spring-web module
	 * uses abstract createRootApplicationContext() method to create application
	 * context, delegates it toContextLoaderListener which then is being registered
	 * in the ServletContext instance. Creating application context using this class
	 * looks as follows: public class SpringAnnotationWebInitializer extends
	 * AbstractContextLoaderInitializer {
	 * 
	 * @Override protected WebApplicationContext createRootApplicationContext() {
	 * AnnotationConfigWebApplicationContext applicationContext = new
	 * AnnotationConfigWebApplicationContext();
	 * applicationContext.register(SpringAnnotationConfig.class); return
	 * applicationContext; } }
	 * 
	 * That was the simplest way to start up Spring web context. But if we want to
	 * experience benefits provided by Spring MVC and don't want to manually
	 * register DispatcherServlet it'll be better to use another class:
	 * AbstractDispatcherServletInitializer. It extends previous class and adds two
	 * abstract methods: createServletApplicationContext() and getServletMappings().
	 * First method returnsWebApplicationContext that will be passed to
	 * DispatcherServlet, which will be automatically added into container
	 * ServletContext. Please notice that this context will be established as a
	 * child of the context returned by createRootApplicationContext() method.
	 * Second method - as you have probably already deduced - returns mappings that
	 * are used during servlet registration. You can also override
	 * getServletFilters() method if you need any custom filters, because default
	 * implementation returns just empty array. Exemplary implementation using this
	 * class could be: public class SpringWebMvcInitializer extends
	 * AbstractDispatcherServletInitializer {
	 * 
	 * @Override protected WebApplicationContext createRootApplicationContext() {
	 * AnnotationConfigWebApplicationContext applicationContext = new
	 * AnnotationConfigWebApplicationContext();
	 * applicationContext.register(SpringRootConfig.class); return
	 * applicationContext; }
	 * 
	 * @Override protected WebApplicationContext createServletApplicationContext() {
	 * AnnotationConfigWebApplicationContext applicationContext = new
	 * AnnotationConfigWebApplicationContext();
	 * applicationContext.register(SpringMvcConfig.class); return
	 * applicationContext; }
	 * 
	 * @Override protected String[] getServletMappings() { return new
	 * String[]{"/*"}; } }
	 * 
	 * And now last but definitely not least class:
	 * AbstractAnnotationConfigDispatcherServletInitializer. Here we can see further
	 * step in simplifying Spring initialization - we don't need to manually create
	 * contexts but just set appropriate config classes in getRootConfigClasses()and
	 * getServletConfigClasses() methods. I hope you are already familiar with those
	 * names, because they works exactly like in the former case. Of course due to
	 * this class extends AbstractDispatcherServletInitializer we can still override
	 * getServletFilters(). Finally we can implement our configuration in the
	 * following way: public class SpringWebMvcSimpleInitializer extends
	 * AbstractAnnotationConfigDispatcherServletInitializer {
	 * 
	 * @Override protected Class<?>[] getRootConfigClasses() { return new Class[]
	 * {SpringRootConfig.class}; }
	 * 
	 * @Override protected Class<?>[] getServletConfigClasses() { return new Class[]
	 * {SpringMvcConfig.class}; }
	 * 
	 * @Override protected String[] getServletMappings() { return new
	 * String[]{"/*"}; } }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}
