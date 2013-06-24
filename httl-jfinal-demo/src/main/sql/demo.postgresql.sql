CREATE TABLE books
(
  id serial NOT NULL,
  title character varying(64) NOT NULL, -- 书名
  author character varying(32) NOT NULL, -- 作者
  publisher character varying(32) NOT NULL, -- 出版商
  publication timestamp without time zone DEFAULT now(), -- 出版日期
  price numeric(5,2) NOT NULL, -- 价格
  discount smallint NOT NULL DEFAULT 0, -- 折扣
  CONSTRAINT books_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE books
  OWNER TO postgres;
COMMENT ON COLUMN books.title IS '书名';
COMMENT ON COLUMN books.author IS '作者';
COMMENT ON COLUMN books.publisher IS '出版商';
COMMENT ON COLUMN books.publication IS '出版日期';
COMMENT ON COLUMN books.price IS '价格';
COMMENT ON COLUMN books.discount IS '折扣';
