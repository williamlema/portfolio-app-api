package com.portfolio.app.api.model.dto;

import java.time.LocalDateTime;

/**
* DTO to expose generic error message content
*
* @author <a href="weleonm@gmail.com">William Leon</a>
* @version 1.0
* @since 1.0
*/

public class ErrorMessage {

    private String message;

    private LocalDateTime time;

    public ErrorMessage(String message) {
        this.message = message;
        this.time = LocalDateTime.now();
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

}
