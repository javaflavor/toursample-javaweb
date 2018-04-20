*******************************************************************************
      TERASOLUNA Server Framework for Java （Web版）
      TERASOLUNAトラベル ツアー予約システム 構築手順

      Copyright (C) 2007, 2010 NTT DATA Corporation.
*******************************************************************************


■  概要：

  このreadmeは、TERASOLUNA Server Framework for Java (Web版) 
  のツアー予約システムを構築する手順書です。
  下記手順に従うことで、TERASOLUNAトラベル ツアー予約システムを実行することがで
  きます。



■  前提条件：

  導入環境には、あらかじめ下記のものが用意されている必要があります。 

　・OS：Microsoft Windows XP Professional SP3
　・JDK：SunJDK 6.0
　・DBサーバ：PostgreSQL 8.4もしくはOracle Database 11g
　・APサーバ：Apache Tomcat 6.0.20
　・統合開発環境：Eclipse SDK 3.4.1
　・Eclipse plugin：WTP 3.0.4, Apache Ant 1.7.0
　・Webブラウザ：Internet Explorer 7.0
    
  併記されているバージョンを元に動作確認を行っていますが、このバージョン以外の環
  境での動作を制限するものではありません。
  また、これらのインストール及び設定の手順については、別途Web上の利用ガイド等を
  参照してください。 


■  Antタスク一覧：

  プロジェクトの「/ant」ディレクトリには、Antタスクが記述された「build.xml」が存在し
  ます。以下がAntタスクの一覧です。 

  ・clean
      作成したwarファイル、コンパイルされたクラスファイルの削除を行います。
  ・compile
      コンパイルを行います。
  ・native2ascii
      native2asciiにてプロパティファイルのコード変換を行います。
  ・deploy
      プロジェクトのデプロイを行います。
  ・createJavaDoc
      JavaDocの生成を行います。



■  サーバの追加（WTP環境）：

  EclipseにWTPプラグインが導入されている場合、以下の手順でサーバを追加します。 

  1.Eclipse画面にて「ウィンドウ」＞「ビューの表示」＞「その他」を実行し、「サー
    バー」を選択し「OK」をクリックします。 
  2.サーバービューで右クリック「新規」＞「サーバー」を実行します。 
  3.「Apache」＞「Tomcat v6.0 サーバー」を選択し、「次へ」をクリックします。 
  4.「Tomcat」を選択し、「次へ」をクリックします。 
  5.自端末の環境に合った「Tomcat インストール･ディレクトリー」を選択します。
  6.「終了」をクリックします。 



