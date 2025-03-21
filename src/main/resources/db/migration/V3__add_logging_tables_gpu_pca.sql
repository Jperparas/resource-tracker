CREATE TABLE gpu_logs
(
    gpu_change_log_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    timestamp         DATETIME,
    change_type       ENUM ('EQUIPMENT_CHECK','MOVEMENT'),
    gpu_id            INT              NOT NULL,
    resource_level    TINYINT UNSIGNED NOT NULL,
    def_blue_level    TINYINT UNSIGNED NULL,
    old_spot_id       INT              NOT NULL,
    new_spot_id       INT              NULL,
    notes             TEXT             NULL,
    FOREIGN KEY (gpu_id) REFERENCES gpus (gpu_id),
    FOREIGN KEY (old_spot_id) REFERENCES spots (spot_id),
    FOREIGN KEY (new_spot_id) REFERENCES spots (spot_id),
    INDEX idx_gpu_logs_timestamp (timestamp)
);
CREATE TABLE pca_logs
(
    pca_change_log_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    timestamp         DATETIME,
    change_type       ENUM ('EQUIPMENT_CHECK','MOVEMENT'),
    pca_id            INT              NOT NULL,
    resource_level    TINYINT UNSIGNED NOT NULL,
    old_spot_id       INT              NOT NULL,
    new_spot_id       INT              NULL,
    notes             TEXT             NULL,
    FOREIGN KEY (pca_id) REFERENCES pcas (pca_id),
    FOREIGN KEY (old_spot_id) REFERENCES spots (spot_id),
    FOREIGN KEY (new_spot_id) REFERENCES spots (spot_id),
    INDEX idx_pca_logs_timestamp (timestamp)

);
