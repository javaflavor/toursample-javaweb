/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.uc_a01_01.dto;

import java.io.Serializable;

/**
 * ページ遷移するときの出力値クラス。
 * 
 * 
 *
 */
public class RP_A01_01_01_04Output implements Serializable {

	/**
	 * シリアルバージョンUID。
	 */
	private static final long serialVersionUID = -8280550864355488098L;
	
    /**
     * ツアー情報一覧。
     */
    private TourInfo[] tourInfoList = null;
    
    /**
     * 一覧情報全行数。
     */
    private Integer allListInfoLineCount = 0;

	/**
	 * 一覧情報全行数を取得する。
	 * 
	 * @return allListInfoLineCount
	 */
	public Integer getAllListInfoLineCount() {
		return allListInfoLineCount;
	}

	/**
	 * 一覧情報全行数を設定する。
	 * 
	 * @param allListInfoLineCount
	 */
	public void setAllListInfoLineCount(Integer allListInfoLineCount) {
		this.allListInfoLineCount = allListInfoLineCount;
	}

	/**
	 * ツアー情報一覧を取得する。
	 * 
	 * @return tourInfoList
	 */
	public TourInfo[] getTourInfoList() {
		return tourInfoList;
	}

	/**
	 * ツアー情報一覧を設定する。
	 * 
	 * @param tourInfoList
	 */
	public void setTourInfoList(TourInfo[] tourInfoList) {
		this.tourInfoList = tourInfoList;
	}

}
