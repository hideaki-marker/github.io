package jp.struts.stQuiz2;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class SelectAreaForm extends ValidatorForm {

	private static final long serialVersioUID = 1L;
	// フィールド
	private String area = null;

	public SelectAreaForm() {
		super();
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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
