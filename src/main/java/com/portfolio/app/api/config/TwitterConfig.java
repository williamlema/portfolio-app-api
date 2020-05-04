package com.portfolio.app.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Bean configuration for {@link TwitterFactory} getting authentication credentials from properties
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */

@Configuration
public class TwitterConfig {

	@Value("${config.twitter.appKey}")
	private String consumerKey;
	@Value("${config.twitter.appSecretKey}")
	private String consumerSecret;
	@Value("${config.twitter.access.token}")
	private String accessToken;
	@Value("${config.twitter.access.token.secret}")
	private String accessTokenSecret;

	@Bean
	Twitter getTwitterFactory() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret)
				.setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSecret);
		return new TwitterFactory(cb.build()).getInstance();

	}
}
