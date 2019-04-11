/**********************************************************************************************
	* FILE						:armstrongnumber.txt
	* AUTHOR NAME				:Shivansh
	* DESC						:Pseudo code to accept and check given number is an Armstrong Number
	* VERSION					:1.0
	* DATE OF MODIFICATION		:10-APR-2019
***********************************************************************************************/

BEGIN
	findDetailsOfStudent(City)
EXCEPTION
	when cityNotFound THEN
		PRINT"ERROR MESSAGE"
END

/**********************************************************************************************
	* MODULE NAME							:findDetailsOfStudent()
	* INPUT PARAMETERS						:CITY
	* RETURN								:STRING 
	* AUTHOR								:SHIVANSH
	* DATE OF MODIFICATION					:10-APR-2019
	*DESC									:FIND DETAILS OF STUDENT BASED ON CITY
***********************************************************************************************/

SUB findDetailsOfStudent(City)
	DECLARE City,address AS STRING
	DECLARE pin AS INTEGER
	PROMPT "Enter City"
	READ City
	IF (isValid(City)) THEN
		IF City = "Pune" THEN
			pin = 452134 AND address = "Hinjawadi"
		ELSE IF City = "Mumbai" THEN
			pin = 123456 AND address = "Thane"
		ELSE IF City = "Varanasi" THEN
			pin = 221008 AND address = "Durgakund"
		ELSE IF City = "Hyderabad" THEN
			pin = 456123 AND address = "Ameerpet"
		ELSE
			RAISE CityNotFound("City doesn't exist"+City)
		END IF
	END IF
	PRINT "The Student City is" +City+ "\nPincode is:"+pin+"Address is:"+address
END SUB
/**********************************************************************************************
	* MODULE NAME							:isValid()
	* INPUT PARAMETERS						:CITY
	* RETURN								:BOOLEAN
	* AUTHOR								:SHIVANSH
	* DATE OF MODIFICATION					:10-APR-2019
	*DESC									:VALIDATE DATA
***********************************************************************************************/
SUB isValid(City)
	IF (isString(City)) THEN
		RETURN 
			TRUE
	ELSE
		FALSE
	END IF
END SUB	
