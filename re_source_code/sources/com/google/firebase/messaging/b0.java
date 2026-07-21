package com.google.firebase.messaging;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
class b0 {
    private final com.google.firebase.j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g0 f19793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rpc f19794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.firebase.s.b<com.google.firebase.u.i> f19795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.firebase.s.b<com.google.firebase.r.j> f19796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.firebase.installations.i f19797f;

    b0(com.google.firebase.j jVar, g0 g0Var, Rpc rpc, com.google.firebase.s.b<com.google.firebase.u.i> bVar, com.google.firebase.s.b<com.google.firebase.r.j> bVar2, com.google.firebase.installations.i iVar) {
        this.a = jVar;
        this.f19793b = g0Var;
        this.f19794c = rpc;
        this.f19795d = bVar;
        this.f19796e = bVar2;
        this.f19797f = iVar;
    }

    b0(com.google.firebase.j jVar, g0 g0Var, com.google.firebase.s.b<com.google.firebase.u.i> bVar, com.google.firebase.s.b<com.google.firebase.r.j> bVar2, com.google.firebase.installations.i iVar) {
        this(jVar, g0Var, new Rpc(jVar.i()), bVar, bVar2, iVar);
    }

    private static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task<String> b(Task<Bundle> task) {
        return task.g(z.f19885f, new Continuation(this) { // from class: com.google.firebase.messaging.a0
            private final b0 a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object a(Task task2) {
                return this.a.g(task2);
            }
        });
    }

    private String c() {
        try {
            return a(MessageDigest.getInstance("SHA-1").digest(this.a.k().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private String e(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("unregistered");
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString("error");
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        String strValueOf = String.valueOf(bundle);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 21);
        sb.append("Unexpected response: ");
        sb.append(strValueOf);
        Log.w("FirebaseMessaging", sb.toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    static boolean f(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    private Bundle h(String str, String str2, String str3, Bundle bundle) {
        com.google.firebase.r.j.a aVarB;
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.a.l().c());
        bundle.putString("gmsv", Integer.toString(this.f19793b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f19793b.a());
        bundle.putString("app_ver_name", this.f19793b.b());
        bundle.putString("firebase-app-name-hash", c());
        try {
            String strB = ((com.google.firebase.installations.l) Tasks.a(this.f19797f.a(false))).b();
            if (TextUtils.isEmpty(strB)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", strB);
            }
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e2);
        }
        bundle.putString("cliv", "fcm-20.1.7_1p");
        com.google.firebase.r.j jVar = this.f19796e.get();
        com.google.firebase.u.i iVar = this.f19795d.get();
        if (jVar != null && iVar != null && (aVarB = jVar.b("fire-iid")) != com.google.firebase.r.j.a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(aVarB.g()));
            bundle.putString("Firebase-Client", iVar.a());
        }
        return bundle;
    }

    private Task<Bundle> i(String str, String str2, String str3, Bundle bundle) {
        h(str, str2, str3, bundle);
        return this.f19794c.a(bundle);
    }

    Task<String> d(String str) {
        return b(i(str, g0.c(this.a), "*", new Bundle()));
    }

    final /* synthetic */ String g(Task task) throws Exception {
        return e((Bundle) task.k(IOException.class));
    }

    Task<?> j(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String strValueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", strValueOf.length() != 0 ? "/topics/".concat(strValueOf) : new String("/topics/"));
        String strValueOf2 = String.valueOf(str3);
        return b(i(str, str2, strValueOf2.length() != 0 ? "/topics/".concat(strValueOf2) : new String("/topics/"), bundle));
    }

    Task<?> k(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String strValueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", strValueOf.length() != 0 ? "/topics/".concat(strValueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String strValueOf2 = String.valueOf(str3);
        return b(i(str, str2, strValueOf2.length() != 0 ? "/topics/".concat(strValueOf2) : new String("/topics/"), bundle));
    }
}
