-- -----------------------------------------------------
-- Table spots
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS spots
(
    spot_id      INT         NOT NULL AUTO_INCREMENT,
    spot_name    VARCHAR(45) NOT NULL,
    has_aircraft TINYINT(1)  NOT NULL,
    PRIMARY KEY (spot_id),
    UNIQUE INDEX spot_name_UNIQUE (spot_name ASC) VISIBLE
);

-- -----------------------------------------------------
-- Table power_types
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS power_types
(
    power_type_id TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
    name          VARCHAR(45)      NOT NULL,
    UNIQUE INDEX name_UNIQUE (name ASC) VISIBLE,
    PRIMARY KEY (power_type_id)
);

-- -----------------------------------------------------
-- Table gpus
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS gpus
(
    gpu_id            INT              NOT NULL AUTO_INCREMENT,
    spot_id           INT              NOT NULL,
    gpu_serial_number VARCHAR(45)      NOT NULL,
    power_type_id     TINYINT UNSIGNED NOT NULL,
    resource_level    TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY (gpu_id),
    UNIQUE INDEX gpu_serial_number_UNIQUE (gpu_serial_number ASC) VISIBLE,
    INDEX fk_gpus_power_types_idx (power_type_id ASC) VISIBLE,
    INDEX fk_gpus_spots_idx (spot_id ASC) VISIBLE,
    CONSTRAINT fk_gpus_power_types
        FOREIGN KEY (power_type_id)
            REFERENCES power_types (power_type_id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT fk_gpus_spots
        FOREIGN KEY (spot_id)
            REFERENCES spots (spot_id)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
);


