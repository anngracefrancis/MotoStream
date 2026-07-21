package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.internal.zzfx;
import com.google.android.gms.measurement.internal.zzgt;
import com.google.android.gms.measurement.internal.zzgv;
import com.google.android.gms.measurement.internal.zzgw;
import com.google.android.gms.measurement.internal.zzgx;
import com.google.android.gms.measurement.internal.zzgy;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzhx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@ShowFirstParty
@KeepForSdk
@Deprecated
public class AppMeasurement {
    private static volatile AppMeasurement a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzfx f17681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzhx f17682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f17683d;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
    @ShowFirstParty
    @KeepForSdk
    public static class ConditionalUserProperty {

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public boolean mActive;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public String mAppId;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mCreationTimestamp;

        @Keep
        public String mExpiredEventName;

        @Keep
        public Bundle mExpiredEventParams;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public String mName;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public String mOrigin;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mTimeToLive;

        @Keep
        public String mTimedOutEventName;

        @Keep
        public Bundle mTimedOutEventParams;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public String mTriggerEventName;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mTriggerTimeout;

        @Keep
        public String mTriggeredEventName;

        @Keep
        public Bundle mTriggeredEventParams;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public long mTriggeredTimestamp;

        @ShowFirstParty
        @Keep
        @KeepForSdk
        public Object mValue;

