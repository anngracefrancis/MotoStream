package cm.aptoide.pt.home.bundles.base;

import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.dataprovider.model.v7.Event;
import cm.aptoide.pt.view.app.ApplicationGraphic;

/* JADX INFO: loaded from: classes.dex */
public class VersionPromotionalBundle extends PromotionalBundle {
    private final String versionName;

    public VersionPromotionalBundle(String str, HomeBundle.BundleType bundleType, Event event, String str2, ApplicationGraphic applicationGraphic, String str3, DownloadModel downloadModel) {
        super(str, bundleType, event, str2, applicationGraphic, downloadModel);
        this.versionName = str3;
    }

    public String getVersionName() {
        return this.versionName;
    }
}
