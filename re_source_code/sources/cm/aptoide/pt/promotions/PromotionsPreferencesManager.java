package cm.aptoide.pt.promotions;

import cm.aptoide.pt.appview.PreferencesPersister;
import cm.aptoide.pt.preferences.managed.ManagedKeys;

/* JADX INFO: loaded from: classes.dex */
public class PromotionsPreferencesManager {
    private PreferencesPersister preferencesPersister;

    public PromotionsPreferencesManager(PreferencesPersister preferencesPersister) {
        this.preferencesPersister = preferencesPersister;
    }

    public void setPromotionsDialogShown() {
        this.preferencesPersister.save(ManagedKeys.SHOW_PROMOTIONS_DIALOG, false);
    }

    public boolean shouldShowPromotionsDialog() {
        return this.preferencesPersister.get(ManagedKeys.SHOW_PROMOTIONS_DIALOG, true);
    }
}