        @KeepForSdk
        public ConditionalUserProperty() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle a() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString(RateAndReviewsFragment.BundleCons.APP_ID, str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                zzgt.b(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
            return bundle;
        }

        private ConditionalUserProperty(Bundle bundle) {
            Preconditions.k(bundle);
            this.mAppId = (String) zzgt.a(bundle, RateAndReviewsFragment.BundleCons.APP_ID, String.class, null);
            this.mOrigin = (String) zzgt.a(bundle, "origin", String.class, null);
            this.mName = (String) zzgt.a(bundle, "name", String.class, null);
            this.mValue = zzgt.a(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) zzgt.a(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) zzgt.a(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) zzgt.a(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) zzgt.a(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) zzgt.a(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) zzgt.a(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) zzgt.a(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) zzgt.a(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) zzgt.a(bundle, "expired_event_params", Bundle.class, null);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
    @ShowFirstParty
    @KeepForSdk
    public static final class Event extends zzgw {
        private Event() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
    @ShowFirstParty
    @KeepForSdk
    public interface EventInterceptor extends zzgx {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
    @ShowFirstParty
    @KeepForSdk
    public interface OnEventListener extends zzha {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
    @ShowFirstParty
    @KeepForSdk
    public static final class Param extends zzgv {
        private Param() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
    @ShowFirstParty
    @KeepForSdk
    public static final class UserProperty extends zzgy {
        private UserProperty() {
        }
    }

    private AppMeasurement(zzfx zzfxVar) {
        Preconditions.k(zzfxVar);
        this.f17681b = zzfxVar;
        this.f17682c = null;
        this.f17683d = false;
    }

    public static AppMeasurement c(Context context, Bundle bundle) {
        if (a == null) {
            synchronized (AppMeasurement.class) {
                if (a == null) {
                    zzhx zzhxVarF = f(context, bundle);
                    if (zzhxVarF != null) {
                        a = new AppMeasurement(zzhxVarF);
                    } else {
                        a = new AppMeasurement(zzfx.b(context, null, null, bundle));
                    }
                }
            }
        }
        return a;
    }

    @VisibleForTesting
    private static AppMeasurement d(Context context, String str, String str2) {
        if (a == null) {
            synchronized (AppMeasurement.class) {
                if (a == null) {
                    zzhx zzhxVarF = f(context, null);
                    if (zzhxVarF != null) {
                        a = new AppMeasurement(zzhxVarF);
                    } else {
                        a = new AppMeasurement(zzfx.b(context, null, null, null));
                    }
                }
            }
        }
        return a;
    }

    private static zzhx f(Context context, Bundle bundle) {
        try {
            return (zzhx) Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, bundle);
        } catch (ClassNotFoundException | Exception unused) {
            return null;
        }
    }

    @Keep
    @Deprecated
    @ShowFirstParty
    @KeepForSdk
    public static AppMeasurement getInstance(Context context) {
        return d(context, null, null);
    }

    @ShowFirstParty
    @KeepForSdk
    public void a(OnEventListener onEventListener) {
        if (this.f17683d) {
            this.f17682c.n(onEventListener);
        } else {
            this.f17681b.H().K(onEventListener);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public void b(String str, String str2, Object obj) {
        Preconditions.g(str);
        if (this.f17683d) {
            this.f17682c.o(str, str2, obj);
        } else {
            this.f17681b.H().W(str, str2, obj, true);
        }
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        if (this.f17683d) {
            this.f17682c.u(str);
        } else {
            this.f17681b.U().z(str, this.f17681b.j().b());
        }
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (this.f17683d) {
            this.f17682c.l(str, str2, bundle);
        } else {
            this.f17681b.H().y0(str, str2, bundle);
        }
    }

    @VisibleForTesting
    @Keep
    protected void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        if (this.f17683d) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f17681b.H().Y(str, str2, str3, bundle);
    }

    public final void e(boolean z) {
        if (this.f17683d) {
            this.f17682c.g0(z);
        } else {
            this.f17681b.H().w0(z);
        }
    }

    @Keep
    public void endAdUnitExposure(String str) {
        if (this.f17683d) {
            this.f17682c.Y(str);
        } else {
            this.f17681b.U().D(str, this.f17681b.j().b());
        }
    }

    @Keep
    public long generateEventId() {
        return this.f17683d ? this.f17682c.e() : this.f17681b.I().w0();
    }

    @Keep
    public String getAppInstanceId() {
        return this.f17683d ? this.f17682c.c() : this.f17681b.H().g0();
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> listI = this.f17683d ? this.f17682c.i(str, str2) : this.f17681b.H().B(str, str2);
        ArrayList arrayList = new ArrayList(listI == null ? 0 : listI.size());
        Iterator<Bundle> it = listI.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty(it.next()));
        }
        return arrayList;
    }

    @VisibleForTesting
    @Keep
    protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        if (this.f17683d) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        ArrayList<Bundle> arrayListC = this.f17681b.H().C(str, str2, str3);
        int i2 = 0;
        ArrayList arrayList = new ArrayList(arrayListC == null ? 0 : arrayListC.size());
        int size = arrayListC.size();
        while (i2 < size) {
            Bundle bundle = arrayListC.get(i2);
            i2++;
            arrayList.add(new ConditionalUserProperty(bundle));
        }
        return arrayList;
    }

    @Keep
    public String getCurrentScreenClass() {
        return this.f17683d ? this.f17682c.b() : this.f17681b.H().j0();
    }

    @Keep
    public String getCurrentScreenName() {
        return this.f17683d ? this.f17682c.a() : this.f17681b.H().i0();
    }

    @Keep
    public String getGmpAppId() {
        return this.f17683d ? this.f17682c.d() : this.f17681b.H().k0();
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public int getMaxUserProperties(String str) {
        if (this.f17683d) {
            return this.f17682c.j(str);
        }
        this.f17681b.H();
        Preconditions.g(str);
        return 25;
    }

    @VisibleForTesting
    @Keep
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.f17683d ? this.f17682c.k(str, str2, z) : this.f17681b.H().E(str, str2, z);
    }

    @VisibleForTesting
    @Keep
    protected Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        if (this.f17683d) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        return this.f17681b.H().D(str, str2, str3, z);
    }

    @ShowFirstParty
    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.f17683d) {
            this.f17682c.m(str, str2, bundle);
        } else {
            this.f17681b.H().S(str, str2, bundle);
        }
    }

    @ShowFirstParty
    @Keep
    @KeepForSdk
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.k(conditionalUserProperty);
        if (this.f17683d) {
            this.f17682c.J(conditionalUserProperty.a());
        } else {
            this.f17681b.H().H(conditionalUserProperty.a());
        }
    }

    @VisibleForTesting
    @Keep
    protected void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.k(conditionalUserProperty);
        if (this.f17683d) {
            throw new IllegalStateException("Unexpected call on client side");
        }
        this.f17681b.H().p0(conditionalUserProperty.a());
    }

    private AppMeasurement(zzhx zzhxVar) {
        Preconditions.k(zzhxVar);
        this.f17682c = zzhxVar;
        this.f17681b = null;
        this.f17683d = true;
    }
}
