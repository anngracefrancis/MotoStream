package com.google.firebase.sessions;

import com.google.firebase.Firebase;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.d0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SessionGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0015\u001a\u00020\tH\u0007J\b\u0010\u0016\u001a\u00020\u000eH\u0002R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/sessions/SessionGenerator;", HttpUrl.FRAGMENT_ENCODE_SET, "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "uuidGenerator", "Lkotlin/Function0;", "Ljava/util/UUID;", "(Lcom/google/firebase/sessions/TimeProvider;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "Lcom/google/firebase/sessions/SessionDetails;", "currentSession", "getCurrentSession", "()Lcom/google/firebase/sessions/SessionDetails;", "firstSessionId", HttpUrl.FRAGMENT_ENCODE_SET, "hasGenerateSession", HttpUrl.FRAGMENT_ENCODE_SET, "getHasGenerateSession", "()Z", "sessionIndex", HttpUrl.FRAGMENT_ENCODE_SET, "generateNewSession", "generateSessionId", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SessionGenerator {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeProvider f19931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function0<UUID> f19932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SessionDetails f19935f;

    /* JADX INFO: renamed from: com.google.firebase.sessions.d0$a */
    /* JADX INFO: compiled from: SessionGenerator.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* synthetic */ class a extends kotlin.jvm.internal.j implements Function0<UUID> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f19936h = new a();

        a() {
            super(0, UUID.class, "randomUUID", "randomUUID()Ljava/util/UUID;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.d0$b */
    /* JADX INFO: compiled from: SessionGenerator.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/SessionGenerator$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "instance", "Lcom/google/firebase/sessions/SessionGenerator;", "getInstance", "()Lcom/google/firebase/sessions/SessionGenerator;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final SessionGenerator a() {
            Object objH = com.google.firebase.l.a(Firebase.a).h(SessionGenerator.class);
            kotlin.jvm.internal.m.e(objH, "Firebase.app[SessionGenerator::class.java]");
            return (SessionGenerator) objH;
        }
    }

    public SessionGenerator(TimeProvider timeProvider, Function0<UUID> function0) {
        kotlin.jvm.internal.m.f(timeProvider, "timeProvider");
        kotlin.jvm.internal.m.f(function0, "uuidGenerator");
        this.f19931b = timeProvider;
        this.f19932c = function0;
        this.f19933d = b();
        this.f19934e = -1;
    }

    private final String b() {
        String string = this.f19932c.invoke().toString();
        kotlin.jvm.internal.m.e(string, "uuidGenerator().toString()");
        String lowerCase = kotlin.text.u.A(string, "-", HttpUrl.FRAGMENT_ENCODE_SET, false, 4, null).toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.m.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    public final SessionDetails a() {
        int i2 = this.f19934e + 1;
        this.f19934e = i2;
        this.f19935f = new SessionDetails(i2 == 0 ? this.f19933d : b(), this.f19933d, this.f19934e, this.f19931b.a());
        return c();
    }

    public final SessionDetails c() {
        SessionDetails sessionDetails = this.f19935f;
        if (sessionDetails != null) {
            return sessionDetails;
        }
        kotlin.jvm.internal.m.w("currentSession");
        return null;
    }

    public /* synthetic */ SessionGenerator(TimeProvider timeProvider, Function0 function0, int i2, kotlin.jvm.internal.g gVar) {
        this(timeProvider, (i2 & 2) != 0 ? a.f19936h : function0);
    }
}
