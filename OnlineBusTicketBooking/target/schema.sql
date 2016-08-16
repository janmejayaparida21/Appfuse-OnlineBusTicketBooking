
    alter table Buses 
        drop 
        foreign key FK_577sf03vpa4rxri2hvd0u6o8p;

    alter table Buses 
        drop 
        foreign key FK_k2gtaw3eywhf7nvk5ky7kngs0;

    alter table Buses 
        drop 
        foreign key FK_o9n6erxatklwi1xj5tvnpor4l;

    alter table Cities 
        drop 
        foreign key FK_gbr5crl5snng7q1vxovuxaeca;

    alter table Cities 
        drop 
        foreign key FK_lhdxrtkor9qkuqhexc60ktaiw;

    alter table Reservations 
        drop 
        foreign key FK_ls6c94o5knkqc66vd21dygj18;

    alter table Reservations 
        drop 
        foreign key FK_9b6bmun7t6v0pi5octeyjqb4j;

    alter table Routes 
        drop 
        foreign key FK_1srn1nsgi3o99379pbokn6j91;

    alter table Routes 
        drop 
        foreign key FK_i9i3bkgro0xebwg91d98ewisw;

    alter table Routes 
        drop 
        foreign key FK_96dvy7t6gbv647auqjlxq5tm0;

    alter table Routes 
        drop 
        foreign key FK_q57461r75iw0p4cvaglj2kqgd;

    alter table Travels 
        drop 
        foreign key FK_ibbaa5exvvhdb9lgd0ordcaxv;

    alter table Travels 
        drop 
        foreign key FK_e9xwiciwa68vd418jsg8fianq;

    alter table TripRoutes 
        drop 
        foreign key FK_sihyi51c7elgmqjlp6ysjgg0i;

    alter table TripRoutes 
        drop 
        foreign key FK_qdkhsuoc60ehcad2khh7m5ylq;

    alter table TripRoutes 
        drop 
        foreign key FK_lv5b47w72yhdxt1x5geajhkyk;

    alter table TripRoutes 
        drop 
        foreign key FK_fgc8w5kaxbuk8o3n33qkvn9tp;

    alter table Trips 
        drop 
        foreign key FK_s1krs3xeux2m6d7e8sisptnja;

    alter table Trips 
        drop 
        foreign key FK_j4jf9q3114netbt7mkqsqhyn2;

    alter table Trips 
        drop 
        foreign key FK_smhv8gfkm1wy4c1k8bweu1k36;

    alter table user_role 
        drop 
        foreign key FK_it77eq964jhfqtu54081ebtio;

    alter table user_role 
        drop 
        foreign key FK_apcc8lxk2xnug8377fatvbn04;

    drop table if exists Buses;

    drop table if exists Cities;

    drop table if exists Reservations;

    drop table if exists Routes;

    drop table if exists Travels;

    drop table if exists TripRoutes;

    drop table if exists Trips;

    drop table if exists app_user;

    drop table if exists role;

    drop table if exists user_role;

    create table Buses (
        Id integer not null auto_increment,
        Created_At date,
        Is_Ac bit,
        Modified_At date,
        Registration_Number varchar(255),
        Total_Number_Of_Seats integer,
        Type varchar(255),
        Created_By bigint,
        Modified_By bigint,
        Travels_Id integer,
        primary key (Id)
    ) ENGINE=InnoDB;

    create table Cities (
        Id integer not null auto_increment,
        Created_At date,
        Modified_At date,
        Name varchar(255),
        Created_By bigint,
        Modified_By bigint,
        primary key (Id)
    ) ENGINE=InnoDB;

    create table Reservations (
        Id integer not null auto_increment,
        No_Of_Seats_Booked integer,
        Payment_Mode varchar(255),
        Status bit,
        Total_Price double precision,
        Trip_Route_Id integer,
        User_Id bigint,
        primary key (Id)
    ) ENGINE=InnoDB;

    create table Routes (
        Id integer not null auto_increment,
        Created_At date,
        Modified_At date,
        Created_By bigint,
        Destination_City_Id integer,
        Modified_By bigint,
        Source_City_Id integer,
        primary key (Id)
    ) ENGINE=InnoDB;

    create table Travels (
        Id integer not null auto_increment,
        Address varchar(255),
        Contact_Number bigint,
        Created_At date,
        Modified_At date,
        Name varchar(255),
        Created_By bigint,
        Modified_By bigint,
        primary key (Id)
    ) ENGINE=InnoDB;

    create table TripRoutes (
        Id integer not null auto_increment,
        Arrival_Time time,
        Created_At date,
        Date_Of_Travel date,
        Departure_Time time,
        Is_Active bit,
        Modified_At date,
        Price double precision,
        Created_By bigint,
        Modified_By bigint,
        Route_Id integer,
        Trip_Id integer,
        primary key (Id)
    ) ENGINE=InnoDB;

    create table Trips (
        Id integer not null auto_increment,
        Created_At date,
        Modified_At date,
        Seat_Vacancy integer,
        Bus_Id integer,
        Created_By bigint,
        Modified_By bigint,
        primary key (Id)
    ) ENGINE=InnoDB;

    create table app_user (
        id bigint not null auto_increment,
        account_expired bit not null,
        account_locked bit not null,
        address varchar(150),
        city varchar(50),
        country varchar(100),
        postal_code varchar(15),
        province varchar(100),
        credentials_expired bit not null,
        email varchar(255) not null,
        account_enabled bit,
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        password varchar(255) not null,
        password_hint varchar(255),
        phone_number varchar(255),
        username varchar(50) not null,
        version integer,
        website varchar(255),
        primary key (id)
    ) ENGINE=InnoDB;

    create table role (
        id bigint not null auto_increment,
        description varchar(64),
        name varchar(20),
        primary key (id)
    ) ENGINE=InnoDB;

    create table user_role (
        user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) ENGINE=InnoDB;

    alter table app_user 
        add constraint UK_1j9d9a06i600gd43uu3km82jw  unique (email);

    alter table app_user 
        add constraint UK_3k4cplvh82srueuttfkwnylq0  unique (username);

    alter table Buses 
        add constraint FK_577sf03vpa4rxri2hvd0u6o8p 
        foreign key (Created_By) 
        references app_user (id);

    alter table Buses 
        add constraint FK_k2gtaw3eywhf7nvk5ky7kngs0 
        foreign key (Modified_By) 
        references app_user (id);

    alter table Buses 
        add constraint FK_o9n6erxatklwi1xj5tvnpor4l 
        foreign key (Travels_Id) 
        references Travels (Id);

    alter table Cities 
        add constraint FK_gbr5crl5snng7q1vxovuxaeca 
        foreign key (Created_By) 
        references app_user (id);

    alter table Cities 
        add constraint FK_lhdxrtkor9qkuqhexc60ktaiw 
        foreign key (Modified_By) 
        references app_user (id);

    alter table Reservations 
        add constraint FK_ls6c94o5knkqc66vd21dygj18 
        foreign key (Trip_Route_Id) 
        references TripRoutes (Id);

    alter table Reservations 
        add constraint FK_9b6bmun7t6v0pi5octeyjqb4j 
        foreign key (User_Id) 
        references app_user (id);

    alter table Routes 
        add constraint FK_1srn1nsgi3o99379pbokn6j91 
        foreign key (Created_By) 
        references app_user (id);

    alter table Routes 
        add constraint FK_i9i3bkgro0xebwg91d98ewisw 
        foreign key (Destination_City_Id) 
        references Cities (Id);

    alter table Routes 
        add constraint FK_96dvy7t6gbv647auqjlxq5tm0 
        foreign key (Modified_By) 
        references app_user (id);

    alter table Routes 
        add constraint FK_q57461r75iw0p4cvaglj2kqgd 
        foreign key (Source_City_Id) 
        references Cities (Id);

    alter table Travels 
        add constraint FK_ibbaa5exvvhdb9lgd0ordcaxv 
        foreign key (Created_By) 
        references app_user (id);

    alter table Travels 
        add constraint FK_e9xwiciwa68vd418jsg8fianq 
        foreign key (Modified_By) 
        references app_user (id);

    alter table TripRoutes 
        add constraint FK_sihyi51c7elgmqjlp6ysjgg0i 
        foreign key (Created_By) 
        references app_user (id);

    alter table TripRoutes 
        add constraint FK_qdkhsuoc60ehcad2khh7m5ylq 
        foreign key (Modified_By) 
        references app_user (id);

    alter table TripRoutes 
        add constraint FK_lv5b47w72yhdxt1x5geajhkyk 
        foreign key (Route_Id) 
        references Routes (Id);

    alter table TripRoutes 
        add constraint FK_fgc8w5kaxbuk8o3n33qkvn9tp 
        foreign key (Trip_Id) 
        references Trips (Id);

    alter table Trips 
        add constraint FK_s1krs3xeux2m6d7e8sisptnja 
        foreign key (Bus_Id) 
        references Buses (Id);

    alter table Trips 
        add constraint FK_j4jf9q3114netbt7mkqsqhyn2 
        foreign key (Created_By) 
        references app_user (id);

    alter table Trips 
        add constraint FK_smhv8gfkm1wy4c1k8bweu1k36 
        foreign key (Modified_By) 
        references app_user (id);

    alter table user_role 
        add constraint FK_it77eq964jhfqtu54081ebtio 
        foreign key (role_id) 
        references role (id);

    alter table user_role 
        add constraint FK_apcc8lxk2xnug8377fatvbn04 
        foreign key (user_id) 
        references app_user (id);
