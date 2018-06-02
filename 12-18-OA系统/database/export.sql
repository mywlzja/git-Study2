--------------------------------------------------------
--  File created - 星期一-十二月-18-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_DEPT
--------------------------------------------------------

   CREATE SEQUENCE  "SEQ_DEPT"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table T_DEPT
--------------------------------------------------------

  CREATE TABLE "T_DEPT" 
   (	"ID" NUMBER(19,0), 
	"DEPTNAME" VARCHAR2(32), 
	"DESCN" VARCHAR2(200), 
	"LEAF" NUMBER(1,0) DEFAULT 1, 
	"PARENT_ID" NUMBER(19,0)
   ) ;

---------------------------------------------------
--   DATA FOR TABLE T_DEPT
--   FILTER = none used
---------------------------------------------------
REM INSERTING into T_DEPT
Insert into T_DEPT (ID,DEPTNAME,DESCN,LEAF,PARENT_ID) values (1,'总公司',null,0,null);
Insert into T_DEPT (ID,DEPTNAME,DESCN,LEAF,PARENT_ID) values (2,'总裁办',null,1,1);
Insert into T_DEPT (ID,DEPTNAME,DESCN,LEAF,PARENT_ID) values (3,'行政部',null,1,1);
Insert into T_DEPT (ID,DEPTNAME,DESCN,LEAF,PARENT_ID) values (4,'财务部',null,1,1);
Insert into T_DEPT (ID,DEPTNAME,DESCN,LEAF,PARENT_ID) values (5,'北京分公司',null,0,1);
Insert into T_DEPT (ID,DEPTNAME,DESCN,LEAF,PARENT_ID) values (6,'西北大区',null,0,1);
Insert into T_DEPT (ID,DEPTNAME,DESCN,LEAF,PARENT_ID) values (7,'西南大区',null,0,1);
Insert into T_DEPT (ID,DEPTNAME,DESCN,LEAF,PARENT_ID) values (8,'西安分公司',null,1,6);
Insert into T_DEPT (ID,DEPTNAME,DESCN,LEAF,PARENT_ID) values (9,'汉中分公司',null,1,6);
Insert into T_DEPT (ID,DEPTNAME,DESCN,LEAF,PARENT_ID) values (10,'高陵分公司',null,1,8);
Insert into T_DEPT (ID,DEPTNAME,DESCN,LEAF,PARENT_ID) values (11,'高新分公司',null,1,8);
Insert into T_DEPT (ID,DEPTNAME,DESCN,LEAF,PARENT_ID) values (12,'雁塔分公司',null,1,8);

---------------------------------------------------
--   END DATA FOR TABLE T_DEPT
---------------------------------------------------

--------------------------------------------------------
--  Constraints for Table T_DEPT
--------------------------------------------------------

  ALTER TABLE "T_DEPT" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "T_DEPT" MODIFY ("DEPTNAME" NOT NULL ENABLE);
 
  ALTER TABLE "T_DEPT" ADD PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "T_DEPT" ADD CONSTRAINT "UK_97JL6TS8XPUQAASWLJV6P6VGJ" UNIQUE ("DEPTNAME") ENABLE;
--------------------------------------------------------
--  DDL for Index UK_97JL6TS8XPUQAASWLJV6P6VGJ
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_97JL6TS8XPUQAASWLJV6P6VGJ" ON "T_DEPT" ("DEPTNAME") 
  ;
--------------------------------------------------------
--  Ref Constraints for Table T_DEPT
--------------------------------------------------------

  ALTER TABLE "T_DEPT" ADD CONSTRAINT "FKGY98OHEEN3YX1L9QMDRN7NRI1" FOREIGN KEY ("PARENT_ID")
	  REFERENCES "T_DEPT" ("ID") ENABLE;
