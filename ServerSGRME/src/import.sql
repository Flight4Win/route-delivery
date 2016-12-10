#dropear tablas iniciales
delete from cliente where 1;
delete from empleado where 1;
delete from cargo where 1;
delete from persona where 1;
delete from usuario where 1;
delete from perfil where 1;
delete from estado where 1;
delete from plandevuelo where 1;
delete from aeropuerto where 1;
delete from lugar where 1;
#scipts de insercion informacion base
#estado
INSERT INTO estado (idestado,nombre) VALUES (1,"ACTIVADO");
INSERT INTO estado (idestado,nombre) VALUES (2,"DESACTIVADO");
INSERT INTO estado (idestado,nombre) VALUES (3,"EN ESPERA");
INSERT INTO estado (idestado,nombre) VALUES (4,"EN TRANSITO");
INSERT INTO estado (idestado,nombre) VALUES (5,"ENTREGADO");
INSERT INTO estado (idestado,nombre) VALUES (6,"CANCELADO");
#cargo
INSERT INTO cargo (idcargo,nombre,descripcion) VALUES (1,"Soporte Tecnico","Administrador del sistema.");
INSERT INTO cargo (idcargo,nombre,descripcion) VALUES (2,"Operario","Empleado de la empresa.");
#perfil
INSERT INTO perfil (idperfil,nombre,descripcion,nivelacceso) VALUES (1,"Administrador General","Administra el sistema",1);
INSERT INTO perfil (idperfil,nombre,descripcion,nivelacceso) VALUES (2,"Empleado","Empleado del sistema",2);
INSERT INTO perfil (idperfil,nombre,descripcion,nivelacceso) VALUES (3,"Cliente","Cliente",3);
#persona
INSERT INTO persona (idpersona,documento,apellidopat,apellidomat,nombres,correo) VALUES	(1,"11111111","Admin","General","Sgrme","dp1.sgrme@gmail.com");
INSERT INTO persona (idpersona,documento,apellidopat,apellidomat,nombres,celular,correo) VALUES	(2,"70339330","Huamani","Malca","Joe","990320305","huamani.jn@pucp.edu.pe");
INSERT INTO persona (idpersona,documento,apellidopat,apellidomat,nombres,celular,correo) VALUES	(3,"71625263","Coronado","Miki","Diego","995822399","a20121129@pucp.pe");
INSERT INTO persona (idpersona,documento,apellidopat,apellidomat,nombres,celular,correo) VALUES	(4,"70691481","Guevara","Lizarraga","Maria","944127523","guevaral@pucp.edu.pe");
INSERT INTO persona (idpersona,documento,apellidopat,apellidomat,nombres,celular,correo) VALUES	(5,"71313909","Alva","Cohello","Carlo","987199629","carlo.alva@pucp.pe");
INSERT INTO persona (idpersona,documento,apellidopat,apellidomat,nombres,celular,correo) VALUES	(6,"48288722","Ferraro","Ticona","Juan Ignacio","987392820","mfguevaral@pucp.edu.pe");
INSERT INTO persona (idpersona,documento,apellidopat,apellidomat,nombres,celular,correo) VALUES	(7,"70004817","Manriquez","Alvarez","Pablo","992413760","mfernanda.mgl95@gmail.com");
INSERT INTO persona (idpersona,documento,apellidopat,apellidomat,nombres,celular,correo) VALUES	(8,"71198948","Loayza","Suarez","Juan","949972702","loayza.juan@pucp.pe");
INSERT INTO persona (idpersona,documento,apellidopat,apellidomat,nombres,celular,correo) VALUES	(9,"72715841","Sarmiento","Tello","Samoel","97105960","samoel.sarmiento@pucp.pe");
INSERT INTO persona (idpersona,documento,apellidopat,apellidomat,nombres,celular,correo) VALUES	(10,"73951903","Guerra","Contreras","Nilton","962366397","guerra.n@pucp.pe");	
#usuario
INSERT INTO usuario (idusuario,usuario,correo,contrasenha,idperfil) VALUES (1,"sgrmeadmin","dp1.sgrme@gmail.com","bcM0cEod11cUY5I3z5g7/Q==",1);
INSERT INTO usuario (idusuario,usuario,correo,contrasenha,idperfil) VALUES (2,"joe123","huamani.jn@pucp.edu.pe","Q/LLQGNwpg+BYbPAZweslg==",2);
INSERT INTO usuario (idusuario,usuario,correo,contrasenha,idperfil) VALUES (3,"diego123","a20121129@pucp.pe","Q/LLQGNwpg+BYbPAZweslg==",2);
INSERT INTO usuario (idusuario,usuario,correo,contrasenha,idperfil) VALUES (4,"fernanda123","guevaral@pucp.edu.pe","Q/LLQGNwpg+BYbPAZweslg==",2);
INSERT INTO usuario (idusuario,usuario,correo,contrasenha,idperfil) VALUES (5,"carlo123","carlo.alva@pucp.pe","Q/LLQGNwpg+BYbPAZweslg==",2);
INSERT INTO usuario (idusuario,usuario,correo,contrasenha,idperfil) VALUES (6,"juanchichu","mfguevaral@pucp.edu.pe","Q/LLQGNwpg+BYbPAZweslg==",3);
INSERT INTO usuario (idusuario,usuario,correo,contrasenha,idperfil) VALUES (7,"pablo123","mfernanda.mgl95@gmail.com","Q/LLQGNwpg+BYbPAZweslg==",3);
INSERT INTO usuario (idusuario,usuario,correo,contrasenha,idperfil) VALUES (8,"juan123","loayza.juan@pucp.pe","Q/LLQGNwpg+BYbPAZweslg==",3);
INSERT INTO usuario (idusuario,usuario,correo,contrasenha,idperfil) VALUES (9,"samoel123","samoel.sarmiento@pucp.pe","Q/LLQGNwpg+BYbPAZweslg==",3);
INSERT INTO usuario (idusuario,usuario,correo,contrasenha,idperfil) VALUES (10,"nilton123","guerra.n@pucp.pe","Q/LLQGNwpg+BYbPAZweslg==",3);
#cliente
INSERT INTO cliente (idcliente,idpersona,codigo,idusuario,idestado) VALUES (1,6,"Cpsem370vpregi0vboshe3jnt79v",6,1);
INSERT INTO cliente (idcliente,idpersona,codigo,idusuario,idestado) VALUES (2,7,"Cha0dpms364l9s8qdvra8oqfr1mk",7,1);
INSERT INTO cliente (idcliente,idpersona,codigo,idusuario,idestado) VALUES (3,8,"C513ourjmahbhnjelpsa0d7q5p5j",8,1);
INSERT INTO cliente (idcliente,idpersona,codigo,idusuario,idestado) VALUES (4,9,"C4f4356cb9e21rhr9d7inilab1tc",9,1);
INSERT INTO cliente (idcliente,idpersona,codigo,idusuario,idestado) VALUES (5,10,"Cldoltskfgpccd55eu5eii2fgk8",10,1);					
#empleado
INSERT INTO empleado (idempleado,idpersona,codigo,idusuario,idcargo,idestado) VALUES (1,1,"Ebna768lqhnb3attvj61beg1e6pu",1,1,1);
INSERT INTO empleado (idempleado,idpersona,codigo,idusuario,idcargo,idestado) VALUES (2,2,"Eeetjpuq4352n1j3mhrdgothl5p3",2,2,1);
INSERT INTO empleado (idempleado,idpersona,codigo,idusuario,idcargo,idestado) VALUES (3,3,"Ef2gsqtpbtsrlej7slsok1476vsf",3,2,1);
INSERT INTO empleado (idempleado,idpersona,codigo,idusuario,idcargo,idestado) VALUES (4,4,"Ek06ldedjiulbl4sm8bdnbin1keo",4,2,1);
INSERT INTO empleado (idempleado,idpersona,codigo,idusuario,idcargo,idestado) VALUES (5,5,"E857a82kkknvq2hj7plh9macq2n9",5,2,1);