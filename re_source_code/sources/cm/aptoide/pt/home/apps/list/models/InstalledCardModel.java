package cm.aptoide.pt.home.apps.list.models;

import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.home.apps.model.InstalledApp;
import cm.aptoide.pt.networking.image.ImageLoader;
import com.airbnb.epoxy.t;
import e.c.a.a.a.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: InstalledCardModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcm/aptoide/pt/home/apps/list/models/InstalledCardModel;", "Lcom/airbnb/epoxy/EpoxyModelWithHolder;", "Lcm/aptoide/pt/home/apps/list/models/InstalledCardModel$CardHolder;", "()V", "application", "Lcm/aptoide/pt/home/apps/model/InstalledApp;", "getApplication", "()Lcm/aptoide/pt/home/apps/model/InstalledApp;", "setApplication", "(Lcm/aptoide/pt/home/apps/model/InstalledApp;)V", "bind", HttpUrl.FRAGMENT_ENCODE_SET, "holder", "CardHolder", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class InstalledCardModel extends t<CardHolder> {
    private InstalledApp application;

    /* JADX INFO: compiled from: InstalledCardModel.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\f¨\u0006\u0011"}, d2 = {"Lcm/aptoide/pt/home/apps/list/models/InstalledCardModel$CardHolder;", "Lcom/fa/epoxysample/bundles/models/base/BaseViewHolder;", "()V", "appIcon", "Landroid/widget/ImageView;", "getAppIcon", "()Landroid/widget/ImageView;", "appIcon$delegate", "Lkotlin/properties/ReadOnlyProperty;", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "name$delegate", "version", "getVersion", "version$delegate", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CardHolder extends BaseViewHolder {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {g0.h(new y(CardHolder.class, "name", "getName()Landroid/widget/TextView;", 0)), g0.h(new y(CardHolder.class, "appIcon", "getAppIcon()Landroid/widget/ImageView;", 0)), g0.h(new y(CardHolder.class, "version", "getVersion()Landroid/widget/TextView;", 0))};
        private final ReadOnlyProperty name$delegate = bind(R.id.apps_installed_app_name);
        private final ReadOnlyProperty appIcon$delegate = bind(R.id.apps_installed_icon);
        private final ReadOnlyProperty version$delegate = bind(R.id.apps_installed_app_version);

        public final ImageView getAppIcon() {
            return (ImageView) this.appIcon$delegate.a(this, $$delegatedProperties[1]);
        }

        public final TextView getName() {
            return (TextView) this.name$delegate.a(this, $$delegatedProperties[0]);
        }

        public final TextView getVersion() {
            return (TextView) this.version$delegate.a(this, $$delegatedProperties[2]);
        }
    }

    public final InstalledApp getApplication() {
        return this.application;
    }

    public final void setApplication(InstalledApp installedApp) {
        this.application = installedApp;
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void bind(CardHolder holder) {
        m.f(holder, "holder");
        InstalledApp installedApp = this.application;
        if (installedApp != null) {
            holder.getName().setText(installedApp.getAppName());
            ImageLoader.with(holder.getItemView().getContext()).load(installedApp.getIcon(), holder.getAppIcon());
            holder.getVersion().setText(installedApp.getVersion());
        }
    }
}
