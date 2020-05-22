package com.mycompany.myapp.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ConvertUtil {

	//정뱡향 최신글순서대로 하는거
	public  static String getSortTree(String parentSortTree, int indexNo) {
		return getSortTree(parentSortTree, indexNo, false);
	}
	//역방향
	public  static String getSortTreeASC(String parentSortTree, int indexNo) {
		return getSortTree(parentSortTree, indexNo, false);
	}
	/**
	 * Integet.MAX_VALUE 까지는 커버됨 2147483147 => ZIK0ZJ
	 * @param parentSortTree
	 * @param indexNo
	 * @return
	 */
	public  static String getSortTree(String parentSortTree, int indexNo, boolean isASC) {
		char END_POINT_CHAR = '~';
		int digits = 36;

		String sortTree = "";
		int covertNo = 0;
		int mod = 0;

		if(isASC){//최신글순서대로 할경우에
			indexNo = Integer.MAX_VALUE - indexNo;
		}

		//digits 변환
		do {
			covertNo = indexNo / digits;
			mod = indexNo % digits;
			if (mod < 10){//0-9
				sortTree = mod + sortTree;
			}else if (mod < digits) {//A-Z
				sortTree = (char) (mod + 55) + sortTree;
			}
			indexNo = covertNo;
		} while (covertNo != 0);

		while (sortTree.length() < 5){
			sortTree = new StringBuilder().append("0").append(sortTree).toString();
		}

		//int level=1;
		if(parentSortTree != null && parentSortTree.length() >= 5){
			//level++;
			//level += (parentSortTree.length()-6) / 5;

			parentSortTree = parentSortTree.substring(0, parentSortTree.lastIndexOf(END_POINT_CHAR));
		} else {
			if(parentSortTree == null) parentSortTree = "";
		}

		return new StringBuilder().append(parentSortTree).append(sortTree).append(END_POINT_CHAR).toString();
	}

	/**
	 * indexNo는 20자리이상의 번호로 구성한다.
	 * 값변환은 넘어온 값의 앞 10자리와 나머자 자리로 구분하여 변환
	 * 리턴값중 앞자리 6자리는 랜덤하게 값을 받음.
	 * @param indexNo
	 * @return
	 */
	public static String getCouponNumber(String indexNo) {

		final char[] possibleCharacters =
			{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'B', 'C', 'D', 'E', 'F',
					'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
					'V', 'W', 'X', 'Y', 'Z'};
		final int possibleCharacterCount = possibleCharacters.length;

		long indexNo1 = Long.parseLong(indexNo.substring(0, 10));
		long indexNo2 = Long.parseLong(indexNo.substring(10, indexNo.length()));



		Random rnd = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i= 2; i > 0; i--) {
			sb.append(possibleCharacters[rnd.nextInt(possibleCharacterCount)]);
		}

		return new StringBuilder().append(sb)
				.append(getCouponNumber(indexNo1 + indexNo2)).toString().substring(0,6);
	}

	/**
	 * Long.MAX_VALUE 까지는 커버됨 9223372036854775807L
	 * @param parentSortTree
	 * @param indexNo
	 * @return
	 */
	public static String getCouponNumber(long indexNo) {
		long digits = 36;

		String sortTree = "";
		long covertNo = 0;
		long mod = 0;

		//digits 변환
		do {
			covertNo = indexNo / digits;
			mod = indexNo % digits;
			if (mod < 10){//0-9
				sortTree = mod + sortTree;
			}else if (mod < digits) {//A-Z
				sortTree = (char) (mod + 55) + sortTree;
			}
			indexNo = covertNo;
		} while (covertNo != 0);

		while (sortTree.length() < 5){
			sortTree = new StringBuilder().append("0").append(sortTree).toString();
		}

		return new StringBuilder().append(sortTree).toString();
	}

	/**
	 * 날짜 이용하여 ORD_ID 생성
	 * 20자리 생성
	 * @return dateString
	 */
	public static String getOrdIdString() throws Exception {
		SimpleDateFormat formatter =
				new SimpleDateFormat ("yyyyMMddHHmmssSSSSSS", Locale.KOREA);
		String ordIdString = formatter.format(new Date());
		return ordIdString;
	}

	/**
	 * 보드타입
	 * @param str
	 * @return
	 */
	public static String getBoardTypePath(String str){
		String boardTypePath = StringUtils.defaultIfEmpty(str, "");


		if(!StringUtils.isEmpty(boardTypePath)){
			boardTypePath=boardTypePath+"/";
		}

		return boardTypePath;


	}

	/**
	 * HTML IMG TAG에서 이미지 URL 가져오기
	 * @param str
	 * @return
	 */
	public static List<String> getImgSrc(String str) {
		return getStringRex(str, "<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>", 1);
	}

	/**
	 * HTML IMG TAG에서 이미지 style 가져오기
	 * @param str
	 * @return
	 */
	public static List<String> getImgStyle(String str) {
		return getStringRex(str, "<img[^>]*style=[\"']?([^>\"']+)[\"']?[^>]*>", 1);
	}

	/**
	 * rex 정규식을 str 문자열에서 찾기.
	 * @param rex
	 * @param str
	 * @return
	 */
	public static String getStringRex(String str, String rex){

		List<String> result = getStringRex(str, rex, 0);

		if (result.size()==0) {
			return str;
		} else {
			return result.get(0);
		}
	}

	public static List<String> getStringRex(String str, String rex, int Index){
		Pattern nonValidPattern = Pattern.compile(rex);

		List<String> result = new ArrayList<String>();
		Matcher mat = nonValidPattern.matcher(str);
		while (mat.find()) {
			result.add(mat.group(Index));
		}
		return result;
	}

	/**
	 * HTML의 IMG TAG중 STYLE에 들어 있는 width 값과 height값을 넘어온 변수 값으로 변경한다.
	 * 넘어온 값이 0이면 style에서 제거한다.
	 * @param str
	 * @param width
	 * @param height
	 * @return
	 */
	public static String getImageTagChange(String str, int width, int height) {

		List<String> img = getImgStyle(str);

		if (img==null) return str;

		for (int i=0; i < img.size(); i++) {

			String hh = getStringRex(img.get(i), "height:*[0-9]*([a-z]*;|[a-z]*)");
			String ww = getStringRex(img.get(i), "width:*[0-9]*([a-z]*;|[a-z]*)");

			Integer imgHeight = Integer.valueOf(getStringRex(hh, "[0-9]*[0-9]"));
			Integer imgWidth = Integer.valueOf(getStringRex(ww, "[0-9]*[0-9]"));

			if (imgWidth > width && width > 0){
				str = str.replace(ww, ww.replace(String.valueOf(imgWidth), String.valueOf(width)));
			} else if (imgHeight > height && width == 0){
				str = str.replace(ww, "");
			}

			if (imgHeight > height && height > 0){
				str = str.replace(hh, hh.replace(String.valueOf(imgHeight), String.valueOf(height)));
			} else if (imgWidth > width && height == 0){
				str = str.replace(hh, "");
			}

		}

		return str;
	}


	/**
	 * String 값을 int로 변환
	 * @param str
	 * @return
	 */
	public static Integer getStrToInt(String str){
		Integer resultInt=0;
		try {
			resultInt=Integer.parseInt(StringUtils.defaultString(str, "0"));
		}catch(Exception e){
			//TODO  : Exception Log 정리
		}
		return resultInt;

	}

	/**
	 * 날짜 이용하여 ORD_ID 생성
	 * 20자리 생성
	 * @return dateString
	 */
	public static String getDownloadDate()  {
		SimpleDateFormat formatter =
				new SimpleDateFormat ("yyyyMMddHHmmss", Locale.KOREA);
		String downloadDatetring = formatter.format(new Date());
		return downloadDatetring;
	}


    /**
     * IP
     *
     * @param request
     * @return
     */
    public static String getRequestIp( ) {

    	ServletRequestAttributes  attributes =  (ServletRequestAttributes )RequestContextHolder.getRequestAttributes();

    	HttpServletRequest request =  attributes.getRequest();


        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }


}
