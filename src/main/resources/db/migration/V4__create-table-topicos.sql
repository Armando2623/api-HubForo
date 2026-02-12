create table  IF NOT EXISTS topicos(
id bigint not null auto_increment,
titulo varchar(100) not null,
mensaje varchar(100) not null,
fecha_creacion datetime not null,
estado TINYINT(1) NOT NULL DEFAULT 1,
autor_id bigint not null,
curso_id bigint not null,
respuesta_id bigint,
primary key (id),
constraint fk_topicos_autor_id foreign key(autor_id) references usuarios(id),
constraint fk_topicos_curso_id foreign key(curso_id) references cursos(id)
)