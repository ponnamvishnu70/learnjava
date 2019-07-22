package learnjava.practice.jms.topic;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import learnjava.practice.jms.model.Employee;

public class SecurityApp {
	
	public static void main(String[] args) throws NamingException {
		
		InitialContext context = new InitialContext();
		Topic topic = (Topic) context.lookup("topic/empTopic");
		try(ActiveMQConnectionFactory amqcf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = amqcf.createContext()){
			jmsContext.setClientID("securityApp");
			JMSConsumer consumer = jmsContext.createDurableConsumer(topic, "subricrition1");
			consumer.close();
			Thread.sleep(10000);
			 consumer = jmsContext.createDurableConsumer(topic, "subricrition1");
			ObjectMessage receiveobjMessage = (ObjectMessage) consumer.receive();
			Employee employeeObj = (Employee) receiveobjMessage.getObject();
			System.out.println("This is from Security APP ::: the name of the employee is "+employeeObj.getFname()+" "+employeeObj.getLname());
			
		}catch (Exception e) {
		}
		
		
	}

}
