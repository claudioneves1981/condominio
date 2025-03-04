PGDMP         &                y            condominiobd    11.12    11.12                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    24872    condominiobd    DATABASE     �   CREATE DATABASE condominiobd WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE condominiobd;
             postgres    false            �            1259    24906    proprietario    TABLE     v  CREATE TABLE public.proprietario (
    codigo integer NOT NULL,
    apto character varying(255),
    bairro character varying(255),
    bloco character varying(255),
    cep character varying(255),
    cidade character varying(255),
    complemento character varying(255),
    cpf character varying(255),
    data_cadastro character varying(255),
    email character varying(255),
    endereco character varying(255),
    estado character varying(255),
    nome character varying(255),
    numero character varying(255),
    pesquisa character varying(255),
    telefone character varying(255),
    tipo character varying(255)
);
     DROP TABLE public.proprietario;
       public         postgres    false            �            1259    24904    proprietario_codigo_seq    SEQUENCE     �   CREATE SEQUENCE public.proprietario_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.proprietario_codigo_seq;
       public       postgres    false    201                       0    0    proprietario_codigo_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.proprietario_codigo_seq OWNED BY public.proprietario.codigo;
            public       postgres    false    200            �            1259    24879    seq_proprietario    SEQUENCE     y   CREATE SEQUENCE public.seq_proprietario
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.seq_proprietario;
       public       postgres    false            �            1259    24881    seq_usuario    SEQUENCE     t   CREATE SEQUENCE public.seq_usuario
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.seq_usuario;
       public       postgres    false            �            1259    24895    usuario    TABLE     �   CREATE TABLE public.usuario (
    codigo integer NOT NULL,
    documento character varying(255),
    nome character varying(255),
    observacao character varying(255),
    pesquisa character varying(255),
    tipo character varying(255)
);
    DROP TABLE public.usuario;
       public         postgres    false            �            1259    24893    usuario_codigo_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.usuario_codigo_seq;
       public       postgres    false    199                       0    0    usuario_codigo_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.usuario_codigo_seq OWNED BY public.usuario.codigo;
            public       postgres    false    198            �
           2604    24909    proprietario codigo    DEFAULT     z   ALTER TABLE ONLY public.proprietario ALTER COLUMN codigo SET DEFAULT nextval('public.proprietario_codigo_seq'::regclass);
 B   ALTER TABLE public.proprietario ALTER COLUMN codigo DROP DEFAULT;
       public       postgres    false    200    201    201            �
           2604    24898    usuario codigo    DEFAULT     p   ALTER TABLE ONLY public.usuario ALTER COLUMN codigo SET DEFAULT nextval('public.usuario_codigo_seq'::regclass);
 =   ALTER TABLE public.usuario ALTER COLUMN codigo DROP DEFAULT;
       public       postgres    false    198    199    199                      0    24906    proprietario 
   TABLE DATA               �   COPY public.proprietario (codigo, apto, bairro, bloco, cep, cidade, complemento, cpf, data_cadastro, email, endereco, estado, nome, numero, pesquisa, telefone, tipo) FROM stdin;
    public       postgres    false    201   �                 0    24895    usuario 
   TABLE DATA               V   COPY public.usuario (codigo, documento, nome, observacao, pesquisa, tipo) FROM stdin;
    public       postgres    false    199                     0    0    proprietario_codigo_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.proprietario_codigo_seq', 1, false);
            public       postgres    false    200                       0    0    seq_proprietario    SEQUENCE SET     >   SELECT pg_catalog.setval('public.seq_proprietario', 5, true);
            public       postgres    false    196                       0    0    seq_usuario    SEQUENCE SET     9   SELECT pg_catalog.setval('public.seq_usuario', 3, true);
            public       postgres    false    197                       0    0    usuario_codigo_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.usuario_codigo_seq', 1, true);
            public       postgres    false    198            �
           2606    24914    proprietario proprietario_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.proprietario
    ADD CONSTRAINT proprietario_pkey PRIMARY KEY (codigo);
 H   ALTER TABLE ONLY public.proprietario DROP CONSTRAINT proprietario_pkey;
       public         postgres    false    201            �
           2606    24903    usuario usuario_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (codigo);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public         postgres    false    199                  x������ � �         !   x�3�,I-.IE!c�8���Ĕ�"�=... �0�     