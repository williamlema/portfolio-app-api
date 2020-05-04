package com.portfolio.app.api.model.dto;

import twitter4j.Status;

/**
* DTO to expose specific information around tweet information
* 
* @author <a href="weleonm@gmail.com">William Leon</a>
* @version 1.0
* @since 1.0
*/ 
public class TweetContent {
	
	public TweetContent (Status tweetStatus) {
		this.text = tweetStatus.getText();
		this.inReplyToScreenName = tweetStatus.getInReplyToScreenName();
		this.profileImageURL = tweetStatus.getUser().getMiniProfileImageURL();
	}
	
	private String text;
	
	private String profileImageURL;
	
	private String inReplyToScreenName;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getInReplyToScreenName() {
		return inReplyToScreenName;
	}

	public void setInReplyToScreenName(String inReplyToScreenName) {
		this.inReplyToScreenName = inReplyToScreenName;
	}

	public String getProfileImageURL() {
		return profileImageURL;
	}

	public void setProfileImageURL(String profileImageURL) {
		this.profileImageURL = profileImageURL;
	}

}
