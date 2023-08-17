package br.dev.felipeschirmann.serviceSms.dto;

import java.io.Serializable;
import java.util.Objects;

public class SmsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String phoneFrom;
	private String phoneTo;
	private String msg;

	SmsDTO() {

	}

	public SmsDTO(String phoneFrom, String phoneTo, String msg) {
		this.phoneFrom = phoneFrom;
		this.phoneTo = phoneTo;
		this.msg = msg;
	}

	public String getPhoneFrom() {
		return phoneFrom;
	}

	public void setPhoneFrom(String phoneFrom) {
		this.phoneFrom = phoneFrom;
	}

	public String getPhoneTo() {
		return phoneTo;
	}

	public void setPhoneTo(String phoneTo) {
		this.phoneTo = phoneTo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public int hashCode() {
		return Objects.hash(phoneFrom, phoneTo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SmsDTO other = (SmsDTO) obj;
		return Objects.equals(phoneFrom, other.phoneFrom) && Objects.equals(phoneTo, other.phoneTo);
	};
}
