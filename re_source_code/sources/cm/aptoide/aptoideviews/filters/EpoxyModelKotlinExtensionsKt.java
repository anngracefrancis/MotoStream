package cm.aptoide.aptoideviews.filters;

import com.airbnb.epoxy.n;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: EpoxyModelKotlinExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001a)\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"clearFilters", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/airbnb/epoxy/EpoxyController;", "modelInitializer", "Lkotlin/Function1;", "Lcm/aptoide/aptoideviews/filters/ClearFiltersModelBuilder;", "Lkotlin/ExtensionFunctionType;", "filter", "Lcm/aptoide/aptoideviews/filters/FilterModelBuilder;", "aptoide-views_prodRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class EpoxyModelKotlinExtensionsKt {
    public static final void clearFilters(n nVar, Function1<? super ClearFiltersModelBuilder, u> function1) {
        m.f(nVar, "<this>");
        m.f(function1, "modelInitializer");
        ClearFiltersModel_ clearFiltersModel_ = new ClearFiltersModel_();
        function1.invoke(clearFiltersModel_);
        clearFiltersModel_.addTo(nVar);
    }

    public static final void filter(n nVar, Function1<? super FilterModelBuilder, u> function1) {
        m.f(nVar, "<this>");
        m.f(function1, "modelInitializer");
        FilterModel_ filterModel_ = new FilterModel_();
        function1.invoke(filterModel_);
        filterModel_.addTo(nVar);
    }
}
