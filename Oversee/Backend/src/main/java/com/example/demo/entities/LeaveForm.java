package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "LeaveForm")
public class LeaveForm {
	 @Id // Marks this field as the primary key
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key value
	    private Long id;
	 
	    @Column(nullable = false) // Maps this field to a database column, and makes it non-nullable
	    private String startDate;
	    
	    @Column(nullable = false) // Maps this field to a database column, and makes it non-nullable
	    private String endDate;

	    @Column(nullable = false) // Maps this field to a database column, and makes it non-nullable
	    private String reason;
	    
	    
}
