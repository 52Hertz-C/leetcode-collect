-- 使用子查询和 LIMIT 子句
SELECT
	( SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT 1, 1 ) AS SecondHighestSalary;

-- 使用 IFNULL 和 LIMIT 子句
SELECT
	IFNULL ( ( SELECT DISTINCT salary FROM Employee ORDER BY Salary DESC LIMIT 1, 1 ), NULL ) AS SecondHighestSalary;