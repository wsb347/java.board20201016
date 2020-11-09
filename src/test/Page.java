package test;

import java.util.Scanner;

public class Page {
	
	private int currentPageNo; // 현재 페이지
	private int totalCntOfItems; // 전체 게시물 개수
	private int startPageNo = 1; // 시작 페이지 번호
	private int itemsCntPerPage = 3; // 페이지당 출력 게시물 개수
	private int pageCntPerBlock = 5; // 한 페이지 블록 당 페이지 개수
	private int endPageNo = (int) Math.ceil((double) totalCntOfItems / itemsCntPerPage); // 마지막 페이지 번호
	
	private int startIndex = (currentPageNo - 1) * itemsCntPerPage;
	private int endIndex = startIndex + itemsCntPerPage;
	
	private int currentPageBlock = (int)Math.ceil((double)currentPageNo / pageCntPerBlock) ; // 현재 페이지 블록
	private int startPageNoInBlock = (currentPageBlock - 1) * pageCntPerBlock + 1 ; // 현재 페이지 블록의 시작 페이지 번호
	private int endPageNoInBlock = startPageNoInBlock + pageCntPerBlock - 1;// // 현재 페이지 블록의 마지막 페이지 번호
	
	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}
	
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	
	public int getTotalCntOfItems() {
		return totalCntOfItems;
	}
	
	public void setTotalCntOfItems(int totalCntOfItems) {
		this.totalCntOfItems = totalCntOfItems;
	}
	
	public int getStartPageNo() {
		return startPageNo;
	}
	
	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}
	
	public int getItemsCntPerPage() {
		return itemsCntPerPage;
	}
	
	public void setItemsCntPerPage(int itemsCntPerPage) {
		this.itemsCntPerPage = itemsCntPerPage;
	}
	
	public int getPageCntPerBlock() {
		return pageCntPerBlock;
	}
	
	public void setPageCntPerBlock(int pageCntPerBlock) {
		this.pageCntPerBlock = pageCntPerBlock;
	}
	
	public int getEndPageNo() {
		return endPageNo;
	}
	
	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}
	
	public int getCurrentPageBlock() {
		return currentPageBlock;
	}
	
	public void setCurrentPageBlock(int currentPageBlock) {
		this.currentPageBlock = currentPageBlock;

	}

	public int getStartPageNoInBlock() {
		return startPageNoInBlock;
	}
	
	public void setStartPageNoInBlock(int startPageNoInBlock) {
		this.startPageNoInBlock = startPageNoInBlock;
	}
	
	public int getEndPageNoInBlock() {
		return endPageNoInBlock;
	}
	
	public void setEndPageNoInBlock(int endPageNoInBlock) {
		this.endPageNoInBlock = endPageNoInBlock;
	}

}
