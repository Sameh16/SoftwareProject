
public class MCQQuestion {

	private String Question_;
	private String answer_1;
	private String answer_2;
	private String answer_3;
	private String answer_4;
	private String correcranswer_;
	private int level;

	public MCQQuestion() {
		super();
	}

	public MCQQuestion(String question_, String answer_1, String answer_2, String answer_3, String answer_4,
			String correcranswer_, int level) {
		super();
		Question_ = question_;
		this.answer_1 = answer_1;
		this.answer_2 = answer_2;
		this.answer_3 = answer_3;
		this.answer_4 = answer_4;
		this.correcranswer_ = correcranswer_;
		this.level = level;
	}

	public String getQuestion_() {
		return Question_;
	}

	public void setQuestion_(String question_) {
		Question_ = question_;
	}

	public String getAnswer_1() {
		return answer_1;
	}

	public void setAnswer_1(String answer_1) {
		this.answer_1 = answer_1;
	}

	public String getAnswer_2() {
		return answer_2;
	}

	public void setAnswer_2(String answer_2) {
		this.answer_2 = answer_2;
	}

	public String getAnswer_3() {
		return answer_3;
	}

	public void setAnswer_3(String answer_3) {
		this.answer_3 = answer_3;
	}

	public String getAnswer_4() {
		return answer_4;
	}

	public void setAnswer_4(String answer_4) {
		this.answer_4 = answer_4;
	}

	public String getCorrecranswer_() {
		return correcranswer_;
	}

	public void setCorrecranswer_(String correcranswer_) {
		this.correcranswer_ = correcranswer_;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
