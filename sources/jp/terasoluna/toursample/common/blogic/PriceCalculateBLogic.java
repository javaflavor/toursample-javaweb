/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.blogic;

import jp.terasoluna.toursample.common.dto.PriceCalculateOutput;

/**
 * 単価料金算出ビジネスロジックインタフェース。<br>
 * <br>
 * ・共通処理CP0009：単価料金算出処理
 * 
 * 
 */
public interface PriceCalculateBLogic {

    /**
     * 単価、料金の算出を行なう。
     * 
     * @param basePrice
     *            基本料金
     * @param adultCount
     *            人数(大人)
     * @param childCount
     *            人数(子ども)
     * @return 単価料金算出結果
     */
    public PriceCalculateOutput execute(Integer basePrice, Integer adultCount,
            Integer childCount);
}
