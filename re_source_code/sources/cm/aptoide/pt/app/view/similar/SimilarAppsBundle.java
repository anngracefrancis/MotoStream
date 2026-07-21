package cm.aptoide.pt.app.view.similar;

import cm.aptoide.pt.app.SimilarAppsViewModel;

/* JADX INFO: loaded from: classes.dex */
public class SimilarAppsBundle {
    private final BundleType bundleType;
    private final SimilarAppsViewModel model;

    public enum BundleType {
        APPS,
        APPC_APPS
    }

    public SimilarAppsBundle(SimilarAppsViewModel similarAppsViewModel, BundleType bundleType) {
        this.model = similarAppsViewModel;
        this.bundleType = bundleType;
    }

    public SimilarAppsViewModel getContent() {
        return this.model;
    }

    public BundleType getType() {
        return this.bundleType;
    }
}
