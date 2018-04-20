/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.blogic;

import jp.terasoluna.toursample.common.dto.TourDetailAcquireOutput;

/**
 * ツアー詳細取得ビジネスロジックインタフェース。<br>
 * <br>
 * ・共通処理CP0007：ツアー詳細取得
 * 
 * 
 */
public interface TourDetailAcquireBLogic {

    /**
     * ツアー詳細の取得を行なう。
     * 
     * @param tourCode
     *            ツアーコード
     * 
     * @return ツアー詳細
     */
    public TourDetailAcquireOutput execute(String tourCode);

}
