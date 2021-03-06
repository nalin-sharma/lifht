package com.lti.lifht.model;

import static com.lti.lifht.util.CommonUtil.parseMDY;
import static com.lti.lifht.util.CommonUtil.parseTime;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import com.lti.lifht.entity.EntryPair;
import com.lti.lifht.util.CommonUtil;

public class EntryPairBean {

	private LocalDate swipeDate;
	private LocalTime swipeIn;
	private LocalTime swipeOut;
	private String swipeDoor;
	private Duration duration;
	private EmployeeBean employee;
	private String psNumber;

	public EntryPairBean() {
		super();
	}

	public EntryPairBean(EntryPair entity) {
		super();
		psNumber = entity.getPsNumber();
		swipeDate = entity.getSwipeDate();
		swipeIn = entity.getSwipeIn();
		swipeOut = entity.getSwipeOut();
		swipeDoor = entity.getSwipeDoor();
		duration = Duration.ofMillis(entity.getDuration());
	}

	public EntryPairBean(EntryRaw entry) {
		super();
		employee = new EmployeeBean(entry.getPsNumber());
		psNumber = entry.getPsNumber();
		swipeDate = entry.getSwipeDate();
		swipeDoor = entry.getSwipeDoor();
	}

	public EntryPairBean(LocalDate swipeDate, LocalTime swipeIn, LocalTime swipeOut, String swipeDoor,
			Duration duration, EmployeeBean employee) {
		super();
		this.swipeDate = swipeDate;
		this.swipeIn = swipeIn;
		this.swipeOut = swipeOut;
		this.swipeDoor = swipeDoor;
		this.duration = duration;
		this.employee = employee;
	}

	public EntryPairBean(Date swipeDate, Time swipeIn, Time swipeOut, String swipeDoor, String duration,
			String psNumber) {
		super();
		this.swipeDate = swipeDate.toLocalDate();
		this.swipeIn = swipeIn.toLocalTime();
		this.swipeOut = swipeOut.toLocalTime();
		this.swipeDoor = swipeDoor;
		this.duration = Duration.parse(duration);
		this.psNumber = psNumber;
	}

	public EntryPairBean(Date date, Time swipeIn, Time swipeOut, String duration, String door, String psNumber,
			EmployeeBean employee) {
		this.swipeDate = date.toLocalDate();
		this.swipeIn = swipeIn.toLocalTime();
		this.swipeOut = swipeOut.toLocalTime();
		this.duration = Duration.parse(duration);
		this.swipeDoor = door;
		this.psNumber = psNumber;
		this.employee = employee;
	}

	public EntryPairBean(Object[] rawResult) {
		employee = new EmployeeBean(
				String.valueOf(rawResult[0]),
				String.valueOf(rawResult[1]),
				String.valueOf(rawResult[2]),
				String.valueOf(rawResult[3]),
				String.valueOf(rawResult[4]),
				String.valueOf(rawResult[10]));

		psNumber = String.valueOf(rawResult[0]);
		swipeDate = LocalDate.parse(String.valueOf(rawResult[5]));
		duration = Duration.ofMillis(Long.valueOf(String.valueOf(rawResult[6])));
		swipeDoor = String.valueOf(rawResult[7]);
		swipeIn = LocalTime.parse(String.valueOf(rawResult[8]));
		swipeOut = LocalTime.parse(String.valueOf(rawResult[9]));
	}

	public LocalDate getSwipeDate() {
		return swipeDate;
	}

	public void setSwipeDate(LocalDate swipeDate) {
		this.swipeDate = swipeDate;
	}

	public void setSwipeDate(String dateString) {
		swipeDate = parseMDY.apply(dateString);
	}

	public LocalTime getSwipeIn() {
		return swipeIn;
	}

	public void setSwipeIn(LocalTime swipeIn) {
		this.swipeIn = swipeIn;
	}

	public void setSwipeIn(String inTimeString) {
		swipeIn = parseTime.apply(inTimeString);
	}

	public LocalTime getSwipeOut() {
		return swipeOut;
	}

	public void setSwipeOut(LocalTime swipeOut) {
		this.swipeOut = swipeOut;
	}

	public void setSwipeOut(String outTimeString) {
		swipeOut = parseTime.apply(outTimeString);
	}

	public String getSwipeDoor() {
		return swipeDoor;
	}

	public void setSwipeDoor(String swipeDoor) {
		this.swipeDoor = swipeDoor;
	}

	public Duration getDuration() {
		if (duration != null) {
			return duration;
		}
        return null != swipeIn && null != swipeOut ? Duration.between(swipeIn, swipeOut) : Duration.ofMillis(0);
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public EmployeeBean getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}

	public String getPsNumber() {
		return psNumber;
	}

	public void setPsNumber(String psNumber) {
		this.psNumber = psNumber;
	}

	public String getDurationString() {
		return CommonUtil.formatDuration(duration);
	}

}
