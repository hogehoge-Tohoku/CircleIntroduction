CREATE TABLE IF NOT EXISTS circle(
    id INT PRIMARY KEY,
    name VARCHAR(50),
    classification VARCHAR(50),/*分類*/
    organization VARCHAR(50),/*所属*/
    introduction TEXT,/*活動内容*/
    picture_name VARCHAR(50),
    picture_num INT
);
