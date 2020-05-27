package com.mycompany.myapp.frontend.bbs;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.myapp.common.Constants;
import com.mycompany.myapp.common.component.base.BaseController;
import com.mycompany.myapp.common.component.processor.AttachmentProcessor;
import com.mycompany.myapp.common.component.vo.AttachmentVO;
import com.mycompany.myapp.common.util.ConvertUtil;
import com.mycompany.myapp.common.util.PamaStringUtils;
import com.mycompany.myapp.component.login.vo.SecurityLoginVO;
import com.mycompany.myapp.shopcomponent.bbs.service.BoardManagerService;
import com.mycompany.myapp.shopcomponent.bbs.service.MessageCategoryService;
import com.mycompany.myapp.shopcomponent.bbs.service.MessageCommentService;
import com.mycompany.myapp.shopcomponent.bbs.service.MessageService;
import com.mycompany.myapp.shopcomponent.bbs.vo.BoardVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageAttachmentVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCategoryListVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCategorySearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCategoryVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCommentFormVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCommentListVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageCommentSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageFormVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageListVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageSearchVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageVO;
import com.mycompany.myapp.shopcomponent.bbs.vo.MessageVarFiledsVO;
import com.mycompany.myapp.shopcomponent.menu.service.MenuService;
import com.mycompany.myapp.shopcomponent.menu.vo.MenuListVO;

/**
 * 게시판
 */
