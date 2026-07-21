package cm.aptoide.pt.dataprovider.ws.v7.home;

import cm.aptoide.pt.bonus.BonusAppcModel;
import cm.aptoide.pt.dataprovider.model.v7.ListApps;

/* JADX INFO: loaded from: classes.dex */
public class BonusAppcBundle {
    private final BonusAppcModel bonusAppcModel;
    private final ListApps listApps;

    public BonusAppcBundle(ListApps listApps, BonusAppcModel bonusAppcModel) {
        this.listApps = listApps;
        this.bonusAppcModel = bonusAppcModel;
    }

    public BonusAppcModel getBonusAppcModel() {
        return this.bonusAppcModel;
    }

    public ListApps getListApps() {
        return this.listApps;
    }
}
