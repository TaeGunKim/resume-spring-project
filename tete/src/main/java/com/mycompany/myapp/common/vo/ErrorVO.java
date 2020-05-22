package com.mycompany.myapp.common.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorVO implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = -3554869409429547011L;

	@XmlElement(name = "code")
	private String code;

	@XmlElement(name = "message")
    private String message;


    public ErrorVO() {
        super();
    }

    public ErrorVO(String code, String message) {
        this.code = code;
        this.message = message;
    }

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
