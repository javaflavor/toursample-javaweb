rem	使用するDBユーザ、パスワード、接続文字列を変更する場合は、
rem	下記記述書式を参考にしてください。
rem	【記述書式】
rem	sqlplus <使用するDBユーザ>/<パスワード>@<ネットサービス名> @setup.sql


sqlplus sample/sample@127.0.0.1:1521/teradb @setup.sql

pause