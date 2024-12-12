package com.ratolla.PicPaySimplified.clients;

import com.ratolla.PicPaySimplified.entities.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "NotificationClient",
        url = "${notification.client.url}"
)
public interface NotificationClient {
    @PostMapping
    public ResponseEntity<Void> sendNotification(Transfer transfer);
}
