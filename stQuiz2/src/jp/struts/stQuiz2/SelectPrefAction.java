package jp.struts.stQuiz2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SelectPrefAction extends Action {
	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/* セッションオブジェクトの生成 */
		HttpSession session = request.getSession();

		Select se = new Select();// PrefBean オブジェクトの生成
		se.distinct();

		session.setAttribute("allSelect", se); // セッションにPrefBean オブジェクトをセット

		/* map.findForward メソッドに success を設定 */
		return map.findForward("success");
	}
}
