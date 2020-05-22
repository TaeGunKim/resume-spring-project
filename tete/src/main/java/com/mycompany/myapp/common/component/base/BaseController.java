package com.mycompany.myapp.common.component.base;

import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.common.exception.PamaException;
import com.mycompany.myapp.common.vo.ErrorVO;

@Controller
public class BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

    @Resource
    private ReloadableResourceBundleMessageSource errorMessageSource;

    @ExceptionHandler(PamaException.class)
    public ModelAndView handlePamaException(PamaException pe, HttpServletResponse response) {

    	LOG.error("PamaException :: {}", pe);

        response.setStatus(pe.getHttpCode());
        String message = errorMessageSource.getMessage(pe.getErrorCode(), pe.getMessageArray(), Locale.getDefault());

        ErrorVO errorVO = new ErrorVO();
        errorVO.setCode(pe.getErrorCode());
        errorVO.setMessage(message);

        ModelAndView model = new ModelAndView("error/error");
        model.addObject("errorVO", errorVO);

        return model;

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ModelAndView handeHttpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletResponse response) {

    	LOG.error("handeHttpMessageNotReadableException :: {}", ex);

        response.setStatus(500);
        ErrorVO errorVO = new ErrorVO();
        errorVO.setCode("5000");
        errorVO.setMessage(errorMessageSource.getMessage("5000", null, Locale.US));

        ModelAndView model = new ModelAndView("error/error");
        model.addObject("errorVO", errorVO);

        return model;

    }

    @ExceptionHandler(javax.xml.bind.UnmarshalException.class)
    public ModelAndView handleUnmarshalException(javax.xml.bind.UnmarshalException ue, HttpServletResponse response) {

    	LOG.error("UnmashalException :: {}", ue);

        response.setStatus(400);
        String message = errorMessageSource.getMessage("1200", null, Locale.US);

        ErrorVO errorVO = new ErrorVO();
        errorVO.setCode("1200");
        errorVO.setMessage(message);

        ModelAndView model = new ModelAndView("error/error");
        model.addObject("errorVO", errorVO);

        LOG.error("UnmashalException :: {}", "1200");
        return model;
    }

    @ExceptionHandler(BindException.class)
    public ModelAndView handleBindException(BindException be, HttpServletResponse response) {
    	LOG.error("BindException :: {}", be);
        FieldError fieldError = be.getBindingResult().getFieldError();
        String field = fieldError.getField();
        String[] messageArray = fieldError.getDefaultMessage().split(":");

        String[] args = messageArray.clone();
        args[0] = field;

        response.setStatus(400);
        String message = errorMessageSource.getMessage("1002", args, Locale.US);

        ErrorVO errorVO = new ErrorVO();
        errorVO.setCode("1002");
        errorVO.setMessage(message);

        ModelAndView model = new ModelAndView("error/error");
        model.addObject("errorVO", errorVO);

        return model;
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ModelAndView handleBindException(MethodArgumentNotValidException mve, HttpServletResponse response) {
    	LOG.error("MethodArgmentNotValidException :: {}", mve);
        FieldError fieldError = mve.getBindingResult().getFieldError();
        String field = fieldError.getField();
        String[] messageArray = fieldError.getDefaultMessage().split(":");

        String[] args = messageArray.clone();
        args[0] = field;

        response.setStatus(400);
        String message = errorMessageSource.getMessage("1002", args, Locale.US);

        ErrorVO errorVO = new ErrorVO();
        errorVO.setCode("1002");
        errorVO.setMessage(message);

        ModelAndView model = new ModelAndView("error/error");
        model.addObject("errorVO", errorVO);

        return model;
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ModelAndView handleUnmarshalException(HttpMediaTypeNotSupportedException he, HttpServletResponse response) {

    	LOG.error("HttpMediaTypeNotSupportedException :: {}", he);
        response.setStatus(500);
        String message = errorMessageSource.getMessage("1201", null, Locale.US);

        ErrorVO errorVO = new ErrorVO();
        errorVO.setCode("1201");
        errorVO.setMessage(message);

        ModelAndView model = new ModelAndView("error/error");
        model.addObject("errorVO", errorVO);

        LOG.error("UnmashalException :: {}", "1201");

        return model;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception e, HttpServletResponse response) {

    	LOG.error("Exception ==== :: {}");

    	response.setStatus(500);
    	String message = errorMessageSource.getMessage("5000", null, Locale.US);

        ErrorVO errorVO = new ErrorVO();
        errorVO.setCode("5000");
        errorVO.setMessage(message);

        ModelAndView model = new ModelAndView("error/error");
        model.addObject("error", errorVO);

        LOG.error("UnmashalException :: {}", "5000");

        return model;

    }
}
