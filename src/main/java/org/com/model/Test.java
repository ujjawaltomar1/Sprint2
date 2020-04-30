package org.com.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.com.services.QuestionsServices;


@Entity
//@Table(name="Test")
public class Test {
	
	@NotNull(message="id is blank")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name=testId)
	private Integer testId ;
	
	@NotEmpty(message="test title is blank")
	private String testTitle ;
	
	//@Column(name="TestDuration",nullable=false)
	private LocalTime testDuration ;
	
	//@NotNull(message = "TestTotalMarks is blank")
	private BigDecimal testTotalMarks ;
	
	private BigDecimal testMarksScored ;
	private Questions currentQuestion ;
	private LocalDateTime startTime ;
	private LocalDateTime endTime ;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="Test")
	@JoinColumn(name="T_id")
	java.util.List<Questions> testQuestions;

	//private QuestionsServices questionsService;
	public Test(Integer testId, String testTitle, LocalTime testDuration, BigDecimal testTotalMarks,
			BigDecimal testMarksScored, Questions currentQuestion, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testTotalMarks = testTotalMarks;
		QuestionsServices questionsService = null;
		this.testQuestions =questionsService.findAllQuestions();
	}
	
	

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testTitle=" + testTitle + ", testDuration=" + testDuration
				+ ", testTotalMarks=" + testTotalMarks + ", testMarksScored=" + testMarksScored + ", currentQuestion="
				+ currentQuestion + ", startTime=" + startTime + ", endTime=" + endTime + ", testQuestions="
				+ testQuestions + "]";
	}



	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public LocalTime getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}

	public BigDecimal getTestTotalMarks() {
		return testTotalMarks;
	}

	public void setTestTotalMarks(BigDecimal testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}

	public BigDecimal getTestMarksScored() {
		return testMarksScored;
	}

	public void setTestMarksScored(BigDecimal testMarksScored) {
		this.testMarksScored = testMarksScored;
	}

	public Questions getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(Questions currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public List<Questions> getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(List<Questions> testQuestions) {
		this.testQuestions = testQuestions;
	}

	
}
