package learnjava.pracctice.jms.gurranteedmessaging;

import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class Producer {

public static void main(String[] args) throws NamingException {

	InitialContext context = new InitialContext();
	Queue queue = (Queue) context.lookup("queue/requestQueue");
	try(ActiveMQConnectionFactory amqcf = new ActiveMQConnectionFactory();
			JMSContext jmsContext = amqcf.createContext(JMSContext.AUTO_ACKNOWLEDGE)){
			
			JMSProducer producer = jmsContext.createProducer();	
		producer.send(queue, "Message produced1" );
		System.out.println("message sent out");
		
		
	}
	

}

}
