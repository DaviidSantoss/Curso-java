--Criando Tabela Estado.

create table estados (
   --O id é unsigned("Sem sinal") e é auto incrementado
    id int unsigned not null auto_increment,
    nome varchar(45) not null,
    sigla varchar(2) not null,
    regiao enum('norte','nordeste','centro-oeste','sudeste','sul') not null ,
    --A "populacao" pode conter 5 numeros decimais e 2 números depois da virgula
    populacao decimal(5,2) not null,
    primary key (id),
    --unique é utilizado para garantir valores unicos na tabela, ou seja,
    --só pode ter um nome e uma sigla de cada estado.
    unique key(nome),
    unique key(sigla)
);

 
 