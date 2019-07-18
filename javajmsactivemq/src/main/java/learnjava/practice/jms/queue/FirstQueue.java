package learnjava.practice.jms.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class FirstQueue {

	public static void main(String[] args) {
		InitialContext context = null;
		ConnectionFactory cf = null;
		Connection conn = null;
		try {
			context = new InitialContext();
			Queue queue = (Queue) context.lookup("queue/myQueue");
			// this is to establish a connection to apache activeMQ artemis server
			cf = (ConnectionFactory) context.lookup("ConnectionFactory");
			conn = cf.createConnection();
			Session sess = conn.createSession();
			MessageProducer msgProducer = sess.createProducer(queue);
			Message message = sess.createTextMessage("Message from FirstQueue....Hello");
			msgProducer.send(message);
			MessageConsumer consumer = sess.createConsumer(queue);
			conn.start();
			TextMessage receivedMessage = (TextMessage) consumer.receive();
			System.out.println("consumer:: " + receivedMessage.getText());
		} catch (NamingException e) {
		} catch (JMSException e) {
		} finally {
			try {
				conn.close();
				context.close();
			} catch (JMSException e) {
				e.printStackTrace();
			} catch (NamingException e) {
				e.printStackTrace();
			}

		}
	}

}
