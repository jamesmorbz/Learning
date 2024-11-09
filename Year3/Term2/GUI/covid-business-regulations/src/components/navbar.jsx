import React from "react";
import { Dropdown } from "semantic-ui-react";
import { Link } from "react-router-dom"

const officeLocations = [
    { key: "London", text: "London", value: "LDN", flag: "gb" },
    { key: "Birmingham", text: "Birmingham", value: "BRM", flag: "gb" },
    { key: "Madrid", text: "Madrid", value: "MDR", flag: "es" },
    { key: "Bangalore", text: "Bangalore", value: "BGL", flag: "in" }
];

const value = "LDN"

const Navbar = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <button
                className="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown"
                aria-expanded="false"
                aria-label="Toggle navigation"
            >
                <span className="navbar-toggler-icon"></span>
            </button>

            <div className="collapse navbar-collapse" id="navbarNavDropdown">
                <ul className="navbar-nav">
                    <li className="nav-item active">
                        <a className="nav-link" href="#">
                            Home <span className="sr-only">(current)</span>
                        </a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#">
                            Government Regulations
                        </a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#">
                            Pandemic Guidelines
                        </a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#">
                            Compliance Training
                        </a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="#">
                            Important Dates
                        </a>
                    </li>
                    <li className="nav-item dropdown">
                        <a
                            className="nav-link dropdown-toggle"
                            href="#"
                            id="navbarDropdownMenuLink"
                            data-toggle="dropdown"
                            aria-haspopup="true"
                            aria-expanded="false"
                        >
                            Dropdown link
                        </a>
                        <div
                            className="dropdown-menu"
                            aria-labelledby="navbarDropdownMenuLink"
                        >
                            <a className="dropdown-item" href="#">
                                Action
                            </a>
                            <a className="dropdown-item" href="#">
                                Another action
                            </a>
                            <a className="dropdown-item" href="#">
                                Something else here
                            </a>
                        </div>
                    </li>
                </ul>
            </div>
            <Dropdown
                placeholder='Select Country'
                fluid
                search
                selection
                options={officeLocations}>
                <Dropdown.Menu>
                    {officeLocations.map(country => {
                        return (
                            <Dropdown.Item
                                key={country.key}
                                value={country.value}
                                active={(value === country.value)}
                                flag={country.flag}
                                onClick={console.log}
                            />)
                    })}
                </Dropdown.Menu>
            </Dropdown>
        </nav>
    );
};

export default Navbar;