CREATE DATABASE lexsol;

CREATE TABLE Tenant(
    id int NOT NULL primary key,
    public_key text NOT NULL
);

CREATE TABLE NoteType(
   id int NOT NULL primary key,
   name text NOT  NULL,
   tenant_id int NOT NULL references Tenant(id),
   secondaryDate boolean,
   siteVisit_id int,
   showDealIssues boolean,
   deletePermittedInterval boolean,
   discussionTopics jsonb
);

CREATE TABLE Note(
   id int NOT NULL primary key,
   Tenant_id int NOT NULL references Tenant(id),
   noteType_id int NOT NULL references NoteType(id),
   property_id int NOT NULL,
   siteVisit_id int NOT NULL,
   noteDate timestamp with time zone NOT NULL,
   secondaryDate timestamp with time zone,
   note text,
   createdDate timestamp with time zone NOT NULL,
   createdBy int NOT NULL,
   lastModifiedDate timestamp with time zone,
   secondaryDateChangedBy_id int,
   secondaryDateChangeDate timestamp with time zone,
   dealIssues jsonb,
   discussionPoints jsonb
);