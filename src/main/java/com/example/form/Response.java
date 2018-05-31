package com.example.form;

public class Response {
	public String massage;
	public String result;
	public Nest response;

	public Nest getResponse() {
		return response;
	}

	public void setResponse(Nest response) {
		this.response = response;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}