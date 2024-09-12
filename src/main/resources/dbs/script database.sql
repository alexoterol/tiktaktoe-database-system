drop database if exists tiktaktoe;
create database if not exists tiktaktoe;
use tiktaktoe;

create table usuario (
	id int auto_increment not null primary key,
	name_user varchar(100) not null,
    pwd varchar(100) not null
    
);

-- Procedure para crear usuario 

DELIMITER //

CREATE PROCEDURE create_user (
    IN name_user VARCHAR(100),
    IN pwd VARCHAR(100),
    OUT completed BOOLEAN
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        -- Si ocurre una excepción, se hace rollback y se marca la operación como fallida
        ROLLBACK;
        SET completed = FALSE;
    END;
    START TRANSACTION;
    INSERT INTO usuario (name_user, pwd) VALUES (name_user, pwd);
    COMMIT;
    SET completed = TRUE;
END //

DELIMITER ;

-- Vista para ver los usuarios

CREATE VIEW vista_usuario AS (SELECT name_user, pwd FROM usuario) ;
