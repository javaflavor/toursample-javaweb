rem 使用するDBユーザ、パスワード、接続文字列を変更する場合は、
rem 下記記述書式を参考にしてください。
rem 【記述書式】
rem createlang -U <使用するDBユーザ> plpgsql <使用するDB>
rem psql -h <DBサーバIP> -U <使用するDBユーザ> -d <使用するDB> -f setup.sql


set path=C:\Program Files\PostgreSQL\8.4\bin\;%path%
createlang -U sample plpgsql teradb
psql -h 127.0.0.1 -U sample -d teradb -f setup.sql

pause
