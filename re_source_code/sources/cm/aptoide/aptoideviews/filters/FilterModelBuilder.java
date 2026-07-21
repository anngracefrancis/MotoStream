package cm.aptoide.aptoideviews.filters;

import com.airbnb.epoxy.f0;
import com.airbnb.epoxy.h0;
import com.airbnb.epoxy.i0;
import com.airbnb.epoxy.j0;
import com.airbnb.epoxy.s;

/* JADX INFO: loaded from: classes.dex */
public interface FilterModelBuilder {
    FilterModelBuilder backgroundRes(Integer num);

    FilterModelBuilder eventListener(FilterEventListener filterEventListener);

    FilterModelBuilder filter(Filter filter);

    FilterModelBuilder id(long j2);

    FilterModelBuilder id(long j2, long j3);

    FilterModelBuilder id(CharSequence charSequence);

    FilterModelBuilder id(CharSequence charSequence, long j2);

    FilterModelBuilder id(CharSequence charSequence, CharSequence... charSequenceArr);

    FilterModelBuilder id(Number... numberArr);

    FilterModelBuilder layout(int i2);

    FilterModelBuilder onBind(f0<FilterModel_, FilterModel.CardHolder> f0Var);

    FilterModelBuilder onUnbind(h0<FilterModel_, FilterModel.CardHolder> h0Var);

    FilterModelBuilder onVisibilityChanged(i0<FilterModel_, FilterModel.CardHolder> i0Var);

    FilterModelBuilder onVisibilityStateChanged(j0<FilterModel_, FilterModel.CardHolder> j0Var);

    FilterModelBuilder spanSizeOverride(s.c cVar);

    FilterModelBuilder textColorStateList(Integer num);
}
