import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";

/*This is a page that will ask the user to input the values for Account in the back end.

fields are: email (textbox), accountName (textbox), prefersDub (checkbox), prefersSub (checkbox)

then a button to submit the form to the back end via axios POST request to /accounts endpoint.*/

function CreateAccountPage(){
    const [accountName, setAccountName] = useState(null);
    const [email, setEmail] = useState(null);
    const [prefersDub, setPrefersDub] = useState(false);
    const [prefersSub, setPrefersSub] = useState(false);
    return (
        <div>
            <form>
                <label htmlFor="email">Email</label>
                <input id="email" type="text" name="email" /><br></br>
                <label htmlFor="accountName">Account Name</label>
                <input name="accountName" />
            </form> 
            <label htmlFor="prefersDub">Do you like dub?</label>
            <input type="checkbox" />
            <label htmlFor="prefersSub">Do you like sub?</label>
            <input type="checkbox" />
            
            <br></br>
            
            <button type="submit">Create Online Account</button>
        </div>
    );
} 


export default CreateAccountPage;