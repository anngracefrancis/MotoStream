package cm.aptoide.aptoideviews.skeleton.mask;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcm/aptoide/aptoideviews/skeleton/mask/Size;", HttpUrl.FRAGMENT_ENCODE_SET, "width", "Lcm/aptoide/aptoideviews/skeleton/mask/SizeDimension;", "height", "(Lcm/aptoide/aptoideviews/skeleton/mask/SizeDimension;Lcm/aptoide/aptoideviews/skeleton/mask/SizeDimension;)V", "getHeight", "()Lcm/aptoide/aptoideviews/skeleton/mask/SizeDimension;", "getWidth", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Size {
    private final SizeDimension height;
    private final SizeDimension width;

    public Size(SizeDimension sizeDimension, SizeDimension sizeDimension2) {
        m.f(sizeDimension, "width");
        m.f(sizeDimension2, "height");
        this.width = sizeDimension;
        this.height = sizeDimension2;
    }

    public final SizeDimension getHeight() {
        return this.height;
    }

    public final SizeDimension getWidth() {
        return this.width;
    }
}
