Coverage: 80.3
# IMS project


I attempted to complete this project using Java and I connected mySQL using a jdbc.
The Project has the CRUD funtions.
My IMS has a list of customers, items, request and orderinfo.
## Getting Started



### using the project
The terminal will ask what list you would like to use. There are 5 options. Customer Item Order OrderInfo STOP

For the options of customer, item, and order, there are 4 main functions the application can perform. These are as follows.

CREATE: this creates a new customer, item or order, depending on the choice the user selecting in the previous menu. 
If the user selected Item previously, 
then the console will ask for a Item Name, Value which the user will write into the command-line and 
Then Item is then created.

READ: This will read all entries in the database for a specific table.
The read function will show every entry on what options you chose previously.
If item was chosen first then it would show every itemID with their respected name and value next to it. 


UPDATE: This function will change an existing entry, 
for example if the user selected ITEMS and then UPDATE, 
The user will need to enter the itemID they want update, followed by the new item name
 and new item value.

DELETE: This function will ask for an ID to enter depending on what option you chose. 
The ID that is selected will be removed along with all other values for that entry
### Prerequisites

What things you need to install the software and how to install them

```

IDE - I used Eclispe
Java - 1.8 or higher
SQL - 5.7 or higher
```



### Unit Tests 

JUNIT tests are used to test each method that is used within my project.
Each test case will verify if the intented outcome is equal to the actual outcome using assertEquals(param1,param2).
```
Example
        @Test
	public void testCreate() {
		final Customer created = new Customer(4L, "chris", "perrins");
		assertEquals(created, DAO.create(created));
	}

```

### jira link
https://has251.atlassian.net/jira/software/projects/IMS/boards/3/roadmap

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

I would like to thank jordon for his customer demo example
i would like to thank ed for his help
and i would like to thank my fianace for her being there when i started to stress

