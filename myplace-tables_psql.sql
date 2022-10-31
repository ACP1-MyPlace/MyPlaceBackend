
    create table accommodation_services (
       accommodation_id int8 not null,
        service int4 not null
    );

    create table accommodations (
       id  bigserial not null,
        apartment varchar(255),
        bathroom_count int4 not null,
        country varchar(255) not null,
        description varchar(255),
        floor varchar(255),
        garage_available boolean not null,
        pets_available boolean not null,
        price_amount int8 not null,
        price_currency_id varchar(255) not null,
        property_type int4 not null,
        rooms_count int4 not null,
        state varchar(255) not null,
        street varchar(255) not null,
        street_number int4 not null,
        user_id int8,
        primary key (id)
    );

    create table users (
       user_id  bigserial not null,
        email varchar(255) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        type int4 not null,
        primary key (user_id)
    );

    alter table accommodation_services 
       add constraint FKcabi4597a482wft99j593fkj3 
       foreign key (accommodation_id) 
       references accommodations;

    alter table accommodations 
       add constraint FKp0dg4bgd1dnioaadgcdb9ccvi 
       foreign key (user_id) 
       references users;

    create table accommodation_services (
       accommodation_id int8 not null,
        service int4 not null
    );

    create table accommodations (
       id  bigserial not null,
        apartment varchar(255),
        bathroom_count int4 not null,
        country varchar(255) not null,
        description varchar(255),
        floor varchar(255),
        garage_available boolean not null,
        pets_available boolean not null,
        price_amount int8 not null,
        price_currency_id varchar(255) not null,
        property_type int4 not null,
        rooms_count int4 not null,
        state varchar(255) not null,
        street varchar(255) not null,
        street_number int4 not null,
        user_id int8,
        primary key (id)
    );

    create table users (
       user_id  bigserial not null,
        email varchar(255) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        type int4 not null,
        primary key (user_id)
    );

    alter table accommodation_services 
       add constraint FKcabi4597a482wft99j593fkj3 
       foreign key (accommodation_id) 
       references accommodations;

    alter table accommodations 
       add constraint FKp0dg4bgd1dnioaadgcdb9ccvi 
       foreign key (user_id) 
       references users;

    create table accommodation_services (
       accommodation_id int8 not null,
        service int4 not null
    );

    create table accommodations (
       id  bigserial not null,
        apartment varchar(255),
        bathroom_count int4 not null,
        country varchar(255) not null,
        description varchar(255),
        floor varchar(255),
        garage_available boolean not null,
        pets_available boolean not null,
        price_amount int8 not null,
        price_currency_id varchar(255) not null,
        property_type int4 not null,
        rooms_count int4 not null,
        state varchar(255) not null,
        street varchar(255) not null,
        street_number int4 not null,
        user_id int8,
        primary key (id)
    );

    create table users (
       user_id  bigserial not null,
        email varchar(255) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        type int4 not null,
        primary key (user_id)
    );

    alter table accommodation_services 
       add constraint FKcabi4597a482wft99j593fkj3 
       foreign key (accommodation_id) 
       references accommodations;

    alter table accommodations 
       add constraint FKp0dg4bgd1dnioaadgcdb9ccvi 
       foreign key (user_id) 
       references users;
