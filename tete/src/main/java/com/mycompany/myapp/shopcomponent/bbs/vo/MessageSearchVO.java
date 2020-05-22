/**
 * Copyright 2016 Cloudci Pama Framework 1.0
 * 게시물 검색조건 VO
 *
 * <pre>
 * <b>History:</b>
 * Author       Date        Description
 * ys.ko        2016.07.03  초기작성
 * </pre>
 *
 * author ys.ko
 * version 1.0, 2016.07.03 초기작성
* see None
 */
package com.mycompany.myapp.shopcomponent.bbs.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.mycompany.myapp.common.vo.SearchVO;

@XmlRootElement(name = "messageSearch")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageSearchVO extends SearchVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8288438407235350314L;

    /**
     * myListId
     */
    @XmlElement(name = "myListId")
    private String myListId;

    /**
     * 게시글 ID
     */
    @XmlElement(name = "messageSeq")
    private String messageSeq;

    /**
     * 게시판 ID
     */
    @XmlElement(name = "boardSeq")
    private String boardSeq;

    /**
     * 게시판 키
     */
    @XmlElement(name = "boardId")
    private String boardId;

    /**
     * 게시물 카테고리 ID
     */
    @XmlElement(name = "messageCategorySeq")
    private String messageCategorySeq;

    /**
     * topFlag
     */
    @XmlElement(name = "topFlag")
    private String topFlag;

    /**
     * topMessageFlag
     */
    @XmlElement(name = "topMessageFlag")
    private String topMessageFlag;

    /**
     * 등록자 ID
     */
    @XmlElement(name = "createId")
    private String createId;

    /**
     * 등록일From
     */
    @XmlElement(name = "createDateFrom")
    private String createDateFrom;

    /**
     * 등록일To
     */
    @XmlElement(name = "createDateTo")
    private String createDateTo;

    /**
     * sortTab
     */
    @XmlElement(name = "sortTab")
    private String sortTab;

    /**
     * 답변글사용여부
     */
    @XmlElement(name = "replyFlag")
    private String replyFlag;

    /**
     * 동영상태그 노출여부
     */
    @XmlElement(name = "displayFlag")
    private String displayFlag;

    /**
     * statusType
     */
    @XmlElement(name = "statusType")
    private String statusType;

    /**
     * consultFlag
     */
    @XmlElement(name = "consultFlag")
    private String consultFlag;

    /**
     * varFiled1
     */
    @XmlElement(name = "varFiled1")
    private String varFiled1;

    /**
     * varFiled2
     */
    @XmlElement(name = "varFiled2")
    private String varFiled2;

    /**
     * varFiled3
     */
    @XmlElement(name = "varFiled3")
    private String varFiled3;

    /**
     * varFiled4
     */
    @XmlElement(name = "varFiled4")
    private String varFiled4;

    /**
     * varFiled5
     */
    @XmlElement(name = "varFiled5")
    private String varFiled5;

    /**
     * varFiled6
     */
    @XmlElement(name = "varFiled6")
    private String varFiled6;

    /**
     * varFiled7
     */
    @XmlElement(name = "varFiled7")
    private String varFiled7;

    /**
     * varFiled8
     */
    @XmlElement(name = "varFiled8")
    private String varFiled8;
    @XmlElement(name = "varFiled9")
    private String varFiled9;
    @XmlElement(name = "varFiled10")
    private String varFiled10;

    /**
     * pageType
     */
    @XmlElement(name = "pageType")
    private String pageType;
    /**
     * tags
     */
    private String[] tags;

    /**
     * mbrLevel
     */
    private String mbrLevel;

    /**
     * messageLevel
     */
    private String messageLevel;

    /**
     * sortTree
     */
    private String sortTree;

    /**
     * parentMessageSeq
     */
    private String parentMessageSeq;

    /**
     * 상품코드
     */
    private String gcode;

    private String ccode;

    private String specialTerms;

    private String subTitle;


    /**
     * @return
     */
    public String getMbrLevel() {
        return mbrLevel;
    }

    /**
     * @param mbrLevel
     */
    public void setMbrLevel(String mbrLevel) {
        this.mbrLevel = mbrLevel;
    }

    /**
     * @return the messageSeq
     */
    public String getMessageSeq() {
        return messageSeq;
    }

    /**
     * @param messageSeq the messageSeq to set
     */
    public void setMessageSeq(String messageSeq) {
        this.messageSeq = messageSeq;
    }

    /**
     * @return the boardSeq
     */
    public String getBoardSeq() {
        return boardSeq;
    }

    /**
     * @param boardSeq the boardSeq to set
     */
    public void setBoardSeq(String boardSeq) {
        this.boardSeq = boardSeq;
    }

    /**
     * @return the boardId
     */
    public String getBoardId() {
        return boardId;
    }

    /**
     * @param boardId the boardId to set
     */
    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    /**
     * @return the messageCategorySeq
     */
    public String getMessageCategorySeq() {
        return messageCategorySeq;
    }

    /**
     * @param messageCategorySeq the messageCategorySeq to set
     */
    public void setMessageCategorySeq(String messageCategorySeq) {
        this.messageCategorySeq = messageCategorySeq;
    }

    /**
     * @return the topFlag
     */
    public String getTopFlag() {
        return topFlag;
    }

    /**
     * @param topFlag the topFlag to set
     */
    public void setTopFlag(String topFlag) {
        this.topFlag = topFlag;
    }

    /**
     * @return the topMessageFlag
     */
    public String getTopMessageFlag() {
        return topMessageFlag;
    }

    /**
     * @param topMessageFlag the topMessageFlag to set
     */
    public void setTopMessageFlag(String topMessageFlag) {
        this.topMessageFlag = topMessageFlag;
    }

    /**
     * @return the createId
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * @param createId the createId to set
     */
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    /**
     * @return the createDateFrom
     */
    public String getCreateDateFrom() {
        return createDateFrom;
    }

    /**
     * @param createDateFrom the createDateFrom to set
     */
    public void setCreateDateFrom(String createDateFrom) {
        this.createDateFrom = createDateFrom;
    }

    /**
     * @return the createDateTo
     */
    public String getCreateDateTo() {
        return createDateTo;
    }

    /**
     * @param createDateTo the createDateTo to set
     */
    public void setCreateDateTo(String createDateTo) {
        this.createDateTo = createDateTo;
    }

    /**
     * @return the sortTab
     */
    public String getSortTab() {
        return sortTab;
    }

    /**
     * @param sortTab the sortTab to set
     */
    public void setSortTab(String sortTab) {
        this.sortTab = sortTab;
    }

    /**
     * @return the replyFlag
     */
    public String getReplyFlag() {
        return replyFlag;
    }

    /**
     * @param replyFlag the replyFlag to set
     */
    public void setReplyFlag(String replyFlag) {
        this.replyFlag = replyFlag;
    }

    /**
     * @return the displayFlag
     */
    public String getDisplayFlag() {
        return displayFlag;
    }

    /**
     * @param displayFlag the displayFlag to set
     */
    public void setDisplayFlag(String displayFlag) {
        this.displayFlag = displayFlag;
    }

    /**
     * @return the statusType
     */
    public String getStatusType() {
        return statusType;
    }

    /**
     * @param statusType the statusType to set
     */
    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    /**
     * @return the consultFlag
     */
    public String getConsultFlag() {
        return consultFlag;
    }

    /**
     * @param consultFlag the consultFlag to set
     */
    public void setConsultFlag(String consultFlag) {
        this.consultFlag = consultFlag;
    }

    /**
     * @return the tags
     */
    public String[] getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    /**
     * @return the varFiled1
     */
    public String getVarFiled1() {
        return varFiled1;
    }

    /**
     * @param varFiled1 the varFiled1 to set
     */
    public void setVarFiled1(String varFiled1) {
        this.varFiled1 = varFiled1;
    }

    /**
     * @return varFiled2
     */
    public String getVarFiled2() {
        return varFiled2;
    }

    /**
     * @param varFiled2 the varFiled2 to set
     */
    public void setVarFiled2(String varFiled2) {
        this.varFiled2 = varFiled2;
    }

    /**
     * @return varFiled3
     */
    public String getVarFiled3() {
        return varFiled3;
    }

    /**
     * @param varFiled3 the varFiled3 to set
     */
    public void setVarFiled3(String varFiled3) {
        this.varFiled3 = varFiled3;
    }

    /**
     * @return varFiled4
     */
    public String getVarFiled4() {
        return varFiled4;
    }

    /**
     * @param varFiled4 the varFiled4 to set
     */
    public void setVarFiled4(String varFiled4) {
        this.varFiled4 = varFiled4;
    }

    /**
     * @return varFiled5
     */
    public String getVarFiled5() {
        return varFiled5;
    }

    /**
     * @param varFiled5 the varFiled5 to set
     */
    public void setVarFiled5(String varFiled5) {
        this.varFiled5 = varFiled5;
    }

    /**
     * @return varFiled6
     */
    public String getVarFiled6() {
        return varFiled6;
    }

    /**
     * @param varFiled6 the varFiled6 to set
     */
    public void setVarFiled6(String varFiled6) {
        this.varFiled6 = varFiled6;
    }

    /**
     * @return varFiled6
     */
    public String getVarFiled7() {
        return varFiled7;
    }

    /**
     * @param varFiled7 the varFiled6 to set
     */
    public void setVarFiled7(String varFiled7) {
        this.varFiled7 = varFiled7;
    }

    /**
     * @return varFiled8
     */
    public String getVarFiled8() {
        return varFiled8;
    }

    /**
     * @param varFiled8 the varFiled8 to set
     */
    public void setVarFiled8(String varFiled8) {
        this.varFiled8 = varFiled8;
    }

    /**
     * @return myListId
     */
    public String getMyListId() {
        return myListId;
    }

    /**
     * @param myListId the myListId to set
     */
    public void setMyListId(String myListId) {
        this.myListId = myListId;
    }

	/**
	 * @return the messageLevel
	 */
	public String getMessageLevel() {
		return messageLevel;
	}

	/**
	 * @param messageLevel the messageLevel to set
	 */
	public void setMessageLevel(String messageLevel) {
		this.messageLevel = messageLevel;
	}

	/**
	 * @return the sortTree
	 */
	public String getSortTree() {
		return sortTree;
	}

	/**
	 * @param sortTree the sortTree to set
	 */
	public void setSortTree(String sortTree) {
		this.sortTree = sortTree;
	}

	/**
	 * @return the parentMessageSeq
	 */
	public String getParentMessageSeq() {
		return parentMessageSeq;
	}

	/**
	 * @param parentMessageSeq the parentMessageSeq to set
	 */
	public void setParentMessageSeq(String parentMessageSeq) {
		this.parentMessageSeq = parentMessageSeq;
	}

	public String getGcode() {
		return gcode;
	}

	public void setGcode(String gcode) {
		this.gcode = gcode;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getVarFiled9() {
		return varFiled9;
	}

	public void setVarFiled9(String varFiled9) {
		this.varFiled9 = varFiled9;
	}

	public String getVarFiled10() {
		return varFiled10;
	}

	public void setVarFiled10(String varFiled10) {
		this.varFiled10 = varFiled10;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getSpecialTerms() {
		return specialTerms;
	}

	public void setSpecialTerms(String specialTerms) {
		this.specialTerms = specialTerms;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

}