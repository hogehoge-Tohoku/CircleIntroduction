CREATE TABLE IF NOT EXISTS circle(
    id INT PRIMARY KEY,
    name VARCHAR(50),
    classification VARCHAR(50),/*分類*/
    organization VARCHAR(50),/*所属*/
    atmosphere TEXT,/*雰囲気*/
    introduction TEXT,/*活動内容*/
    welcome_party_inf TEXT,/*新歓情報*/
    home_page VARCHAR(100),
    email VARCHAR(50),/*お問い合わせ*/
    twitter VARCHAR(100),
    instagram VARCHAR(100),
    line VARCHAR(100),
    picture_name VARCHAR(50),
    picture_num INT
);
