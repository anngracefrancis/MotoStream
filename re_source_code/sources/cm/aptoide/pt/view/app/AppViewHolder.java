package cm.aptoide.pt.view.app;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.home.bundles.base.HomeBundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppViewHolder extends RecyclerView.c0 {
    public AppViewHolder(View view) {
        super(view);
    }

    public abstract void setApp(Application application, HomeBundle homeBundle, int i2);
}
