create table if not exists prefeitos(
    id int unsigned not null auto_increment,
    nome varchar(255) not null,
    --Essa é nossa chave estrangeira
    cidade_id int unsigned,
    primary key(id),
    --a chave estrangeira deve ser unica
    unique key (cidade_id),
    --a nossa chave estrangeira "cidade_id" esta referenciando
    --o campo "id" da tabela cidades.
    foreign key (cidade_id) references cidades(id)
);