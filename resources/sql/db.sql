

-- DROP DATABASE postgres WITH (FORCE)

-- SELECT pg_terminate_backend(procpid) FROM pg_stat_activity WHERE datname = 'postgres';

-- SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = 'postgres';

CREATE DATABASE postgres
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;