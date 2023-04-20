DROP DATABASE IF EXISTS Human_Friends;
CREATE DATABASE Human_Friends;
USE Human_Friends;
	
	DROP TABLE IF EXISTS Animal;
	CREATE TABLE Animal(
	id INT AUTO_INCREMENT PRIMARY KEY,
	animal_id INT,
    KEY animal_id (animal_id)
	);
    
	DROP TABLE IF EXISTS Pet;
	CREATE TABLE Pet(
	animal_id INT ,
	animal_type_id INT PRIMARY KEY,
     type_name varchar(200),
    FOREIGN KEY (animal_id) REFERENCES Animal (animal_id)
	);
    
	DROP TABLE IF EXISTS PackAnimal;
    CREATE TABLE PackAnimal(
	animal_id INT,
	animal_type_id INT PRIMARY KEY,
    type_name varchar(200),
    FOREIGN KEY (animal_id) REFERENCES Animal (animal_id)
	);
    
	DROP TABLE IF EXISTS Dog;
    CREATE TABLE Dog(
	animal_Type_ID INT,
	name_ID INT PRIMARY KEY,
	name_animal VARCHAR(200),
	birthday DATE,
    FOREIGN KEY (animal_Type_ID) REFERENCES Pet (animal_type_id)
	);
    
	DROP TABLE IF EXISTS Hamster;
    CREATE TABLE Hamster(
	animal_Type_ID INT,
	name_ID INT PRIMARY KEY,
	name_animal VARCHAR(200),
	birthday DATE,
    FOREIGN KEY (animal_Type_ID) REFERENCES Pet (animal_type_id)
	);
    
	DROP TABLE IF EXISTS Cat;
    CREATE TABLE Cat(
	animal_Type_ID INT,
	name_ID INT PRIMARY KEY,
	name_animal VARCHAR(200),
	birthday DATE,
    FOREIGN KEY (animal_Type_ID) REFERENCES Pet (animal_type_id)
	);
    
	DROP TABLE IF EXISTS Horse;
	CREATE TABLE Horse(
	animal_Type_ID INT,
	name_ID INT PRIMARY KEY,
	name_animal VARCHAR(200),
	birthday DATE,
    FOREIGN KEY (animal_Type_ID) REFERENCES PackAnimal (animal_type_id)
	);
    
	DROP TABLE IF EXISTS Camel;
	CREATE TABLE Camel(
	animal_Type_ID INT,
	name_ID INT PRIMARY KEY,
	name_animal VARCHAR(200),
	birthday DATE,
    FOREIGN KEY (animal_Type_ID) REFERENCES PackAnimal (animal_type_id)
	);
    
	DROP TABLE IF EXISTS Donkey;
	CREATE TABLE Donkey(
	animal_Type_ID INT,
	name_ID INT PRIMARY KEY,
	name_animal VARCHAR(200),
	birthday DATE,
    FOREIGN KEY (animal_Type_ID) REFERENCES PackAnimal (animal_type_id)
	);
    
	DROP TABLE IF EXISTS Comand_animals;
    CREATE TABLE Comand_animals(
	ID_Command INT PRIMARY KEY,
	name_command VARCHAR(200)
	); 
	
	DROP TABLE IF EXISTS Comand_type;
	CREATE TABLE Comand_type(
	ID INT   AUTO_INCREMENT PRIMARY KEY,
	ID_Command INT,
    animal_ID INT,
	animal_type_id INT,
	name_ID INT,
    FOREIGN KEY (ID_Command) REFERENCES Comand_animals (ID_Command)
	); 
    
    INSERT INTO Animal(animal_id)
    VALUES (1),(2);
    
	INSERT INTO Pet(animal_id,animal_type_id,type_name)
    VALUES (1,1,'Собака')
			,(1,2,'Хомяк')
            ,(1,3,'Кошка');
    
    INSERT INTO PackAnimal(animal_id,animal_type_id,type_name)
    VALUES (2,1,'Лошадь')
			,(2,2,'Осел')
            ,(2,3,'Верблюд');
			
			
	INSERT INTO Dog(animal_type_id,name_ID,name_animal,birthday)
    VALUES (1,1,'Полкан','20220507')
			,(1,2,'Мухтар', '20200508');
            
   	INSERT INTO Hamster(animal_type_id,name_ID,name_animal,birthday)
    VALUES (2,1,'Вулкан','20230207')
			,(2,2,'Мойша', '20200508'); 
            
   	INSERT INTO Cat(animal_type_id,name_ID,name_animal,birthday)
    VALUES (3,1,'Васька','20130207')
			,(3,2,'Машка', '20180508');             
    
    
	INSERT INTO Horse(animal_type_id,name_ID,name_animal,birthday)
    VALUES (1,1,'Василиса','20210507')
			,(1,2,'Маргарита', '20130508');
            
   	INSERT INTO Donkey(animal_type_id,name_ID,name_animal,birthday)
    VALUES (2,1,'Чистый','20150207')
			,(2,2,'Белый', '20190508'); 
            
   	INSERT INTO Camel(animal_type_id,name_ID,name_animal,birthday)
    VALUES (3,1,'Варта','20190607')
			,(3,2,'Союз', '20200708');   
            			
	INSERT INTO Comand_animals(ID_Command,name_command)
    VALUES (1,'Лежать')
			,(2, 'Стоять')
            ,(3, 'Сидеть')
            ,(4, 'Ко мне')
            ,(5, 'Голос');      
    
    INSERT INTO Comand_type(ID_Command,animal_ID,animal_Type_ID,name_ID)
    VALUES (1,1,1,1)
			,(2,1,1,2)
            ,(3,1,2,1)
			,(4,1,2,2)
            ,(1,1,3,1)
			,(2,1,3,2)
            ,(3,2,1,1)
			,(4,2,1,2)
            ,(1,2,2,1)
			,(2,2,2,2)
            ,(3,2,3,1)
			,(4,2,3,2);


	DELETE FROM Comand_type
    WHERE animal_type_id = (SELECT animal_type_id FROM PackAnimal WHERE type_name = 'Верблюд')
    AND animal_id  = (SELECT animal_id FROM PackAnimal WHERE type_name = 'Верблюд'); 
    
	
	
	
    DROP TABLE Camel;
	
	

    SET @temp = (SELECT animal_id FROM PackAnimal WHERE type_name = 'Верблюд');
	SET @temp2 = (SELECT animal_Type_ID FROM PackAnimal WHERE type_name = 'Верблюд');
    
    DELETE FROM PackAnimal
    WHERE animal_id  = @temp AND animal_type_id = @temp2; 
    
    INSERT INTO PackAnimal(animal_id,animal_type_id,type_name)
    VALUES (2,4,'Лошади и Ослы');





	DROP TABLE IF EXISTS Donk_Horse;
	CREATE TABLE Donk_Horse(
	animal_Type_ID INT,
	old_animal_Type_ID INT,
	name_ID INT  AUTO_INCREMENT  PRIMARY KEY,
	old_name_ID INT,
	name_animal VARCHAR(200),
	birthday DATE,
    FOREIGN KEY (animal_Type_ID) REFERENCES PackAnimal (animal_type_id)
	); 
     
	INSERT INTO Donk_Horse(
		animal_type_id
		,old_animal_Type_ID
		,old_name_ID
		,name_animal
		,birthday)
	SELECT 4
			,animal_Type_ID
			,name_ID
			,name_animal
			,birthday
		FROM Horse;
    
		INSERT INTO Donk_Horse(
		animal_type_id
		,old_animal_Type_ID
		,old_name_ID
		,name_animal
		,birthday)
	SELECT 4
			,animal_Type_ID
			,name_ID
			,name_animal
			,birthday
		FROM Donkey;
	
    INSERT INTO Comand_type(ID_Command,animal_ID,animal_Type_ID,name_ID)
	SELECT 
        c.ID_Command
        ,c.animal_ID
        ,d.animal_Type_ID
        ,d.name_ID
     FROM   
        Donk_Horse d
        INNER JOIN PackAnimal p
        ON d.animal_Type_ID=p.animal_type_id
        INNER JOIN Comand_type c
        ON c.animal_ID=p.animal_id AND c.animal_type_id=d.old_animal_Type_ID AND c.name_ID=d.old_name_ID;	

	
	DELETE FROM Comand_type
	WHERE EXISTS
	(
	SELECT p.animal_ID,h.animal_Type_ID
			FROM Horse h
			INNER JOIN PackAnimal p
			ON h.animal_Type_ID=p.animal_type_id
			WHERE Comand_type.animal_ID= p.animal_ID AND Comand_type.animal_type_id=h.animal_Type_ID
	);

	DELETE FROM Comand_type
	WHERE EXISTS
	(
	SELECT p.animal_ID,h.animal_Type_ID
			FROM Donkey h
			INNER JOIN PackAnimal p
			ON h.animal_Type_ID=p.animal_type_id
			WHERE Comand_type.animal_ID= p.animal_ID AND Comand_type.animal_type_id=h.animal_Type_ID
	);

	DROP TABLE Horse;
	DROP TABLE Donkey;
    
	DROP TABLE IF EXISTS Young_animals;
	CREATE TABLE Young_animals(
     ID INT AUTO_INCREMENT PRIMARY KEY,
     animal_ID INT,
	 animal_Type_ID INT,
	 name_ID INT,
     name_animal VARCHAR(200),
     age_month INT 
	);		
	
	
	INSERT INTO Young_animals(animal_ID,animal_Type_ID,name_ID,name_animal,age_month)
		SELECT p.animal_ID,d.animal_Type_ID,d.name_ID, d.name_animal, (SELECT TIMESTAMPDIFF(MONTH,d.birthday,NOW())) AS age_month
		FROM Dog d
		INNER JOIN Pet p
		ON d.animal_type_id=p.animal_type_id
		WHERE TIMESTAMPDIFF(YEAR,d.birthday,NOW()) BETWEEN 1 AND 3
		UNION ALL
		SELECT p.animal_ID,d.animal_Type_ID,d.name_ID, d.name_animal, (SELECT TIMESTAMPDIFF(MONTH,d.birthday,NOW())) AS age_month
		FROM Cat d
		INNER JOIN Pet p
		ON d.animal_type_id=p.animal_type_id
		WHERE TIMESTAMPDIFF(YEAR,d.birthday,NOW()) BETWEEN 1 AND 3
		UNION ALL
		SELECT p.animal_ID,d.animal_Type_ID,d.name_ID, d.name_animal, (SELECT TIMESTAMPDIFF(MONTH,d.birthday,NOW())) AS age_month
		FROM Hamster d
		INNER JOIN Pet p
		ON d.animal_type_id=p.animal_type_id
		WHERE TIMESTAMPDIFF(YEAR,d.birthday,NOW()) BETWEEN 1 AND 3
		UNION ALL
		SELECT p.animal_ID,d.animal_Type_ID,d.name_ID, d.name_animal, (SELECT TIMESTAMPDIFF(MONTH,d.birthday,NOW())) AS age_month
		FROM Donk_Horse d
		INNER JOIN PackAnimal p
		ON d.animal_type_id=p.animal_type_id
		WHERE TIMESTAMPDIFF(YEAR,d.birthday,NOW()) BETWEEN 1 AND 3;
	
	SELECT * FROM Young_animals;

	DROP TABLE IF EXISTS All_animals;
	 CREATE TABLE All_animals(
     ID INT AUTO_INCREMENT PRIMARY KEY,
     animal_ID INT,
	 animal_Type_ID INT,
	 type_name varchar(200),
	 name_ID INT,
     name_animal VARCHAR(200),
     birthday DATE ,
     ID_Command INT,
     name_command VARCHAR(200)   
	 ); 
	
	
	INSERT INTO All_animals(animal_ID,animal_Type_ID,type_name,name_ID,name_animal,birthday,ID_Command,name_command)
		SELECT p.animal_ID,d.animal_Type_ID,p.type_name,d.name_ID, d.name_animal, d.birthday,ca.ID_Command,ca.name_command
		FROM Dog d
		INNER JOIN Pet p
		ON d.animal_type_id=p.animal_type_id
		LEFT JOIN Comand_type ct
		ON ct.animal_type_id=d.animal_type_id AND p.animal_ID=ct.animal_ID AND ct.name_ID=d.name_ID
		LEFT JOIN Comand_animals ca
		ON ca.ID_Command=ct.ID_Command
		UNION ALL
		SELECT p.animal_ID,d.animal_Type_ID,p.type_name,d.name_ID, d.name_animal, d.birthday,ca.ID_Command,ca.name_command
		FROM Cat d
		INNER JOIN Pet p
		ON d.animal_type_id=p.animal_type_id
		LEFT JOIN Comand_type ct
		ON ct.animal_type_id=d.animal_type_id AND p.animal_ID=ct.animal_ID AND ct.name_ID=d.name_ID
		LEFT JOIN Comand_animals ca
		ON ca.ID_Command=ct.ID_Command
		UNION ALL
		SELECT p.animal_ID,d.animal_Type_ID,p.type_name,d.name_ID, d.name_animal, d.birthday,ca.ID_Command,ca.name_command
		FROM Hamster d
		INNER JOIN Pet p
		ON d.animal_type_id=p.animal_type_id
		LEFT JOIN Comand_type ct
		ON ct.animal_type_id=d.animal_type_id AND p.animal_ID=ct.animal_ID AND ct.name_ID=d.name_ID
		LEFT JOIN Comand_animals ca
		ON ca.ID_Command=ct.ID_Command   
		UNION ALL
		SELECT p.animal_ID,d.animal_Type_ID,p.type_name,d.name_ID, d.name_animal, d.birthday,ca.ID_Command,ca.name_command
		FROM Donk_Horse d
		INNER JOIN PackAnimal p
		ON d.animal_type_id=p.animal_type_id
		LEFT JOIN Comand_type ct
		ON ct.animal_type_id=d.animal_type_id AND p.animal_ID=ct.animal_ID AND ct.name_ID=d.name_ID
		LEFT JOIN Comand_animals ca
		ON ca.ID_Command=ct.ID_Command;     

		 CREATE TABLE All_animals_simple(
		 ID INT AUTO_INCREMENT PRIMARY KEY,
		 type_name varchar(200),
		 name_animal VARCHAR(200),
		 birthday VARCHAR(50),
		 name_command VARCHAR(200)   
		 ); 
		 
		 INSERT INTO All_animals_simple(type_name,name_animal,birthday,name_command)
		 SELECT type_name,name_animal,birthday,name_command FROM All_animals;
		
		SELECT ID,type_name,name_animal,birthday,name_command FROM All_animals_simple;
		