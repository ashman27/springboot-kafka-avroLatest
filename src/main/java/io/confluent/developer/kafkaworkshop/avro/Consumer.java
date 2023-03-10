package io.confluent.developer.kafkaworkshop.avro;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.commerzbank.cobest.kafka.client.avro.IncompleteDocumentEvent;
import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog(topic = "Consumer Logger")
public class Consumer {

  @KafkaListener(
      topics = "#{'${topic.name}'}",
      groupId = "simple-consumer"
  )
  public void consume(IncompleteDocumentEvent record) {
    log.info(String.format("Consumed message -> %s", record));
  }
}