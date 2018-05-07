/* 2.1 SELECT
Task – Select all records from the Employee table.*/
SELECT * FROM EMPLOYEE;
/
/* 2.1 SELECT
Task – Select all records from the Employee table where last name is King.*/
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';
/
/* 2.1 SELECT
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.*/
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO IS NULL;
/
/* 2.2 ORDER BY 
Task – Select all albums in Album table and sort result set in descending order by title. */
SELECT * FROM ALBUM
ORDER BY TITLE DESC;
/
/* 2.2 ORDER BY
Task – Select first name from Customer and sort result set in ascending order by city */
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;
/
/* 2.3 INSERT INTO 
Task – Insert two new records into Genre table  */
INSERT INTO GENRE
VALUES(26,'K-pop');
/
INSERT INTO GENRE
VALUES(27,'J-pop');
/
/* 2.3 INSERT INTO 
Task – Insert two new records into Employee table  */
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME)
VALUES(9,'Francis','Keller');
/
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME)
VALUES(10,'Kevin','Smith');
/
/* 2.3 INSERT INTO 
Task – Insert two new records into Customer table  */
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
VALUES(60,'Andrew','Brown','andrew.brown@gmail.com');
/
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
VALUES(61,'Sarah','Lee','saralee@gmail.com');
/
/* 2.4 UPDATE 
Task – Update Aaron Mitchell in Customer table to Robert Walter */
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron'
AND LASTNAME = 'Mitchell';
/
/* 2.4 UPDATE
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	*/
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
/
/* 2.5 LIKE 
Task – Select all invoices with a billing address like “T%” */
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
/
/* 2.6 BETWEEN 
Task – Select all invoices that have a total between 15 and 50 */
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;
/
/* 2.6 BETWEEN 
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004 */
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

/* 2.7 DELETE 
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them). */
DELETE FROM INVOICELINE
WHERE INVOICEID =
    (SELECT INVOICEID FROM INVOICE
    WHERE CUSTOMERID =
        (SELECT CUSTOMERID FROM CUSTOMER 
        WHERE FIRSTNAME = 'Robert'
        AND LASTNAME = 'Walter'));

DELETE FROM INVOICE
WHERE CUSTOMERID = (
    SELECT CUSTOMERID 
    FROM CUSTOMER 
    WHERE FIRSTNAME = 'Robert'
    AND LASTNAME = 'Walter');

DELETE
FROM CUSTOMER
WHERE FIRSTNAME = 'Robert'
AND LASTNAME = 'Walter';
/
/* 3.1 SYSTEM DEFINED FUNCTIONS 
Task – Create a function that returns the current time. */
CREATE OR REPLACE FUNCTION getTime
RETURN TIMESTAMP
IS currentTime TIMESTAMP;
BEGIN
SELECT
    TO_CHAR(CURRENT_TIMESTAMP,'DD-MON-YYYY HH:MI')
    INTO currentTime
    FROM DUAL;
    RETURN(currentTime);
END;

-- select getTime FROM DUAL;
/
/* 3.1 SYSTEM DEFINED FUNCTIONS 
Task – create a function that returns the length of name in MEDIATYPE table */
CREATE OR REPLACE FUNCTION getLength
RETURN INT
IS mlength INT;
BEGIN
SELECT 
    MAX(LENGTH(NAME))
    INTO mlength
    FROM MEDIATYPE;
    RETURN mlength;
END;

--SELECT GETLENGTH FROM DUAL;
/
/* 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS 
Task – Create a function that returns the average total of all invoices */
CREATE OR REPLACE FUNCTION getAvgInv
RETURN FLOAT
IS avgInv FLOAT;
BEGIN
SELECT
    TO_CHAR(AVG(TOTAL), '999.99')
    INTO avgInv
    FROM INVOICE;
    RETURN avgInv;
END;

--SELECT GETAVGINV FROM DUAL;
/
/* 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS 
Task – Create a function that returns the most expensive track */
CREATE OR REPLACE FUNCTION getMaxPrice
RETURN FLOAT
IS maxPrice FLOAT;
BEGIN
SELECT TO_CHAR(MAX(UNITPRICE),'999.99')
    INTO maxPrice
    FROM TRACK;
    RETURN maxPrice;
