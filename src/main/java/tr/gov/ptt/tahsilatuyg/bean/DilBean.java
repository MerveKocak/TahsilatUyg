package tr.gov.ptt.tahsilatuyg.bean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "dilBean")
@ViewScoped
public class DilBean implements Serializable {

    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    private String dilKodu;
    private static Map<String, Object> ulkeler;

    static {
        ulkeler = new LinkedHashMap<String, Object>();
        ulkeler.put("Türkçe", new Locale("tr", "TR"));
        ulkeler.put("English", Locale.ENGLISH); //label(key), value

    }

    public Map<String, Object> getUlkeler() {
        return ulkeler;
    }

    public DilBean() {
    }

    public String getDilKodu() {
        return dilKodu;
    }

    public void setDilKodu(String dilKodu) {
        this.dilKodu = dilKodu;
    }

    //value change event listener
    public void ulkeDilKoduDegistir() {
        FacesContext.getCurrentInstance()
                .getViewRoot().setLocale(new Locale(dilKodu));
//Gereksiz
//        //loop country map to compare the locale code
//        for (Map.Entry<String, Object> entry : ulkeler.entrySet()) {
//
//            if (entry.getValue().toString().equals(dilKodu)) {
//
//                FacesContext.getCurrentInstance()
//                        .getViewRoot().setLocale(new Locale(dilKodu));
//
//            }
//        }
    }

    public void changeLanguage(String p_language) {
        locale = new Locale(p_language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);

    }

}
