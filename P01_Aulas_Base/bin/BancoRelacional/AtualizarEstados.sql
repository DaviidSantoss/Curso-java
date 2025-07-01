--Esse código nos diz o seguinte, atualize a tabela "estados"
--setando nome para "Maranhão" onde a sigla é "MA".
update estados
set nome  = 'Maranhão'
where sigla = 'MA'

select nome from estados where sigla = 'MA'

update estados 
set nome = 'Paraná', populacao = 11.32
where sigla = 'PR'

select nome, populacao from estados where sigla = "PR"