CREATE TABLE PUBLIC.price (
	id varchar not null,
	brand_id varchar not null,
	start_date timestamp not null,
	end_date timestamp not null,
	price_list int not null,
	product_id int8 not null,
	priority int not null,
	price double not null,
	curr varchar(5) not null,
	primary key (id)
);

insert into public.price(id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
	values (random_uuid(), 1, (TO_TIMESTAMP('2020-06-14-00.00.00', 'YYYY-MM-DD-HH24.MI.SS')), (TO_TIMESTAMP('2020-12-31-23.59.59',  'YYYY-MM-DD-HH24.MI.SS')), 1, 35455, 0, 35.50, 'EUR');
insert into public.price(id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
	values (random_uuid(), 1, (TO_TIMESTAMP('2020-06-14-15.00.00', 'YYYY-MM-DD-HH24.MI.SS')), (TO_TIMESTAMP('2020-06-14-18.30.00',  'YYYY-MM-DD-HH24.MI.SS')), 2, 35455, 1, 25.45, 'EUR');
insert into public.price(id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
	values (random_uuid(), 1, (TO_TIMESTAMP('2020-06-15-00.00.00', 'YYYY-MM-DD-HH24.MI.SS')), (TO_TIMESTAMP('2020-06-15-11.00.00',  'YYYY-MM-DD-HH24.MI.SS')), 3, 35455, 1, 30.50, 'EUR');
insert into public.price(id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
	values (random_uuid(), 1, (TO_TIMESTAMP('2020-06-15-16.00.00', 'YYYY-MM-DD-HH24.MI.SS')), (TO_TIMESTAMP('2020-12-31-23.59.59',  'YYYY-MM-DD-HH24.MI.SS')), 4, 35455, 1, 38.95, 'EUR');