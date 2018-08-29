# SpringBoot with Cassandra

This application uses Cassandra DB. Since the purpose of this application is to provide micro services to an online store as a Catalogue Master. 
There will be 2 tables that will be automatically created when you start up the appilication as we are using JPA.
1. PLANS - this table will hold all the plans(post paid, pre paid, voice, sms , 3G/4G etc..)
2. PRODUCTS - this table will hold all the products(smartphone, dongles, warranty, subscriptions)

##Sample Create Plan Json
{
    "productId": "200-1004",
    "productName": "499 prepaid plan",
    "shortDesc": "prepaid plan",
    "longDesc": "499 prepaid plan",
    "unitPrice": 499,
    "retailPrice": 499,
    "category": "499 Prepaid plan",
    "regions": "Delhi",
    "dimensions": "",
    "createTs": null,
    "modifyTs": null,
    "createProgId": "admin",
    "modifyProgId": ""
}

##Sample Create Product Json

{
    "productId": "100-1001",
    "productName": "iPhone",
    "shortDesc": "i-phone",
    "longDesc": "apple i-phone",
    "unitPrice": 125,
    "retailPrice": 100,
    "category": "mobile",
    "subCategory": "smartphone",
    "dimensions": "10*5*5",
    "createTs": null,
    "modifyTs": null,
    "createProgId": "admin",
    "modifyProgId": ""
}

You can find all the services and their usage in the swagger UI.
