create table  IF NOT EXISTS respuestas(
id bigint not null auto_increment,
mensaje varchar(100) not null,
fecha_creacion datetime not null,
solucion varchar(255) not null,
topico_id bigint not null,
primary key (id),
constraint fk_respuestas_topico_id foreign key(topico_id) references topicos(id)
)