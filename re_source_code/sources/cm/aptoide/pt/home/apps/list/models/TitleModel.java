package cm.aptoide.pt.home.apps.list.models;

import android.view.View;
import android.widget.TextView;
import cm.aptoide.pt.R;
import com.airbnb.epoxy.t;
import e.c.a.a.a.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: TitleModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0016R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcm/aptoide/pt/home/apps/list/models/TitleModel;", "Lcom/airbnb/epoxy/EpoxyModelWithHolder;", "Lcm/aptoide/pt/home/apps/list/models/TitleModel$Holder;", "()V", "eventSubject", "Lrx/subjects/PublishSubject;", "Ljava/lang/Void;", "getEventSubject", "()Lrx/subjects/PublishSubject;", "setEventSubject", "(Lrx/subjects/PublishSubject;)V", "shouldShowButton", HttpUrl.FRAGMENT_ENCODE_SET, "getShouldShowButton", "()Z", "setShouldShowButton", "(Z)V", "title", HttpUrl.FRAGMENT_ENCODE_SET, "getTitle", "()Ljava/lang/Integer;", "setTitle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bind", HttpUrl.FRAGMENT_ENCODE_SET, "holder", "Holder", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TitleModel extends t<Holder> {
    private rx.s.b<Void> eventSubject;
    private boolean shouldShowButton;
    private Integer title;

    /* JADX INFO: compiled from: TitleModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\f"}, d2 = {"Lcm/aptoide/pt/home/apps/list/models/TitleModel$Holder;", "Lcom/fa/epoxysample/bundles/models/base/BaseViewHolder;", "()V", "button", "Landroid/widget/TextView;", "getButton", "()Landroid/widget/TextView;", "button$delegate", "Lkotlin/properties/ReadOnlyProperty;", "title", "getTitle", "title$delegate", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Holder extends BaseViewHolder {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {g0.h(new y(Holder.class, "title", "getTitle()Landroid/widget/TextView;", 0)), g0.h(new y(Holder.class, "button", "getButton()Landroid/widget/TextView;", 0))};
        private final ReadOnlyProperty title$delegate = bind(R.id.apps_header_title);
        private final ReadOnlyProperty button$delegate = bind(R.id.apps_header_button);

        public final TextView getButton() {
            return (TextView) this.button$delegate.a(this, $$delegatedProperties[1]);
        }

        public final TextView getTitle() {
            return (TextView) this.title$delegate.a(this, $$delegatedProperties[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: bind$lambda-1, reason: not valid java name */
    public static final void m162bind$lambda1(TitleModel titleModel, View view) {
        m.f(titleModel, "this$0");
        rx.s.b<Void> bVar = titleModel.eventSubject;
        if (bVar != null) {
            bVar.onNext(null);
        }
    }

    public final rx.s.b<Void> getEventSubject() {
        return this.eventSubject;
    }

    public final boolean getShouldShowButton() {
        return this.shouldShowButton;
    }

    public final Integer getTitle() {
        return this.title;
    }

    public final void setEventSubject(rx.s.b<Void> bVar) {
        this.eventSubject = bVar;
    }

    public final void setShouldShowButton(boolean z) {
        this.shouldShowButton = z;
    }

    public final void setTitle(Integer num) {
        this.title = num;
    }

    @Override // com.airbnb.epoxy.t, com.airbnb.epoxy.s
    public void bind(Holder holder) {
        m.f(holder, "holder");
        Integer num = this.title;
        if (num != null) {
            holder.getTitle().setText(holder.getItemView().getContext().getString(num.intValue()));
        }
        if (this.shouldShowButton) {
            holder.getButton().setVisibility(0);
        } else {
            holder.getButton().setVisibility(8);
        }
        holder.getButton().setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.home.apps.list.models.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitleModel.m162bind$lambda1(this.f5756f, view);
            }
        });
    }
}
