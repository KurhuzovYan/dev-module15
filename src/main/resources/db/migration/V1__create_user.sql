CREATE TABLE "user"
(
    id       BIGINT AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL PRIMARY KEY,
    password VARCHAR(255),
    enabled  VARCHAR(255),
    role     VARCHAR(255)
);

INSERT INTO "user"
    VALUES (1, 'user', '$2a$10$7ifqYeNbFwdcHbgNbRT53urD3rlvKCvR1mafNIm.mKwgnO/AJxzZG', 'true', 'USER')