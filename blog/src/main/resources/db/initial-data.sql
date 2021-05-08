INSERT INTO USERS (id, username, password) VALUES
('d3cf15bc-61bc-4681-b0d6-4a94bd557448', 'admin', '{bcrypt}$2y$12$Zl06IDjndjLO3O.QWsQ46eyF1SwSxW18rEO6pY8es1AGmRynQY8ES'),--admin
('d3cf15bc-64bc-4681-b0d6-4a14bd557448', 'user', '{bcrypt}$2y$12$Z5Rz0tZC2YVpustgrWkoxONrqHjBjmEM1VFH8g5MPYMI0oD63Pzka'),--pass
('cddd20d5-951e-4a4c-9b49-5944e88d9e14', 'second', '{bcrypt}$2y$12$IwN6891khy7dKHTe0vWsBuUCisDajOdVJYt7Kp5BT1Eu0RnWIBnK6'),--pass
('9024b2df-39b5-42bc-aa24-373e52a1403f', 'another', '{bcrypt}$2y$12$KcTdBJF44EULiT4N3h7bMOGd0eVt8IPIcmZnJp2FEFASMFJodNm6C');--pass

INSERT INTO POSTS (id, title, content, date, user_id) values
    ('8300bb58-ec03-4323-b5f5-14596b00ad10', 'My first post',
     'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Gravida arcu ac tortor dignissim. Blandit aliquam etiam erat velit scelerisque in dictum non consectetur. Lacus viverra vitae congue eu. Ornare arcu odio ut sem nulla. Magna ac placerat vestibulum lectus mauris ultrices. Ultricies mi eget mauris pharetra et ultrices neque. Adipiscing diam donec adipiscing tristique risus. Ac auctor augue mauris augue neque. Nec ullamcorper sit amet risus nullam. Cras ornare arcu dui vivamus arcu felis bibendum. Felis bibendum ut tristique et egestas quis ipsum. Diam ut venenatis tellus in metus vulputate eu. Morbi tincidunt augue interdum velit euismod in pellentesque massa placerat. Sit amet porttitor eget dolor morbi non arcu risus quis. Quis lectus nulla at volutpat diam ut venenatis tellus in.',
     '2021-01-15', 'd3cf15bc-61bc-4681-b0d6-4a94bd557448'),
    ('c6e80bf7-a09a-4bbf-a086-90d59468d0f8', 'My second post',
     'Volutpat odio facilisis mauris sit amet massa. Varius duis at consectetur lorem donec massa sapien faucibus et. Tincidunt eget nullam non nisi est. Aliquam id diam maecenas ultricies mi eget. Iaculis nunc sed augue lacus. Tellus orci ac auctor augue mauris augue. Quam viverra orci sagittis eu volutpat odio facilisis mauris sit. Auctor augue mauris augue neque gravida in. Ut porttitor leo a diam sollicitudin. Sollicitudin tempor id eu nisl nunc mi ipsum faucibus. Et netus et malesuada fames ac turpis.',
     '2021-01-18', 'd3cf15bc-61bc-4681-b0d6-4a94bd557448'),
    ('0d775a8f-809a-464e-9aed-05aa8d2754eb', 'My third post',
     'Augue lacus viverra vitae congue eu consequat ac. Et malesuada fames ac turpis egestas. Lacus luctus accumsan tortor posuere ac ut consequat semper. Sit amet massa vitae tortor condimentum lacinia quis. Arcu dui vivamus arcu felis. Enim nunc faucibus a pellentesque sit amet porttitor eget dolor. Quisque id diam vel quam elementum pulvinar etiam non. Dignissim diam quis enim lobortis scelerisque fermentum. Turpis massa tincidunt dui ut ornare. Sed elementum tempus egestas sed sed risus pretium quam. Volutpat diam ut venenatis tellus in metus vulputate eu.',
     '2021-01-28', 'd3cf15bc-61bc-4681-b0d6-4a94bd557448'),
    ('56ba884c-0b7f-4bc8-8d9d-49cd40f78fd1', 'My fourth post',
     'Non arcu risus quis varius quam quisque id diam. Vulputate mi sit amet mauris commodo quis imperdiet massa. Adipiscing tristique risus nec feugiat. Turpis massa tincidunt dui ut ornare lectus sit amet est. Quam adipiscing vitae proin sagittis nisl rhoncus mattis rhoncus urna. Praesent tristique magna sit amet. Sed id semper risus in hendrerit. Amet commodo nulla facilisi nullam vehicula ipsum a arcu. Hendrerit dolor magna eget est. Scelerisque viverra mauris in aliquam. Nunc scelerisque viverra mauris in. Vitae congue mauris rhoncus aenean vel elit scelerisque mauris pellentesque. Nulla posuere sollicitudin aliquam ultrices sagittis orci a. Et magnis dis parturient montes nascetur ridiculus. Fusce id velit ut tortor pretium. Tincidunt arcu non sodales neque sodales ut. Risus quis varius quam quisque id diam.',
     '2021-02-04', 'd3cf15bc-61bc-4681-b0d6-4a94bd557448'),
    ('3d371090-ac16-4450-a0bc-e08f77e71180', 'My fifth post',
     'Facilisi morbi tempus iaculis urna id volutpat. Id volutpat lacus laoreet non. Ut enim blandit volutpat maecenas volutpat blandit aliquam. Aliquam sem fringilla ut morbi. Aliquam etiam erat velit scelerisque in dictum. Neque laoreet suspendisse interdum consectetur libero. Turpis massa sed elementum tempus egestas. Eget nullam non nisi est sit amet facilisis magna etiam. Tempus quam pellentesque nec nam aliquam sem. Egestas integer eget aliquet nibh praesent tristique magna sit amet. Tortor condimentum lacinia quis vel eros donec ac. Eget nunc scelerisque viverra mauris in aliquam. Suscipit adipiscing bibendum est ultricies integer. Cursus sit amet dictum sit amet justo donec. Vel facilisis volutpat est velit egestas. Risus feugiat in ante metus dictum at. Interdum velit laoreet id donec. Ut faucibus pulvinar elementum integer enim neque. Tellus pellentesque eu tincidunt tortor aliquam nulla.',
     '2021-02-10', 'd3cf15bc-61bc-4681-b0d6-4a94bd557448'),
    ('6ed3241c-843a-404a-92fb-43bc3ce4410d', 'My sixth post',
     'Nibh mauris cursus mattis molestie a iaculis at erat pellentesque. Mi ipsum faucibus vitae aliquet nec ullamcorper sit amet risus. Eu volutpat odio facilisis mauris sit amet massa vitae. Faucibus ornare suspendisse sed nisi. Id venenatis a condimentum vitae sapien. Eu augue ut lectus arcu bibendum at varius vel. Nibh venenatis cras sed felis eget. Rutrum quisque non tellus orci ac auctor. Id leo in vitae turpis massa sed. Ultricies mi eget mauris pharetra et ultrices neque ornare. Libero nunc consequat interdum varius sit. Nunc aliquet bibendum enim facilisis gravida neque. Et egestas quis ipsum suspendisse ultrices gravida. Nunc pulvinar sapien et ligula ullamcorper malesuada proin libero.',
     '2021-02-25', 'd3cf15bc-61bc-4681-b0d6-4a94bd557448'),
    ('d3cf15bc-61bc-4681-b0d6-4a91bd557448', 'My seventh post',
     'Nisl suscipit adipiscing bibendum est ultricies integer. Neque aliquam vestibulum morbi blandit cursus risus at. Commodo sed egestas egestas fringilla. Donec ultrices tincidunt arcu non sodales neque. Lorem dolor sed viverra ipsum nunc. Semper eget duis at tellus at. Sed risus pretium quam vulputate dignissim suspendisse in est ante. Vestibulum morbi blandit cursus risus at ultrices mi. Gravida quis blandit turpis cursus in hac habitasse. Cursus risus at ultrices mi tempus. Vitae tempus quam pellentesque nec nam aliquam sem et. Mauris pharetra et ultrices neque ornare aenean euismod elementum nisi. Congue eu consequat ac felis donec et.',
     '2021-03-13', 'd3cf15bc-61bc-4681-b0d6-4a94bd557448'),
    ('9d438afb-3178-4486-b9e5-b7e84a13458e', 'My eighth post',
     'Sit amet mattis vulputate enim nulla aliquet porttitor. Mauris a diam maecenas sed. Interdum varius sit amet mattis vulputate enim. Diam vulputate ut pharetra sit. Vitae aliquet nec ullamcorper sit amet risus nullam. Elementum pulvinar etiam non quam. Massa enim nec dui nunc mattis enim ut tellus. Accumsan lacus vel facilisis volutpat est velit egestas dui. Diam vel quam elementum pulvinar etiam non quam lacus. Elementum pulvinar etiam non quam. Suscipit tellus mauris a diam maecenas sed. Gravida rutrum quisque non tellus orci. Et tortor at risus viverra adipiscing. Urna neque viverra justo nec ultrices dui sapien. Ultricies mi eget mauris pharetra et ultrices neque ornare.',
     '2021-03-27', 'd3cf15bc-61bc-4681-b0d6-4a94bd557448'),
    ('f844e470-3a9a-4d46-8af8-45d95d455d16', 'My ninth post',
     'Eget nulla facilisi etiam dignissim diam quis enim. Proin gravida hendrerit lectus a. Ultrices sagittis orci a scelerisque purus semper eget. Bibendum at varius vel pharetra vel turpis nunc eget lorem. Amet facilisis magna etiam tempor orci eu lobortis elementum. Leo urna molestie at elementum eu facilisis sed. Est ante in nibh mauris cursus. Viverra maecenas accumsan lacus vel facilisis. Scelerisque eu ultrices vitae auctor eu augue ut. At tellus at urna condimentum mattis pellentesque id nibh. Posuere morbi leo urna molestie at elementum. Id consectetur purus ut faucibus pulvinar elementum integer enim. Massa id neque aliquam vestibulum morbi. Nisl suscipit adipiscing bibendum est ultricies integer. Massa placerat duis ultricies lacus sed. Justo nec ultrices dui sapien eget mi proin sed libero. In cursus turpis massa tincidunt dui ut ornare. Tortor vitae purus faucibus ornare suspendisse sed. Maecenas pharetra convallis posuere morbi leo urna molestie at. Mi ipsum faucibus vitae aliquet nec ullamcorper sit amet.',
     '2021-04-02', 'd3cf15bc-61bc-4681-b0d6-4a94bd557448');

