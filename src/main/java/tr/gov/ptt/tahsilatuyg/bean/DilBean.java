
package tr.gov.ptt.tahsilatuyg.bean;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "dilBean")
@ViewScoped
public class DilBean implements Serializable{
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public void changeLanguage(String p_language) {
        locale = new Locale(p_language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        
    }
    
}
