-- Safely clear existing data for fresh insert
SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM pca_logs;
DELETE FROM gpu_logs;
DELETE FROM pcas;
DELETE FROM gpus;
DELETE FROM spots;
DELETE FROM power_types;
SET FOREIGN_KEY_CHECKS = 1;

-- Insert power types first
INSERT INTO power_types (power_type_id, name) VALUES (1, '220V');
INSERT INTO power_types (power_type_id, name) VALUES (2, '110V');
INSERT INTO power_types (power_type_id, name) VALUES (3, '48V');
INSERT INTO power_types (power_type_id, name) VALUES (4, '480V');
INSERT INTO power_types (power_type_id, name) VALUES (5, 'DC');

-- Insert spots with explicit IDs to ensure consistency
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (1, 'Spot A1', 1);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (2, 'Spot A2', 0);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (3, 'Spot B1', 1);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (4, 'Spot B2', 0);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (5, 'Spot C1', 1);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (6, 'Spot C2', 0);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (7, 'Spot D1', 1);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (8, 'Spot D2', 0);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (9, 'Spot E1', 1);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (10, 'Spot E2', 0);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (11, 'Spot F1', 1);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (12, 'Spot F2', 0);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (13, 'Spot G1', 1);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (14, 'Spot G2', 0);
INSERT INTO spots (spot_id, spot_name, has_chocks) VALUES (15, 'Storage', 0);

-- Insert GPUs with explicit IDs to ensure consistency with logs
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (1, 1, 'GPU-A10001', 1, 75, 60, TRUE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (2, 1, 'GPU-A10002', 1, 80, 65, TRUE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (3, 2, 'GPU-A10003', 2, 70, 55, TRUE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (4, 3, 'GPU-B20001', 1, 90, 75, TRUE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (5, 4, 'GPU-B20002', 3, 65, 50, FALSE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (6, 5, 'GPU-C30001', 2, 85, 70, TRUE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (7, 6, 'GPU-C30002', 1, 78, 63, FALSE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (8, 7, 'GPU-D40001', 3, 82, 67, TRUE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (9, 8, 'GPU-D40002', 2, 68, 53, TRUE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (10, 9, 'GPU-E50001', 1, 92, 77, TRUE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (11, 10, 'GPU-E50002', 4, 73, 58, FALSE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (12, 11, 'GPU-F60001', 2, 88, 73, TRUE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (13, 12, 'GPU-F60002', 3, 76, 61, TRUE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (14, 13, 'GPU-G70001', 1, 95, 80, TRUE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (15, 14, 'GPU-G70002', 5, 79, 64, FALSE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (16, 15, 'GPU-S10001', 2, 50, 40, FALSE);
INSERT INTO gpus (gpu_id, spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (17, 15, 'GPU-S10002', 1, 45, 35, FALSE);

-- Insert PCAs with explicit IDs
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (1, 'PCA-A10001', 1, 1, 80, TRUE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (2, 'PCA-A10002', 2, 2, 75, TRUE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (3, 'PCA-B20001', 3, 1, 85, TRUE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (4, 'PCA-B20002', 4, 3, 70, FALSE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (5, 'PCA-C30001', 5, 2, 82, TRUE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (6, 'PCA-C30002', 6, 1, 77, FALSE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (7, 'PCA-D40001', 7, 3, 79, TRUE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (8, 'PCA-D40002', 8, 2, 73, TRUE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (9, 'PCA-E50001', 9, 1, 88, TRUE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (10, 'PCA-E50002', 10, 4, 76, FALSE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (11, 'PCA-F60001', 11, 2, 83, TRUE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (12, 'PCA-F60002', 12, 3, 78, TRUE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (13, 'PCA-G70001', 13, 1, 90, TRUE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (14, 'PCA-G70002', 14, 5, 81, FALSE);
INSERT INTO pcas (pca_id, pca_serial_number, spot_id, power_type_id, resource_level, is_powered)
VALUES (15, 'PCA-S10001', 15, 2, 60, FALSE);

-- Now insert logs for GPUs
-- GPU-A10001 (ON)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 2 DAY), 'POWER_OFF', 1, 75, 60, 1, NULL, 'Maintenance shutdown');
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 1 DAY), 'POWER_ON', 1, 75, 60, 1, NULL, 'Maintenance complete');

-- GPU-A10002 (ON)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 3 DAY), 'POWER_ON', 2, 80, 65, 1, NULL, 'Initial power-up');

-- GPU-A10003 (ON)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 5 DAY), 'POWER_OFF', 3, 70, 55, 2, NULL, 'Weekend shutdown');
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 2 DAY), 'POWER_ON', 3, 70, 55, 2, NULL, 'Monday startup');

-- GPU-B20001 (ON)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 4 DAY), 'POWER_ON', 4, 90, 75, 3, NULL, 'High performance test');

-- GPU-B20002 (OFF)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 10 DAY), 'POWER_ON', 5, 65, 50, 4, NULL, 'Initial setup');
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 1 DAY), 'POWER_OFF', 5, 65, 50, 4, NULL, 'Temporary shutdown for area maintenance');

-- GPU-C30001 (ON)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 15 DAY), 'POWER_OFF', 6, 85, 70, 5, NULL, 'Monthly maintenance');
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 14 DAY), 'POWER_ON', 6, 85, 70, 5, NULL, 'Resuming operations');

-- GPU-C30002 (OFF)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 8 DAY), 'POWER_ON', 7, 78, 63, 6, NULL, 'Test run');
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 7 DAY), 'POWER_OFF', 7, 78, 63, 6, NULL, 'Test complete');

-- GPU-D40001 (ON)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 6 DAY), 'POWER_ON', 8, 82, 67, 7, NULL, 'Standard operation');

-- GPU-D40002 (ON)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 12 DAY), 'POWER_OFF', 9, 68, 53, 8, NULL, 'Firmware update');
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 11 DAY), 'POWER_ON', 9, 68, 53, 8, NULL, 'Update complete');

