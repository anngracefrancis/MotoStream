package com.facebook.o0;

import android.content.Context;
import android.util.Log;
import com.facebook.internal.p0;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

/* JADX INFO: compiled from: AppEventDiskStore.kt */
/* JADX INFO: loaded from: classes.dex */
public final class x {
    public static final x a = new x();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10549b = x.class.getName();

    /* JADX INFO: compiled from: AppEventDiskStore.kt */
    private static final class a extends ObjectInputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0152a f10550f = new C0152a(null);

        /* JADX INFO: renamed from: com.facebook.o0.x$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AppEventDiskStore.kt */
        public static final class C0152a {
            private C0152a() {
            }

            public /* synthetic */ C0152a(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() throws ClassNotFoundException, IOException {
            ObjectStreamClass classDescriptor = super.readClassDescriptor();
            if (kotlin.jvm.internal.m.a(classDescriptor.getName(), "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                classDescriptor = ObjectStreamClass.lookup(t.b.class);
            } else if (kotlin.jvm.internal.m.a(classDescriptor.getName(), "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2")) {
                classDescriptor = ObjectStreamClass.lookup(v.b.class);
            }
            kotlin.jvm.internal.m.e(classDescriptor, "resultClassDescriptor");
            return classDescriptor;
        }
    }

    private x() {
    }

    public static final synchronized h0 a() {
        h0 h0Var;
        Throwable th;
        a aVar;
        String str;
        String str2;
        com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
        com.facebook.o0.q0.g.b();
        com.facebook.a0 a0Var = com.facebook.a0.a;
        Context contextC = com.facebook.a0.c();
        h0Var = null;
        try {
            try {
                FileInputStream fileInputStreamOpenFileInput = contextC.openFileInput("AppEventsLogger.persistedevents");
                kotlin.jvm.internal.m.e(fileInputStreamOpenFileInput, "context.openFileInput(PERSISTED_EVENTS_FILENAME)");
                aVar = new a(new BufferedInputStream(fileInputStreamOpenFileInput));
                try {
                    Object object = aVar.readObject();
                    if (object == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.PersistedEvents");
                    }
                    h0 h0Var2 = (h0) object;
                    p0 p0Var = p0.a;
                    p0.h(aVar);
                    try {
                        contextC.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception e2) {
                        Log.w(f10549b, "Got unexpected exception when removing events file: ", e2);
                    }
                    h0Var = h0Var2;
                    if (h0Var == null) {
                        h0Var = new h0();
                    }
                } catch (FileNotFoundException unused) {
                    p0 p0Var2 = p0.a;
                    p0.h(aVar);
                    try {
                        contextC.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception e3) {
                        e = e3;
                        str = f10549b;
                        str2 = "Got unexpected exception when removing events file: ";
                        Log.w(str, str2, e);
                    }
                } catch (Exception e4) {
                    e = e4;
                    Log.w(f10549b, "Got unexpected exception while reading events: ", e);
                    p0 p0Var3 = p0.a;
                    p0.h(aVar);
                    try {
                        contextC.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception e5) {
                        e = e5;
                        str = f10549b;
                        str2 = "Got unexpected exception when removing events file: ";
                        Log.w(str, str2, e);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                p0 p0Var4 = p0.a;
                p0.h(null);
                try {
                    contextC.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                } catch (Exception e6) {
                    Log.w(f10549b, "Got unexpected exception when removing events file: ", e6);
                }
                throw th;
            }
        } catch (FileNotFoundException unused2) {
            aVar = null;
        } catch (Exception e7) {
            e = e7;
            aVar = null;
        } catch (Throwable th3) {
            th = th3;
            p0 p0Var5 = p0.a;
            p0.h(null);
            contextC.getFileStreamPath("AppEventsLogger.persistedevents").delete();
            throw th;
        }
        return h0Var;
    }

    public static final void b(h0 h0Var) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        Context contextC = com.facebook.a0.c();
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(contextC.openFileOutput("AppEventsLogger.persistedevents", 0)));
            try {
                objectOutputStream2.writeObject(h0Var);
                p0 p0Var = p0.a;
                p0.h(objectOutputStream2);
            } catch (Throwable th) {
                th = th;
                objectOutputStream = objectOutputStream2;
                try {
                    Log.w(f10549b, "Got unexpected exception while persisting events: ", th);
                    try {
                        contextC.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception unused) {
                    }
                } finally {
                    p0 p0Var2 = p0.a;
                    p0.h(objectOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
