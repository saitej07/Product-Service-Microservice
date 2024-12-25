CREATE TABLE `t_products` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    `description` varchar(255),
    `price` decimal(19,2),
    PRIMARY KEY (`id`)
);
