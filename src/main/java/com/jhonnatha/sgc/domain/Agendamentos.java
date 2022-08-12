package com.jhonnatha.sgc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Agendamentos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String title;
	private Boolean allDay;
	private Date start;
	private Date end;
	private String colorEvento;
	private String color;
	
	public Agendamentos() {
		super();
	}

	public Agendamentos(String id, String title, Boolean allDay, Date start, Date end, String colorEvento,
			String color) {
		super();
		this.id = id;
		this.title = title;
		this.allDay = allDay;
		this.start = start;
		this.end = end;
		this.colorEvento = colorEvento;
		this.color = color;
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

	public void setEnd(Date end) {
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


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamentos other = (Agendamentos) obj;
		return Objects.equals(id, other.id);
	}	
	

}
