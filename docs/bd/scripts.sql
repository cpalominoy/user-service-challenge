create table if not exists users
(
    id         bigint auto_increment primary key COMMENT 'Identificador único interno del usuario',
    is_active  bit          null COMMENT 'Si el usuario se encuentra activo',
    code       varchar(255) not null COMMENT 'código único publico del usuario - UUID',
    email      varchar(255) not null COMMENT 'correo único del usuario',
    last_login datetime(6)  null COMMENT 'Ultima sesión del usuario',
    name       varchar(255) not null COMMENT 'Nombre del usuario',
    password   varchar(255) not null COMMENT 'Password del usuario',
    token      varchar(255) null COMMENT 'Token JWT',
    created_at datetime(6)  null COMMENT 'Fecha de creación',
    created_by varchar(255) not null COMMENT 'Usuario creador',
    updated_at datetime(6)  null COMMENT 'Fecha de actualización',
    updated_by varchar(255) null COMMENT 'Usuario actualizó',
    constraint UK_email_user unique (email),
    constraint UK_code_user unique (code)
    );

create table if not exists phones
(
    id           bigint auto_increment primary key COMMENT 'Identificador único del phone',
    city_code    varchar(255) not null COMMENT 'Código de la ciudad',
    country_code varchar(255) null COMMENT 'Código del país',
    number       varchar(255) not null COMMENT 'numero telefónico del usuario',
    user_id      bigint       null COMMENT 'FK de la tabla users',
    created_at datetime(6)  null COMMENT 'Fecha de creación',
    created_by varchar(255) not null COMMENT 'Usuario creador',
    updated_at datetime(6)  null COMMENT 'Fecha de actualización',
    updated_by varchar(255) null COMMENT 'Usuario actualizó',
    constraint FK_user_phone foreign key (user_id) references users (id)
    );

