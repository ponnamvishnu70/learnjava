package learnjava.practice.jms.topic;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import learnjava.practice.jms.model.Employee;

public class HRApp {
	
	
	public static void main(String[] args) throws NamingException, JMSException {
		InitialContext context = new InitialContext();
		Topic topic = (Topic) context.lookup("topic/empTopic");
		try(ActiveMQConnectionFactory amqcf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = amqcf.createContext()){
			Employee e = new Employee();
			e.setAge(28);
			e.setFname("vishnu");
			e.setLname("ponnam");
			JMSProducer producer = jmsContext.createProducer();
			ObjectMessage objectMessage = jmsContext.createObjectMessage();
			objectMessage.setIntProperty("age", 28);
			objectMessage.setObject(e);
			producer.send(topic, objectMessage);
			System.out.println("message sent out");
		}
		
	}

}
