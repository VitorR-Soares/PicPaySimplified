package com.ratolla.PicPaySimplified.services;

import com.ratolla.PicPaySimplified.clients.NotificationClient;
import com.ratolla.PicPaySimplified.entities.Transfer;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationClient notificationClient;

    private final static Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void sendNotification(Transfer transfer){

        try {
            logger.info("Sending notification...");

            var response = notificationClient.sendNotification(transfer);
            if(response.getStatusCode().isError()){
                logger.info("Error while sending notification");
            }

        } catch (Exception e) {
                logger.info("Error while sending notification: " + e.getMessage());
        }


    }

}
