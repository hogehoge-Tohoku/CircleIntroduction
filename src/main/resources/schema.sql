CREATE TABLE IF NOT EXISTS circle(
    id INT PRIMARY KEY,
    name VARCHAR(50),
    classification VARCHAR(50),/*分類*/
    organization VARCHAR(50),/*所属*/
    atmosphere VARCHAR(100),/*雰囲気*/
    introduction TEXT,/*活動内容*/
    welcome_party_inf TEXT,/*新歓情報*/
    inquiry TEXT,/*お問い合わせ*/
    picture_name VARCHAR(50),
    picture_num INT
);
