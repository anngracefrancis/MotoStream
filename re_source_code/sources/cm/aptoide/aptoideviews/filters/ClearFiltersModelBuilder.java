package cm.aptoide.aptoideviews.filters;

import com.airbnb.epoxy.f0;
import com.airbnb.epoxy.h0;
import com.airbnb.epoxy.i0;
import com.airbnb.epoxy.j0;
import com.airbnb.epoxy.s;

/* JADX INFO: loaded from: classes.dex */
public interface ClearFiltersModelBuilder {
    ClearFiltersModelBuilder eventListener(FilterEventListener filterEventListener);

    ClearFiltersModelBuilder id(long j2);

    ClearFiltersModelBuilder id(long j2, long j3);

    ClearFiltersModelBuilder id(CharSequence charSequence);

    ClearFiltersModelBuilder id(CharSequence charSequence, long j2);

    ClearFiltersModelBuilder id(CharSequence charSequence, CharSequence... charSequenceArr);

    ClearFiltersModelBuilder id(Number... numberArr);

    ClearFiltersModelBuilder layout(int i2);

    ClearFiltersModelBuilder onBind(f0<ClearFiltersModel_, ClearFiltersModel.CardHolder> f0Var);

    ClearFiltersModelBuilder onUnbind(h0<ClearFiltersModel_, ClearFiltersModel.CardHolder> h0Var);

    ClearFiltersModelBuilder onVisibilityChanged(i0<ClearFiltersModel_, ClearFiltersModel.CardHolder> i0Var);

    ClearFiltersModelBuilder onVisibilityStateChanged(j0<ClearFiltersModel_, ClearFiltersModel.CardHolder> j0Var);

    ClearFiltersModelBuilder spanSizeOverride(s.c cVar);

    ClearFiltersModelBuilder textColorStateList(Integer num);
}
