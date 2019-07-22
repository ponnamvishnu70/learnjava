package learnjava.practice.jms.listener;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import learnjava.practice.jms.model.Student;

public class StudentMessageListener implements MessageListener {

	public void onMessage(Message message) {
		ObjectMessage om =(ObjectMessage) message;
		try {
			Student student = (Student) om.getObject();
			System.out.println(student.getName());			
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
