package com.assignment.junit;

public class Mark {
	private Integer studentId;
	private Subject subject;
	private Integer score;

	public Mark(Integer studentId, Subject subject, Integer score) {
		this.studentId = studentId;
		this.subject = subject;
		this.score = score;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public Subject getSubject() {
		return subject;
	}

	public Integer getScore() {
		return score;
	}

	public String[] getCSV() {
		return new String[] { studentId.toString(), subject.toString(), score.toString() };
	}

	@Override
	public boolean equals(Object obj) {
		Mark m = (Mark) obj;
		return m.getStudentId().equals(this.studentId) && m.getScore().equals(this.score)
				&& m.getSubject().equals(this.subject);
	}

}
