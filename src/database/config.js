const mongoose = require('mongoose');

const db = mongoose.connection;

mongoose.connect('mongodb://127.0.0.1:27017/test', {useNewUrlParser: true});

db.once('open', function() {
  console.log('mongodb connected.');
}).on('error', (error) => {
    console.log("errorMessage", error);
});