const mongoose = require('mongoose')

const invoiceSchema = new mongoose.Schema({

  
    invoiceId:{
            type:Number,
            required:true
    },
    info:[{
            name:String,
            surname:String
        
        }]
    
})

module.exports = mongoose.model('Invoice', invoiceSchema)

