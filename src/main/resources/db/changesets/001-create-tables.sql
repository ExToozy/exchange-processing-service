create table "user"
(
    id bigint generated always as identity primary key
);

create table account
(
    id            bigint generated always as identity primary key,
    user_id       bigint     not null,
    currency_code varchar(3) not null,
    balance       numeric    not null,
    constraint fk_account_user foreign key (user_id) references "user" (id)
)