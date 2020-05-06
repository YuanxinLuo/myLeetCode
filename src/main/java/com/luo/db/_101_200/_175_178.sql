-- 175. 组合两个表
-- 表1: Person
-- +-------------+---------+
-- | 列名         | 类型     |
-- +-------------+---------+
-- | PersonId    | int     |
-- | FirstName   | varchar |
-- | LastName    | varchar |
-- +-------------+---------+
-- PersonId 是上表主键
-- 表2: Address
--
-- +-------------+---------+
-- | 列名         | 类型    |
-- +-------------+---------+
-- | AddressId   | int     |
-- | PersonId    | int     |
-- | City        | varchar |
-- | State       | varchar |
-- +-------------+---------+
-- AddressId 是上表主键
--
-- 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
-- FirstName, LastName, City, State
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/combine-two-tables
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
select FirstName,LastName,City,State
From Person p LEFT JOIN Address a ON p.PersonId = a.PersonId

-- 176. 第二高的薪水
-- 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
--
-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
--
-- +---------------------+
-- | SecondHighestSalary |
-- +---------------------+
-- | 200                 |
-- +---------------------+
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/second-highest-salary
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
SELECT IFNULL(
    (
        SELECT DISTINCT Salary
        FROM Employee
        ORDER BY Salary DESC
        LIMIT 1,1
    ),null
) as SecondHighestSalary

-- 177. 第N高的薪水
-- 编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
--
-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- 例如上述 Employee 表，n = 2 时，应返回第二高的薪水 200。如果不存在第 n 高的薪水，那么查询应返回 null。
--
-- +------------------------+
-- | getNthHighestSalary(2) |
-- +------------------------+
-- | 200                    |
-- +------------------------+
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/nth-highest-salary
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  declare M INT;
  set M=n-1;
  RETURN (
      select ifnull(
          (
              select distinct Salary from Employee order by Salary desc limit M,1
          ),null
      ) as getNthHighestSalary
  );
END


-- 178. 分数排名
-- 编写一个 SQL 查询来实现分数排名。
-- 如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。
--
-- +----+-------+
-- | Id | Score |
-- +----+-------+
-- | 1  | 3.50  |
-- | 2  | 3.65  |
-- | 3  | 4.00  |
-- | 4  | 3.85  |
-- | 5  | 4.00  |
-- | 6  | 3.65  |
-- +----+-------+
-- 例如，根据上述给定的 Scores 表，你的查询应该返回（按分数从高到低排列）：
--
-- +-------+------+
-- | Score | Rank |
-- +-------+------+
-- | 4.00  | 1    |
-- | 4.00  | 1    |
-- | 3.85  | 2    |
-- | 3.65  | 3    |
-- | 3.65  | 3    |
-- | 3.50  | 4    |
-- +-------+------+
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/rank-scores
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
SELECT score, (SELECT COUNT(DISTINCT score) FROM scores WHERE score >= s.score) rank
FROM scores s ORDER BY score desc