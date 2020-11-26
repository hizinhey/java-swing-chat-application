--
-- PostgreSQL database dump
--

-- Dumped from database version 12.0
-- Dumped by pg_dump version 12.0

-- Started on 2019-11-12 19:29:45

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
-- TOC entry 202 (class 1259 OID 16394)
-- Name: Blog; Type: TABLE; Schema: public; Owner: postgres
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


ALTER TABLE public."Blog" OWNER TO postgres;

--
-- TOC entry 2824 (class 0 OID 0)
-- Dependencies: 202
-- Name: TABLE "Blog"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public."Blog" IS 'Data for blog';


--
-- TOC entry 203 (class 1259 OID 16400)
-- Name: Blog_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Blog_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Blog_ID_seq" OWNER TO postgres;

--
-- TOC entry 2825 (class 0 OID 0)
-- Dependencies: 203
-- Name: Blog_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Blog_ID_seq" OWNED BY public."Blog"."ID";


--
-- TOC entry 2688 (class 2604 OID 16402)
-- Name: Blog ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Blog" ALTER COLUMN "ID" SET DEFAULT nextval('public."Blog_ID_seq"'::regclass);


--
-- TOC entry 2817 (class 0 OID 16394)
-- Dependencies: 202
-- Data for Name: Blog; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Blog" (name, description, date, tag, image, content, "ID") FROM stdin;
Gợi ý trang phục trẻ trung để đi chơi cùng bạn bè.	Hãy cùng tham khảo một vài gợi ý về trang phục đi bar, đi pub hay các câu lạc bộ đêm sau đây để trở thành một người trẻ thật trời trang và sành điệu nhé.	2019-10-15	{"Thời trang","Phong cách"}	/images/blog/single_blog_1.png	Cuối tuần đến lại khiến nhiều cô nàng đau đầu suy nghĩ làm sao có cách ăn mặc đẹp và thoải mái nhất để đi chơi. Nếu bạn chưa tìm ra style nào đẹp và tiện lợi nhất thì hãy tham khảo các gợi ý của chúng tôi dưới đây nhé!\n\nCác cách ăn mặc đơn giản mà đẹp này sẽ cho bạn những ngày vui chơi cuối tuần thoải mái mà không lo bị gò bó bởi trang phục. Chọn trang phục đi chơi từ chất liệu đến những kiểu dáng để cho mình sự thoải mái nhất, hoặc chọn trang phục đi chơi theo phong cách như vintage lãng mạn.\n\nCuộc đời quá ngắn ngủi để mặc trang phục nhàm chán\nKhông gì tiện lợi, thoáng mát hơn là những mẫu áo, váy freesize, tiện dụng vô cùng và vẫn giúp các cô nàng giữ được nét trẻ trung.\n\nNhững kiểu áo váy freesize này không những cho bạn một sự thoải mái mà còn giúp che những khuyết điểm cơ thể như béo bụng hay quá gầy giúp bạn tự tin diện đồ đi chơi\n\nBạn có thể mix quần jeans với áo phông Freesize pha ren tinh tế. Với bộ trang phục này bạn có thể mix cùng giày slip-on hay giày thể thao đều rất năng động	1
Samsung Galaxy S7 màn hình mới siêu nét	Sở hữu màn hình Super AMOLED với độ phân giải 2.560 x 1.440 pixel cho mật độ điểm ảnh 577 ppi. Màn hình trên Galaxy S7 cho thấy độ sáng vượt trội, tốt hơn 24% so với Galaxy S6.	2019-09-30	{"Công nghệ","Thiết kế"}	/images/blog/single_blog_2.png	No Content	2
Điểm mặt 4 mẫu giày cao gót đẹp nhất hiện nay	Giày cao gót nói chung luôn giúp chị em phụ nữ tôn dáng, lại vừa khẳng định được phong cách thời trang. Một cô nàng bước chân trên chiếc giày cao gót không những giúp thể hiện sự quý phái, thanh lịch mà còn làm trang phục và hình dáng của cô ấy trở nên nổi bật.	2019-09-20	{"Thời trang","Phong cách"}	/images/blog/single_blog_3.png	No Content	3
Top 5 các loại nước uống tốt cho sức khỏe	Sự tồn tại của nước là điều kiện đầu tiên để xác định sự tồn tại của sự sông. Ở đâu có nước ở đó có sự tồn tại. Nước chiếm đến 70% cơ thể, là thành phần quan trọng nhất trong cơ thể con người và tham gia vào hầu hết tất cả các hoạt động diễn ra bên trong cơ thể.	2019-08-28	{"Sức khỏe","Lối sống"}	/images/blog/single_blog_4.png	No Content	4
Ưu đãi sinh nhật giảm đến 20%, tháng 08 tha hồ mua sắm	Từ ngày 01/08 đến 31/08, Winter ưu đãi khách hàng có sinh nhật trong tháng 08. Khách hàng được giảm giá 20% khi mua sắm tại shop.	2019-08-01	{"Ưu đãi","Tin tức"}	/images/blog/single_blog_5.png	No Content	5
\.


--
-- TOC entry 2826 (class 0 OID 0)
-- Dependencies: 203
-- Name: Blog_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Blog_ID_seq"', 5, true);


--
-- TOC entry 2690 (class 2606 OID 16410)
-- Name: Blog Blog_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Blog"
    ADD CONSTRAINT "Blog_pkey" PRIMARY KEY ("ID");


-- Completed on 2019-11-12 19:29:45

--
-- PostgreSQL database dump complete
--

