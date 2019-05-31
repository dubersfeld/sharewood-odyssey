DROP DATABASE IF EXISTS sharewood_users;

CREATE DATABASE sharewood_users DEFAULT CHARACTER SET 'utf8'
  DEFAULT COLLATE 'utf8_unicode_ci';

USE sharewood_users;

-- database for users only

CREATE TABLE user (
  userId BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(30) NOT NULL,
  hashedPassword BINARY(68) NOT NULL,
  accountNonExpired BOOLEAN NOT NULL,
  accountNonLocked BOOLEAN NOT NULL,
  credentialsNonExpired BOOLEAN NOT NULL,
  enabled BOOLEAN NOT NULL,
  CONSTRAINT user_unique UNIQUE (username)
) ENGINE = InnoDB;

CREATE TABLE user_Authority (
  userId BIGINT UNSIGNED NOT NULL,
  authority VARCHAR(100) NOT NULL,
  UNIQUE KEY user_Authority_User_Authority (userId, authority),
  CONSTRAINT user_Authority_UserId FOREIGN KEY (userId)
    REFERENCES user (userId) ON DELETE CASCADE
) ENGINE = InnoDB;

-- s1a2t3o4r {bcrypt}$2a$10$YPcqdqZYIb1yxa7VTUqx9eG7PD2n46h1eqEm3gbIp5ZwWuFeL/pTa
-- o8p7e6r5a {bcrypt}$2a$10$JFhUs6DGSEHPFLpwuez/kugL7pxAr2Sv4FLynTL2QtWSeytbbX7Iu
-- a5r6e7p8o {bcrypt}$2a$10$F9xInpiEg8WqXxwrVESgoe6OpxGi80EqVf79Hu.AfbEnt74DNQ.aq

-- s1a2t3o4r {bcrypt}$2a$10$vrR0dpGxjwS78JXFlE/FEO2BGnYpw7DD8dukdFFTlAAfM1XpZypOS

-- s1a2t3o4r $2a$10$w2NVMPLhmHPSSBd/KS.X1usyoIL3jTa3N09INacdVg18InJe..hjK


INSERT INTO user (username, hashedPassword, accountNonExpired,
                           accountNonLocked, credentialsNonExpired, enabled)
VALUES ( -- s1a2t3o4r
  'Carol', '{bcrypt}$2a$10$YPcqdqZYIb1yxa7VTUqx9eG7PD2n46h1eqEm3gbIp5ZwWuFeL/pTa',
  TRUE, TRUE, TRUE, TRUE
);

INSERT INTO user (username, hashedPassword, accountNonExpired,
                           accountNonLocked, credentialsNonExpired, enabled)
VALUES ( -- a5r6e7p8o
  'Albert', '{bcrypt}$2a$10$F9xInpiEg8WqXxwrVESgoe6OpxGi80EqVf79Hu.AfbEnt74DNQ.aq',
  TRUE, TRUE, TRUE, TRUE
);

INSERT INTO user (username, hashedPassword, accountNonExpired,
                           accountNonLocked, credentialsNonExpired, enabled)
VALUES ( -- o8p7e6r5a
  'Alice', '{bcrypt}$2a$10$JFhUs6DGSEHPFLpwuez/kugL7pxAr2Sv4FLynTL2QtWSeytbbX7Iu',
  TRUE, TRUE, TRUE, TRUE
);



INSERT INTO user_Authority (UserId, Authority)
  VALUES (1, 'USER');

INSERT INTO user_Authority (UserId, Authority)
  VALUES (2, 'USER');

INSERT INTO user_Authority (UserId, Authority)
  VALUES (3, 'USER');

