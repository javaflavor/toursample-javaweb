-- 
-- PostgreSQL用DDLスクリプト
-- 
-- データベースのエンコーディングはEUC_JPを想定しているが、
-- データファイルはShift_JISであるため、クライアントエンコーディングを
-- 明示的に変更している。
--
\encoding SJIS

\i drops.sql

\i create_all_sequences.sql
\i create_all_tables.sql
\i create_all_index.sql

\i insert_all_data.sql

COMMIT;
