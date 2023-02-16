# Vehical Rental System 

#	User Manual:

Run LoginGUI.java inside main package to view the main (login) screen of the system.

##	Logging into the system:

User groups that can login to the system include staff and customer.
 
1.	Select Staff or Customer to login or Exit the system.          
2.	Staff can login to the system using admin as username and password.
3.	Customers can login with the username and password entered into the system by the staff (Example - joe  can be used as username and password to login)


## How to use (for staff):

 
###	Adding Customers:

Records that already exist and are stored in a binary file can be loaded after pressing display. Staff can add details of corporate customers which is displayed in a table as the records are added. Individual records can also be edited, deleted and updated and the information displayed in the JTable is stored in a binary file on pressing save to file.

1.	Press on display to load records of customers (if any) from binary file 
2.	After pressing display add, edit, delete and save to file buttons become enabled. Adding a new record requires data in all fields and a unique id for the customer.
3.	To delete, select an individual record from the table on the right and press on delete
4.	To edit, select an individual record from the table on the right and press on edit which sets details of the customer on the form which can then be edited and update button can be pressed to update the record.
5.	Pressing save to file successfully writes the data currently displayed in the JTable to the binary file

###	Adding Vehicles:

Adding vehicles has similar functionalities as adding customers (See 3.1.3).  Vehicles records are categorized into cars, mini-buses and lorries. Press on save to file after display is pressed to save data for individual types of vehicles. 

1.	Press on car, mini-bus or lorry radio button respectively to add vehicle records of choice
2.	Other functionalities such as add, edit, display, save work the same as adding customers (See 2.1.2)
3.	Records are stored for cars, mini-buses and lorries in separate files so to write records to binary file, press save to file which takes the current data in the JTable and stores it in respective files. Data must be saved for each type of vehicle by pressing save to file after pressing display.

###	Manage Vehicle Hire:
 
1.	View Requested Hires shows the list containing customer id, name, phone and make, model and registration number of the vehicles that they have requested to hire. Staff can then choose to accept the hire. After accepting hire, the vehicle shows up on the hired vehicle list of the customer. To remove the vehicle from the hire list of the customer and other customers, edit available to hire of the vehicle to no.
2.	Similar to 1, view Requested Returns shows the list containing the vehicles that customers have requested to return. Staff can then choose to accept the return. To show the vehicle to the hire list of the customer and other customers, edit available to hire of the vehicle to yes.
3.	View Vehicles on Loan shows the list of vehicles that are currently hired by different customers. 

## How to use (for customers):

Customers can login with the username and password provided by the staff.

 
###	Find Vehicles To Loan:

Vehicles to loan can be accessed using the buttons as shown above, find cars to loan, find lorries to loan and find mini-buses to loan. The vehicles with available to hire set to yes can only be seen in this hire list. 
 
###	View Vehicles on Loan:

The vehicles that are currently out on loan by a customer can be seen here.
 

###	View Profile:

View Profile shows details of the customer such as customer id, name, and username and so on as entered by the staff of the company.
