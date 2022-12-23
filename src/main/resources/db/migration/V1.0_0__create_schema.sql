create table contato
(
    id serial not null,
    numero_telefone text,
    numero_celular text,
    possui_whats_app boolean,
    email text,
    constraint contato_pk primary key (id)
);

create table pessoa
(
    id serial not null,
    nome text not null,
    nome_pai text,
    nome_mae text,
    cpf text,
    data_nascimento timestamp not null,
    contato_id int,
    constraint pessoa_pk primary key (id),
    constraint FK_CONTATO foreign key (contato_id) references contato(id)
);
