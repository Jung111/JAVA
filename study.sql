-- 데이터 전체 조회
SELECT * FROM emp ;
SELECT * from s_emp;

-- 데이터 입력 (INSERT)
INSERT INTO emp (id,name) VALUES (123,'sdss');
INSERT into emp (id,name,salary) VALUES(789,'gggg',7898585);
INSERT into emp (id,name,salary) VALUES(963,'tttt',44444);
INSERT into s_emp (id,name)VALUES(26,'이용호');

-- 데이터 수정(update)
UPDATE emp set id = 333 where id =123;

-- 데이터 삭제(delete)
DELETE from  emp  where salary=44444;


-- 산술식(사칙연산)을 이용한 검색 
SELECT name, salary, salary * 18 from s_emp;
SELECT id, id*100 from s_emp;
SELECT id , id/1 from s_emp;

-- 칼럼에 대한 alias(as) 부여
SELECT name, salary *18 as 연봉 from s_emp;

-- 칼럼의 합성 (합성 연산자 || 이용하여 다른 컬럼 값과 연결하여 하나로 출력가능)
SELECT name || '' || title from s_emp;
SELECT name || '' || title || '' || salary from s_emp;

-- 중복행제거 (distinct )
SELECT DISTINCT name from s_emp;

-- 정열순서 order by (asc :오름차순 , DESC :내림차순)
SELECT  DISTINCT salary as from s_emp ORDER by salary asc;
SELECT  DISTINCT salary as from s_emp ORDER by salary desc;

-- 특정행의 검색 where
SELECT name, dept_id from s_emp where name='이상헌'  ORDER by  name;

-- where  절에 사용 되는 연산자
select name , title, salary FROM s_emp where title ='사원' and salary BETWEEN 1000 and 2100;

-- 조건의 부정 (논리비교연산자, sql비교연산자)
SELECT id, name ,start_date from s_emp where start_date > '15/12/12' or start_date <'16/05/31';
SELECT name ,salary from  s_emp where salary >=3000;

