-- 4. �̸�(FIRST_NAME)�� M ���� �����ϴ� ����� ��� ������ ��ȸ�϶�.
SELECT * FROM EMPLOYEES WHERE FIRST_NAME LIKE 'M%'; 
SELECT FIRST_NAME,SALARY FROM EMPLOYEES WHERE FIRST_NAME LIKE '_a%';
SELECT CITY FROM LOCATIONS ORDER BY CITY;
-- 5. �̸�(FIRST_NAME)�� �� ��° ���ڰ� 'a'�� ����� �̸�(FIRST_NAME)�� ������ ��ȸ�϶�.

-- 6. ���� ���� �������� �����϶�.

-- 7. �μ� ���� �������� �����϶�.
SELECT DEPARTMENT_NAME FROM DEPARTMENTS ORDER BY DEPARTMENT_NAME DESC;
-- 8. ������ 7000 �̻��� ������� ��� ������ ������(��������)���� �����϶�.
SELECT * FROM EMPLOYEES WHERE SALARY >=7000 ORDER BY SALARY ASC;
-- 9. �μ�Ƽ��(COMMISSION_PCT)�� ���� �ʴ� ������� ��� ������ ��ȸ�϶�.
SELECT * FROM EMPLOYEES WHERE COMMISSION_PCT IS NULL;
-- 10. �μ�Ƽ��(COMMISSION_PCT)�� �޴� ������� ��� ������ ��ȸ�϶�.
SELECT * FROM EMPLOYEES WHERE COMMISSION_PCT IS NOT NULL;
-- 11. 2007�� 06�� 21�Ͽ� �Ի��� ����� �����ȣ, �̸�(FIRST_NAME, LAST_NAME) 
--      �׸��� �μ���ȣ�� ��ȸ�϶�.
SELECT EMPLOYEE_ID,FIRST_NAME, LAST_NAME,DEPARTMENT_ID FROM EMPLOYEES WHERE TO_DATE('07/06/21')=HIRE_DATE;
-- 12. 2006�⿡ �Ի��� ����� �����ȣ�� �Ի����� ��ȸ�϶�.**
--SELECT EMPLOYEE_ID,HIRE_DATE FROM EMPLOYEES WHERE 
-- 13. �̸�(FIRST_NAME)�� ���̰� 5���� �̻��� ����� ��ȸ�϶�.
SELECT FIRST_NAME FROM EMPLOYEES WHERE LENGTH(FIRST_NAME)>=5;
-- 14. �μ���ȣ�� ������� ��ȸ�϶�. (�μ���ȣ �������� ����)
SELECT DEPARTMENT_ID,COUNT(*)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID ASC;
-- 15. ���� ���̵� ��� ������ ��ȸ�϶�. (���� ���̵� �������� ����)
SELECT JOB_ID, AVG(SALARY) FROM EMPLOYEES GROUP BY JOB_ID ORDER BY JOB_ID DESC;
-- 16. ��簡 �ִ� ������� ��� ������ ��ȸ�϶�.
SELECT * FROM EMPLOYEES WHERE MANAGER_ID IS NOT NULL;
-- 17. ��簡 ���� ������� ��� ������ ��ȸ�϶�.
SELECT * FROM EMPLOYEES WHERE MANAGER_ID IS NULL;
-- 18. ��� ������� �����ȣ, �̸�(FIRST_NAME, LAST_NAME), �μ���ȣ 
--   �׸��� �μ����� ��ȸ�϶�.
SELECT E.EMPLOYEE_ID,E.FIRST_NAME, E.LAST_NAME,E.DEPARTMENT_ID,D.DEPARTMENT_NAME
FROM EMPLOYEES E JOIN DEPARTMENTS D ON  E.DEPARTMENT_ID = D.DEPARTMENT_ID;
-- 19. ��� �μ��� �μ���� ���ø��� ��ȸ�϶�.
SELECT D.DEPARTMENT_ID,D.DEPARTMENT_NAME,L.CITY FROM DEPARTMENTS D JOIN LOCATIONS L ON D.LOCATION_ID=L.LOCATION_ID;
-- 20. ��� ������� �����ȣ, �μ���, �������� ��ȸ�϶�.
SELECT E.EMPLOYEE_ID,D.DEPARTMENT_NAME,J.JOB_TITLE FROM EMPLOYEES E JOIN DEPARTMENTS D ON  E.DEPARTMENT_ID = D.DEPARTMENT_ID JOIN JOBS J ON E.JOB_ID=J.JOB_ID;
-- 21. ��� ������� �����ȣ, �μ���, ������, ���ø��� ��ȸ�϶�.
SELECT E.EMPLOYEE_ID,D.DEPARTMENT_NAME,E.JOB_ID,CITY FROM EMPLOYEES E JOIN DEPARTMENTS D ON  E.DEPARTMENT_ID = D.DEPARTMENT_ID JOIN LOCATIONS L ON D.LOCATION_ID=L.LOCATION_ID;
-- 22. 10��, 20��, 30�� �μ����� �ٹ��ϴ� ������� ��� ������ ��ȸ�϶�.
SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID IN(10,20,30);
-- 23. 6�� �̸��� ����� �ٹ��ϴ� �μ��� �̸��� ��ȸ�϶�.
SELECT DISTINCT D.DEPARTMENT_NAME FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID WHERE(SELECT COUNT(*)
                                                                                                                FROM EMPLOYEES EM
                                                                                                                WHERE E.DEPARTMENT_ID=EM.DEPARTMENT_ID)<=6;
-- 24. 4�� �̸��� ����� �ٹ��ϴ� �μ��� ��� ������ �μ����� ��ȸ�϶�.
SELECT ROUND(AVG(SALARY),2),DEPARTMENT_NAME
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID=D.DEPARTMENT_ID
GROUP BY DEPARTMENT_NAME;
-- 25. IT �μ��� ���� ������ ��ȸ�϶�.
SELECT SUM(SALARY) 
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID=D.DEPARTMENT_ID
WHERE DEPARTMENT_NAME='IT';
-- 26. �����(REGIONS)�� ������ ������ ��ȸ�϶�.
SELECT R.REGION_NAME, COUNT(L.CITY)
FROM LOCATIONS L JOIN COUNTRIES C ON L.COUNTRY_ID =C.COUNTRY_ID JOIN REGIONS R ON C.REGION_ID=R.REGION_ID
GROUP BY R.REGION_NAME;
-- 27. ���ø� �� �μ��� ������ ��ȸ�϶�.
SELECT L.CITY,COUNT(D.DEPARTMENT_ID)
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID=D.DEPARTMENT_ID JOIN LOCATIONS L ON D.LOCATION_ID=L.LOCATION_ID
GROUP BY L.CITY;
-- 28. �μ��� �������� �ʴ� ���ø� ��ȸ�϶�.
SELECT L.CITY
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID=D.DEPARTMENT_ID JOIN LOCATIONS L ON D.LOCATION_ID=L.LOCATION_ID
GROUP BY L.CITY HAVING COUNT(D.DEPARTMENT_ID)=0;
-- 29. ����� �������� �ʴ� ������ ��ȸ�϶�.
SELECT L.CITY
FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID=D.DEPARTMENT_ID JOIN LOCATIONS L ON D.LOCATION_ID=L.LOCATION_ID JOIN COUNTRIES C USING(COUNTRY_ID)
GROUP BY L.CITY HAVING COUNT(E.EMPLOYEE_ID)=0;
-- 30. 150�� ������� ���� �Ի��� ��� �� ���� �ֽſ� �Ի��� ����� ��� ������ ��ȸ�϶�.*****
SELECT *
FROM EMPLOYEES A 
WHERE A.EMPLOYEE_ID<>150 AND (A.HIRE_DATE-(SELECT B.HIRE_DATE
                                            FROM EMPLOYEES B
                                            WHERE B.EMPLOYEE_ID=150))>=0 
                                            ORDER BY A.HIRE_DATE ASC;
