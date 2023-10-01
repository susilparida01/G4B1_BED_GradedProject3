package com.gl.codingassignmnet.tickettrackerapplication.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private long id;

	@Column(name = "ticket_title")
	private String title;

	@Column(name = "ticket_description")
	private String description;

	@Column(name = "ticket_content", length = 512)
	private String content;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false)
	private Date createdOn;
}
