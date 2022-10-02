package com.elec5619.bloodsystem.service;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

public class SmsService {
  // Find your Account Sid and Token at twilio.com/console
  public static final String ACCOUNT_SID =
      System.getenv("TWILIO_API_SID") == null
          ? ""
          : System.getenv("TWILIO_API_SID");
  public static final String AUTH_TOKEN =
      System.getenv("TWILIO_API_KEY") == null
          ? ""
          : System.getenv("TWILIO_API_KEY");
  public static void sendSMS( String smstext) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(
            new com.twilio.type.PhoneNumber("+61415548977"),
            "MGf03805d894df253688c4b3b43e6b4927",
            smstext)
        .create();

    System.out.println(message.getSid());
  }
}