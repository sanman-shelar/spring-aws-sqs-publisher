package com.aws.sqs.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonPublisher {

    private final static String QUEUE = "aws.person.info.queue";
    private final static String TOPIC = "person-info-topic";

    @Autowired
    QueueMessagingTemplate messagingTemplate;

    @Autowired
    NotificationMessagingTemplate topicMessagingTemplate;

    @PostMapping(("/sqs/person"))
    public void publishMessageToSQS(@RequestBody Person person) {
        messagingTemplate.convertAndSend(QUEUE, person);
    }

    @PostMapping(("/sns/person"))
    public void publishMessageToSNS(@RequestBody Person person) {
        topicMessagingTemplate.convertAndSend(TOPIC, person);
    }
}
