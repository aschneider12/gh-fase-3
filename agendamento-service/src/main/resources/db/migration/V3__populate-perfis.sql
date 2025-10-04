
-- mesmo login é a senha, p1,p1
INSERT into usuario(nome, login, senha)
values('Paciente 01', 'p1', '$2a$12$IPTV60S0BTkgylZ4DfMvY./WDlTHbjOaB4mp40yyzP.taDAw9O4ZW')
,('Medico 01', 'm1', '$2a$12$COLL0m2fDziLxO/IDfAS/uyDGqNAAxjBoaEQhf9Ds4eA0t8//bTwK')
,('Enfermeira 01', 'e1', '$2a$12$WiDIjnyBGjs0Y6QSH.ICjutXUIXUy7Pw2XX5PNaELRx73mmkqSvSy')
,('Administrador 01', 'a1', '$2a$12$10rxLVYHcqZp6OuEQfA9f.14MGtY.mhPGtARhoWM1PSibKd4E7TOC');

insert into permissao (recurso)
values ('consulta'),('usuario');

insert into perfil (descricao)
values ('administrador'),('paciente'),('medico'),('enfermeiro');

--perfil paciente
insert into usuario_perfil (usuario_id, perfil_id)
values ((select id from usuario where login = 'p1' limit 1),
 (select id from perfil where descricao like 'paciente' limit 1));

--perfil medico
insert into usuario_perfil (usuario_id, perfil_id)
values ((select id from usuario where login = 'm1' limit 1),
 (select id from perfil where descricao like 'medico' limit 1));

--perfil enfermeiro
insert into usuario_perfil (usuario_id, perfil_id)
values ((select id from usuario where login = 'e1' limit 1),
 (select id from perfil where descricao like 'enfermeiro' limit 1));

--perfil admnistrador
insert into usuario_perfil (usuario_id, perfil_id)
values ((select id from usuario where login = 'a1' limit 1),
(select id from perfil where descricao like 'administrador' limit 1));