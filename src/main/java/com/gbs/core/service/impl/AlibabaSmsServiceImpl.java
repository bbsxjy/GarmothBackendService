package com.gbs.core.service.impl;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teautil.models.*;
import com.aliyun.teaopenapi.models.*;
import com.aliyun.tea.TeaException;
import com.gbs.core.config.AliyunSmsConfig;
import com.gbs.core.service.SmsService;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Service
public class AlibabaSmsServiceImpl implements SmsService {

    @Value("${aliyun.sms.signName}")
    private String signName;

    @Value("${aliyun.sms.templateCode}")
    private String templateCode;

    @Autowired
    private AliyunSmsConfig aliyunSmsProperties;


    private Client createClient() throws Exception {
        Config config = new Config()
                .setAccessKeyId(aliyunSmsProperties.getAccessKeyId())
                .setAccessKeySecret(aliyunSmsProperties.getAccessKeySecret());
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new Client(config);
    }

    @Override
    public void sendSms(String phoneNumber, String code) {
        try {
            Client client = createClient();

            Map<String, String> templateParam = new HashMap<>();
            templateParam.put("code", code); // 假设您的模板中有 ${code} 参数

            SendSmsRequest sendSmsRequest = new SendSmsRequest()
                    .setPhoneNumbers(phoneNumber)
                    .setSignName(signName)
                    .setTemplateCode(templateCode)
                    .setTemplateParam(com.alibaba.fastjson.JSON.toJSONString(templateParam));

            RuntimeOptions runtime = new RuntimeOptions();

            // 调用发送短信的接口
            SendSmsResponse response = client.sendSmsWithOptions(sendSmsRequest, runtime);

            // 处理响应
            String responseCode = response.getBody().getCode();
            String responseMessage = response.getBody().getMessage();

            if ("OK".equals(responseCode)) {
                log.info("短信发送成功，手机号：{}", phoneNumber);
            } else {
                log.error("短信发送失败，错误码：{}，错误信息：{}", responseCode, responseMessage);
                throw new RuntimeException("短信发送失败：" + responseMessage);
            }

        } catch (TeaException error) {
            log.error("TeaException 错误信息：{}", error.getMessage(), error);
            throw new RuntimeException("短信发送失败：" + error.getMessage());
        } catch (Exception error) {
            log.error("Exception 错误信息：{}", error.getMessage(), error);
            throw new RuntimeException("短信发送失败：" + error.getMessage());
        }
    }
}
