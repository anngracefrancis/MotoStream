package cm.aptoide.pt.home.bundles.editorial;

import android.view.View;
import cm.aptoide.pt.home.bundles.base.AppBundleViewHolder;
import cm.aptoide.pt.home.bundles.base.HomeBundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class EditorialViewHolder extends AppBundleViewHolder {
    public EditorialViewHolder(View view) {
        super(view);
    }

    @Override // cm.aptoide.pt.home.bundles.base.AppBundleViewHolder
    public abstract void setBundle(HomeBundle homeBundle, int i2);
}
