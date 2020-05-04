package com.portfolio.app.api.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity class to retrieve portfolio information from database
 *
 * @author <a href="weleonm@gmail.com">William Leon</a>
 * @version 1.0
 * @since 1.0
 */

@Entity
@Table(name = "portfolio")
public class Portfolio implements Serializable {

    private static final long serialVersionUID = 2035441530790722402L;

    
    public Portfolio() {
		super();
	}

	public Portfolio(Long id, String description, String imageUrl, @NotNull String twitterUserName, String title) {
		super();
		this.id = id;
		this.description = description;
		this.imageUrl = imageUrl;
		this.twitterUserName = twitterUserName;
		this.title = title;
	}
	
	public Portfolio(String description, String imageUrl, @NotNull String twitterUserName, String title) {
		super();
		this.description = description;
		this.imageUrl = imageUrl;
		this.twitterUserName = twitterUserName;
		this.title = title;
	}

	@Id
    @Column(name = "idportfolio")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @NotNull
    @Column(name = "twitter_user_name")
    private String twitterUserName;

    @Column(name = "title")
    private String title;

	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTwitterUserName() {
		return twitterUserName;
	}

	public void setTwitterUserName(String twitterUserName) {
		this.twitterUserName = twitterUserName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

    
}
