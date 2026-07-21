package cm.aptoide.pt;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AptoideFirebaseNotificationService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcm/aptoide/pt/FirebaseConstants;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "FIREBASE_ANALYTICS_DATA", HttpUrl.FRAGMENT_ENCODE_SET, "FIREBASE_MESSAGE_ID", "FIREBASE_MESSAGE_LABEL", "FIREBASE_MESSAGE_NAME", "LAUNCH_SOURCE", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FirebaseConstants {
    public static final String FIREBASE_ANALYTICS_DATA = "gcm.n.analytics_data";
    public static final String FIREBASE_MESSAGE_ID = "google.message_id";
    public static final String FIREBASE_MESSAGE_LABEL = "google.c.a.m_l";
    public static final String FIREBASE_MESSAGE_NAME = "google.c.a.c_l";
    public static final FirebaseConstants INSTANCE = new FirebaseConstants();
    public static final String LAUNCH_SOURCE = "launchSource";

    private FirebaseConstants() {
    }
}
