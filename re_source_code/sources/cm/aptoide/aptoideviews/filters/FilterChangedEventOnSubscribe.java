package cm.aptoide.aptoideviews.filters;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import rx.e;
import rx.j;

/* JADX INFO: compiled from: FilterChangedEventOnSubscribe.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcm/aptoide/aptoideviews/filters/FilterChangedEventOnSubscribe;", "Lrx/Observable$OnSubscribe;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/aptoideviews/filters/Filter;", "view", "Lcm/aptoide/aptoideviews/filters/FiltersView;", "(Lcm/aptoide/aptoideviews/filters/FiltersView;)V", "getView", "()Lcm/aptoide/aptoideviews/filters/FiltersView;", "call", HttpUrl.FRAGMENT_ENCODE_SET, "subscriber", "Lrx/Subscriber;", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FilterChangedEventOnSubscribe implements e.a<List<? extends Filter>> {
    private final FiltersView view;

    public FilterChangedEventOnSubscribe(FiltersView filtersView) {
        m.f(filtersView, "view");
        this.view = filtersView;
    }

    public final FiltersView getView() {
        return this.view;
    }

    @Override // rx.m.b
    public void call(final j<? super List<Filter>> jVar) {
        m.f(jVar, "subscriber");
        rx.l.a.verifyMainThread();
        FiltersChangedEventListener filtersChangedEventListener = new FiltersChangedEventListener() { // from class: cm.aptoide.aptoideviews.filters.FilterChangedEventOnSubscribe$call$eventListener$1
            @Override // cm.aptoide.aptoideviews.filters.FiltersChangedEventListener
            public void onFiltersChanged(List<Filter> filters) {
                m.f(filters, "filters");
                if (jVar.isUnsubscribed()) {
                    return;
                }
                jVar.onNext(filters);
            }
        };
        jVar.add(new rx.l.a() { // from class: cm.aptoide.aptoideviews.filters.FilterChangedEventOnSubscribe.call.1
            @Override // rx.l.a
            protected void onUnsubscribe() {
                FilterChangedEventOnSubscribe.this.getView().setFiltersChangedEventsListener$aptoide_views_prodRelease(null);
            }
        });
        this.view.setFiltersChangedEventsListener$aptoide_views_prodRelease(filtersChangedEventListener);
    }
}
