--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: ect; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE ect WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';


ALTER DATABASE ect OWNER TO postgres;

\connect ect

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    idcliente bigint NOT NULL,
    ci bigint,
    apellido_cliente character varying(255),
    nombre_cliente character varying(255)
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- Name: clientes_idcliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clientes_idcliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.clientes_idcliente_seq OWNER TO postgres;

--
-- Name: clientes_idcliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clientes_idcliente_seq OWNED BY public.clientes.idcliente;


--
-- Name: productos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.productos (
    id bigint NOT NULL,
    cantidad integer NOT NULL,
    nombre character varying(255) NOT NULL,
    precio integer NOT NULL
);


ALTER TABLE public.productos OWNER TO postgres;

--
-- Name: productos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.productos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.productos_id_seq OWNER TO postgres;

--
-- Name: productos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.productos_id_seq OWNED BY public.productos.id;


--
-- Name: transacciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transacciones (
    id_transaccion bigint NOT NULL,
    cantidad integer NOT NULL,
    idcliente_proveedor bigint,
    id_producto bigint,
    tipo_transaccion character varying(255)
);


ALTER TABLE public.transacciones OWNER TO postgres;

--
-- Name: transacciones_id_transaccion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transacciones_id_transaccion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.transacciones_id_transaccion_seq OWNER TO postgres;

--
-- Name: transacciones_id_transaccion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transacciones_id_transaccion_seq OWNED BY public.transacciones.id_transaccion;


--
-- Name: clientes idcliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes ALTER COLUMN idcliente SET DEFAULT nextval('public.clientes_idcliente_seq'::regclass);


--
-- Name: productos id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos ALTER COLUMN id SET DEFAULT nextval('public.productos_id_seq'::regclass);


--
-- Name: transacciones id_transaccion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transacciones ALTER COLUMN id_transaccion SET DEFAULT nextval('public.transacciones_id_transaccion_seq'::regclass);


--
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clientes (idcliente, ci, apellido_cliente, nombre_cliente) FROM stdin;
1	3294203	Portillo	Jose
2	5099286	Gonzalez	Isaac
3	2225217	Ayala	Maria
4	452345	Pascal	Pedro
\.


--
-- Data for Name: productos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.productos (id, cantidad, nombre, precio) FROM stdin;
2	0	ProductoB	20000
1	2	ProductoA	500000
\.


--
-- Data for Name: transacciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transacciones (id_transaccion, cantidad, idcliente_proveedor, id_producto, tipo_transaccion) FROM stdin;
1	3	1	1	Compra
2	1	1	1	Venta
\.


--
-- Name: clientes_idcliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientes_idcliente_seq', 4, true);


--
-- Name: productos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.productos_id_seq', 2, true);


--
-- Name: transacciones_id_transaccion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transacciones_id_transaccion_seq', 2, true);


--
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (idcliente);


--
-- Name: productos productos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (id);


--
-- Name: transacciones transacciones_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transacciones
    ADD CONSTRAINT transacciones_pkey PRIMARY KEY (id_transaccion);


--
-- Name: clientes uk_hfva8vj9sldqqnokwflk783ni; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT uk_hfva8vj9sldqqnokwflk783ni UNIQUE (ci);


--
-- Name: productos uk_mlgw7js72hh2xtd4mvpdqfsbe; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productos
    ADD CONSTRAINT uk_mlgw7js72hh2xtd4mvpdqfsbe UNIQUE (nombre);


--
-- PostgreSQL database dump complete
--

