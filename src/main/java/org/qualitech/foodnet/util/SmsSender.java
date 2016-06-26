package org.qualitech.foodnet.util;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aram Kirakosyan.
 */
public class SmsSender {

    // Find your Account Sid and Token at twilio.com/user/account
//    public static final String ACCOUNT_SID = "AC734554c9ab34c9830d5e58750a1121c7";
//    public static final String AUTH_TOKEN = "3617c6be279f7a901c7183a2514b1253";

    public static final String ACCOUNT_SID = "AC734554c9ab34c9830d5e58750a1121c7";
    public static final String AUTH_TOKEN = "3617c6be279f7a901c7183a2514b1253";


    public static void send(String phone, String text) {

        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        // Build a filter for the MessageList
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Body", text));
        boolean to = params.add(new BasicNameValuePair("To", "+" + phone));
        params.add(new BasicNameValuePair("From", "+17075496112"));

        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message = null;
        try {
            message = messageFactory.create(params);
        } catch (TwilioRestException e) {
            e.printStackTrace();
        }
        System.out.println(message.getSid());
    }
}
