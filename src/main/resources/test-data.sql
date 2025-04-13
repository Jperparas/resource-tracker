-- Insert test data for spots
INSERT INTO spots (spot_name, has_aircraft)
VALUES ('Spot 1', 1),
       ('Spot 2', 0),
       ('Spot 3', 1),
       ('Spot 4', 0),
       ('Spot 5', 1),
       ('Spot 6', 0),
       ('Spot 7', 1),
       ('Spot 8', 0),
       ('Spot 9', 1),
       ('Spot 10', 0);

-- Insert test data for power types
INSERT INTO power_types (name)
VALUES ('Diesel'),
       ('Electric');

-- Insert test data for GPUs - Note: Electric GPUs (power_type_id=2) have NULL def_blue_level
INSERT INTO gpus (spot_id, gpu_serial_number, power_type_id, resource_level, def_blue_level, is_powered)
VALUES (1, 'GPU-001', 1, 80, 60, 1),   -- Diesel with DEF blue
       (1, 'GPU-002', 2, 75, NULL, 0), -- Electric without DEF blue
       (2, 'GPU-003', 1, 90, 70, 1),   -- Diesel with DEF blue
       (3, 'GPU-004', 2, 65, NULL, 0), -- Electric without DEF blue
       (4, 'GPU-005', 1, 85, 65, 1),   -- Diesel with DEF blue
       (5, 'GPU-006', 1, 70, 50, 0),   -- Diesel with DEF blue
       (6, 'GPU-007', 2, 95, NULL, 1), -- Electric without DEF blue
       (7, 'GPU-008', 2, 60, NULL, 0), -- Electric without DEF blue
       (8, 'GPU-009', 1, 85, 65, 1),   -- Diesel with DEF blue
       (9, 'GPU-010', 1, 75, 55, 0);
-- Diesel with DEF blue

-- Insert test data for GPU logs (equipment checks)
-- For electric GPUs, def_blue_level is NULL
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 30 DAY), 'EQUIPMENT_CHECK', 1, 80, 60, 1, NULL, 'Routine check - Diesel GPU'),
       (DATE_SUB(NOW(), INTERVAL 25 DAY), 'EQUIPMENT_CHECK', 2, 75, NULL, 1, NULL, 'Routine check - Electric GPU'),
       (DATE_SUB(NOW(), INTERVAL 20 DAY), 'EQUIPMENT_CHECK', 3, 90, 70, 2, NULL, 'Routine check - Diesel GPU'),
       (DATE_SUB(NOW(), INTERVAL 15 DAY), 'EQUIPMENT_CHECK', 4, 65, NULL, 3, NULL, 'Low resource level - Electric GPU'),
       (DATE_SUB(NOW(), INTERVAL 10 DAY), 'EQUIPMENT_CHECK', 5, 85, 65, 4, NULL, 'Routine check - Diesel GPU');

-- Insert test data for GPU logs (movements)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 28 DAY), 'MOVEMENT', 1, 80, 60, 1, 3, 'Relocated diesel GPU'),
       (DATE_SUB(NOW(), INTERVAL 27 DAY), 'MOVEMENT', 2, 75, NULL, 1, 4, 'Relocated electric GPU'),
       (DATE_SUB(NOW(), INTERVAL 22 DAY), 'MOVEMENT', 3, 90, 70, 2, 5, 'Relocated diesel GPU'),
       (DATE_SUB(NOW(), INTERVAL 18 DAY), 'MOVEMENT', 4, 65, NULL, 3, 6, 'Relocated electric GPU'),
       (DATE_SUB(NOW(), INTERVAL 12 DAY), 'MOVEMENT', 5, 85, 65, 4, 7, 'Relocated diesel GPU');

-- Insert test data for GPU logs (power status changes)
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 29 DAY), 'POWER_ON', 1, 80, 60, 1, NULL, 'Started diesel GPU'),
       (DATE_SUB(NOW(), INTERVAL 29 DAY), 'POWER_OFF', 2, 75, NULL, 1, NULL, 'Stopped electric GPU'),
       (DATE_SUB(NOW(), INTERVAL 24 DAY), 'POWER_ON', 3, 90, 70, 2, NULL, 'Started diesel GPU'),
       (DATE_SUB(NOW(), INTERVAL 23 DAY), 'POWER_OFF', 4, 65, NULL, 3, NULL, 'Stopped electric GPU'),
       (DATE_SUB(NOW(), INTERVAL 14 DAY), 'POWER_ON', 7, 95, NULL, 6, NULL, 'Started electric GPU');

-- Insert more recent logs for testing
INSERT INTO gpu_logs (timestamp, log_type, gpu_id, resource_level, def_blue_level, old_spot_id, new_spot_id, notes)
VALUES (DATE_SUB(NOW(), INTERVAL 5 DAY), 'EQUIPMENT_CHECK', 6, 70, 50, 5, NULL, 'DEF blue level check - Diesel GPU'),
       (DATE_SUB(NOW(), INTERVAL 4 DAY), 'MOVEMENT', 7, 95, NULL, 6, 8, 'Relocated electric GPU'),
       (DATE_SUB(NOW(), INTERVAL 3 DAY), 'POWER_ON', 8, 60, NULL, 7, NULL, 'Started electric GPU'),
       (DATE_SUB(NOW(), INTERVAL 2 DAY), 'EQUIPMENT_CHECK', 9, 85, 65, 8, NULL, 'Fuel check - Diesel GPU'),
       (DATE_SUB(NOW(), INTERVAL 1 DAY), 'POWER_OFF', 10, 75, 55, 9, NULL, 'Stopped diesel GPU');