@Controller
@RequestMapping("/")
public class MessageController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);

    private @Value("${server.prod.images.domain}") String prodImagesDomain;

    @Resource
    private MessageService messageService;

    @Resource
    private MessageCategoryService messageCategoryService;

    @Resource
    private MessageCommentService messageCommentService;

    @Resource
    private AttachmentProcessor attachmentProcessor;

    @Resource
    private BoardManagerService boardManagerService;

    @Resource
    private MenuService menuService;

    private final static String FRONT_SKIN_PREFIX="/board/";

    @RequestMapping(value = "{boardId}/messageFrameList", method = RequestMethod.GET)
    public ModelAndView getMessageFrameList(@PathVariable("boardId") String boardId,
            HttpServletRequest request,
            HttpServletResponse response,
            MessageSearchVO messageSearchVO,
            Authentication authentication){

        LOG.debug("invoked 'getMessageFrameList' method...");

        //board info
        BoardVO boardVO = boardManagerService.getBoard(boardId);
        if ("1".equals(boardVO.getTopMessageFlag())) {  // 공지사항 사용여부 체크
            messageSearchVO.setTopMessageFlag(boardVO.getTopMessageFlag());
        }
        messageSearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));

        //message category list
        /*
        MessageCategorySearchVO messageCategorySearchVO = new MessageCategorySearchVO();
        messageCategorySearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));
        List<MessageCategoryVO> messageCategoryList = messageCategoryService.getMessageCategorySelectList(messageCategorySearchVO);
        */

        //message list
        int row = boardVO.getListLinesAdmin()==null?10:Integer.parseInt(boardVO.getListLinesAdmin());
        int startIndex = (messageSearchVO.getPageNo()-1) * row;

        messageSearchVO.setStartIndex(startIndex);
        messageSearchVO.setRow(row);
        MessageListVO messageList = messageService.getMessageList(messageSearchVO);


        ModelAndView mav = new ModelAndView();
        mav.addObject("boardVO", boardVO);
        //mav.addObject("messageCategoryList", messageCategoryList);
        mav.addObject("messageList", messageList);

        boardVO.setBoardId(boardId);
       	mav.setViewName(FRONT_SKIN_PREFIX+ConvertUtil.getBoardTypePath(boardVO.getBoardId())+"messageFrameList");

        return mav;
    }

    @RequestMapping(value = "{boardId}/messageList", method = RequestMethod.GET)
    public ModelAndView getMessageList(@PathVariable("boardId") String boardId,
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication,
            MessageSearchVO messageSearchVO){

        LOG.debug("invoked 'getMessageList' method...");

        //board info
        BoardVO boardVO = boardManagerService.getBoard(boardId);
        if ("1".equals(boardVO.getTopMessageFlag())) {  // 공지사항 사용여부 체크
            messageSearchVO.setTopMessageFlag(boardVO.getTopMessageFlag());
        }
        messageSearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));

        //message category list
        /*
        MessageCategorySearchVO messageCategorySearchVO = new MessageCategorySearchVO();
        messageCategorySearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));
        List<MessageCategoryVO> messageCategoryList = messageCategoryService.getMessageCategorySelectList(messageCategorySearchVO);
        */

        //message list
        int row = boardVO.getListLinesAdmin()==null?10:Integer.parseInt(boardVO.getListLinesAdmin());
        if (!"".equals(messageSearchVO.getRow())) {
            row = messageSearchVO.getRow();
        }

        int startIndex = (messageSearchVO.getPageNo()-1) * row;

        messageSearchVO.setStartIndex(startIndex);
        messageSearchVO.setRow(row);
        MessageListVO messageList  = new MessageListVO();
    	messageList = messageService.getMessageList(messageSearchVO);


        ModelAndView mav = new ModelAndView();

        mav.addObject("boardVO", boardVO);
        //mav.addObject("messageCategoryList", messageCategoryList);
        mav.addObject("messageList", messageList);

        //최근 문서 4개
        MessageListVO messageListRecent4  = new MessageListVO();
        messageListRecent4 = messageService.getMessageListRecent4();
        mav.addObject("messageListRecent4", messageListRecent4);

        //subtitle (category) count
        MessageListVO messageSubTitleCnt  = new MessageListVO();
        messageSubTitleCnt = messageService.getMessageSubTitleCnt();
        mav.addObject("messageSubTitleCnt", messageSubTitleCnt);

        boardVO.setBoardId(boardId);
        mav.setViewName(FRONT_SKIN_PREFIX+ConvertUtil.getBoardTypePath(boardVO.getBoardId())+"messageList");

        MenuListVO menuList = menuService.getUseMenu();
        mav.addObject("menuList", menuList);


        return mav;
    }

    //상단 공지게시판 글 5개 목록 가져오기
    @RequestMapping(value = "{boardId}/messageList5.json", method = RequestMethod.GET)
    public ModelAndView getMessageList5(@PathVariable("boardId") String boardId,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		Authentication authentication,
    		MessageSearchVO messageSearchVO){

    	LOG.debug("invoked 'getMessageList5' method...");

    	//board info
    	BoardVO boardVO = boardManagerService.getBoard(boardId);
    	messageSearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));

    	//message category list
    	MessageCategorySearchVO messageCategorySearchVO = new MessageCategorySearchVO();
    	messageCategorySearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));
    	List<MessageCategoryVO> messageCategoryList = messageCategoryService.getMessageCategorySelectList(messageCategorySearchVO);

    	//message list
    	int row = boardVO.getListLinesAdmin()==null?10:Integer.parseInt(boardVO.getListLinesAdmin());
    	if (!"".equals(messageSearchVO.getRow())) {
    		row = messageSearchVO.getRow();
    	}
    	int startIndex = (messageSearchVO.getPageNo()-1) * row;

    	messageSearchVO.setStartIndex(startIndex);
    	messageSearchVO.setRow(row);
    	MessageListVO messageList  = new MessageListVO();
		messageList = messageService.getMessageList5(messageSearchVO);

    	ModelAndView mav = new ModelAndView();
    	mav.addObject("messageList", messageList);
    	boardVO.setBoardId(boardId);
    	mav.setViewName(FRONT_SKIN_PREFIX+ConvertUtil.getBoardTypePath(boardVO.getBoardId())+"messageList");

    	return mav;
    }

    @RequestMapping(value = "{boardId}/messageDetail", method = RequestMethod.GET)
    public ModelAndView getMessage(@PathVariable("boardId") String boardId,
            HttpServletRequest request,
            HttpServletResponse response,
            MessageSearchVO messageSearchVO) throws ParseException{

        LOG.debug("invoked 'getMessage' method...");

        //게시판정보조회
        BoardVO boardVO = boardManagerService.getBoard(boardId);

        //게시글조회
        messageSearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));
        MessageVO messageVO = messageService.getMessageOne(messageSearchVO);

        //이전글조회
        MessageVO prevMessageVO = messageService.getMessagePrev(messageSearchVO);

        //다음글조회
        MessageVO nextMessageVO = messageService.getMessageNext(messageSearchVO);

        //답글 조회
        messageSearchVO.setParentMessageSeq(messageSearchVO.getMessageSeq());
        MessageVO messageReplyVO = messageService.getMessageReplyOne(messageSearchVO);

        //댓글리스트조회
        MessageCommentSearchVO messageCommentSearchVO = new MessageCommentSearchVO();
        messageCommentSearchVO.setMessageSeq(messageSearchVO.getMessageSeq());
        MessageCommentListVO messageCommentListVO = messageCommentService.getMessageCommentList(messageCommentSearchVO);

        //조회수+1
        MessageFormVO messageFormVO = new MessageFormVO();
        messageFormVO.setMessageSeq(String.valueOf(messageVO.getMessageSeq()));
        messageService.modifyMessageAddViewCount(messageFormVO);

        //return
        ModelAndView mav = new ModelAndView();
        mav.addObject("boardVO"           , boardVO);
        mav.addObject("messageSearchVO"   , messageSearchVO);
        mav.addObject("messageVO"         , messageVO);
        mav.addObject("messageReplyVO"    , messageReplyVO);
        mav.addObject("prevMessageVO"     , prevMessageVO);
        mav.addObject("nextMessageVO"     , nextMessageVO);
        mav.addObject("messageCommentList", messageCommentListVO.getMessageCommentList());

        mav.addObject("prodImagesDomain", prodImagesDomain);

        boolean isMobile = PamaStringUtils.isMobile(request);
        mav.addObject("isMobile", isMobile);

        //최근 문서 4개
        MessageListVO messageListRecent4  = new MessageListVO();
        messageListRecent4 = messageService.getMessageListRecent4();
        mav.addObject("messageListRecent4", messageListRecent4);

        //subtitle (category) count
        MessageListVO messageSubTitleCnt  = new MessageListVO();
        messageSubTitleCnt = messageService.getMessageSubTitleCnt();
        mav.addObject("messageSubTitleCnt", messageSubTitleCnt);

        boardVO.setBoardId(boardId);
        mav.setViewName(FRONT_SKIN_PREFIX+ConvertUtil.getBoardTypePath(boardVO.getBoardId())+"messageDetail");

        MenuListVO menuList = menuService.getUseMenu();
        mav.addObject("menuList", menuList);

        return mav;
    }
    @RequestMapping(value = "{boardId}/messageFrameDetail", method = RequestMethod.GET)
    public ModelAndView getFrameMessage(@PathVariable("boardId") String boardId,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		MessageSearchVO messageSearchVO) throws ParseException{

    	LOG.debug("invoked 'getFrameMessage' method...");

    	//게시판정보조회
    	BoardVO boardVO = boardManagerService.getBoard(boardId);

    	//게시글조회
    	messageSearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));
    	MessageVO messageVO = messageService.getMessageOne(messageSearchVO);

    	//이전글조회
    	MessageVO prevMessageVO = messageService.getMessagePrev(messageSearchVO);

    	//다음글조회
    	MessageVO nextMessageVO = messageService.getMessageNext(messageSearchVO);

    	//댓글리스트조회
    	MessageCommentSearchVO messageCommentSearchVO = new MessageCommentSearchVO();
    	messageCommentSearchVO.setMessageSeq(messageSearchVO.getMessageSeq());
    	MessageCommentListVO messageCommentListVO = messageCommentService.getMessageCommentList(messageCommentSearchVO);

    	//조회수+1
    	MessageFormVO messageFormVO = new MessageFormVO();
    	messageFormVO.setMessageSeq(String.valueOf(messageVO.getMessageSeq()));
    	messageService.modifyMessageAddViewCount(messageFormVO);

    	//return
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("boardVO"           , boardVO);
    	mav.addObject("messageSearchVO"   , messageSearchVO);
    	mav.addObject("messageVO"         , messageVO);
    	mav.addObject("prevMessageVO"     , prevMessageVO);
    	mav.addObject("nextMessageVO"     , nextMessageVO);
    	mav.addObject("messageCommentList", messageCommentListVO.getMessageCommentList());

    	boardVO = boardManagerService.getBoard("noticelist");
    	messageSearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));
    	MessageListVO notice5List = messageService.getMessageList(messageSearchVO);

    	mav.addObject("notice5List", notice5List);
    	mav.addObject("prodImagesDomain", prodImagesDomain);

    	boolean isMobile = PamaStringUtils.isMobile(request);
        mav.addObject("isMobile", isMobile);

    	boardVO.setBoardId(boardId);
    	mav.setViewName(FRONT_SKIN_PREFIX+ConvertUtil.getBoardTypePath(boardVO.getBoardId())+"messageFrameDetail");
    	return mav;
    }

    @RequestMapping(value = "{boardId}/messageForm", method = RequestMethod.GET)
    public ModelAndView getMessageForm(@PathVariable("boardId") String boardId,
            HttpServletRequest request,
            HttpServletResponse response,
            MessageSearchVO messageSearchVO) throws ParseException {

        LOG.debug("invoked 'getMessageForm' method...");

        BoardVO boardVO = boardManagerService.getBoard(boardId);


        messageSearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));
        MessageVO messageInfoVO = null;

        if (!"".equals(messageSearchVO.getMessageSeq())) {
            messageInfoVO = messageService.getMessageOne(messageSearchVO);
        }

        ModelAndView mav = new ModelAndView();

        //if ("1".equals(boardVO.getMessageCategoryFlag())) {
            MessageCategorySearchVO messageCategorySearchVO = new MessageCategorySearchVO();
            messageCategorySearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));
            mav.addObject("messageCategoryList", messageCategoryService.getMessageCategorySelectList(messageCategorySearchVO));
        //}

        MessageCommentSearchVO messageCommentSearchVO = new MessageCommentSearchVO();
        messageCommentSearchVO.setMessageSeq(messageSearchVO.getMessageSeq());
        MessageCommentListVO messageCommentListVO = messageCommentService.getMessageCommentList(messageCommentSearchVO);
        mav.addObject("messageCommentList", messageCommentListVO);


        boolean isMobile = PamaStringUtils.isMobile(request);
        mav.addObject("isMobile", isMobile);

        mav.addObject("boardVO", boardVO);
        mav.addObject("messageSearchVO", messageSearchVO);
        mav.addObject("messageVO", messageInfoVO);
        mav.setViewName(FRONT_SKIN_PREFIX+ConvertUtil.getBoardTypePath(boardVO.getBoardId())+"messageForm");

        MenuListVO menuList = menuService.getUseMenu();
        mav.addObject("menuList", menuList);

        return mav;
    }

    @RequestMapping(value = "{boardId}/messageReplyForm", method = RequestMethod.POST)
    public ModelAndView getMessageReplyForm(@PathVariable("boardId") String boardId,
            HttpServletRequest request,
            HttpServletResponse response,
            MessageSearchVO messageSearchVO) throws ParseException {

        LOG.debug("invoked 'getMessageReplyForm' method...");

        BoardVO boardVO = boardManagerService.getBoard(boardId);

        messageSearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));
        MessageVO messageQuestionVO = messageService.getMessageOne(messageSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardVO", boardVO);
        mav.addObject("messageVO", messageQuestionVO);

        return mav;
    }

    /**
     * 글쓰기(답변쓰기)
     * @param boardKey
     * @param request
     * @param response
     * @param messageFormVO
     * @return
     * @throws IllegalStateException
     * @throws IOException
     * @throws Exception
     */
    @RequestMapping(value = "{boardId}/messageRegister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes="multipart/form-data")
    public  ResponseEntity<BoardVO> addMessage(@PathVariable("boardId") String boardId,
    		//@RequestParam("title") String title,
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication,
            MessageFormVO messageFormVO,
            MessageVarFiledsVO messageVarFiledsVO
            ) throws IllegalStateException, IOException, Exception {

        LOG.debug("invoked 'addMessage' method...");

        BoardVO boardVO = boardManagerService.getBoard(boardId);

        messageFormVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq())); //게시판이이디

        LOG.debug("messageFormVO-title ========== {}", messageFormVO.getTitle());


        if (StringUtils.isEmpty(messageFormVO.getParentMessageSeq())) messageFormVO.setParentMessageSeq("0");

        String comma = "";
        if (!StringUtils.isEmpty(messageFormVO.getOtags()) && !StringUtils.isEmpty(messageFormVO.getTags())) {
            comma = ",";
        }

        messageFormVO.setTags( (messageFormVO.getOtags()==null?"":messageFormVO.getOtags() + comma) + messageFormVO.getTags() ); // 기존태그 와 신규태그 결합
        String topFlag = StringUtils.defaultIfEmpty(messageFormVO.getTopFlag(),"0");
        messageFormVO.setTopFlag(topFlag);

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;

                messageFormVO.setCreateId(securityLoginVO.getUsername());
                messageFormVO.setCreateName(securityLoginVO.getUsername());
                messageFormVO.setCreateEmail(securityLoginVO.getUsername());
                messageFormVO.setCreateIp(ConvertUtil.getRequestIp());
                messageFormVO.setUpdateId(securityLoginVO.getUsername());
                messageFormVO.setUpdateIp(ConvertUtil.getRequestIp());


                if (messageFormVO.getRegisterDateType()!=null) {
                    SimpleDateFormat formatter;
                    String dateString;
                    if ("".equals(messageFormVO.getRegisterDateType())) {
                        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Calendar now = Calendar.getInstance();
                        int hh = now.get(Calendar.HOUR_OF_DAY);
                        int mm = now.get(Calendar.MINUTE);
                        int ss = now.get(Calendar.SECOND);
                        now.setTime(formatter.parse(messageFormVO.getCreateDate()));
                        now.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH), hh, mm, ss);
                        dateString = formatter.format(now.getTime());
                    } else if ("0".equals(messageFormVO.getRegisterDateType())) {
                        dateString = null;
                    } else {
                        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Calendar now = Calendar.getInstance();
                        now.add(Calendar.HOUR_OF_DAY, -Integer.parseInt(messageFormVO.getRegisterDateType()));
                        dateString = formatter.format(now.getTime());
                    }

                    messageFormVO.setCreateDate(dateString);
                }


                if (messageFormVO.getProgressStatus()==null){
                	messageFormVO.setProgressStatus(Constants.CONTENTS_PROGRESS_PROG); // 진행
                }

                messageFormVO.setThumbnailUrl("");
                if (messageFormVO.getFiles()!=null) { // 첨부파일 정보 입력
                    List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
                    for (String arrFile : messageFormVO.getFiles()) {
                        if (arrFile.startsWith("new")) {
                            AttachmentVO attachmentVO = attachmentProcessor.uploadImageThumbnail(Constants.SERVICE_ID_BBS, arrFile);
                            messageAttachmentList.add(messageService.getMessageAttachmentoVO(attachmentVO, messageFormVO.getBoardSeq()));
                            if (messageFormVO.getThumbnailUrl().indexOf(arrFile.split("\\|")[1]) > 0) {
                                messageFormVO.setThumbnailUrl("/media/" + attachmentVO.getFileName() + ".image");
                            }
                        } else {
                            if (messageFormVO.getThumbnailUrl().indexOf(arrFile.split("\\|")[1]) > 0) {
                                messageFormVO.setThumbnailUrl(messageFormVO.getThumbnailUrl());
                            }
                        }
                    }
                    messageFormVO.setAttachmentList(messageAttachmentList);
                    messageFormVO.setAttachmentCount(messageFormVO.getFiles().length);
                }

                if (messageFormVO.getFile()!=null) {  // 첨부파일이 있으면
                    AttachmentVO attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getFile());
                    List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getMessageAttachmentoVO(attachmentVO, messageFormVO.getBoardSeq()));
                    }
                    messageFormVO.setAttachmentList(messageAttachmentList);
                    messageFormVO.setAttachmentCount( messageFormVO.getAttachmentCount() + messageAttachmentList.size());
                }else{
                    //showindex 처리 파일들
                    List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
                    AttachmentVO attachmentVO = null;
                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile1());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 1));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile2());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 2));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile3());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 3));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile4());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 4));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile5());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 5));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile6());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 6));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile7());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 7));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile8());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 8));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile9());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 9));
                    }

                    messageFormVO.setAttachmentList(messageAttachmentList);
                    messageFormVO.setAttachmentCount(messageFormVO.getAttachmentCount() + messageAttachmentList.size());
                }

                try {
                    //TODO : tag말고 쓴는 방법을 확인하자.
                    ObjectMapper objectMapper = new ObjectMapper();
                    String varFileds =  objectMapper.writeValueAsString(messageVarFiledsVO);
                    messageFormVO.setVarFileds(varFileds);
                } catch (Exception e) {
                    LOG.error("JSON ERROR[varFileds]" + e.getMessage());
                }

                messageService.addMessage(messageFormVO);

                MessageVO parentMessageVO = messageService.getMessageOne2(messageFormVO.getParentMessageSeq());

                if(StringUtils.isNotEmpty(messageFormVO.getPointInit()) ){
                    //pointService.trxUsePoint(parentMessageVO.getRegisterId(), Integer.parseInt(messageFormVO.getPointInit()), "PointUse:워셔액지급", parentMessageVO.getMessageId(), parentMessageVO.getRegisterId(), messageFormVO.getRegisterId(), messageFormVO.getRegisterIp());

                    MessageVO messageVarFiled1VO = new MessageVO();
                    messageVarFiled1VO.setMessageSeq(parentMessageVO.getMessageSeq());
                    messageVarFiled1VO.setVarFiled1("0");
                    messageService.modifyVarFiled1(messageVarFiled1VO);

                }

            }
        }

        //ModelAndView mav = new ModelAndView();
        //mav.addObject("boardVO", boardVO);

        //return mav;

        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<BoardVO>(boardVO, httpHeaders, HttpStatus.OK);

    }

    @RequestMapping(value = "{boardId}/messageModify", method = RequestMethod.POST)
    public ResponseEntity<BoardVO> modifyMessage(@PathVariable("boardId") String boardId,
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication,
            MessageFormVO messageFormVO,
            MessageVarFiledsVO messageVarFiledsVO
            ) throws IllegalStateException, IOException, Exception {

        LOG.debug("invoked 'modifyMessage' method...");

        BoardVO boardVO = boardManagerService.getBoard(boardId);

        MessageVO messageVO = new MessageVO();
        //BeanUtils.copyProperties(messageVO, messageFormVO);
        BeanUtils.copyProperties(messageFormVO, messageVO);

        messageVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq())); //게시판이이디

        messageVO.setMessageSeq(Integer.parseInt(messageFormVO.getMessageSeq()));   // 게시물 코드

        LOG.debug("messageFormVO-title ========== {}", messageVO.getTitle());

        /*
        String title = new String(messageVO.getTitle().getBytes("iso-8859-1"), "utf-8");
        String contents = new String(messageVO.getContents().getBytes("iso-8859-1"), "utf-8");

        messageVO.setTitle(title);
        messageVO.setContents(contents);
        */

        if (StringUtils.isEmpty(messageFormVO.getParentMessageSeq())) messageVO.setParentMessageSeq("0");

        String comma = "";
        if (!StringUtils.isEmpty(messageFormVO.getOtags()) && !StringUtils.isEmpty(messageVO.getTags())) comma = ",";

        messageVO.setTags( (messageFormVO.getOtags()==null?"":messageFormVO.getOtags() + comma) + messageVO.getTags() ); // 기존태그 와 신규태그 결합

        if( !"0".equals(messageVO.getTopFlag()) ) {
            messageVO.setTopFlag("1");
        }

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;

                messageVO.setUpdateId(securityLoginVO.getUsername());
                messageVO.setUpdateIp(ConvertUtil.getRequestIp());

                if (messageFormVO.getRegisterDateType()!=null) {
                    SimpleDateFormat formatter;
                    String dateString;
                    if ("".equals(messageFormVO.getRegisterDateType())) {
                        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Calendar now = Calendar.getInstance();
                        int hh = now.get(Calendar.HOUR_OF_DAY);
                        int mm = now.get(Calendar.MINUTE);
                        int ss = now.get(Calendar.SECOND);
                        now.setTime(formatter.parse(messageFormVO.getCreateDate()));
                        now.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH), hh, mm, ss);
                        dateString = formatter.format(now.getTime());
                    } else if ("0".equals(messageFormVO.getRegisterDateType())) {
                        dateString = null;
                    } else {
                        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Calendar now = Calendar.getInstance();
                        now.add(Calendar.HOUR_OF_DAY, -Integer.parseInt(messageFormVO.getRegisterDateType()));
                        dateString = formatter.format(now.getTime());
                    }
                    messageVO.setCreateDate(dateString);
                }

