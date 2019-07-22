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

public class ExpiredQueueExample {
	
	public static void main(String[] args) throws InterruptedException {

		try {
			InitialContext icontext = new InitialContext();
			Queue queue = (Queue) icontext.lookup("queue/myQueue");
			Queue expiryqueue = (Queue) icontext.lookup("queue/expiryQueue");
			ActiveMQConnectionFactory amqf = new ActiveMQConnectionFactory();
			JMSContext jmscontext = amqf.createContext();
			JMSProducer producer = jmscontext.createProducer();
			TextMessage message1 = jmscontext.createTextMessage("Hello from Jmscontext create text message1");
			message1.setBooleanProperty("jms", true);
			message1.setStringProperty("name", "vishnu");
			//producer.setTimeToLive(3000);			
			producer.setDeliveryDelay(3000);
			producer.send(queue, message1);
			//Thread.sleep(4000);
			JMSConsumer consumer = jmscontext.createConsumer(queue);
			TextMessage receivemsg1 = (TextMessage)consumer.receive(4000);			
			if(receivemsg1 == null) {
				System.out.println("Entered expired queue");
				 consumer = jmscontext.createConsumer(expiryqueue);
				 receivemsg1 = (TextMessage)consumer.receive();
			}
			System.out.println(receivemsg1.getBooleanProperty("jms"));
			System.out.println(receivemsg1.getStringProperty("name"));
			System.out.println("receiving from queue "+receivemsg1.getText());

			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	
	}

}
