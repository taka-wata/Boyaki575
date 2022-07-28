-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: boyaki_db
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `boyaki`
--

DROP TABLE IF EXISTS `boyaki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boyaki` (
  `id` int NOT NULL AUTO_INCREMENT,
  `upper` varchar(6) NOT NULL,
  `middle` varchar(8) NOT NULL,
  `lower` varchar(6) NOT NULL,
  `user_id` int NOT NULL,
  `is_secret` tinyint(1) NOT NULL DEFAULT '0',
  `date` datetime DEFAULT NULL,
  `goods_count` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boyaki`
--

LOCK TABLES `boyaki` WRITE;
/*!40000 ALTER TABLE `boyaki` DISABLE KEYS */;
INSERT INTO `boyaki` VALUES (1,'あさがきた','あああさがきた','あさがきた',1,1,'2022-07-22 10:26:30',0),(2,'ひるがくる','ああひるがくる','ひるがくる',2,0,'2022-07-22 10:40:10',0),(3,'よるになれ','さっさとよるに','なってくれ',1,0,'2022-07-22 11:22:20',0),(4,'バス来ない','寝ても覚めても','バス来ない',1,0,'2022-07-22 11:46:40',2),(5,'飯を食う','朝昼晩と','三食を',2,0,'2022-07-22 12:20:10',1),(6,'今日は寝る','明日はきっと','本気だす',1,0,'2022-07-22 12:26:30',0),(7,'テストです','ああテストです','テストです',1,0,'2022-07-22 14:13:31',2),(8,'三郎が','よしなしごとを','ぼやきます',4,0,'2022-07-22 15:23:43',20),(9,'テストです','匿名希望の','テストです',1,0,'2022-07-26 13:47:54',0),(10,'テストです','匿名希望の','テストです',1,0,'2022-07-26 13:50:42',0),(11,'テストです','匿名希望の','テストです',1,0,'2022-07-26 13:51:54',0),(12,'テストです','匿名希望の','テストです',1,0,'2022-07-26 13:52:40',0),(13,'テストです','匿名希望の','テストです',1,0,'2022-07-26 13:57:06',1),(14,'テストです','匿名希望の','テストです',1,1,'2022-07-26 13:58:52',1),(15,'ようやっと','完成しました','ぼやきBBS',4,1,'2022-07-26 14:16:13',0),(16,'ようやっと','匿名希望の','テストです',1,1,'2022-07-27 10:13:40',0),(17,'ひるがくる','朝昼晩と！','ぼやきBB',1,0,'2022-07-27 11:32:22',0),(18,'よるになれ','よしなしごとを','ぼやきBB',1,0,'2022-07-27 11:32:35',0),(19,'テストです','朝昼晩とで','ぼやきBB',1,0,'2022-07-27 11:32:57',0),(20,'ひるがくる','匿名希望の','ぼやきます',1,0,'2022-07-27 11:34:02',1),(21,'ひるがくる','匿名希望の','なってくれ',4,0,'2022-07-27 12:30:51',0),(22,'今日は寝る','明日はきっと','バス来ない',4,0,'2022-07-27 12:30:59',0),(23,'あさがきた','匿名希望の','ぼやきBB',4,1,'2022-07-27 12:32:08',1),(24,'三郎が!','よしなしごとを','ぼやきBB',1,0,'2022-07-28 10:10:26',0),(25,'よるになれ','あああさがきた','なってくれ',1,0,'2022-07-28 10:15:56',0),(26,'ひるがくる','よしなしごとを','なってくれ',1,0,'2022-07-28 10:16:06',0),(27,'今日は寝る','完成しました','本気だす',1,1,'2022-07-28 10:17:10',0),(28,'ひるがくる','よしなしごとを','本気だす',1,1,'2022-07-28 10:19:10',1),(29,'テストです','よしなしごとを','テストです',1,0,'2022-07-28 10:19:18',0),(30,'ぼやきます','ああぼやきます','ぼやきます',9,0,'2022-07-28 10:27:27',0),(31,'テストです','ああぼやきます','バス来ない',9,1,'2022-07-28 10:28:16',0),(32,'テストです','テスト書き込み','テストです',4,0,'2022-07-28 12:40:00',0),(33,'三郎が!','匿名希望の','テストです',5,1,'2022-07-28 12:41:10',0);
/*!40000 ALTER TABLE `boyaki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `login_id` varchar(20) NOT NULL,
  `login_pass` char(60) NOT NULL,
  `name` varchar(20) NOT NULL,
  `good_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_id` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'taro@example.com','$2a$08$K14JmjmnOKtadhwoT3wc2eIfDv0BcmAXccjssluSjQUC.kOaZxU8a','山田太郎','2022-07-28 10:10:59'),(2,'jiro@example.com','$2a$08$ps.f7/3isuSaYKca5Wx0PewuR4tnwsjX6aYHskbwmF1zvaUG48C1q','佐藤次郎',NULL),(4,'saburo@example.com','$2a$10$cTYPH.AhyiZlVBgzBbhZC.xbW0rVGaj5bz5bG5fwlflQ53Ql2abAi','藤原三郎','2022-07-26 14:29:16'),(5,'kano@example.com','$2a$10$t4rKici6I0UxWPfqfT/bh.4Gay4TEKqvdo50SUgCTMdURefyfVz.6','嘉納治五郎',NULL),(9,'haitani@example.com','$2a$10$bbOXVrOIrTh9dNnB2XXxNOxP41hqQUoveUiH/hHlt.a/ftlRUpeCS','灰谷健次郎',NULL),(10,'yamada@example.com','$2a$10$bz0XlpEbrZoKfMORf0yM6OweENg5LhMPrq2SyHefCrZnvZT6kE3Y.','山田太郎',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-28 14:42:10
