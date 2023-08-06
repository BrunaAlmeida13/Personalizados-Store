alter table materiais add column categoria_id bigint not null,
add constraint fk_categoria foreign key (categoria_id) references categorias (id);