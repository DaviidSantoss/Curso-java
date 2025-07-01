--Selecionamos a tabela "regiao" e colocamos seu nome como
--"Região", após isso utilizamos o código "sum(populacao)" que é usado
--para somar a populacao das regiões e em seguida atribuimos a essa coluna o 
--nome "Total", após isso especificamos a tabela que seria usada que no caso era
--"estados", em seguida utilizamos o código (group by regiao) para podermos agrupar
--por regiao, e por ultimo ordenamos a coluna "Total" em ordem decrescente, através
--do código "order by Total desc"
select regiao as "Região",
sum(populacao) as Total
from estados 
group by regiao
order by Total desc

select sum(populacao) as Total from estados

--O código "avg" calcula a media dos estados
select avg(populacao) as Total from estados