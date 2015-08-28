package com.columbia.net.mailer;


import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.constants.CommonConstants;


public class SendMail {

	public static void main(String[] args) {
        
        System.out.println("SimpleEmail Start");
         
        String smtpHostServer = "mail.smtp.host";
        String emailIdTO = CommonConstants.TO;
         
        Properties props = System.getProperties();
 
        props.put("mail.smtp.host", smtpHostServer);
 
        Session session = Session.getInstance(props, null);
         
        sendEmail(session, emailIdTO,"Testing", "Testing");
    }

	public static void sendEmail(Session session, String toEmail, String subject, String body){
        try
        {
          MimeMessage msg = new MimeMessage(session);
          //set message headers
          msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
          msg.addHeader("format", "flowed");
          msg.addHeader("Content-Transfer-Encoding", "8bit");
 
          msg.setFrom(new InternetAddress(CommonConstants.FROM, "NoReply-JD"));
 
          msg.setReplyTo(InternetAddress.parse(CommonConstants.TO, false));
 
          msg.setSubject(subject, "UTF-8");
 
          msg.setText(body, "UTF-8");
 
          msg.setSentDate(new Date());
 
          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
          System.out.println("Message is ready");
          Transport.send(msg);  
 
          System.out.println("EMail Sent Successfully!!");
        }
        catch (Exception e) {
          e.printStackTrace();
        }
    }

	
}
