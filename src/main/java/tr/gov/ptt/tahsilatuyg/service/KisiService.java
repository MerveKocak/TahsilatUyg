package tr.gov.ptt.tahsilatuyg.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import tr.gov.ptt.tahsilatuyg.entity.Kisi;
import tr.gov.ptt.tahsilatuyg.facade.KisiFacade;

@Stateless
public class KisiService {
    @Inject
    private KisiFacade kisiFacade;
    public Kisi girisKontrol(Kisi p_kisi)
    {
        return kisiFacade.girisKontrol(p_kisi);
    }
}
