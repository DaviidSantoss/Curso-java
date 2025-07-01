select * from estados


insert into cidades(nome,area,estado_id)
values("Campinas",795,25)

insert into cidades(nome,area,estado_id)
values("Niteroi",135.9,19)

insert into cidades(id,nome,area,estado_id)
values(2,"Bom Repouso",50,19)

--Ao invés de termos que inserir um "id" especifico, fizemos um código que
--seleciona o "id" da tabela "estados" onde a sigla seja "PE"
insert into cidades(nome,area,estado_id)
values("Caruaru",920.6,(select id from estados where sigla = "PE"))

insert into cidades(nome,area,estado_id)
values("Juazeiro do Norte",248.2,(select id from estados where sigla = "CE"))

select * from cidades