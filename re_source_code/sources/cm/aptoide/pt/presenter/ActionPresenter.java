package cm.aptoide.pt.presenter;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ActionPresenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H$J\u001c\u0010\u0010\u001a\u00020\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\n\u001a\u00020\u000bR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcm/aptoide/pt/presenter/ActionPresenter;", "T", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "eventObservable", "Lrx/Observable;", "getEventObservable", "()Lrx/Observable;", "setEventObservable", "(Lrx/Observable;)V", "lifecycleView", "Lcm/aptoide/pt/presenter/View;", "getLifecycleView", "()Lcm/aptoide/pt/presenter/View;", "setLifecycleView", "(Lcm/aptoide/pt/presenter/View;)V", "present", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ActionPresenter<T> {
    protected rx.e<T> eventObservable;
    protected View lifecycleView;

    protected final rx.e<T> getEventObservable() {
        rx.e<T> eVar = this.eventObservable;
        if (eVar != null) {
            return eVar;
        }
        kotlin.jvm.internal.m.w("eventObservable");
        return null;
    }

    protected final View getLifecycleView() {
        View view = this.lifecycleView;
        if (view != null) {
            return view;
        }
        kotlin.jvm.internal.m.w("lifecycleView");
        return null;
    }

    protected abstract void present();

    public final void present(rx.e<T> eVar, View view) {
        kotlin.jvm.internal.m.f(eVar, "eventObservable");
        kotlin.jvm.internal.m.f(view, "lifecycleView");
        setEventObservable(eVar);
        setLifecycleView(view);
        present();
    }

    protected final void setEventObservable(rx.e<T> eVar) {
        kotlin.jvm.internal.m.f(eVar, "<set-?>");
        this.eventObservable = eVar;
    }

    protected final void setLifecycleView(View view) {
        kotlin.jvm.internal.m.f(view, "<set-?>");
        this.lifecycleView = view;
    }
}