-- 31. ������ ��ȯ�� �̷��� �ִ� ����� ��� ������ ��ȸ�϶�.
SELECT * FROM EMPLOYEES E JOIN JOB_HISTORY H USING(EMPLOYEE_ID) WHERE E.JOB_ID<>H.JOB_ID;
-- 32. �μ��� �޴������� �ִ� ����� ��� ������ �μ����� ��ȸ�϶�.
SELECT *
FROM EMPLOYEES E JOIN DEPARTMENTS D USING(DEPARTMENT_ID)
WHERE E.EMPLOYEE_ID IN(SELECT MANAGER_ID
                        FROM DEPARTMENTS);
-- 33. �ٸ� ����� ����� ����� ��� ������ ��ȸ�϶�.
SELECT *
FROM EMPLOYEES E JOIN DEPARTMENTS D USING(DEPARTMENT_ID)
WHERE E.EMPLOYEE_ID IN(SELECT MANAGER_ID
                        FROM EMPLOYEES
                        GROUP BY MANAGER_ID)
                        ORDER BY DEPARTMENT_ID;
-- 34. �̸�(FIRST_NAME)�� C�� �����ϰ� s�� ������ 
--    ����� �μ���, ������, ���ø�, ������, ������� ��ȸ�϶�.
SELECT DEPARTMENT_NAME,JOB_TITLE,COUNTRY_NAME,REGION_NAME
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID) JOIN JOBS USING(JOB_ID) JOIN LOCATIONS USING(LOCATION_ID) JOIN COUNTRIES USING(COUNTRY_ID) JOIN REGIONS USING(REGION_ID)
WHERE FIRST_NAME LIKE 'C%s';

-- 35. ������ ��ȯ�� �̷��� ���� ����� ��� ������ ��ȸ�϶�.
SELECT *
FROM EMPLOYEES
WHERE EMPLOYEE_ID NOT IN(SELECT EMPLOYEE_ID
                        FROM JOB_HISTORY);
-- 36. �ڽ��� ��簡 �ڽ� ���� �ʰ� �Ի��� ����� ��� ������ ��ȸ�϶�.
SELECT *
FROM EMPLOYEES A
WHERE HIRE_DATE <(SELECT HIRE_DATE
                FROM EMPLOYEES B
                WHERE A.MANAGER_ID=B.EMPLOYEE_ID);
-- 37. 100�� ����� ���� ���� �ΰ� �ִ� ������� ��� ������ ��ȸ�϶�.
SELECT *
FROM EMPLOYEES
WHERE MANAGER_ID = 100;
-- 38. 100�� ����� ���� �ΰ� �ִ� ��� ������� ��� ������ ��ȸ�϶�. ������ ���� �̿�!
SELECT *
FROM EMPLOYEES
START WITH MANAGER_ID =100
CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID
ORDER BY SALARY;



-- 38-1. 112�� ����� ������ ��� ��ȸ�ض�
SELECT  *
FROM    EMPLOYEES 
START   WITH EMPLOYEE_ID = 112
CONNECT BY PRIOR MANAGER_ID = EMPLOYEE_ID;
-- 38-2. 150�� ����� ��� ������ �̸��� �μ����� ��ȸ�϶�
SELECT  E.FIRST_NAME,E.LAST_NAME,D.DEPARTMENT_NAME
FROM    EMPLOYEES E JOIN DEPARTMENTS D USING(DEPARTMENT_ID) 
START   WITH E.EMPLOYEE_ID = 150
CONNECT BY PRIOR E.MANAGER_ID = E.EMPLOYEE_ID;
-- 39. ������� ���� ���� ������ �̸��� ��ȸ�϶�.
SELECT CITY
FROM (SELECT L.CITY
FROM EMPLOYEES E JOIN DEPARTMENTS E USING(DEPARTMENT_ID)JOIN LOCATIONS L USING(LOCATION_ID) JOIN COUNTRIES C USING(COUNTRY_ID)
GROUP BY L.CITY
ORDER BY COUNT(*) DESC)
WHERE ROWNUM=1;
-- 40. ������ ������ ���� ���� �μ��� �̸��� ��ȸ�϶�.
SELECT DEPARTMENT_NAME
FROM(SELECT DEPARTMENT_NAME
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
GROUP BY DEPARTMENT_NAME
ORDER BY COUNT(JOB_ID) DESC
)
WHERE ROWNUM=1;
-- 41. ��� ������ �ִ� ������ �ް� �ִ� ������� ��� ������ ��ȸ�϶�.
SELECT *
FROM EMPLOYEES E JOIN JOBS J USING(JOB_ID)
WHERE E.SALARY=J.MAX_SALARY;

SELECT EA.*
FROM(
SELECT J.JOB_ID A, MAX(E.SALARY) B
FROM EMPLOYEES E JOIN JOBS J ON E.JOB_ID=J.JOB_ID
GROUP BY J.JOB_ID
),EMPLOYEES EA
WHERE EA.SALARY=B AND EA.JOB_ID=A;

-- 42. ��� ������ �ּ� ������ �ް� �ִ� ������� ��� ������ ��ȸ�϶�.
SELECT EA.*
FROM(
SELECT J.JOB_ID A,MIN(E.SALARY) B
FROM EMPLOYEES E JOIN JOBS J ON E.JOB_ID=J.JOB_ID
GROUP BY J.JOB_ID
),EMPLOYEES EA
WHERE EA.SALARY=B AND EA.JOB_ID=A;
-- 43. �μ��� ������ �ִ뿬��, �ּҿ���, ������� ��ȸ�϶�.
SELECT D.DEPARTMENT_NAME,J.JOB_ID A,MAX(SALARY), MIN(E.SALARY),COUNT(*) COUN
FROM EMPLOYEES E JOIN JOBS J ON E.JOB_ID=J.JOB_ID JOIN DEPARTMENTS D ON D.DEPARTMENT_ID=E.DEPARTMENT_ID
GROUP BY D.DEPARTMENT_NAME,J.JOB_ID
ORDER BY D.DEPARTMENT_NAME;

-- 44. ������� ���� ���� ���ÿ��� �ٹ��ϴ� ��� ������� ���� ������ ��ȸ�϶�.
    SELECT CITY,SU
    FROM(SELECT L.CITY,SUM(E.SALARY) SU
    FROM EMPLOYEES E JOIN DEPARTMENTS D USING(DEPARTMENT_ID) JOIN LOCATIONS L USING(LOCATION_ID)
    GROUP BY L.CITY
    ORDER BY COUNT(*) DESC
    )
    WHERE ROWNUM=1;
    
