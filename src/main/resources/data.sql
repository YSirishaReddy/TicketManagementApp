CREATE DATABASE IF NOT EXISTS ticketbooking;

use ticketbooking;
create table ticket(
ticket_id int not null auto_increment,passenger_name varchar(50),booking_date date,
source_station varchar(50),dest_station varchar(50),email varchar(50),primary key(ticket_id)
);
drop table ticket;
insert into ticket(passenger_name,booking_date,source_station,dest_station,email) values('avinash','2020-07-14','america','london','avinash@microsoft.com');

select * from ticket;