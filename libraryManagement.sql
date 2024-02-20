CREATE TABLE `book` (
  `BookId` int NOT NULL,
  `Title` varchar(50) NOT NULL,
  `Author` varchar(50) NOT NULL,
  `yearPublished` int NOT NULL,
  PRIMARY KEY (`BookId`)
) ;
INSERT INTO `library`.`book`
(`BookId`,
`Title`,
`Author`,
`yearPublished`)
VALUES
(100,"life is beautiful","Prathibha",1999);

INSERT INTO `library`.`book`
(`BookId`,
`Title`,
`Author`,
`yearPublished`)
VALUES
(101,"The end","Pravalika",2001);
CREATE TABLE `member` (
  `MemberId` int NOT NULL,
  `FirstName` varchar(60) NOT NULL,
  `LastName` varchar(60) NOT NULL,
  `emailAddress` varchar(80) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  PRIMARY KEY (`MemberId`)
) ;
INSERT INTO `library`.`member`
(`MemberId`,
`FirstName`,
`LastName`,
`emailAddress`,
`phoneNumber`)
VALUES
(100,"Prathibha","Garipelly","prathibhasuni.g@gmail.com","2148567890");
INSERT INTO `library`.`member`
(`MemberId`,
`FirstName`,
`LastName`,
`emailAddress`,
`phoneNumber`)
VALUES
(102,"Lavanya","Kon","lavanya.kona2gmail.com","3456789087");



