import React,{useState, useEffect} from 'react'
import axios from 'axios'

function DataFetching(){
    const [subscribers,getSubscribers] = useState([])

    useEffect(() =>{
        axios.get('/subscribers')
        .then(res => getSubscribers(res.data))
        .catch(err => console.log(err))



    },[])

    return(
        <div>
            {
                subscribers.map(sub => <li key={sub._id}>{sub.name} and {sub.subscriberDetails}{sub.invoices.invoiceId }</li>)
            }
        </div>
    )
}

export default DataFetching;