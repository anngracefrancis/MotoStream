package cm.aptoide.pt.home.apps.list.models;

import cm.aptoide.pt.home.apps.model.InstalledApp;
import com.airbnb.epoxy.f0;
import com.airbnb.epoxy.h0;
import com.airbnb.epoxy.i0;
import com.airbnb.epoxy.j0;
import com.airbnb.epoxy.s;

/* JADX INFO: loaded from: classes.dex */
public interface InstalledCardModelBuilder {
    InstalledCardModelBuilder application(InstalledApp installedApp);

    InstalledCardModelBuilder id(long j2);

    InstalledCardModelBuilder id(long j2, long j3);

    InstalledCardModelBuilder id(CharSequence charSequence);

    InstalledCardModelBuilder id(CharSequence charSequence, long j2);

    InstalledCardModelBuilder id(CharSequence charSequence, CharSequence... charSequenceArr);

    InstalledCardModelBuilder id(Number... numberArr);

    InstalledCardModelBuilder layout(int i2);

    InstalledCardModelBuilder onBind(f0<InstalledCardModel_, InstalledCardModel.CardHolder> f0Var);

    InstalledCardModelBuilder onUnbind(h0<InstalledCardModel_, InstalledCardModel.CardHolder> h0Var);

    InstalledCardModelBuilder onVisibilityChanged(i0<InstalledCardModel_, InstalledCardModel.CardHolder> i0Var);

    InstalledCardModelBuilder onVisibilityStateChanged(j0<InstalledCardModel_, InstalledCardModel.CardHolder> j0Var);

    InstalledCardModelBuilder spanSizeOverride(s.c cVar);
}
