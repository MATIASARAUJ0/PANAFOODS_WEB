INSERT INTO pedidos(ruc,empresa_que,tipo_produc,lugar,fecha_entrega,hora_tiempo,fecha_creacion) VALUES('12345678910','Plaza Vea','Harina de Pescado','CHORRILLOS','2022-11-11','14:14:14','2022-08-02');
INSERT INTO pedidos(ruc,empresa_que,tipo_produc,lugar,fecha_entrega,hora_tiempo,fecha_creacion) VALUES('12345678920','Wong','Congelados','ATE','2022-11-11','1:00:000','2022-08-02');
INSERT INTO pedidos(ruc,empresa_que,tipo_produc,lugar,fecha_entrega,hora_tiempo,fecha_creacion) VALUES('12345678930','FrioCenter','Aceite de Pescado','SANTA ANITA','2022-11-11','1:00:0000','2022-08-02');

INSERT INTO productos(nombre,precio,fecha_creacion) VALUES('Aceite de Pescado',18000.50,NOW());
INSERT INTO productos(nombre,precio,fecha_creacion) VALUES('Pescado',10500.50,NOW());
INSERT INTO productos(nombre,precio,fecha_creacion) VALUES('Harina',10000.50,NOW());
INSERT INTO productos(nombre,precio,fecha_creacion) VALUES('Atun',24000.50,NOW());

INSERT INTO facturas(descripcion,fecha_creacion,pedido_id) VALUES('Factura de Contenedores de Aceite de pescado y atun',NOW(),1);
INSERT INTO factura_item(cantidad,producto_id,factura_id) VALUES(1,1,1);
INSERT INTO factura_item(cantidad,producto_id,factura_id) VALUES(1,4,1);

INSERT INTO facturas(descripcion,fecha_creacion,pedido_id) VALUES('Factura de Contenedores de Atun',NOW(),2);
INSERT INTO factura_item(cantidad,producto_id,factura_id) VALUES(2,4,2);

INSERT INTO facturas(descripcion,fecha_creacion,pedido_id) VALUES('Factura de Contenedores de Pescado',NOW(),3);
INSERT INTO factura_item(cantidad,producto_id,factura_id) VALUES(3,2,3);

INSERT INTO creacion_empleados(dni,correo,password,fecha_creacion) VALUES('75382531','jorgegravital360@gmail.com','123456',''2022-08-02'')