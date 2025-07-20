create table if not exists auth.users (
    id uuid PRIMARY KEY,
    email varchar(255) UNIQUE NOT NULL,
    password varchar(255) NOT null,
    role varchar(255) NOT NULL,
    created_at timestamp default current_timestamp
);
