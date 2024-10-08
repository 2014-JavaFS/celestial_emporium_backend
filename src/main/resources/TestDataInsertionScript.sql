INSERT INTO items(name, description, image) VALUES
	('Necklace of Adaptation', '(Requires Attunement) While wearing this necklace, you can breathe normally in any environment, and you have advantage on saving throws made against harmful gases and vapors (such as cloudkill and stinking cloud effects...', 'https://revaturecelestialemporium.s3.us-east-2.amazonaws.com/necklaceofadapt.jpg'),
	('Wand of Magic Missiles', 'This wand has 7 charges. While holding it, you can use an action to expend 1 or more of its charges to cast the magic missile spell from it. For 1 charge, you cast the 1st-level version of the spell. You can increase the spell slot...', 'https://revaturecelestialemporium.s3.us-east-2.amazonaws.com/wands/magicmissilewand.jpg'),
	('Heward''s Handy Spice Pouch', 'This belt pouch appears empty and has 10 charges. While holding the pouch, you can use an action to expend 1 of its charges, speak the name of any nonmagical food seasoning (such as salt, pepper, saffron, or cilantro)...', 'https://revaturecelestialemporium.s3.us-east-2.amazonaws.com/bags/magicspicepouch.jpg'),
	('Wand of Conducting', 'This wand has 3 charges. While holding it, you can use an action to expend 1 of its charges and create orchestral music by waving it around. The music can be heard out to a range of 60 feet and ends when you stop waving the wand.', 'https://revaturecelestialemporium.s3.us-east-2.amazonaws.com/wands/wandconducting.jpg'),
	('Staff of Flowers', 'This wooden staff has 10 charges. While holding it, you can use an action to expend 1 charge from the staff and cause a flower to sprout from a patch of earth or soil within 5 feet of you, or from the staff itself...', 'https://revaturecelestialemporium.s3.us-east-2.amazonaws.com/staves/staffflowers.jpg'),
	('Ruby of the War Mage', '(Requires Attunement) Etched with eldritch runes, this 1-inch-diameter ruby allows you to use a simple or martial weapon as a spellcasting focus for your spells...', 'https://revaturecelestialemporium.s3.us-east-2.amazonaws.com/neck/rubywarmagenecklace.jpg'),
	('Boots of False Tracks', 'Only humanoids can wear these boots. While wearing the boots, you can choose to have them leave tracks like those of another kind of humanoid of your size.', 'https://revaturecelestialemporium.s3.us-east-2.amazonaws.com/feet/falsetrackboots.jpg'),
	('Potion of Animal Friendship', 'When you drink this potion, you can cast the animal friendship spell (save DC 13) for 1 hour at will. Agitating this muddy liquid brings little bits into view: a fish scale, a hummingbird tongue...', 'https://revaturecelestialemporium.s3.us-east-2.amazonaws.com/potions/potionanimalfriendship.jpg'),
	('Gauntlets of Ogre Power', '(Requires Attunement) Your Strength score is 19 while you wear these gauntlets. They have no effect on you if your Strength is already 19 or higher without them.', 'https://revaturecelestialemporium.s3.us-east-2.amazonaws.com/wrist/ogrepowergauntlets.jpg'),
	('Mithral Plate Armor', 'Mithral is a light, flexible metal. A mithral chain shirt or breastplate can be worn under normal clothes. If the armor normally imposes disadvantage on Dexterity (Stealth) checks or has a Strength requirement...', 'https://revaturecelestialemporium.s3.us-east-2.amazonaws.com/armor/mithralplate.jpg');

INSERT INTO users(email, password, first_name, last_name, address, member_tier) VALUES
	('testemail1@newuser.com', 'pAssword123_', 'Tom', 'Engine', '1234 Fake Street, Newmedia, TN, 88888', 'BUYER'),
	('testbuyer2@randomemail.com', 'p@Ss456', 'Marvolo', 'Riddle', '777 Hogwarts Lane, Great Britain, 30300', 'BUYER'),
	('testseller1@swordcoast.net', 'sEsame!111', 'Count', 'Strad', '1 Raven Road, Ravenloft, 66666', 'SELLER'),
	('testseller2@wotcisevil.com', '123Fes#', 'Gale', 'Of-Waterdeep', 'Planes', 'SELLER'),
	('testseller3@pathfinder.com', 'abC$323', 'Hammer', 'Thor', 'somewhere', 'SELLER'),
	('testadmintobe@admin.net', '11A2b3c000!', 'Admin', 'Tom', 'someplace', 'SELLER'),
	('testadmin1@email.com', '123pass@worD', 'Adam', 'Tester', 'nowhere', 'ADMIN'),
	('testadmin2@email.org', '111A2d4!', 'Tony', 'Stark', 'multiverse', 'ADMIN'),
	('waukeen@gods.com', '7777777AAaa!', 'Waukeen', 'Gold', 'Nirvana', 'WAUKEEN');

INSERT INTO inventories(user_id_number, item_id, quantity, price) VALUES
    (1, 1, 5, 3000),
    (1, 2, 3, 4000),
    (2, 4, 2, 1000);