# Booking a Show Application.

# Executable jar file is at out -> artifacts -> Task_jar folder

To execute the jar, cd to the above directory and enter the command java -jar Task.jar.

The basic view/Main Panel of the console will be like the following :

1) Admin
2) Buyer
3) Exit

Upon selecting 1 as Admin, the next menu will be the Admin Panel where the user will see :

1) Setup
2) View
3) Back

Upon selecting 1 as Setup, the user will be prompt the following:

- Enter Show Number: (Integer)
- Enter Number of Rows (Maximum of 26 rows): (Integer)
- Enter Number of Seats per Row (Maximum of 10 per Row): (Integer)
- Enter Cancellation Period (Minutes) : (Integer)

After information are inserted, it will return back to the menu of the Admin Panel.

Upon selecting 2 as View, the user will be prompt the following:

- Enter Show Number: (Integer)

If there are available booking, it will display the information of the that partiular show. It will return back to the menu of the Admin Panel.

Upon selecting 3 as Back, it will return to the Main Panel.

In the Main Panel, upon selecting 2 as Buyer, the user will see the Buyer Panel:

1) Availability:
2) Book:
3) Cancel:
4) Back:

Upon selecting 1 as Availability, it will prompt the user for the following:

- Enter Show Number: (Integer)

After user input the show number, if it exist, it will display the available seats for that particular show.

Upon selecting 2 as Book, it will prompt the user for the following:

- Enter Show Number: (Integer)
- Enter Phone Number: (Integer)
- Enter Seats Number: (String of seats number)

Ticket Id will be display unpon successful purchase of tickets.


Upon selecting 3 as Cancel, it will prompt the user for the following:

- Enter Show Number to Cancel: (Integer)
- Enter Ticket Number to Cancel: (String of ticket id)

Upon correct inputs and within the cancellation time frame, cancellation of the ticket will be reflected on the view of the admin panel too.




