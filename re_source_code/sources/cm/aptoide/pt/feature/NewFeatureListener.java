package cm.aptoide.pt.feature;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: NewFeatureListener.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcm/aptoide/pt/feature/NewFeatureListener;", HttpUrl.FRAGMENT_ENCODE_SET, "onActivateFeature", HttpUrl.FRAGMENT_ENCODE_SET, "onDismiss", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface NewFeatureListener {
    void onActivateFeature();

    void onDismiss();
}
