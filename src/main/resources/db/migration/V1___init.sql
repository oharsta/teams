CREATE TABLE teams (
  id          MEDIUMINT    NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(255) NOT NULL,
  description TEXT,
  created     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

ALTER TABLE teams
  ADD UNIQUE INDEX teams_name_unique (name);

CREATE TABLE memberships (
  role        VARCHAR(255) NOT NULL,
  team_id   MEDIUMINT    NOT NULL,
  person_id MEDIUMINT    NOT NULL,
  created   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (team_id, person_id)
)
  ENGINE = InnoDB;

CREATE TABLE persons (
  id      MEDIUMINT    NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name    VARCHAR(255) NOT NULL,
  email   VARCHAR(255) NOT NULL,
  created TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

ALTER TABLE persons
  ADD UNIQUE INDEX persons_email_unique (email);
