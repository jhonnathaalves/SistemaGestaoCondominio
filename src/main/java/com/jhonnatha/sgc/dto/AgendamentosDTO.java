package com.jhonnatha.sgc.dto;

import java.io.Serializable;
import java.util.Date;

import com.jhonnatha.sgc.domain.Agendamentos;

public class AgendamentosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private Boolean allDay;
	private Date start;
	private Date end;
	private String colorEvento;
	private String color;
		

	public AgendamentosDTO() {
		super();
	}

	public AgendamentosDTO(Agendamentos obj) {
		super();
		this.id = obj.getId();
		this.title = obj.getTitle();
		this.allDay = obj.getAllDay();
		this.start = obj.getStart();
		this.end = obj.getEnd();
		this.colorEvento = obj.getColorEvento();
		this.color = obj.getColor();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getAllDay() {
		return allDay;
	}

	public void setAllDay(Boolean allDay) {
		this.allDay = allDay;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEndDate(Date end) {
		this.end = end;
	}

	public String getColorEvento() {
		return colorEvento;
	}

	public void setColorEvento(String colorEvento) {
		this.colorEvento = colorEvento;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
	


}
