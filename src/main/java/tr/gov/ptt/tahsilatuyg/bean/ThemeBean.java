
package tr.gov.ptt.tahsilatuyg.bean;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ThemeBean implements Serializable{
    private List<String> temaListesi;

    public ThemeBean() {
    }

    public List<String> getTemaListesi() {
        return temaListesi;
    }

    public void setTemaListesi(List<String> temaListesi) {
        this.temaListesi = temaListesi;
    }
    
}
