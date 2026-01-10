import React from "react";
import Logo from "../assets/Logo";
import Input from '@mui/joy/Input';
import Button from '@mui/joy/Button';
import { Outlet } from "react-router";


function PageHead() {

    return(
        <div style={{ display: "flex", alignItems: "center" }}>
            <Logo />

            <Input 
                type="text" 
                placeholder="Search..." 
                style={{ flexGrow: 1, margin: "0 10px" }} 
            />
            <Button variant="outlined">Search</Button>
            <div style={{ paddingTop: "16px" }}>
                <Outlet />
            </div>
        </div>
    );

}

export default PageHead