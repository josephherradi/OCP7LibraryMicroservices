CREATE DATABASE  IF NOT EXISTS `ocp7db2` ;
USE `ocp7db2`;

 SET NAMES utf8 ;

--
-- Table structure for table `livre`
--

DROP TABLE IF EXISTS `livre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `livre` (
  `livre_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `disponibilite` int(11) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`livre_id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livre`
--

LOCK TABLES `livre` WRITE;
/*!40000 ALTER TABLE `livre` DISABLE KEYS */;
INSERT INTO `livre` VALUES (1,'programme TS 2019',3,'physique chimie terminale 2019','Sciences'),(2,'programme ES 2019',4,'ECO GESTION 2019','Gestion'),(3,'test description',2,'livre de philo','Litterature');
/*!40000 ALTER TABLE `livre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pret`
--

DROP TABLE IF EXISTS `pret`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pret` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_pret` datetime DEFAULT NULL,
  `id_livre` int(11) DEFAULT NULL,
  `pret_prolonge` bit(1) DEFAULT NULL,
  `utilisateur` varchar(255) DEFAULT NULL,
  `nom_livre` varchar(255) DEFAULT NULL,
  `tag_for_update` bit(1) DEFAULT NULL,
  `date_retour` datetime DEFAULT NULL,
  `rendu` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pret`
--

LOCK TABLES `pret` WRITE;
/*!40000 ALTER TABLE `pret` DISABLE KEYS */;
INSERT INTO `pret` VALUES (96,'2019-09-07 09:20:04',3,_binary '','userTest','livre de philo',_binary '\0','2019-11-02 09:20:04',_binary '\0'),(95,'2019-07-07 09:19:53',2,_binary '','userTest','ECO GESTION 2019',_binary '\0','2019-08-02 09:19:53',_binary '\0'),(94,'2019-09-07 09:19:40',1,_binary '\0','userTest','physique chimie terminale 2019',_binary '\0','2019-10-05 09:19:40',_binary '\0'),(98,'2019-09-07 09:20:32',2,_binary '\0','lecteurTest','ECO GESTION 2019',_binary '\0','2019-10-05 09:20:32',_binary '\0');
/*!40000 ALTER TABLE `pret` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prolongation`
--

DROP TABLE IF EXISTS `prolongation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `prolongation` (
  `prolongation_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_demande` datetime DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `utilisateur` varchar(255) DEFAULT NULL,
  `pret_id` int(11) DEFAULT NULL,
  `nom_livre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`prolongation_id`),
  KEY `FKqrri65iha8sp5t8aslywwy0xs` (`pret_id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prolongation`
--

LOCK TABLES `prolongation` WRITE;
/*!40000 ALTER TABLE `prolongation` DISABLE KEYS */;
INSERT INTO `prolongation` VALUES (31,'2019-09-07 14:12:15','en attente','userTest',94,'physique chimie terminale 2019'),(30,'2019-09-07 09:21:42','Validee','userTest',95,'ECO GESTION 2019'),(29,'2019-09-07 09:21:37','Validee','userTest',96,'livre de philo');
/*!40000 ALTER TABLE `prolongation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identifiant` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (1,'userTest','joseph.herradi@gmail.com','827ccb0eea8a706c4c34a16891f84e7b'),(2,'lecteurTest','joseph.herradi@gmail.com','827ccb0eea8a706c4c34a16891f84e7b');
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;
