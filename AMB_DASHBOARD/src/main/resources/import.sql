INSERT INTO categoria (nombre, tiempo_pregunta, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion) VALUES ('Táctica Militar', '45', 'admin', '2025-07-28', 'admin', '2025-07-28');
INSERT INTO categoria (nombre, tiempo_pregunta, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion) VALUES ('Historia Bélica', '45', 'admin', '2025-07-28', 'admin', '2025-07-28');
INSERT INTO categoria (nombre, tiempo_pregunta, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion) VALUES ('Armamento', '45', 'admin', '2025-07-28', 'admin', '2025-07-28');


INSERT INTO subcategoria (categoria_id, nombre, usuario_creacion, fecha_creacion, habilitada) VALUES (1, 'Subcategoría A', 'admin', '2024-06-01T10:00:00', true);
INSERT INTO subcategoria (categoria_id, nombre, usuario_creacion, fecha_creacion, habilitada) VALUES (1, 'Subcategoría B', 'admin', '2024-06-01T11:00:00', true);
INSERT INTO subcategoria (categoria_id, nombre, usuario_creacion, fecha_creacion, habilitada) VALUES (1, 'Subcategoría C', 'admin', '2024-06-01T12:00:00', false);


INSERT INTO curso (nombre_curso, precio, descripcion, dias, fecha_creacion, usuario_creacion, fecha_inicio, fecha_fin, habilitado, modo) VALUES ('Curso de Estrategia', 150.00, 'Curso avanzado de estrategia militar', 30, '2024-06-01', 'admin', '2024-06-10 08:00:00', '2024-07-10 18:00:00', true, 'presencial');
INSERT INTO curso (nombre_curso, precio, descripcion, dias, fecha_creacion, usuario_creacion, fecha_inicio, fecha_fin, habilitado, modo) VALUES ('Curso de Historia', 120.00, 'Historia de conflictos bélicos', 20, '2024-06-05', 'admin', '2024-06-15 09:00:00', '2024-07-05 17:00:00', true, 'virtual');


