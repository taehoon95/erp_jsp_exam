select e.emp_no, e.emp_name,
		t.title_No , t.title_Name,
		m.emp_no as managerNo, m.emp_name  as managerName,
		e.salary ,
		d.dept_no ,d.dept_name ,d.floor ,
		e.hiredate 
  from employee e join title t on e.TNO = t.TITLE_NO 
  left join  employee m on e.manager = m.emp_no 
  join department d on e.DNO = d.DEPT_NO ;

select EMP_NO,EMP_NAME,TNO,MANAGER,SALARY,DNO,HIREDATE from employee where EMP_NO = 4377;
INSERT INTO EMPLOYEE VALUES(1004, '이태훟', 2, 4377, 6000000, 2, '2021-04-09 16:24:43');
update employee set EMP_NO = 1004, EMP_NAME = '이태훈',
					TNO = 5, MANAGER = 3426, SALARY = 2000000,
					DNO = 3, HIREDATE = '2020-03-21 16:24:43'where EMP_NO = 1004;

delete from employee where EMP_NO = 1004;

update employee set EMP_NAME = '이태훈',
TNO as title_No = 4 ,
MANAGER  = 4377 as managerNo,
SALARY = 2000000,
DNO  = 2 as dept_No,
HIREDATE = '3921-04-05 00:00:00' where  EMP_NO = 1004
select EMP_NO,EMP_NAME,TNO as title_No,MANAGER,SALARY,DNO,HIREDATE from employee where EMP_NO = 4377