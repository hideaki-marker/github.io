package jp.struts.stQuiz2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AnswerAction extends Action {
	public ActionForward execute(ActionMapping map, ActionForm frm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//Sessionオブジェクトの作成
		HttpSession session = request.getSession(false);
		/* Form オブジェクトを受け取る */
		AnswerForm answerForm = (AnswerForm) frm;
		/* 入力された住所の一部を取得 */
		String answer = answerForm.getAnswer();
		System.out.println(answer);

		/* Bean の処理
		 * session情報からQuizBeanの生成
		 */
		QuizBean qb =  (QuizBean) session.getAttribute("choice");
		//QuizBeanオブジェクトから読みを取得
		String read = qb.getTownReading();
		//最後のjspに表示する文章の変数
		String correct = "";
		//読みが答えとあっているか判定
		if(read.equals(answer)){
			//正解なら・・・
			correct = "＜" + answer + "＞で、正解です。";
		}else{
			//不正解なら・・・
			correct = "＜" + answer + "＞で、不正解です。" + read + "と読みます。";
		}
		//リクエストオブジェクトに文章の設定
		request.setAttribute("result", correct);
		/* map.findForward メソッドに success を設定 */
		return map.findForward("success");
	}
}
