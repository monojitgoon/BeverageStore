--DROP TABLE incentive;
CREATE TABLE incentive
(
    id integer NOT NULL,
    name character varying(255),
    incentivetype character varying(255),
	version integer,
  CONSTRAINT incentive_pkey PRIMARY KEY (id )
)
WITH (
    OIDS = FALSE
);
ALTER TABLE incentive
  OWNER TO tester;


--DROP TABLE Beverage;
CREATE TABLE Beverage
(
  id integer NOT NULL,
  manufacturer character varying(255),
  name character varying(255),
  quantity integer,
  price double precision,
  incentive_id integer,
  version integer,
  CONSTRAINT beverage_pkey PRIMARY KEY (id ),
  CONSTRAINT fk_beverage_incentive_id FOREIGN KEY (incentive_id)
      REFERENCES incentive (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE Beverage
  OWNER TO tester;
  
--DROP TABLE customerorder;
CREATE TABLE customerorder
(
    id integer NOT NULL,
    issuedate date,
    orderdetails_id integer,
	version integer,
  CONSTRAINT customerorder_pkey PRIMARY KEY (id ),
  CONSTRAINT fk_order_beverage_id FOREIGN KEY (beverage_id)
      REFERENCES beverage (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
);
ALTER TABLE customerorder
  OWNER TO tester;
  
  --DROP TABLE customerorderdetails;
CREATE TABLE customerorderdetails
(
    id integer NOT NULL,
    issuedate date,
    beverage_id integer,
	version integer,
  CONSTRAINT customerorder_pkey PRIMARY KEY (id ),
  CONSTRAINT fk_order_beverage_id FOREIGN KEY (beverage_id)
      REFERENCES beverage (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
);
ALTER TABLE customerorder
  OWNER TO tester;

-- Sequence: seq_gen_sequence

-- DROP SEQUENCE seq_gen_sequence;

CREATE SEQUENCE seq_gen_sequence
  INCREMENT 50
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 800
  CACHE 1;
ALTER TABLE seq_gen_sequence
  OWNER TO tester;