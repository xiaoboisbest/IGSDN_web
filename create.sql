/*
SQLyog Enterprise v12.08 (64 bit)
MySQL - 8.0.15 : Database - igsdn_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`igsdn_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `igsdn_db`;

/*Table structure for table `categories` */

DROP TABLE IF EXISTS `categories`;

CREATE TABLE `categories` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `level` int(11) NOT NULL DEFAULT '1',
  `parents` int(11) NOT NULL DEFAULT '0',
  `intro` text NOT NULL,
  `doc_num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `categories` */

insert  into `categories`(`ID`,`name`,`level`,`parents`,`intro`,`doc_num`) values (1,'数据结构',1,0,'数据结构是计算机存储、组织数据的方式。数据结构是指相互之间存在一种或多种特定关系的数据元素的集合。通常情况下，精心选择的数据结构可以带来更高的运行或者存储效率。数据结构往往同高效的检索算法和索引技术有关。',1),(2,'树',2,1,'树状图是一种数据结构，它是由n（n>=1）个有限结点组成一个具有层次关系的集合。把它叫做“树”是因为它看起来像一棵倒挂的树，也就是说它是根朝上，而叶朝下的。它具有以下的特点：\r\n每个结点有零个或多个子结点；没有父结点的结点称为根结点；每一个非根结点有且只有一个父结点；除了根结点外，每个子结点可以分为多个不相交的子树。',0),(3,'图',2,1,'图（Graph）是表示物件与物件之间的关系的数学对象，是图论的基本研究对象。一个不带权图中若两点不相邻，邻接矩阵相应位置为0，对带权图(网)，相应位置为∞。\r\n对于一个拥有n个顶点的无向连通图，它的边数一定多于n-1条。若从中选择n-1条边，使得无向图仍然连通，则由n个顶点及这 n-1条边（弧）组成的图被称为原无向图的生成树。',1),(4,'二叉树',3,3,'在计算机科学中，二叉树是每个结点最多有两个子树的树结构。通常子树被称作“左子树”（left subtree）和“右子树”（right subtree）。二叉树常被用于实现二叉查找树和二叉堆。\r\n一棵深度为k，且有2^k-1个节点的二叉树，称为满二叉树。这种树的特点是每一层上的节点数都是最大节点数。而在一棵二叉树中，除最后一层外，若其余层都是满的，并且最后一层或者是满的，或者是在右边缺少连续若干节点，则此二叉树为完全二叉树。具有n个节点的完全二叉树的深度为floor(log2n)+1。深度为k的完全二叉树，至少有2k-1个叶子节点，至多有2k-1个节点。',1);

/*Table structure for table `document_comments` */

DROP TABLE IF EXISTS `document_comments`;

CREATE TABLE `document_comments` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(50) NOT NULL,
  `is_identify` tinyint(1) NOT NULL,
  `commentator` int(11) NOT NULL,
  `document` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `commentator` (`commentator`),
  KEY `document` (`document`),
  CONSTRAINT `document_comments_ibfk_1` FOREIGN KEY (`commentator`) REFERENCES `ig_user` (`ID`),
  CONSTRAINT `document_comments_ibfk_2` FOREIGN KEY (`document`) REFERENCES `documents` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `document_comments` */

/*Table structure for table `document_formats` */

DROP TABLE IF EXISTS `document_formats`;

CREATE TABLE `document_formats` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `suffix` varchar(10) NOT NULL,
  `default_icon_src` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `intro` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `document_formats` */

insert  into `document_formats`(`ID`,`suffix`,`default_icon_src`,`intro`) values (1,'.pdf','icon_pdf.png','pdf（Portable Document Format的简称，意为“便携式文档格式”），是由Adobe Systems用于与应用程序、操作系统、硬件无关的方式进行文件交换所发展出的文件格式。');

/*Table structure for table `document_storages` */

DROP TABLE IF EXISTS `document_storages`;

CREATE TABLE `document_storages` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `size` varchar(20) NOT NULL,
  `upload_time` date NOT NULL,
  `src` varchar(50) NOT NULL,
  `icon_src` varchar(50) DEFAULT NULL,
  `key1` varchar(10) DEFAULT NULL,
  `key2` varchar(10) DEFAULT NULL,
  `key3` varchar(10) DEFAULT NULL,
  `intro` text NOT NULL,
  `is_public` tinyint(1) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `format` int(11) NOT NULL,
  `uploader` int(11) NOT NULL,
  `category` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `format` (`format`),
  KEY `uploader` (`uploader`),
  KEY `category` (`category`),
  CONSTRAINT `document_storages_ibfk_1` FOREIGN KEY (`format`) REFERENCES `document_formats` (`ID`),
  CONSTRAINT `document_storages_ibfk_2` FOREIGN KEY (`uploader`) REFERENCES `ig_user` (`ID`),
  CONSTRAINT `document_storages_ibfk_3` FOREIGN KEY (`category`) REFERENCES `categories` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `document_storages` */

insert  into `document_storages`(`ID`,`name`,`size`,`upload_time`,`src`,`icon_src`,`key1`,`key2`,`key3`,`intro`,`is_public`,`status`,`format`,`uploader`,`category`) values (1,'二叉树','216MB','2019-03-10','/static/uploadStorage/数据结构/图/二叉树.pdf',NULL,'二叉树','数据结构',NULL,'这个是一篇关于二叉树的文档。',1,0,1,3,4);

/*Table structure for table `documents` */

DROP TABLE IF EXISTS `documents`;

CREATE TABLE `documents` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `size` varchar(20) NOT NULL,
  `upload_time` date NOT NULL,
  `last_update_time` date NOT NULL,
  `src` varchar(50) NOT NULL,
  `icon_src` varchar(50) DEFAULT NULL,
  `key1` varchar(10) DEFAULT NULL,
  `key2` varchar(10) DEFAULT NULL,
  `key3` varchar(10) DEFAULT NULL,
  `intro` text NOT NULL,
  `is_public` tinyint(1) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `format` int(11) NOT NULL,
  `uploader` int(11) NOT NULL,
  `category` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `format` (`format`),
  KEY `uploader` (`uploader`),
  KEY `category` (`category`),
  CONSTRAINT `documents_ibfk_1` FOREIGN KEY (`format`) REFERENCES `document_formats` (`ID`),
  CONSTRAINT `documents_ibfk_2` FOREIGN KEY (`uploader`) REFERENCES `ig_user` (`ID`),
  CONSTRAINT `documents_ibfk_3` FOREIGN KEY (`category`) REFERENCES `categories` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `documents` */

/*Table structure for table `ig_user` */

DROP TABLE IF EXISTS `ig_user`;

CREATE TABLE `ig_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(20) NOT NULL,
  `gen_user_level` smallint(6) NOT NULL DEFAULT '0',
  `admin_user_level` smallint(6) NOT NULL DEFAULT '0',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `age` varchar(3) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `uname` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNIQUE_TEL` (`tel`),
  UNIQUE KEY `UNIQUE_EMAIL` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `ig_user` */

insert  into `ig_user`(`ID`,`password`,`gen_user_level`,`admin_user_level`,`tel`,`email`,`name`,`age`,`gender`,`uname`) values (1,'123456',0,1,'1','1@gmail.com',NULL,NULL,NULL,'昵称1'),(2,'123456',0,2,'2','2@gmail.com','高学坤','22',1,'昵称2'),(3,'123456',1,0,'3','3@gmail.com','董晓洁','21',1,'昵称3');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
