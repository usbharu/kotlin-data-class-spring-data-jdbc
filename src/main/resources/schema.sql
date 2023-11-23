create table if not exists ITEM
(
    ID    BIGINT not null constraint ITEM_PK primary key auto_increment,
    "VALUE" varchar not null
);