-- 45. ������� ���� ���� ���ÿ��� �ٹ��ϴ� ��� ������� �μ��� �� ������ ��� ������ ��ȸ�϶�.
    SELECT DISTINCT DEPARTMENT_NAME, ROUND(AVG(SALARY)OVER(PARTITION BY DEPARTMENT_NAME),2) �μ���տ���,JOB_ID,AVG(SALARY)OVER(PARTITION BY JOB_ID) ������տ���
    FROM (SELECT CITY
    FROM 
    (SELECT L.CITY
    FROM EMPLOYEES E JOIN DEPARTMENTS D USING(DEPARTMENT_ID) JOIN LOCATIONS L USING(LOCATION_ID)
    GROUP BY L.CITY
    ORDER BY COUNT(*) DESC
    )
    WHERE ROWNUM=1) JOIN LOCATIONS L USING(CITY)JOIN DEPARTMENTS D USING(LOCATION_ID) JOIN EMPLOYEES E USING(DEPARTMENT_ID);

-- 46. �Ի����� ���� ������ ����� ��ȸ�϶�.
SELECT *
FROM
(SELECT *
FROM EMPLOYEES
ORDER BY HIRE_DATE ASC)

WHERE ROWNUM=1;
-- 47. �Ի����� ���� �ֱ��� ����� ��ȸ�϶�.
SELECT *
FROM(SELECT *
    FROM EMPLOYEES
    ORDER BY HIRE_DATE DESC)
WHERE ROWNUM=1;
-- 48. ���� �ֱٿ� �Ի��� ����� ���� �������� �Ի��� ����� ������ ����� ��ȸ�϶�.
SELECT MAX(HIRE_DATE)-MIN(HIRE_DATE)
FROM EMPLOYEES;
-- 49. ���� �ֱٿ� �Ի��� ����� ���� �������� �Ի��� ����� �ð����� ����� ��ȸ�϶�.
SELECT (MAX(HIRE_DATE)-MIN(HIRE_DATE))*24
FROM EMPLOYEES;
-- 50. ������ 12000 �̻�Ǵ� �������� LAST_NAME �� ������ ��ȸ�Ѵ�.
SELECT LAST_NAME,SALARY
FROM EMPLOYEES
WHERE SALARY>=12000;
-- 51. �����ȣ�� 176 �� ����� LAST_NAME �� �μ� ��ȣ�� ��ȸ�Ѵ�.
SELECT LAST_NAME,DEPARTMENT_ID
FROM EMPLOYEES 
WHERE EMPLOYEE_ID=176;
-- 52. ������ 5000 ���� 12000�� ���� �̿��� ������� LAST_NAME �� ������ ��ȸ����.
SELECT LAST_NAME,SALARY FROM EMPLOYEES WHERE NOT (SALARY BETWEEN 5000 AND 12000);
-- 53. 2000/02/20 �Ϻ��� 2010/05/01 ���̿� ���� ������� LAST_NAME ���, ������ڸ� ��ȸ�Ѵ�.
SELECT LAST_NAME,EMPLOYEE_ID,HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN TO_DATE('2000/02/20') AND TO_DATE('2010/05/01')
ORDER BY HIRE_DATE;
-- 54. 20 �� �� 50 �� �μ����� �ٹ��ϴ� ��� ������� LAST_NAME �� 
--   �μ� ��ȣ�� ���ĺ������� ��ȸ�Ѵ�.
SELECT LAST_NAME,DEPARTMENT_ID
FROM EMPLOYEES 
WHERE DEPARTMENT_ID IN(20,50)
ORDER BY LAST_NAME,DEPARTMENT_ID ASC;
-- 55. 20 �� �� 50 �� �μ��� �ٹ��ϸ�, ������ 5000 ~ 12,000 ������ 
--   ������� LAST_NAME �� ������ ��ȸ�Ѵ�.
SELECT LAST_NAME,SALARY
FROM EMPLOYEES 
WHERE DEPARTMENT_ID IN(20,50) AND SALARY BETWEEN 5000 AND 12000;
-- 56. 2005�⵵�� ���� ��� ������� LAST_NAME �� ������� ��ȸ�Ѵ�.
SELECT LAST_NAME,HIRE_DATE
FROM EMPLOYEES
WHERE '05'=SUBSTR(TO_CHAR(HIRE_DATE),1,2);
-- 57. �Ŵ����� ���� ������� LAST_NAME �� JOB_ID �� ��ȸ�Ѵ�.
SELECT LAST_NAME, JOB_ID
FROM EMPLOYEES
WHERE MANAGER_ID IS NULL;
-- 58. �Ŵ����� �ִ� ������� LAST_NAME �� JOB_ID �� ��ȸ�Ѵ�.
SELECT LAST_NAME, JOB_ID
FROM EMPLOYEES
WHERE MANAGER_ID IS NOT NULL;
-- 59. Ŀ�̼��� ���� ��� ������� LAST_ANME, ���� �� Ŀ�̼��� ��ȸ�Ѵ�.
--    ���� ����, Ŀ�̼� �������� �����Ѵ�.
SELECT LAST_NAME,SALARY,COMMISSION_PCT*SALARY
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;
-- 60. LAST_NAME �� �׹�° ���ڰ� a �� ������� LAST_NAME �� ��ȸ�Ѵ�.
SELECT LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME LIKE '___a%';
-- 61. LAST_NAME �� a ��(OR) e ���ڰ� �ִ� ������� LAST_NAME �� ��ȸ�Ѵ�. ****
SELECT LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME LIKE '___a%' OR LAST_NAME LIKE '___e%';
-- 62. ������ 2,500, 3,500, 7000 �� �ƴϸ� 
-- ������ SA_REP �̳� ST_CLERK �� ������� ��ȸ�Ѵ�.
SELECT *
FROM EMPLOYEES
WHERE JOB_ID IN('SA_REP','ST_CLERK') AND SALARY NOT IN(2500,3500,7000);
-- 63.  ������ AD_PRESS �� ����� A �����, 
--  ST_MAN �� ����� B �����, IT_PROG �� ����� C �����,
--  SA_REP �� ����� D �����, ST_CLERK �� ����� E ����� 
--  ��Ÿ�� 0 �� �ο��Ͽ� ��ȸ�Ѵ�.
SELECT  DECODE(JOB_ID,'AD_PRESS','A','ST_MAN','B','IT_PROG','C','SA_REP','D','ST_CLERK','E','0') ���, A.*
FROM EMPLOYEES A
ORDER BY ���;
-- 64. ��� ������� LAST_NAME, �μ� �̸� �� �μ� ��ȣ�� ��ȸ�Ѵ�.
SELECT LAST_NAME,DEPARTMENT_NAME,DEPARTMENT_ID
FROM EMPLOYEES JOIN DEPARTMENTS D USING(DEPARTMENT_ID);
-- 65. �μ���ȣ 30 ���� ��� �������� ������ �������� ��ȸ�Ѵ�. 90 �μ� ���� �����Ѵ�.

