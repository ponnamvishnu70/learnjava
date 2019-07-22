package learnjava.practice.jms.context;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class JMSContextDemo {
	
	public static void main(String[] args) {
		try {
			InitialContext icontext = new InitialContext();
			Queue queue = (Queue) icontext.lookup("queue/myQueue");
			ActiveMQConnectionFactory amqf = new ActiveMQConnectionFactory();
			JMSContext jmscontext = amqf.createContext();
			JMSProducer producer = jmscontext.createProducer();
			Message message1 = jmscontext.createTextMessage("Hello from Jmscontext create text message1");
			Message message3 = jmscontext.createTextMessage("Hello from Jmscontext create text message3");
			producer.setPriority(2);
			producer.send(queue, message1);			
			producer.setPriority(9);
			producer.send(queue, message3);
			JMSConsumer consumer = jmscontext.createConsumer(queue);
			jmscontext.start();
			TextMessage receivemsg1 = (TextMessage)consumer.receive();
			System.out.println("receiving from queue "+receivemsg1.getText());
			TextMessage receivemsg2 = (TextMessage)consumer.receive();
			System.out.println("receiving from queue "+receivemsg2.getText());
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
