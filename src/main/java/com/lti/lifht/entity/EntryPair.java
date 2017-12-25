package com.lti.lifht.entity;

import static javax.persistence.GenerationType.AUTO;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entry_pair")
public class EntryPair {

	// "id"
	// "ps_number"
	// "swipe_date"
	// "swipe_in"
	// "swipe_out"
	// "swipe_door"
	// "duration"
	// "employee"

	@Id
	@GeneratedValue(strategy = AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "ps_number")
	private String psNumber;

	@Column(name = "swipe_date")
	private LocalDate swipeDate;

	@Column(name = "swipe_in")
	private LocalTime swipeIn;

	@Column(name = "swipe_out")
	private LocalTime swipeOut;

	@Column(name = "swipe_door")
	private String swipeDoor;

	@Column(name = "duration")
	private long duration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPsNumber() {
		return psNumber;
	}

	public void setPsNumber(String psNumber) {
		this.psNumber = psNumber;
	}

	public LocalDate getSwipeDate() {
		return swipeDate;
	}

	public void setSwipeDate(LocalDate swipeDate) {
		this.swipeDate = swipeDate;
	}

	public LocalTime getSwipeIn() {
		return swipeIn;
	}

	public void setSwipeIn(LocalTime swipeIn) {
		this.swipeIn = swipeIn;
	}

	public LocalTime getSwipeOut() {
		return swipeOut;
	}

	public void setSwipeOut(LocalTime swipeOut) {
		this.swipeOut = swipeOut;
	}

	public String getSwipeDoor() {
		return swipeDoor;
	}

	public void setSwipeDoor(String swipeDoor) {
		this.swipeDoor = swipeDoor;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

}