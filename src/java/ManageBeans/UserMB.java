/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jairo
 */
@ManagedBean
@SessionScoped
public class UserMB {

    /**
     * Creates a new instance of UserManageBeans
     */
    private String code;

    public UserMB() {
        code = "XULES-CODE";
        System.out.println("Validation code (Código de validación): " + code);
    }

    private String user;
    private String nickName;
    private String email;
    private String validationCode;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public String getValidation() {
        if ((validationCode != null) && (validationCode.compareTo(code) == 0)) {
            // The validationCode is OK then we show the user data in validation.xhtml
            // El código validationCode es correcto entonces mostramos los datos en validation.xhtm
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.invalidate();
            String styles = "<html><style>"
                    + "    body {"
                    + "        text-align: center;"
                    + "        background:#59ABE3;margin:0;"
                    + "        font-family:'Segoe UI',sans-serif;"
                    + "    }"
                    + "    div {"
                    + "        width: 340px;"
                    + "        height: 320px;"
                    + "        background: #e6e6e6;"
                    + "        border-radius: 8px;"
                    + "        box-shadow: 0 0 40px -10px #000;"
                    + "        margin: calc(50vh - 220px) auto;"
                    + "        padding: 20px 30px;"
                    + "        max-width: calc(100vw - 40px);"
                    + "        box-sizing: border-box;"
                    + "        position: relative;margin-top:0;margin-bottom:0"
                    + "    }"
                    + ""
                    + "</style>";

            return styles
                    + "<body><div><h2>Usuario aceptado:</h2>"
                    + " <h2>Usuario: " + getUser() + " </h2>"
                    + " <h2>Nombre Usuario: " + getNickName() + " </h2>"
                    + " <h2>Email: " + getEmail() + " </h2>"
                    + "</div></body></html>";
        } else {
            String styles = "<html><style>"
                    + "    body {"
                    + "        text-align: center;"
                    + "        background:#59ABE3;margin:0;"
                    + "        font-family:'Segoe UI',sans-serif;"
                    + "    }"
                    + "    div {"
                    + "        width: 340px;"
                    + "        height: 200px;"
                    + "        background: #e6e6e6;"
                    + "        border-radius: 8px;"
                    + "        box-shadow: 0 0 40px -10px #000;"
                    + "        margin: calc(50vh - 220px) auto;"
                    + "        padding: 20px 30px;"
                    + "        max-width: calc(100vw - 40px);"
                    + "        box-sizing: border-box;"
                    + "        position: relative;margin-top:0;margin-bottom:0"
                    + "    }"
                    + ""
                    + "</style>";
            return styles+"<body><div><p>Lo sentimos el codigo, " + validationCode.toString() + " no es valido.</p>"
                    + "<p>Intentalo de nuevo...</p></div></body></html>";
        }
    }
}
