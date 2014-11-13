DROP DATABASE IF EXISTS GsbCRSlam;

CREATE DATABASE IF NOT EXISTS GsbCRSlam;
USE GsbCRSlam;


-
-- Table structure for table `ACTIVITE_COMPL`
--

DROP TABLE IF EXISTS `ACTIVITE_COMPL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACTIVITE_COMPL` (
  `AC_NUM` int(11) NOT NULL DEFAULT '0',
  `AC_DATE` date DEFAULT NULL,
  `AC_LIEU` varchar(50) DEFAULT NULL,
  `AC_THEME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`AC_NUM`)
) ENGINE=InnoDB CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACTIVITE_COMPL`
--

LOCK TABLES `ACTIVITE_COMPL` WRITE;
/*!40000 ALTER TABLE `ACTIVITE_COMPL` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACTIVITE_COMPL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COMPOSANT`
--

DROP TABLE IF EXISTS `COMPOSANT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COMPOSANT` (
  `CMP_CODE` varchar(8) NOT NULL DEFAULT '',
  `CMP_LIBELLE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CMP_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COMPOSANT`
--

LOCK TABLES `COMPOSANT` WRITE;
/*!40000 ALTER TABLE `COMPOSANT` DISABLE KEYS */;
/*!40000 ALTER TABLE `COMPOSANT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CONSTITUER`
--

DROP TABLE IF EXISTS `CONSTITUER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CONSTITUER` (
  `MED_DEPOTLEGAL` varchar(20) NOT NULL DEFAULT '',
  `CMP_CODE` varchar(8) NOT NULL DEFAULT '',
  `CST_QTE` float DEFAULT NULL,
  PRIMARY KEY (`MED_DEPOTLEGAL`,`CMP_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Dumping data for table `CONSTITUER`
--

LOCK TABLES `CONSTITUER` WRITE;
/*!40000 ALTER TABLE `CONSTITUER` DISABLE KEYS */;
/*!40000 ALTER TABLE `CONSTITUER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DOSAGE`
--

DROP TABLE IF EXISTS `DOSAGE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DOSAGE` (
  `DOS_CODE` varchar(20) NOT NULL DEFAULT '',
  `DOS_QUANTITE` varchar(20) DEFAULT NULL,
  `DOS_UNITE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`DOS_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DOSAGE`
--

LOCK TABLES `DOSAGE` WRITE;
/*!40000 ALTER TABLE `DOSAGE` DISABLE KEYS */;
/*!40000 ALTER TABLE `DOSAGE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FAMILLE`
--

DROP TABLE IF EXISTS `FAMILLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FAMILLE` (
  `FAM_CODE` varchar(6) NOT NULL DEFAULT '',
  `FAM_LIBELLE` varchar(160) DEFAULT NULL,
  PRIMARY KEY (`FAM_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FAMILLE`
--

LOCK TABLES `FAMILLE` WRITE;
/*!40000 ALTER TABLE `FAMILLE` DISABLE KEYS */;
INSERT INTO `FAMILLE` VALUES 
	('AA','Antalgiques en association'),
	('AAA','Antalgiques antipyrétiques en association'),
	('AAC','Antidépresseur d\'\'action centrale'),
	('AAH','Antivertigineux antihistaminique H1'),
	('ABA','Antibiotique antituberculeux'),
	('ABC','Antibiotique antiacnéique local'),
	('ABP','Antibiotique de la famille des béta-lactamines (pénicilline A)'),
	('AFC','Antibiotique de la famille des cyclines'),
	('AFM','Antibiotique de la famille des macrolides'),
	('AH','Antihistaminique H1 local'),
	('AIM','Antidépresseur imipraminique (tricyclique)'),
	('AIN','Antidépresseur inhibiteur sélectif de la recapture de la sérotonine'),
	('ALO','Antibiotique local (ORL)'),
	('ANS','Antidépresseur IMAO non sélectif'),
	('AO','Antibiotique ophtalmique'),
	('AP','Antipsychotique normothymique'),
	('AUM','Antibiotique urinaire minute'),
	('CRT','Corticoïde, antibiotique et antifongique à usage local'),
	('HYP','Hypnotique antihistaminique'),
	('PSA','Psychostimulant, antiasthénique');
/*!40000 ALTER TABLE `FAMILLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FORMULER`
--

DROP TABLE IF EXISTS `FORMULER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FORMULER` (
  `MED_DEPOTLEGAL` varchar(20) NOT NULL DEFAULT '',
  `PRE_CODE` varchar(4) NOT NULL DEFAULT '',
  PRIMARY KEY (`MED_DEPOTLEGAL`,`PRE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FORMULER`
--

LOCK TABLES `FORMULER` WRITE;
/*!40000 ALTER TABLE `FORMULER` DISABLE KEYS */;
/*!40000 ALTER TABLE `FORMULER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INTERAGIR`
--

DROP TABLE IF EXISTS `INTERAGIR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `INTERAGIR` (
  `MED_PERTURBATEUR` varchar(20) NOT NULL DEFAULT '',
  `MED_PERTURBE` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`MED_PERTURBATEUR`,`MED_PERTURBE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INTERAGIR`
--

LOCK TABLES `INTERAGIR` WRITE;
/*!40000 ALTER TABLE `INTERAGIR` DISABLE KEYS */;
/*!40000 ALTER TABLE `INTERAGIR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `INVITER`
--

DROP TABLE IF EXISTS `INVITER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `INVITER` (
  `AC_NUM` int(11) NOT NULL DEFAULT '0',
  `PRA_NUM` int(11) NOT NULL DEFAULT '0',
  `SPECIALISATION` char(1) DEFAULT NULL,
  PRIMARY KEY (`AC_NUM`,`PRA_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `INVITER`
--

LOCK TABLES `INVITER` WRITE;
/*!40000 ALTER TABLE `INVITER` DISABLE KEYS */;
/*!40000 ALTER TABLE `INVITER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LABORATOIRE`
--

DROP TABLE IF EXISTS `LABORATOIRE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LABORATOIRE` (
  `LAB_CODE` varchar(4) NOT NULL DEFAULT '',
  `LAB_NOM` varchar(20) DEFAULT NULL,
  `LAB_CHEFVENTE` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`LAB_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LABORATOIRE`
--

LOCK TABLES `LABORATOIRE` WRITE;
/*!40000 ALTER TABLE `LABORATOIRE` DISABLE KEYS */;
INSERT INTO `LABORATOIRE` VALUES 
	('BC','Bichat','Suzanne Terminus'),
	('GY','Gyverny','Marcel MacDouglas'),
	('SW','Swiss Kane','Alain Poutre');
/*!40000 ALTER TABLE `LABORATOIRE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MEDICAMENT`
--

DROP TABLE IF EXISTS `MEDICAMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MEDICAMENT` (
  `MED_DEPOTLEGAL` varchar(20) NOT NULL DEFAULT '',
  `MED_NOMCOMMERCIAL` varchar(50) DEFAULT NULL,
  `FAM_CODE` varchar(6) DEFAULT NULL,
  `MED_COMPOSITION` varchar(510) DEFAULT NULL,
  `MED_EFFETS` varchar(510) DEFAULT NULL,
  `MED_CONTREINDIC` varchar(510) DEFAULT NULL,
  `MED_PRIXECHANTILLON` float DEFAULT NULL,
  PRIMARY KEY (`MED_DEPOTLEGAL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MEDICAMENT`
--

LOCK TABLES `MEDICAMENT` WRITE;
/*!40000 ALTER TABLE `MEDICAMENT` DISABLE KEYS */;
INSERT INTO `MEDICAMENT` VALUES 
	('3MYC7','TRIMYCINE','CRT','Triamcinolone (acétonide) + Néomycine + Nystatine','Ce médicament est un corticoïde à activité forte ou très forte associé à un antibiotique et un antifongique, utilisé en application locale dans certaines atteintes cutanées surinfectées.','Ce médicament est contre-indiqué en cas d\'\'allergie à l\'\'un des constituants, d\'\'infections de la peau ou de parasitisme non traités, d\'\'acné. Ne pas appliquer sur une plaie, ni sous un pansement occlusif.',NULL),
	('ADIMOL9','ADIMOL','ABP','Amoxicilline + Acide clavulanique','Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.','Ce médicament est contre-indiqué en cas d\'\'allergie aux pénicillines ou aux céphalosporines.',NULL),
	('AMOPIL7','AMOPIL','ABP','Amoxicilline','Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.','Ce médicament est contre-indiqué en cas d\'\'allergie aux pénicillines. Il doit être administré avec prudence en cas d\'\'allergie aux céphalosporines.',NULL),
	('AMOX45','AMOXAR','ABP','Amoxicilline','Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.','La prise de ce médicament peut rendre positifs les tests de dépistage du dopage.',NULL),
	('AMOXIG12','AMOXI Gé','ABP','Amoxicilline','Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.','Ce médicament est contre-indiqué en cas d\'\'allergie aux pénicillines. Il doit être administré avec prudence en cas d\'\'allergie aux céphalosporines.',NULL),
	('APATOUX22','APATOUX Vitamine C','ALO','Tyrothricine + Tétracène + Acide ascorbique (Vitamine C)','Ce médicament est utilisé pour traiter les affections de la bouche et de la gorge.','Ce médicament est contre-indiqué en cas d\'\'allergie à l\'\'un des constituants, en cas de phénylcétonurie et chez l\'\'enfant de moins de 6 ans.',NULL),
	('BACTIG10','BACTIGEL','ABC','Erythromycine','Ce médicament est utilisé en application locale pour traiter l\'\'acné et les infections cutanées bactériennes associées.','Ce médicament est contre-indiqué en cas d\'\'allergie aux antibiotiques de la famille des macrolides ou des lincosanides.',NULL),
	('BACTIV13','BACTIVIL','AFM','Erythromycine','Ce médicament est utilisé pour traiter des infections bactériennes spécifiques.','Ce médicament est contre-indiqué en cas d\'\'allergie aux macrolides (dont le chef de file est l\'\'érythromycine).',NULL),
	('BITALV','BIVALIC','AAA','Dextropropoxyphène + Paracétamol','Ce médicament est utilisé pour traiter les douleurs d\'\'intensité modérée ou intense.','Ce médicament est contre-indiqué en cas d\'\'allergie aux médicaments de cette famille, d\'\'insuffisance hépatique ou d\'\'insuffisance rénale.',NULL),
	('CARTION6','CARTION','AAA','Acide acétylsalicylique (aspirine) + Acide ascorbique (Vitamine C) + Paracétamol','Ce médicament est utilisé dans le traitement symptomatique de la douleur ou de la fièvre.','Ce médicament est contre-indiqué en cas de troubles de la coagulation (tendances aux hémorragies), d\'\'ulcère gastroduodénal, maladies graves du foie.',NULL),
	('CLAZER6','CLAZER','AFM','Clarithromycine','Ce médicament est utilisé pour traiter des infections bactériennes spécifiques. Il est également utilisé dans le traitement de l\'\'ulcère gastro-duodénal, en association avec d\'\'autres médicaments.','Ce médicament est contre-indiqué en cas d\'\'allergie aux macrolides (dont le chef de file est l\'\'érythromycine).',NULL),
	('DEPRIL9','DEPRAMIL','AIM','Clomipramine','Ce médicament est utilisé pour traiter les épisodes dépressifs sévères, certaines douleurs rebelles, les troubles obsessionnels compulsifs et certaines énurésies chez l\'\'enfant.','Ce médicament est contre-indiqué en cas de glaucome ou d\'\'adénome de la prostate, d\'\'infarctus récent, ou si vous avez reçu un traitement par IMAO durant les 2 semaines précédentes ou en cas d\'\'allergie aux atidépresseurs imipraminiques.',NULL),
	('DIMIRTAM6','DIMIRTAM','AAC','Mirtazapine','Ce médicament est utilisé pour traiter les épisodes dépressifs sévères.','La prise de ce produit est contre-indiquée en cas de d\'\'allergie à l\'\'un des constituants.',NULL),
	('DOLRIL7','DOLORIL','AAA','Acide acétylsalicylique (aspirine) + Acide ascorbique (Vitamine C) + Paracétamol','Ce médicament est utilisé dans le traitement symptomatique de la douleur ou de la fièvre.','Ce médicament est contre-indiqué en cas d\'\'allergie au Paracétamol ou aux salicylates.',NULL),
	('DORNOM8','NORMADOR','HYP','Doxylamine','Ce médicament est utilisé pour traiter l\'\'insomnie chez l\'\'adulte.','Ce médicament est contre-indiqué en cas de glaucome, de certains troubles urinaires (rétention urinaire) et chez l\'\'enfant de moins de 15 ans.',NULL),
	('EQUILARX6','EQUILAR','AAH','Méclozine','Ce médicament est utilisé pour traiter les vertiges et pour prévenir le mal des transports.','Ce médicament ne doit pas être utilisé en cas d\'\'allergie au produit, en cas de glaucome ou de rétention urinaire.',NULL),
	('EVILR7','EVEILLOR','PSA','Adrafinil','Ce médicament est utilisé pour traiter les troubles de la vigilance et certains symptomes neurologiques chez le sujet agé.','Ce médicament est contre-indiqué en cas d\'\'allergie à  l\'\'un des constituants.',NULL),
	('INSXT5','INSECTIL','AH','Diphénydramine','Ce médicament est utilisé en application locale sur les piqûres d\'\'insecte et l\'\'urticaire.','Ce médicament est contre-indiqué en cas d\'\'allergie aux antihistaminiques.',NULL),
	('JOVAI8','JOVENIL','AFM','Josamycine','Ce médicament est utilisé pour traiter des infections bactériennes spécifiques.','Ce médicament est contre-indiqué en cas d\'\'allergie aux macrolides (dont le chef de file est l\'\'érythromycine).',NULL),
	('LIDOXY23','LIDOXYTRACINE','AFC','Oxytétracycline +Lidocaïne','Ce médicament est utilisé en injection intramusculaire pour traiter certaines infections spécifiques.','Ce médicament est contre-indiqué en cas d\'\'allergie à  l\'\'un des constituants. Il ne doit pas être associé aux rétinoïdes.',NULL),
	('LITHOR12','LITHORINE','AP','Lithium','Ce médicament est indiqué dans la prévention des psychoses maniaco-dépressives ou pour traiter les états maniaques.','Ce médicament ne doit pas être utilisé si vous êtes allergique au lithium. Avant de prendre ce traitement, signalez à  votre Médecin traitant si vous souffrez d\'\'insuffisance rénale, ou si vous avez un régime sans sel.',NULL),
	('PARMOL16','PARMOCODEINE','AA','Codéine + Paracétamol','Ce médicament est utilisé pour le traitement des douleurs lorsque des antalgiques simples ne sont pas assez efficaces.','Ce médicament est contre-indiqué en cas d\'\'allergie à  l\'\'un des constituants, chez l\'\'enfant de moins de 15 Kg, en cas d\'\'insuffisance hépatique ou respiratoire, d\'\'asthme, de phénylcétonurie et chez la femme qui allaite.',NULL),
	('PHYSOI8','PHYSICOR','PSA','Sulbutiamine','Ce médicament est utilisé pour traiter les baisses d\'\'activité physique ou psychique, souvent dans un contexte de dépression.','Ce médicament est contre-indiqué en cas d\'\'allergie à l\'\'un des constituants.',NULL),
	('PIRIZ8','PIRIZAN','ABA','Pyrazinamide','Ce médicament est utilisé, en association à d\'\'autres antibiotiques, pour traiter la tuberculose.','Ce médicament est contre-indiqué en cas d\'\'allergie à  l\'\'un des constituants, d\'\'insuffisance rénale ou hépatique, d\'\'hyperuricémie ou de porphyrie.',NULL),
	('POMDI20','POMADINE','AO','Bacitracine','Ce médicament est utilisé pour traiter les infections oculaires de la surface de l\'\'oeil.','Ce médicament est contre-indiqué en cas d\'\'allergie aux antibiotiques appliqués localement.',NULL),
	('TROXT21','TROXADET','AIN','Paroxétine','Ce médicament est utilisé pour traiter la dépression et les troubles obsessionnels compulsifs. Il peut également être utilisé en prévention des crises de panique avec ou sans agoraphobie.','Ce médicament est contre-indiqué en cas d\'\'allergie au produit.',NULL),
	('TXISOL22','TOUXISOL Vitamine C','ALO','Tyrothricine + Acide ascorbique (Vitamine C)','Ce médicament est utilisé pour traiter les affections de la bouche et de la gorge.','Ce médicament est contre-indiqué en cas d\'\'allergie à l\'\'un des constituants et chez l\'\'enfant de moins de 6 ans.',NULL),
	('URIEG6','URIREGUL','AUM','Fosfomycine trométamol','Ce médicament est utilisé pour traiter les infections urinaires simples chez la femme de moins de 65 ans.','La prise de ce médicament est contre-indiquée en cas d\'\'allergie à l\'\'un des constituants et d\'\'insuffisance rénale.',NULL);
/*!40000 ALTER TABLE `MEDICAMENT` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `MOTIF`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MOTIF` (
  `MOT_NUM` int(8) NOT NULL ,
  `MOT_LABEL` varchar(510) NOT NULL,
  PRIMARY KEY (`MOT_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MOTIF`
--

LOCK TABLES `MOTIF` WRITE;
/*!40000 ALTER TABLE `MOTIF` DISABLE KEYS */;

INSERT INTO `MOTIF` VALUES 
	(1,'Actualisation annuelle'),
	(2,'Rapport Annuel'),
	(3,'Baisse activité');

/*!40000 ALTER TABLE `MOTIF` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COLLABORATEUR`
--

DROP TABLE IF EXISTS `COLLABORATEUR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COLLABORATEUR` (
  `COL_MATRICULE` varchar(20) NOT NULL DEFAULT '',
  `COL_NOM` varchar(50) DEFAULT NULL,
  `COL_MDP` varchar(20) NOT NULL ,
  `COL_PRENOM` varchar(100) DEFAULT NULL,
  `COL_ADRESSE` varchar(100) DEFAULT NULL,
  `COL_CP` varchar(10) DEFAULT NULL,
  `COL_VILLE` varchar(60) DEFAULT NULL,
  `COL_DATEEMBAUCHE` date DEFAULT NULL,
  `SEC_CODE` varchar(2) DEFAULT NULL,
  `LAB_CODE` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`COL_MATRICULE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COLLABORATEUR`
--

LOCK TABLES `COLLABORATEUR` WRITE;
/*!40000 ALTER TABLE `COLLABORATEUR` DISABLE KEYS */;
INSERT INTO `COLLABORATEUR` VALUES 
	('a131','Villechalane','azerty','Louis','8 cours Lafontaine','29000','BREST','2012-11-08',NULL,'SW'),
	('a17','Andre','azerty','David','1 r Aimon de Chissée','38100','GRENOBLE','2008-06-19',NULL,'GY'),
	('a55','Bedos','azerty','Christian','1 r Bénédictins','65000','TARBES','2007-09-07',NULL,'GY'),
	('a93','Tusseau','azerty','Louis','22 r Renou','86000','POITIERS','2001-02-09',NULL,'SW'),
	('b13','Bentot','azerty','Pascal','11 av 6 Juin','67000','STRASBOURG','2003-11-06',NULL,'GY'),
	('b16','Bioret','azerty','Luc','1 r Linne','35000','RENNES','2003-01-06',NULL,'SW'),
	('b19','Bunisset','azerty','Francis','10 r Nicolas Chorier','85000','LA ROCHE SUR YON','2013-09-23',NULL,'GY'),
	('b25','Bunisset','azerty','Denise','1 r Lionne','49100','ANGERS','2007-03-04',NULL,'SW'),
	('b28','Cacheux','azerty','Bernard','114 r Authie','34000','MONTPELLIER','2008-02-10',NULL,'GY'),
	('b34','Cadic','azerty','Eric','123 r Caponiére','41000','BLOIS','2012-06-03','P','SW'),
	('b4','Charoze','azerty','Catherine','100 pl Géants','33000','BORDEAUX','2009-05-07',NULL,'SW'),
	('b50','Clepkens','azerty','Christophe','12 r Fédérico Garcia Lorca','13000','MARSEILLE','2011-08-18',NULL,'SW'),
	('b59','Cottin','azerty','Vincenne','36 sq Capucins','5000','GAP','2010-12-19',NULL,'GY'),
	('c14','Daburon','azerty','François','13 r Champs Elysées','6000','NICE','2012-01-20','S','SW'),
	('c3','De','azerty','Philippe','13 r Charles Peguy','10000','TROYES','2005-05-29',NULL,'SW'),
	('c54','Debelle','azerty','Michel','181 r Caponiére','88000','EPINAL','2004-09-19',NULL,'SW'),
	('d13','Debelle','azerty','Jeanne','134 r Stalingrad','44000','NANTES','2012-05-25',NULL,'SW'),
	('d51','Debroise','azerty','Michel','2 av 6 Juin','70000','VESOUL','2011-08-17','E','GY'),
	('e22','Desmarquest','azerty','Nathalie','14 r Fédérico Garcia Lorca','54000','NANCY','2013-04-18',NULL,'GY'),
	('e24','Desnost','azerty','Pierre','16 r Barral de Montferrat','55000','VERDUN','2013-04-18','E','SW'),
	('e39','Dudouit','azerty','Frédéric','18 quai Xavier Jouvin','75000','PARIS','2013-04-18',NULL,'GY'),
	('e49','Duncombe','azerty','Claude','19 av Alsace Lorraine','9000','FOIX','2012-09-16',NULL,'GY'),
	('e5','Enault-Pascreau','azerty','Céline','25B r Stalingrad','40000','MONT DE MARSAN','2012-09-16','S','GY'),
	('e52','Eynde','azerty','Valérie','3 r Henri Moissan','76000','ROUEN','2012-09-16',NULL,'GY'),
	('f21','Finck','azerty','Jacques','rte Montreuil Bellay','74000','ANNECY','2012-09-16',NULL,'SW'),
	('f39','Frémont','azerty','Fernande','4 r Jean Giono','69000','LYON','2005-05-29',NULL,'GY'),
	('f4','Gest','azerty','Alain','30 r Authie','46000','FIGEAC','2005-05-29',NULL,'GY'),
	('g19','Gheysen','azerty','Galassus','32 bd Mar Foch','75000','PARIS','2005-05-29',NULL,'SW'),
	('g30','Girard','azerty','Yvon','31 av 6 Juin','80000','AMIENS','2012-05-25','N','GY'),
	('g53','Gombert','azerty','Luc','32 r Emile Gueymard','56000','VANNES','2012-05-25',NULL,'GY'),
	('g7','Guindon','azerty','Caroline','40 r Mar Montgomery','87000','LIMOGES','2012-05-25',NULL,'GY'),
	('h13','Guindon','azerty','François','44 r Picotiére','19000','TULLE','2012-05-25',NULL,'SW'),
	('h30','Igigabel','azerty','Guy','33 gal Arlequin','94000','CRETEIL','2008-06-19',NULL,'SW'),
	('h35','Jourdren','azerty','Pierre','34 av Jean Perrot','15000','AURRILLAC','2008-06-19',NULL,'GY'),
	('h40','Juttard','azerty','Pierre-Raoul','34 cours Jean Jaurès','8000','SEDAN','2008-06-19',NULL,'GY'),
	('j45','LABORATOIREuré-Morel','azerty','Saout','38 cours Berriat','52000','CHAUMONT','2008-06-19','N','SW'),
	('j50','Landré','azerty','Philippe','4 av Gén Laperrine','59000','LILLE','2000-05-01',NULL,'GY'),
	('j8','Langeard','azerty','Hugues','39 av Jean Perrot','93000','BAGNOLET','2000-05-01','P','GY'),
	('k4','Lanne','azerty','Bernard','4 r Bayeux','30000','NIMES','2000-05-01',NULL,'SW'),
	('k53','Le','azerty','Noêl','4 av Beauvert','68000','MULHOUSE','2000-05-01',NULL,'SW'),
	('l14','Le','azerty','Jean','39 r Raspail','53000','LAVAL','2000-05-01',NULL,'SW'),
	('l23','Leclercq','azerty','Servane','11 r Quinconce','18000','BOURGES','1998-11-23',NULL,'SW'),
	('l46','Lecornu','azerty','Jean-Bernard','4 bd Mar Foch','72000','LA FERTE BERNARD','1998-11-23',NULL,'GY'),
	('l56','Lecornu','azerty','Ludovic','4 r Abel Servien','25000','BESANCON','1998-11-23',NULL,'SW'),
	('m35','Lejard','azerty','Agnès','4 r Anthoard','82000','MONTAUBAN','1998-11-23',NULL,'SW'),
	('m45','Lesaulnier','azerty','Pascal','47 r Thiers','57000','METZ','1998-11-23',NULL,'SW'),
	('n42','Letessier','azerty','St�phane','5 chem Capuche','27000','EVREUX','1998-11-23',NULL,'GY'),
	('n58','Loirat','azerty','Didier','Les PÃªchers cit� Bourg la Croix','45000','ORLEANS','1998-11-23',NULL,'GY'),
	('n59','Maffezzoli','azerty','Thibaud','5 r Chateaubriand','2000','LAON','2005-12-21',NULL,'SW'),
	('o26','Mancini','azerty','Anne','5 r D\'\'Agier','48000','MENDE','2005-12-21',NULL,'GY'),
	('p32','Marcouiller','azerty','Gérard','7 pl St Gilles','91000','ISSY LES MOULINEAUX','2005-12-21',NULL,'GY'),
	('p40','Michel','azerty','Jean-Claude','5 r Gabriel Péri','61000','FLERS','2005-12-21','O','SW'),
	('p41','Montecot','azerty','Françoise','6 r Paul Valéry','17000','SAINTES','2005-12-21',NULL,'GY'),
	('p42','Notini','azerty','Veronique','5 r Lieut Chabal','60000','BEAUVAIS','2005-12-21',NULL,'SW'),
	('p49','Onfroy','azerty','Den','5 r Sidonie Jacolin','37000','TOURS','2005-12-21',NULL,'GY'),
	('p6','Pascreau','azerty','Charles','57 bd Mar Foch','64000','PAU','1997-03-30',NULL,'SW'),
	('p7','Pernot','azerty','Claude-Noêl','6 r Alexandre 1 de Yougoslavie','11000','NARBONNE','2003-01-02',NULL,'SW'),
	('p8','Perrier','azerty','Maotre','6 r Aubert Dubayet','71000','CHALON SUR SAONE','2006-06-23',NULL,'GY'),
	('q17','Petit','azerty','Jean-Louis','7 r Ernest Renan','50000','SAINT LO','2009-06-07',NULL,'GY'),
	('r24','Piquery','azerty','Patrick','9 r Vaucelles','14000','CAEN','2007-04-29','O','GY'),
	('r58','Quiquandon','azerty','Joêl','7 r Ernest Renan','29000','QUIMPER','2006-09-30',NULL,'GY'),
	('s10','Retailleau','azerty','Josselin','88Bis r Saumuroise','39000','DOLE','2011-12-05',NULL,'SW'),
	('s21','Retailleau','azerty','Pascal','32 bd Ayrault','23000','MONTLUCON','2009-05-09',NULL,'SW'),
	('t43','Souron','azerty','Maryse','7B r Gay Lussac','21000','DIJON','2003-09-03',NULL,'SW'),
	('t47','Tiphagne','azerty','Patrick','7B r Gay Lussac','62000','ARRAS','1997-08-29',NULL,'SW'),
	('t55','Tréhet','azerty','Alain','7D chem Barral','12000','RODEZ','1994-11-29',NULL,'SW'),
	('t60','Tusseau','azerty','Josselin','63 r Bon Repos','28000','CHARTRES','1991-03-29',NULL,'GY');
/*!40000 ALTER TABLE `COLLABORATEUR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OFFRIR`
--

DROP TABLE IF EXISTS `OFFRIR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OFFRIR` (
  `COL_MATRICULE` varchar(20) NOT NULL DEFAULT '',
  `RAP_NUM` int(11) NOT NULL DEFAULT '0',
  `MED_DEPOTLEGAL` varchar(20) NOT NULL DEFAULT '',
  `OFF_QTE` int(11) DEFAULT NULL,
  PRIMARY KEY (`COL_MATRICULE`,`RAP_NUM`,`MED_DEPOTLEGAL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OFFRIR`
--

LOCK TABLES `OFFRIR` WRITE;
/*!40000 ALTER TABLE `OFFRIR` DISABLE KEYS */;
INSERT INTO `OFFRIR` VALUES 
	('a17',4,'3MYC7',3),
	('a17',4,'AMOX45',12);
	
/*!40000 ALTER TABLE `OFFRIR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `POSSEDER`
--

DROP TABLE IF EXISTS `POSSEDER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `POSSEDER` (
  `PRA_NUM` int(11) NOT NULL DEFAULT '0',
  `SPE_CODE` varchar(10) NOT NULL DEFAULT '',
  `POS_DIPLOME` varchar(20) DEFAULT NULL,
  `POS_COEFPRESCRIPTION` float DEFAULT NULL,
  PRIMARY KEY (`PRA_NUM`,`SPE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `POSSEDER`
--

LOCK TABLES `POSSEDER` WRITE;
/*!40000 ALTER TABLE `POSSEDER` DISABLE KEYS */;
/*!40000 ALTER TABLE `POSSEDER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRATICIEN`
--

DROP TABLE IF EXISTS `PRATICIEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRATICIEN` (
  `PRA_NUM` int(11) NOT NULL DEFAULT '0',
  `PRA_NOM` varchar(50) DEFAULT NULL,
  `PRA_PRENOM` varchar(60) DEFAULT NULL,
  `PRA_ADRESSE` varchar(100) DEFAULT NULL,
  `PRA_CP` varchar(10) DEFAULT NULL,
  `PRA_VILLE` varchar(50) DEFAULT NULL,
  `PRA_COEFNOTORIETE` float DEFAULT NULL,
  `TYP_CODE` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`PRA_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRATICIEN`
--

LOCK TABLES `PRATICIEN` WRITE;
/*!40000 ALTER TABLE `PRATICIEN` DISABLE KEYS */;
INSERT INTO `PRATICIEN` VALUES 
	(1,'Notini','Alain','114 r Authie','85000','LA ROCHE SUR YON',290.03,'MH'),
	(2,'Gosselin','Albert','13 r Devon','41000','BLOIS',307.49,'MV'),
	(3,'Delahaye','André','36 av 6 Juin','25000','BESANCON',185.79,'PS'),
	(4,'Leroux','André','47 av Robert Schuman','60000','BEAUVAIS',172.04,'PH'),
	(5,'Desmoulins','Anne','31 r St Jean','30000','NIMES',94.75,'PO'),
	(6,'Mouel','Anne','27 r Auvergne','80000','AMIENS',45.2,'MH'),
	(7,'Desgranges-Lentz','Antoine','1 r Albert de Mun','29000','MORLAIX',20.07,'MV'),
	(8,'Marcouiller','Arnaud','31 r St Jean','68000','MULHOUSE',396.52,'PS'),
	(9,'Dupuy','Benoit','9 r Demolombe','34000','MONTPELLIER',395.66,'PH'),
	(10,'Lerat','Bernard','31 r St Jean','59000','LILLE',257.79,'PO'),
	(11,'Marçais-Lefebvre','Bertrand','86Bis r Basse','67000','STRASBOURG',450.96,'MH'),
	(12,'Boscher','Bruno','94 r Falaise','10000','TROYES',356.14,'MV'),
	(13,'Morel','Catherine','21 r Chateaubriand','75000','PARIS',379.57,'PS'),
	(14,'Guivarch','Chantal','4 av Gén Laperrine','45000','ORLEANS',114.56,'PH'),
	(15,'Bessin-Grosdoit','Christophe','92 r Falaise','6000','NICE',222.06,'PO'),
	(16,'Rossa','Claire','14 av Thiès','6000','NICE',529.78,'MH'),
	(17,'Cauchy','Denis','5 av Ste Thérèse','11000','NARBONNE',458.82,'MV'),
	(18,'Gaffé','Dominique','9 av 1ère Armée Française','35000','RENNES',213.4,'PS'),
	(19,'Guenon','Dominique','98 bd Mar Lyautey','44000','NANTES',175.89,'PH'),
	(20,'Prévot','Dominique','29 r Lucien Nelle','87000','LIMOGES',151.36,'PO'),
	(21,'Houchard','Eliane','9 r Demolombe','49100','ANGERS',436.96,'MH'),
	(22,'Desmons','Elisabeth','51 r Bernières','29000','QUIMPER',281.17,'MV'),
	(23,'Flament','Elisabeth','11 r Pasteur','35000','RENNES',315.6,'PS'),
	(24,'Goussard','Emmanuel','9 r Demolombe','41000','BLOIS',40.72,'PH'),
	(25,'Desprez','Eric','9 r Vaucelles','33000','BORDEAUX',406.85,'PO'),
	(26,'Coste','Evelyne','29 r Lucien Nelle','19000','TULLE',441.87,'MH'),
	(27,'Lefebvre','Frédéric','2 pl Wurzburg','55000','VERDUN',573.63,'MV'),
	(28,'Lemée','Frédéric','29 av 6 Juin','56000','VANNES',326.4,'PS'),
	(29,'Martin','Frédéric','Bât A 90 r Bayeux','70000','VESOUL',506.06,'PH'),
	(30,'Marie','Frédérique','172 r Caponière','70000','VESOUL',313.31,'PO'),
	(31,'Rosenstech','Geneviève','27 r Auvergne','75000','PARIS',366.82,'MH'),
	(32,'Pontavice','Ghislaine','8 r Gaillon','86000','POITIERS',265.58,'MV'),
	(33,'Leveneur-Mosquet','Guillaume','47 av Robert Schuman','64000','PAU',184.97,'PS'),
	(34,'Blanchais','Guy','30 r Authie','8000','SEDAN',502.48,'PH'),
	(35,'Leveneur','Hugues','7 pl St Gilles','62000','ARRAS',7.39,'PO'),
	(36,'Mosquet','Isabelle','22 r Jules Verne','76000','ROUEN',77.1,'MH'),
	(37,'Giraudon','Jean-Christophe','1 r Albert de Mun','38100','VIENNE',92.62,'MV'),
	(38,'Marie','Jean-Claude','26 r Hérouville','69000','LYON',120.1,'PS'),
	(39,'Maury','Jean-François','5 r Pierre Girard','71000','CHALON SUR SAONE',13.73,'PH'),
	(40,'Dennel','Jean-Louis','7 pl St Gilles','28000','CHARTRES',550.69,'PO'),
	(41,'Ain','Jean-Pierre','4 résid Olympia','2000','LAON',5.59,'MH'),
	(42,'Chemery','Jean-Pierre','51 pl Ancienne Boucherie','14000','CAEN',396.58,'MV'),
	(43,'Comoz','Jean-Pierre','35 r Auguste Lechesne','18000','BOURGES',340.35,'PS'),
	(44,'Desfaudais','Jean-Pierre','7 pl St Gilles','29000','BREST',71.76,'PH'),
	(45,'Phan','Jérôme','9 r Clos Caillet','79000','NIORT',451.61,'PO'),(
	46,'Riou','Line','43 bd Gén Vanier','77000','MARNE LA VALLEE',193.25,'MH'),
	(47,'Chubilleau','Louis','46 r Eglise','17000','SAINTES',202.07,'MV'),
	(48,'Lebrun','Lucette','178 r Auge','54000','NANCY',410.41,'PS'),
	(49,'Goessens','Marc','6 av 6 Juin','39000','DOLE',548.57,'PH'),
	(50,'Laforge','Marc','5 résid Prairie','50000','SAINT LO',265.05,'PO'),
	(51,'Millereau','Marc','36 av 6 Juin','72000','LA FERTE BERNARD',430.42,'MH'),
	(52,'Dauverne','Marie-Christine','69 av Charlemagne','21000','DIJON',281.05,'MV'),
	(53,'Vittorio','Myriam','3 pl Champlain','94000','BOISSY SAINT LEGER',356.23,'PS'),
	(54,'Lapasset','Nhieu','31 av 6 Juin','52000','CHAUMONT',107,'PH'),
	(55,'Plantet-Besnier','Nicole','10 av 1ère Armée Française','86000','CHATELLEREAULT',369.94,'PO'),
	(56,'Chubilleau','Pascal','3 r Hastings','15000','AURRILLAC',290.75,'MH'),
	(57,'Robert','Pascal','31 r St Jean','93000','BOBIGNY',162.41,'MV'),
	(58,'Jean','Pascale','114 r Authie','49100','SAUMUR',375.52,'PS'),
	(59,'Chanteloube','Patrice','14 av Thiès','13000','MARSEILLE',478.01,'PH'),
	(60,'Lecuirot','Patrice','résid St Pères 55 r Pigacière','54000','NANCY',239.66,'PO'),
	(61,'Gandon','Patrick','47 av Robert Schuman','37000','TOURS',599.06,'MH'),
	(62,'Mirouf','Patrick','22 r Puits Picard','74000','ANNECY',458.42,'MV'),
	(63,'Boireaux','Philippe','14 av Thiès','10000','CHALON EN CHAMPAGNE',454.48,'PS'),
	(64,'Cendrier','Philippe','7 pl St Gilles','12000','RODEZ',164.16,'PH'),
	(65,'Duhamel','Philippe','114 r Authie','34000','MONTPELLIER',98.62,'PO'),
	(66,'Grigy','Philippe','15 r Mélingue','44000','CLISSON',285.1,'MH'),
	(67,'Linard','Philippe','1 r Albert de Mun','81000','ALBI',486.3,'MV'),
	(68,'Lozier','Philippe','8 r Gaillon','31000','TOULOUSE',48.4,'PS'),
	(69,'Dechâtre','Pierre','63 av Thiès','23000','MONTLUCON',253.75,'PH'),
	(70,'Goessens','Pierre','22 r Jean Romain','40000','MONT DE MARSAN',426.19,'PO'),
	(71,'Leménager','Pierre','39 av 6 Juin','57000','METZ',118.7,'MH'),
	(72,'Née','Pierre','39 av 6 Juin','82000','MONTAUBAN',72.54,'MV'),
	(73,'Guyot','Pierre-Laurent','43 bd Gén Vanier','48000','MENDE',352.31,'PS'),
	(74,'Chauchard','Roger','9 r Vaucelles','13000','MARSEILLE',552.19,'PH'),
	(75,'Mabire','Roland','11 r Boutiques','67000','STRASBOURG',422.39,'PO'),
	(76,'Leroy','Soazig','45 r Boutiques','61000','ALENCON',570.67,'MH'),
	(77,'Guyot','Stéphane','26 r Hérouville','46000','FIGEAC',28.85,'MV'),
	(78,'Delposen','Sylvain','39 av 6 Juin','27000','DREUX',292.01,'PS'),
	(79,'Rault','Sylvie','15 bd Richemond','2000','SOISSON',526.6,'PH'),
	(80,'Renouf','Sylvie','98 bd Mar Lyautey','88000','EPINAL',425.24,'PO'),
	(81,'Alliet-Grach','Thierry','14 av Thiès','7000','PRIVAS',451.31,'MH'),
	(82,'Bayard','Thierry','92 r Falaise','42000','SAINT ETIENNE',271.71,'MV'),
	(83,'Gauchet','Thierry','7 r Desmoueux','38100','GRENOBLE',406.1,'PS'),
	(84,'Bobichon','Tristan','219 r Caponière','9000','FOIX',218.36,'PH'),
	(85,'Duchemin-Laniel','Véronique','130 r St Jean','33000','LIBOURNE',265.61,'PO'),
	(86,'Laurent','Younès','34 r Demolombe','53000','MAYENNE',496.1,'MH');
/*!40000 ALTER TABLE `PRATICIEN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRESCRIRE`
--

DROP TABLE IF EXISTS `PRESCRIRE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRESCRIRE` (
  `MED_DEPOTLEGAL` varchar(20) NOT NULL DEFAULT '',
  `TIN_CODE` varchar(10) NOT NULL DEFAULT '',
  `DOS_CODE` varchar(20) NOT NULL DEFAULT '',
  `PRE_POSOLOGIE` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`MED_DEPOTLEGAL`,`TIN_CODE`,`DOS_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRESCRIRE`
--

LOCK TABLES `PRESCRIRE` WRITE;
/*!40000 ALTER TABLE `PRESCRIRE` DISABLE KEYS */;
/*!40000 ALTER TABLE `PRESCRIRE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRESENTATION`
--

DROP TABLE IF EXISTS `PRESENTATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRESENTATION` (
  `PRE_CODE` varchar(4) NOT NULL DEFAULT '',
  `PRE_LIBELLE` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`PRE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRESENTATION`
--

LOCK TABLES `PRESENTATION` WRITE;
/*!40000 ALTER TABLE `PRESENTATION` DISABLE KEYS */;
/*!40000 ALTER TABLE `PRESENTATION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `RAPPORT_VISITE`
--

DROP TABLE IF EXISTS `RAPPORT_VISITE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RAPPORT_VISITE` (
  `COL_MATRICULE` varchar(20) NOT NULL ,
  `RAP_NUM` int(11) NOT NULL ,
  `PRA_NUM` int(11) DEFAULT NULL DEFAULT '0',
  `RAP_DATE` date DEFAULT NULL,
  `DATE_VISITE` date NOT NULL,
  `RAP_BILAN` varchar(510) DEFAULT NULL,
  `RAP_MOTIF` int(8) NOT NULL,
  `COEF_CONF` int(2) DEFAULT NULL,
  `RAP_EST_LU` bit DEFAULT false,
  PRIMARY KEY (`COL_MATRICULE`,`RAP_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RAPPORT_VISITE`
--

LOCK TABLES `RAPPORT_VISITE` WRITE;
/*!40000 ALTER TABLE `RAPPORT_VISITE` DISABLE KEYS */;
INSERT INTO `RAPPORT_VISITE` VALUES 
	('a131',3,23,'2013-04-20','2013-05-21','Médecin curieux, à recontacer en décembre pour réunion',1,1,0),
('a17',4,40,'2014-03-01','2014-03-21','Changement de direction, redéfinition de la politique médicamenteuse, recours au générique',3,5,0),
	('a131',7,41,'2014-04-12','2014-04-21','RAS Changement de tel : 05 89 89 89 89',2,2,1);
	
/*!40000 ALTER TABLE `RAPPORT_VISITE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REALISER`
--

DROP TABLE IF EXISTS `REALISER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `REALISER` (
  `AC_NUM` int(11) NOT NULL DEFAULT '0',
  `COL_MATRICULE` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`AC_NUM`,`COL_MATRICULE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REALISER`
--

LOCK TABLES `REALISER` WRITE;
/*!40000 ALTER TABLE `REALISER` DISABLE KEYS */;
/*!40000 ALTER TABLE `REALISER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REGION`
--

DROP TABLE IF EXISTS `REGION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `REGION` (
  `REG_CODE` varchar(4) NOT NULL DEFAULT '',
  `SEC_CODE` varchar(2) DEFAULT NULL,
  `REG_NOM` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`REG_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REGION`
--

LOCK TABLES `REGION` WRITE;
/*!40000 ALTER TABLE `REGION` DISABLE KEYS */;
INSERT INTO `REGION` VALUES 
	('AL','E','Alsace Lorraine'),
	('AQ','S','Aquitaine'),
	('AU','P','Auvergne'),
	('BG','O','Bretagne'),
	('BN','O','Basse Normandie'),
	('BO','E','Bourgogne'),
	('CA','N','Champagne Ardennes'),
	('CE','P','Centre'),
	('FC','E','Franche Comté'),
	('HN','N','Haute Normandie'),
	('IF','P','Ile de France'),
	('LG','S','Languedoc'),
	('LI','P','Limousin'),
	('MP','S','Midi Pyrénée'),
	('NP','N','Nord Pas de Calais'),
	('PA','S','Provence Alpes Cote d\'\'Azur'),
	('PC','O','Poitou Charente'),
	('PI','N','Picardie'),
	('PL','O','Pays de Loire'),
	('RA','E','Rhone Alpes'),
	('RO','S','Roussilon'),
	('VD','O','Vendée');
/*!40000 ALTER TABLE `REGION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SECTEUR`
--

DROP TABLE IF EXISTS `SECTEUR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SECTEUR` (
  `SEC_CODE` varchar(2) NOT NULL DEFAULT '',
  `SEC_LIBELLE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`SEC_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SECTEUR`
--

LOCK TABLES `SECTEUR` WRITE;
/*!40000 ALTER TABLE `SECTEUR` DISABLE KEYS */;
INSERT INTO `SECTEUR` VALUES 
	('E','Est'),
	('N','Nord'),
	('O','Ouest'),
	('P','Paris centre'),
	('S','Sud');
/*!40000 ALTER TABLE `SECTEUR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SPECIALITE`
--

DROP TABLE IF EXISTS `SPECIALITE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SPECIALITE` (
  `SPE_CODE` varchar(10) NOT NULL DEFAULT '',
  `SPE_LIBELLE` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`SPE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SPECIALITE`
--

LOCK TABLES `SPECIALITE` WRITE;
/*!40000 ALTER TABLE `SPECIALITE` DISABLE KEYS */;
INSERT INTO `SPECIALITE` VALUES 
	('ACP','anatomie et cytologie pathologiques'),
	('AMV','angéiologie, Médecine vasculaire'),
	('ARC','anesthésiologie et réanimation chirurgicale'),
	('BM','biologie médicale'),
	('CAC','cardiologie et affections cardio-vasculaires'),
	('CCT','chirurgie cardio-vasculaire et thoracique'),
	('CG','chirurgie générale'),
	('CMF','chirurgie maxillo-faciale'),
	('COM','cancérologie, oncologie médicale'),
	('COT','chirurgie orthopédique et traumatologie'),
	('CPR','chirurgie plastique reconstructrice et esthétique'),
	('CU','chirurgie urologique'),
	('CV','chirurgie vasculaire'),
	('DN','diabétologie-nutrition, nutrition'),
	('DV','dermatologie et vénéréologie'),
	('EM','endocrinologie et métabolismes'),
	('ETD','évaluation et traitement de la douleur'),
	('GEH','gastro-entérologie et hépatologie (appareil digestif)'),
	('GMO','gynécologie médicale, obstétrique'),
	('GO','gynécologie-obstétrique'),
	('HEM','maladies du sang (hématologie)'),
	('MBS','Médecine et biologie du sport'),
	('MDT','Médecine du travail'),
	('MMO','Médecine manuelle - ostéopathie'),
	('MN','Médecine nucléaire'),
	('MPR','Médecine physique et de réadaptation'),
	('MTR','Médecine tropicale, pathologie infectieuse et tropicale'),
	('NEP','néphrologie'),('NRC','neurochirurgie'),
	('NRL','neurologie'),
	('ODM','orthopédie dento maxillo-faciale'),
	('OPH','ophtalmologie'),
	('ORL','oto-rhino-laryngologie'),
	('PEA','psychiatrie de l\'\'enfant et de l\'\'adolescent'),
	('PME','pédiatrie maladies des enfants'),
	('PNM','pneumologie'),
	('PSC','psychiatrie'),
	('RAD','radiologie (radiodiagnostic et imagerie médicale)'),
	('RDT','radiothérapie (oncologie option radiothérapie)'),
	('RGM','reproduction et gynécologie médicale'),
	('RHU','rhumatologie'),
	('STO','stomatologie'),
	('SXL','sexologie'),
	('TXA','toxicomanie et alcoologie');
/*!40000 ALTER TABLE `SPECIALITE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRAVAILLER`
--

DROP TABLE IF EXISTS `TRAVAILLER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TRAVAILLER` (
  `COL_MATRICULE` varchar(20) NOT NULL DEFAULT '',
  `JJMMAA` date NOT NULL DEFAULT '0000-00-00',
  `REG_CODE` varchar(4) NOT NULL DEFAULT '',
  `TRA_ROLE` varchar(22) DEFAULT NULL,
  PRIMARY KEY (`COL_MATRICULE`,`JJMMAA`,`REG_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRAVAILLER`
--

LOCK TABLES `TRAVAILLER` WRITE;
/*!40000 ALTER TABLE `TRAVAILLER` DISABLE KEYS */;
INSERT INTO `TRAVAILLER` VALUES 
	('p49','2014-02-20','CE','Visiteur'),
	('k53','2014-02-20','CA','Visiteur'),
	('r24','2014-02-20','BN','Visiteur'),
	('g53','2014-02-20','BG','Visiteur'),
	('m35','2014-03-12','MP','Visiteur'),
	('e39','2014-03-12','IF','Visiteur'),
	('e22','2014-03-12','AL','Visiteur'),
	('p7','2014-03-12','RO','Visiteur'),
	('r58','2014-03-12','BG','Visiteur'),
	('m45','2014-03-12','AL','Visiteur'),
	('t60','2014-03-12','CE','Visiteur'),
	('c54','2014-01-05','AL','Visiteur'),
	('p8','2014-01-05','BO','Visiteur'),
	('a17','2014-01-05','RA','Visiteur'),
	('e52','2014-01-05','HN','Visiteur'),
	('d13','2014-01-05','PL','Visiteur'),
	('k53','2014-01-05','AL','Délégué'),
	('c3','2014-01-05','CA','Visiteur'),
	('n58','2014-01-05','CE','Visiteur'),
	('s21','2014-01-05','LI','Visiteur'),
	('h40','2014-01-05','CA','Visiteur'),
	('a131','2014-01-05','BN','Visiteur'),
	('j50','2014-01-05','NP','Visiteur'),
	('p32','2014-01-20','IF','Visiteur'),
	('h13','2014-01-20','LI','Visiteur'),
	('f21','2014-01-20','RA','Visiteur'),
	('h35','2014-01-20','AU','Visiteur'),
	('b34','2014-01-20','CE','Délégué'),
	('f4','2014-03-02','MP','Visiteur'),
	('b25','2014-03-02','PL','Visiteur'),
	('t55','2014-03-02','MP','Visiteur'),
	('p42','2014-03-02','PI','Visiteur'),
	('n59','2014-03-02','PI','Visiteur'),
	('o26','2014-03-02','LG','Visiteur'),
	('l14','2014-03-02','PL','Visiteur'),
	('t43','2014-03-02','BO','Visiteur'),
	('a55','2014-03-02','RO','Visiteur'),
	('l23','2014-03-02','PC','Visiteur'),
	('b59','2014-03-02','RA','Visiteur'),
	('s10','2014-03-03','FC','Visiteur'),
	('g7','2014-03-03','LI','Visiteur'),
	('g19','2014-03-03','IF','Visiteur'),
	('e49','2014-03-03','MP','Visiteur'),
	('l56','2014-03-03','FC','Visiteur'),
	('n42','2014-03-03','HN','Visiteur'),
	('b13','2014-03-03','AL','Visiteur'),
	('a131','2014-03-03','BG','Visiteur'),
	('k4','2014-03-03','LG','Visiteur'),
	('l46','2014-03-03','PL','Visiteur'),
	('c14','2014-04-04','PA','Délégué'),
	('f39','2014-04-04','RA','Visiteur'),
	('b16','2014-04-04','BG','Visiteur'),
	('p6','2004-05-022014-03-02','AQ','Visiteur'),
	('t47','2004-05-02','PI','Visiteur'),
	('q17','2003-03-01','BN','Visiteur'),
	('b4','2003-03-01','AQ','Visiteur'),
	('b50','2003-03-01','PA','Visiteur'),
	('j45','2003-03-01','CA','Responsable'),
	('h30','2003-03-01','IF','Visiteur'),
	('j8','2008-02-10','IF','Responsable'),
	('p41','2008-02-10','PC','Visiteur'),
	('a93','2008-02-10','PC','Visiteur'),
	('b19','2008-02-10','PL','Visiteur'),
	('p40','2008-02-10','BN','Responsable'),
	('b25','2001-01-00','PL','Délégué'),
	('e24','2008-02-10','AL','Responsable'),
	('b28','2008-02-10','LG','Visiteur'),
	('g30','2003-03-01','PI','Responsable'),
	('e5','2003-03-01','AQ','Responsable'),
	('c14','2003-03-01','PA','Responsable'),
	('d51','2003-03-01','FC','Responsable');
/*!40000 ALTER TABLE `TRAVAILLER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TYPE_INDIVIDU`
--

DROP TABLE IF EXISTS `TYPE_INDIVIDU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TYPE_INDIVIDU` (
  `TIN_CODE` varchar(10) NOT NULL DEFAULT '',
  `TIN_LIBELLE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`TIN_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TYPE_INDIVIDU`
--

LOCK TABLES `TYPE_INDIVIDU` WRITE;
/*!40000 ALTER TABLE `TYPE_INDIVIDU` DISABLE KEYS */;
/*!40000 ALTER TABLE `TYPE_INDIVIDU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TYPE_PRATICIEN`
--

DROP TABLE IF EXISTS `TYPE_PRATICIEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TYPE_PRATICIEN` (
  `TYP_CODE` varchar(6) NOT NULL DEFAULT '',
  `TYP_LIBELLE` varchar(50) DEFAULT NULL,
  `TYP_LIEU` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`TYP_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TYPE_PRATICIEN`
--

LOCK TABLES `TYPE_PRATICIEN` WRITE;
/*!40000 ALTER TABLE `TYPE_PRATICIEN` DISABLE KEYS */;
INSERT INTO `TYPE_PRATICIEN` VALUES
	('MH','Médecin Hospitalier','Hopital ou clinique'),
	('MV','Médecine de Ville','Cabinet'),
	('PH','Pharmacien Hospitalier','Hopital ou clinique'),
	('PO','Pharmacien Officine','Pharmacie'),
	('PS','Personnel de santé','Centre paramédical');
/*!40000 ALTER TABLE `TYPE_PRATICIEN` ENABLE KEYS */;
UNLOCK TABLES;




/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

ALTER TABLE `CONSTITUER` ADD CONSTRAINT `FK_CONSTITUER_MEDICAMENT` FOREIGN KEY (`MED_DEPOTLEGAL`) REFERENCES `MEDICAMENT`( `MED_DEPOTLEGAL`) ;
ALTER TABLE `CONSTITUER` ADD CONSTRAINT `FK_CONSTITUER_COMPOSANT` FOREIGN KEY (`CMP_CODE`) REFERENCES `COMPOSANT` (`CMP_CODE`) ;

ALTER TABLE `FORMULER` ADD CONSTRAINT  `FK_FORMULER_MEDICAMENT` FOREIGN KEY (`MED_DEPOTLEGAL`)  REFERENCES `MEDICAMENT`( `MED_DEPOTLEGAL`) ;
ALTER TABLE `FORMULER` ADD CONSTRAINT  `FK_FORMULER_PRESENTATION` FOREIGN KEY (`PRE_CODE`) REFERENCES `PRESENTATION`(`PRE_CODE`) ;

ALTER TABLE `INTERAGIR` ADD CONSTRAINT  `FK_INTERAGIR_PERTURBATEUR_MEDICAMENT` FOREIGN KEY(`MED_PERTURBATEUR`) REFERENCES `MEDICAMENT`( `MED_DEPOTLEGAL`) ;
ALTER TABLE `INTERAGIR` ADD CONSTRAINT  `FK_INTERAGIR_PERTURBE_MEDICAMENT` FOREIGN KEY(`MED_PERTURBE`) REFERENCES `MEDICAMENT`( `MED_DEPOTLEGAL`) ;

ALTER TABLE `MEDICAMENT` ADD CONSTRAINT  `FK_MEDICAMENT_FAMILLE` FOREIGN KEY(`FAM_CODE`) REFERENCES `FAMILLE`(`FAM_CODE`) ;

ALTER TABLE `PRESCRIRE` ADD CONSTRAINT `FK_PRESCRIRE_MEDICAMENT` FOREIGN KEY(`MED_DEPOTLEGAL`) REFERENCES `MEDICAMENT`(`MED_DEPOTLEGAL`) ;
ALTER TABLE `PRESCRIRE` ADD CONSTRAINT `FK_PRESCRIRE_TYPE_INDIVIDU` FOREIGN KEY(`TIN_CODE`) REFERENCES `TYPE_INDIVIDU`(`TIN_CODE`) ;
ALTER TABLE `PRESCRIRE` ADD CONSTRAINT `FK_PRESCRIRE_DOSAGE` FOREIGN KEY(`DOS_CODE`) REFERENCES `DOSAGE`(`DOS_CODE`) ;

ALTER TABLE `INVITER` ADD CONSTRAINT  `FK_INVITER_ACTIVITE_COMPL` FOREIGN KEY(`AC_NUM`) REFERENCES `ACTIVITE_COMPL`(`AC_NUM`) ;
ALTER TABLE `INVITER` ADD CONSTRAINT  `FK_INVITER_PRATICIEN` FOREIGN KEY(`PRA_NUM`) REFERENCES `PRATICIEN`(`PRA_NUM`) ;

ALTER TABLE `OFFRIR` ADD CONSTRAINT  `FK_OFFRIR_COLLABORATEUR` FOREIGN KEY(`COL_MATRICULE`) REFERENCES `COLLABORATEUR`(`COL_MATRICULE`) ;
ALTER TABLE `OFFRIR` ADD CONSTRAINT  `FK_OFFRIR_RAPPORT_VISITE` FOREIGN KEY (`RAP_NUM`)  REFERENCES `RAPPORT_VISITE`(`RAP_NUM`)  ;
ALTER TABLE `OFFRIR` ADD CONSTRAINT  `FK_OFFRIR_MEDICAMENT` FOREIGN KEY (`MED_DEPOTLEGAL`) REFERENCES `MEDICAMENT`( `MED_DEPOTLEGAL`) ;

ALTER TABLE  `POSSEDER` ADD CONSTRAINT `FK_POSSEDER_PRATICIEN` FOREIGN KEY(`PRA_NUM`) REFERENCES `PRATICIEN`(`PRA_NUM`) ;
ALTER TABLE  `POSSEDER` ADD CONSTRAINT `FK_POSSEDER_SPECIALITE` FOREIGN KEY(`SPE_CODE`) REFERENCES `SPECIALITE`(`SPE_CODE`) ;

ALTER TABLE  `PRATICIEN` ADD CONSTRAINT  `FK_PRATICIEN_TYPE_PRATICIEN` FOREIGN KEY(`TYP_CODE`) REFERENCES `TYPE_PRATICIEN`(`TYP_CODE`) ;
 
ALTER TABLE `RAPPORT_VISITE` ADD CONSTRAINT  `FK_RAPPORT_VISITE_COLLABORATEUR` FOREIGN KEY(`COL_MATRICULE`) REFERENCES `COLLABORATEUR`(`COL_MATRICULE`) ;
ALTER TABLE `RAPPORT_VISITE` ADD CONSTRAINT  `FK_RAP_MOTIF` FOREIGN KEY(`RAP_MOTIF`) REFERENCES `MOTIF`(`MOT_NUM`) ;
ALTER TABLE `RAPPORT_VISITE` ADD CONSTRAINT  `FK_RAPPORT_VISITE_PRATICIEN` FOREIGN KEY(`PRA_NUM`) REFERENCES `PRATICIEN`(`PRA_NUM`) ;
 
ALTER TABLE `REALISER` ADD CONSTRAINT  `FK_REALISER_ACTIVITE_COMPL` FOREIGN KEY(`AC_NUM`) REFERENCES `ACTIVITE_COMPL`(`AC_NUM`) ;
ALTER TABLE `REALISER` ADD CONSTRAINT  `FK_REALISER_COLLABORATEUR` FOREIGN KEY(`COL_MATRICULE`) REFERENCES `COLLABORATEUR`(`COL_MATRICULE`) ;

ALTER TABLE `REGION` ADD CONSTRAINT  `FK_REGION_SECTEUR` FOREIGN KEY(`SEC_CODE`) REFERENCES `SECTEUR`(`SEC_CODE`) ;

ALTER TABLE `TRAVAILLER` ADD CONSTRAINT  `FK_TRAVAILLER_COLLABORATEUR` FOREIGN KEY(`COL_MATRICULE`) REFERENCES `COLLABORATEUR`(`COL_MATRICULE`) ;
ALTER TABLE `TRAVAILLER` ADD CONSTRAINT  `FK_TRAVAILLER_REGION` FOREIGN KEY(`REG_CODE`) REFERENCES `REGION`(`REG_CODE`) ;

ALTER TABLE `COLLABORATEUR` ADD CONSTRAINT  `FK_COLLABORATEUR_SECTEUR` FOREIGN KEY(`SEC_CODE`) REFERENCES `SECTEUR`(`SEC_CODE`) ;
ALTER TABLE `COLLABORATEUR` ADD CONSTRAINT  `FK_COLLABORATEUR_LABORATOIRE` FOREIGN KEY(`LAB_CODE`) REFERENCES `LABORATOIRE`(`LAB_CODE`) ;


