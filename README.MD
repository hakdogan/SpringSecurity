# Spring Security
--

The subject of this tutorial, Spring Framework's security module.

<br>

**Exemplified topics: **

* Authentication
* Authorization
* Intercept-url
* RememberMe functionality

<br>

**SQL Schema**
--

<pre>

CREATE DATABASE `springsecurity` 
USE `springsecurity`;

CREATE TABLE `user_roles` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `role` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `yetki_Kullanici` (`user`),
  CONSTRAINT `yetki_Kullanici` FOREIGN KEY (`user`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

CREATE TABLE `persistent_logins` (
  `username` varchar(64) COLLATE utf8_turkish_ci NOT NULL,
  `series` varchar(64) COLLATE utf8_turkish_ci NOT NULL,
  `token` varchar(64) COLLATE utf8_turkish_ci NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

CREATE TABLE `users` (
  `username` char(20) COLLATE utf8_turkish_ci NOT NULL,
  `password` char(50) COLLATE utf8_turkish_ci NOT NULL,
  `enabled` tinyint(1) unsigned NOT NULL,
  `fullname` char(50) COLLATE utf8_turkish_ci NOT NULL,
  `lastname` char(50) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

</pre>

<br>
**A screenshot of the application**
--

<img src="http://i62.tinypic.com/r060bn.png"/>