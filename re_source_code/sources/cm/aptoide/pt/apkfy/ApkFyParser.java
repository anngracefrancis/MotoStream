package cm.aptoide.pt.apkfy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.analytics.FirstLaunchAnalytics;
import cm.aptoide.pt.preferences.secure.SecurePreferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.intrinsics.d;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlin.text.v;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.j;
import kotlinx.coroutines.p0;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ApkFyParser.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcm/aptoide/pt/apkfy/ApkFyParser;", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "securePreferences", "Landroid/content/SharedPreferences;", "apkfyManager", "Lcm/aptoide/pt/apkfy/ApkfyManager;", "firstLaunchAnalytics", "Lcm/aptoide/pt/analytics/FirstLaunchAnalytics;", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/SharedPreferences;Lcm/aptoide/pt/apkfy/ApkfyManager;Lcm/aptoide/pt/analytics/FirstLaunchAnalytics;)V", "run", HttpUrl.FRAGMENT_ENCODE_SET, "saveGuestUID", "guestUid", HttpUrl.FRAGMENT_ENCODE_SET, "setApkfyUtmProperties", "apkfyModel", "Lcm/aptoide/pt/apkfy/ApkfyModel;", "updateApkfy", "Companion", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApkFyParser {
    public static final String APKFY_PACKAGE_APKFY_NO_UTM = "APKFY_BUT_NO_UTM";
    public static final String APKFY_PACKAGE_NO_APKFY = "NO_APKFY";
    public static final String APKFY_PACKAGE_NO_APP = "APKFY_BUT_NO_APP";
    public static final String MMP_GUEST_UID = "MMP_GUEST_UID";
    private final ApkfyManager apkfyManager;
    private final Context context;
    private final FirstLaunchAnalytics firstLaunchAnalytics;
    private final Intent intent;
    private final SharedPreferences securePreferences;

    /* JADX INFO: renamed from: cm.aptoide.pt.apkfy.ApkFyParser$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: ApkFyParser.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "cm.aptoide.pt.apkfy.ApkFyParser$run$1", f = "ApkFyParser.kt", l = {30}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super u>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return ApkFyParser.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = d.c();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    o.b(obj);
                    String string = ApkFyParser.this.securePreferences.getString(ApkFyParser.MMP_GUEST_UID, HttpUrl.FRAGMENT_ENCODE_SET);
                    boolean z = false;
                    boolean z2 = !(string == null || string.length() == 0);
                    if (SecurePreferences.shouldRunApkFy(ApkFyParser.this.securePreferences) && !z2) {
                        z = true;
                    }
                    if (z) {
                        ApkfyManager apkfyManager = ApkFyParser.this.apkfyManager;
                        this.label = 1;
                        obj = apkfyManager.getApkfy(this);
                        if (obj == objC) {
                            return objC;
                        }
                    }
                    return u.a;
                }
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                o.b(obj);
                ApkfyModel apkfyModel = (ApkfyModel) obj;
                ApkFyParser.this.saveGuestUID(apkfyModel.getGuestUid());
                ApkFyParser.this.updateApkfy(apkfyModel);
                ApkFyParser.this.setApkfyUtmProperties(apkfyModel);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return u.a;
        }
    }

    public ApkFyParser(Context context, Intent intent, SharedPreferences sharedPreferences, ApkfyManager apkfyManager, FirstLaunchAnalytics firstLaunchAnalytics) {
        m.f(context, "context");
        m.f(intent, "intent");
        m.f(sharedPreferences, "securePreferences");
        m.f(apkfyManager, "apkfyManager");
        m.f(firstLaunchAnalytics, "firstLaunchAnalytics");
        this.context = context;
        this.intent = intent;
        this.securePreferences = sharedPreferences;
        this.apkfyManager = apkfyManager;
        this.firstLaunchAnalytics = firstLaunchAnalytics;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveGuestUID(String guestUid) {
        this.securePreferences.edit().putString(MMP_GUEST_UID, guestUid).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setApkfyUtmProperties(ApkfyModel apkfyModel) {
        if (apkfyModel.hasUTMs()) {
            String packageName = apkfyModel.getPackageName();
            if ((packageName == null || kotlin.text.u.t(packageName)) && apkfyModel.getAppId() == null) {
                this.firstLaunchAnalytics.sendIndicativeFirstLaunchSourceUserProperties(apkfyModel.getUtmContent(), apkfyModel.getUtmSource(), apkfyModel.getUtmCampaign(), apkfyModel.getUtmMedium(), apkfyModel.getUtmTerm(), APKFY_PACKAGE_NO_APP);
                return;
            } else {
                this.firstLaunchAnalytics.sendIndicativeFirstLaunchSourceUserProperties(apkfyModel.getUtmContent(), apkfyModel.getUtmSource(), apkfyModel.getUtmCampaign(), apkfyModel.getUtmMedium(), apkfyModel.getUtmTerm(), apkfyModel.getPackageName());
                return;
            }
        }
        String packageName2 = apkfyModel.getPackageName();
        if ((packageName2 == null || kotlin.text.u.t(packageName2)) && apkfyModel.getAppId() == null) {
            this.firstLaunchAnalytics.sendIndicativeFirstLaunchSourceUserProperties(APKFY_PACKAGE_NO_APKFY, APKFY_PACKAGE_NO_APKFY, APKFY_PACKAGE_NO_APKFY, APKFY_PACKAGE_NO_APKFY, APKFY_PACKAGE_NO_APKFY, APKFY_PACKAGE_NO_APKFY);
        } else {
            this.firstLaunchAnalytics.sendIndicativeFirstLaunchSourceUserProperties(apkfyModel.getUtmContent(), apkfyModel.getUtmSource(), apkfyModel.getUtmCampaign(), apkfyModel.getUtmMedium(), apkfyModel.getUtmTerm(), APKFY_PACKAGE_APKFY_NO_UTM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateApkfy(ApkfyModel apkfyModel) {
        String packageName = apkfyModel.getPackageName();
        if ((packageName == null || kotlin.text.u.t(packageName)) || v.J(apkfyModel.getPackageName(), "cm.aptoide.pt", false, 2, null)) {
            return;
        }
        if (apkfyModel.getAppId() != null) {
            this.intent.putExtra(DeepLinkIntentReceiver.DeepLinksTargets.APP_VIEW_FRAGMENT, true);
            this.intent.putExtra("appId", apkfyModel.getAppId().longValue());
            String oemId = apkfyModel.getOemId();
            if (!(oemId == null || kotlin.text.u.t(oemId))) {
                this.intent.putExtra(DeepLinkIntentReceiver.DeepLinksKeys.OEM_ID_KEY, apkfyModel.getOemId());
            }
            this.intent.putExtra(DeepLinkIntentReceiver.DeepLinksKeys.APK_FY, true);
            SecurePreferences.setApkFyRun(this.securePreferences);
            this.context.startActivity(this.intent);
            return;
        }
        String packageName2 = apkfyModel.getPackageName();
        if (packageName2 == null || kotlin.text.u.t(packageName2)) {
            return;
        }
        this.intent.putExtra(DeepLinkIntentReceiver.DeepLinksTargets.APP_VIEW_FRAGMENT, true);
        this.intent.putExtra("packageName", apkfyModel.getPackageName());
        String oemId2 = apkfyModel.getOemId();
        if (!(oemId2 == null || kotlin.text.u.t(oemId2))) {
            this.intent.putExtra(DeepLinkIntentReceiver.DeepLinksKeys.OEM_ID_KEY, apkfyModel.getOemId());
        }
        this.intent.putExtra(DeepLinkIntentReceiver.DeepLinksKeys.APK_FY, true);
        SecurePreferences.setApkFyRun(this.securePreferences);
        this.context.startActivity(this.intent);
    }

    public final void run() {
        j.b(p0.a(Dispatchers.c()), null, null, new AnonymousClass1(null), 3, null);
    }
}
