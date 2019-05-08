package com.example.terminalServer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Terminal {

	private int terminalId;
	private int sequenceNo;
	private Date timestamp;
	private boolean isLocked;
	private String error;

	public Terminal() {
		super();
	}

	public Terminal(int terminalId, int sequenceNo, Date timestamp, boolean isLocked) {
		super();
		this.terminalId = terminalId;
		this.sequenceNo = sequenceNo;
		this.timestamp = timestamp;
		this.isLocked = isLocked;
	}
	
	public Terminal(String error) {
		super();
		this.error=error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(int terminalId) {
		this.terminalId = terminalId;
	}

	public int getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public List<Terminal> createTerminalPool() {

		List<Terminal> terminalPool = new ArrayList<Terminal>();
		for (int i = 0; i < 5; i++) {

			terminalPool.add(new Terminal(1001 + i, 0, new Date(), false));

		}

//		System.out.println(terminalPool.size());

		return terminalPool;

	}

	@Override
	public String toString() {
		return "Terminal [terminalId=" + terminalId + ", sequenceNo=" + sequenceNo + ", timestamp=" + timestamp
				+ ", isLocked=" + isLocked + ", error=" + error + "]";
	}

	
	
}
