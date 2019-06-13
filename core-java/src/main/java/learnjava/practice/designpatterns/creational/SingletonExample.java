package learnjava.practice.designpatterns.creational;

public class SingletonExample {
	
	//public static final SingletonExample singleton = new SingletonExample() ;
	public static volatile SingletonExample singleton ;
	
	//Make constructor Private so that you can't create a object with new
	private SingletonExample() {
		// protection from reflection
        if(singleton != null) {
            throw new IllegalStateException("Singleton initialized");
        }
	}
	
	//Preventing a  way to create new instance from de-serialization
	protected Object readResolve() {
	        return singleton;
	    }
	
	public static SingletonExample GetInstance(){
		if (singleton == null) {
			synchronized (singleton) {
				if(singleton == null) {
				singleton = new SingletonExample();
			}
		}
		}
		return singleton;
	}
	
	//This static inner class is loaded only after getInstance() is called for the first time. */
    private static class SingletonHelper {
        private static final SingletonExample SINGLE_INSTANCE = new SingletonExample();
    }
    
    public static SingletonExample getInstance() {
        return SingletonHelper.SINGLE_INSTANCE;
    }
	
	/* Using Reflections we can still get a new object. just block it in the constructor
	 try {
            Constructor[] constructors = MySingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                reflectionInstance = (MySingleton) constructor.newInstance();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    */
	

}
