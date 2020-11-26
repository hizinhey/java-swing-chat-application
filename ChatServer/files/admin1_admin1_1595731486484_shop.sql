--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5 (Ubuntu 11.5-3.pgdg16.04+1)
-- Dumped by pg_dump version 12.0

-- Started on 2019-11-19 15:45:41

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

--
-- TOC entry 196 (class 1259 OID 3524784)
-- Name: Blog; Type: TABLE; Schema: public; Owner: kqrntaewhwqkzy
--

CREATE TABLE public."Blog" (
    name character varying(100) NOT NULL,
    description text,
    date date NOT NULL,
    tag character varying(50)[],
    image character varying(100),
    content text NOT NULL,
    "ID" integer NOT NULL
);


ALTER TABLE public."Blog" OWNER TO kqrntaewhwqkzy;

--
-- TOC entry 3850 (class 0 OID 0)
-- Dependencies: 196
-- Name: TABLE "Blog"; Type: COMMENT; Schema: public; Owner: kqrntaewhwqkzy
--

COMMENT ON TABLE public."Blog" IS 'Data for blog';


--
-- TOC entry 197 (class 1259 OID 3524791)
-- Name: Blog_ID_seq; Type: SEQUENCE; Schema: public; Owner: kqrntaewhwqkzy
--

CREATE SEQUENCE public."Blog_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Blog_ID_seq" OWNER TO kqrntaewhwqkzy;

--
-- TOC entry 3851 (class 0 OID 0)
-- Dependencies: 197
-- Name: Blog_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kqrntaewhwqkzy
--

ALTER SEQUENCE public."Blog_ID_seq" OWNED BY public."Blog"."ID";


--
-- TOC entry 198 (class 1259 OID 3524793)
-- Name: chitiet_sanpham; Type: TABLE; Schema: public; Owner: kqrntaewhwqkzy
--

CREATE TABLE public.chitiet_sanpham (
    id character(8) NOT NULL,
    rong integer,
    dai integer,
    day integer,
    trongluong integer,
    ktchatluong boolean,
    nhanhieu character(20)
);


ALTER TABLE public.chitiet_sanpham OWNER TO kqrntaewhwqkzy;

--
-- TOC entry 3852 (class 0 OID 0)
-- Dependencies: 198
-- Name: TABLE chitiet_sanpham; Type: COMMENT; Schema: public; Owner: kqrntaewhwqkzy
--

COMMENT ON TABLE public.chitiet_sanpham IS 'Chi tiết các loại sản phẩm';


--
-- TOC entry 199 (class 1259 OID 3524797)
-- Name: sanpham; Type: TABLE; Schema: public; Owner: kqrntaewhwqkzy
--

CREATE TABLE public.sanpham (
    id_sanpham character(8) NOT NULL,
    ten_sanpham text,
    sl_sanpham integer,
    mota_sanpham text,
    loai_sanpham character(8),
    phanloai_sanpham text,
    gia_sanpham integer,
    hinh_sanpham text,
    link_sanpham text
);


ALTER TABLE public.sanpham OWNER TO kqrntaewhwqkzy;

--
-- TOC entry 3711 (class 2604 OID 3524803)
-- Name: Blog ID; Type: DEFAULT; Schema: public; Owner: kqrntaewhwqkzy
--

ALTER TABLE ONLY public."Blog" ALTER COLUMN "ID" SET DEFAULT nextval('public."Blog_ID_seq"'::regclass);


--
-- TOC entry 3840 (class 0 OID 3524784)
-- Dependencies: 196
-- Data for Name: Blog; Type: TABLE DATA; Schema: public; Owner: kqrntaewhwqkzy
--

