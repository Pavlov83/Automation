import React,{useState} from 'react';
import axios from 'axios'
import Button from 'react-bootstrap/Button'
import "bootstrap/dist/css/bootstrap.min.css"


function CreateSubscriber(){

    const[input, setInput] = useState(
        {
            name: '',
            subscriberDetails: '',
            invoices:[]
        }
    )

    function handleChange(event){

        const {name,value} = event.target;

        setInput(prevInput =>{
            return{
                ...prevInput,
                [name]: value
            }
        })
    }

    function handleClick(event){
        event.preventDefault();
        const newSub = {
           name: input.name,
           subscriberDetails: input.subscriberDetails,
           invoices:[]
         
        }

        axios.post("/subscribers/",newSub)
    }


    return <div className='container'>
        <h1>Create Subscriber</h1>
        <form>

        <div  className="form-group">
            <input onChange={handleChange} name='name' value={input.title} className="form-control" placeholder="subscriber name"></input>
        </div>

        <div>
            <textarea onChange={handleChange} name='subscriberDetails' value={input.content} className="form-control" placeholder="subs details"></textarea>
        </div>

        <Button onClick={handleClick}>ADD SUB</Button>
        </form>
    </div>


}

export default CreateSubscriber