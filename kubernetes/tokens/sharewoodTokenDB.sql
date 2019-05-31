DROP DATABASE IF EXISTS sharewood_tokens;

CREATE DATABASE sharewood_tokens DEFAULT CHARACTER SET 'utf8'
  DEFAULT COLLATE 'utf8_unicode_ci';

USE sharewood_tokens;

-- database for token persistence only

create table oauth_client_details (
  client_id VARCHAR(30) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(1024),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
) ENGINE = InnoDB;

create table oauth_client_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(30),
  user_name VARCHAR(256),
  client_id VARCHAR(256)
) ENGINE = InnoDB;

create table oauth_access_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication BLOB,
  refresh_token VARCHAR(256)
) engine = InnoDB;

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication BLOB
) ENGINE = InnoDB;

create table oauth_code (
  code VARCHAR(256), authentication BLOB
) ENGINE = InnoDB;

create table oauth_approvals (
  userId VARCHAR(256),
  clientId VARCHAR(256),
  scope VARCHAR(256),
  status VARCHAR(10),
  expiresAt TIMESTAMP NULL,
  lastModifiedAt TIMESTAMP NULL
) ENGINE = InnoDB;


-- Store a single client with authorization code grant 

-- y471l12D2y55U5558rd2 {bcrypt}$2a$10$xMgMQRCnrZ.vf/8WxyIwrOTiFKGJF72FYGxUjnSIWQMpFxFTtoU.2


INSERT INTO oauth_client_details (
  client_id, 
  resource_ids, 
  client_secret, 
  scope, 
  authorized_grant_types, 
  web_server_redirect_uri,
  authorities,
  access_token_validity,
  refresh_token_validity,
  additional_information,
  autoapprove)
VALUES('Fleetwood', 'SHAREWOOD', '{bcrypt}$2a$10$xMgMQRCnrZ.vf/8WxyIwrOTiFKGJF72FYGxUjnSIWQMpFxFTtoU.2', 'READ,WRITE,DELETE', 'authorization_code', 'http://localhost:8090/fleetwood/sharewood/photosMy,http://localhost:8090/fleetwood/sharewood/sharedPhotos,http://localhost:8090/fleetwood/sharewood/updatePhoto,http://localhost:8090/fleetwood/sharewood/deletePhoto,http://localhost:8090/fleetwood/sharewood/createPhotoMulti,http://localhost:8090/fleetwood/sharewood/getToken', 'ROLE_CLIENT', '520', null, '{}', null);