INSERT INTO ROLES (id, role) VALUES
    ('56ba814c-0b7f-4bc8-8d1d-49cd40f78fd1', 'ADMIN'),
    ('9d438afb-3178-4423-b9e5-b7e84a13451e', 'USER');

INSERT INTO USERS_ROLES (user_id, roles_id) VALUES
    ('d3cf15bc-61bc-4681-b0d6-4a94bd557448', '56ba814c-0b7f-4bc8-8d1d-49cd40f78fd1'),
    ('d3cf15bc-61bc-4681-b0d6-4a94bd557448', '9d438afb-3178-4423-b9e5-b7e84a13451e'),
    ('d3cf15bc-64bc-4681-b0d6-4a14bd557448', '9d438afb-3178-4423-b9e5-b7e84a13451e'),
    ('cddd20d5-951e-4a4c-9b49-5944e88d9e14', '9d438afb-3178-4423-b9e5-b7e84a13451e'),
    ('9024b2df-39b5-42bc-aa24-373e52a1403f', '9d438afb-3178-4423-b9e5-b7e84a13451e');

INSERT INTO COMMENTS (id, date, message, post_id, user_id) VALUES
    ('164fe137-5676-4ab1-bddf-311ef547e14f', '2021-04-02', 'Sit amet mattis vulputate enim nulla aliquet porttitor.',
     'f844e470-3a9a-4d46-8af8-45d95d455d16', 'd3cf15bc-64bc-4681-b0d6-4a14bd557448'),
    ('3c9ca875-6d10-427b-ad5d-a6d2a27bd844', '2021-04-02', 'Eget nulla facilisi etiam dignissim diam quis enim.',
     'f844e470-3a9a-4d46-8af8-45d95d455d16', 'cddd20d5-951e-4a4c-9b49-5944e88d9e14'),
    ('cd5da2e3-cbb2-4dc6-8637-dfa0e123b9ea', '2021-04-04', 'Nibh mauris cursus mattis molestie a iaculis at erat pellentesque.',
     'f844e470-3a9a-4d46-8af8-45d95d455d16', '9024b2df-39b5-42bc-aa24-373e52a1403f'),
    ('65059fae-1bf5-4ec8-a555-759309de69c8', '2021-04-12', 'Volutpat odio facilisis mauris sit amet massa. Varius duis at consectetur lorem donec massa sapien faucibus et.',
     'f844e470-3a9a-4d46-8af8-45d95d455d16', '9024b2df-39b5-42bc-aa24-373e52a1403f'),
    ('98ba0a0c-5cd5-49f1-ad88-f80f2d348ff9', '2021-03-27', 'Varius duis at consectetur lorem donec massa sapien faucibus et.',
     '9d438afb-3178-4486-b9e5-b7e84a13458e', 'cddd20d5-951e-4a4c-9b49-5944e88d9e14'),
    ('c7e6a7c5-32b7-429e-8cf8-a73791cdc11f', '2021-03-30', 'Id volutpat lacus laoreet non. Et malesuada fames ac turpis egestas.',
     '9d438afb-3178-4486-b9e5-b7e84a13458e', 'd3cf15bc-61bc-4681-b0d6-4a94bd557448');