package cm.aptoide.pt.home.bundles.base;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppBundleViewHolder extends RecyclerView.c0 {
    public AppBundleViewHolder(View view) {
        super(view);
    }

    public abstract void setBundle(HomeBundle homeBundle, int i2);
}
