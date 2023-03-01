package mysql;
import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMultipart;

public class sendMail {
	

	public static void main(String[] args) throws MessagingException, IOException {
	      Properties props = new Properties();
	      props.setProperty("mail.store.protocol", "imaps");
	      Session session = Session.getDefaultInstance(props, null);
	      Store store = session.getStore("imaps");
	      store.connect("imap.gmail.com", "huynhquangvku22ns@gmail.com", "blflnuaqkgovmphc");
	      Folder inbox = store.getFolder("INBOX");
	      inbox.open(Folder.READ_ONLY);
	      
	      int messageCount = inbox.getMessageCount();
	      Message[] messages = inbox.getMessages(messageCount, messageCount);
	      // Lọc nội dung email chứa dòng "quangdeptrai"
	      String[] keywords = {"NGUYEN HUYNH QUANG chuyen khoan", "HUYNH DUC HIEU", "Chuyển tiền nhanh ngoài MB"};
	      for (Message message : messages) {
	    	  
	    		    // kiểm tra xem email có chứa từ "quang dep trai" hay không
	    		    String contentType = message.getContentType();
	    		    if (contentType.contains("multipart")) {
	    		        Multipart multiPart = (Multipart) message.getContent();
	    		        for (int i = 0; i < multiPart.getCount(); i++) {
	    		            BodyPart bodyPart = multiPart.getBodyPart(i);
	    		            String body = bodyPart.getContent().toString();
	    		            boolean containsAllKeywords = true;
	    		            for (String keyword : keywords) {
	    		                if (!body.contains(keyword)) {
	    		                    containsAllKeywords = false;
	    		                    break;
	    		                }
	    		            }
	    		            if (containsAllKeywords) {
	    		                System.out.println("Found email containing all keywords:  " + message.getSubject());
	    		                break;
	    		            }
	    		        }
	    		    } else {
	    		        String body = message.getContent().toString();
	    		        boolean containsAllKeywords = true;
	    		        for (String keyword : keywords) {
	    		            if (!body.contains(keyword)) {
	    		                containsAllKeywords = false;
	    		                break;
	    		            }
	    		        }
	    		        if (containsAllKeywords) {
	    		            System.out.println("Found email containing all keywords: " + message.getSubject());
	    		        }
	    		    }

	    		    }
	    		}
	   }
	
	






