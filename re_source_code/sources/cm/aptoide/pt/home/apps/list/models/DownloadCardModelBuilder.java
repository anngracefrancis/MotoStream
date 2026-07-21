package cm.aptoide.pt.home.apps.list.models;

import cm.aptoide.pt.home.apps.AppClick;
import cm.aptoide.pt.home.apps.model.DownloadApp;
import com.airbnb.epoxy.f0;
import com.airbnb.epoxy.h0;
import com.airbnb.epoxy.i0;
import com.airbnb.epoxy.j0;
import com.airbnb.epoxy.s;

/* JADX INFO: loaded from: classes.dex */
public interface DownloadCardModelBuilder {
    DownloadCardModelBuilder application(DownloadApp downloadApp);

    DownloadCardModelBuilder eventSubject(rx.s.b<AppClick> bVar);

    DownloadCardModelBuilder id(long j2);

    DownloadCardModelBuilder id(long j2, long j3);

    DownloadCardModelBuilder id(CharSequence charSequence);

    DownloadCardModelBuilder id(CharSequence charSequence, long j2);

    DownloadCardModelBuilder id(CharSequence charSequence, CharSequence... charSequenceArr);

    DownloadCardModelBuilder id(Number... numberArr);

    DownloadCardModelBuilder layout(int i2);

    DownloadCardModelBuilder onBind(f0<DownloadCardModel_, DownloadCardModel.CardHolder> f0Var);

    DownloadCardModelBuilder onUnbind(h0<DownloadCardModel_, DownloadCardModel.CardHolder> h0Var);

    DownloadCardModelBuilder onVisibilityChanged(i0<DownloadCardModel_, DownloadCardModel.CardHolder> i0Var);

    DownloadCardModelBuilder onVisibilityStateChanged(j0<DownloadCardModel_, DownloadCardModel.CardHolder> j0Var);

    DownloadCardModelBuilder spanSizeOverride(s.c cVar);
}
