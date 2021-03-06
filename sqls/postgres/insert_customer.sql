
--  初期データ登録用のプロシージャを生成する。  --
CREATE OR REPLACE FUNCTION C_CUSTOMER(
    --  顧客テーブルへの登録データ  --
    IN customerName VARCHAR,
    IN customerKana VARCHAR,
    IN customerPass VARCHAR,
    IN customerBirth DATE,
    IN customerJob VARCHAR,
    IN customerMail VARCHAR,
    IN customerTel VARCHAR,
    IN customerPost VARCHAR,
    IN customerAdd VARCHAR)
RETURNS 
     CHAR(8) AS $$
DECLARE
     customerCode CHAR(8);
BEGIN

     --  顧客コードシーケンスから顧客コードを取得  --
    SELECT
        TO_CHAR(nextval('CUSTOMER_CODE_SEQ'), 'FM09999999') INTO customerCode;
    --FROM
      --DUAL ;
      
    --  顧客情報の登録  --
    INSERT INTO CUSTOMER(
      CUSTOMER_CODE,
      CUSTOMER_NAME,
      CUSTOMER_KANA,
      CUSTOMER_PASS,
      CUSTOMER_BIRTH,
      CUSTOMER_JOB,
      CUSTOMER_MAIL,
      CUSTOMER_TEL,
      CUSTOMER_POST,
      CUSTOMER_ADD
    ) VALUES (
      customerCode,
      customerName,
      customerKana,
      customerPass,
      customerBirth,
      customerJob,
      customerMail,
      customerTel,
      customerPost,
      customerAdd
    );
    RETURN customerCode;
END;
$$ LANGUAGE plpgsql;

--  初期顧客情報を生成する。  --
SELECT  C_CUSTOMER('木村　太郎', 'キムラ　タロウ', 'password', '1975/01/05', 'プログラマ', 'tarou@example.com', '111-1111-1111', '276-0022', '千葉県八千代市上高野');
SELECT  C_CUSTOMER('前田　五郎', 'マエダ　ゴロウ', 'password', '1980/12/13', '建設業', 'gorou@example.com', '222-2222-2222', '135-8671', '東京都江東区豊洲3-3-9');
SELECT  C_CUSTOMER('鈴木　花子', 'スズキ　ハナコ', 'password', '1960/10/21', '主婦', '', '333-3333-3333', '616-0000', '京都市右京区');
SELECT  C_CUSTOMER('加藤　一郎', 'カトウ　イチロウ', 'password', '1965/03/12', '自営業', 'irasyai@example.com', '444-4444-4444', '039-1500', '三戸郡五戸町');
SELECT  C_CUSTOMER('田中　南都化', 'タナカ　ナントカ', 'password', '1970/06/30', '自営業', 'nantoka@example.com', '555-5555-5555', '039-1500', '三戸郡五戸町');
SELECT  C_CUSTOMER('渡辺　梟', 'ワタナベ　フクロウ', 'password', '1966/11/03', '自営業', 'watanabehu@example.com', '666-6666-6666', '135-8671', '東京都江東区豊洲3-3-9');
SELECT  C_CUSTOMER('データ　太郎', 'データ　タロウ', 'password', '1970/04/05', '営業', 'data1@example.com', '123-1234-1234', '135-8671', '東京都江東区豊洲3-3-9');
SELECT  C_CUSTOMER('データ　次郎', 'データ　ジロウ', 'password', '1972/05/15', '営業', 'data2@example.com', '123-1234-1234', '135-8671', '東京都江東区豊洲3-3-9');
SELECT  C_CUSTOMER('データ　三郎', 'データ　サブロウ', 'password', '1974/06/02', '営業', 'data3@example.com', '123-1234-1234', '135-8671', '東京都江東区豊洲3-3-9');
SELECT  C_CUSTOMER('データ　四郎', 'データ　シロウ', 'password', '1976/12/30', '営業', 'data4@example.com', '123-1234-1234', '135-8671', '東京都江東区豊洲3-3-9');
SELECT  C_CUSTOMER('データ　五郎', 'データ　ゴロウ', 'password', '1978/05/25', '営業', 'data5@example.com', '123-1234-1234', '135-8671', '東京都江東区豊洲3-3-9');

--  初期データ登録用のプロシージャを削除する。  --
DROP FUNCTION C_CUSTOMER(VARCHAR,VARCHAR,VARCHAR,DATE,VARCHAR,VARCHAR,VARCHAR,VARCHAR,VARCHAR);

COMMIT;

