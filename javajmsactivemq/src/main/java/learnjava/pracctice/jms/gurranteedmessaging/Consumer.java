package learnjava.pracctice.jms.gurranteedmessaging;

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

public class Consumer {

public static void main(String[] args) throws NamingException, JMSException {

	InitialContext context = new InitialContext();
	Queue queue = (Queue) context.lookup("queue/requestQueue");
	try(ActiveMQConnectionFactory amqcf = new ActiveMQConnectionFactory();
			JMSContext jmsContext = amqcf.createContext()){
		JMSConsumer consumer = jmsContext.createConsumer(queue);	
		TextMessage receive = (TextMessage) consumer.receive();
		System.out.println("message sent received"+receive.getText());
	}
	

}

}
