package br.unisal.api.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseMessage {
	private String status;
	private String msg;

	public ResponseMessage() {
	}

	public ResponseMessage getMessage(String status, String msg) {
		ResponseMessage r = new ResponseMessage();
		r.setStatus(status);
		r.setMsg(msg);
		return r;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return GsonSingleton.getInstance().toJson(this);
	}

}
