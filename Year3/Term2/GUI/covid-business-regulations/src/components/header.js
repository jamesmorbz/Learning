import React from "react";
import { House } from '@mui/icons-material';

const Header = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light">

            <House> </House>
            <div class="mx-auto">
                Covid Business Regulations
            </div>           
            <p class="d-flex ms-auto order-5">Login</p>
        </nav>
    );
};

export default Header;