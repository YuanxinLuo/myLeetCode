# 196. 删除重复的电子邮箱
# 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
#
# +----+------------------+
# | Id | Email            |
# +----+------------------+
# | 1  | john@example.com |
# | 2  | bob@example.com  |
# | 3  | john@example.com |
# +----+------------------+
# Id 是这个表的主键。
# 例如，在运行你的查询语句之后，上面的 Person 表应返回以下几行:
#
# +----+------------------+
# | Id | Email            |
# +----+------------------+
# | 1  | john@example.com |
# | 2  | bob@example.com  |
# +----+------------------+
delete from person
where id in (
    select t.id
    from (
         select a.id
         from Person a left join Person b on a.Email = b.Email
         where a.id > b.id
    ) t
)

# 197. 上升的温度
# SQL架构
# 给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
#
# +---------+------------------+------------------+
# | Id(INT) | RecordDate(DATE) | Temperature(INT) |
# +---------+------------------+------------------+
# |       1 |       2015-01-01 |               10 |
# |       2 |       2015-01-02 |               25 |
# |       3 |       2015-01-03 |               20 |
# |       4 |       2015-01-04 |               30 |
# +---------+------------------+------------------+
# 例如，根据上述给定的 Weather 表格，返回如下 Id:
#
# +----+
# | Id |
# +----+
# |  2 |
# |  4 |
# +----+
select a.Id
from  Weather as a join Weather as b
    on a.Temperature > b.Temperature
    and dateDiff(a.RecordDate,b.RecordDate) = 1