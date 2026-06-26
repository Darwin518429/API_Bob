
DROP DATABASE IF  EXISTS fondodebikini;
CREATE DATABASE IF NOT EXISTS fondodebikini;
USE fondodebikini;


-- Tabla: personaje
-- Habitantes del fondo de bikinia

CREATE TABLE personajes (
    id          BIGINT AUTO_INCREMENT ,
    nombre      VARCHAR(100) NOT NULL,
    especie     VARCHAR(100) NOT NULL,
    direccion   VARCHAR(150),
    ocupacion   VARCHAR(100),
    edad MEDIUMINT, 
    CONSTRAINT pk_personaje PRIMARY KEY(id)
);

-- -----------------------------------------------
-- Tabla: restaurante
-- Locales de comida de Bikini Bottom
-- -----------------------------------------------
CREATE TABLE restaurantes (
    id          BIGINT AUTO_INCREMENT ,
    nombre      VARCHAR(100) NOT NULL,
    propietario VARCHAR(100) NOT NULL,
    direccion   VARCHAR(150),
    CONSTRAINT pk_restaurantes PRIMARY KEY(id)
);


CREATE TABLE productos (
    id              BIGINT AUTO_INCREMENT ,
    nombre          VARCHAR(100)   NOT NULL,
    precio          DECIMAL(5,2)   NOT NULL,
    id_restaurante  BIGINT         NOT NULL,
     CONSTRAINT pk_producto  PRIMARY KEY(id),
    CONSTRAINT fk_producto_restaurante
        FOREIGN KEY (id_restaurante)
        REFERENCES restaurantes(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- -----------------------------------------------
-- Tabla: ingrediente
-- Ingredientes que puede llevar un producto
-- -----------------------------------------------
CREATE TABLE ingredientes (
    id      BIGINT AUTO_INCREMENT ,
    nombre  VARCHAR(100) NOT NULL,
    alergeno BOOLEAN DEFAULT FALSE,
     CONSTRAINT pk_ingrediente  PRIMARY KEY(id)
);


CREATE TABLE productos_ingredientes (
    id_producto     BIGINT NOT NULL,
    id_ingrediente  BIGINT NOT NULL,
  CONSTRAINT pk_producto_ingrediente PRIMARY KEY (id_producto, id_ingrediente),
    CONSTRAINT fk_pi_producto
        FOREIGN KEY (id_producto)
        REFERENCES productos(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_pi_ingrediente
        FOREIGN KEY (id_ingrediente)
        REFERENCES ingredientes(id)
        ON DELETE CASCADE
);


CREATE TABLE pedidos (
    id              BIGINT AUTO_INCREMENT ,
    id_personaje    BIGINT  NOT NULL,
    id_producto     BIGINT  NOT NULL,
    cantidad        INT     NOT NULL DEFAULT 1,
    fecha           DATE    NOT NULL,
    total           DECIMAL(7,2),
     CONSTRAINT pk_pedido  PRIMARY KEY(id),
    CONSTRAINT fk_pedido_personaje
        FOREIGN KEY (id_personaje)
        REFERENCES personajes(id)
        ON DELETE CASCADE 
        ,
    CONSTRAINT fk_pedido_producto
        FOREIGN KEY (id_producto)
        REFERENCES productos(id)
        ON DELETE CASCADE 
);