■  プロジェクトの実行（共通）：

  TERASOLUNAトラベル ツアー予約システムをEclipseにインポートします。また、データ
  ベースの設定を行います。 

  ①ZIPファイルの展開
  
    toursample-javaweb.zipを「C:/」直下に展開します。 
    ・例「C:/toursample-javaweb/」
    （※）指定されたディレクトリは固定ではないため、適宜読み替えて実行してくださ
    い。
    ここでは、（Windows XPの）C:/に展開すると仮定し、手順を進めていきます。 

  ②Eclipseへのインポート
  
    1.Eclipse画面にて「ファイル」＞「インポート」を選択します。
    2.「既存プロジェクトをワークスペースへ」を選択し「次へ」をクリックします。
    3.「ルート・ディレクトリーの選択」にチェックが入った状態で「参照」をクリック
      し、ブランクプロジェクトを展開した親ディレクトリを指定します。 
    4.「toursample-javaweb」にチェックが入っていることを確認し、「終了」をクリ
      ックします。 

    エラーが出る場合は「■備考」を参照し、設定を変更してください。 

  ③JDBCドライバの配置
  
    Tomcatがデータベースに接続できるようにJDBCドライバを「<TOMCAT_HOME>/lib」
    にコピーします。JDBCドライバは付属されていないので、利用者各自でで別途
    入手する必要があります。 
    ・PostgreSQL … http://jdbc.postgresql.org/download.html
    ・Oracle … http://www.oracle.com/technology/software/tech/java/sqlj_jdbc/index.html
    
    ※バージョンが合っていれば、クライアント等をインストールした際に付属している
      JDBCドライバをご利用いただけます。 

  ④データベース環境の設定
  
    1.前提条件(環境により変更可能)
        データベース名(インスタンス名)･･･teradb
        DBユーザー名/パスワード･･･sample/sample

    2.「setup.bat」の編集
        「/sql/postgres/setup.bat」もしくは「/sql/oracle/setup.bat」を自端末の環境に
        合った値に書き換えます。「setup.bat」を参照してください。

    3.テーブル、サンプルデータの作成
      「/sql/(略)/setup.bat」を実行します。(Eclipseから実行不可)
      「SQL> 」が表示されたら exitと入力して終了してください。
      ※実行時パスの整合性をとるため、必ず当該ファイルが存在するディレクトリで実行
        してください。


  ⑤設定ファイルの編集
  
    ・「context.xml」の編集
        「/webapps/META-INF/context.xml」を自端末の環境に合った値に書き換えます。
        詳細は「context.xml」を参照してください。
        
    ・「sqlMapConfig.xml」の編集
		PostgreSQLを利用するか、Oracle Databaseを利用するかで、
		「/webapps/WEB-INF/sqlMapConfig.xml」のコメントアウト部を切り替えます。
		※詳細は「sqlMapConfig.xml」を参照してください。
        
        

■  プロジェクトの実行（WTP環境）：

    WTPプラグインを利用する場合、以下の手順でプロジェクトを実行します。 

  ⑥サーバへの追加
    ・サーバービューで「toursample-javaweb」のプロジェクトを追加します。
    
  ⑦Tomcatの起動および、実行確認
    1.サーバを始動します。
    2.http://localhost:8080/toursample-javaweb/にアクセスし、
      メニュー画面が表示されれば、デプロイ成功です。
  
  
  
■  プロジェクトの実行（非WTP環境）：

  ⑥Antタスクの実行
  
    1.プロジェクトの「/ant/build.properties」を自端末の環境に合った値に書き換え
      ます。
      ・詳細はbuild.propertiesを参照してください。特にパス関連に関しては十分確認
        してください。 
    2.「build.properties」の修正後、「/ant/build.xml」を右クリックしAntタスクの
      「deploy」を選択して実行します。 
      
  ⑦Tomcatの起動および、実行
  
    1.デプロイ先のTomcatを起動します。 
    2.http://localhost:8080/<context.name>/にアクセスします。 
      ・「<context.name>」は、build.properties内に記述した値であり、デフォルトは
        toursample-javawebとなっています。      
    3.メニュー画面が表示されれば、デプロイ成功です。


■　動作確認
  
  　・動作確認方法
    　ログインする場合は２つの方法があります。
   　 一つ目は会員登録機能を利用し新しくログインユーザを作成することです。
    　二つ目は以下のログインユーザを使用することです。
    　全てのログインユーザについては
    　＜プロジェクトディレクトリ＞/sql/insert_customer.sqlを参照してください。
    　
    　・予約履歴が存在するユーザ
    　　　ユーザID: 00000001
   　　 　パスワード: password

  　　・検索方法
    　　　ツアー検索画面にて検索条件を入力する必要がありますが、以下のツアー情報が存在
    　　　しています。
    　　　・出発地：北海道(検索条件一番目)
    　　　・目的地：北海道、青森県、岩手県、宮城県、秋田県、山形県、福島県、茨城県、
              　　　栃木県、群馬県(検索条件一～十番目)
    　　　・出発日：SQL文実行日の六日後から実行日の一ヶ月後
        　　　　　　例)SQL文実行日が5/10の場合は2010/5/16～2011/5/15のツアー情報が
       　　　　　　　　存在しています。
          
-------------------------------------------------------------------------------
Copyright (C) 2007, 2010 NTT DATA Corporation.


