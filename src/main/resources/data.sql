

--add users
insert into user(id,firstname,lastname,mail,password) values(1,'Tony','Stark','tony.stark@avengers.com','jarvis');
insert into user(id,firstname,lastname,mail,password) values(2,'Ron','Swanson','not your business','tammy');
insert into user(id,firstname,lastname,mail,password) values(3,'Clark','Kent','clark.kent@dailyplanet.com','martha');

--add places
insert into place(id,town_name,post_code) values(1,'New-York','10001');
insert into place(id,town_name,post_code) values(4,'San Francisco','94016');
insert into place(id,town_name,post_code) values(2,'Metropolis','88001');
insert into place(id,town_name,post_code) values(3,'Pawnee','00001');

--add sports
insert into sport(id,rainy,sunny,sport_name,type) values(1,false,true,'Sky Diving','AIR');
insert into sport(id,rainy,sunny,sport_name,type) values(2,true,true,'Fishing','EAU');
insert into sport(id,rainy,sunny,sport_name,type) values(3,false,true,'Woodworking','MECANIQUE');
insert into sport(id,rainy,sunny,sport_name,type) values(4,true,true,'Driving','TERRE');

--add places to users
insert into user_place(id,preference_order,place_id,user_id) values(1,1,1,1);
insert into user_place(id,preference_order,place_id,user_id) values(2,2,2,1);
insert into user_place(id,preference_order,place_id,user_id) values(3,1,3,2);
insert into user_place(id,preference_order,place_id,user_id) values(4,1,2,3);
insert into user_place(id,preference_order,place_id,user_id) values(5,2,4,3);
insert into user_place(id,preference_order,place_id,user_id) values(6,3,1,3);

--add sports to users
insert into user_sport(id,preference_order,sport_id,user_id) values(1,1,1,1);
insert into user_sport(id,preference_order,sport_id,user_id) values(2,2,4,1);
insert into user_sport(id,preference_order,sport_id,user_id) values(3,1,3,2);
insert into user_sport(id,preference_order,sport_id,user_id) values(4,1,1,3);
insert into user_sport(id,preference_order,sport_id,user_id) values(5,2,2,3);