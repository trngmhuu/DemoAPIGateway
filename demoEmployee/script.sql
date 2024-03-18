CREATE DATABASE DemoSpringBoot
USE DemoSpringBoot

CREATE TABLE [dbo].[Employee] (
	[id] [int] IDENTITY (1, 1) NOT NULL PRIMARY KEY,
	[first_name] [nvarchar](60) NULL,
	[last_name] [nvarchar](60) NULL,
	[email] [nvarchar](60) NULL
)

SELECT * FROM Employee
DELETE FROM Employee
DROP TABLE Employee