SELECT DEPARTMENT_ID,JOB_ID,JOB_TITLE
FROM EMPLOYEES E JOIN JOBS J USING(JOB_ID)
GROUP BY DEPARTMENT_ID,JOB_ID,JOB_TITLE HAVING  DEPARTMENT_ID IN(30,90)
ORDER BY DEPARTMENT_ID,JOB_ID;
-- 66. Ŀ�̼��� ���� ��� ������� LAST_NAME, �μ� ��, ���� ID �� ���� ���� ��ȸ�Ѵ�.
SELECT LAST_NAME, DEPARTMENT_NAME,LOCATION_ID,CITY
FROM EMPLOYEES E JOIN DEPARTMENTS D USING(DEPARTMENT_ID) JOIN LOCATIONS USING(LOCATION_ID)
WHERE COMMISSION_PCT IS NOT NULL;
-- 66-1. �þ�Ʋ�� ��� ��� �� Ŀ�̼��� ���� ��� ������� LAST_NAME, �μ� ��, ���� ID �� ���� ���� ��ȸ�Ѵ�. ������==�ٹ����� ��츦 ����
SELECT LAST_NAME,DEPARTMENT_NAME,LOCATION_ID,CITY
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID) JOIN LOCATIONS USING(LOCATION_ID)
WHERE COMMISSION_PCT IS NOT NULL;
-- 67. LAST_NAME �� DAVIES �� ������� �Ŀ� ���� ������� LAST_NAME �� HIRE_DATE �� ��ȸ�Ѵ�. DAVIES�� �̸����� ������ �ִ� ����� ������ ��쵵 ���
SELECT LAST_NAME,HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE>ANY(SELECT HIRE_DATE
                            FROM EMPLOYEES
                            WHERE UPPER(LAST_NAME)='DAVIES');
-- 68. �ڽ��� �Ŵ������� ���� ���� ������� LAST_NAME �� ������� ��ȸ�Ѵ�.
SELECT LAST_NAME,HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE<ANY(SELECT HIRE_DATE
                            FROM EMPLOYEES
                            WHERE UPPER(LAST_NAME)='DAVIES');
-- 69. ȸ�� ��ü�� �ִ� ����, �ּ� ����, ���� �� �� �� ��� ������ �ڿ����� �����Ͽ� ��ȸ�Ѵ�. ����ó��
SELECT MAX(MA) �ִ뿬��,MIN(MI) �ּҿ���,SUM(SU) ��������,FLOOR(AVG(AV)) ��տ���
FROM(
SELECT DEPARTMENT_ID, MAX(SALARY) MA,MIN(SALARY) MI,SUM(SALARY) SU,FLOOR(AVG(SALARY)) AV
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
GROUP BY DEPARTMENT_ID
);
-- 70. �� JOB_ID ��, �ִ� ����, �ּ� ����, ���� �� �� �� ��� ������ �ڿ����� �����Ͽ� ��ȸ�Ѵ�.
SELECT JOB_ID,MAX(SALARY) �ִ뿬��,MIN(SALARY) �ּҿ���,SUM(SALARY) ��������,FLOOR(AVG(SALARY)) ��տ���
FROM EMPLOYEES
GROUP BY JOB_ID;
-- 71. ������ ������ ���� ������� �� ���� ��ȸ�Ѵ�.
SELECT SUM(CO) ������ġ�»����
FROM(SELECT JOB_ID,COUNT(*) CO
FROM EMPLOYEES
GROUP BY JOB_ID HAVING COUNT(*)>1);
-- 72. �Ŵ����� �ٹ��ϴ� ������� �� ���� ��ȸ�Ѵ�.
SELECT COUNT(MA)
FROM(SELECT MANAGER_ID MA
FROM EMPLOYEES
GROUP BY MANAGER_ID);
-- 73. �系�� �ִ� ���� �� �ּ� ������ ���̸� ��ȸ�Ѵ�.
SELECT MAX(SALARY)-MIN(SALARY) ����
FROM EMPLOYEES;
-- 74. �Ŵ����� ��� �� �� �Ŵ��� �� ����� �� �ּ� ������ �޴� ����� ������ ��ȸ�Ѵ�. DISTICT �ᵵ �Ǳ� �� �Ϻη� GROUP BY ��
--     �Ŵ����� ���� ������� �����Ѵ�.
--     �ּ� ������ 6000 �̸��� ���� �����Ѵ�.
--     ���� ���� �������� ��ȸ�Ѵ�.
SELECT MANAGER_ID ,MSAL
FROM(SELECT MANAGER_ID , (SELECT MIN(SALARY)
                        FROM EMPLOYEES B
                        START WITH B.MANAGER_ID=A.MANAGER_ID
                        CONNECT BY PRIOR B.EMPLOYEE_ID=B.MANAGER_ID) MSAL
FROM EMPLOYEES A
GROUP BY MANAGER_ID HAVING MANAGER_ID IS NOT NULL
ORDER BY MSAL DESC)
WHERE MSAL>=6000;
-- 75. �μ� ��, ��ġ ID, �� �μ� �� ��� �� ��, �� �μ� �� ��� ������ ��ȸ�Ѵ�.
--     ��� ������ �Ҽ��� 2 �ڸ������� ǥ���Ѵ�.
SELECT DISTINCT DEPARTMENT_NAME �μ���,LOCATION_ID ����ID,COUNT(*) �����,ROUND(AVG(SALARY),2) ��տ���
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
GROUP BY DEPARTMENT_NAME,LOCATION_ID;
-- 76. �� ��� �� �� 2001, 2003, 2005, 2006 �⵵ �� ���� ������� �� ���� ������ ���� ��ȸ�Ѵ�.**
SELECT TO_CHAR(HIRE_DATE,'YY'),COUNT(*)
FROM EMPLOYEES
GROUP BY TO_CHAR(HIRE_DATE,'YY') HAVING TO_CHAR(HIRE_DATE,'YY') IN(01,03,05,06);

-- 77.  �� �μ��� �� ���� �� ���� �� �� �� �� �μ��� ���� �� ���� ��ȸ�Ѵ�. 
SELECT DISTINCT DEPARTMENT_ID,SUM(SALARY)OVER(PARTITION BY DEPARTMENT_ID),SUM(SALARY)OVER(PARTITION BY JOB_ID)
FROM EMPLOYEES
ORDER BY DEPARTMENT_ID;

-- 78. LAST_NAME �� Zlotkey �� ������ �μ��� �ٹ��ϴ� ��� ������� ��� �� ��볯¥�� ��ȸ�Ѵ�.
--     ��������� Zlotkey �� �����Ѵ�.
SELECT EMPLOYEE_ID,HIRE_DATE
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN(SELECT DEPARTMENT_ID
FROM EMPLOYEES
WHERE LAST_NAME='Zlotkey');
-- 79. ȸ�� ��ü ��� �������� �� �޴� ������� ��� �� LAST_NAME �� ��ȸ�Ѵ�.
SELECT EMPLOYEE_ID,LAST_NAME,SALARY
FROM EMPLOYEES
WHERE SALARY>(SELECT AVG(SALARY)
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID))
ORDER BY EMPLOYEE_ID;  
-- 80. LAST_NAME �� u �� ���ԵǴ� ������ ���� �μ��� �ٹ��ϴ� ������� ��� �� LAST_NAME �� ��ȸ�Ѵ�.**
SELECT EMPLOYEE_ID,LAST_NAME
FROM EMPLOYEES
WHERE DEPARTMENT_ID=ANY(SELECT DEPARTMENT_ID
                        FROM EMPLOYEES
                        WHERE LAST_NAME LIKE '%u%');
