-- 추가 데이터베이스 생성 
CREATE DATABASE parking_dev;

-- PostGIS 확장 프로그램 활성화 
\connect parking_dev;
CREATE EXTENSION IF NOT EXISTS postgis;
\connect parking_prod;
CREATE EXTENSION IF NOT EXISTS postgis;