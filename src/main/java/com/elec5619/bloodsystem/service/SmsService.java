package com.elec5619.bloodsystem.service;



/**
 * The interface Sms service.
 */
// Interface
public interface SmsService {

  /**
   * Send sms message based on bloodRequester message in urgent case.
   *
   * @param message     the SMS text
   * @param phoneNumber the blood donator number
   * @return void
   */
// Method
  // To send sms message

  void sendSMS(String message, String phoneNumber);
}
