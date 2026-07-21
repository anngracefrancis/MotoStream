package com.facebook.internal;

import android.content.Intent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CallbackManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements com.facebook.y {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Integer, a> f9858b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Integer, a> f9859c = new HashMap();

    /* JADX INFO: compiled from: CallbackManagerImpl.kt */
    public interface a {
        boolean a(int i2, Intent intent);
    }

    /* JADX INFO: compiled from: CallbackManagerImpl.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final synchronized a b(int i2) {
            return (a) t.f9858b.get(Integer.valueOf(i2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(int i2, int i3, Intent intent) {
            a aVarB = b(i2);
            if (aVarB == null) {
                return false;
            }
            return aVarB.a(i3, intent);
        }

        public final synchronized void c(int i2, a aVar) {
            kotlin.jvm.internal.m.f(aVar, "callback");
            if (t.f9858b.containsKey(Integer.valueOf(i2))) {
                return;
            }
            t.f9858b.put(Integer.valueOf(i2), aVar);
        }
    }

    /* JADX INFO: compiled from: CallbackManagerImpl.kt */
    public enum c {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8),
        GamingFriendFinder(9),
        GamingGroupIntegration(10),
        Referral(11),
        GamingContextCreate(12),
        GamingContextSwitch(13),
        GamingContextChoose(14),
        TournamentShareDialog(15),
        TournamentJoinDialog(16);

        private final int x;

        c(int i2) {
            this.x = i2;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static c[] valuesCustom() {
            c[] cVarArrValuesCustom = values();
            return (c[]) Arrays.copyOf(cVarArrValuesCustom, cVarArrValuesCustom.length);
        }

        public final int k() {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            return com.facebook.a0.h() + this.x;
        }
    }

    public final void b(int i2, a aVar) {
        kotlin.jvm.internal.m.f(aVar, "callback");
        this.f9859c.put(Integer.valueOf(i2), aVar);
    }

    @Override // com.facebook.y
    public boolean onActivityResult(int i2, int i3, Intent intent) {
        a aVar = this.f9859c.get(Integer.valueOf(i2));
        return aVar == null ? a.d(i2, i3, intent) : aVar.a(i3, intent);
    }
}
