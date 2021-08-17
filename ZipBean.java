package zipSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ZipBean {

	private static int code;
	private static String pref;
	private static String city;
	private static String town;
	private static String fullAddress;
	public static void execute(String zipNum){
		HttpURLConnection connection = null;// HttpConnection�̐錾
		URL url = null;// URL�̕ϐ�
		final String urlAddress = "https://zipcloud.ibsnet.co.jp/api/search?zipcode="
				+ zipNum;// URL��zipNum����������������
		try {
			url = new URL(urlAddress);// �X�֔ԍ����q�����ϐ���URL�I�u�W�F�N�g�֑��
			try {
				connection = (HttpURLConnection) url.openConnection();// �ڑ��pHttpURLConnection�I�u�W�F�N�g�̍쐬
				connection.setRequestMethod("GET");// �T�[�o�[�ƌq������GET�������ɂ���
				connection.setInstanceFollowRedirects(false);// ���_�C���N�g�͂��Ȃ��̂�false
				connection.setRequestProperty("Accept-Language", "jp");// �w�b�_�[�̐ݒ�(���{��)
				connection.connect();// ���N�G�X�g
				if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {// �����ɐڑ��o�����Ȃ�
					try (InputStreamReader isr = new InputStreamReader(
							connection.getInputStream(), StandardCharsets.UTF_8);
							BufferedReader reader = new BufferedReader(isr)) {// �ǂݍ��݂̏����ƕ����R�[�h��UTF-8�ɐݒ�
						String rec;// �t�@�C���ǂݍ��ݗp�̕ϐ�
						StringBuffer line = new StringBuffer();// �t�@�C���̕��������s�ɂ܂Ƃ߂�ϐ�
						while ((rec = reader.readLine()) != null) {// �f�[�^���S�ēǂݍ��݂��I���܂�
							line.append(rec);// StringBuffer line��rec���q���Ă���
						}
						JSONObject json = new JSONObject(line.toString());// line��String�^�ɕϊ����Ajson�I�u�W�F�N�g�֑��
						ZipBean.code = json.getInt("status");// �X�e�[�^�X�R�[�h�̕ϐ�����
						if (code == 200) {// 200�ԂȂ�ʐM�ɐ���
							if (!json.isNull("results")) {// results�̃X�e�[�^�X��S���ǂݍ��ݏI����܂�
								JSONArray jar = json.getJSONArray("results");// results�̃f�[�^��JSON�z��Ɋi�[
								JSONObject data = jar.getJSONObject(0);// �P�ԏ�̏Z���̃f�[�^���I�u�W�F�N�g�֑��
								String yuubin = data.getString("zipcode");//
								ZipBean.pref = data.getString("address1");//
								ZipBean.city = data.getString("address2");//
								ZipBean.town = data.getString("address3");//
								ZipBean.fullAddress = "���@" + yuubin + "�@�Z��:"
										+ pref + city + town;
								System.out.println(fullAddress);
							} else {
								System.out.println("��" + zipNum
										+ "�ɊY������X�֔ԍ��͌�����܂���ł����B");
							}
						} else {
							String message = json.getString("message");
							System.out.println("status:" + code + "message:"
									+ message);
						}
					} catch (JSONException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();

					}
				}

			} finally {
				if (connection != null) {
					connection.disconnect();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
	
	}
