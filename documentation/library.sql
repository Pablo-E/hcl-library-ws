-- library.address definition

CREATE TABLE `address` (
  `id_address` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(100) NOT NULL,
  `number` int(11) NOT NULL,
  `city` varchar(100) NOT NULL,
  PRIMARY KEY (`id_address`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;


-- library.author definition

CREATE TABLE `author` (
  `id_author` int(11) NOT NULL AUTO_INCREMENT,
  `name_author` varchar(100) CHARACTER SET latin1 NOT NULL,
  `last_name_author` varchar(100) CHARACTER SET latin1 NOT NULL,
  `nationality` varchar(15) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id_author`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


-- library.book definition

CREATE TABLE `book` (
  `isbn` varchar(20) NOT NULL,
  `title` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `publisher` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `genre` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `author` int(11) DEFAULT NULL,
  `stock` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  KEY `book_FK` (`author`),
  CONSTRAINT `book_FK` FOREIGN KEY (`author`) REFERENCES `author` (`id_author`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- library.`user` definition

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) CHARACTER SET latin1 NOT NULL,
  `last_name` varchar(15) CHARACTER SET latin1 NOT NULL,
  `gender` char(1) CHARACTER SET latin1 DEFAULT NULL,
  `email` varchar(35) CHARACTER SET latin1 DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `role` varchar(8) CHARACTER SET latin1 NOT NULL,
  `status` tinyint(1) NOT NULL,
  `address` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `user_FK` (`address`),
  CONSTRAINT `user_FK` FOREIGN KEY (`address`) REFERENCES `address` (`id_address`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


-- library.loan definition

CREATE TABLE `loan` (
  `id_loan` int(11) NOT NULL AUTO_INCREMENT,
  `staff` int(11) NOT NULL,
  `client` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `book` varchar(20) NOT NULL,
  PRIMARY KEY (`id_loan`),
  KEY `loan_FK` (`staff`),
  KEY `loan_FK_1` (`client`),
  KEY `loan_FK_2` (`book`),
  CONSTRAINT `loan_FK` FOREIGN KEY (`staff`) REFERENCES `user` (`id_user`),
  CONSTRAINT `loan_FK_1` FOREIGN KEY (`client`) REFERENCES `user` (`id_user`),
  CONSTRAINT `loan_FK_2` FOREIGN KEY (`book`) REFERENCES `book` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;