package com.facebook.internal;

import android.R;
import android.content.Context;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: FeatureManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 {
    public static final a0 a = new a0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<b, String[]> f9721b = new HashMap();

    /* JADX INFO: compiled from: FeatureManager.kt */
    public interface a {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: FeatureManager.kt */
    public enum b {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        CloudBridge(67584),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        IntelligentIntegrity(66562),
        ModelRequest(66563),
        ProtectedMode(66564),
        MACARuleMatching(66565),
        EventDeactivation(66816),
        OnDeviceEventProcessing(67072),
        OnDevicePostInstallEventProcessing(67073),
        IapLogging(67328),
        IapLoggingLib2(67329),
        Instrument(131072),
        CrashReport(131328),
        CrashShield(131329),
        ThreadCheck(131330),
        ErrorReport(131584),
        AnrReport(131840),
        Monitoring(196608),
        ServiceUpdateCompliance(196864),
        Megatron(262144),
        Elora(327680),
        Login(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE),
        ChromeCustomTabsPrefetching(R.attr.theme),
        IgnoreAppSwitchToLoggedOut(R.id.background),
        BypassAppSwitch(R.style.Animation),
        Share(33554432);


        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f9722f = new a(null);
        private final int O;

        /* JADX INFO: compiled from: FeatureManager.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }

            public final b a(int i2) {
                b[] bVarArrValuesCustom = b.valuesCustom();
                int length = bVarArrValuesCustom.length;
                int i3 = 0;
                while (i3 < length) {
                    b bVar = bVarArrValuesCustom[i3];
                    i3++;
                    if (bVar.O == i2) {
                        return bVar;
                    }
                }
                return b.Unknown;
            }
        }

        /* JADX INFO: renamed from: com.facebook.internal.a0$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FeatureManager.kt */
        public /* synthetic */ class C0144b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[b.valuesCustom().length];
                iArr[b.Core.ordinal()] = 1;
                iArr[b.AppEvents.ordinal()] = 2;
                iArr[b.CodelessEvents.ordinal()] = 3;
                iArr[b.RestrictiveDataFiltering.ordinal()] = 4;
                iArr[b.Instrument.ordinal()] = 5;
                iArr[b.CrashReport.ordinal()] = 6;
                iArr[b.CrashShield.ordinal()] = 7;
                iArr[b.ThreadCheck.ordinal()] = 8;
                iArr[b.ErrorReport.ordinal()] = 9;
                iArr[b.AnrReport.ordinal()] = 10;
                iArr[b.AAM.ordinal()] = 11;
                iArr[b.CloudBridge.ordinal()] = 12;
                iArr[b.PrivacyProtection.ordinal()] = 13;
                iArr[b.SuggestedEvents.ordinal()] = 14;
                iArr[b.IntelligentIntegrity.ordinal()] = 15;
                iArr[b.ProtectedMode.ordinal()] = 16;
                iArr[b.MACARuleMatching.ordinal()] = 17;
                iArr[b.ModelRequest.ordinal()] = 18;
                iArr[b.EventDeactivation.ordinal()] = 19;
                iArr[b.OnDeviceEventProcessing.ordinal()] = 20;
                iArr[b.OnDevicePostInstallEventProcessing.ordinal()] = 21;
                iArr[b.IapLogging.ordinal()] = 22;
                iArr[b.IapLoggingLib2.ordinal()] = 23;
                iArr[b.Monitoring.ordinal()] = 24;
                iArr[b.Megatron.ordinal()] = 25;
                iArr[b.Elora.ordinal()] = 26;
                iArr[b.ServiceUpdateCompliance.ordinal()] = 27;
                iArr[b.Login.ordinal()] = 28;
                iArr[b.ChromeCustomTabsPrefetching.ordinal()] = 29;
                iArr[b.IgnoreAppSwitchToLoggedOut.ordinal()] = 30;
                iArr[b.BypassAppSwitch.ordinal()] = 31;
                iArr[b.Share.ordinal()] = 32;
                a = iArr;
            }
        }

        b(int i2) {
            this.O = i2;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] bVarArrValuesCustom = values();
            return (b[]) Arrays.copyOf(bVarArrValuesCustom, bVarArrValuesCustom.length);
        }

        public final b q() {
            int i2 = this.O;
            if ((i2 & 255) > 0) {
                return f9722f.a(i2 & (-256));
            }
            if ((65280 & i2) > 0) {
                return f9722f.a(i2 & (-65536));
            }
            return (16711680 & i2) > 0 ? f9722f.a(i2 & (-16777216)) : f9722f.a(0);
        }

        @Override // java.lang.Enum
        public String toString() {
            switch (C0144b.a[ordinal()]) {
                case 1:
                    return "CoreKit";
                case 2:
                    return "AppEvents";
                case 3:
                    return "CodelessEvents";
                case 4:
                    return "RestrictiveDataFiltering";
                case 5:
                    return "Instrument";
                case 6:
                    return "CrashReport";
                case 7:
                    return "CrashShield";
                case 8:
                    return "ThreadCheck";
                case 9:
                    return "ErrorReport";
                case 10:
                    return "AnrReport";
                case 11:
                    return "AAM";
                case 12:
                    return "AppEventsCloudbridge";
                case 13:
                    return "PrivacyProtection";
                case 14:
                    return "SuggestedEvents";
                case 15:
                    return "IntelligentIntegrity";
                case 16:
                    return "ProtectedMode";
                case 17:
                    return "MACARuleMatching";
                case 18:
                    return "ModelRequest";
                case 19:
                    return "EventDeactivation";
                case 20:
                    return "OnDeviceEventProcessing";
                case 21:
                    return "OnDevicePostInstallEventProcessing";
                case 22:
                    return "IAPLogging";
                case 23:
                    return "IAPLoggingLib2";
                case 24:
                    return "Monitoring";
                case 25:
                    return "Megatron";
                case 26:
                    return "Elora";
                case 27:
                    return "ServiceUpdateCompliance";
                case 28:
                    return "LoginKit";
                case 29:
                    return "ChromeCustomTabsPrefetching";
                case 30:
                    return "IgnoreAppSwitchToLoggedOut";
                case 31:
                    return "BypassAppSwitch";
                case 32:
                    return "ShareKit";
                default:
                    return "unknown";
            }
        }

        public final String u() {
            return kotlin.jvm.internal.m.n("FBSDKFeature", this);
        }
    }

    /* JADX INFO: compiled from: FeatureManager.kt */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.valuesCustom().length];
            iArr[b.RestrictiveDataFiltering.ordinal()] = 1;
            iArr[b.Instrument.ordinal()] = 2;
            iArr[b.CrashReport.ordinal()] = 3;
            iArr[b.CrashShield.ordinal()] = 4;
            iArr[b.ThreadCheck.ordinal()] = 5;
            iArr[b.ErrorReport.ordinal()] = 6;
            iArr[b.AnrReport.ordinal()] = 7;
            iArr[b.AAM.ordinal()] = 8;
            iArr[b.CloudBridge.ordinal()] = 9;
            iArr[b.PrivacyProtection.ordinal()] = 10;
            iArr[b.SuggestedEvents.ordinal()] = 11;
            iArr[b.IntelligentIntegrity.ordinal()] = 12;
            iArr[b.ModelRequest.ordinal()] = 13;
            iArr[b.EventDeactivation.ordinal()] = 14;
            iArr[b.OnDeviceEventProcessing.ordinal()] = 15;
            iArr[b.OnDevicePostInstallEventProcessing.ordinal()] = 16;
            iArr[b.IapLogging.ordinal()] = 17;
            iArr[b.IapLoggingLib2.ordinal()] = 18;
            iArr[b.ProtectedMode.ordinal()] = 19;
            iArr[b.MACARuleMatching.ordinal()] = 20;
            iArr[b.ChromeCustomTabsPrefetching.ordinal()] = 21;
            iArr[b.Monitoring.ordinal()] = 22;
            iArr[b.IgnoreAppSwitchToLoggedOut.ordinal()] = 23;
            iArr[b.BypassAppSwitch.ordinal()] = 24;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: FeatureManager.kt */
    public static final class d implements b0.a {
        final /* synthetic */ a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f9728b;

        d(a aVar, b bVar) {
            this.a = aVar;
            this.f9728b = bVar;
        }

        @Override // com.facebook.internal.b0.a
        public void onCompleted() {
            a aVar = this.a;
            a0 a0Var = a0.a;
            aVar.a(a0.g(this.f9728b));
        }
    }

    private a0() {
    }

    public static final void a(b bVar, a aVar) {
        kotlin.jvm.internal.m.f(bVar, DeepLinkIntentReceiver.DeepLinksTargets.FEATURE);
        kotlin.jvm.internal.m.f(aVar, "callback");
        b0 b0Var = b0.a;
        b0.h(new d(aVar, bVar));
    }

    private final boolean b(b bVar) {
        switch (c.a[bVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                return false;
            default:
                return true;
        }
    }

    public static final void c(b bVar) {
        kotlin.jvm.internal.m.f(bVar, DeepLinkIntentReceiver.DeepLinksTargets.FEATURE);
        com.facebook.a0 a0Var = com.facebook.a0.a;
        com.facebook.a0.c().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).edit().putString(bVar.u(), com.facebook.a0.s()).apply();
    }

    public static final b d(String str) {
        kotlin.jvm.internal.m.f(str, "className");
        a.f();
        for (Map.Entry<b, String[]> entry : f9721b.entrySet()) {
            b key = entry.getKey();
            String[] value = entry.getValue();
            int length = value.length;
            int i2 = 0;
            while (i2 < length) {
                String str2 = value[i2];
                i2++;
                if (kotlin.text.u.E(str, str2, false, 2, null)) {
                    return key;
                }
            }
        }
        return b.Unknown;
    }

    private final boolean e(b bVar) {
        boolean zB = b(bVar);
        b0 b0Var = b0.a;
        String strU = bVar.u();
        com.facebook.a0 a0Var = com.facebook.a0.a;
        return b0.b(strU, com.facebook.a0.d(), zB);
    }

    private final synchronized void f() {
        Map<b, String[]> map = f9721b;
        if (map.isEmpty()) {
            map.put(b.AAM, new String[]{"com.facebook.appevents.aam."});
            map.put(b.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
            map.put(b.CloudBridge, new String[]{"com.facebook.appevents.cloudbridge."});
            map.put(b.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
            map.put(b.AnrReport, new String[]{"com.facebook.internal.instrument.anrreport."});
            map.put(b.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
            map.put(b.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
            map.put(b.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
            map.put(b.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
            map.put(b.ProtectedMode, new String[]{"com.facebook.appevents.integrity.ProtectedModeManager"});
            map.put(b.MACARuleMatching, new String[]{"com.facebook.appevents.integrity.MACARuleMatchingManager"});
            map.put(b.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
            map.put(b.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
            map.put(b.IapLogging, new String[]{"com.facebook.appevents.iap."});
            map.put(b.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
        }
    }

    public static final boolean g(b bVar) {
        kotlin.jvm.internal.m.f(bVar, DeepLinkIntentReceiver.DeepLinksTargets.FEATURE);
        if (b.Unknown == bVar) {
            return false;
        }
        if (b.Core == bVar) {
            return true;
        }
        com.facebook.a0 a0Var = com.facebook.a0.a;
        Context contextC = com.facebook.a0.c();
        a0 a0Var2 = a;
        String string = contextC.getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).getString(bVar.u(), null);
        if (string != null && kotlin.jvm.internal.m.a(string, com.facebook.a0.s())) {
            return false;
        }
        b bVarQ = bVar.q();
        if (bVarQ == bVar) {
            return a0Var2.e(bVar);
        }
        return g(bVarQ) && a0Var2.e(bVar);
    }
}
