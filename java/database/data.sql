BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;

BEGIN TRANSACTION;

INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Priscilla', 'cat', 'female', '3 years', 'true', 'Priscilla is much too dignified to sit on laps.', '../public/img/cats/cat_1.png', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Tiger', 'cat', 'female', '8 months', 'true', 'Tiger likes to tug on shoelaces and heart strings.', '../public/img/cats/cat_2.jpg', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Bruce', 'cat', 'male', '4 months', 'false', 'Bruce loves his flower necklace and will fight you if you try to take it away.', '../public/img/cats/cat_3.jpg', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Simba', 'cat', 'male', '1 year', 'true', 'Simba prowls. Simba hunts. Simba trips you at the top of the stairs.', '..\public\img\cats\cat_4.webp', 'true');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Souxie', 'cat', 'female', '6 months', 'true', 'Souxie is so very sad that no one has chosen her yet. Can you help?', '..\public\img\cats\cat_5.jpg', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Leo', 'cat', 'male', '9 months', 'true', 'Alex enjoys hunting mice and neck scratchies.', '..\public\img\cats\cat_6.png', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Flower', 'cat', 'male', '1 year 5 months', 'true', 'Flower is incredibly sociable but had bad breath and is a bit gassy.', '..\public\img\cats\cat_7.webp', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Cliff', 'cat', 'male', '11 months', 'true', 'Cliff is always happy to see you and will meet you at the door every time you get home.', '..\public\img\cats\cat_8.webp', 'true');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Banbi', 'rabbit', 'male', '1 year 2 months', 'true', 'Bambi loves lap time and carrot time.', '..\public\img\Bunny\Bunny_1.png', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Spot', 'rabbit', 'female', '8 months', 'true', 'Spot is a little shy but warms up quickly.', '..\public\img\Bunny\Bunny_2.jpg', 'true');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Esther', 'rabbit', 'female', '4 months', 'false', 'Esther will consume everything around her.', '..\public\img\Bunny\Bunny_3.jpg', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Ted', 'rabbit', 'male', '2 years', 'true', 'Ted sits. Most rabbits hop, but Ted just sits.', '..\public\img\Bunny\Bunny_4.jpg', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Max', 'rabbit', 'male', '11 months', 'true', 'Max is just one rabbit. There is only one rabbit here. Do not overthink it.', '..\public\img\Bunny\Bunny_5.png', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('June', 'rabbit', 'female', '1 year 6  months', 'false', 'June is pregnant and will bless you with bonus bunnies.', '..\public\img\Bunny\Bunny_6.png', 'true');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Trae', 'rabbit', 'male', '11 months', 'true', 'Trae will find all of your lost wristbands.', '..\public\img\Bunny\Bunny_7.png', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Butterscotch', 'rabbit', 'male', '2 years 1 month', 'true', 'Butterscotch is semi-sweet and will stick around you for a long time.', '..\public\img\Bunny\Bunny_8.png', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Peach', 'rabbit', 'female', '7 months', 'true', 'Peach is quicker than she looks but still makes a great snuggle companion.', '..\public\img\Bunny\Bunny_9.png', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Spike', 'dog', 'male', '8 months', 'true', 'Spike will guard you home with ruthless ferocity.', '..\public\img\dogs\dog_1.jpg', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Jimmy', 'dog', 'male', '6 months', 'true', 'Jimmy will just sit there, watching every single move you make.', '..\public\img\dogs\dog_2.webp', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Sarah', 'dog', 'female', '2 years 3 months', 'true', 'Sarah is a huge drama queen that will let you know every little inconvenience that occurs.', '..\public\img\dogs\dog_3.jpg', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Sam', 'dog', 'male', '11 months', 'true', 'Sam will just wait there until you finally realize how much you need him.', '..\public\img\dogs\dog_4.jpg', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Sue', 'dog', 'female', '1 year', 'true', 'Sue worries about her wrinkles, please reassure her.', '..\public\img\dogs\dog_5.webp', 'true');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Lightning', 'dog', 'male', '11 months', 'true', 'Do not fall into false complacency, Lightning can run with the best of them.', '..\public\img\dogs\dog_6.webp', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Caraline', 'dog', 'female', '4 months', 'false', 'Caroline is a rocket ship in puppy form.', '..\public\img\dogs\dog_7.webp', 'false');
INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES ('Freddie', 'dog', 'male', '7 months', 'true', 'Freddie would much rather have the name Gizmo, but we liked Freddie.', '..\public\img\dogs\dog_8.jpg', 'false');

COMMIT TRANSACTION;

BEGIN TRANSACTION;
INSERT INTO volunteersignup (name, age, phone_number, address, email, is_active) 
VALUES ('Dan', 29, '4405396774', '1234 Madeup Way', 'notmyemail@gmail.com', 'true');

COMMIT TRANSACTION;