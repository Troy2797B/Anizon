import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import Button from '@mui/joy/Button';
import ToggleButtonGroup from '@mui/joy/ToggleButtonGroup';
import Input from '@mui/joy/Input';
import IconButton from '@mui/joy/IconButton';
import FormatBoldIcon from '@mui/icons-material/FormatBold';
import FormatItalicIcon from '@mui/icons-material/FormatItalic';
import FormatUnderlinedIcon from '@mui/icons-material/FormatUnderlined';
import Checkbox from "@mui/joy/Checkbox";

/*This is a page that will ask the user to input the values for Account in the back end.

fields are: email (textbox), accountName (textbox), prefersDub (checkbox), prefersSub (checkbox)

then a button to submit the form to the back end via axios POST request to /accounts endpoint.*/

function CreateAccountPage(){
    const [accountName, setAccountName] = useState("");
    const [prefersDub, setPrefersDub] = useState(true);
    const [prefersSub, setPrefersSub] = useState(true);
    const [email, setEmail] = useState("");
    const [value, setValue] = React.useState<string | null>('default');
    //speaks to the backend in order to add the account to the database
    const handleCreateOnlineAccount = async () => {
        console.log('clicked!')
    //tells the backend what the DTO values are for the fields
        const accountObject = {
            email: email,
            accountName: accountName,
            prefersDub: prefersDub,
            prefersSub: prefersSub
        };
        console.log("accountObject:", accountObject);
    //axios POST request to /accounts endpoint
        try {
            const response = await axios.post("http://localhost:8080/accounts", accountObject);
            console.log("Account created.", response.data);
        // TODO: add routing redirect to Homepage
        } 
    //if this doesn't work, then throw the error
        catch (error){
            console.error("Error creating account", error);
        } finally {
            console.log("Request complete.")
        }
    }
    return (
        //the inputs and checkboxes update the state, while the button will call on the function to speak with the backend once it is done.
        <div>
            <Input
                id="email"
                name="email"
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />
                <br></br>
            <Input
                id="accountName"
                name="accountName"
                placeholder="Username"
                value={accountName}
                onChange={(e) => setAccountName(e.target.value)}
            />
            <Checkbox 
            label="I like dubbed anime!" 
            defaultChecked
            checked={prefersDub}
            onChange={(e) => setPrefersDub(e.target.checked)}
            /> 
            <div></div>
            <Checkbox
                label="I like subtitled anime!"
                defaultChecked
                checked={prefersSub}
                onChange={(e) => setPrefersSub(e.target.checked)}
            />

            {/* <ToggleButtonGroup 
                value={value}
                onChange={(event, newValue) => {
                    setValue(newValue);
                }}>
                <Button value={prefersDub} onClick={handleSubmit}>I prefer dubbed shows.</Button>
                <Button value="prefersSub" onClick={handleSubmit}>I prefer subbed shows.</Button>
                <Button value="indifferent" onClick={handleSubmit}>Doesn't matter!</Button>
            </ToggleButtonGroup> */}
            
            <br></br>
            
            <Button 
            type="submit" 
            size="lg" 
            variant="soft"
            onClick={handleCreateOnlineAccount}>Create Online Account</Button>
            
        </div>
    );
} 


export default CreateAccountPage;