COPY public."Blog" (name, description, date, tag, image, content, "ID") FROM stdin;
Gợi ý trang phục trẻ trung để đi chơi cùng bạn bè.	Hãy cùng tham khảo một vài gợi ý về trang phục đi bar, đi pub hay các câu lạc bộ đêm sau đây để trở thành một người trẻ thật trời trang và sành điệu nhé.	2019-10-15	{"Thời trang","Phong cách"}	/images/blog/single_blog_1.png	Cuối tuần đến lại khiến nhiều cô nàng đau đầu suy nghĩ làm sao có cách ăn mặc đẹp và thoải mái nhất để đi chơi. Nếu bạn chưa tìm ra style nào đẹp và tiện lợi nhất thì hãy tham khảo các gợi ý của chúng tôi dưới đây nhé!\n\nCác cách ăn mặc đơn giản mà đẹp này sẽ cho bạn những ngày vui chơi cuối tuần thoải mái mà không lo bị gò bó bởi trang phục. Chọn trang phục đi chơi từ chất liệu đến những kiểu dáng để cho mình sự thoải mái nhất, hoặc chọn trang phục đi chơi theo phong cách như vintage lãng mạn.\n\nCuộc đời quá ngắn ngủi để mặc trang phục nhàm chán\nKhông gì tiện lợi, thoáng mát hơn là những mẫu áo, váy freesize, tiện dụng vô cùng và vẫn giúp các cô nàng giữ được nét trẻ trung.\n\nNhững kiểu áo váy freesize này không những cho bạn một sự thoải mái mà còn giúp che những khuyết điểm cơ thể như béo bụng hay quá gầy giúp bạn tự tin diện đồ đi chơi\n\nBạn có thể mix quần jeans với áo phông Freesize pha ren tinh tế. Với bộ trang phục này bạn có thể mix cùng giày slip-on hay giày thể thao đều rất năng động	1
Samsung Galaxy S7 màn hình mới siêu nét	Sở hữu màn hình Super AMOLED với độ phân giải 2.560 x 1.440 pixel cho mật độ điểm ảnh 577 ppi. Màn hình trên Galaxy S7 cho thấy độ sáng vượt trội, tốt hơn 24% so với Galaxy S6.	2019-09-30	{"Công nghệ","Thiết kế"}	/images/blog/single_blog_2.png	No Content	2
Điểm mặt 4 mẫu giày cao gót đẹp nhất hiện nay	Giày cao gót nói chung luôn giúp chị em phụ nữ tôn dáng, lại vừa khẳng định được phong cách thời trang. Một cô nàng bước chân trên chiếc giày cao gót không những giúp thể hiện sự quý phái, thanh lịch mà còn làm trang phục và hình dáng của cô ấy trở nên nổi bật.	2019-09-20	{"Thời trang","Phong cách"}	/images/blog/single_blog_3.png	No Content	3
Top 5 các loại nước uống tốt cho sức khỏe	Sự tồn tại của nước là điều kiện đầu tiên để xác định sự tồn tại của sự sông. Ở đâu có nước ở đó có sự tồn tại. Nước chiếm đến 70% cơ thể, là thành phần quan trọng nhất trong cơ thể con người và tham gia vào hầu hết tất cả các hoạt động diễn ra bên trong cơ thể.	2019-08-28	{"Sức khỏe","Lối sống"}	/images/blog/single_blog_4.png	No Content	4
Ưu đãi sinh nhật giảm đến 20%, tháng 08 tha hồ mua sắm	Từ ngày 01/08 đến 31/08, Winter ưu đãi khách hàng có sinh nhật trong tháng 08. Khách hàng được giảm giá 20% khi mua sắm tại shop.	2019-08-01	{"Ưu đãi","Tin tức"}	/images/blog/single_blog_5.png	No Content	5
\.


--
-- TOC entry 3842 (class 0 OID 3524793)
-- Dependencies: 198
-- Data for Name: chitiet_sanpham; Type: TABLE DATA; Schema: public; Owner: kqrntaewhwqkzy
--

COPY public.chitiet_sanpham (id, rong, dai, day, trongluong, ktchatluong, nhanhieu) FROM stdin;
\.


--
-- TOC entry 3843 (class 0 OID 3524797)
-- Dependencies: 199
-- Data for Name: sanpham; Type: TABLE DATA; Schema: public; Owner: kqrntaewhwqkzy
--

