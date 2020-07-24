package com.app;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import java.net.URI;

public class VoiceMain {
    public static final String ACCOUNT_SID = "qqq";
    public static final String AUTH_TOKEN = "ttt";

    public static void main(String[] args) throws InterruptedException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Call call = Call.creator(
                new com.twilio.type.PhoneNumber("+380507619505"),
                new com.twilio.type.PhoneNumber("+12057758584"),
                URI.create("http://demo.twilio.com/docs/voice.xml"))
                .create();
        System.out.println(call.getSid());
        Thread.sleep(60000);
    }
}