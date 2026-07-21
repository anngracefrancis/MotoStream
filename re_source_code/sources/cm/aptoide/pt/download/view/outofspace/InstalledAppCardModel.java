package cm.aptoide.pt.download.view.outofspace;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.utils.AptoideUtils;
import e.c.a.a.a.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: InstalledAppCardModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcm/aptoide/pt/download/view/outofspace/InstalledAppCardModel;", "Lcom/airbnb/epoxy/EpoxyModelWithHolder;", "Lcm/aptoide/pt/download/view/outofspace/InstalledAppCardModel$CardHolder;", "()V", "application", "Lcm/aptoide/pt/download/view/outofspace/InstalledApp;", "getApplication", "()Lcm/aptoide/pt/download/view/outofspace/InstalledApp;", "setApplication", "(Lcm/aptoide/pt/download/view/outofspace/InstalledApp;)V", "eventSubject", "Lrx/subjects/PublishSubject;", HttpUrl.FRAGMENT_ENCODE_SET, "getEventSubject", "()Lrx/subjects/PublishSubject;", "setEventSubject", "(Lrx/subjects/PublishSubject;)V", "bind", HttpUrl.FRAGMENT_ENCODE_SET, "holder", "handleUninstallClick", "app", "CardHolder", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class InstalledAppCardModel extends com.airbnb.epoxy.t<CardHolder> {
    private InstalledApp application;
    private rx.s.b<String> eventSubject;

    /* JADX INFO: compiled from: InstalledAppCardModel.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0011\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0012\u0010\f¨\u0006\u0014"}, d2 = {"Lcm/aptoide/pt/download/view/outofspace/InstalledAppCardModel$CardHolder;", "Lcom/fa/epoxysample/bundles/models/base/BaseViewHolder;", "()V", "appIcon", "Landroid/widget/ImageView;", "getAppIcon", "()Landroid/widget/ImageView;", "appIcon$delegate", "Lkotlin/properties/ReadOnlyProperty;", "appSize", "Landroid/widget/TextView;", "getAppSize", "()Landroid/widget/TextView;", "appSize$delegate", "name", "getName", "name$delegate", "uninstallButton", "getUninstallButton", "uninstallButton$delegate", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CardHolder extends BaseViewHolder {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {kotlin.jvm.internal.g0.h(new kotlin.jvm.internal.y(CardHolder.class, "appIcon", "getAppIcon()Landroid/widget/ImageView;", 0)), kotlin.jvm.internal.g0.h(new kotlin.jvm.internal.y(CardHolder.class, "name", "getName()Landroid/widget/TextView;", 0)), kotlin.jvm.internal.g0.h(new kotlin.jvm.internal.y(CardHolder.class, "appSize", "getAppSize()Landroid/widget/TextView;", 0)), kotlin.jvm.internal.g0.h(new kotlin.jvm.internal.y(CardHolder.class, "uninstallButton", "getUninstallButton()Landroid/widget/TextView;", 0))};
        private final ReadOnlyProperty appIcon$delegate = bind(R.id.app_icon);
        private final ReadOnlyProperty name$delegate = bind(R.id.app_name);
        private final ReadOnlyProperty appSize$delegate = bind(R.id.app_size);
        private final ReadOnlyProperty uninstallButton$delegate = bind(R.id.uninstall_button);

        public final ImageView getAppIcon() {
            return (ImageView) this.appIcon$delegate.a(this, $$delegatedProperties[0]);
        }

        public final TextView getAppSize() {
            return (TextView) this.appSize$delegate.a(this, $$delegatedProperties[2]);
        }

        public final TextView getName() {
            return (TextView) this.name$delegate.a(this, $$delegatedProperties[1]);
        }

        public final TextView getUninstallButton() {
            return (TextView) this.uninstallButton$delegate.a(this, $$delegatedProperties[3]);
        }
    }

    private final void handleUninstallClick(CardHolder holder, final InstalledApp app) {
        holder.getUninstallButton().setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.download.view.outofspace.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InstalledAppCardModel.m111handleUninstallClick$lambda1(this.f5128f, app, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleUninstallClick$lambda-1, reason: not valid java name */
    public static final void m111handleUninstallClick$lambda1(InstalledAppCardModel installedAppCardModel, InstalledApp installedApp, View view) {
        kotlin.jvm.internal.m.f(installedAppCardModel, "this$0");
        kotlin.jvm.internal.m.f(installedApp, "$app");
        rx.s.b<String> bVar = installedAppCardModel.eventSubject;
        if (bVar != null) {
            bVar.onNext(installedApp.getPackageName());
        }
    }

    public final InstalledApp getApplication() {
        return this.application;
    }

    public final rx.s.b<String> getEventSubject() {
        return this.eventSubject;
    }

    public final void setApplication(InstalledApp installedApp) {
        this.application = installedApp;
    }

    public final void setEventSubject(rx.s.b<String> bVar) {
        this.eventSubject = bVar;
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void bind(CardHolder holder) {
        kotlin.jvm.internal.m.f(holder, "holder");
        InstalledApp installedApp = this.application;
        if (installedApp != null) {
            holder.getName().setText(installedApp.getAppName());
            ImageLoader.with(holder.getItemView().getContext()).load(installedApp.getIcon(), holder.getAppIcon());
            holder.getAppSize().setText(AptoideUtils.StringU.formatBytes(installedApp.getSize(), false));
            handleUninstallClick(holder, installedApp);
        }
    }
}
