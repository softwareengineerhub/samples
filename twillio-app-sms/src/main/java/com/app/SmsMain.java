package com.app;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsMain {
    public static final String ACCOUNT_SID = "qqq";
    public static final String AUTH_TOKEN = "ttt";

    public static void main(String[] args) {

        //Runnable r = ()->{};

        //
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message
                .creator(new PhoneNumber("+380507619505"), // to
                        new PhoneNumber("+12057758584"), // from
                        "Test2")
                .create();

        System.out.println(message.getSid());
    }
}
