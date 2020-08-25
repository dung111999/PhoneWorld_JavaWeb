-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 25, 2020 at 06:23 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phoneworld`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'dung1999', '1999'),
(2, 'amazon', 'forest99');

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `id` int(11) NOT NULL,
  `brand` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`id`, `brand`) VALUES
(1, 'Iphone'),
(2, 'Samsung'),
(3, 'Vsmart');

-- --------------------------------------------------------

--
-- Table structure for table `cartitem`
--

CREATE TABLE `cartitem` (
  `id` int(11) NOT NULL,
  `buyer_name` varchar(50) NOT NULL,
  `buyer_address` varchar(100) NOT NULL,
  `buyer_phone` varchar(50) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `buy_date` date NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cartitem`
--

INSERT INTO `cartitem` (`id`, `buyer_name`, `buyer_address`, `buyer_phone`, `product_id`, `quantity`, `buy_date`, `status`) VALUES
(24, 'Pham Tan Dung', 'Thanh Xuan Ha Noi', '0123456789', 2, 1, '2020-08-24', 2),
(25, 'Pham Tan Dung', 'Thanh Xuan Ha Noi', '0123456789', 1, 2, '2020-08-24', 1),
(26, 'Pham Tan Dung', 'Thanh Xuan Ha Noi', '0123456789', 2, 1, '2020-08-24', 1),
(27, 'a', 'a', 'a', 1, 1, '2020-08-25', 1),
(28, 'Pham Tan Dung', 'a', 'a', 1, 1, '2020-08-25', 1),
(29, 'Pham Tan Dung', 'a', 'a', 2, 1, '2020-08-25', 1),
(30, 'a', 'a', 'a', 1, 1, '2020-08-25', 1),
(31, 'a', 'a', 'a', 1, 1, '2020-08-25', 1);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `brand_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `Ram` int(11) NOT NULL,
  `Rom` int(11) NOT NULL,
  `CPU` varchar(50) NOT NULL,
  `Pin` int(11) NOT NULL,
  `image` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `brand_id`, `name`, `price`, `Ram`, `Rom`, `CPU`, `Pin`, `image`) VALUES
(1, 1, 'Iphone 11 128GB', 21990000, 4, 64, 'Apple A13 Bionic 6 nhan', 3110, '1596966866858.png'),
(2, 1, 'Iphone Xs Max 256GB', 30990000, 4, 256, 'Apple A12 Bionic 6 nhan', 3174, '1596966920503.png'),
(3, 1, 'Iphone SE 256GB', 17990000, 3, 256, 'Apple A13 Bionic 6 nhan', 1821, '1596966961737.png'),
(4, 2, 'Samsung Galaxy A21s 3GB/32GB', 4390000, 3, 32, 'Exynos 850 8 nhan', 5000, '1596967005848.png'),
(5, 2, 'Samsung Galaxy S10 Lite 8GB/128GB', 11990000, 8, 128, 'Snapdragon 855 8 nhan', 4500, '1596967063184.png'),
(6, 2, 'Samsung Galaxy Z Flip', 36000000, 8, 256, 'Snapdragon 855+ 8 nhan', 3300, '1596967106730.png'),
(7, 3, 'Vsmart Active 3 6GB/64GB', 3490000, 6, 64, 'MediaTek Helio P60 8 nhan', 4020, '1596967163525.png'),
(8, 3, 'Vsmart Joy 3 4GB/64GB', 2990000, 4, 64, 'Snapdragon 632 8 nhan', 5000, '1596967200472.png'),
(9, 3, 'Vsmart Live 4GB/64GB', 3490000, 4, 64, 'Snapdragon 675 8 nhan', 4000, '1596967283512.png'),
(14, 1, 'Iphone 8 Plus 128GB', 16990000, 3, 128, 'Apple A11 Bionic 6 nhan', 2691, '1596967375661.png'),
(15, 2, 'Samsung Galaxy S20 Ultra', 19990000, 12, 128, 'Exynos 990 8 nhan', 5000, '1596967490841.png'),
(16, 3, 'Vsmart Star 4 3GB/32GB', 2090000, 2, 32, 'MediaTek Helio P35 8 nhan', 3500, '1597224059486.png');

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id`, `status`) VALUES
(1, 'Wait'),
(2, 'Ordered');

-- --------------------------------------------------------

--
-- Table structure for table `tableorders`
--

CREATE TABLE `tableorders` (
  `id` int(11) NOT NULL,
  `cartitem_id` int(11) NOT NULL,
  `order_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tableorders`
--

INSERT INTO `tableorders` (`id`, `cartitem_id`, `order_date`) VALUES
(25, 24, '2020-08-25');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartitem`
--
ALTER TABLE `cartitem`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `status` (`status`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `brand_id` (`brand_id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tableorders`
--
ALTER TABLE `tableorders`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cartitem_id` (`cartitem_id`),
  ADD UNIQUE KEY `cartitem_id_2` (`cartitem_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `cartitem`
--
ALTER TABLE `cartitem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tableorders`
--
ALTER TABLE `tableorders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cartitem`
--
ALTER TABLE `cartitem`
  ADD CONSTRAINT `cartitem_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `cartitem_ibfk_2` FOREIGN KEY (`status`) REFERENCES `status` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);

--
-- Constraints for table `tableorders`
--
ALTER TABLE `tableorders`
  ADD CONSTRAINT `tableorders_ibfk_1` FOREIGN KEY (`cartitem_id`) REFERENCES `cartitem` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
