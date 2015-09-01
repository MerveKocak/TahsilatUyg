package tr.gov.ptt.tahsilatuyg.bean;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import tr.gov.ptt.tahsilatuyg.entity.Kisi;
import tr.gov.ptt.tahsilatuyg.service.KisiService;
import tr.gov.ptt.util.JSFUtil;

@Named(value = "kisiBean")
@SessionScoped
public class KisiBean implements Serializable {

    @Inject
    private KisiService kisiService;
    private Kisi kisi;

    public KisiBean() {
        kisi = new Kisi();
        kisi.setTema("bluesky");
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public String girisKontrol() {
        ResourceBundle mesajlar = FacesContext.getCurrentInstance().
                getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "msg");
                
        Kisi vtKisi = kisiService.girisKontrol(this.kisi);
        if (vtKisi != null) {
            this.kisi = vtKisi;
            HttpSession session = JSFUtil.getSession();
            session.setAttribute("kullanici", this.kisi.getKullaniciAd());
            return "menu.xhtml?faces-redirect=true";
        } else {
            kisi = new Kisi();
            JSFUtil.hataGoster(mesajlar.getString("tahsilatuyg.giris.loginErrorSummary"),
                    mesajlar.getString("tahsilatuyg.giris.loginErrorDetail"));
            return "";
        }
    }

    public String guvenliCikis() {
        HttpSession session = JSFUtil.getSession();
        JSFUtil.sessionBitir(session);
        JSFUtil.mesajGoster("Oturumunuz sonlandı.", "Yeniden giriş yapınız");
        return "giris.xhtml?faces-redirect=true";
    }

}
