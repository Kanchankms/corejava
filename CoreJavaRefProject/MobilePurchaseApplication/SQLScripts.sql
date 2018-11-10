


 CREATE SEQUENCE mobileid_seq
  START WITH     1004
  INCREMENT BY   1
  NOCACHE
  NOCYCLE;

CREATE TABLE mobiles (mobileid NUMBER PRIMARY KEY, name VARCHAR2 (20), price NUMBER(10,2),quantity VARCHAR2(20));



CREATE SEQUENCE custpurchaseid_seq
  START WITH     1
  INCREMENT BY   1
  NOCACHE
  NOCYCLE;
  
CREATE TABLE purchasedetails(purchaseid NUMBER PRIMARY KEY, cname VARCHAR2(20), mailid VARCHAR2(30),phoneno VARCHAR2(20), purchasedate DATE, mobileid references mobiles(mobileid));

