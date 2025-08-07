INSERT INTO categoria (nombre, tiempo_pregunta, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion) VALUES ('Táctica Militar', '45', 'admin', '2025-07-28', 'admin', '2025-07-28');
INSERT INTO categoria (nombre, tiempo_pregunta, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion) VALUES ('Historia Bélica', '45', 'admin', '2025-07-28', 'admin', '2025-07-28');
INSERT INTO categoria (nombre, tiempo_pregunta, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion) VALUES ('Armamento', '45', 'admin', '2025-07-28', 'admin', '2025-07-28');


INSERT INTO subcategoria (categoria_id, nombre, usuario_creacion, fecha_creacion, habilitada) VALUES (1, 'Subcategoría A', 'admin', '2024-06-01T10:00:00', true);
INSERT INTO subcategoria (categoria_id, nombre, usuario_creacion, fecha_creacion, habilitada) VALUES (1, 'Subcategoría B', 'admin', '2024-06-01T11:00:00', true);
INSERT INTO subcategoria (categoria_id, nombre, usuario_creacion, fecha_creacion, habilitada) VALUES (1, 'Subcategoría C', 'admin', '2024-06-01T12:00:00', false);


INSERT INTO curso (nombre_curso, precio, descripcion, dias, fecha_creacion, usuario_creacion, fecha_inicio, fecha_fin, habilitado, modo) VALUES ('Curso de Estrategia', 150.00, 'Curso avanzado de estrategia militar', 30, '2024-06-01', 'admin', '2024-06-10 08:00:00', '2024-07-10 18:00:00', true, 'presencial');
INSERT INTO curso (nombre_curso, precio, descripcion, dias, fecha_creacion, usuario_creacion, fecha_inicio, fecha_fin, habilitado, modo) VALUES ('Curso de Historia', 120.00, 'Historia de conflictos bélicos', 20, '2024-06-05', 'admin', '2024-06-15 09:00:00', '2024-07-05 17:00:00', true, 'virtual');


INSERT INTO parametrizacion (clave, valor) VALUES ( 'google_classroom', 12345);
INSERT INTO parametrizacion ( clave, valor) VALUES ( 'zoom_api', 67890);
INSERT INTO parametrizacion ( clave, valor) VALUES ( 'moodle_token', 11111);
INSERT INTO parametrizacion ( clave, valor) VALUES ( 'teams_secret', 22222);
INSERT INTO parametrizacion ( clave, valor) VALUES ( 'slack_webhook', 33333);



