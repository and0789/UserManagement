package com.andreseptian.usermanagement.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import static com.twilio.rest.api.v2010.account.Message.creator;


public class SmsUtils {
    public static final String FROM_NUMBER = "6285295557633";
    public static final String SID_KEY = "AC9014759e5d414efb6a08c1d51fe799d9";
    public static final String TOKEN_KEY = "6f8b96f671554d223f99c73f9521d74e";

    public static void sendSMS(String to, String messageBody) {
        Twilio.init(SID_KEY, TOKEN_KEY);
        Message message = creator(new PhoneNumber("+" + to), new PhoneNumber(FROM_NUMBER), messageBody).create();
        System.out.println(message);
    }
}
