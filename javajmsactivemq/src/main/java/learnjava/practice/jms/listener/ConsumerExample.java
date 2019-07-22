package learnjava.practice.jms.listener;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class ConsumerExample {

	public static void main(String[] args) {
		ActiveMQConnectionFactory amqf = null;
		try {
			InitialContext icontext = new InitialContext();
			Queue queue = (Queue) icontext.lookup("queue/requestQueue");
			amqf = new ActiveMQConnectionFactory();
			JMSContext jmscontext = amqf.createContext();
			JMSConsumer consumer = jmscontext.createConsumer(queue);
			//Asynchronous messaging 
			consumer.setMessageListener(new StudentMessageListener());
			Thread.sleep(5000);
		} catch (Exception e) {
		} finally {

		}
	}

}
