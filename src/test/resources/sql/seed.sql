INSERT INTO `teams` (`id`, `name`, `description`) VALUES (1, 'riders', 'we are riders');
INSERT INTO `teams` (`id`, `name`, `description`) VALUES (2, 'giants', 'we are giants');
INSERT INTO `teams` (`id`, `name`, `description`) VALUES (3, 'gliders', 'we are gliders');

INSERT INTO `persons` (`id`, `name`, `email`) VALUES (1, 'John Doe', 'john.doe@example.org');
INSERT INTO `persons` (`id`, `name`, `email`) VALUES (2, 'Mary Doe', 'mary.doe@example.org');
INSERT INTO `persons` (`id`, `name`, `email`) VALUES (3, 'William Doe', 'william.doe@example.org');
INSERT INTO `persons` (`id`, `name`, `email`) VALUES (4, 'Tracey Doe', 'tracey.doe@example.org');
INSERT INTO `persons` (`id`, `name`, `email`) VALUES (5, 'Dick Doe', 'dick.doe@example.org');

INSERT INTO `memberships` (`name`, `team_id`, `person_id`) VALUES ('ADMIN', 1, 1);
INSERT INTO `memberships` (`name`, `team_id`, `person_id`) VALUES ('MEMBER', 1, 2);
INSERT INTO `memberships` (`name`, `team_id`, `person_id`) VALUES ('MANAGER', 1, 3);
INSERT INTO `memberships` (`name`, `team_id`, `person_id`) VALUES ('ADMIN', 2, 4);
INSERT INTO `memberships` (`name`, `team_id`, `person_id`) VALUES ('MEMBER', 2, 5);
INSERT INTO `memberships` (`name`, `team_id`, `person_id`) VALUES ('ADMIN', 3, 4);
INSERT INTO `memberships` (`name`, `team_id`, `person_id`) VALUES ('MEMBER', 3, 5);


