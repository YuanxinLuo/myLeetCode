



# 620. 有趣的电影
# SQL架构
# 某城市开了一家新的电影院，吸引了很多人过来看电影。该电影院特别注意用户体验，专门有个 LED显示板做电影推荐，上面公布着影评和相关电影描述。
#
# 作为该电影院的信息部主管，您需要编写一个 SQL查询，找出所有影片描述为非 boring (不无聊) 的并且 id 为奇数 的影片，结果请按等级 rating 排列。
#
#
#
# 例如，下表 cinema:
#
# +---------+-----------+--------------+-----------+
# |   id    | movie     |  description |  rating   |
# +---------+-----------+--------------+-----------+
# |   1     | War       |   great 3D   |   8.9     |
# |   2     | Science   |   fiction    |   8.5     |
# |   3     | irish     |   boring     |   6.2     |
# |   4     | Ice song  |   Fantacy    |   8.6     |
# |   5     | House card|   Interesting|   9.1     |
# +---------+-----------+--------------+-----------+
# 对于上面的例子，则正确的输出是为：
#
# +---------+-----------+--------------+-----------+
# |   id    | movie     |  description |  rating   |
# +---------+-----------+--------------+-----------+
# |   5     | House card|   Interesting|   9.1     |
# |   1     | War       |   great 3D   |   8.9     |
# +---------+-----------+--------------+-----------+
select id,movie,description,rating
from cinema
where description != 'boring' and id % 2 = 1
order by rating desc



# 627. 交换工资
# SQL架构
# 给定一个 salary 表，如下所示，有 m = 男性 和 f = 女性 的值。交换所有的 f 和 m 值（例如，将所有 f 值更改为 m，反之亦然）。要求只使用一个更新（Update）语句，并且没有中间的临时表。
#
# 注意，您必只能写一个 Update 语句，请不要编写任何 Select 语句。
#
#     例如：
#
#     | id | name | sex | salary |
#     |----|------|-----|--------|
#     | 1  | A    | m   | 2500   |
#     | 2  | B    | f   | 1500   |
#     | 3  | C    | m   | 5500   |
#     | 4  | D    | f   | 500    |
#     运行你所编写的更新语句之后，将会得到以下表:
#
#     | id | name | sex | salary |
#     |----|------|-----|--------|
#     | 1  | A    | f   | 2500   |
#     | 2  | B    | m   | 1500   |
#     | 3  | C    | f   | 5500   |
#     | 4  | D    | m   | 500    |
update salary set sex = case when sex='m' then 'f' else 'm' end