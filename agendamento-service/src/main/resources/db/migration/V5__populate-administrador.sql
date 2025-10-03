
insert into permissao (recurso)
values ('perfil'),('permissao','usuario_perfil','perfil_permissao');

INSERT INTO perfil_permissao (view, insert, update, delete, permissao_id, perfil_id)
SELECT
    TRUE, TRUE, TRUE, TRUE,
    p.id,
    adm.id
FROM permissao p
CROSS JOIN (
    SELECT id FROM perfil WHERE descricao ILIKE 'administrador' LIMIT 1
) adm
LEFT JOIN perfil_permissao pp
    ON pp.permissao_id = p.id AND pp.perfil_id = adm.id
WHERE pp.permissao_id IS NULL;

