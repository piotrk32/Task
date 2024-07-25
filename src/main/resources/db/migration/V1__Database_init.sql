CREATE SEQUENCE IF NOT EXISTS id_seq AS BIGINT START WITH 1000;

CREATE TABLE stars (
                       id BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('id_seq'),
                       star_name VARCHAR(255) NOT NULL,
                       distance BIGINT NOT NULL,
                       created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
                       modified_at TIMESTAMP WITHOUT TIME ZONE
);