-- 81. (VIEW �̿�) LAST_NAME �� u �� ���ԵǴ� ������ ���� �μ��� �ٹ��ϴ� ������� ��� �� LAST_NAME �� ��ȸ�Ѵ�.
SELECT EMPLOYEE_ID,LAST_NAME
FROM EMP_DETAILS_VIEW
WHERE DEPARTMENT_ID=ANY(SELECT DEPARTMENT_ID
FROM EMP_DETAILS_VIEW
WHERE LAST_NAME LIKE '%u%');
-- 82. ��ġ ID �� 1700 �� �μ����� �ٹ��ϴ� ������� LAST_NAME, �μ� ��ȣ �� JOB_ID �� ��ȸ�Ѵ�.**
SELECT DEPARTMENT_ID,JOB_ID
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID) JOIN LOCATIONS USING(LOCATION_ID)
WHERE LOCATION_ID=1700;
-- 83. (VIEW �̿�)��ġ ID �� 1700 �� �μ����� �ٹ��ϴ� ������� LAST_NAME, �μ� ��ȣ �� JOB_ID �� ��ȸ�Ѵ�.
SELECT DEPARTMENT_ID,JOB_ID
FROM EMP_DETAILS_VIEW
WHERE LOCATION_ID=1700;
-- 84. King �� �Ŵ����� �ΰ� �ִ� ��� ������� LAST_NAME �� ������ ��ȸ�Ѵ�.
SELECT LAST_NAME,SALARY
FROM EMPLOYEES
WHERE MANAGER_ID = ANY(SELECT EMPLOYEE_ID
                    FROM EMPLOYEES
                    WHERE LAST_NAME='King')
ORDER BY LAST_NAME;


-- 85. EXECUTIVE �μ��� �ٹ��ϴ� ��� ������� �μ� ��ȣ, LAST_NAME, JOB_ID �� ��ȸ�Ѵ�.
SELECT DEPARTMENT_ID,LAST_NAME,JOB_ID
FROM EMPLOYEES E JOIN DEPARTMENTS D USING(DEPARTMENT_ID)
WHERE UPPER(DEPARTMENT_NAME)='EXECUTIVE';
-- 86. ȸ�� ��ü ��� ���� ���� �� ���� ����� �� LAST_NAME �� u �� �ִ� �������
--       �ٹ��ϴ� �μ����� �ٹ��ϴ� ������� ���, LAST_NAME �� ������ ��ȸ�Ѵ�.
SELECT EMPLOYEE_ID,LAST_NAME,SALARY
FROM EMPLOYEES
WHERE DEPARTMENT_ID = ANY(SELECT DEPARTMENT_ID
                        FROM EMPLOYEES
                        WHERE LAST_NAME LIKE '%u%' AND SALARY>(SELECT AVG(SALARY)
                                                                FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)));

-- 87. (VIEW �̿�)ȸ�� ��ü ��� ���� ���� �� ���� ����� �� LAST_NAME �� u �� �ִ� �������
--       �ٹ��ϴ� �μ����� �ٹ��ϴ� ������� ���, LAST_NAME �� ������ ��ȸ�Ѵ�.
SELECT EMPLOYEE_ID,LAST_NAME,SALARY
FROM EMP_DETAILS_VIEW
WHERE DEPARTMENT_ID = ANY(SELECT DEPARTMENT_ID
                        FROM EMP_DETAILS_VIEW
                        WHERE LAST_NAME LIKE '%u%' AND SALARY>(SELECT AVG(SALARY)
                                                                FROM EMP_DETAILS_VIEW));
-- 88. ST_CLERK �� ���� ID �� ���� ����� ���� �μ� ID �� ��ȸ�Ѵ�. ****** 50���� ���;� ����..
--       NULL ���� �����Ѵ�. (NOT EXISTS ���)            
SELECT DEPARTMENT_ID
FROM EMPLOYEES EA
GROUP BY DEPARTMENT_ID HAVING DEPARTMENT_ID IS NOT NULL AND NOT EXISTS(SELECT 1
                                        FROM EMPLOYEES EB
                                        GROUP BY DEPARTMENT_ID,JOB_ID HAVING EA.DEPARTMENT_ID=EB.DEPARTMENT_ID AND EB.JOB_ID ='ST_CLERK')
ORDER BY DEPARTMENT_ID;
                                        
-- 89. ST_CLERK �� ���� ID �� ���� ����� �ִ� �μ� ID �� ��ȸ�Ѵ�.
--       NULL ���� �����Ѵ�. (NOT EXISTS ���)
SELECT DEPARTMENT_ID
FROM EMPLOYEES EA
GROUP BY DEPARTMENT_ID HAVING DEPARTMENT_ID IS NOT NULL AND NOT( NOT EXISTS(SELECT 1
                                        FROM EMPLOYEES EB
                                        GROUP BY DEPARTMENT_ID,JOB_ID HAVING EA.DEPARTMENT_ID=EB.DEPARTMENT_ID AND EB.JOB_ID='ST_CLERK'))
ORDER BY DEPARTMENT_ID;


-- 90. ��ġ�� �μ��� ���� ���� ID �� ���� �̸��� ��ȸ����.(NOT EXISTS ���)
SELECT C.COUNTRY_ID,C.COUNTRY_NAME
FROM COUNTRIES C
WHERE NOT EXISTS(SELECT 1
                FROM LOCATIONS L LEFT JOIN DEPARTMENTS D ON L.LOCATION_ID =D.LOCATION_ID
                WHERE C.COUNTRY_ID=L.COUNTRY_ID AND D.LOCATION_ID IS NULL);
-- 91. ��ġ�� �μ��� �ִ� ���� ID �� ���� �̸��� ��ȸ����.(EXISTS ���)
SELECT C.COUNTRY_ID,C.COUNTRY_NAME
FROM COUNTRIES C
WHERE EXISTS(SELECT 1
                FROM LOCATIONS L LEFT JOIN DEPARTMENTS D ON L.LOCATION_ID =D.LOCATION_ID
                WHERE C.COUNTRY_ID=L.COUNTRY_ID AND D.LOCATION_ID IS NULL);
-- 92. ������ ������ ������ ������ �ִ� ������� ��� �� JOB_ID �� ��ȸ�Ѵ�.
SELECT EMPLOYEE_ID,JOB_ID
FROM EMPLOYEES E
WHERE EXISTS(SELECT 1
            FROM JOB_HISTORY JH
            WHERE JH.EMPLOYEE_ID IN(E.EMPLOYEE_ID,NULL));
