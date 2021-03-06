create table view_table (view text primary key, head_variables text, lambda_term text);
create table subgoals (view text references view_table(view), subgoal_names text);
create table subgoal_arguments (subgoal_names text primary key, arguments text);
insert into view_table values ('v1','family_id,name,type');
insert into view_table values ('v2','family_id,name,type','type');
insert into view_table values ('v3','family_id,name,type','family_id');
insert into view_table values ('v4','family_id,name,type,text,object_id');
insert into view_table values ('v5','family_id,name,type,text,object_id','type');
insert into view_table values ('v6','family_id,name,type,text,object_id','family_id');
insert into view_table values ('v7','family_id,object_id','family_id');
insert into view_table values ('v8','family_id,object_id','object_id');
insert into view_table values ('v9','family_id,text','family_id');
insert into view_table values ('v10','family_id,text','family_id');
insert into subgoals values ('v1','family_c');
insert into subgoals values ('v2','family_c');
insert into subgoals values ('v3','family_c');
insert into subgoals values ('v4','family_c');
insert into subgoals values ('v4','introduction_c');
insert into subgoals values ('v4','receptor2family_c');
insert into subgoals values ('v5','family_c');
insert into subgoals values ('v5','introduction_c');
insert into subgoals values ('v5','receptor2family_c');
insert into subgoals values ('v6','family_c');
insert into subgoals values ('v6','introduction_c');
insert into subgoals values ('v6','receptor2family_c');
insert into subgoals values ('v7','receptor2family_c');
insert into subgoals values ('v8','receptor2family_c');
insert into subgoals values ('v9','introduction_c');
insert into subgoals values ('v10','introduction_c');
insert into subgoal_arguments values ('family_c','family_id,name,type');
insert into subgoal_arguments values ('introduction_c','family_id,text');
insert into subgoal_arguments values ('receptor2family_c','object_id,family_id');
create table family_c as select family_id,name,type from family;
create table receptor2family_c as select object_id, family_id from receptor2family;
create table introduction_c as select family_id, text from introduction;
create view v1 as select * from family_c;
create view v2 as select * from family_c;
create view v3 as select * from family_c;
create view v4 as select f.family_id, name,type,text,object_id from family_c f, introduction_c i, receptor2family_c r where f.family_id = i.family_id and f.family_id = r.family_id;
create view v5 as select f.family_id, name,type,text,object_id from family_c f, introduction_c i, receptor2family_c r where f.family_id = i.family_id and f.family_id = r.family_id;
create view v6 as select f.family_id, name,type,text,object_id from family_c f, introduction_c i, receptor2family_c r where f.family_id = i.family_id and f.family_id = r.family_id;
create view v7 as select * from receptor2family_c;
create view v8 as select * from receptor2family_c;
create view v9 as select * from introduction_c;
create view v10 as select * from introduction_c;
create table v1_table as select * from v1;
create table v2_table as select * from v2;
create table v3_table as select * from v3;
create table v4_table as select * from v4;
create table v5_table as select * from v5;
create table v6_table as select * from v6;
create table v7_table as select * from v7;
create table v8_table as select * from v8;
create table v9_table as select * from v9;
create table v10_table as select * from v10;
insert into citation_view values ('C1','v1'),('C2','v2'),('C3','v3'),('C4','v4'),('C5','v5'),('C6','v6'),('C7','v7'),('C8','v8'),('C9','v9'),('C10','v10');


