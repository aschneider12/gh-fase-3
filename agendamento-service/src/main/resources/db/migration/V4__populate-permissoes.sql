
insert into perfil_permissao (view, insert, update, delete,permissao_id, perfil_id)
values (true, true, true, true, (select id from permissao where recurso like 'consulta' limit 1),
(select id from perfil where descricao like 'administrador' limit 1));

insert into perfil_permissao (view, insert, update, delete,permissao_id, perfil_id)
values (true, false, true, false, (select id from permissao where recurso like 'consulta' limit 1),
(select id from perfil where descricao like 'medico' limit 1));

insert into perfil_permissao (view, insert, update, delete,permissao_id, perfil_id)
values (true, false, false, false, (select id from permissao where recurso like 'consulta' limit 1),
(select id from perfil where descricao like 'paciente' limit 1));

insert into perfil_permissao (view, insert, update, delete,permissao_id, perfil_id)
values (true, true, false, false, (select id from permissao where recurso like 'consulta' limit 1),
(select id from perfil where descricao like 'enfermagem' limit 1));

