-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2023 at 04:44 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paymentms`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` int(11) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `contributions`
--

CREATE TABLE `contributions` (
  `id` int(11) NOT NULL,
  `column_name` varchar(250) DEFAULT NULL,
  `contribution_name` varchar(250) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `contributions`
--

INSERT INTO `contributions` (`id`, `column_name`, `contribution_name`, `price`) VALUES
(3, 'Penalty', 'Penalty', 500);

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `id` int(11) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `Intrams` varchar(250) DEFAULT NULL,
  `CCS_Day_and_Night` varchar(250) DEFAULT 'NOT PAYED',
  `Penalty` varchar(250) DEFAULT 'NOT PAYED'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`id`, `student_id`, `Intrams`, `CCS_Day_and_Night`, `Penalty`) VALUES
(1, 'C2101173', NULL, 'NOT PAYED', 'PAYED');

-- --------------------------------------------------------

--
-- Table structure for table `sections`
--

CREATE TABLE `sections` (
  `id` int(11) NOT NULL,
  `section` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `sections`
--

INSERT INTO `sections` (`id`, `section`) VALUES
(1, 'BSIT 3A'),
(2, 'BSIT 3B'),
(3, 'BSIT 3C'),
(4, 'BSIT 3D'),
(5, 'BSIT 3E'),
(6, 'BSIT 3F');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `student_id` varchar(20) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `section` varchar(250) DEFAULT NULL,
  `email` varchar(250) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`student_id`, `name`, `section`, `email`, `password`) VALUES
