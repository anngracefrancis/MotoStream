package cm.aptoide.pt.download.view.outofspace;

import com.airbnb.epoxy.i0;
import com.airbnb.epoxy.j0;

/* JADX INFO: loaded from: classes.dex */
public interface InstalledAppCardModelBuilder {
    InstalledAppCardModelBuilder application(InstalledApp installedApp);

    InstalledAppCardModelBuilder eventSubject(rx.s.b<String> bVar);

    InstalledAppCardModelBuilder id(long j2);

    InstalledAppCardModelBuilder id(long j2, long j3);

    InstalledAppCardModelBuilder id(CharSequence charSequence);

    InstalledAppCardModelBuilder id(CharSequence charSequence, long j2);

    InstalledAppCardModelBuilder id(CharSequence charSequence, CharSequence... charSequenceArr);

    InstalledAppCardModelBuilder id(Number... numberArr);

    InstalledAppCardModelBuilder layout(int i2);

    InstalledAppCardModelBuilder onBind(com.airbnb.epoxy.f0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> f0Var);

    InstalledAppCardModelBuilder onUnbind(com.airbnb.epoxy.h0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> h0Var);

    InstalledAppCardModelBuilder onVisibilityChanged(i0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> i0Var);

    InstalledAppCardModelBuilder onVisibilityStateChanged(j0<InstalledAppCardModel_, InstalledAppCardModel.CardHolder> j0Var);

    InstalledAppCardModelBuilder spanSizeOverride(com.airbnb.epoxy.s.c cVar);
}
