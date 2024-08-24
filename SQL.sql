-- В подключенном MySQL репозитории создать базу данных “Друзья
-- человека”.

CREATE DATABASE IF NOT EXISTS HumanFriends;
USE HumanFriends;

--  Создать таблицы с иерархией из диаграммы в БД.

CREATE TABLE IF NOT EXISTS Pets (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(40),
    Type VARCHAR(40),
    BirthDay DATE,
    Commands VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS PackAnimals (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50),
    Type VARCHAR(50),
    BirthDay DATE,
    Commands VARCHAR(200)
);

-- Заполнить низкоуровневые таблицы именами(животных), командами
-- которые они выполняют и датами рождения.

INSERT INTO Pets (Name, Type, BirthDay, Commands) VALUES
('Bob', 'Dog', '2022-11-11', 'Sit, Stay, Fetch'),
('Murka', 'Cat', '2020-07-17', 'Sit, Pounce'),
('Glutton', 'Hamster', '2022-10-10', 'Roll, Hide'),
('Baks', 'Dog', '2019-10-03', 'Sit, Paw, Bark'),
('Tom', 'Cat', '2018-05-20', 'Sit, Pounce, Scratch'),
('Masik', 'Hamster', '2022-03-23', 'Roll, Spin'),
('Sara', 'Dog', '2017-12-17', 'Sit, Stay, Roll'),
('Markiz', 'Cat', '2021-08-11', 'Meow, Scratch, Jump'),
('Lev', 'Hamster', '2023-08-04', 'Roll, Spin');

INSERT INTO PackAnimals (Name, Type, BirthDay, Commands) VALUES
('King', 'Horse', '2017-09-20', 'Trot, Canter, Gallop'),
('Rokky', 'Camel', '2015-10-13', 'Walk, Carry Load'),
('Messi', 'Donkey', '2018-04-18', 'Walk, Carry Load, Bray'),
('Prinz', 'Horse', '2016-06-05', 'Trot, Canter'),
('Luna', 'Camel', '2014-12-01', 'Walk, Sit'),
('Sascha', 'Donkey', '2016-11-03', 'Walk, Bray, Kick'),
('Sofi', 'Horse', '2021-02-12', 'Trot, Jump, Gallop'),
('Pesok', 'Camel', '2017-06-16', 'Walk, Run'),
('Lola', 'Donkey', '2022-11-06', 'Walk, Bray, Kick');

-- Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
-- питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

CREATE TABLE IF NOT EXISTS Camels AS
SELECT * FROM PackAnimals WHERE Type = 'Camel';

CREATE TABLE IF NOT EXISTS NonCamels AS
SELECT * FROM PackAnimals WHERE Type != 'Camel';

CREATE TABLE IF NOT EXISTS Horses_Donkeys AS
SELECT * FROM NonCamels WHERE Type IN ('Horse', 'Donkey');

-- Создать новую таблицу “молодые животные” в которую попадут все
-- животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
-- до месяца подсчитать возраст животных в новой таблице.

CREATE TABLE IF NOT EXISTS YoungAnimals AS
SELECT ID, Name, Type, BirthDay, Commands, TIMESTAMPDIFF(MONTH, BirthDay, CURDATE()) AS AgeOfTheAnimals
FROM (
    SELECT ID, Name, Type, BirthDay, Commands FROM Pets
    UNION ALL
    SELECT ID, Name, Type, BirthDay, Commands FROM PackAnimals
) AS AllAnimals
WHERE BirthDay BETWEEN DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND DATE_SUB(CURDATE(), INTERVAL 1 YEAR);

--  Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
-- прошлую принадлежность к старым таблицам.

SELECT 'Pets' AS SourceTable, ID, Name, Type, BirthDay, Commands FROM Pets
UNION ALL
SELECT 'PackAnimals' AS SourceTable, ID, Name, Type, BirthDay, Commands FROM PackAnimals
UNION ALL
SELECT 'Camels' AS SourceTable, ID, Name, Type, BirthDay, Commands FROM Camels
UNION ALL
SELECT 'NonCamels' AS SourceTable, ID, Name, Type, BirthDay, Commands FROM NonCamels
UNION ALL
SELECT 'Horses_Donkeys' AS SourceTable, ID, Name, Type, BirthDay, Commands FROM Horses_Donkeys
UNION ALL
SELECT 'YoungAnimals' AS SourceTable, ID, Name, Type, BirthDay, Commands FROM YoungAnimals;






