-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th5 04, 2022 lúc 01:36 PM
-- Phiên bản máy phục vụ: 5.7.33
-- Phiên bản PHP: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `thietbi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL,
  `tenloaisanpham` varchar(200) NOT NULL,
  `hinhanhloaisanpham` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`id`, `tenloaisanpham`, `hinhanhloaisanpham`) VALUES
(1, 'Trang Chính', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIzKRIktaOYX5Op2oTppGXrBTmMXaliLIPWlIBICdkMbz81TbB6jxIUfmoxQXK5pvQ80A&usqp=CAU'),
(2, 'Điện thoại', 'https://ngochieu.name.vn/img/mobile.png'),
(3, 'Laptop', 'https://ngochieu.name.vn/img/laptop.png'),
(4, 'Liên Hệ', 'https://ngochieu.name.vn/img/contact.png'),
(5, 'Thông Tin', 'https://ngochieu.name.vn/img/info.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(15) NOT NULL,
  `hinhanhsanpham` varchar(200) NOT NULL,
  `motasanpham` varchar(10000) NOT NULL,
  `idsanpham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `motasanpham`, `idsanpham`) VALUES
(1, 'iPhone 13 Pro Max 128GB ', 29800000, 'https://image.cellphones.com.vn/358x/media/catalog/product/i/p/iphone_13-_pro-1_2.jpg', 'Hiệu năng vượt trội - Chip Apple A15 Bionic mạnh mẽ, hỗ trợ mạng 5G tốc độ cao\r\nKhông gian hiển thị sống động - Màn hình 6.7\" Super Retina XDR độ sáng cao, sắc nét\r\nTrải nghiệm điện ảnh đỉnh cao - Cụm 3 camera kép 12MP, hỗ trợ ổn định hình ảnh quang học\r\nTối ưu điện năng - Sạc nhanh 20 W, đầy 50% pin trong khoảng 30 phút', 1),
(2, 'Samsung Galaxy S22 Ultra', 29190000, 'https://image.cellphones.com.vn/358x/media/catalog/product/s/m/sm-s908_galaxys22ultra_front_green_211119.jpg', 'Vi xử lý mạnh mẽ nhất Galaxy - Snapdragon 8 Gen 1 (4 nm)\r\nCamera mắt thần bóng đêm Nightography - Chụp đêm cực đỉnh\r\nS Pen đầu tiên trên Galaxy S - Độ trễ thấp, dễ thao tác\r\nDung lượng pin bất chấp ngày đêm - Viên pin 5000mAh, sạc nhanh 45W', 1),
(3, 'Xiaomi Redmi Note 11 Pro ', 8800000, 'https://image.cellphones.com.vn/358x/media/catalog/product/1/1/11-pro-plus-green-1.jpg', 'Đón đầu thử thách, bứt phá mọi tựa game - Chip MediaTek Dimensity 920 5G 8 nhân siêu mạnh mẽ\r\nKhông gian giải trí đỉnh cao - Màn hình AMOLED 6.67 inch sắc nét, tần số quét 120Hz mượt mà\r\nSạc nhanh thần tốc, tràn đầy năng lượng - Dung lượng pin lớn 4500mAh, sạc nhanh đến 120W\r\nTrải nghiệm nhiếp ảnh cực đỉnh - Camera chính 108MP, hỗ trợ nhiều chế độ chụp linh hoạt', 1),
(4, 'Samsung Galaxy Z Flip3 5G', 18790000, 'https://image.cellphones.com.vn/358x/media/catalog/product/8/0/800x800_flip_3_black.png', 'Thiết kế độc đáo tiện lợi, khẳng định đẳng cấp - Thiết kế gập mở vỏ sò, khung nhôm aluminum chắc chắn\r\nMàn hình kép ấn tượng - Màn hình chính: 6.7\", màn hình phụ: 1.9\" AMOLED\r\nHệ thống camera siêu ấn tượng - Bộ 3 ống kính camera 12MP, camera selfie sắc nét\r\nHiệu năng ấn tượng, làm chủ tốc độ - Snapdragon 888 kết hợp RAM 8GB, hỗ trợ 5G', 1),
(5, 'iPhone SE 2022', 12490000, 'https://image.cellphones.com.vn/358x/media/catalog/product/l/c/lcimg-beede483-355b-48bb-b07a-51285393a1031122.jpg', 'Hiệu năng vượt trội với vi xử lý mới nhất - Chip Apple A15 tiên tiến nhất, cân mọi tác vụ\r\nTận hưởng không gian hiển thị sắc nét - Màn hình Liquid Retina nhỏ gọn 4.7 inch tỷ lệ 16:9\r\nGiải trí trọn vẹn ngày dài - Viên pin có nhiều cải tiến giúp bạn không còn lo lắng khi sử dụng\r\nCamera ghi trọn mọi khoảnh khắc - Camera đơn 12 MP f/1.8 hỗ trợ công nghệ Deep Fusion', 1),
(6, 'OPPO Reno7 Z (5G)', 9190000, 'https://image.cellphones.com.vn/358x/media/catalog/product/c/o/combo_product_-_rainbow_spectrum_-_reno7_z.png', 'Trải nghiệm mượt mà các tác vụ - Bộ xử lý Snapdragon 695 mạnh mẽ RAM 8 GB\r\nNăng lượng bất tận cả ngày - Dung lượng pin lớn 4500 mAh và sạc nhanh 60W\r\nTrọn vẹn từng khoảnh khắc - Cụm 3 camera sau cảm biến lên đến 64MP, chụp chân dung chuyên nghiệp\r\nMàn hình hiển thị sắc nét, màu sắc sống động - Màn hình AMOLED 6.43\"\", tần số quét 60 Hz', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
