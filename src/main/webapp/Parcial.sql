CREATE TABLE Students(
SID int not null,
"FIRST" varchar(15) not null,
"LAST" varchar(15) not null,
"EMAIL" varchar(30),
PRIMARY KEY (SID)


);


CREATE TABLE Exercises(
CAT character not null,
ENO int not null,
TOPIC varchar(20),
MAXPT int not null,
PRIMARY KEY (CAT,ENO)

);

CREATE TABLE RESULTS(
SID int not null,
CAT character not null,
ENO int not null,
POINTS int not null,
 
PRIMARY KEY(SID,CAT,ENO), 
FOREIGN KEY (SID) REFERENCES Students(SID),
FOREIGN KEY (CAT,ENO) REFERENCES Exercises(CAT,ENO)
);



INSERT  INTO Students VALUES (101,'Ann','Smith','....');
INSERT  INTO Students VALUES (102,'Michael','Jones',null);
INSERT  INTO Students VALUES (103, 'Richard', 'Turner',  '...');
INSERT  INTO Students VALUES (104,'Maria','Brown','....');


INSERT INTO EXERCIses VALUES('H',1,'Rel.ALG.',10);
INSERT INTO EXERCISES VALUES ('H',2,'SQL',10);
INSERT INTO EXERCISES VALUES ('M',1,'SQL',14);


INSERT INTO RESULTS VALUES(101,'H',1,10);
INSERT INTO RESULTS VALUES(101,'H',2,8);
INSERT INTO RESULTS VALUES(101,'M',1,12);
INSERT INTO RESULTS VALUES(102,'H',1,9);
INSERT INTO RESULTS VALUES(102,'H',2,9);

INSERT INTO RESULTS VALUES(102,'M',1,10);
INSERT INTO RESULTS VALUES(103,'H',1,5);
INSERT INTO RESULTS VALUES(103,'M',1,7);


 
 
 <-- Listar el nombre de los estudiantes que resolvieron todas las tareas. (CAT=H)-->
SELECT Students."FIRST" FROM Students NATURAL JOIN (SELECT SID FROM Results  WHERE Cat='H' GROUP BY(SID,CAT) HAVING (COUNT(SID))= (SELECT COUNT(Exercises.CAT)  FROM Exercises WHERE Exercises.cat='H')) AS T


 <-- QUien es el estudiante que tiene el mejor resultado promedio de las tareas (Máxima suma de los puntos de las taras con categoría H)-->
SELECT  Students.*  FROM Students NATURAL JOIN  (SELECT SID, AVG(POINTS) as prom FROM Results WHERE CAT='H' GROUP BY(SID,CAT) ORDER BY prom DESC LIMIT 1 ) AS T 
;

<---Resultado ultima consulta---->
SELECT RESULTS.CAT, RESULTS.ENO, ROUND(AVG(RESULTS.POINTS),2) AS rounded FROM RESULTS,(SELECT CAT,ENO FROM Exercises WHERE TOPIC='SQL')AS T WHERE T.CAT=RESULTS.CAT AND T.ENO=RESULTS.ENO GROUP BY (RESULTS.CAT,RESULTS.ENO)


 
 