-- 93. Ŀ�̼��� ���� ������� �μ��� ������ ������ ������� LAST_NAME, �μ� ��ȣ �� ������ ��ȸ�Ѵ�.
SELECT LAST_NAME,DEPARTMENT_ID,SALARY
FROM EMPLOYEES
WHERE SALARY= ANY(SELECT SALARY
                    FROM EMPLOYEES
                    WHERE COMMISSION_PCT IS NOT NULL);
-- 94. ��ġ ID �� 1700 �� ������� ������ Ŀ�̼��� ������ ������� LAST_NAME, �μ� ��ȣ �� ������ ��ȸ�Ѵ�. 
    --1��° ����
    SELECT LAST_NAME,DEPARTMENT_ID,SALARY
    FROM(SELECT SALARY SAL,COMMISSION_PCT COMM
    FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID) JOIN LOCATIONS USING(LOCATION_ID)
    WHERE LOCATION_ID=1700) RA,EMPLOYEES RB
    WHERE RA.SAL=RB.SALARY AND NVL(RA.COMM,0)=NVL(RB.COMMISSION_PCT,0);
    --2��° ����
   SELECT LAST_NAME,DEPARTMENT_ID,SALARY
   FROM EMPLOYEES A
   WHERE EXISTS(SELECT 1
    FROM EMPLOYEES E JOIN DEPARTMENTS D USING(DEPARTMENT_ID) JOIN LOCATIONS L USING(LOCATION_ID)
    WHERE LOCATION_ID=1700 AND E.SALARY=A.SALARY AND NVL(E.COMMISSION_PCT,0)=NVL(A.COMMISSION_PCT,0));
-- 95. LAST_NAME �� 'Kochhar' �� ����� ������ ���� �� Ŀ�̼��� ���� ������� LAST_NAME, �μ� ��ȣ �� ������ ��ȸ�Ѵ�.
    SELECT LAST_NAME,DEPARTMENT_ID,SALARY
    FROM(SELECT SALARY SAL,COMMISSION_PCT COMM
    FROM EMPLOYEES
    WHERE LAST_NAME='Kochhar') RA,EMPLOYEES RB
    WHERE RA.SAL=RB.SALARY AND NVL(RA.COMM,0)=NVL(RB.COMMISSION_PCT,0);
-- 96. ���� ID �� SA_MAN �� ������� ���� �� �ִ� �ִ� ���� ���� ���� �޴� ������� LAST_NAME, JOB_ID �� ������ ��ȸ�Ѵ�.
SELECT LAST_NAME,JOB_ID,SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT MAX(SALARY)
                    FROM EMPLOYEES
                    WHERE JOB_ID='SA_MAN');
-- 97. ���� �̸��� T �� �����ϴ� ������ ��� ������� ���, LAST_NAME �� �μ� ��ȣ�� ��ȸ�Ѵ�. (������=�ٹ��� �� ��� ���)
SELECT EMPLOYEE_ID,LAST_NAME,DEPARTMENT_ID
FROM EMPLOYEES E JOIN DEPARTMENTS D USING(DEPARTMENT_ID) JOIN LOCATIONS L USING(LOCATION_ID)
WHERE L.CITY LIKE 'T%';
-- 98.  �� �μ��� ��� �������� �� �޴� ���Ϻμ� �ٹ��������
--      LAST_NAME, ����, �μ���ȣ �� �ش� �μ��� ��� ������ ��ȸ�Ѵ�.
--      ����� �μ��� ������ �������� �����Ѵ�.
SELECT  LAST_NAME,SALARY,D_ID,AVSAL
FROM(SELECT DEPARTMENT_ID D_ID, FLOOR(AVG(SALARY)) AVSAL
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID HAVING DEPARTMENT_ID IS NOT NULL) RA,EMPLOYEES RB
WHERE RA.D_ID=RB.DEPARTMENT_ID AND RB.SALARY>RA.AVSAL 
ORDER BY D_ID,AVSAL;
-- 99. �ҼӺμ��� ��� �������� ���� ���� ������� last_name �� ��ȸ�Ѵ�.
SELECT LAST_NAME
FROM (SELECT DEPARTMENT_ID D_ID, FLOOR(AVG(SALARY)) AVSAL
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID HAVING DEPARTMENT_ID IS NOT NULL) RA ,EMPLOYEES RB
WHERE RA.D_ID=RB.DEPARTMENT_ID AND RB.SALARY<RA.AVSAL;
-- 100. �� ��� �� �ҼӺμ����� �ڽź��� �ʰ� ���Ǿ����� ���� ���� ������ �޴� ����� �����ϴ� ��� ������� last_name �� ��ȸ�Ѵ�.
SELECT LAST_NAME
FROM EMPLOYEES EA
WHERE EXISTS(SELECT 1
            FROM EMPLOYEES EB
            WHERE (SYSDATE-EA.HIRE_DATE)>(SYSDATE-EB.HIRE_DATE) AND EA.SALARY<EB.SALARY
    );
--101. ��å(Job Title)�� Sales Manager�� ������� �Ի�⵵�� �Ի�⵵(hire_date)�� ��� �޿��� ����Ͻÿ�. 
--   ��� �� �⵵�� �������� �������� �����Ͻÿ�. 
    SELECT TO_CHAR(HIRE_DATE,'YY') �⵵, FLOOR(AVG(SALARY)) �޿����
    FROM EMPLOYEES E JOIN JOBS J USING(JOB_ID)
    WHERE JOB_TITLE='Sales Manager'
    GROUP BY TO_CHAR(HIRE_DATE,'YY');
    

--102. �� ����(city)�� �ִ� ��� �μ� �������� ��ձ޿��� ��ȸ�ϰ��� �Ѵ�. 
--   ��ձ޿��� ���� ���� ���ú��� ���ø�(city)�� ��տ���, �ش� ������ �������� ����Ͻÿ�. 
--   ��, ���ÿ� �� ���ϴ� ������ 10�� �̻��� ���� �����ϰ� ��ȸ�Ͻÿ�.
SELECT CITY ����,FLOOR(AVG(SALARY)) ��ձ޿�,COUNT(*) �����
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID) JOIN LOCATIONS USING(LOCATION_ID)
GROUP BY CITY HAVING COUNT(*)<10
ORDER BY AVG(SALARY);
--103. ��Public  Accountant���� ��å(job_title)���� ���ſ� �ٹ��� ���� �ִ� ��� ����� ����� �̸��� ����Ͻÿ�. 
--   (���� ��Public Accountant���� ��å(job_title)���� �ٹ��ϴ� ����� ��� ���� �ʴ´�.)      
--   �̸��� first_name, last_name�� �Ʒ��� �������� ���� ����Ѵ�.
SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,JOB_ID
FROM EMPLOYEES EA JOIN JOBS USING(JOB_ID)
WHERE JOB_TITLE<>'Public Accountant' AND EXISTS(SELECT 1
                                                FROM JOBS J JOIN JOB_HISTORY JH USING(JOB_ID)
                                                WHERE EA.EMPLOYEE_ID=JH.EMPLOYEE_ID AND JOB_TITLE='Public Accountant');

