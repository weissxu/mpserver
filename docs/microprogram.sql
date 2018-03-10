CREATE TABLE `sign_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creator` varchar(16) NOT NULL,
  `modifier` varchar(16) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `open_Id` varchar(32) not null,
  `activity_name` varchar(32)  DEFAULT '',
  `remark` varchar(32)  DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

CREATE TABLE `sign_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creator` varchar(16) NOT NULL,
  `modifier` varchar(16) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  
  `open_Id` varchar(32) not null,
  `activity_id` int(11) NOT NULL,
  `activity_name` varchar(32)  DEFAULT '',
  `remark` varchar(32)  DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;