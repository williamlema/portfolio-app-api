package com.portfolio.app.api.exception;

/**
* Exception to control not founds portfolios
* 
* @author <a href="weleonm@gmail.com">William Leon</a>
* @version 1.0
* @since 1.0
*/
public class NotFoundPortfolioException extends RuntimeException {

    private static final long serialVersionUID = -7050334577722746136L;

    private String message;

    public NotFoundPortfolioException(String message){
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
