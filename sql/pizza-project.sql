
-- -----------------------------------------------------
-- Table `mydb`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(10) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `mydb`.`pizza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizza` (
  `pizza_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL DEFAULT 0.0,
  PRIMARY KEY (`pizza_id`));


-- -----------------------------------------------------
-- Table `mydb`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL DEFAULT 1,
  `total` DECIMAL(10,2) NOT NULL DEFAULT 0.0,
  `state` TINYINT NOT NULL DEFAULT 0,
  `customer_customer_id` INT NOT NULL,
  `pizza_pizza_id` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_order_customer_idx` (`customer_customer_id` ASC) VISIBLE,
  INDEX `fk_order_pizza1_idx` (`pizza_pizza_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_customer`
    FOREIGN KEY (`customer_customer_id`)
    REFERENCES `customer` (`customer_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_pizza1`
    FOREIGN KEY (`pizza_pizza_id`)
    REFERENCES `pizza` (`pizza_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `mydb`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ticket` (
  `ticket_id` INT NOT NULL AUTO_INCREMENT,
  `serie` VARCHAR(10) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` TINYINT(1) NOT NULL DEFAULT 0,
  `order_order_id` INT NOT NULL,
  PRIMARY KEY (`ticket_id`, `order_order_id`),
  UNIQUE INDEX `serie_UNIQUE` (`serie` ASC) VISIBLE,
  INDEX `fk_ticket_order1_idx` (`order_order_id` ASC) VISIBLE,
  CONSTRAINT `fk_ticket_order1`
    FOREIGN KEY (`order_order_id`)
    REFERENCES `order` (`order_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `mydb`.`serie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `serie` (
  `serie_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) NOT NULL,
  `quantity` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`serie_id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

