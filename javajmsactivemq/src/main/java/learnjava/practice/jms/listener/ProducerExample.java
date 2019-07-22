package learnjava.practice.jms.listener;

import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.naming.InitialContext;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import learnjava.practice.jms.model.Student;

public class ProducerExample {

	public static void main(String[] args) {
		ActiveMQConnectionFactory amqf = null;
		try {
			InitialContext icontext = new InitialContext();
			Queue queue = (Queue) icontext.lookup("queue/requestQueue");
			Queue replyqueue = (Queue) icontext.lookup("queue/replyQueue");
			amqf = new ActiveMQConnectionFactory();
			JMSContext jmscontext = amqf.createContext();
			JMSProducer producer = jmscontext.createProducer();
			//Message message = jmscontext.createTextMessage("Hello from Jmscontext create text message");
			ObjectMessage objMessage = jmscontext.createObjectMessage();		
			Student s = new Student();
			s.setAge(28);
			s.setName("vishnu");
			objMessage.setObject(s);
			objMessage.setJMSReplyTo(replyqueue);
			producer.send(queue, objMessage);
		} catch (Exception e) {
		} finally {

		}
	}

}
