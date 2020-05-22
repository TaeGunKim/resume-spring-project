package com.mycompany.myapp.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class PamaStringUtils extends StringUtils {

    /**
     * 첫자리부터 지정된 자리까지만 문자열을 출력한다.
     * @param str
     * @param pos
     * @return
     */
    public static String leftsubstring(String str, int pos) {
        if (str == null) return null;
        return str.substring(0, pos);
    }

    public static int strlen(String str) {
        if (str == null) return 0;
        return str.length();
    }

    public static int arrsize(String[] arr) {
        if (arr == null) return 0;
        return arr.length;
    }

    /**
     * @param str
     * @return 문자열를 받아 null이면 공백으로 반환한다.
     */
    public static String getSpaceNVL(String str) {
        if (str == null) {
            return "";
        } else if (str.equals("null")) {
            return "";
        }

        return str;
    }

    public static String removeTag(String regex) {
        String patern = "\\<(\\/?)(\\w+)*([^<>]*)>";

        Pattern p = Pattern.compile(patern);

        Matcher m = p.matcher(regex);

        return m.replaceAll("");
    }

    public static String removeTag(String regex, String patern) {
        Pattern p = Pattern.compile(patern);

        Matcher m = p.matcher(regex);

        return m.replaceAll("");
    }

    /**
     * 태그중에서 이미지(img) 태그를 가져온다.
     * @param regex  문자열
     * @return
     * @throws Exception
     */
    public static String searchImgTag(String regex) throws Exception {
        String patern = "((src)|(SRC))=([\\s'\"])([^<>\\s]*)(['\"])";
        Pattern p = Pattern.compile(patern);
        Matcher m = p.matcher(regex);
        boolean found = m.find();
        String mStr = "";
        if (found) mStr = m.group();
        if (mStr != "") {
            mStr = mStr.replace("src","");
            mStr = mStr.replace("SRC","");
            mStr = mStr.replace("=","");
            mStr = mStr.replace("'","");
            mStr = mStr.replace("\"","");
            mStr = mStr.replace(" ", "");
        }
        return mStr;
    }

    public static List<String> searchImgTagList(String regex) throws Exception {
        List<String> imgList = new ArrayList<String>();

        String patern = "\\<img(\\w+)*([^<>]*).*\\/>";
        Pattern p = Pattern.compile(patern);
        Matcher m = p.matcher(regex);
        while(m.find()) {
            String mStr = m.group();
            imgList.add(mStr);
        }

        return imgList;
    }

    public static String searchImgUrl(String mStr) {
        if (mStr != "") {
            mStr = mStr.replace("src","");
            mStr = mStr.replace("SRC","");
            mStr = mStr.replace("=","");
            mStr = mStr.replace("'","");
            mStr = mStr.replace("\"","");
            mStr = mStr.replace(" ", "");
        }
        return mStr;
    }

    public static List<String> getImgSrc(String str) {

        Pattern nonValidPattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");


        List<String> result = new ArrayList<String>();

        Matcher matcher = nonValidPattern.matcher(str);

        while (matcher.find()) {

            result.add(matcher.group(1));

        }

        return result;

    }

    /**
     * @param input
     * @param len
     * @return
     */
    public static String right(String input, int len) {
    	if (input == null || input.isEmpty()) {
            return null;
        }
        return input.substring(input.length() - len);
    }

    /**
     * mid함수
     * @param input
     * @param index
     * @return
     */
    public static String dateadd(String date, int index) {
    	if (date == null || date.isEmpty()) {
            return null;
        }
    	SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        Calendar cal = Calendar.getInstance();
        try {
			cal.setTime( dateFormat.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cal.add( Calendar.DATE, index );
        String convertedDate=dateFormat.format(cal.getTime());

        return convertedDate;
    }

    /**
     * mid함수
     * @param input
     * @param index
     * @param len
     * @return
     */
    public static String mid(String input, int index, int len) {
    	if (input == null || input.isEmpty()) {
            return null;
        }
        return input.substring(index - 1, index + len - 1);
    }

    /**
     * mid함수
     * @param input
     * @param index
     * @return
     */
    public static String mid(String input, int index) {
    	if (input == null || input.isEmpty()) {
            return null;
        }
        return input.substring(index - 1);
    }

    /**
     * @param input
     * @param len
     * @return
     */
    public static String left(String input, int len) {
    	if (input == null || input.isEmpty()) {
            return null;
        }
        return input.substring(0, len);
    }


    /**
     * 랜덤 passwd 생성.
     * @param size
     * @return
     */
    public static String rndPasswd(int size) {
    	StringBuffer buffer = new StringBuffer();
    	Random random = new Random();

    	String chars[] = "A,B,C,D,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,U,V,W,X,Y,Z,2,3,4,5,6,8,9".split(",");

    	for (int i = 0; i < size; i++) {
    		buffer.append(chars[random.nextInt(chars.length)]);
    	}
    	return buffer.toString();
    }

    /**
     * 0으로 채우기(4자리 이하)
     * @param strValue, length
     * @return
     */
    public static String fncZeroValue(String str, int size) {
    	if(str == null || str.trim().length() == 0 || str.trim().length() > size) {
    		return str;
    	}

    	str = "0000" + str;
    	int len = str.length();
    	System.out.println("" + len);
    	return str.substring(len-size, len);
    }

    /**
     * id 일정위치 뒤에선 * 로 표시
     * @param id
     * @return
     */
    public static String fncIdhidden(String id) {
        int len = id.length();
        int hidden = Math.round(id.length() / 2);
        String newId = "";
        for (int i=0; i<len; i++) {
            if (i < hidden) {
                newId += id.substring(i, i+1);
            } else {
                newId += "*";
            }
        }
        return newId;
    }

    /**
     * 전화번호에서 특정문제 제거
     * @param tel
     * @return
     */
    public static String fncTelTrim(String tel) {
        String newTel = "";
        newTel = tel.replaceAll("-", "");
        newTel = newTel.replaceAll(" ", "");
        return newTel;
    }

    public static boolean isNumeric(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        int i = 0;
        int stringLength = string.length();
        if (string.charAt(0) == '-') {
            if (stringLength > 1) {
                i++;
            } else {
                return false;
            }
        }
        if (!Character.isDigit(string.charAt(i))
                || !Character.isDigit(string.charAt(stringLength - 1))) {
            return false;
        }
        i++;
        stringLength--;
        if (i >= stringLength) {
            return true;
        }
        for (; i < stringLength; i++) {
            if (!Character.isDigit(string.charAt(i))
                    && string.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }

    /**
     * 오늘과 날짜 비교
     * @param date
     * @return
     */
    public static long fncDateDiff(String date) {
    	if (date == null || date.isEmpty()) {
            return 0;
        }
		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d2 = new Date();
		//in milliseconds
		long diff = d2.getTime() - d1.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);

		return diffDays;

    }

    /**
     * date1 - date2 날짜
     * @param date
     * @return
     */
    public static long fncDateMinus(String date1, String date2) {
    	if (date1 == null || date1.isEmpty()) {
            return 0;
        }
    	if (date2 == null || date2.isEmpty()) {
            return 0;
        }
		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(date1);
			d2 = format.parse(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//in milliseconds
		long diff = d1.getTime() - d2.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);

		return diffDays;
    }

    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }


    /**
     * @param barCode
     * @return
     */
    public static boolean fncCheckdigit(String barCode) {
        if (barCode == null || barCode.isEmpty()) {
            return false;
        }

        String[] arBarCode = new String[13];
        String totalEven = "0";
        String totalOdd = "0";
        String totalNumber = "0";
        for (int i=0 ; i < 13 ; i++) {
        	if(barCode.length() - i > 0){
	        	arBarCode[i] = mid(barCode, barCode.length() - i, 1);
	        	if(i != 1 && (i % 2) == 0 ){
	        		totalEven = String.valueOf(Integer.parseInt(totalEven) + Integer.parseInt(arBarCode[i]));
	        	}else if(i != 1 && (i % 2) == 1 ){
	        		totalOdd = String.valueOf(Integer.parseInt(totalOdd) + Integer.parseInt(arBarCode[i]));
	        	}
        	}
        }
        totalEven = String.valueOf(Integer.parseInt(totalEven) * 3);
        totalNumber = String.valueOf(Integer.parseInt(totalEven) * Integer.parseInt(totalOdd));
        totalNumber = String.valueOf(10 - Integer.parseInt(right(totalNumber, 1)));

        if(arBarCode[1]== right(totalNumber, 1)){
        	return true;
        }else{
        	return false;
        }
    }

    /**
     * @param barCode
     * @return
     */
    public static String fncCheckdigit2(String barCode) {
        if (barCode == null || barCode.isEmpty()) {
            return "0";
        }

        String[] arBarCode = new String[13];
        String totalEven = "0";
        String totalOdd = "0";
        String totalNumber = "0";
        for (int i=0 ; i < 13 ; i++) {
        	if(barCode.length() - i > 0){
	        	arBarCode[i] = mid(barCode, barCode.length() - i, 1);
	        	if(i != 1 && (i % 2) == 0 ){
	        		totalEven = String.valueOf(Integer.parseInt(totalEven) + Integer.parseInt(arBarCode[i]));
	        	}else if(i != 1 && (i % 2) == 1 ){
	        		totalOdd = String.valueOf(Integer.parseInt(totalOdd) + Integer.parseInt(arBarCode[i]));
	        	}
        	}
        }
        totalEven = String.valueOf(Integer.parseInt(totalEven) * 3);
        totalNumber = String.valueOf(Integer.parseInt(totalEven) * Integer.parseInt(totalOdd));
        totalNumber = String.valueOf(10 - Integer.parseInt(right(totalNumber, 1)));

        if(barCode.length()>= 12){
        	return left(barCode,12) + totalNumber;
        }else{
        	return left(barCode,barCode.length()) + totalNumber;
        }
    }

    public static String fncCheckBarcode(String keyword, String type) {
    	String barcodeCheckResult = "1"; //완료 TODO: 정상바코드일 경우 1
		String barcodeTrue = "";
	    if(keyword.length() == 13 && (PamaStringUtils.isNumeric(keyword))){	// 표준바코드 880~
			if(PamaStringUtils.fncCheckdigit(keyword)){
				barcodeCheckResult = "1";
				barcodeTrue = "";
			}else{
				barcodeCheckResult = "0";
				barcodeTrue = PamaStringUtils.fncCheckdigit2(keyword);
			}
		}else if(keyword.length() == 30 ){	// 협회KCOD바코드
			if(PamaStringUtils.isNumeric(keyword)){
				if(PamaStringUtils.fncCheckdigit(PamaStringUtils.left(keyword, 13))){
					barcodeCheckResult = "1";
					barcodeTrue = "";
				}else{
					barcodeCheckResult = "0";
					barcodeTrue = PamaStringUtils.fncCheckdigit2(keyword);
				}
				keyword = PamaStringUtils.left(keyword, 13);
			}else{
				barcodeCheckResult = "1";
				keyword = PamaStringUtils.left(keyword, 10);
			}
		}else if(keyword.length() == 10 ){
			barcodeCheckResult = "1";
		}else if(keyword.length() == 8 && PamaStringUtils.isNumeric(keyword)){
			barcodeCheckResult = "1";
		}else{
			barcodeCheckResult = "0";
		}
	    if("keyword".equals(type)){
	    	return keyword;
	    }if("barcodeTrue".equals(type)){
	    	return barcodeTrue;
	    }else{
	    	return barcodeCheckResult;
	    }
    }

    public static void main(String[] args) {
        String str3 = "mid string";
        System.out.println( "Test fncIdhidden :" + fncIdhidden("123456789"));
        System.out.println("Test mid str: " + str3);
        System.out.println("Test mid str: " + mid(str3, 6, 3));
        String str1 = "left string";
        System.out.println("Test left str: " + str1);
        System.out.println("Test left str: " + left(str1, 4));
        System.out.println("Test right str: " + right(str1, 4));
        String date="2011-10-08";
        System.out.println("Test dateadd str: " + dateadd(date, 2));
        String str5 ="-10";
        System.out.println("Test isNumeric str: " + isNumeric(str5));
        String str6 ="0031000163";
        System.out.println("Test checkDigit str: " + fncCheckdigit(str6));
        String str7 ="0031000163";
        System.out.println("Test checkDigit2 str: " + fncCheckdigit2(str7));

        System.out.println("Test fncCheckBarcode -keyword- str: " + fncCheckBarcode(str7,"keyword"));
        System.out.println("Test fncCheckBarcode -barcodeTrue- str: " + fncCheckBarcode(str7,"barcodeTrue"));
        System.out.println("Test fncCheckBarcode -barcodeCheckResult- str: " + fncCheckBarcode(str7,"barcodeCheckResult"));
    }
    public static boolean isMobile(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        boolean mobile1 = userAgent.matches(".*(iPhone|iPad|iPod|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson).*");
        boolean mobile2 = userAgent.matches(".*(LG|SAMSUNG|Samsung).*");
        if(mobile1 || mobile2) {
            return true;
        }
        return false;
    }
    public static String getBrowser(HttpServletRequest request){
    	String header = request.getHeader("User-Agent");
    	if (header != null) {
    		return header;
    	}else{
    		return null;
    	}
    	/*
    	if (header != null) {
		   if (header.indexOf("Trident") > -1) {
			   if(header.indexOf("11.0") > -1){
				   return "MSIE 11";
			   }else if(header.indexOf("10.0") > -1){
				   return "MSIE 10";
			   }else if(header.indexOf("9.0") > -1){
				   return "MSIE 9";
			   }else if(header.indexOf("8.0") > -1){
				   return "MSIE 8";
			   }else{
				   return "MSIE";
			   }
		   } else if (header.indexOf("Chrome") > -1) {
		    return "Chrome";
		   } else if (header.indexOf("Opera") > -1) {
		    return "Opera";
		   } else if (header.indexOf("iPhone") > -1
		     && header.indexOf("Mobile") > -1) {
		    return "iPhone";
		   } else if (header.indexOf("Android") > -1
		     && header.indexOf("Mobile") > -1) {
		    return "Android";
		   }
    	}
		  return "Firefox";
		*/
    }

}
