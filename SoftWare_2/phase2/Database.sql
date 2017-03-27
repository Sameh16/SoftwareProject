-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2017 at 11:41 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `software`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `Id` int(11) NOT NULL,
  `QuestionId` int(11) NOT NULL,
  `Answer` varchar(100) NOT NULL,
  `CorrectAnswer` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `CATID` int(11) NOT NULL,
  `CATNAME` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Age` int(11) NOT NULL,
  `CatId` int(11) NOT NULL,
  `TeacherId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `GAMEID` int(11) NOT NULL,
  `TYPEID` int(11) DEFAULT NULL,
  `GAMENAME` varchar(250) DEFAULT NULL,
  `CourseId` int(11) NOT NULL,
  `NumberOfLevel` int(11) NOT NULL,
  `Description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `Id` int(11) NOT NULL,
  `Question` varchar(100) NOT NULL,
  `GameId` int(11) NOT NULL,
  `Level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Id` int(11) NOT NULL,
  `NAME` varchar(250) NOT NULL,
  `USERNAME` varchar(250) NOT NULL,
  `AGE` int(11) NOT NULL,
  `GENDER` char(1) DEFAULT NULL,
  `EMAIL` varchar(250) NOT NULL,
  `PASSWORD` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `studentcourse`
--

CREATE TABLE `studentcourse` (
  `StudentId` int(11) NOT NULL,
  `CourseId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `studentgame`
--

CREATE TABLE `studentgame` (
  `GAMEID` int(11) NOT NULL,
  `StudentId` int(11) NOT NULL,
  `ACHIEVEMENT` int(11) DEFAULT NULL,
  `COMENT` varchar(250) DEFAULT NULL,
  `RATE` int(11) DEFAULT NULL,
  `LEVEL` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `Id` int(11) NOT NULL,
  `NAME` varchar(250) NOT NULL,
  `USERNAME` varchar(250) NOT NULL,
  `AGE` int(11) NOT NULL,
  `GENDER` char(1) DEFAULT NULL,
  `EMAIL` varchar(250) NOT NULL,
  `PASSWORD` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `teachergame`
--

CREATE TABLE `teachergame` (
  `GAMEID` int(11) NOT NULL,
  `TeacherId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `TYPEID` int(11) NOT NULL,
  `TYPENAME` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `QuestionId` (`QuestionId`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CATID`),
  ADD UNIQUE KEY `CATEGORY_PK` (`CATID`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `CourseName` (`Name`),
  ADD KEY `CatId` (`CatId`),
  ADD KEY `Username` (`TeacherId`),
  ADD KEY `Username_2` (`TeacherId`),
  ADD KEY `Username_3` (`TeacherId`),
  ADD KEY `TeacherId` (`TeacherId`);

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`GAMEID`),
  ADD UNIQUE KEY `GAME_PK` (`GAMEID`),
  ADD KEY `RELATIONSHIP_12_FK` (`TYPEID`),
  ADD KEY `CourseId` (`CourseId`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `GameId` (`GameId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `STUDENT_PK` (`USERNAME`),
  ADD UNIQUE KEY `Id` (`Id`);

--
-- Indexes for table `studentcourse`
--
ALTER TABLE `studentcourse`
  ADD PRIMARY KEY (`StudentId`,`CourseId`),
  ADD KEY `Username` (`StudentId`),
  ADD KEY `CourseId` (`CourseId`);

--
-- Indexes for table `studentgame`
--
ALTER TABLE `studentgame`
  ADD PRIMARY KEY (`GAMEID`,`StudentId`),
  ADD UNIQUE KEY `STUDENTGAME_PK` (`GAMEID`,`StudentId`),
  ADD KEY `RELATIONSHIP_4_FK` (`GAMEID`),
  ADD KEY `RELATIONSHIP_5_FK` (`StudentId`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `TEACHER_PK` (`USERNAME`),
  ADD UNIQUE KEY `Id` (`Id`);

--
-- Indexes for table `teachergame`
--
ALTER TABLE `teachergame`
  ADD PRIMARY KEY (`GAMEID`,`TeacherId`),
  ADD UNIQUE KEY `TEACHERGAME_PK` (`GAMEID`,`TeacherId`),
  ADD KEY `RELATIONSHIP_7_FK` (`GAMEID`),
  ADD KEY `RELATIONSHIP_8_FK` (`TeacherId`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`TYPEID`),
  ADD UNIQUE KEY `TYPE_PK` (`TYPEID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `CATID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `game`
--
ALTER TABLE `game`
  MODIFY `GAMEID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `studentgame`
--
ALTER TABLE `studentgame`
  MODIFY `GAMEID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `teachergame`
--
ALTER TABLE `teachergame`
  MODIFY `GAMEID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `TYPEID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `category_ibfk_1` FOREIGN KEY (`CATID`) REFERENCES `course` (`CatId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`Id`) REFERENCES `game` (`CourseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `course_ibfk_2` FOREIGN KEY (`TeacherId`) REFERENCES `teacher` (`Id`);

--
-- Constraints for table `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `FK_GAME_RELATIONS_TYPE` FOREIGN KEY (`TYPEID`) REFERENCES `type` (`TYPEID`),
  ADD CONSTRAINT `game_ibfk_1` FOREIGN KEY (`CourseId`) REFERENCES `course` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`GameId`) REFERENCES `game` (`GAMEID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `question_ibfk_2` FOREIGN KEY (`Id`) REFERENCES `answer` (`QuestionId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `studentcourse`
--
ALTER TABLE `studentcourse`
  ADD CONSTRAINT `studentcourse_ibfk_1` FOREIGN KEY (`StudentId`) REFERENCES `student` (`Id`),
  ADD CONSTRAINT `studentcourse_ibfk_2` FOREIGN KEY (`CourseId`) REFERENCES `course` (`Id`);

--
-- Constraints for table `studentgame`
--
ALTER TABLE `studentgame`
  ADD CONSTRAINT `FK_STUDENTG_RELATIONS_GAME` FOREIGN KEY (`GAMEID`) REFERENCES `game` (`GAMEID`),
  ADD CONSTRAINT `studentgame_ibfk_1` FOREIGN KEY (`StudentId`) REFERENCES `student` (`Id`);

--
-- Constraints for table `teachergame`
--
ALTER TABLE `teachergame`
  ADD CONSTRAINT `FK_TEACHERG_RELATIONS_GAME` FOREIGN KEY (`GAMEID`) REFERENCES `game` (`GAMEID`),
  ADD CONSTRAINT `teachergame_ibfk_1` FOREIGN KEY (`TeacherId`) REFERENCES `teacher` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
