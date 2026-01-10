import React from "react";
import Logo from "../assets/Logo";
import Input from '@mui/joy/Input';
import Button from '@mui/joy/Button';
import { Outlet } from "react-router";
import SearchBar from "./SearchBar";


function PageHead() {

    return(
        <div style={{ display: "flex", alignItems: "center" }}>
            <Logo />
            <SearchBar />
            <div style={{ paddingTop: "16px" }}>
                <Outlet />
            </div>
        </div>
    );

}

export default PageHead