END;

/
/* 3.3 USER DEFINED SCALAR FUNCTIONS 
Task – Create a function that returns the average price of invoiceline items in the invoiceline table */ 
CREATE OR REPLACE FUNCTION getAvgPrice
RETURN FLOAT
IS avgPrice FLOAT;
BEGIN
SELECT TO_CHAR(AVG(UNITPRICE),'999.99')
    INTO avgPrice
    FROM INVOICELINE;
    RETURN avgPrice;
END;

--select getAvgPrice from dual;
/
/* 3.4 USER DEFINED TABLE VALUED FUNCTIONS 
Task – Create a function that returns all employees who are born after 1968. */
CREATE OR REPLACE FUNCTION returnEmp
RETURN INT
IS emp INT;
BEGIN
SELECT EMPLOYEEID
    INTO emp
    FROM EMPLOYEE
    WHERE EXTRACT (YEAR FROM TO_DATE(BIRTHDATE, 'DD-MON-RR')) > '1968';
    RETURN emp;
END;

--SELECT RETURNEMP FROM DUAL;
/* 4.1 BASIC STORED PROCEDURE 
Task – Create a stored procedure that selects the first and last names of all the employees. */

CREATE OR REPLACE PROCEDURE employeeNames (FNAME OUT VARCHAR2, LNAME OUT VARCHAR2, C_NAMES OUT SYS_REFCURSOR )
AS
CURSOR C_NAMES IS
    SELECT FIRSTNAME, LASTNAME
    FROM EMPLOYEE;
BEGIN
    OPEN C_NAMES;
    LOOP
        FETCH C_NAMES  INTO FNAME, LNAME;
        DBMS_OUTPUT.PUT_LINE(FNAME, LNAME);
        EXIT WHEN C%NOTFOUND;
    END LOOP;
    CLOSE C_NAMES;
END;


/* 4.2 STORED PROCEDURE INPUT PARAMETERS 
Task – Create a stored procedure that updates the personal information of an employee. */
CREATE OR REPLACE PROCEDURE updateEmployee(empID IN NUMBER)
AS
BEGIN
    UPDATE EMPLOYEE SET TITLE = 'IT Staff'
    WHERE empID = EMPLOYEEID;
END;

/* 4.2 STORED PROCEDURE INPUT PARAMETERS 
Task – Create a stored procedure that returns the managers of an employee. */
CREATE OR REPLACE PROCEDURE empManager(empID IN NUMBER)
AS
BEGIN
    SELECT REPORTSTO FROM EMPLOYEE
    WHERE empID = EMPLOYEEID;
END;

/* 4.3 STORED PROCCEDURE OUTPUT PARAMETERS
Task – Create a stored procedure that returns the name and company of a customer. */
CREATE OR REPLACE PROCEDURE custInfo(custID IN NUMBER)
AS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER
    WHERE custID = CUSTOMERID;
END;

/* 5.0 TRANSACTIONS 
Task – Create a transaction that given a invoiceId will delete that invoice. */

/* 6.1 AFTER/FOR 
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table. */
CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    NULL;
END;
/* 6.1 AFTER/FOR 
Task – Create an after update trigger on the album table that fires after a row is inserted in the table */
CREATE OR REPLACE TRIGGER TR_UPDATE_ALBUM
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    NULL;
END;

/* 6.1 AFTER/FOR 
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table. */
CREATE OR REPLACE TRIGGER TR_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
    NULL;
END;

/* 7.1 INNER 
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId */
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

/* 7.2 OUTER 
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total. */
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

/* 7.3 RIGHT 
Task – Create a right join that joins album and artist specifying artist name and title. */
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM
RIGHT JOIN ARTIST ON ARTIST.ARTISTID = ALBUM.ARTISTID;

/* 7.4 CROSS 
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order. */
SELECT * FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

/* 7.5 SELF 
Task – Perform a self-join on the employee table, joining on the reportsto column. */
SELECT A.FIRSTNAME, A.LASTNAME, A.REPORTSTO, B.FIRSTNAME, B.LASTNAME, B.REPORTSTO
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.EMPLOYEEID <> B.EMPLOYEEID
AND A.REPORTSTO = B.REPORTSTO;















