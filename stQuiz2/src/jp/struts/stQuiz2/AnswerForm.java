package jp.struts.stQuiz2;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class AnswerForm extends ValidatorForm {

	private static final long serialVersioUID = 1L;
	// フィールド
	private String answer = null;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public AnswerForm() {
		super();
	}

	// 日本語対応
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