--104. �ڽ��� �Ŵ������� ����(salary)�� ���� �޴� �������� ��(last_name)�� ����(salary)�� �� ���Ͻÿ�. 
SELECT EA.LAST_NAME,EA.SALARY
FROM EMPLOYEES EA JOIN EMPLOYEES EB ON EA.MANAGER_ID=EB.EMPLOYEE_ID
WHERE EA.SALARY>EB.SALARY;

--105. 2007�⿡ �Ի�(hire_date)�� �������� ���(employee_id), �̸�(first_name), ��(last_name), 
--   �μ���(department_name)�� ��ȸ�մϴ�.  
--   �̶�, �μ��� ��ġ���� ���� ������ ���, ��<Not Assigned>���� ����Ͻÿ�. 
SELECT EMPLOYEE_ID ���,FIRST_NAME �̸�,LAST_NAME ��,NVL(DEPARTMENT_NAME,'<Not Assigned>') �ҼӺμ�
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
WHERE TO_CHAR(HIRE_DATE,'YY')='07';

--106. ������(job_title)�� ��Sales Representative���� ���� �߿��� ����(salary)�� 9,000�̻�, 10,000 ������ 
--   �������� �̸�(first_name), ��(last_name)�� ����(salary)�� ����Ͻÿ�
SELECT FIRST_NAME,LAST_NAME,SALARY
FROM EMPLOYEES E JOIN JOBS J USING(JOB_ID)
WHERE JOB_TITLE='Sales Representative' AND (SALARY BETWEEN 9000 AND 10000);

--107. �μ����� ���� ���� �޿��� �ް� �ִ� ������ �̸�, �μ��̸�, �޿��� ����Ͻÿ�. 
--   �̸��� last_name�� ����ϸ�, �μ��̸����� �������� �����ϰ�, 
--   �μ��� ���� ��� �̸��� ���� ���� �������� �����Ͽ� ����մϴ�. 
SELECT LAST_NAME,DEPARTMENT_NAME,SALARY
FROM EMPLOYEES EA JOIN DEPARTMENTS D ON EA.DEPARTMENT_ID=D.DEPARTMENT_ID
WHERE SALARY=(SELECT MIN(SALARY)
            FROM EMPLOYEES EB
            GROUP BY DEPARTMENT_ID HAVING EB.DEPARTMENT_ID=EA.DEPARTMENT_ID);


--108. EMPLOYEES ���̺��� �޿��� ���� �޴� ������� ��ȸ���� �� ���ó�� 6��°���� 10 ��°���� 
--   5���� last_name, first_name, salary�� ��ȸ�ϴ� sql������ �ۼ��Ͻÿ�.****
SELECT LAST_NAME,FIRST_NAME,SALARY,R
FROM(SELECT LAST_NAME,FIRST_NAME,SALARY,DENSE_RANK()OVER(ORDER BY SALARY,FIRST_NAME,LAST_NAME) R
FROM EMPLOYEES)
WHERE R BETWEEN 6 AND 10;
--109. ����� �μ��� ���� ����(city)�� ��Seattle���� ����� �̸�, �ش� ����� �Ŵ��� �̸�, ��� �� �μ��̸��� ����Ͻÿ�. 
--   �̶� ����� �Ŵ����� ���� ��� ��<����>���̶�� ����Ͻÿ�. �̸��� last_name�� ����ϸ�, 
--   ����� �̸��� ������������ �����Ͻÿ�. 
SELECT EA.LAST_NAME,NVL(EB.LAST_NAME,'<����>'),D.DEPARTMENT_NAME
FROM EMPLOYEES EA LEFT JOIN EMPLOYEES EB ON EA.MANAGER_ID=EB.EMPLOYEE_ID JOIN DEPARTMENTS D ON EA.DEPARTMENT_ID=D.DEPARTMENT_ID JOIN LOCATIONS L USING(LOCATION_ID)
WHERE L.CITY='Seattle';

--110. �� ����(job) ���� ����(salary)�� ������ ���ϰ��� �Ѵ�. ���� ������ ���� ���� �������� 
--    ������(job_title)�� ���� ������ ��ȸ�Ͻÿ�. �� ���������� 30,000���� ū ������ ����Ͻÿ�. 
SELECT JOB_TITLE,SUM(SALARY)
FROM EMPLOYEES JOIN JOBS USING(JOB_ID)
GROUP BY JOB_TITLE HAVING SUM(SALARY)>30000
ORDER BY SUM(SALARY) DESC;
--111. �� ���(employee)�� ���ؼ� ���(employee_id), �̸�(first_name), ������(job_title), 
--    �μ� ��(department_name)�� ��ȸ�Ͻÿ�. 
--    �� ���ø�(city)�� ��Seattle���� ����(location)�� �μ� (department)�� �ٹ��ϴ� ������ �����ȣ �������������� ����Ͻÿ�.
SELECT EMPLOYEE_ID,FIRST_NAME,JOB_TITLE,DEPARTMENT_ID
FROM EMPLOYEES JOIN JOBS USING(JOB_ID) JOIN DEPARTMENTS USING(DEPARTMENT_ID) JOIN LOCATIONS USING(LOCATION_ID)
WHERE CITY='Seattle'
ORDER BY EMPLOYEE_ID;
--112. 2001~20003����̿� �Ի��� ������ �̸�(first_name), �Ի���(hire_date), �����ڻ�� (employee_id), 
--    ������ �̸�(fist_name)�� ��ȸ�մϴ�. ��, �����ڰ� ���� ��������� ��� ����� ���Խ��� ����Ѵ�.
SELECT EA.FIRST_NAME,EA.HIRE_DATE,EA.EMPLOYEE_ID,EB.FIRST_NAME,EB.FIRST_NAME
FROM EMPLOYEES EA JOIN EMPLOYEES EB ON EA.MANAGER_ID=EB.EMPLOYEE_ID
WHERE TO_CHAR(EA.HIRE_DATE,'YY') IN ('01','02','03');

--113. ��Sales�� �μ��� ���� ������ �̸�(first_name), �޿�(salary), �μ��̸�(department_name)�� ��ȸ�Ͻÿ�. 
--    ��, �޿��� 100�� �μ��� ��պ��� ���� �޴� ���� ������ ��µǾ�� �Ѵ�. 
SELECT FIRST_NAME,SALARY,DEPARTMENT_NAME
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
WHERE DEPARTMENT_NAME='Sales' AND SALARY<(SELECT AVG(SALARY)
                                        FROM EMPLOYEES
                                        WHERE DEPARTMENT_ID=100);
--114. Employees ���̺��� �Ի��Ѵ�(hire_date)���� �ο����� ��ȸ�Ͻÿ�.
SELECT TO_CHAR(HIRE_DATE,'YY/MM') �Ի��Ѵ�, COUNT(1) �ο��� 
FROM EMPLOYEES
GROUP BY TO_CHAR(HIRE_DATE,'YY/MM');
--115. �μ��� �������� �ִ�, �ּ�, ��ձ޿��� ��ȸ�ϵ�, 
--    ��ձ޿��� ��IT�� �μ��� ��ձ޿����� ����, ��Sales�� �μ��� ��պ��� ���� �μ� ������ ����Ͻÿ�. 
SELECT DEPARTMENT_ID,MAX(SALARY),MIN(SALARY),AVG(SALARY)
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
GROUP BY DEPARTMENT_ID HAVING AVG(SALARY) BETWEEN (SELECT AVG(SALARY)
                                            FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
                                            WHERE DEPARTMENT_NAME='IT') AND (SELECT AVG(SALARY)
                                                                            FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
                                                                            WHERE DEPARTMENT_NAME='Sales');
                                            