('1100734', 'Olaso, Jayson Alix', 'BSIT 3E', 'jaolaso@my.cspc.edu.ph', 'YKJXUDMV'),
('1400042', 'Cordez, Tradh General', 'BSIT 3E', 'trcordez@my.cspc.edu.ph', 'XLWMYAQW'),
('1500020', 'Bañaria, Dominic Lomeda', 'BSIT 3C', 'dobañaria@my.cspc.edu.ph', 'UCFMUAWR'),
('1801194', 'Ignao, Criselle Bagalacsa', 'BSIT 3C', 'crignao@my.cspc.edu.ph', 'XJFKAMFF'),
('1801519', 'Evallar, John Carlo Climacosa', 'BSIT 3D', 'joevallar@my.cspc.edu.ph', 'PHQRNCUI'),
('1801737', 'Ubante, Harold Jay Bristol', 'BSIT 3E', 'haubante@my.cspc.edu.ph', 'TDMPIJSP'),
('1900745', 'Nacario, Jomarc Ignao', 'BSIT 3F', 'jonacario@my.cspc.edu.ph', 'CTDIELXF'),
('1902999', 'Navelino, John Phillip Flores', 'BSIT 3F', 'jonavelino@my.cspc.edu.ph', 'TEJYJEFX'),
('20111272216', 'Neverio, Jovita Zantua', 'BSIT 3A', 'joneverio@my.cspc.edu.ph', 'BGJIVAAF'),
('20111272383', 'Burgos, Mark Aj NACARIO', 'BSIT 3A', 'maburgos@my.cspc.edu.ph', 'HHVBCPCA'),
('C20100513', 'Valenzuela, Gabriel Aquino', 'BSIT 3F', 'gavalenzuela@my.cspc.edu.ph', 'YCBAIQEB'),
('C20100911', 'Nacario, Andrew Joseph Tumbado', 'BSIT 3A', 'annacario@my.cspc.edu.ph', 'DXRVPGDT'),
('C20100947', 'Agnes, Ma. Andrea BACHO', 'BSIT 3F', 'maagnes@my.cspc.edu.ph', 'PCRTDRVA'),
('C20101381', 'Delamitas, Justine Karl B', 'BSIT 3D', 'judelamitas@my.cspc.edu.ph', 'SXTTAMTL'),
('C20101935', 'Serrano, Charles Christian Obrero', 'BSIT 3D', 'chserrano@my.cspc.edu.ph', 'KXXRVLRB'),
('C20102070', 'Orense, Mantie -', 'BSIT 3D', 'maorense@my.cspc.edu.ph', 'ZKSOEFIB'),
('C20102156', 'Gaite, Joshua Bobis', 'BSIT 3D', 'jogaite@my.cspc.edu.ph', 'XMGZXYDH'),
('C20102198', 'TORALDE, Rayven Fran Morillo', 'BSIT 3F', 'ratoralde@my.cspc.edu.ph', 'TQZQIYBR'),
('C2101173', 'Mark Glen S. Miguel', 'BSIT 3A', 'ddddddddddddd@gmail.com', 'masasas'),
('C21101121', 'Cavite, Lea Jean Saulon', 'BSIT 3C', 'lecavite@my.cspc.edu.ph', 'ACWJGMEY'),
('C21101126', 'Solera, Jane Tataro', 'BSIT 3B', 'jasolera@my.cspc.edu.ph', 'YGSLQBAO'),
('C21101128', 'Badong, Samuel Busadre', 'BSIT 3A', 'sabadong@my.cspc.edu.ph', 'DWXWRHJN'),
('C21101131', 'Fulledo, Mark Angelo Soriano', 'BSIT 3A', 'mafulledo@my.cspc.edu.ph', 'KRGTCNCJ'),
('C21101132', 'Pagador, Judy Lyn Berido', 'BSIT 3A', 'jupagador@my.cspc.edu.ph', 'JNJWJEON'),
('C21101133', 'Sombrero, Anne Nicole Aguado', 'BSIT 3A', 'ansombrero@my.cspc.edu.ph', 'VKEEQCHB'),
('C21101134', 'Arcilla, Kimberly B', 'BSIT 3A', 'kiarcilla@my.cspc.edu.ph', 'YXSUBMLP'),
('C21101144', 'Aguilar, Angeline Dacleson', 'BSIT 3A', 'anaguilar@my.cspc.edu.ph', 'MGKZAPTR'),
('C21101147', 'Pajenago, Keven Jahn Pajenago Castro', 'BSIT 3E', 'kepajenago@my.cspc.edu.ph', 'SKAZEQBE'),
('C21101161', 'Penaflor, Bernadette Stump', 'BSIT 3D', 'bepenaflor@my.cspc.edu.ph', 'PEPMWHTK'),
('C21101162', 'Lavarias, Lyme General', 'BSIT 3C', 'lylavarias@my.cspc.edu.ph', 'ZZMVTZWA'),
('C21101163', 'Baldoza, Eileen Ganalon', 'BSIT 3E', 'eibaldoza@my.cspc.edu.ph', 'MQEASBGI'),
('C21101166', 'Gotoman, Jennelyn Bersabe', 'BSIT 3A', 'jegotoman@my.cspc.edu.ph', 'GTZYWGFJ'),
('C21101167', 'Felices, Florence Kyle Del Rosario', 'BSIT 3E', 'flfelices@my.cspc.edu.ph', 'FPHXORTV'),
('C21101172', 'Cereno, Melannie Lorzano', 'BSIT 3B', 'mecereno@my.cspc.edu.ph', 'DEJEIGQZ'),
('C21101174', 'Perez, Mary cris Ani', 'BSIT 3D', 'maperez@my.cspc.edu.ph', 'IMNCHZOL'),
('C21101177', 'Babilonia, Sean ', 'BSIT 3A', 'sebabilonia@my.cspc.edu.ph', 'FLLQIDDX'),
('C21101180', 'Del Rosario, Kaela Victoria Lumame', 'BSIT 3A', 'rodel rosario@my.cspc.edu.ph', 'VTGWCDQW'),
('C21101183', 'Talamor, Jenny Acabado', 'BSIT 3A', 'jetalamor@my.cspc.edu.ph', 'RIZKIWCN'),
('C21101188', 'Baltazar, Alfred Joseph Tino', 'BSIT 3A', 'albaltazar@my.cspc.edu.ph', 'PDNRKJJR'),
('C21101190', 'Pidoc, Ralph Dexter Rhey Ampongan', 'BSIT 3C', 'rapidoc@my.cspc.edu.ph', 'MTNZDTXP'),
('C21101191', 'Sandrino, Cyrus David Burcer', 'BSIT 3C', 'cysandrino@my.cspc.edu.ph', 'YUJPUOBV'),
('C21101201', 'Villacorta, Jay Mark Delgaco', 'BSIT 3A', 'javillacorta@my.cspc.edu.ph', 'PLWREFDM'),
('C21101205', 'Gamilo, John Martine Lumabad', 'BSIT 3E', 'jogamilo@my.cspc.edu.ph', 'ZYKZCTDG'),
('C21101220', 'Canonce, Reymond Dancalan', 'BSIT 3E', 'recanonce@my.cspc.edu.ph', 'RJNUSYUC'),
('C21101222', 'Divinasflores, Jirah Quijance', 'BSIT 3E', 'jidivinasflores@my.cspc.edu.ph', 'CLTEJRGZ'),
('C21101228', 'Buita, Angel Zurick Fisal Belmonte', 'BSIT 3A', 'anbuita@my.cspc.edu.ph', 'PQZTHICQ'),
('C21101237', 'Unabia, Aljen Siaboc', 'BSIT 3C', 'alunabia@my.cspc.edu.ph', 'WTEIYZAC'),
('C21101238', 'Decierra, Mark Delgaco', 'BSIT 3A', 'madecierra@my.cspc.edu.ph', 'BKQDRRYF'),
('C21101239', 'Alcantara, Angelo James Clores', 'BSIT 3A', 'analcantara@my.cspc.edu.ph', 'LJIYWAAR'),
('C21101245', 'Llorin, Mark Anthony Arellano', 'BSIT 3E', 'mallorin@my.cspc.edu.ph', 'SMOVMYFL'),
('C21101252', 'Grecia, Joal Juster Cuarto', 'BSIT 3A', 'jogrecia@my.cspc.edu.ph', 'NNITYBTA'),
('C21101257', 'Tigue, Nikki Icamin', 'BSIT 3A', 'nitigue@my.cspc.edu.ph', 'JLQJUJEZ'),
('C21101259', 'Fernandez, Jose Enrique Jingco', 'BSIT 3A', 'jofernandez@my.cspc.edu.ph', 'VHVWUYEP'),
('C21101263', 'Inocentes, Clven Jay Lavapie', 'BSIT 3A', 'clinocentes@my.cspc.edu.ph', 'RXBDDHBW'),
('C21101264', 'Lastrollo, MaryGrace Mendoza', 'BSIT 3A', 'malastrollo@my.cspc.edu.ph', 'NUYIYYWI'),
('C21101265', 'Sain, Larry C', 'BSIT 3A', 'lasain@my.cspc.edu.ph', 'UVMFZVCL'),
('C21101266', 'Tuyay, Mario Jr. Ortega', 'BSIT 3C', 'matuyay@my.cspc.edu.ph', 'ZJLEJFPC'),
('C21101269', 'Pacheco, Remnant De leon', 'BSIT 3D', 'repacheco@my.cspc.edu.ph', 'PMJYVSNV'),
('C21101271', 'Cerdon, Joshua Cerilo', 'BSIT 3A', 'jocerdon@my.cspc.edu.ph', 'NSNDWXSE'),
('C21101281', 'Belza, Abegail Sombrero', 'BSIT 3B', 'abbelza@my.cspc.edu.ph', 'YHYFWRWA'),
('C21101285', 'Esquivel, Maria Danica Tucay', 'BSIT 3A', 'maesquivel@my.cspc.edu.ph', 'AUPMKYJP'),
('C21101289', 'Lucañas, Jessica Babelonia', 'BSIT 3A', 'jelucañas@my.cspc.edu.ph', 'DRMUPDQR'),
('C21101290', 'Obias, Mc Angelo Bernaldez', 'BSIT 3E', 'mcobias@my.cspc.edu.ph', 'FSLHQNOH'),
('C21101292', 'Bolival, Gelmark Relos', 'BSIT 3B', 'gebolival@my.cspc.edu.ph', 'MAQIXFZB'),
('C21101297', 'Quitola, Christian Paje', 'BSIT 3A', 'chquitola@my.cspc.edu.ph', 'LEOHVJEJ'),
('C21101299', 'Facistol, Ma. Daniela San Juan', 'BSIT 3A', 'mafacistol@my.cspc.edu.ph', 'WRRSEHVO'),
('C21101303', 'Colarina, Peter Kenjie', 'BSIT 3E', 'pecolarina@my.cspc.edu.ph', 'IZMFFGZR'),
('C21101305', 'Lavilla, Glenn Petalio', 'BSIT 3A', 'gllavilla@my.cspc.edu.ph', 'RDZDRUNJ'),
('C21101457', 'Salcedo, Aaliyah Dana Sabas', 'BSIT 3D', 'aasalcedo@my.cspc.edu.ph', 'ENXNVJFU'),
('C21101917', 'San Miguel, Miko Andre Claro', 'BSIT 3D', 'misan miguel@my.cspc.edu.ph', 'SEDIKNCQ'),
('C21102296', 'Abillonar, Carl Nathaniel Palcon', 'BSIT 3B', 'caabillonar@my.cspc.edu.ph', 'PHRKZDWQ'),
('C21102297', 'Amaro, Maria Rica Bino', 'BSIT 3E', 'maamaro@my.cspc.edu.ph', 'JEFEWRWN'),
('C21102298', 'Aguilar, Louie Podawan', 'BSIT 3B', 'loaguilar@my.cspc.edu.ph', 'UZNFYWAO'),
('C21102299', 'Alvaro, Jonalyn Guevarra', 'BSIT 3E', 'joalvaro@my.cspc.edu.ph', 'IXMSKCEF'),
('C21102300', 'Andrade, Argel Aries Cunanan', 'BSIT 3B', 'arandrade@my.cspc.edu.ph', 'ROBRTCHP'),
('C21102301', 'Aballa, John Loyd DeCastro', 'BSIT 3C', 'joaballa@my.cspc.edu.ph', 'HNSRMGVP'),
('C21102302', 'Aguila, Nikka Mae Tangan', 'BSIT 3D', 'niaguila@my.cspc.edu.ph', 'WACSKMNV'),
('C21102303', 'Abitan, Jomel Luzon', 'BSIT 3E', 'joabitan@my.cspc.edu.ph', 'IEWGDIMO'),
('C21102305', 'Alfonso, John Paul Amoroso', 'BSIT 3B', 'joalfonso@my.cspc.edu.ph', 'APFCHDEE'),
('C21102306', 'Almasco, Abegail Caratero', 'BSIT 3B', 'abalmasco@my.cspc.edu.ph', 'INGWBIJO'),
('C21102307', 'Paje, Jan Fredriz Salud', 'BSIT 3C', 'japaje@my.cspc.edu.ph', 'AWAOSFKP'),
('C21102310', 'Bigata, Ryan Jake Carullo', 'BSIT 3C', 'rybigata@my.cspc.edu.ph', 'UDNCQNQQ'),
('C21102311', 'Baldago, Kyla Mae Osea', 'BSIT 3B', 'kybaldago@my.cspc.edu.ph', 'RYLTKXYR'),
('C21102312', 'Broqueza, Marisol Regoris', 'BSIT 3C', 'mabroqueza@my.cspc.edu.ph', 'BRNZOIVB'),
('C21102313', 'Buquid, Edjim Catapat', 'BSIT 3C', 'edbuquid@my.cspc.edu.ph', 'PSQSGLTY'),
('C21102314', 'Bagalihog, Joy Cabarles', 'BSIT 3C', 'jobagalihog@my.cspc.edu.ph', 'BISODRAI'),
('C21102315', 'Bomalay, Vincent Tomenio', 'BSIT 3B', 'vibomalay@my.cspc.edu.ph', 'SVILAHUT'),
('C21102316', 'Barrio, Veberly Barsanilla', 'BSIT 3C', 'vebarrio@my.cspc.edu.ph', 'IRPGYDSV'),
('C21102318', 'Bondoy, Monica Gamban', 'BSIT 3C', 'mobondoy@my.cspc.edu.ph', 'ZFJDGRMV'),
('C21102323', 'Cortez, Artemio Manuel Degal', 'BSIT 3B', 'arcortez@my.cspc.edu.ph', 'EKULJBVS'),
('C21102324', 'Cleofe, Mark Vincent Mariscotes', 'BSIT 3C', 'macleofe@my.cspc.edu.ph', 'HWRBUELI'),
('C21102325', 'Casia, Christine Joy Sariola', 'BSIT 3C', 'chcasia@my.cspc.edu.ph', 'RUAOFCSN'),
('C21102326', 'Carpo, John Francis Cambiado', 'BSIT 3E', 'jocarpo@my.cspc.edu.ph', 'ACDYFQUP'),
('C21102327', 'Mendoza, Noel Andrew De villa', 'BSIT 3B', 'nomendoza@my.cspc.edu.ph', 'YKFFZYXC'),
('C21102328', 'Dichoso, Christine Joy Labordo', 'BSIT 3E', 'chdichoso@my.cspc.edu.ph', 'JGIWNLSR'),
('C21102330', 'Españo, Kyla Caryl Bisera', 'BSIT 3B', 'kyespaño@my.cspc.edu.ph', 'TCKOTUYF'),
('C21102333', 'Follosco, Blessy Hyacinth Landong', 'BSIT 3E', 'blfollosco@my.cspc.edu.ph', 'ROBLIQQN'),
('C21102334', 'Gastilo, John Rey Tataro', 'BSIT 3E', 'jogastilo@my.cspc.edu.ph', 'PNRJWNWY'),
('C21102338', 'Ilarde, Kyla Marie Pacardo', 'BSIT 3B', 'kyilarde@my.cspc.edu.ph', 'HZNHSUCN'),
('C21102339', 'Isidro, Mary Grace Narra', 'BSIT 3B', 'maisidro@my.cspc.edu.ph', 'AGMRTKIF'),
('C21102341', 'Lim, Sean Howard Naval', 'BSIT 3E', 'selim@my.cspc.edu.ph', 'ZIPXVNYF'),
('C21102342', 'Lomeda, John Francis Buffe', 'BSIT 3C', 'jolomeda@my.cspc.edu.ph', 'QYOWCWDR'),
('C21102343', 'Lumapag, Bergel Rafinian', 'BSIT 3D', 'belumapag@my.cspc.edu.ph', 'GRFNPFBJ'),
('C21102344', 'Manansala, John Paul Sedonio', 'BSIT 3B', 'jomanansala@my.cspc.edu.ph', 'BCAHNHED'),
('C21102345', 'Argarin, John Roger Velasco', 'BSIT 3C', 'joargarin@my.cspc.edu.ph', 'DGGBXEGH'),
('C21102347', 'Maniscan, Lee Andrew Belista', 'BSIT 3B', 'lemaniscan@my.cspc.edu.ph', 'QXHDQCHR'),
('C21102348', 'Margate, Vinz Christian Trajano', 'BSIT 3E', 'vimargate@my.cspc.edu.ph', 'YUDQSBMX'),
('C21102349', 'Martinez, Niño Jofel Arcilla', 'BSIT 3B', 'nimartinez@my.cspc.edu.ph', 'KAERHETC'),
('C21102350', 'Monroy, Marianne Odiver', 'BSIT 3B', 'mamonroy@my.cspc.edu.ph', 'NGGBWWJF'),
('C21102351', 'Nagal, John Llenard Prestado', 'BSIT 3C', 'jonagal@my.cspc.edu.ph', 'ZPWHBVUV'),
('C21102352', 'Navarro, Maria Cleofe Regala', 'BSIT 3B', 'manavarro@my.cspc.edu.ph', 'HSUUYHYT'),
('C21102353', 'Navida, Niño Joshua', 'BSIT 3C', 'ninavida@my.cspc.edu.ph', 'LHIEYCYU'),
('C21102354', 'Neverio, Lerma Vacal', 'BSIT 3B', 'leneverio@my.cspc.edu.ph', 'OASTARMJ'),
('C21102356', 'Olaso, Keith Marianne Landong', 'BSIT 3E', 'keolaso@my.cspc.edu.ph', 'ZMKMSFEX'),
('C21102357', 'Olleres, Adrian Samuel Sta. Cruz', 'BSIT 3B', 'adolleres@my.cspc.edu.ph', 'EEHEZRYW'),
('C21102358', 'Onido, Aira Baluis', 'BSIT 3A', 'aionido@my.cspc.edu.ph', 'BCDERUJK'),
('C21102360', 'Pabon, Sheila Marie Plotado', 'BSIT 3B', 'shpabon@my.cspc.edu.ph', 'XFJOMEZS'),
('C21102361', 'Pastoral, Jesus Cerdon', 'BSIT 3F', 'jepastoral@my.cspc.edu.ph', 'YEMGMNDJ'),
('C21102362', 'Peralta, Romel Hernandez', 'BSIT 3B', 'roperalta@my.cspc.edu.ph', 'SASNMYPA'),
('C21102363', 'Periabras, Christine Vargas', 'BSIT 3B', 'chperiabras@my.cspc.edu.ph', 'WLWMMXZI'),
('C21102364', 'Pili, Deniel genesis Orea', 'BSIT 3D', 'depili@my.cspc.edu.ph', 'KVCLYWYB'),
('C21102365', 'Podawan, Bernardo Bello', 'BSIT 3B', 'bepodawan@my.cspc.edu.ph', 'UDIPKIXI'),
('C21102366', 'Ranido, Marife Ocfemia', 'BSIT 3E', 'maranido@my.cspc.edu.ph', 'BZLXDBOE'),
('C21102367', 'Redondo, Jack arnel Devera', 'BSIT 3B', 'jaredondo@my.cspc.edu.ph', 'HZSFUTDL'),
('C21102368', 'Refereza, Marylie Lorzano', 'BSIT 3E', 'marefereza@my.cspc.edu.ph', 'JCWSZSGJ'),
('C21102370', 'Rempillo, Mike Jr Layderos', 'BSIT 3C', 'mirempillo@my.cspc.edu.ph', 'WPNJTHLS'),
('C21102372', 'Sabido, Crizzalie Melgar', 'BSIT 3C', 'crsabido@my.cspc.edu.ph', 'TDYHGGCS'),
('C21102373', 'Samillano, Niel Marc Monterey', 'BSIT 3E', 'nisamillano@my.cspc.edu.ph', 'WYOXAJOI'),
('C21102374', 'Sandrino, Faye Andrea Camposano', 'BSIT 3C', 'fasandrino@my.cspc.edu.ph', 'NKOHKRAA'),
('C21102375', 'Sangreo, Althea Irish Marcelino', 'BSIT 3C', 'alsangreo@my.cspc.edu.ph', 'UQTFBQWF'),
('C21102376', 'Sanorjo, Hazel Anne Cariño', 'BSIT 3E', 'hasanorjo@my.cspc.edu.ph', 'HZMWEHDO'),
('C21102377', 'Sapalaran, Rodel Jr. Cornelio', 'BSIT 3C', 'rosapalaran@my.cspc.edu.ph', 'WNRPVZBZ'),
('C21102378', 'Sayson, Julius Samaco', 'BSIT 3B', 'jusayson@my.cspc.edu.ph', 'GPTSFEBD'),
('C21102379', 'Secundo, Joshua Morante', 'BSIT 3D', 'josecundo@my.cspc.edu.ph', 'HEAVJVAD'),
('C21102380', 'Sedeño, Jessie James Dichoso', 'BSIT 3B', 'jesedeño@my.cspc.edu.ph', 'ZEUNSBJR'),
('C21102381', 'Sernande, Ma.Henna Fe Baylon', 'BSIT 3E', 'masernande@my.cspc.edu.ph', 'ZAWTBIKD'),
('C21102382', 'Talento, Ma. Lianne Isabel Dela Justa', 'BSIT 3B', 'matalento@my.cspc.edu.ph', 'GSBPJDZO'),
('C21102383', 'Togores, Kenneth Pasa', 'BSIT 3E', 'ketogores@my.cspc.edu.ph', 'ARQFPZDF'),
('C21102384', 'Tomenio, Gemalyn Mortega', 'BSIT 3A', 'getomenio@my.cspc.edu.ph', 'LYOBVLTG'),
('C21102385', 'Tominio, Edison Bicaldo', 'BSIT 3C', 'edtominio@my.cspc.edu.ph', 'HTQVPMAH'),
('C21102388', 'Valenzuela, Diana Joy Cañada', 'BSIT 3C', 'divalenzuela@my.cspc.edu.ph', 'RRCSDATW'),
('C21102389', 'Valenzuela, Marvin Lim', 'BSIT 3E', 'mavalenzuela@my.cspc.edu.ph', 'JZLEGQZN'),
('C21102390', 'Velitario, Missy San Pedro', 'BSIT 3C', 'mivelitario@my.cspc.edu.ph', 'LPAZAMDU'),
('C21102394', 'Volante, John Mark Ramoyan', 'BSIT 3B', 'jovolante@my.cspc.edu.ph', 'TCODLAUS'),
('C21102496', 'Bano, Fharson Brigola', 'BSIT 3C', 'fhbano@my.cspc.edu.ph', 'RTVNNVJP'),
('C21102498', 'Clorado, Shiela Aguilar', 'BSIT 3E', 'shclorado@my.cspc.edu.ph', 'RUEYZVCQ'),
('C21102499', 'Colarina, Niel Jay Ablon', 'BSIT 3C', 'nicolarina@my.cspc.edu.ph', 'IGFHAFYR'),
('C21102500', 'Conde, Carl Edwin Vasquez', 'BSIT 3C', 'caconde@my.cspc.edu.ph', 'RJTLTUCC'),
('C21102501', 'Espedillon, Marealie Coloma', 'BSIT 3E', 'maespedillon@my.cspc.edu.ph', 'YFMOZDDL'),
('C21102502', 'Lachama, John Patrick T', 'BSIT 3B', 'jolachama@my.cspc.edu.ph', 'DTQIPGHW'),
('C21102504', 'Lanzuela, Joseph Era', 'BSIT 3E', 'jolanzuela@my.cspc.edu.ph', 'GRRQMHRX'),
('C21102505', 'Lastrollo, John Dominic Gabarda', 'BSIT 3B', 'jolastrollo@my.cspc.edu.ph', 'EZICKNZX'),
('C21102506', 'Onquit, Gerald Berara', 'BSIT 3B', 'geonquit@my.cspc.edu.ph', 'UNPEXUJA'),
('C21102507', 'Vinas, Lyka Mae Francisquete', 'BSIT 3C', 'lyvinas@my.cspc.edu.ph', 'TNRMORRS'),
('C21102745', 'Gabarda, James Ivan Bongyad', 'BSIT 3D', 'jagabarda@my.cspc.edu.ph', 'OTBLLUHM'),
('C21103064', 'Soreta, April joy Botor', 'BSIT 3E', 'apsoreta@my.cspc.edu.ph', 'ERBUMNIO'),
('C21103236', 'Monte, April Lyn Pallega', 'BSIT 3D', 'apmonte@my.cspc.edu.ph', 'WXUFEOMZ'),
('C21103256', 'Saba, Hexaldin Gervacio', 'BSIT 3D', 'hesaba@my.cspc.edu.ph', 'MDQUDZHE'),
('C21103365', 'Salazar, Frederick Bascon', 'BSIT 3D', 'frsalazar@my.cspc.edu.ph', 'SIHRGYYP'),
('C21103373', 'Maniscan, Mark Glandestine Landagan', 'BSIT 3E', 'mamaniscan@my.cspc.edu.ph', 'QANCGKIY'),
('C21103397', 'Ani, Johndexter Porto', 'BSIT 3D', 'joani@my.cspc.edu.ph', 'PWUKCBLW'),
('C21103674', 'Nacario, Rosalie Sereno', 'BSIT 3D', 'ronacario@my.cspc.edu.ph', 'PRZZQMON'),
('C21103687', 'Manalo, Hannah Mei Barbosa', 'BSIT 3D', 'hamanalo@my.cspc.edu.ph', 'HNWPIDAV'),
('C21103689', 'Sasaluya, Nikki Coleen Batacan', 'BSIT 3D', 'nisasaluya@my.cspc.edu.ph', 'LBREXXRL'),
('C21103690', 'Abonita, Claire Abillonar', 'BSIT 3D', 'clabonita@my.cspc.edu.ph', 'QSONOQJI'),
('C21103694', 'Satuito, Joshua Ampongan', 'BSIT 3D', 'josatuito@my.cspc.edu.ph', 'HKSSHRPT'),
('C21103696', 'Arevalo, Alliah Jane Ranera', 'BSIT 3D', 'alarevalo@my.cspc.edu.ph', 'RFGMELOI'),
('C21103697', 'Verso, Maica Bascon', 'BSIT 3D', 'maverso@my.cspc.edu.ph', 'RRGKZXNV'),
('C21103698', 'Tino, Nathaniel Aurellano', 'BSIT 3D', 'natino@my.cspc.edu.ph', 'MBQMKBAJ'),
('C21103706', 'Esquivel, Allyza Palencia', 'BSIT 3D', 'alesquivel@my.cspc.edu.ph', 'BSZNYUDK'),
('C21103711', 'Romaraog, Markjoseph Nanale', 'BSIT 3D', 'maromaraog@my.cspc.edu.ph', 'FNSSDDWB'),
('C21103712', 'Fabul, Justin Jeffre Lacayanga', 'BSIT 3D', 'jufabul@my.cspc.edu.ph', 'ROPBHCHU'),
('C21103713', 'Rosales, CrisAngelo Landagan', 'BSIT 3A', 'crrosales@my.cspc.edu.ph', 'MJDPDZFG'),
('C21103716', 'Alam, Benedict -', 'BSIT 3D', 'bealam@my.cspc.edu.ph', 'GLJAUPVW'),
('C21104095', 'Samuela, Michelle Machado', 'BSIT 3F', 'misamuela@my.cspc.edu.ph', 'XWCVAJUL'),
('C21104221', 'Imperial, Cyril Christian Bisa', 'BSIT 3D', 'cyimperial@my.cspc.edu.ph', 'VIFKOQRT'),
('C21104273', 'Noble, Chino Lawrence Alina', 'BSIT 3D', 'chnoble@my.cspc.edu.ph', 'XPBIHRQT'),
('C21104312', 'Arroyo, Rodelyn *', 'BSIT 3D', 'roarroyo@my.cspc.edu.ph', 'EIRAJEPW'),
('C21104411', 'Examinada, Edlyn Joan Marie', 'BSIT 3C', 'edexaminada@my.cspc.edu.ph', 'KGAKPDQF'),
('C21104636', 'Bas, Kristian Pontanares', 'BSIT 3E', 'krbas@my.cspc.edu.ph', 'HOXEXSAU'),
('C21104655', 'Bazar, Vince Franc Moraña', 'BSIT 3F', 'vibazar@my.cspc.edu.ph', 'LEJZIDZJ'),
('C21104667', 'Moreno, Jansel noah Magistrado', 'BSIT 3F', 'jamoreno@my.cspc.edu.ph', 'XLYSOPBF'),
('C21104683', 'Turiano, Fermin Jr. III Hugo', 'BSIT 3F', 'feturiano@my.cspc.edu.ph', 'MPZAPBGD'),
('C21104744', 'Lorzano, Ralph Homo', 'BSIT 3F', 'ralorzano@my.cspc.edu.ph', 'YSZWHOVR'),
('C21104745', 'Bardenas, John Paul Oletin', 'BSIT 3F', 'jobardenas@my.cspc.edu.ph', 'TJKUHIYM'),
('C21104797', 'Babol, Andrey Bustarga', 'BSIT 3F', 'anbabol@my.cspc.edu.ph', 'ENUCWPHJ'),
('C21104818', 'Esteban, Ken David Ashley Mercado', 'BSIT 3F', 'keesteban@my.cspc.edu.ph', 'MKTPMVUV'),
('C21104836', 'Braga, Kisha Jamila Periabras', 'BSIT 3F', 'kibraga@my.cspc.edu.ph', 'OLKPAPDF'),
('C21104839', 'Imperial, Arlan Baylon', 'BSIT 3F', 'arimperial@my.cspc.edu.ph', 'DSYXJNEQ'),
('C21104852', 'Biazon, Norry May Reginaldo', 'BSIT 3F', 'nobiazon@my.cspc.edu.ph', 'PDCYARZJ'),
('C21104857', 'Cierva, Daniel Efraim Oliva', 'BSIT 3F', 'dacierva@my.cspc.edu.ph', 'PYCCLPEQ'),
('C21104864', 'Juanillas, Jilyn Rose Salazar', 'BSIT 3F', 'jijuanillas@my.cspc.edu.ph', 'ACKBIVFY'),
('C21104867', 'Delacruz, Rochelle Navarra', 'BSIT 3F', 'rodelacruz@my.cspc.edu.ph', 'FVSQJSDL'),
('C21104964', 'Caceres, Joey Anthony Arcilla', 'BSIT 3F', 'jocaceres@my.cspc.edu.ph', 'QBRIZOXK'),
('C21104974', 'Papa, Ma.Teresa Rivera', 'BSIT 3F', 'mapapa@my.cspc.edu.ph', 'SPQIATAE'),
('C21104977', 'Rada, Jay-Ar Alimoron', 'BSIT 3F', 'jarada@my.cspc.edu.ph', 'GVZXNYNJ'),
('C21104978', 'Raynes, Cristel Salimbacod', 'BSIT 3F', 'crraynes@my.cspc.edu.ph', 'SCFLEOZH'),
('C21105096', 'Rivera, Marimar Herez', 'BSIT 3F', 'marivera@my.cspc.edu.ph', 'DZCICAYC'),
('C21105210', 'Dimaiwat, Justin Larry Ramos', 'BSIT 3A', 'judimaiwat@my.cspc.edu.ph', 'ATEZXBCE');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`,`student_id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `contributions`
--
ALTER TABLE `contributions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`id`,`student_id`),
  ADD UNIQUE KEY `student_id` (`student_id`) USING BTREE;

--
-- Indexes for table `sections`
--
ALTER TABLE `sections`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `section` (`section`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `section` (`section`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `contributions`
--
ALTER TABLE `contributions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sections`
--
ALTER TABLE `sections`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `users` (`student_id`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `users` (`student_id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`section`) REFERENCES `sections` (`section`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
