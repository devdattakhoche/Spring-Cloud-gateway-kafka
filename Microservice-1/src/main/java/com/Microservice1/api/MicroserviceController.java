package com.Microservice1.api;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservice1.api.model.User;

@RestController
@Service
@RequestMapping("/Microservice-1")
public class MicroserviceController {

		@GetMapping("/Service-1")
		public String FirstService() throws InterruptedException
		{
//			Thread.sleep(100000);
			return "Microservice - V3";
		}
		   @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
		    public void consume(String message) {
		        System.out.println("Consumed message: " + message);
		    }


		    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
		            containerFactory = "userKafkaListenerFactory")
		    public void consumeJson(User user) {
		        System.out.println("Consumed JSON Message: " + user);
		    }
	}


