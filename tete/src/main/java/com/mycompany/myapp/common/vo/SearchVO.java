package com.mycompany.myapp.common.vo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

/**
 * 페이징VO
 *
 * author Sycop
 * version 1.0
 */
@XmlRootElement(name = "paging")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchVO implements Serializable{

    private static final long serialVersionUID = -2212585803867404940L;

    private static final String SORTASC  = "ASC";
    private static final String SORTDESC = "DESC";
    private static final int LIST_PAGE_NO = 1;
    private static final int LIST_ROW = 10;
    private static final int LIST_START_INDEX = 0;
    private static final int TOTAL_PAGES = 1;

    /**
     * 조회할 페이지 번호.
     */
    @XmlElement(name = "pageNo")
    protected int pageNo=LIST_PAGE_NO;

    /**
     * 한 페이지에 보여질 아이템 수.
     */
    @XmlElement(name = "row")
    protected int row=LIST_ROW;

    /**
     * 목록시작번호
     */
    @XmlElement(name = "startIndex")
    protected int startIndex=LIST_START_INDEX;

    /**
     * 목록끝번호
     */
    @XmlElement(name = "endIndex")
    protected int endIndex;

    /**
     * 해당페이징의 목록시작번호
     */
    @XmlElement(name = "pageStartIndex")
    protected int pageStartIndex;

    /**
     * 전체페이지갯수
     */
    @XmlElement(name = "totalPages")
    protected int totalPages=TOTAL_PAGES;

    /**
     * 전체갯수
     */
    @XmlElement(name = "totalCount")
    protected int totalCount;

    /**
     * 정렬컬럼
     */
    @XmlElement(name = "sortColumn")
    protected String sortColumn;

    /**
     * 정렬방향 : 0 ASC 1: DESC
     */
    @XmlElement(name = "sortDirection")
    protected int sortDirection;

    /**
     * 정렬방향 변환되는값
     */
    @XmlElement(name = "sortValue")
    protected String sortValue;

    /**
     * 검색컬럼
     */
    @XmlElement(name = "searchColumn")
    private String searchColumn;

    /**
     * 검색값
     */
    @XmlElement(name = "searchValue")
    private String searchValue;

    /**
     * @return the pageNo
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo the pageNo to set
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the startIndex
     */
    public int getStartIndex() {
         if(startIndex==0){
             startIndex=(getPageNo()-1)*getRow();//mysql일경우에는 -1
         }
         return startIndex;
    }

    /**
     * @param startIndex the startIndex to set
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * @return the endIndex
     */
    public int getEndIndex() {
        if(endIndex==0){
            endIndex=getStartIndex() + getRow();
        }
        return endIndex;
    }

    /**
     * @param endIndex the endIndex to set
     */
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    /**
     * @return the pageStartIndex
     */
    public int getPageStartIndex() {
        if(pageStartIndex == 0){
            pageStartIndex = getTotalCount() - (getPageNo()-1)*getRow();
        }
        return pageStartIndex;
    }

    /**
     * @param pageStartIndex the pageStartIndex to set
     */
    public void setPageStartIndex(int pageStartIndex) {
        this.pageStartIndex = pageStartIndex;
    }

    /**
     * @return the totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * @param totalPages the totalPages to set
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * @return the totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return the sortColumn
     */
    public String getSortColumn() {
        return sortColumn;
    }

    /**
     * @param sortColumn the sortColumn to set
     */
    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    /**
     * @return the sortDirection
     */
    public int getSortDirection() {
        return sortDirection;
    }

    /**
     * @param sortDirection the sortDirection to set
     */
    public void setSortDirection(int sortDirection) {
        this.sortDirection = sortDirection;
    }

    /**
     * @return the sortValue
     */
    public String getSortValue() {
        if(StringUtils.isEmpty(sortValue)){
            if(sortDirection==0){
            	sortValue=SORTDESC;
            }else{
                sortValue=SORTASC;
            }
        }
        return sortValue;
    }

    /**
     * @param sortValue the sortValue to set
     */
    public void setSortValue(String sortValue) {
        this.sortValue = sortValue;
    }

    /**
     * @return the searchColumn
     */
    public String getSearchColumn() {
        return searchColumn;
    }

    /**
     * @param searchColumn the searchColumn to set
     */
    public void setSearchColumn(String searchColumn) {
        this.searchColumn = searchColumn;
    }

//    /**
//     * @return the searchValue
//     */
//    public String getSearchValue() {
//    	this.searchValue = StringUtils.defaultString(this.searchValue);
//    	 try {
// 			return new String(this.searchValue.getBytes("8859_1"),"UTF-8");
// 		} catch (UnsupportedEncodingException e) {
// 			e.printStackTrace();
// 		}
// 		return searchValue;
//    }

    /**
     * @return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

}
