package cm.aptoide.pt.home.apps.list.models;

import com.airbnb.epoxy.f0;
import com.airbnb.epoxy.h0;
import com.airbnb.epoxy.i0;
import com.airbnb.epoxy.j0;
import com.airbnb.epoxy.s;

/* JADX INFO: loaded from: classes.dex */
public interface TitleModelBuilder {
    TitleModelBuilder eventSubject(rx.s.b<Void> bVar);

    TitleModelBuilder id(long j2);

    TitleModelBuilder id(long j2, long j3);

    TitleModelBuilder id(CharSequence charSequence);

    TitleModelBuilder id(CharSequence charSequence, long j2);

    TitleModelBuilder id(CharSequence charSequence, CharSequence... charSequenceArr);

    TitleModelBuilder id(Number... numberArr);

    TitleModelBuilder layout(int i2);

    TitleModelBuilder onBind(f0<TitleModel_, TitleModel.Holder> f0Var);

    TitleModelBuilder onUnbind(h0<TitleModel_, TitleModel.Holder> h0Var);

    TitleModelBuilder onVisibilityChanged(i0<TitleModel_, TitleModel.Holder> i0Var);

    TitleModelBuilder onVisibilityStateChanged(j0<TitleModel_, TitleModel.Holder> j0Var);

    TitleModelBuilder shouldShowButton(boolean z);

    TitleModelBuilder spanSizeOverride(s.c cVar);

    TitleModelBuilder title(Integer num);
}
