/*
 *
 *
 * Copyright (c) 2007, 2010 NTT DATA Corporation
 *
 */
package jp.terasoluna.toursample.common.blogic;

import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireInput;
import jp.terasoluna.toursample.common.dto.ReserveDetailAcquireOutput;

/**
 * 予約詳細取得ビジネスロジックインタフェース。<br>
 * <br>
 * ・共通処理CP0006：予約詳細取得
 * 
 * 
 */
public interface ReserveDetailAcquireBLogic {

    /**
     * 予約詳細の取得を行なう。
     * 
     * @param input
     *            検索条件(予約番号、顧客ID)
     * 
     * @return 予約詳細
     */
    public ReserveDetailAcquireOutput execute(ReserveDetailAcquireInput input);

}
