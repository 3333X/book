DROP TABLE IF EXISTS account;
CREATE TABLE account (
  id INT AUTO_INCREMENT  PRIMARY KEY COMMENT '顾客id',
  name VARCHAR(250) NOT NULL COMMENT '姓名',
  sex INTEGER(1) NOT NULL COMMENT '性别 1-男 2-女',
  age INTEGER(3) COMMENT '年龄',
  level VARCHAR(255) DEFAULT 'Coper' COMMENT '会员等级Coper member Silver member Gold member',
  point DOUBLE DEFAULT 0
);
INSERT INTO account (name, sex, age, level, point) VALUES
  ('Ethan', 1, 18, 'Coper', 0),
  ('Odom', 1, 22, 'Coper', 0),
  ('Cindy', 2, 25, 'Silver', 40),
  ('Luby', 1, 43, 'Gold',168);


DROP TABLE IF EXISTS orderForm;
CREATE TABLE orderForm (
    id INT AUTO_INCREMENT  PRIMARY KEY COMMENT '订单id',
    account_no INTEGER NOT NULL COMMENT '顾客id',
    price DOUBLE NOT NULL COMMENT '订单总价格'
);
INSERT INTO orderForm (account_no, price) VALUES
    (3, 20),
    (4, 10),
    (4, 33),
    (4, 13);

DROP TABLE IF EXISTS goods;
CREATE TABLE goods (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL COMMENT '书名',
    price DOUBLE NOT NULL COMMENT '单价',
    number Integer NOT NULL COMMENT '数量',
    order_No VARCHAR(250) NOT NULL COMMENT '订单编号'
);
INSERT INTO goods (name, price, number, order_No) VALUES
    ('111', 20, 1, 1),
    ('我们仨', 10, 1, 2),
    ('霍乱时期的爱情', 20, 1, 3),
    ('水浒传', 13, 1, 3),
    ('水浒传', 13, 1, 4);