

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


--insert user (password: 12345)
insert into public.user (id,address,cpf,delivery_address, email, first_name, last_name, password_hash, role)
values (1, null, '12345678909', null, 'andre@gmail.com', 'andre', 'zanella', '$2a$10$lmA9vGVr7F/1ycxBALWJmunj4xEk6V9hU9/qKiGQWOUUykZpiuqva', 'ADMIN'),
(2, null, '98765432121', null, 'victor@gmail.com', 'victor', 'hugo', '$2a$10$lmA9vGVr7F/1ycxBALWJmunj4xEk6V9hU9/qKiGQWOUUykZpiuqva', 'CLIENT')

--insert products
INSERT INTO product_storage (id, quantity, size) VALUES
(1, 5, 'M'),
(2, 5, 'M'),
(3, 5, 'M'),
(4, 5, 'M'),
(5, 5, 'M'),
(6, 5, 'M'),
(7, 5, 'G');

insert into product (id, name, photo_url, price) values
(1, 'camisa barça', 'https://shoxstore.com.br/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/c/a/camisa-barcelona-barca-2022-2023-home-azul-grena-e-vermelha-nike-61-c583d5bf21bc40f27f16548649509918-1024-1024.png', 30),
(2, 'camisa Real', 'https://cdn.sistemawbuy.com.br/arquivos/d1ae3fe0c225cf59cbdf748aaa4635f3/produtos/SEI5WIO3/camisa-real-madrid-1-me-dia-2-63d037d07071f.jpeg', 35),
(3, 'camisa liverpool', 'https://imgcentauro-a.akamaihd.net/900x900/9726473I/camisa-liverpool-i-22-23-torcedor-nike-masculina-img.jpg', 50),
(4, 'camisa byern', 'https://images.tcdn.com.br/img/img_prod/1044362/camisa_bayern_de_munique_iii_22_23_adidas_torcedor_masculina_preta_1997_1_aaf9c7c29d30e215ed81d94c237eb039.jpg', 33),
(5, 'camisa saopaulo', 'https://static.saopaulomania.com.br/produtos/camisa-sao-paulo-i-2223-gabriel-sara-n-21-torcedor-adidas-masculina/14/3ZP-9420-014/3ZP-9420-014_zoom2.jpg?ts=1655746368', 45),
(6, 'camisa milan', 'https://images.tcdn.com.br/img/img_prod/638286/camisa_manga_longa_ac_milan_2023_uniforme_titular_dry_cell_4613_1_f8fc007b758ab74d7389dca774c9b021.jpg', 55);

insert into product_product_storages(product_id, product_storages_id) values
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(1,7);