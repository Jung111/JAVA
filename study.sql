-- ������ ��ü ��ȸ
SELECT * FROM emp ;
SELECT * from s_emp;

-- ������ �Է� (INSERT)
INSERT INTO emp (id,name) VALUES (123,'sdss');
INSERT into emp (id,name,salary) VALUES(789,'gggg',7898585);
INSERT into emp (id,name,salary) VALUES(963,'tttt',44444);
INSERT into s_emp (id,name)VALUES(26,'�̿�ȣ');

-- ������ ����(update)
UPDATE emp set id = 333 where id =123;

-- ������ ����(delete)
DELETE from  emp  where salary=44444;


-- �����(��Ģ����)�� �̿��� �˻� 
SELECT name, salary, salary * 18 from s_emp;
SELECT id, id*100 from s_emp;
SELECT id , id/1 from s_emp;

-- Į���� ���� alias(as) �ο�
SELECT name, salary *18 as ���� from s_emp;

-- Į���� �ռ� (�ռ� ������ || �̿��Ͽ� �ٸ� �÷� ���� �����Ͽ� �ϳ��� ��°���)
SELECT name || '' || title from s_emp;
SELECT name || '' || title || '' || salary from s_emp;

-- �ߺ������� (distinct )
SELECT DISTINCT name from s_emp;

-- �������� order by (asc :�������� , DESC :��������)
SELECT  DISTINCT salary as from s_emp ORDER by salary asc;
SELECT  DISTINCT salary as from s_emp ORDER by salary desc;

-- Ư������ �˻� where
SELECT name, dept_id from s_emp where name='�̻���'  ORDER by  name;

-- where  ���� ��� �Ǵ� ������
select name , title, salary FROM s_emp where title ='���' and salary BETWEEN 1000 and 2100;

-- ������ ���� (���񱳿�����, sql�񱳿�����)
SELECT id, name ,start_date from s_emp where start_date > '15/12/12' or start_date <'16/05/31';
SELECT name ,salary from  s_emp where salary >=3000;

