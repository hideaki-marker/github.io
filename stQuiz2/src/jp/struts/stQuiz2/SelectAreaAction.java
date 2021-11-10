package jp.struts.stQuiz2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SelectAreaAction extends Action {
	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//Sessionオブジェクトの作成
		HttpSession session = request.getSession(false);
		/* Form オブジェクトを受け取る */
		SelectAreaForm sa = (SelectAreaForm)frm;
		/* 入力された住所の一部を取得 */
		String area = sa.getArea();
		//Bean の処理
		QuizBean quiz = new QuizBean();
		Select s = new Select();
		s.distinct();
		//クイズBeanに出題のエリアをセット
		quiz.setArea(area);
		quiz.execute();

		//sessionにクイズをセット
		session.setAttribute("choice", quiz);
		/* map.findForward メソッドに success を設定 */
		return map.findForward("success");
	}
}
