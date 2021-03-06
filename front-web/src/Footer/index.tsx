import './styles.css';
import { ReactComponent as IconInstagram} from './instagram.svg';
import { ReactComponent as IconLinkedin} from './linkedin.svg';
import { ReactComponent as IconYoutube} from './youtube.svg';


function Footer() {
    return (
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className="footer-icons">
                <a href="https://www.youtube.com" target="_new">
                    <IconYoutube />
                </a>
                <a href="https://www.linkedin.com" target="_new">
                    <IconLinkedin />
                </a>
                <a href="https://www.instagram.com" target="_new">
                    <IconInstagram />
                </a>
            </div>
        </footer>
    )
}

export default Footer;