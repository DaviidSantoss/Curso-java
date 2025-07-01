insert into empresas (nome,cnpj)
values ("Microsfot",23901239817),
       ("Apple",23901239816),
       ("Vale",23901239815),
       ("Nvidea",23901239814);

--Nesse código alteramos o campo "cnpj" da tabela empresas
--onde o campo "cnpj" passou de "int" para varchar.
alter table empresas modify cnpj varchar(20);

--Esse códgio descreve como funciona a tabela "empresas"
desc empresas; 

select * from empresas;
select * from cidades;

insert into empresas_unidades(empresa_id,cidade_id,sede)
values(1,2,1),
      (2,1,1),
      (3,1,0);