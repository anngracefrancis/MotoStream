package cm.aptoide.pt.home.apps.list.models;

import cm.aptoide.pt.home.apps.AppClick;
import cm.aptoide.pt.home.apps.model.UpdateApp;
import cm.aptoide.pt.themes.ThemeManager;
import com.airbnb.epoxy.f0;
import com.airbnb.epoxy.h0;
import com.airbnb.epoxy.i0;
import com.airbnb.epoxy.j0;
import com.airbnb.epoxy.s;

/* JADX INFO: loaded from: classes.dex */
public interface UpdateCardModelBuilder {
    UpdateCardModelBuilder application(UpdateApp updateApp);

    UpdateCardModelBuilder eventSubject(rx.s.b<AppClick> bVar);

    UpdateCardModelBuilder id(long j2);

    UpdateCardModelBuilder id(long j2, long j3);

    UpdateCardModelBuilder id(CharSequence charSequence);

    UpdateCardModelBuilder id(CharSequence charSequence, long j2);

    UpdateCardModelBuilder id(CharSequence charSequence, CharSequence... charSequenceArr);

    UpdateCardModelBuilder id(Number... numberArr);

    UpdateCardModelBuilder layout(int i2);

    UpdateCardModelBuilder onBind(f0<UpdateCardModel_, UpdateCardModel.CardHolder> f0Var);

    UpdateCardModelBuilder onUnbind(h0<UpdateCardModel_, UpdateCardModel.CardHolder> h0Var);

    UpdateCardModelBuilder onVisibilityChanged(i0<UpdateCardModel_, UpdateCardModel.CardHolder> i0Var);

    UpdateCardModelBuilder onVisibilityStateChanged(j0<UpdateCardModel_, UpdateCardModel.CardHolder> j0Var);

    UpdateCardModelBuilder spanSizeOverride(s.c cVar);

    UpdateCardModelBuilder themeManager(ThemeManager themeManager);
}
