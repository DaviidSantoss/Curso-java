create table if not exists empresas(
    id int unsigned not null auto_increment,
    nome varchar(255) not null,
    cnpj int unsigned,
    primary key(id),
    unique key(cnpj)
);

create table if not exists empresas_unidades(
    -- Define a coluna "empresa_id" como um inteiro sem sinal, obrigatório (não pode ser nulo).
    empresa_id int unsigned not null,
    -- Define a coluna "cidade_id" como um inteiro sem sinal, obrigatório (não pode ser nulo).
    cidade_id int unsigned not null,
    -- Define a coluna "sede" como um valor booleano (0 ou 1), obrigatório (não pode ser nulo).
    -- Esta coluna provavelmente indica se a unidade da empresa é a sede principal (1) ou não (0).
    sede tinyint(1) not null,
    -- Define uma chave primária composta pelas colunas "empresa_id" e "cidade_id".
    -- Isso garante que cada combinação de "empresa_id" e "cidade_id" seja única,
    -- ou seja, uma empresa pode ter apenas uma unidade por cidade.
    primary key (empresa_id , cidade_id)
);