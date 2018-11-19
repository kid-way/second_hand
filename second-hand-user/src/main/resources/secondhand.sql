/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17 : Database - second_hand
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`second_hand` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `second_hand`;

/*Table structure for table `buycar` */

DROP TABLE IF EXISTS `buycar`;

CREATE TABLE `buycar` (
  `iid` varchar(200) NOT NULL COMMENT '条目主键',
  `uid` int(11) DEFAULT NULL COMMENT '用户主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `buycar` */

/*Table structure for table `first_category` */

DROP TABLE IF EXISTS `first_category`;

CREATE TABLE `first_category` (
  `fcid` int(11) NOT NULL AUTO_INCREMENT COMMENT '一级分类主键',
  `fcname` varchar(20) DEFAULT NULL COMMENT '一级分类名称',
  PRIMARY KEY (`fcid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `first_category` */

insert  into `first_category`(`fcid`,`fcname`) values (1,'服装'),(2,'数码产品'),(3,'影音家电'),(4,'闲置母婴');

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `iid` varchar(200) NOT NULL COMMENT '条目主键',
  `subtotal` decimal(10,2) DEFAULT NULL COMMENT '条目小计',
  `count` int(11) DEFAULT NULL COMMENT '购买商品数量',
  `pid` int(11) DEFAULT NULL COMMENT '商品主键',
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `item` */

insert  into `item`(`iid`,`subtotal`,`count`,`pid`) values ('03fefda6ef3d41d69ccd28dd887182d2','20.00',1,102),('04c6e2371e1d4545b21d3cfdcde0c3ff','20.00',1,16),('084d3119b206473b904acf689ea2fe7b','20.00',1,79),('0ec9703b84884bc8abfadbc5eb857e72','20.00',1,104),('151e98828dab41978a8691d39189aaf2','20.00',1,93),('15b3e945b62f4e6da63b25df823b4d00','20.00',1,17),('20257f46715344ffbbb907616465f7db','500.00',1,11),('36ff46685cd344a692b6d53678ffba2a','20.00',1,11),('3ff3247ba7b045158a955d3e13f8671c','40.00',2,39),('4cd202484efd4feabb3c360ac6ced21e','20.00',1,8),('58c705e1428745de877ffabe397d44dc','20.00',1,8),('637100dfe4324c629c4a41ebb0908724','20.00',1,88),('8341a613d5054aa08608bb8aaa832302','20.00',1,98),('9802fe2a799f46508f569a4511d7ac5e','20.00',1,62),('9957eddfe8934010b1a1c6d4e837d25c','20.00',1,79),('abff962621bc46728f9d406f7f6effbc','40.00',2,20),('ac72ce5f27c74e7aa30f408691088b87','20.00',1,99),('be7c71fb6f924fadb757ab11bdff90ab','40.00',2,49),('c0f03d6f3de94f2b9ce689d41fa9ef29','20.00',1,42),('d565dc7ba05f484f92dd9f92a3004c4f','20.00',1,100),('e7cb022804be416c9fbf4003c4fcdc1e','60.00',3,14),('ea1bbcdbfe3e4d419e0df12bc7779ac4','20.00',1,89),('ec061017a1234943b21cf11e9cbf8c7f','20.00',1,103),('f154b548680945dbbb52748cd5669e72','20.00',1,54),('f1888c7d39ec4c0c9f0999ef492625af','20.00',1,68),('f2984e4bf1e74baa8124ecec7dbf3993','40.00',2,8),('f5c03777e8e64a8789adaf46fb8d2a79','40.00',2,16);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `oid` varchar(255) NOT NULL,
  `uid` int(11) NOT NULL COMMENT '用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `total` decimal(10,2) DEFAULT NULL COMMENT '总计',
  `state` tinyint(4) DEFAULT NULL COMMENT '大订单状态',
  `raddress` varchar(200) NOT NULL COMMENT '收货地址',
  `rphone` varchar(20) NOT NULL COMMENT '收货人电话',
  `rname` varchar(50) NOT NULL COMMENT '收货人姓名',
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`oid`,`uid`,`create_time`,`total`,`state`,`raddress`,`rphone`,`rname`) values ('05829b031a8a466693f43d1e7c06f69a',1,'2018-03-01 18:28:09','60.00',1,'广东省','13543811425','伍克伟'),('2269b87958644d91a113e30e943598f4',1,'2018-04-23 16:09:38','20.00',1,'同样符合基金吧','13543811425','伍克伟'),('5dea794494d843faa694c068ddb1fd52',1,'2018-02-06 15:36:03','40.00',1,'上海','13543811425','伍克伟'),('847aec0880e046d292768d9086a8c721',3,'2018-02-07 22:03:28','20.00',1,'鸿景园','12345678900','陈可儿'),('93291fe137bc4798a70633d7ad17f122',1,'2018-04-23 15:48:48','40.00',1,'接哈赛季的合法地方','13543811425','伍克伟'),('96390ddc920e4368b60b2b7fde09c40f',3,'2018-02-07 22:09:30','40.00',1,'某某某','12345678900','陈锦鸿'),('b987f53ac39c4c6a87aeca1112109c20',1,'2018-02-06 12:49:08','40.00',1,'北京市朝阳区','13543811425','伍克伟'),('ba1f67ca5f1c4fd3a493364086eef28e',1,'2018-02-06 16:05:07','20.00',1,'思考的合法','13543811425','伍克伟'),('dbb4e342cfbe475b915f56153f693b35',3,'2018-02-07 21:55:08','20.00',1,'广东省汕尾市城区鸿景园1期3栋2梯1403','13543811425','陈锦鸿'),('dc3a16e59c6a434ba23637ac8e14ef30',1,'2018-02-06 16:21:08','20.00',1,'接哈赛季的合法','13543811425','伍克伟'),('dd11ddbbee7b4c649bcf8e3cf0294d4b',3,'2018-02-07 21:56:28','20.00',1,'鸿景园','12332112332','陈可儿'),('e0367cc004d24861a7c7ab791958cf62',10,'2018-02-06 16:54:49','20.00',1,'就hiuadf','11111122222','小黄'),('ea61b7d02d1e46d98d244d97ac4f53b7',3,'2018-02-07 22:05:40','40.00',1,'鸿景园','12345678900','陈锦鸿'),('f511444ba07348f2a72a2df10dd80584',11,'2018-08-13 23:48:03','40.00',1,'','12344567322','陈招全'),('f89a783b72574c58be045db950462298',1,'2018-02-06 16:04:50','20.00',1,'姐啊很舒服','13543811425','伍克伟');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `pname` varchar(20) NOT NULL COMMENT '商品名称',
  `apicname` varchar(20) DEFAULT NULL COMMENT '商品小图名称',
  `bpicname` varchar(20) DEFAULT NULL COMMENT '商品大图名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `stock` int(11) DEFAULT NULL COMMENT '商品库存',
  `sid` int(11) DEFAULT NULL COMMENT '卖家id',
  `fcid` int(11) DEFAULT NULL COMMENT '商品一级分类id',
  `scid` int(11) DEFAULT NULL COMMENT '商品二级分类id',
  `undercarriage` tinyint(2) DEFAULT '0' COMMENT '商品是否下架：1是下架了，0是未下架',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`pid`,`pname`,`apicname`,`bpicname`,`price`,`stock`,`sid`,`fcid`,`scid`,`undercarriage`) values (1,'小米','shoujia1.jpg',NULL,'400.00',3,1,2,5,0),(2,'魅白','shoujia2.jpg','shoujib2.jpg','800.00',2,3,2,5,0),(4,'苹果','shoujia3.jpg','shoujib3.jpg','1000.00',10,3,2,5,0),(5,'华为','shoujia4.jpg','shoujib4.jpg','700.00',1,1,2,5,0),(6,'小米','shoujia5.jpg','shoujib6.jpg','500.00',2,2,2,5,0),(7,'女装','nvzhuanga2.jpg',NULL,'20.00',5,1,1,1,0),(8,'女装3','nvzhuanga3.jpg',NULL,'20.00',5,1,1,1,0),(9,'女装4','nvzhuanga4.jpg','','20.00',5,1,1,1,0),(10,'女装5','nvzhuanga5.jpg','','20.00',5,1,1,1,0),(12,'女鞋1','nvxiea1.jpg','','20.00',5,1,1,2,0),(13,'女鞋2','nvxiea2.jpg','','20.00',5,1,1,2,0),(14,'女鞋3','nvxiea3.jpg','','20.00',5,1,1,2,1),(15,'女鞋4','nvxiea4.jpg','','20.00',5,1,1,2,0),(16,'女鞋5','nvxiea5.jpg','','20.00',0,1,1,2,1),(17,'女鞋6','nvxiea6.jpg','','20.00',5,1,1,2,0),(18,'女鞋7','nvxiea7.jpg','','20.00',5,1,1,2,0),(19,'包包1','baobaoa1.jpg','','20.00',5,1,1,3,0),(20,'包包2','baobaoa2.jpg','','20.00',5,1,1,3,0),(21,'包包3','baobaoa3.jpg','','20.00',5,1,1,3,0),(22,'包包4','baobaoa4.jpg','','20.00',5,1,1,3,0),(23,'包包5','baobaoa5.jpg','','20.00',5,1,1,3,0),(24,'包包6','baobaoa6.jpg','','20.00',5,1,1,3,0),(26,'配饰1','peishia1.jpg','','20.00',5,1,1,4,0),(27,'配饰2','peishia2.jpg','','20.00',5,1,1,4,0),(28,'配饰3','peishia3.jpg','','20.00',5,1,1,4,0),(29,'配饰4','peishia4.jpg','','20.00',5,1,1,4,0),(30,'配饰5','peishia5.jpg','','20.00',5,1,1,4,0),(31,'配饰6','peishia6.jpg','','20.00',5,1,1,4,0),(32,'配饰7','peishia7.jpg','','20.00',5,1,1,4,0),(33,'手机6','shoujia6.jpg','','20.00',5,2,2,5,0),(34,'手机7','shoujia7.jpg','','20.00',5,2,2,5,0),(35,'手机8','shoujia8.jpg','','20.00',5,2,2,5,0),(36,'手机9','shoujia9.jpg','','20.00',5,2,2,5,0),(37,'手机10','shoujia10.jpg','','20.00',5,2,2,5,0),(38,'手机11','shoujia11.jpg','','20.00',5,2,2,5,0),(39,'手机12','shoujia12.jpg','','20.00',5,2,2,5,0),(40,'手机13','shoujia13.jpg','','20.00',5,2,2,5,0),(41,'相机1','xiangjia1.jpg','','20.00',5,2,2,6,0),(42,'相机3','xiangjia3.jpg','','20.00',5,2,2,6,0),(43,'相机4','xiangjia4.jpg','','20.00',5,2,2,6,0),(44,'相机5','xiangjia5.jpg','','20.00',5,2,2,6,0),(45,'相机6','xiangjia6.jpg','','20.00',5,2,2,6,0),(46,'相机7','xiangjia7.jpg','','20.00',5,2,2,6,0),(47,'相机8','xiangjia8.jpg','','20.00',5,2,2,6,0),(48,'相机9','xiangjia9.jpg','','20.00',5,2,2,6,0),(49,'平板1','pingbana1.jpg','','20.00',5,2,2,8,0),(50,'平板2','pingbana2.jpg','','20.00',5,2,2,8,0),(51,'平板3','pingbana3.jpg','','20.00',5,2,2,8,0),(52,'平板4','pingbana4.jpg','','20.00',5,2,2,8,0),(53,'平板5','pingbana5.jpg','','20.00',5,2,2,8,0),(54,'平板6','pingbana6.jpg','','20.00',5,2,2,8,0),(55,'平板7','pingbana7.jpg','','20.00',5,2,2,8,0),(56,'平板8','pingbana8.jpg','','20.00',5,2,2,8,0),(57,'电脑1','diannaoa1.jpg','','20.00',5,2,2,7,0),(58,'电脑2','diannaoa2.jpg','','20.00',5,2,2,7,0),(59,'电脑3','diannaoa3.jpg','','20.00',5,2,2,7,0),(60,'电脑4','diannaoa4.jpg','','20.00',5,2,2,7,0),(61,'电脑5','diannaoa5.jpg','','20.00',5,2,2,7,0),(62,'电脑6','diannaoa6.jpg','','20.00',5,2,2,7,0),(63,'电脑7','diannaoa7.jpg','','20.00',5,2,2,7,0),(64,'电脑8','diannaoa8.jpg','','20.00',5,2,2,7,0),(65,'电脑9','diannaoa9.jpg','','20.00',5,2,2,7,0),(66,'电脑10','diannaoa10.jpg','','20.00',5,2,2,7,0),(67,'电视1','dianshia1.jpg','','20.00',5,3,3,9,0),(68,'电视3','dianshia3.jpg','','20.00',5,3,3,9,0),(69,'电视4','dianshia4.jpg','','20.00',5,3,3,9,0),(70,'烤箱1','kaoxianga1.jpg','','20.00',5,3,3,9,0),(71,'烤箱2','kaoxianga2.jpg','','20.00',5,3,3,9,0),(72,'冰箱1','bingxianga1.jpg','','20.00',5,3,3,9,0),(73,'冰箱2','bingxianga2.jpg','','20.00',5,3,3,9,0),(74,'冰箱3','bingxianga3.jpg','','20.00',5,3,3,9,0),(75,'冰箱4','bingxianga4.jpg','','20.00',5,3,3,9,0),(76,'电风扇1','dianfengshana1.jpg','','20.00',5,3,3,10,0),(77,'电风扇2','dianfengshana2.jpg','','20.00',5,3,3,10,0),(78,'电风扇3','dianfengshana3.jpg','','20.00',5,3,3,10,0),(79,'洗衣机2','xiyijia2.jpg','','20.00',5,3,3,10,0),(80,'音响1','yinxianga1.jpg','','20.00',5,3,3,10,0),(81,'音响3','yinxianga3.jpg','','20.00',5,3,3,10,0),(82,'榨汁机1','zhazhijia1.jpg','','20.00',5,3,3,11,0),(83,'榨汁机2','zhazhijia2.jpg','','20.00',5,3,3,11,0),(84,'微波炉','weibolua1.jpg','','20.00',5,3,3,11,0),(85,'微波炉2','weibolua2.jpg','','20.00',5,3,3,11,0),(86,'电饭煲1','dianfanbaoa1.jpg','','20.00',5,3,3,11,0),(87,'电饭煲2','dianfanbaoa2.jpg','','20.00',5,3,3,11,0),(88,'童装1','tongzhuanga1.jpg','','20.00',5,4,4,12,0),(89,'童装2','tongzhuanga2.jpg','','20.00',5,4,4,12,0),(90,'童装3','tongzhuanga3.jpg','','20.00',5,4,4,12,0),(91,'童装4','tongzhuanga4.jpg','','20.00',5,4,4,12,0),(92,'童装5','tongzhuanga5.jpg','','20.00',5,4,4,12,0),(93,'童装6','tongzhuanga6.jpg','','20.00',5,4,4,12,0),(94,'宝宝用具1','baobaoyongjua1.jpg','','20.00',5,4,4,13,0),(95,'宝宝用具2','baobaoyongjua2.jpg','','20.00',5,4,4,13,0),(96,'宝宝用具3','baobaoyongjua3.jpg','','20.00',5,4,4,13,0),(97,'玩具1','wanjua1.jpg','','20.00',5,4,4,14,0),(98,'玩具2','wanjua2.jpg','','20.00',5,4,4,14,0),(99,'玩具3','wanjua3.jpg','','20.00',5,4,4,14,0),(100,'玩具4','wanjua4.jpg','','20.00',5,4,4,14,0),(101,'玩具5','wanjua5.jpg','','20.00',5,4,4,14,0),(102,'玩具6','wanjua6.jpg','','20.00',5,4,4,14,0),(103,'玩具7','wanjua7.jpg','','20.00',5,4,4,14,0),(104,'玩具8','wanjua8.jpg','','20.00',5,4,4,14,0);

/*Table structure for table `second_category` */

DROP TABLE IF EXISTS `second_category`;

CREATE TABLE `second_category` (
  `scid` int(11) NOT NULL AUTO_INCREMENT COMMENT '二级分类主键',
  `scname` varchar(20) DEFAULT NULL COMMENT '二级分类名称',
  `fcid` int(11) DEFAULT NULL COMMENT '一级分类的Id',
  PRIMARY KEY (`scid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='二级分类表';

/*Data for the table `second_category` */

insert  into `second_category`(`scid`,`scname`,`fcid`) values (1,'女装',1),(2,'女鞋',1),(3,'箱包',1),(4,'配饰',1),(5,'手机',2),(6,'相机',2),(7,'笔记本',2),(8,'平板',2),(9,'大家电',3),(10,'小家电',3),(11,'料理机',3),(12,'童装',4),(13,'宝宝用品',4),(14,'玩具',4);

/*Table structure for table `seller` */

DROP TABLE IF EXISTS `seller`;

CREATE TABLE `seller` (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '卖家主键',
  `sname` varchar(20) NOT NULL COMMENT '卖家名字',
  `sphone` varchar(20) NOT NULL COMMENT '卖家电话',
  `gender` bit(1) DEFAULT b'0' COMMENT '性别：0是女，1是男',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `password` varchar(20) DEFAULT NULL COMMENT '卖家密码',
  PRIMARY KEY (`sid`),
  UNIQUE KEY `sname` (`sname`),
  UNIQUE KEY `sphone` (`sphone`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `seller` */

insert  into `seller`(`sid`,`sname`,`sphone`,`gender`,`age`,`address`,`password`) values (1,'陈真','12345123451','',22,'广东省广州市','1233333'),(2,'嘻哈侠','567999111','',20,'北京市朝阳区','kkkkkksss'),(3,'小呆','118828828','\0',18,'广东省深圳市宝安区','yyyaaa222'),(4,'嘿嘿嘿','13443811425','\0',55,'上海灵石路','5762jgs'),(5,'伍克伟','13543811425','',25,'汕尾','3264374');

/*Table structure for table `sm_order` */

DROP TABLE IF EXISTS `sm_order`;

CREATE TABLE `sm_order` (
  `soid` varchar(255) NOT NULL COMMENT '小订单主键',
  `iid` varchar(200) NOT NULL COMMENT '条目主键',
  `state` tinyint(4) DEFAULT NULL COMMENT '订单状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `oid` varchar(255) NOT NULL COMMENT '大订单主键',
  `raddress` varchar(200) NOT NULL COMMENT '收货地址',
  `rphone` varchar(20) NOT NULL COMMENT '收货人电话',
  `rname` varchar(50) NOT NULL COMMENT '收货人姓名',
  PRIMARY KEY (`soid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sm_order` */

insert  into `sm_order`(`soid`,`iid`,`state`,`create_time`,`oid`,`raddress`,`rphone`,`rname`) values ('1ea4c067c476476191aa5d62c2792676','f1888c7d39ec4c0c9f0999ef492625af',3,'2018-02-06 12:49:08','b987f53ac39c4c6a87aeca1112109c20','北京市朝阳区','13543811425','伍克伟'),('2d776b9690564bc4a7a7be02e3e43206','ea1bbcdbfe3e4d419e0df12bc7779ac4',3,'2018-02-06 16:04:50','f89a783b72574c58be045db950462298','姐啊很舒服','13543811425','伍克伟'),('32e74597f7a54e288205f938d5d59c9d','ec061017a1234943b21cf11e9cbf8c7f',3,'2018-02-06 15:36:03','5dea794494d843faa694c068ddb1fd52','上海','13543811425','伍克伟'),('44976d89a8fc49c1a87ca4ab42069d96','04c6e2371e1d4545b21d3cfdcde0c3ff',3,'2018-04-23 16:09:38','2269b87958644d91a113e30e943598f4','同样符合基金吧','13543811425','伍克伟'),('50c6d082df584e30a86cfa1831d87a4e','4cd202484efd4feabb3c360ac6ced21e',3,'2018-02-06 16:54:49','e0367cc004d24861a7c7ab791958cf62','就hiuadf','11111122222','小黄'),('640054451be446309867e88de1902922','f5c03777e8e64a8789adaf46fb8d2a79',3,'2018-04-23 15:48:48','93291fe137bc4798a70633d7ad17f122','接哈赛季的合法地方','13543811425','伍克伟'),('6ed52777cf8048af9aeeca091aa744d9','03fefda6ef3d41d69ccd28dd887182d2',3,'2018-02-07 22:03:28','847aec0880e046d292768d9086a8c721','鸿景园','12345678900','陈可儿'),('7e62148e90ce4ad7a9dbfdef65ff0417','f154b548680945dbbb52748cd5669e72',3,'2018-02-06 16:05:07','ba1f67ca5f1c4fd3a493364086eef28e','思考的合法','13543811425','伍克伟'),('8079255ec53642039f40ae011bec32b0','084d3119b206473b904acf689ea2fe7b',3,'2018-02-06 15:36:03','5dea794494d843faa694c068ddb1fd52','上海','13543811425','伍克伟'),('8341bf0cf1ce4e348807047b26ae0144','abff962621bc46728f9d406f7f6effbc',3,'2018-08-13 23:48:03','f511444ba07348f2a72a2df10dd80584','','12344567322','陈招全'),('84811ebb86b74a9bae1a73efb04e17f0','e7cb022804be416c9fbf4003c4fcdc1e',3,'2018-03-01 18:28:09','05829b031a8a466693f43d1e7c06f69a','广东省','13543811425','伍克伟'),('9dbae04e9120420f88505e0b84dc0714','d565dc7ba05f484f92dd9f92a3004c4f',3,'2018-02-07 21:55:08','dbb4e342cfbe475b915f56153f693b35','广东省汕尾市城区鸿景园1期3栋2梯1403','13543811425','陈锦鸿'),('9e61552d51a946fc9a09c700a862f375','9802fe2a799f46508f569a4511d7ac5e',3,'2018-02-06 12:49:08','b987f53ac39c4c6a87aeca1112109c20','北京市朝阳区','13543811425','伍克伟'),('bb5aa29218d8443ea4d68a651e99bc01','637100dfe4324c629c4a41ebb0908724',3,'2018-02-07 21:56:28','dd11ddbbee7b4c649bcf8e3cf0294d4b','鸿景园','12332112332','陈可儿'),('ca5d69fe1d39431792983b2a41e996ab','8341a613d5054aa08608bb8aaa832302',3,'2018-02-07 22:09:30','96390ddc920e4368b60b2b7fde09c40f','某某某','12345678900','陈锦鸿'),('d7805873e6b740f8aaf7d7a7ba753fb0','ac72ce5f27c74e7aa30f408691088b87',3,'2018-02-07 22:09:30','96390ddc920e4368b60b2b7fde09c40f','某某某','12345678900','陈锦鸿'),('fc57ad8da29f4242bece3c454e235a17','be7c71fb6f924fadb757ab11bdff90ab',3,'2018-02-07 22:05:40','ea61b7d02d1e46d98d244d97ac4f53b7','鸿景园','12345678900','陈锦鸿'),('ff1f5d3f248e4023aaa6d74632c36054','151e98828dab41978a8691d39189aaf2',3,'2018-02-06 16:21:08','dc3a16e59c6a434ba23637ac8e14ef30','接哈赛季的合法','13543811425','伍克伟');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名称',
  `uphone` varchar(20) DEFAULT NULL COMMENT '用户电话',
  `gender` bit(1) DEFAULT NULL COMMENT '性别',
  `age` smallint(6) DEFAULT NULL COMMENT '年龄',
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `uphone` (`uphone`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`uphone`,`gender`,`age`,`password`) values (1,'伍克伟','13543811425','',25,'123321'),(3,'陈锦','12345678900','',8,'123456'),(4,'李四','11112222','',18,'123321'),(5,'哈哈','13443811425','',23,'111222'),(6,'王五','12345678901','',13,'123321'),(7,'陈可儿','12345543211','\0',5,'chenkeer'),(8,'伍清萍','12332112321','\0',30,'wuqingping'),(9,'张三','15819042671','',24,'qweasdzxc123'),(10,'小黄','11111122222','',22,'12345'),(11,'陈招全','12344567322','\0',24,'qqqqq');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
