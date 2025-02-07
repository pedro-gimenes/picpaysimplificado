package com.picpaysimplificado.picpaysimplificado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.picpaysimplificado.picpaysimplificado.domain.User;
import com.picpaysimplificado.picpaysimplificado.dto.NotificationDto;

@Service
public class NotificationService {
    
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDto notificationRequest = new NotificationDto(email, message);

        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://04d9z.mocklab.io/notify", notificationRequest, String.class);
    
        if(!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
            System.out.println("Erro ao enviar notificação");
            throw new Exception("Serviço de notificação está fora do ar");
        }
    }
}
