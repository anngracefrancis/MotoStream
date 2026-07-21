package cm.aptoide.pt.home.bundles.base;

import cm.aptoide.pt.view.app.Application;

/* JADX INFO: loaded from: classes.dex */
public class AppHomeEvent extends HomeEvent {
    private final Application app;
    private final int appPosition;

    public AppHomeEvent(Application application, int i2, HomeBundle homeBundle, int i3, HomeEvent.Type type) {
        super(homeBundle, i3, type);
        this.app = application;
        this.appPosition = i2;
    }

    public Application getApp() {
        return this.app;
    }

    public int getAppPosition() {
        return this.appPosition;
    }
}
