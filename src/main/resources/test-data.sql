-- Insert power types
INSERT INTO power_types (name) VALUES ('220V');
INSERT INTO power_types (name) VALUES ('110V');
INSERT INTO power_types (name) VALUES ('48V');

-- Insert spots
INSERT INTO spots (spot_name, has_chocks) VALUES ('Spot A', 1);
INSERT INTO spots (spot_name, has_chocks) VALUES ('Spot B', 0);
INSERT INTO spots (spot_name, has_chocks) VALUES ('Spot C', 1);
INSERT INTO spots (spot_name, has_chocks) VALUES ('Spot D', 0);
INSERT INTO spots (spot_name, has_chocks) VALUES ('Spot E', 1);

-- Insert GPUs
INSERT INTO gpus (spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level)
VALUES (1, 'GPU001', 1, 3, 2);
INSERT INTO gpus (spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level)
VALUES (1, 'GPU002', 1, 4, 3);
INSERT INTO gpus (spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level)
VALUES (2, 'GPU003', 2, 2, 1);
INSERT INTO gpus (spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level)
VALUES (3, 'GPU004', 1, 5, 4);
INSERT INTO gpus (spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level)
VALUES (4, 'GPU005', 3, 3, 2);
INSERT INTO gpus (spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level)
VALUES (5, 'GPU006', 2, 4, 3);

-- Insert PCAs
INSERT INTO pcas (pca_serial_number, spot_id, power_type_id, resource_level)
VALUES ('PCA001', 1, 1, 3);
INSERT INTO pcas (pca_serial_number, spot_id, power_type_id, resource_level)
VALUES ('PCA002', 2, 2, 2);
INSERT INTO pcas (pca_serial_number, spot_id, power_type_id, resource_level)
VALUES ('PCA003', 3, 1, 4);
INSERT INTO pcas (pca_serial_number, spot_id, power_type_id, resource_level)
VALUES ('PCA004', 4, 3, 3);
INSERT INTO pcas (pca_serial_number, spot_id, power_type_id, resource_level)
VALUES ('PCA005', 5, 2, 4);

-- Insert GPU logs with different timestamps to test elapsed time functionality
-- Spot A - most recent (10 minutes ago)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 10 MINUTE), 'EQUIPMENT_CHECK', 1, 3, 2, 1, NULL, 'Recent check');

-- Spot B - 2 days ago
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 2 DAY), 'EQUIPMENT_CHECK', 3, 2, 1, 2, NULL, 'Regular maintenance');

-- Spot C - 1 week ago
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 7 DAY), 'POWER_ON', 4, 5, 4, 3, NULL, 'Weekly power cycle');

-- Spot D - 3 weeks ago
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 21 DAY), 'MOVEMENT', 5, 3, 2, 4, NULL, 'Repositioned for better cooling');

-- Spot E - 2 months ago (should be first in the elapsed time order)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 60 DAY), 'EQUIPMENT_CHECK', 6, 4, 3, 5, NULL, 'Initial setup');

-- Additional logs for Spot A to demonstrate multiple entries
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 2 DAY), 'POWER_OFF', 1, 3, 2, 1, NULL, 'Temporary shutdown');
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 2 DAY), 'POWER_ON', 1, 3, 2, 1, NULL, 'Restart after shutdown');
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 3 DAY), 'MOVEMENT', 2, 4, 3, 1, 1, 'Adjusted position');

-- PCA logs
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 15 MINUTE), 'EQUIPMENT_CHECK', 1, 3, 1, NULL, 'Regular check');
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 3 DAY), 'EQUIPMENT_CHECK', 2, 2, 2, NULL, 'Preventive maintenance');
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 10 DAY), 'POWER_ON', 3, 4, 3, NULL, 'After power outage');
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 25 DAY), 'MOVEMENT', 4, 3, 4, NULL, 'Relocated to improve airflow');
INSERT INTO pca_logs (timestamp, log_type, pca_id, resource_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 45 DAY), 'EQUIPMENT_CHECK', 5, 4, 5, NULL, 'Initial setup check');