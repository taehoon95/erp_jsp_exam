-- 내 스키마
DROP SCHEMA IF EXISTS erp_jsp_exam;

-- 내 스키마
CREATE SCHEMA erp_jsp_exam;

-- 부서
CREATE TABLE erp_jsp_exam.Department (
	DEPT_NO   INT         NOT NULL COMMENT '부서번호', -- 부서번호
	DEPT_NAME VARCHAR(20) NULL     COMMENT '부서명', -- 부서명
	FLOOR     INT         NULL     COMMENT '위치' -- 위치
)
COMMENT '부서';

-- 부서
ALTER TABLE erp_jsp_exam.Department
	ADD CONSTRAINT PK_Department -- 부서 기본키
		PRIMARY KEY (
			DEPT_NO -- 부서번호
		);

-- 사원
CREATE TABLE erp_jsp_exam.Employee (
	EMP_NO   INT         NOT NULL COMMENT '사원번호', -- 사원번호
	EMP_NAME VARCHAR(20) NULL     COMMENT '사원명', -- 사원명
	TNO      INT         NULL     COMMENT '직책', -- 직책
	MANAGER  INT         NULL     COMMENT '직속상사', -- 직속상사
	SALARY   INT         NULL     COMMENT '급여', -- 급여
	DNO      INT         NOT NULL COMMENT '부서', -- 부서
	HIREDATE DATE        NULL     COMMENT '입사일' -- 입사일
)
COMMENT '사원';

-- 사원
ALTER TABLE erp_jsp_exam.Employee
	ADD CONSTRAINT PK_Employee -- 사원 기본키
		PRIMARY KEY (
			EMP_NO -- 사원번호
		);

-- 직책
CREATE TABLE erp_jsp_exam.Title (
	TITLE_NO   INT         NOT NULL COMMENT '직책번호', -- 직책번호
	TITLE_NAME VARCHAR(20) NOT NULL COMMENT '직책명' -- 직책명
)
COMMENT '직책';

-- 직책
ALTER TABLE erp_jsp_exam.Title
	ADD CONSTRAINT PK_Title -- 직책 기본키
		PRIMARY KEY (
			TITLE_NO -- 직책번호
		);

-- 사원
ALTER TABLE erp_jsp_exam.Employee
	ADD CONSTRAINT FK_Department_TO_Employee -- 부서 -> 사원
		FOREIGN KEY (
			DNO -- 부서
		)
		REFERENCES erp_jsp_exam.Department ( -- 부서
			DEPT_NO -- 부서번호
		);

-- 사원
ALTER TABLE erp_jsp_exam.Employee
	ADD CONSTRAINT FK_Title_TO_Employee -- 직책 -> 사원
		FOREIGN KEY (
			TNO -- 직책
		)
		REFERENCES erp_jsp_exam.Title ( -- 직책
			TITLE_NO -- 직책번호
		);