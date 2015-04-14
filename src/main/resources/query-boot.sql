
CREATE TABLE Account(
   account_id  serial NOT NULL ,
   account_balance Double precision NOT NULL,
   customer_id integer NOT NULL,
   PRIMARY KEY (account_id)
);


CREATE TABLE Customer(
   customer_id serial NOT NULL,
   customer_name VARCHAR(20) NOT NULL,
   PRIMARY KEY (customer_id)
);

