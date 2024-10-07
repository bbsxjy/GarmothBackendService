package com.gbs.core.service;

public interface SmsService {
    void sendSms(String phoneNumber, String code);
}
