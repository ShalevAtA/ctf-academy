CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  email VARCHAR(255) UNIQUE NOT NULL,
  pass_hash VARCHAR(255) NOT NULL,
  role VARCHAR(32) NOT NULL DEFAULT 'student'
);

CREATE TABLE challenges (
  id BIGSERIAL PRIMARY KEY,
  slug VARCHAR(100) UNIQUE NOT NULL,
  title VARCHAR(200) NOT NULL,
  category VARCHAR(50) NOT NULL,
  difficulty VARCHAR(20) NOT NULL,
  description_md TEXT NOT NULL,
  flag_static VARCHAR(255) NOT NULL,
  published BOOLEAN NOT NULL DEFAULT TRUE,
  points_base INT NOT NULL DEFAULT 100
);

-- seed one simple challenge so we can see data later
INSERT INTO challenges (slug,title,category,difficulty,description_md,flag_static,published,points_base)
VALUES ('intro-bof','Intro Buffer Overflow','pwn','easy',
'# Intro BOF\nSubmit FLAG{hello} for MVP validation.',
'FLAG{hello}', true, 100);
