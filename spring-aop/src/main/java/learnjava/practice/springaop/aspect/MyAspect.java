package learnjava.practice.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect// Mark a class as a class containing advice methods.
public class MyAspect {

	//A JoinPoint represents a point in your application where you can plug-in AOP aspect. You can also say,
	//it is the actual place in the application where an action will be taken using Spring AOP framework.
	@Before("execution(* get*(..))")
	public void allgetters(JoinPoint joinpoint){
		System.out.println("from getters "+joinpoint);
	}
	
	
	//PointCut is a set of one or more JoinPoint where an advice should be executed.
	//You can specify PointCuts using expressions or patterns
	//.. represent zero or more
	//in this case spriongaop and all subfolders if any
	@Pointcut("execution(* learnjava.practice.springaop..*change(..))")
	public void allmethodendwithchange() {}
	
	@Before("allmethodendwithchange()")
	public void adviceforchangemethod() {
		System.out.println("allmethodendwithchange");
	}
	
	@After("allmethodendwithchange()")
	public void adviceforchangemethodafter() {
		System.out.println("adviceforchangemethodafter");
	}
	
	@AfterReturning("allmethodendwithchange()")
	public void adviceforchangemethodafterreturn() {
		System.out.println("adviceforchangemethodafterreturn");
	}
	
	@AfterThrowing("allmethodendwithchange()")
	public void adviceforchangemethodafterthrowing() {
		System.out.println("adviceforchangemethodafterthrowing");
	}
	
	@AfterReturning(pointcut = "args()", returning="returnedBoolean")
	public void adviceforchangemethodafterreturnboolean(boolean returnedBoolean) {
		System.out.println("adviceforchangemethodafterreturnboolean " + returnedBoolean);
	}
	
	//with @around you can modify the return object..but not posssible with afterreturn
	@Around("allmethodendwithchange()")
	public boolean aroundoilchange(ProceedingJoinPoint pjp) {
		System.out.println("before actual method call");
		boolean isoilchanged;
		try {
		isoilchanged=(Boolean)pjp.proceed();
		} catch (Throwable e) {	}
		System.out.println("after actual method call");
		return false;
		
	}
	
	@Before("@annotation(learnjava.practice.springaop.customannotations.Loggable)")
	public void customannotation() {
		System.out.println("@annotation(learnjava.practice.springaop.customannotations.Loggable)");
		
	}
	@Pointcut("within(learnjava.practice.springaop.service.CarService)")
	public void allmethodsincarservice() {
	}
	
	@Before("allmethodsincarservice()")
	public void allmethodscarservice() {
		System.out.println("allmethodsincarservice allmethodsincarservice");
	}
	
}
