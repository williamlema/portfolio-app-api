package com.portfolio.app.api.exception;

/**
* Exception to control Twitter expections when try to retrieve timeline
* 
* @author <a href="weleonm@gmail.com">William Leon</a>
* @version 1.0
* @since 1.0
*/
public class TimelineException extends RuntimeException {

	private static final long serialVersionUID = 3652235733403506866L;
	
	private String message;

    public TimelineException(String message){
        super(message);
        this.message = message;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
