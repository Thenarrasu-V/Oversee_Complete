package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Feedback")
public class FeedbackForm {
	
	 @Id // Marks this field as the primary key
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key value
	    private Long id;

	    @Column(nullable = false) // Maps this field to a database column, and makes it non-nullable
	    private String message;

		@Column(nullable = false)
		private String fromName;

	public FeedbackForm(Long id, String message, String fromName) {
		this.id = id;
		this.message = message;
		this.fromName = fromName;
	}

	public FeedbackForm() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
}
