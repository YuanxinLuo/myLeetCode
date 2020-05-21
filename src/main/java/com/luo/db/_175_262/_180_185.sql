# 180. 连续出现的数字
# 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
#
# +----+-----+
# | Id | Num |
# +----+-----+
# | 1  |  1  |
# | 2  |  1  |
# | 3  |  1  |
# | 4  |  2  |
# | 5  |  1  |
# | 6  |  2  |
# | 7  |  2  |
# +----+-----+
# 例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。
#
# +-----------------+
# | ConsecutiveNums |
# +-----------------+
# | 1               |
# +-----------------+
select distinct a.num as ConsecutiveNums
from Logs as a,
     Logs as b,
     Logs as c
where a.num = b.num
  and b.num = c.num
  and a.id = b.id - 1
  and b.id = c.id - 1;

# 181. 超过经理收入的员工
# Employee 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。
#
# +----+-------+--------+-----------+
# | Id | Name  | Salary | ManagerId |
# +----+-------+--------+-----------+
# | 1  | Joe   | 70000  | 3         |
# | 2  | Henry | 80000  | 4         |
# | 3  | Sam   | 60000  | NULL      |
# | 4  | Max   | 90000  | NULL      |
# +----+-------+--------+-----------+
# 给定 Employee 表，编写一个 SQL 查询，该查询可以获取收入超过他们经理的员工的姓名。在上面的表格中，Joe 是唯一一个收入超过他的经理的员工。
#
# +----------+
# | Employee |
# +----------+
# | Joe      |
# +----------+
SELECT name Employee
FROM employee a
WHERE salary > (SELECT salary FROM employee b WHERE b.id = a.managerId)

# 182. 查找重复的电子邮箱
# 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
#
# 示例：
#
# +----+---------+
# | Id | Email   |
# +----+---------+
# | 1  | a@b.com |
# | 2  | c@d.com |
# | 3  | a@b.com |
# +----+---------+
# 根据以上输入，你的查询应返回以下结果：
#
# +---------+
# | Email   |
# +---------+
# | a@b.com |
# +---------+
SELECT email
FROM person
GROUP BY email
HAVING COUNT(email) > 1


# 183. 从不订购的客户
# 某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。
#
# Customers 表：
#
# +----+-------+
# | Id | Name  |
# +----+-------+
# | 1  | Joe   |
# | 2  | Henry |
# | 3  | Sam   |
# | 4  | Max   |
# +----+-------+
# Orders 表：
#
# +----+------------+
# | Id | CustomerId |
# +----+------------+
# | 1  | 3          |
# | 2  | 1          |
# +----+------------+
# 例如给定上述表格，你的查询应返回：
#
# +-----------+
# | Customers |
# +-----------+
# | Henry     |
# | Max       |
# +-----------+
select name Customers
from Customers c
left join Orders o on c.Id = o.CustomerId
where o.CustomerId is null

# 184. 部门工资最高的员工
# Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。
# +----+-------+--------+--------------+
# | Id | Name  | Salary | DepartmentId |
# +----+-------+--------+--------------+
# | 1  | Joe   | 70000  | 1            |
# | 2  | Henry | 80000  | 2            |
# | 3  | Sam   | 60000  | 2            |
# | 4  | Max   | 90000  | 1            |
# +----+-------+--------+--------------+
# Department 表包含公司所有部门的信息。
#
# +----+----------+
# | Id | Name     |
# +----+----------+
# | 1  | IT       |
# | 2  | Sales    |
# +----+----------+
# 编写一个 SQL 查询，找出每个部门工资最高的员工。例如，根据上述给定的表格，Max 在 IT 部门有最高工资，Henry 在 Sales 部门有最高工资。
#
# +------------+----------+--------+
# | Department | Employee | Salary |
# +------------+----------+--------+
# | IT         | Max      | 90000  |
# | Sales      | Henry    | 80000  |
# +------------+----------+--------+
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/department-highest-salary
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
SELECT
    d.name department,t2.employee ,t2.salary
FROM department d ,
 (
     SELECT e.name employee,e.departmentId, t1.salary
     from employee e,
          (
              SELECT departmentId, max(salary) salary FROM employee
              GROUP BY departmentId
          ) t1
     WHERE e.departmentId = t1.departmentId and e.salary = t1.salary
 ) t2
WHERE d.id = t2.departmentId


# 185. 部门工资前三高的所有员工
# Employee 表包含所有员工信息，每个员工有其对应的工号 Id，姓名 Name，工资 Salary 和部门编号 DepartmentId 。
#
# +----+-------+--------+--------------+
# | Id | Name  | Salary | DepartmentId |
# +----+-------+--------+--------------+
# | 1  | Joe   | 85000  | 1            |
# | 2  | Henry | 80000  | 2            |
# | 3  | Sam   | 60000  | 2            |
# | 4  | Max   | 90000  | 1            |
# | 5  | Janet | 69000  | 1            |
# | 6  | Randy | 85000  | 1            |
# | 7  | Will  | 70000  | 1            |
# +----+-------+--------+--------------+
# Department 表包含公司所有部门的信息。
#
# +----+----------+
# | Id | Name     |
# +----+----------+
# | 1  | IT       |
# | 2  | Sales    |
# +----+----------+
# 编写一个 SQL 查询，找出每个部门获得前三高工资的所有员工。例如，根据上述给定的表，查询结果应返回：
#
# +------------+----------+--------+
# | Department | Employee | Salary |
# +------------+----------+--------+
# | IT         | Max      | 90000  |
# | IT         | Randy    | 85000  |
# | IT         | Joe      | 85000  |
# | IT         | Will     | 70000  |
# | Sales      | Henry    | 80000  |
# | Sales      | Sam      | 60000  |
# +------------+----------+--------+
# 解释：
#
# IT 部门中，Max 获得了最高的工资，Randy 和 Joe 都拿到了第二高的工资，Will 的工资排第三。销售部门（Sales）只有两名员工，Henry 的工资最高，Sam 的工资排第二。
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/department-top-three-salaries
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
select d.Name as Department,e.Name as Employee,e.Salary as Salary
from Employee as e
         left join Department as d on e.DepartmentId = d.Id
where e.Id in
      (
          select e1.Id
          from Employee as e1
                   left join Employee as e2 on e1.DepartmentId = e2.DepartmentId and e1.Salary < e2.Salary
          group by e1.Id
          having count(distinct e2.Salary) <= 2
      )
and e.DepartmentId in (select Id from Department)
order by d.Id asc,e.Salary desc