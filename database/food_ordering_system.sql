-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20220616.7a6bd9eb57
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2022 at 04:49 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `food_ordering_system`
--

--
-- Dumping data for table `cuisine`
--

INSERT INTO `cuisine` (`id`, `cuisine_name`) VALUES
(1, 'Mexican'),
(2, 'Polish'),
(3, 'Italian');

--
-- Dumping data for table `drink`
--

INSERT INTO `drink` (`id`, `drink_name`, `price`) VALUES
(1, 'Cola', 50),
(2, 'Sprite', 30),
(3, 'Juice', 100),
(4, 'Pina Colada', 200),
(5, 'Fanta', 30);

--
-- Dumping data for table `meal`
--

INSERT INTO `meal` (`id`, `meal_name`, `price`) VALUES
(1, 'Rice', 30),
(2, 'Pasta', 50),
(3, 'Curry', 100),
(4, 'Burrito', 200),
(5, 'Pizza', 500),
(6, 'Chicken wing', 400),
(7, 'Molten lava cake', 100),
(8, 'Ice Cream', 150),
(9, 'Custard', 40);

--
-- Dumping data for table `meal_cuisine`
--

INSERT INTO `meal_cuisine` (`meal_id`, `cuisines_id`) VALUES
(1, 1),
(2, 1),
(2, 3),
(2, 2),
(3, 2),
(4, 1),
(4, 3),
(5, 1),
(6, 2),
(6, 3),
(7, 1),
(7, 2),
(8, 2),
(8, 3),
(9, 3),
(9, 2),
(9, 1);

--
-- Dumping data for table `order_transaction`
--

INSERT INTO `order_transaction` (`id`, `isIceCubes`, `isLemon`, `order_date`, `drink_id`, `meal_id`) VALUES
(1, b'0', b'0', '2022-10-02', NULL, 1),
(2, b'0', b'0', '2022-10-02', 2, NULL),
(3, b'0', b'0', '2022-10-02', NULL, 1),
(4, b'0', b'1', '2022-10-02', 3, NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



