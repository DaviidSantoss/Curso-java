--Aqui fizemos a seleção do seguinte modo, selecione da tabela
--"estados e" e "cidades c ", onde o id do "estado" seja igual ao
-- estado_id da tabela "cidade".
select * from estados e, cidades c
where e.id = c.estado_id;

-- Neste SELECT, estamos renomeando algumas colunas para facilitar a leitura dos resultados:
-- "c.nome" está sendo renomeado como "Cidade", que representa o nome da cidade.
-- "e.nome" está sendo renomeado como "Estado", que representa o nome do estado.
-- A coluna "regiao" está sendo renomeada como "Região", representando a região.
-- A seleção de "e.nome" e "regiao" vem da tabela "estados e", que é referenciada na junção.
-- Estamos fazendo um INNER JOIN entre as tabelas "estados e" e "cidades c" onde "e.id" 
--(ID do estado) corresponde a "c.estado_id" (ID do estado na tabela de cidades).
select c.nome as Cidade,
       e.nome as Estado,
       regiao as Região
from estados e
inner join  cidades c on  e.id= c.estado_id