package learnjava.practice.callablestatement;

public class StoredProcedureFunctionTheory {
//1)Stored Procedure - Oracle
//$how to write storedProcedure
	/* @ SQL/PLSQL is not case sensitive BEGIN==begin
	 * CREATE OR REPLACE PROCEDURE procedurename(parametername1 IN number, parametername2 IN number, parametername3 OUT number) as
	 *  BEGIN
	 *	   all the operations
	 *  END
	 * slash/ for compilation
	 */
//2)$How to run above Stored Procedure in SQL Developer
	/* @
	 * variable nameofvariable number(datatype);
	 * execute procedurename(input1,input2,:nameofvariable);
	 * print nameofvariable;
	 */
//3)$Example of stored Procedure
	/*@
	 * CREATE OR REPLACE PROCEDURE getsalary(employeenumber IN number, salary OUT number) as
	 * BEGIN
	 * select employee_salary into salary from employee where employee_number =employeenumber;
	 * END
	 * slash/
	 * 
	 *  Use step 2 to execute procedure 
	 */
//Stored procedure with SYS_REFCURSOR
	/*
	 *CREATE OR REPLACE PROCEDURE getsalary(employeenumber IN number, salary OUT SYS_REFCURSOR) as
	 * BEGIN
	 * open salary for 
	 * select employee_salary  from employee ;
	 * END
	 * slash/ 
	 * 
	 * 
	 */
	
//Functions
//$how to write storedProcedure
		/* @ SQL/PLSQL is not case sensitive BEGIN==begin
		 * CREATE OR REPLACE Function functionname(parametername1 IN number, parametername2 IN number, parametername3 OUT number) return SYS_REFCURSOR as
		 * --variable declarion
			cursorname SYS_REFCURSOR;

		 *  BEGIN
		 *  open cursorname for 
		 *	   all the operations
		 *return cursorname;
		 *  END
		 * slash/ for compilation
		 */
/*EXAMPLE
  	create or replace function companyheod(symbol IN varchar2,noofrecords OUT number) return SYS_REFCURSOR as
	--variable declarion
	companyeodinfo SYS_REFCURSOR;

	BEGIN
	open companyeodinfo for
	select * from HIST_EOD_DATA where ticker =symbol;
	update hist_eod_data set adj_close_price=0 where ticker = symbol;
	noofrecords := SQL%ROWCOUNT;--non select queries.....no of rows effected
	return companyeodinfo;
	END;

 */

}
