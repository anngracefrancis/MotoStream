package cm.aptoide.pt.home.apps;

/* JADX INFO: loaded from: classes.dex */
public class AppClickEventWrapper {
    private App app;
    private boolean isAppcUpgrade;

    public AppClickEventWrapper(boolean z, App app) {
        this.isAppcUpgrade = z;
        this.app = app;
    }

    public App getApp() {
        return this.app;
    }

    public boolean isAppcUpgrade() {
        return this.isAppcUpgrade;
    }
}
