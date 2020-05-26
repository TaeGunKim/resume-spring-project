import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;
import java.util.regex.Pattern;


public class BaseMain {

	/*
	@Resource
	static
	SmssendBatchService smssendBatchService;

	@Resource
	static
	SmssendService smssendService;
	*/

    public static void main(String[] args){


    		System.out.println("1☆☆☆☆☆☆☆☆☆☆");
    		System.out.println("2☆☆☆☆☆☆☆☆☆☆");
    		System.out.println("3☆☆☆☆☆☆☆☆☆☆");




            //String text = "qlalfqjsgh!$";
    		//String text = "1234";
    		String text = "k1478128!";

            byte[] targetBytes = text.getBytes();
            // Base64 인코딩 ///////////////////////////////////////////////////
            Encoder encoder = Base64.getEncoder(); byte[] encodedBytes = encoder.encode(targetBytes);
            // Base64 디코딩 ///////////////////////////////////////////////////
            Decoder decoder = Base64.getDecoder(); byte[] decodedBytes = decoder.decode(encodedBytes);
            System.out.println("인코딩 전 : " + text);
            System.out.println("인코딩 text : " + new String(encodedBytes));
            System.out.println("디코딩 text : " + new String(decodedBytes));


//    		byte[] password = Base64.decodeBase64("비밀번호!$");
//    		System.out.println(password);
//    		System.out.println(password);
//    		System.out.println(password);
//
//    		System.out.println("------------------------------------------");
//
//    		byte[] password2 = Base64.decodeBase64("minwoo@dba");
//    		System.out.println(password2);
//    		System.out.println(password2);
//    		System.out.println(password2);



    		/*

    		Connection conn = null;

    		try {
    			//String url ="jdbc:mysql://localhost:3306?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    			String url ="jdbc:mysql://localhost:3306/kimtgbase?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    			conn = DriverManager.getConnection(url,"kimtg","1234");
    			System.out.println(conn.toString());

    		}catch(SQLException e) {

    			System.out.println("SQLException :: " + e.getMessage());
    			System.out.println("SQLState :: " + e.getSQLState());
    			System.out.println("VendorError :: " + e.getErrorCode());
    		}finally {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			*/

    		System.out.println("☆☆☆☆☆☆☆☆☆☆");
    		System.out.println("☆☆☆☆☆☆☆☆☆☆");
    		System.out.println("☆☆☆☆☆☆☆☆☆☆");



    }



}
