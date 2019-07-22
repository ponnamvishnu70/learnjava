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

public class RequestReplyJMS {
	
	public static void main(String[] args) {
		ActiveMQConnectionFactory amqf = null;
		try {
			//Looking up for queues
			InitialContext icontext = new InitialContext();
			Queue queue = (Queue) icontext.lookup("queue/requestQueue");
			Queue replyqueue = (Queue) icontext.lookup("queue/replyQueue");
			
			//getting connection factory and creating context
			amqf = new ActiveMQConnectionFactory();
			JMSContext jmscontext = amqf.createContext();
			
			//creating producer and send message 
			JMSProducer producer = jmscontext.createProducer();
			Message message = jmscontext.createTextMessage("Hello from Jmscontext create text message");
			
			message.setJMSReplyTo(replyqueue);
			producer.send(queue, message);
			
			//receiving the message from queue
			JMSConsumer consumer = jmscontext.createConsumer(queue);
			TextMessage receive = (TextMessage) consumer.receive();
			Queue jmsReplyTo = (Queue) receive.getJMSReplyTo();
			System.out.println("consumer just received the message "+ receive.getText());
			String jmsMessageID = receive.getJMSMessageID();
			System.out.println(jmsMessageID);
			
			//creating the producer to reply back 
			JMSProducer replyproducer = jmscontext.createProducer();
			Message replymessage = jmscontext.createTextMessage("Hello from Jmscontext REPLY.... we received your message");
			//This to identify which request this reply belongs. we can use the  correction id 
			replymessage.setJMSMessageID(receive.getJMSCorrelationID());
			replyproducer.send(jmsReplyTo, replymessage);
			
			//Receiving the reply back ...
			JMSConsumer replyconsumer = jmscontext.createConsumer(jmsReplyTo);
			TextMessage receivereplymsg = (TextMessage) replyconsumer.receive();			
			System.out.println("consumer just received reply message "+ receivereplymsg.getText());
			String jmscorrelationID = receivereplymsg.getJMSCorrelationID();
			System.out.println(jmscorrelationID);
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}finally {
			amqf.close();
		}
		
	
	}

}
