package com.mycompany.myapp.common.error;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.common.util.ConvertUtil;
import com.mycompany.myapp.common.util.PamaStringUtils;
//import com.mycompany.myapp.shopcomponent.error.service.ErrorService;
//import com.mycompany.myapp.shopcomponent.error.vo.ErrorVO;

@Controller
@RequestMapping("/common/error")
public class CommonErrorController {
	private static final Logger logger = LoggerFactory.getLogger(CommonErrorController.class);

	//@Resource
    //private ErrorService errorService;

	@RequestMapping(value = "/throwable")
	public String throwable(HttpServletRequest request,HttpServletResponse response, Model model,Authentication authentication){
		logger.info("throwable");
		pageErrorLog(request, response, authentication);
		model.addAttribute("msg","예외가발생하였습니다.");
		return "common/error/error";
	}

	@RequestMapping(value = "/exception")
	public String exception(HttpServletRequest request,HttpServletResponse response, Model model,Authentication authentication){
		logger.info("exception");
		pageErrorLog(request, response, authentication);
		model.addAttribute("msg","예외가발생하였습니다.");
		return "common/error/error";
	}

	@RequestMapping(value = "/400")
	public String pageError400(HttpServletRequest request,HttpServletResponse response, Model model,Authentication authentication){
		logger.info("page error code 400");
		pageErrorLog(request, response, authentication);
		model.addAttribute("msg","잘못된 요청입니다.");
		return "common/error/400";
	}

	@RequestMapping(value = "/403")
	public String pageError403(HttpServletRequest request,HttpServletResponse response, Model model,Authentication authentication){
		logger.info("page error code 403");
		pageErrorLog(request, response, authentication);
		model.addAttribute("msg","접근이 금지되었습니다.");
		return "common/error/403";
	}

	@RequestMapping(value = "/404")
	public String pageError404(HttpServletRequest request,HttpServletResponse response, Model model,Authentication authentication){
		logger.info("page error code 404");
		pageErrorLog(request, response, authentication);

		model.addAttribute("msg","요청하신 페이지는 존재하지 않습니다.");
		return "common/error/404";
	}

	@RequestMapping(value = "/405")
	public String pageError405(HttpServletRequest request,HttpServletResponse response, Model model,Authentication authentication){
		logger.info("page error code 405");
		pageErrorLog(request, response, authentication);
		model.addAttribute("msg","요청하신 메소드가 허용되지 않습니다.");
		return "common/error/405";
	}

	@RequestMapping(value = "/500")
	public String pageError500(HttpServletRequest request,HttpServletResponse response, Model model,Authentication authentication){
		logger.info("page error code 500");
		pageErrorLog(request, response, authentication);
		model.addAttribute("msg","서버에 오류가 발생하였습니다.");
		return "common/error/500";
	}

	@RequestMapping(value = "/503")
	public String pageError503(HttpServletRequest request,HttpServletResponse response, Model model,Authentication authentication){
		logger.info("page error code 503");
		pageErrorLog(request, response, authentication);
		model.addAttribute("msg","서비스를 사용할 수 없습니다.");
		return "common/error/503";
	}

	private void pageErrorLog(HttpServletRequest request,HttpServletResponse response, Authentication authentication){
		String noInsertException = String.valueOf(request.getAttribute("javax.servlet.error.request_uri"));

		if(
			noInsertException.contains(".css") ||
			noInsertException.contains(".jpg") ||
			noInsertException.contains(".gif") ||
			noInsertException.contains(".png") ||
			noInsertException.contains(".ico")
			){
			//이미지 등이 404로 보일땐 일단 테이블에 입력 안함.
			//페이지 에러를 확인하기 위해서 해당기능을 추가한 것이므로.

		}else{
			//user info
	        /*SecurityUserVO securityUserVO = AuthenticationUtil.getSecurityUser();
	        System.out.println(securityUserVO.getUsername());
	        System.out.println(securityUserVO.getUserNm());*/


	        /*
	        System.out.println("message&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	        System.out.println("message : " + request.getAttribute("javax.servlet.error.message"));
	        System.out.println("message&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	        System.out.println(securityUserVO.getErpMcode());
	        System.out.println(ConvertUtil.getRequestIp());

			logger.info("status_code : " + request.getAttribute("javax.servlet.error.status_code"));
			logger.info("exception_type : " + request.getAttribute("javax.servlet.error.exception_type"));
			logger.info("message : " + request.getAttribute("javax.servlet.error.message"));
			logger.info("request_url : " + request.getAttribute("javax.servlet.error.request_url"));
			logger.info("exception : " + request.getAttribute("javax.servlet.error.exception"));
			logger.info("servlet_name : " + request.getAttribute("javax.servlet.error.servlet_name"));
			*/
			//ErrorVO errorVO = new ErrorVO();
			String ChkUserWebInfo = PamaStringUtils.getBrowser(request);
	        String isMobile = String.valueOf(PamaStringUtils.isMobile(request));
	        if(isMobile == "true"){
	        	isMobile = "Y";
	        }else{
	        	isMobile = "N";
	        }

	        InetAddress ip = null;
			try {
				ip = InetAddress.getLocalHost();
				System.out.println("Host Name = [" + ip.getHostName() + "]");
				System.out.println("Host Address = [" + ip.getHostAddress() + "]");
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			String userId = "guest";
			String userName = "guest";

			/*
			if (authentication != null) { // 로그인
	            Object details = authentication.getPrincipal();
	            if(details instanceof SecurityLoginVO) {
	                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;

	                userId = securityLoginVO.getMcode();
	                userName = securityLoginVO.getUsername();
	            }
			}
			if(securityUserVO.getErpMcode() != null || securityUserVO.getUsername() != null){
				userId = securityUserVO.getErpMcode();
				userName = securityUserVO.getUsername();
			}
			*/

			/*
			errorVO.setUserId(userId);
			errorVO.setUserName(userName);
			errorVO.setStatusCode(String.valueOf(request.getAttribute("javax.servlet.error.status_code")));
			errorVO.setExceptionType(String.valueOf(request.getAttribute("javax.servlet.error.exception_type")));
			errorVO.setMessage(String.valueOf(request.getAttribute("javax.servlet.error.message")));
			errorVO.setRequestUri(String.valueOf(request.getAttribute("javax.servlet.error.request_uri")));
			errorVO.setException(String.valueOf(request.getAttribute("javax.servlet.error.exception")));
			errorVO.setServletName(String.valueOf(request.getAttribute("javax.servlet.error.servlet_name")));
			errorVO.setIp(ip.getHostAddress());
			errorVO.setWebInfo(ChkUserWebInfo);
			errorVO.setIsMobile(isMobile);
			 */
			int status = 0;
			//status = errorService.insertErrorLog(errorVO);
		}

	}


}
