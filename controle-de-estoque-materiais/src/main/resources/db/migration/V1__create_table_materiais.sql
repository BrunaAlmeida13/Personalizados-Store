CREATE TABLE materiais (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    cor varchar(100) not null,
    descricao varchar(100),
    quantidade_em_estoque int not null check (quantidade_em_estoque >= 0),
    preco decimal(10, 2) not null check (preco >= 0),

    primary key(id)
);