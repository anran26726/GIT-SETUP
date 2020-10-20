const express = require('express');
const app = express();

// const userList = require('src/database/schema.js');

// userList.find((error, users) => {
//     if (error) {
//         console.log(error);
//     }
//     else {
//         console.log(users)
//     }
// });

const data = [
    'Sunnyvale',
    'Palo Alto',
    'San Jose',
    'San Francisco',
    'San Diego',
    'New York'
];

const userList = [
    {
        id: 1,
        firstname: "test1",
        lastname: "test1",
        age: 1,
        sex: 'male'
    },
    {
        id: 2,
        firstname: "test2",
        lastname: "test2",
        age: 2,
        sex: 'male'
    },
    {
        id: 3,
        firstname: "test3",
        lastname: "test3",
        age: 3,
        sex: 'female'
    },
    {
        id: 4,
        firstname: "test4",
        lastname: "test4",
        age: 4,
        sex: 'female'
    },
    {
        id: 5,
        firstname: "test5",
        lastname: "test5",
        age: 5,
        sex: 'male'
    },
    {
        id: 6,
        firstname: "test6",
        lastname: "test6",
        age: 6,
        sex: 'male'
    },
    {
        id: 7,
        firstname: "test7",
        lastname: "test7",
        age: 7,
        sex: 'female'
    },
    {
        id: 8,
        firstname: "test8",
        lastname: "test8",
        age: 8,
        sex: 'female'
    },
    {
        id: 9,
        firstname: "test9",
        lastname: "test9",
        age: 9,
        sex: 'female'
    },
    {
        id: 10,
        firstname: "test10",
        lastname: "test10",
        age: 10,
        sex: 'male'
    }
];

app.use((req, res, next) => {
    console.log("A request is received");
    next();
});

app.get('/api/cities/:cityName', (req, res) => {
    const { cityName } = req.params;
    if (!cityName) {
        return res.status(200).json({ payload: [] });
    }
    const regex = new RegExp(cityName, 'ig');
    const responsePayload = data.filter(city => city.match(regex));

    return res.status(200).json({ payload: responsePayload });
});

app.get('/api/userlist/:user', (req, res) => {
    try {
        const { user } = req.params;
        if (!user) {
            return res.status(200).json({ payload: [] });
        }
        const responsePayload = userList;
    
        return res.status(200).json({ payload: responsePayload });
    } catch {
        return res.status(500).json({error: 'unhandled error'});
    }
    
});

app.listen(5000, () => {
    console.log("server is up and running on port 5000.");
});