//                messageVO.setProgressStatus(Constants.CONTENTS_PROGRESS_PROG); // 진행
                if (messageFormVO.getFiles()!=null) { // 첨부파일 정보 입력
                    messageVO.setThumbnailUrl("");
                    List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
                    for (String arrFile : messageFormVO.getFiles()) {
                        if (arrFile.startsWith("new")) {
                            AttachmentVO attachmentVO = attachmentProcessor.uploadImageThumbnail(Constants.SERVICE_ID_BBS, arrFile);
                            messageAttachmentList.add(messageService.getMessageAttachmentoVO(attachmentVO, messageVO.getBoardId()));
                            if (messageFormVO.getThumbnailUrl().indexOf("http") < 0 &&
                                    messageFormVO.getThumbnailUrl().indexOf(arrFile.split("\\|")[1]) > 0) {
                                messageVO.setThumbnailUrl("/media/" + attachmentVO.getFileName() + ".image");
                            }
                        } else {
                            if (messageFormVO.getThumbnailUrl().indexOf("http") < 0 &&
                                    messageFormVO.getThumbnailUrl().indexOf(arrFile.split("\\|")[1]) > 0) {
                                messageVO.setThumbnailUrl(messageFormVO.getThumbnailUrl());
                            }
                        }
                    }
                    messageVO.setAttachmentList(messageAttachmentList);
                    messageVO.setAttachmentCount(messageFormVO.getFiles().length);
                }

                if (messageFormVO.getFile()!=null) {  // 첨부파일이 있으면
                    AttachmentVO attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getFile());
                    List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getMessageAttachmentoVO(attachmentVO, messageVO.getBoardId()));
                    }
                    messageVO.setAttachmentList(messageAttachmentList);
                    messageVO.setAttachmentCount(messageVO.getAttachmentCount() + messageAttachmentList.size());
                }else{
                    //showindex 처리 파일들
                    List<MessageAttachmentVO> messageAttachmentList = new ArrayList<MessageAttachmentVO>();
                    AttachmentVO attachmentVO = null;
                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile1());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 1));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile2());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 2));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile3());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 3));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile4());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 4));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile5());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 5));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile6());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 6));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile7());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 7));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile8());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 8));
                    }

                    attachmentVO = attachmentProcessor.upload(Constants.SERVICE_ID_BBS, messageFormVO.getShowFile9());
                    if(attachmentVO!=null){
                        messageAttachmentList.add(messageService.getShowIndexMessageAttachmentoVO(attachmentVO, String.valueOf(boardVO.getBoardId()), 9));
                    }

                    messageVO.setAttachmentList(messageAttachmentList);
                    messageVO.setAttachmentCount(messageFormVO.getAttachmentCount() + messageAttachmentList.size());
                }


                try {
                    //TODO : tag말고 쓴는 방법을 확인하자.
                    ObjectMapper objectMapper = new ObjectMapper();
                    String varFileds =  objectMapper.writeValueAsString(messageVarFiledsVO);
                    messageVO.setVarFileds(varFileds);
                } catch (Exception e) {
                    LOG.error("JSON ERROR[varFileds] {}", e.getMessage());
                }

                messageService.modifyMessage(messageVO);

            }
        }

        //ModelAndView mav = new ModelAndView();
        //mav.addObject("boardVO", boardVO);
        //mav.addObject("messageVO", messageVO);

        //return mav;

        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<BoardVO>(boardVO, httpHeaders, HttpStatus.OK);

    }

    @RequestMapping(value = "{boardId}/messageRemoveProc", method = RequestMethod.POST)
    public ModelAndView removeMessage(@PathVariable("boardId") String boardId,
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication,
            MessageVO messageVO) {

        LOG.debug("invoked 'removeMessage' method...");

        BoardVO boardVO = boardManagerService.getBoard(boardId);
        messageVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));
        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;

                messageVO.setUpdateId(securityLoginVO.getUsername());
                messageVO.setUpdateIp(ConvertUtil.getRequestIp());

                if (boardVO != null) { // 게시판이 있으면
                    messageService.removeMessage(messageVO);
                }

            }
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardVO", boardVO);

        return mav;

    }

    @RequestMapping(value = "{boardId}/messageErasureProc", method = RequestMethod.POST)
    public ModelAndView removeAllMessage(@PathVariable("boardId") String boardId,
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication,
            MessageVO messageVO) {

        LOG.debug("invoked 'removeAllMessage' method...");

        BoardVO boardVO = boardManagerService.getBoard(boardId);
        messageVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;

                messageVO.setUpdateId(securityLoginVO.getUsername());
                messageVO.setUpdateIp(ConvertUtil.getRequestIp());

                messageService.removeAllMessage(messageVO); // 게시물에 관련된 파일 및 컨텐츠를 모두 삭제한다.

            }
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("boardId", boardId);

        return mav;
    }

    @RequestMapping(value = "{boardId}/messageRemoveSelectProc", method = RequestMethod.POST)
    public ModelAndView removeSelectMessage(@PathVariable("boardId") String boardId,
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication,
            MessageFormVO messageFormVO) {

        LOG.debug("invoked 'removeSelectMessage' method...");

        BoardVO boardVO = boardManagerService.getBoard(boardId);
        messageFormVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;

                messageFormVO.setUpdateId(securityLoginVO.getUsername());
                messageFormVO.setUpdateIp(ConvertUtil.getRequestIp());

                messageService.removeSelectMessage(messageFormVO);
            }
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardId", boardId);

        return mav;
    }

    @RequestMapping(value="{boardKey}/messageAttachmentDelete", method = RequestMethod.GET)
    public ModelAndView removeMessageAttachment(@PathVariable("boardKey") String boardKey,
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication,
            @RequestParam("imageId") String imageId
            ) {

        LOG.debug("invoked 'removeMessageAttachment' method...");

        if (authentication !=null) {
            Object details = authentication.getPrincipal();
            if(details instanceof SecurityLoginVO) {
                messageService.removeMessageAttachment(imageId);
                AttachmentVO attachmentVO = attachmentProcessor.getImage(imageId);
                File file = new File(attachmentVO.getFilePath(),attachmentVO.getOriginalFilename());
                file.delete();
            }
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("msgCode", "100");

        return mav;
    }

    @RequestMapping(value="search/{boardId}/messageSearch", method = RequestMethod.GET)
    public ModelAndView searchMessageList(@PathVariable("boardId") String boardId,
            HttpServletRequest request,
            HttpServletResponse response,
            MessageSearchVO messageSearchVO){

        LOG.debug("invoked 'searchMessageList' method...");

        BoardVO boardVO = boardManagerService.getBoard(boardId);

        if ("1".equals(boardVO.getTopMessageFlag())) {  // 공지사항 사용여부 체크
            messageSearchVO.setTopMessageFlag(boardVO.getTopMessageFlag());
        }

        messageSearchVO.setBoardId(String.valueOf(boardVO.getBoardId()));
        messageSearchVO.setRow(Integer.parseInt(boardVO.getListLines())); //listLines
        MessageListVO messageList = messageService.getMessageList(messageSearchVO);

        ModelAndView mav = new ModelAndView();
        mav.addObject("boardVO", boardVO);
        mav.addObject("messageList", messageList);

        return mav;

    }

    @RequestMapping(value="{boardId}/insertMessageComment.json", method = RequestMethod.POST)
    public ModelAndView insertMessageComment(@PathVariable("boardId") String boardId,
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication,
            MessageCommentFormVO messageCommentFormVO) {

        LOG.debug("invoked 'insertMessageComment' method...");

        ModelAndView mav = new ModelAndView();


//        if (authentication !=null) {
//            Object details = authentication.getPrincipal();
//            if(details instanceof SecurityLoginVO) {
//                SecurityLoginVO securityLoginVO = (SecurityLoginVO) details;
//
//                messageCommentFormVO.setCreateName(securityLoginVO.getUsername());
//            }
//        }
        int successInt = messageCommentService.insertMessageComment(messageCommentFormVO);
        if(successInt>0){
            mav.addObject("msgCode", "100");
        }else{
            mav.addObject("msgCode", "-1");
        }
        return mav;
    }

    @RequestMapping(value="{boardId}/removeMmessageComment", method = RequestMethod.GET)
    public ModelAndView removeMmessageComment(@PathVariable("boardId") String boardId,
            HttpServletRequest request,
            HttpServletResponse response,
            MessageCommentFormVO messageCommentFormVO
            ) {

        LOG.debug("invoked 'removeMmessageComment' method...");

        ModelAndView mav = new ModelAndView();

        int successInt = messageCommentService.deleteSelectComment(messageCommentFormVO);
        if(successInt>0){
            mav.addObject("msgCode", "100");
        }else{
            mav.addObject("msgCode", "-1");
        }
        return mav;
    }

    @RequestMapping(value="{boardId}/recommendScore", method = RequestMethod.GET)
    public ModelAndView getRecommendScore(@PathVariable("boardId") String boardId,
            HttpServletRequest request,
            HttpServletResponse response,
            MessageSearchVO messageSearchVO
            ) {

        LOG.debug("invoked 'getRecommendScore' method...");

        ModelAndView mav = new ModelAndView();

        BoardVO boardVO = boardManagerService.getBoard(boardId);
        messageSearchVO.setBoardSeq(String.valueOf(boardVO.getBoardSeq()));

        int recommendScore = messageService.getRecommendScore(messageSearchVO);

        mav.addObject("recommendScore", recommendScore);

        return mav;
    }
}