--116. �� �μ����� ������ �Ѹ� �ִ� �μ��� ��ȸ�Ͻÿ�. 
--    ��, ������ ���� �μ��� ���ؼ��� ��<�Ż��μ�>����� ���ڿ��� ��µǵ��� �ϰ�,
--    ��°���� ������ ���� �μ����� �������� ���� ���ĵǾ���Ѵ�. 
SELECT DEPARTMENT_NAME, (CASE 
                        WHEN COUNT(EMPLOYEE_ID)=0 THEN '<�Ż��μ�>'
                        ELSE '<�ִ� �μ�>'
                        END)
FROM EMPLOYEES RIGHT JOIN DEPARTMENTS USING(DEPARTMENT_ID)
GROUP BY DEPARTMENT_NAME HAVING COUNT(EMPLOYEE_ID) <=1
ORDER BY DEPARTMENT_NAME DESC;

--117. �μ��� �Ի���� �������� ����Ͻÿ�.
--    ��, �������� 5�� �̻��� �μ��� ��µǾ�� �ϸ� ��°���� �μ��̸� ������ �Ѵ�.
SELECT EA.DEPARTMENT_ID �μ�,TO_CHAR(EA.HIRE_DATE,'YY/MM'),COUNT(*)
FROM EMPLOYEES EA JOIN DEPARTMENTS D ON EA.DEPARTMENT_ID=D.DEPARTMENT_ID
GROUP BY EA.DEPARTMENT_ID,TO_CHAR(EA.HIRE_DATE,'YY/MM') HAVING 5<=(SELECT COUNT(*)
                                                            FROM EMPLOYEES EB
                                                            GROUP BY DEPARTMENT_ID HAVING EA.DEPARTMENT_ID=EB.DEPARTMENT_ID)
ORDER BY D.DEPARTMENT_ID;

--118. ����(country_name) �� ����(city)�� �������� ��ȸ�Ͻÿ�. 
--    ��, �μ��� �������� ���� ���� �� �ֱ� ������ 106���� ������ ����� �ȴ�. 
--    �μ������� ���� ������ ������� ���ø� ��ſ� ��<�μ�����>���� ��µǵ��� �Ͽ� 107�� ��� ��µǰ� �Ѵ�.
SELECT NVL(COUNTRY_NAME,'<�μ� ����>') ����,NVL(CITY,'<�μ� ����>') ����,COUNT(1) ������
FROM EMPLOYEES LEFT JOIN DEPARTMENTS USING(DEPARTMENT_ID) LEFT JOIN LOCATIONS USING(LOCATION_ID) LEFT JOIN COUNTRIES USING(COUNTRY_ID)
GROUP BY COUNTRY_NAME,CITY;

--119. �� �μ��� �ִ� �޿����� ���̵�(employee_id), �̸�(first_name), �޿�(salary)�� ����Ͻÿ�. 
--    ��, �ִ� �޿��ڰ� ���� �μ��� ��ձ޿��� ���������� ����Ͽ� ��ձ޿��� ���� �� �ְ� �� ��. ****** ROLLUP CUBE PIVOT
SELECT DEPARTMENT_ID �μ���ȣ,EMPLOYEE_ID ���,FIRST_NAME �̸�,SALARY �޿�,ROUND((SELECT AVG(SALARY)
                                                    FROM EMPLOYEES EC
                                                    WHERE EA.DEPARTMENT_ID= EC.DEPARTMENT_ID)) ��ձ޿�
FROM EMPLOYEES EA
GROUP BY ROLLUP(DEPARTMENT_ID,EMPLOYEE_ID,FIRST_NAME,SALARY) HAVING SALARY=(SELECT MAX(SALARY)
                                                            FROM EMPLOYEES EB
                                                            WHERE EA.DEPARTMENT_ID=EB.DEPARTMENT_ID)
ORDER BY DEPARTMENT_ID;
--120. Ŀ�̼�(commission_pct)�� �������� ��ȸ�Ͻÿ�. 
--    Ŀ�̼��� �Ʒ�������ó�� 0.2, 0.25�� ��� .2��, 0.3, 0.35�� .3 ���·� ��µǾ�� �Ѵ�. 
--    ��, Ŀ�̼� ������ ���� �����鵵 �ִ� �� Ŀ�̼��� ���� ���� �׷��� ��<Ŀ�̼� ����>���� ��µǰ� �Ѵ�.
SELECT NVL(SUBSTR(TO_CHAR(COMMISSION_PCT),1,2),'<Ŀ�̼� ����>')Ŀ�̼Ǻ���, COUNT(1) ������
FROM EMPLOYEES
GROUP BY SUBSTR(TO_CHAR(COMMISSION_PCT),1,2);
--121. Ŀ�̼�(commission_pct)�� ���� ���� ���� ���� 4���� �μ���(department_name), 
--    ������ (first_name), �޿�(salary), Ŀ�̼�(commission_pct) ������ ��ȸ�Ͻÿ�. 
--    ��°���� Ŀ�̼� �� ���� �޴� ������ ����ϵ� ������ Ŀ�̼ǿ� ���ؼ��� �޿��� ���� ������ ���� ��� �ǰ� �Ѵ�.
SELECT DENAME,NAME,COMM,RAN
FROM(SELECT DEPARTMENT_NAME DENAME,FIRST_NAME NAME,SALARY,NVL(COMMISSION_PCT,0)COMM,DENSE_RANK()OVER(ORDER BY NVL(COMMISSION_PCT,0) DESC) RAN
FROM EMPLOYEES JOIN DEPARTMENTS USING(DEPARTMENT_ID)
GROUP BY DEPARTMENT_NAME,FIRST_NAME,SALARY,COMMISSION_PCT
ORDER BY NVL(COMMISSION_PCT,0) DESC)
WHERE ROWNUM<=4;
--Q1 �μ���, ������(first_name),�޿�,Ŀ�̼� �÷��� ���� �並 �ۼ��Ͻÿ�.
--�� Ŀ�̼� ����Ʈ�� ���� ��� 0���� ��ȯ

--Q2 �μ���, ��å, ������, �Ի����� ���� �並 �ۼ��Ͻÿ�.

--Q3 �μ����̺��� �����Ͽ� �� ���̺��� ����� �� ���̺� ������ �÷��� �߰��ϰ� �ʱⰪ�� ������ �� 
--������ �Ի� �� ���� ������ �÷��� �����ϴ� Ʈ���Ÿ� �ۼ��Ͻÿ�

--Q4 �μ�ID�� �Է��ϸ� �μ����� ��ȯ�ϴ� �Լ��� �ۼ��Ͻÿ�.

--Q5 �μ�ID�� �Է��ϸ� �ش� �μ��� ���� ����� ����ϴ� ���ν����� �ۼ��Ͻÿ�.