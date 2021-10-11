-- 1.同薪同名且不跳级的问题，解决办法是用group by按薪水分组后再order by
-- 2.排名第N高意味着要跳过N-1个薪水，由于无法直接用limit N-1，所以需先在函数开头处理N为N=N-1。
-- 注：这里不能直接用limit N-1是因为limit和offset字段后面只接受正整数（意味着0、负数、小数都不行）
-- 或者单一变量（意味着不能用表达式），也就是说想取一条，limit 2-1、limit 1.1这类的写法都是报错的。
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N := N-1;
  RETURN (
      SELECT DISTINCT
      	salary
      FROM
      	employee
      ORDER BY
      	salary DESC
      LIMIT N, 1
  );
END