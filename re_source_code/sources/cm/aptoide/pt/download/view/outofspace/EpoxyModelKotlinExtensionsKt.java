package cm.aptoide.pt.download.view.outofspace;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: EpoxyModelKotlinExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"installedAppCard", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/airbnb/epoxy/EpoxyController;", "modelInitializer", "Lkotlin/Function1;", "Lcm/aptoide/pt/download/view/outofspace/InstalledAppCardModelBuilder;", "Lkotlin/ExtensionFunctionType;", "app_vanillaProdRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class EpoxyModelKotlinExtensionsKt {
    public static final void installedAppCard(com.airbnb.epoxy.n nVar, Function1<? super InstalledAppCardModelBuilder, kotlin.u> function1) {
        kotlin.jvm.internal.m.f(nVar, "<this>");
        kotlin.jvm.internal.m.f(function1, "modelInitializer");
        InstalledAppCardModel_ installedAppCardModel_ = new InstalledAppCardModel_();
        function1.invoke(installedAppCardModel_);
        installedAppCardModel_.addTo(nVar);
    }
}
