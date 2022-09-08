USE JavaProjectG_KewinA;

CREATE TABLE `Employees` (
    `EmployeeID` smallint NOT NULL UNIQUE AUTO_INCREMENT,
	`Name` varchar(30),
	`Address` varchar(100),
	`Salary` decimal(10, 2),
	`IBAN` char(17),
	`NIN` char(9),
    PRIMARY KEY (`EmployeeID`)
);

CREATE TABLE `SalesEmployees` (
   	`EmployeeID` smallint NOT NULL UNIQUE AUTO_INCREMENT,
   	`CommissionRate` decimal(10, 2),
   	`TotalValue` decimal(10, 2),
	FOREIGN KEY (`EmployeeID`) REFERENCES Employees(`EmployeeID`)
);

INSERT INTO Employees (`Name`, `Address`, Salary, IBAN, NIN)
VALUES
('Joe Bloggs', '564 2nd Street Crown Point, IN 46307', '10000.00', '012345567', 'P123456B'),
('Jane Doe', '890 Woodsman Circle Riverview, FL 33569', '10000.00', '98765432', 'P987654B'),
('Fred Jones', '52 S. Third St. Williamstown, NJ 08094', '15000.00', '00112233', 'P998877G'),
('John Anderson', '41 Edgewood St. Longwood, FL 32779', '15000.00', '99998888', 'P776655T'),
('Mr Jones', '683 Valley View St. Attleboro, MA 02703', '20000.00', '11112222', 'P665544R'),
('Frank Michaels', '1 North Meadow Drive Asheville, NC 28803', '20000.00', '12341234', 'P998877S');

INSERT INTO SalesEmployees (CommissionRate, TotalValue)
VALUES
('100.00', '8000.00'),
('200.00', '7000.00'),
('300.00', '9000.00');