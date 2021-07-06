package com.microservices.demo.twitter.to.kafka.service;

import com.microservices.demo.config.TwitterToKafkaServiceConfigData;
import com.microservices.demo.twitter.to.kafka.service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import twitter4j.TwitterException;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan("com.microservices.demo") //This helps to find Spring Beans in other modules that have package names starting
//like this.
public class TwitterToKafkaServiceApplication {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);

    private final TwitterToKafkaServiceConfigData twitterToKafkaServiceConfigData;

    private final StreamRunner streamRunner;

    public TwitterToKafkaServiceApplication(TwitterToKafkaServiceConfigData configData, StreamRunner streamRunner) {
        this.twitterToKafkaServiceConfigData = configData;
        this.streamRunner = streamRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
    }

    @PostConstruct
    public void init() throws TwitterException {
        LOG.info("App Started...");
        LOG.info(twitterToKafkaServiceConfigData.getWelcomeMessage());
        LOG.info(twitterToKafkaServiceConfigData.getTwitterKeywords().toString());
        streamRunner.start();
    }

}
