package learnjava.practice.jms.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FirstTopic {

	public static void main(String[] args) {

		InitialContext context = null;
		ConnectionFactory cf = null;
		try {
			context = new InitialContext();
			Topic topic = (Topic) context.lookup("topic/myTopic");
			// this is to establish a connection to apache activeMQ artemis server
			cf = (ConnectionFactory) context.lookup("ConnectionFactory");
			Connection conn = cf.createConnection();
			Session sess = conn.createSession();
			MessageProducer msgProducer = sess.createProducer(topic);
			Message message = sess.createTextMessage("Message from FirstQueue....Hello");
			// consumer of topic should be created before producer sends message
			MessageConsumer consumer = sess.createConsumer(topic);
			msgProducer.send(message);
			conn.start();
			TextMessage receivedMessage = (TextMessage) consumer.receive();
			System.out.println("consumer:: " + receivedMessage.getText());
		} catch (NamingException e) {
		} catch (JMSException e) {
		} finally {
			/*
			 * try { ((Connection) cf).close(); context.close(); } catch (JMSException e) {
			 * e.printStackTrace(); } catch (NamingException e) { e.printStackTrace(); }
			 */

		}

	}

}
