select * from  estados

--o comando 'as' serve para darmos nome a uma coluna
select sigla, nome as 'Nome do Estado' from estados
where regiao = 'Sul'

--Nessa seleção selecionamos o "nome", "regiao"
--da tabela "estados" onde a populacao e maior ou igual a 10
--e ordenamos a coluna da "populacao" em ordem "decrescente".
select nome, regiao from estados
where populacao >= 10
order by populacao desc