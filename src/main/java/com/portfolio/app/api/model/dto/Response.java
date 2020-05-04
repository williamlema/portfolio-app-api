package com.portfolio.app.api.model.dto;

/**
* Generic standar response
* 
* @author <a href="weleonm@gmail.com">William Leon</a>
* @version 1.0
* @since 1.0
*/

public class Response <T> {

    private T data;

    private ErrorMessage error;

    public Response(T data) {
        this.data = data;
        this.error = null;
    }

    public Response(ErrorMessage error) {
        this.data = null;
        this.error = error;
    }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ErrorMessage getError() {
		return error;
	}

	public void setError(ErrorMessage error) {
		this.error = error;
	}
    
}

