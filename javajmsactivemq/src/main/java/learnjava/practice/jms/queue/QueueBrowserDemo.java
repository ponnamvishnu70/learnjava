package learnjava.practice.jms.queue;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class QueueBrowserDemo {

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
			TextMessage message1 = sess.createTextMessage("Message1 from FirstQueue....Hello");
			TextMessage message2 = sess.createTextMessage("Message2 from FirstQueue....Hello");
			msgProducer.setPriority(3);
			msgProducer.send(message1);
			msgProducer.setPriority(9);
			msgProducer.send(message2);
			QueueBrowser browser = sess.createBrowser(queue);
			Enumeration msgenum = browser.getEnumeration();
			while(msgenum.hasMoreElements()) {
				TextMessage msg = (TextMessage) msgenum.nextElement();
				System.out.println("browsing queue"+msg.getText());
			}
			MessageConsumer consumer = sess.createConsumer(queue);
			conn.start();
			TextMessage receivedMessage = (TextMessage) consumer.receive();
			System.out.println("consumer:: " + receivedMessage.getText());
			 receivedMessage = (TextMessage) consumer.receive();
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