INSERT INTO usuario (usuario_id, correo, contrasena, nombre, apellidos, nombre_completo, ano_nacimiento, prefijo, telefono, direccion, apodo, foto, genero, fecha_creacion, ultimo_acceso, discord, ident_fiscal, verificado, fecha_examen, aciertos_examen, nota_examen) VALUES (1, 'juan@mail.com', 'pass1', 'Juan', 'Pérez', 'Juan Pérez', '1990', '+34', 600111111, 'Calle 1', 'jp', 'foto1.jpg', 'M', '2023-01-01', '2023-06-01', 'juan#1234', 'X1234567A', true, '2023-05-01', 8, 7.5);
INSERT INTO usuario (usuario_id, correo, contrasena, nombre, apellidos, nombre_completo, ano_nacimiento, prefijo, telefono, direccion, apodo, foto, genero, fecha_creacion, ultimo_acceso, discord, ident_fiscal, verificado, fecha_examen, aciertos_examen, nota_examen) VALUES (2, 'ana@mail.com', 'pass2', 'Ana', 'López', 'Ana López', '1985', '+34', 600222222, 'Calle 2', 'al', 'foto2.jpg', 'F', '2023-01-02', '2023-06-02', 'ana#5678', 'Y7654321B', false, '2023-05-02', 9, 8.0);
INSERT INTO usuario (usuario_id, correo, contrasena, nombre, apellidos, nombre_completo, ano_nacimiento, prefijo, telefono, direccion, apodo, foto, genero, fecha_creacion, ultimo_acceso, discord, ident_fiscal, verificado, fecha_examen, aciertos_examen, nota_examen) VALUES (3, 'luis@mail.com', 'pass3', 'Luis', 'Martín', 'Luis Martín', '1992', '+34', 600333333, 'Calle 3', 'lm', 'foto3.jpg', 'M', '2023-01-03', '2023-06-03', 'luis#9999', 'Z9876543C', true, '2023-05-03', 7, 6.5);
INSERT INTO usuario (usuario_id, correo, contrasena, nombre, apellidos, nombre_completo, ano_nacimiento, prefijo, telefono, direccion, apodo, foto, genero, fecha_creacion, ultimo_acceso, discord, ident_fiscal, verificado, fecha_examen, aciertos_examen, nota_examen) VALUES (4, 'maria@mail.com', 'pass4', 'María', 'García', 'María García', '1995', '+34', 600444444, 'Calle 4', 'mg', 'foto4.jpg', 'F', '2023-01-04', '2023-06-04', 'maria#2222', 'W1239876D', true, '2023-05-04', 10, 9.0);
INSERT INTO usuario (usuario_id, correo, contrasena, nombre, apellidos, nombre_completo, ano_nacimiento, prefijo, telefono, direccion, apodo, foto, genero, fecha_creacion, ultimo_acceso, discord, ident_fiscal, verificado, fecha_examen, aciertos_examen, nota_examen) VALUES (5, 'carlos@mail.com', 'pass5', 'Carlos', 'Ruiz', 'Carlos Ruiz', '1988', '+34', 600555555, 'Calle 5', 'cr', 'foto5.jpg', 'M', '2023-01-05', '2023-06-05', 'carlos#3333', 'V6543210E', false, '2023-05-05', 6, 5.5);
INSERT INTO usuario (usuario_id, correo, contrasena, nombre, apellidos, nombre_completo, ano_nacimiento, prefijo, telefono, direccion, apodo, foto, genero, fecha_creacion, ultimo_acceso, discord, ident_fiscal, verificado, fecha_examen, aciertos_examen, nota_examen) VALUES (6, 'laura@mail.com', 'pass6', 'Laura', 'Sánchez', 'Laura Sánchez', '1993', '+34', 600666666, 'Calle 6', 'ls', 'foto6.jpg', 'F', '2023-01-06', '2023-06-06', 'laura#4444', 'U3210987F', true, '2023-05-06', 8, 7.0);
INSERT INTO usuario (usuario_id, correo, contrasena, nombre, apellidos, nombre_completo, ano_nacimiento, prefijo, telefono, direccion, apodo, foto, genero, fecha_creacion, ultimo_acceso, discord, ident_fiscal, verificado, fecha_examen, aciertos_examen, nota_examen) VALUES (7, 'david@mail.com', 'pass7', 'David', 'Fernández', 'David Fernández', '1991', '+34', 600777777, 'Calle 7', 'df', 'foto7.jpg', 'M', '2023-01-07', '2023-06-07', 'david#5555', 'T2109876G', false, '2023-05-07', 5, 4.5);
INSERT INTO usuario (usuario_id, correo, contrasena, nombre, apellidos, nombre_completo, ano_nacimiento, prefijo, telefono, direccion, apodo, foto, genero, fecha_creacion, ultimo_acceso, discord, ident_fiscal, verificado, fecha_examen, aciertos_examen, nota_examen) VALUES (8, 'sara@mail.com', 'pass8', 'Sara', 'Moreno', 'Sara Moreno', '1994', '+34', 600888888, 'Calle 8', 'sm', 'foto8.jpg', 'F', '2023-01-08', '2023-06-08', 'sara#6666', 'S1098765H', true, '2023-05-08', 9, 8.5);
INSERT INTO usuario (usuario_id, correo, contrasena, nombre, apellidos, nombre_completo, ano_nacimiento, prefijo, telefono, direccion, apodo, foto, genero, fecha_creacion, ultimo_acceso, discord, ident_fiscal, verificado, fecha_examen, aciertos_examen, nota_examen) VALUES (9, 'jorge@mail.com', 'pass9', 'Jorge', 'Navarro', 'Jorge Navarro', '1987', '+34', 600999999, 'Calle 9', 'jn', 'foto9.jpg', 'M', '2023-01-09', '2023-06-09', 'jorge#7777', 'R0987654I', false, '2023-05-09', 7, 6.0);
INSERT INTO usuario (usuario_id, correo, contrasena, nombre, apellidos, nombre_completo, ano_nacimiento, prefijo, telefono, direccion, apodo, foto, genero, fecha_creacion, ultimo_acceso, discord, ident_fiscal, verificado, fecha_examen, aciertos_examen, nota_examen) VALUES (10, 'eva@mail.com', 'pass10', 'Eva', 'Torres', 'Eva Torres', '1996', '+34', 601000000, 'Calle 10', 'et', 'foto10.jpg', 'F', '2023-01-10', '2023-06-10', 'eva#8888', 'Q9876543J', true, '2023-05-10', 10, 9.5);

INSERT INTO compra (precio_compra, fecha_compra, usuario_id, codigo_descuento, fecha_inicio, fecha_fin, merchant_order)VALUES ('49.99', '2024-06-01', 1, 'DESC10', '2024-06-01 10:00:00', '2024-07-01 10:00:00', 'ORDER123');
INSERT INTO compra (precio_compra, fecha_compra, usuario_id, codigo_descuento, fecha_inicio, fecha_fin, merchant_order)VALUES ('55.00', '2024-06-11', 6, 'DESC20', '2024-06-11 09:00:00', '2024-07-11 09:00:00', 'ORDER456');
INSERT INTO compra (precio_compra, fecha_compra, usuario_id, codigo_descuento, fecha_inicio, fecha_fin, merchant_order)VALUES ('70.50', '2024-06-12', 7, 'DESC30', '2024-06-12 08:00:00', '2024-07-12 08:00:00', 'ORDER789');
INSERT INTO compra (precio_compra, fecha_compra, usuario_id, codigo_descuento, fecha_inicio, fecha_fin, merchant_order)VALUES ('33.25', '2024-06-13', 8, 'DESC40', '2024-06-13 07:00:00', '2024-07-13 07:00:00', 'ORDER321');

INSERT INTO compra_curso (compra_id, curso_id) VALUES (1, 1);
INSERT INTO compra_curso (compra_id, curso_id) VALUES (2, 2);
INSERT INTO compra_curso (compra_id, curso_id) VALUES (3, 1);
INSERT INTO compra_curso (compra_id, curso_id) VALUES (4, 2);