COPY public.sanpham (id_sanpham, ten_sanpham, sl_sanpham, mota_sanpham, loai_sanpham, phanloai_sanpham, gia_sanpham, hinh_sanpham, link_sanpham) FROM stdin;
IDP00001	Váy trắng	50	Thích hợp cho các buổi tiệc sang trọng và tao nhã	Váy     	Thời trang nữ	340000	/images/product_details/prodect_details_1.png	shop/1
IDP00002	Áo thun đá bóng	50	Thun colton thoáng mát, dễ dàng cho các hoạt động ngoài trời.	Áo      	Thời trang nam	100000	/images/category/category_2.png	shop/1
IDP00003	Áo sơ mi caro Hàn Quốc	50	Áo thời trang năng động, có thể làm áo khoác. Thích hợp cho những chuỗi ngày party cùng bạn bè.	Áo      	Thời trang nam	250000	/images/arrivel/arrivel_2.png	shop/1
IDP00004	Váy đen	50	Váy đen trang nhã, phù hợp cho các chị em thích phong cách bí ẩn	Váy     	Thời trang nữ	350000	/images/category/category_4.png	shop/4
IDP00005	Áo thun tay dài	50	Chiếc áo tay dài thời trang thích hợp khi trời lạnh	Áo      	Thời trang nữ	150000	/images/category/category_5.png	shop/5
IDP00006	Áo thun giả bộ đội	50	Áo thun phong cách mạnh mẽ dành cho các bạn có lòng nồng nàn yêu nước	Áo      	Thời trang nam	200000	/images/category/category_6.png	shop/6
IDP00007	Váy lam	50	Cũng là váy nhưng nó có màu lam đặc trưng, thích hợp cho ai thích biển	Váy     	Thời trang nữ	260000	/images/category/category_7.png	shop/7
IDP00008	Áo khoác jean	50	Thòi trang đại trà, chắc hẳn không ai còn xa lạ với loại trang phục này nữa	Áo khoác	Thời trang nam	250000	/images/category/category_8.png	shop/8
IDP00009	Giày Nike	50	Giày thể thao mạnh mẽ, thích hợp cho thể thao, đi chơi, du lịch....	Giày    	Giày	500000	/images/category/category_9.png	shop/9
IDP00010	Váy đa sắc	50	Váy sặc sỡ, nhiều màu, năng động, trẻ trunng.	Váy     	Thời trang nữ	280000	/images/category/category_10.png	shop/10
IDP00011	Váy đen bó	50	Váy bó gợi cảm, cổ chẻ táo bạo	Váy     	Thời trang nữ	320000	/images/category/category_11.png	shop/11
IDP00012	Khoác jean denim	50	Khoác jean nam denim, dành cho các chàng phong cách bụi	Áo khoác	Thời trang nam	230000	/images/category/category_12.png	shop/12
\.


--
-- TOC entry 3853 (class 0 OID 0)
-- Dependencies: 197
-- Name: Blog_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: kqrntaewhwqkzy
--

SELECT pg_catalog.setval('public."Blog_ID_seq"', 5, true);


--
-- TOC entry 3713 (class 2606 OID 3524805)
-- Name: Blog Blog_pkey; Type: CONSTRAINT; Schema: public; Owner: kqrntaewhwqkzy
--

ALTER TABLE ONLY public."Blog"
    ADD CONSTRAINT "Blog_pkey" PRIMARY KEY ("ID");


--
-- TOC entry 3715 (class 2606 OID 3524807)
-- Name: chitiet_sanpham chitiet_sanpham_pkey; Type: CONSTRAINT; Schema: public; Owner: kqrntaewhwqkzy
--

ALTER TABLE ONLY public.chitiet_sanpham
    ADD CONSTRAINT chitiet_sanpham_pkey PRIMARY KEY (id);


--
-- TOC entry 3717 (class 2606 OID 3524809)
-- Name: sanpham sanpham_pkey; Type: CONSTRAINT; Schema: public; Owner: kqrntaewhwqkzy
--

ALTER TABLE ONLY public.sanpham
    ADD CONSTRAINT sanpham_pkey PRIMARY KEY (id_sanpham);


--
-- TOC entry 3718 (class 2606 OID 3524810)
-- Name: chitiet_sanpham id; Type: FK CONSTRAINT; Schema: public; Owner: kqrntaewhwqkzy
--

ALTER TABLE ONLY public.chitiet_sanpham
    ADD CONSTRAINT id FOREIGN KEY (id) REFERENCES public.sanpham(id_sanpham) NOT VALID;


--
-- TOC entry 3849 (class 0 OID 0)
-- Dependencies: 604
-- Name: LANGUAGE plpgsql; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON LANGUAGE plpgsql TO kqrntaewhwqkzy;


-- Completed on 2019-11-19 15:46:12

--
-- PostgreSQL database dump complete
--

