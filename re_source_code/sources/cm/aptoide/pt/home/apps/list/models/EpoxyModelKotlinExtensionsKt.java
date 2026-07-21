package cm.aptoide.pt.home.apps.list.models;

import com.airbnb.epoxy.n;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: EpoxyModelKotlinExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001a)\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001a)\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001a)\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"downloadCard", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/airbnb/epoxy/EpoxyController;", "modelInitializer", "Lkotlin/Function1;", "Lcm/aptoide/pt/home/apps/list/models/DownloadCardModelBuilder;", "Lkotlin/ExtensionFunctionType;", "installedCard", "Lcm/aptoide/pt/home/apps/list/models/InstalledCardModelBuilder;", "title", "Lcm/aptoide/pt/home/apps/list/models/TitleModelBuilder;", "updateCard", "Lcm/aptoide/pt/home/apps/list/models/UpdateCardModelBuilder;", "app_vanillaProdRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class EpoxyModelKotlinExtensionsKt {
    public static final void downloadCard(n nVar, Function1<? super DownloadCardModelBuilder, u> function1) {
        m.f(nVar, "<this>");
        m.f(function1, "modelInitializer");
        DownloadCardModel_ downloadCardModel_ = new DownloadCardModel_();
        function1.invoke(downloadCardModel_);
        downloadCardModel_.addTo(nVar);
    }

    public static final void installedCard(n nVar, Function1<? super InstalledCardModelBuilder, u> function1) {
        m.f(nVar, "<this>");
        m.f(function1, "modelInitializer");
        InstalledCardModel_ installedCardModel_ = new InstalledCardModel_();
        function1.invoke(installedCardModel_);
        installedCardModel_.addTo(nVar);
    }

    public static final void title(n nVar, Function1<? super TitleModelBuilder, u> function1) {
        m.f(nVar, "<this>");
        m.f(function1, "modelInitializer");
        TitleModel_ titleModel_ = new TitleModel_();
        function1.invoke(titleModel_);
        titleModel_.addTo(nVar);
    }

    public static final void updateCard(n nVar, Function1<? super UpdateCardModelBuilder, u> function1) {
        m.f(nVar, "<this>");
        m.f(function1, "modelInitializer");
        UpdateCardModel_ updateCardModel_ = new UpdateCardModel_();
        function1.invoke(updateCardModel_);
        updateCardModel_.addTo(nVar);
    }
}
