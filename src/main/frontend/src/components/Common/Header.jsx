import { faCheckSquare, faSpinner } from "@fortawesome/free-solid-svg-icons";
import { faSquare } from "@fortawesome/free-regular-svg-icons";
import styled from "styled-components";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faApple } from "@fortawesome/free-brands-svg-icons";
import { faBars, faUser, faTimes } from "@fortawesome/free-solid-svg-icons";

const Header = () => {
    return (
        <header>
            <div className="logo">
                <FontAwesomeIcon icon={faApple} size="2x"/>
            </div>

            <nav>
                <ul>
                    <li>메뉴1</li>
                    <li>2</li>
                    <li>3</li>
                </ul>
            </nav>
        </header>
    )
}
export default Header