-- GPU-E50001 (ON)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 20 DAY), 'POWER_ON', 10, 92, 77, 9, NULL, 'Initial installation');

-- GPU-E50002 (OFF)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 18 DAY), 'POWER_ON', 11, 73, 58, 10, NULL, 'New equipment test');
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 5 DAY), 'POWER_OFF', 11, 73, 58, 10, NULL, 'Hardware issue detected');

-- Additional logs for remaining GPUs
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 45 DAY), 'EQUIPMENT_CHECK', 1, 70, 55, 1, NULL, 'Routine inspection');

INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 60 DAY), 'MOVEMENT', 3, 65, 50, 15, 2, 'Moved from storage to active spot');

-- Now insert logs for PCAs
-- PCA-A10001 (ON)
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 30 DAY), 'POWER_ON', 1, 80, 1, NULL, 'Initial deployment');

-- PCA-A10002 (ON)
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 25 DAY), 'POWER_OFF', 2, 75, 2, NULL, 'Scheduled maintenance');
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 24 DAY), 'POWER_ON', 2, 75, 2, NULL, 'Maintenance complete');

-- PCA-B20001 (ON)
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 15 DAY), 'POWER_ON', 3, 85, 3, NULL, 'High capacity test');

-- PCA-B20002 (OFF)
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 22 DAY), 'POWER_ON', 4, 70, 4, NULL, 'Standard operation');
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 3 DAY), 'POWER_OFF', 4, 70, 4, NULL, 'Facility power maintenance');

-- PCA-C30001 (ON)
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 18 DAY), 'POWER_ON', 5, 82, 5, NULL, 'Post-inspection startup');

-- PCA-C30002 (OFF)
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 10 DAY), 'POWER_ON', 6, 77, 6, NULL, 'Performance testing');
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 9 DAY), 'POWER_OFF', 6, 77, 6, NULL, 'Performance test complete');

-- PCA-D40001 (ON)
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 7 DAY), 'POWER_ON', 7, 79, 7, NULL, 'Regular operation');

-- PCA-D40002 (ON)
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 14 DAY), 'POWER_ON', 8, 73, 8, NULL, 'New installation');

-- PCA-E50001 (ON)
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 21 DAY), 'POWER_ON', 9, 88, 9, NULL, 'Initial setup');

-- PCA-E50002 (OFF)
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 28 DAY), 'POWER_ON', 10, 76, 10, NULL, 'Configuration testing');
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 2 DAY), 'POWER_OFF', 10, 76, 10, NULL, 'Scheduled downtime');

-- Additional PCA logs
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 35 DAY), 'EQUIPMENT_CHECK', 2, 70, 2, NULL, 'Quarterly inspection');

INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 50 DAY), 'MOVEMENT', 5, 75, 15, 5, 'Relocated from storage to Spot C1');

-- Add ALTER statements to change column names if needed
-- ALTER TABLE gpus CHANGE COLUMN is_powered_on is_powered BOOLEAN DEFAULT FALSE;
-- ALTER TABLE pcas CHANGE COLUMN is_powered_on is_powered BOOLEAN DEFAULT FALSE;