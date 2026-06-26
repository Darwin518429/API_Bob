

USE fondodebikini;

-- -----------------------------------------------
-- Datos: personaje
-- -----------------------------------------------
INSERT INTO personajes (nombre, especie, direccion, ocupacion,edad) VALUES
('Bob Esponja',   'Esponja',  'Piña, 124 Calle Concha',        'Cocinero',20),
('Patricio Star', 'Estrella', 'Roca, 120 Calle Concha',         'Desempleado',30),
('Calamardo',     'Pulpo',    'Isla de Pascua, 122 C. Concha',  'Cajero',110),
('Sandy Mejillas','Ardilla',  'Cúpula submarina, Bikini',       'Científica',200),
('El Cangrejo',   'Cangrejo', 'Ancora, Calle Ancla 1',          'Empresario',500),
('Plankton',      'Plancton', 'Cubo de Basura, Calle Basura 1', 'Villano',320),
('Gary',          'Caracol',  'Piña, 124 Calle Concha',         'Mascota',1);

-- -----------------------------------------------
-- Datos: restaurante
-- -----------------------------------------------
INSERT INTO restaurantes (nombre, propietario, direccion) VALUES
('El Crustáceo Crujiente', 'El Cangrejo', 'Bikini Bottom, Calle Ancla 3'),
('El Balde',               'Plankton',    'Bikini Bottom, Calle Basura 1');

-- -----------------------------------------------
-- Datos: producto
-- (id_restaurante 1 = Crustáceo, 2 = El Balde)
-- -----------------------------------------------
INSERT INTO productos (nombre, precio, id_restaurante) VALUES
('Cangreburger',         1.99, 1),
('Cangreburger doble',   2.99, 1),
('Cangreburger triple',  3.99, 1),
('Patatas fritas',       0.99, 1),
('Batido de algas',      1.49, 1),
('Fórmula Krabby Patty', 0.01, 2),
('Chum Burger',          0.50, 2);

-- -----------------------------------------------
-- Datos: ingrediente
-- -----------------------------------------------
INSERT INTO ingredientes (nombre, alergeno) VALUES
('Pan de algas',    FALSE),
('Carne secreta',   FALSE),
('Lechuga marina',  FALSE),
('Queso de coral',  FALSE),
('Salsa secreta',   FALSE),
('Plancton frito',  TRUE),
('Algas fritas',    FALSE);

-- -----------------------------------------------
-- Datos: producto_ingrediente
-- Qué ingredientes lleva cada producto
-- -----------------------------------------------
INSERT INTO productos_ingredientes (id_producto, id_ingrediente) VALUES
(1, 1), (1, 2), (1, 3), (1, 5),   -- Cangreburger
(2, 1), (2, 2), (2, 3), (2, 4),   -- Cangreburger doble (doble carne)
(3, 1), (3, 2), (3, 3), (3, 4), (3, 5), -- Triple
(4, 7),                             -- Patatas fritas
(5, 3),                             -- Batido de algas
(6, 6),                             -- Fórmula Krabby (lleva plancton)
(7, 6), (7, 1);                     -- Chum Burger

-- -----------------------------------------------
-- Datos: pedido
-- total = cantidad * precio del producto
-- -----------------------------------------------
INSERT INTO pedidos (id_personaje, id_producto, cantidad, fecha, total) VALUES
(1, 1, 2,  '2024-01-10',  3.98),   -- Bob pide 2 Cangreburger
(2, 2, 5,  '2024-01-10', 14.95),   -- Patricio pide 5 dobles
(2, 4, 3,  '2024-01-11',  2.97),   -- Patricio pide patatas
(3, 5, 1,  '2024-01-12',  1.49),   -- Calamardo pide batido
(4, 1, 1,  '2024-01-13',  1.99),   -- Sandy pide Cangreburger
(4, 4, 2,  '2024-01-13',  1.98),   -- Sandy pide patatas
(5, 1, 10, '2024-01-14', 19.90),   -- El Cangrejo prueba su propio producto
(6, 6, 1,  '2024-01-15',  0.01),   -- Plankton pide su propia fórmula
(1, 3, 1,  '2024-01-16',  3.99);   -- Bob pide triple