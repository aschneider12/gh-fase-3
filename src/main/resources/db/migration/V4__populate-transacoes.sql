
insert into perfil_transacao (view, insert, update, delete,transacao_id, perfil_id)
values (true, true, true, true, (select id from transacao where descricao like 'consulta' limit 1),
(select id from perfil where descricao like 'administrador' limit 1));

insert into perfil_transacao (view, insert, update, delete,transacao_id, perfil_id)
values (true, false, false, true, (select id from transacao where descricao like 'consulta' limit 1),
(select id from perfil where descricao like 'medico' limit 1));

insert into perfil_transacao (view, insert, update, delete,transacao_id, perfil_id)
values (true, false, false, false, (select id from transacao where descricao like 'consulta' limit 1),
(select id from perfil where descricao like 'paciente' limit 1));

insert into perfil_transacao (view, insert, update, delete,transacao_id, perfil_id)
values (true, true, true, false, (select id from transacao where descricao like 'consulta' limit 1),
(select id from perfil where descricao like 'enfermeiro' limit 1));

