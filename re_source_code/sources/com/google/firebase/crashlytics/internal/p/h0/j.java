package com.google.firebase.crashlytics.internal.p.h0;

import android.util.Base64;
import android.util.JsonReader;
import cm.aptoide.pt.database.room.RoomNotification;
import com.google.firebase.crashlytics.internal.p.f0;
import com.google.firebase.encoders.json.d;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static final com.google.firebase.encoders.a a = new d().g(com.google.firebase.crashlytics.internal.p.a.a).h(true).f();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CrashlyticsReportJsonTransform.java */
    interface a<T> {
        T a(JsonReader jsonReader) throws IOException;
    }

    private static f0.e.d.f A(JsonReader jsonReader) throws IOException {
        f0.e.d.f.a aVarA = f0.e.d.f.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("assignments")) {
                aVarA.b(n(jsonReader, new a() { // from class: com.google.firebase.crashlytics.h.p.h0.b
                    @Override // com.google.firebase.crashlytics.h.p.h0.j.a
                    public final Object a(JsonReader jsonReader2) {
                        return j.z(jsonReader2);
                    }
                }));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    private static f0.e.d.a.b.AbstractC0218d B(JsonReader jsonReader) throws IOException {
        f0.e.d.a.b.AbstractC0218d.AbstractC0219a abstractC0219aA = f0.e.d.a.b.AbstractC0218d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "address":
                    abstractC0219aA.b(jsonReader.nextLong());
                    break;
                case "code":
                    abstractC0219aA.c(jsonReader.nextString());
                    break;
                case "name":
                    abstractC0219aA.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0219aA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f0.e.d.a.b.AbstractC0220e C(JsonReader jsonReader) throws IOException {
        f0.e.d.a.b.AbstractC0220e.AbstractC0221a abstractC0221aA = f0.e.d.a.b.AbstractC0220e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "frames":
                    abstractC0221aA.b(n(jsonReader, d.a));
                    break;
                case "name":
                    abstractC0221aA.d(jsonReader.nextString());
                    break;
                case "importance":
                    abstractC0221aA.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0221aA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f0.d.b D(JsonReader jsonReader) throws IOException {
        f0.d.b.a aVarA = f0.d.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("filename")) {
                aVarA.c(jsonReader.nextString());
            } else if (strNextName.equals("contents")) {
                aVarA.b(Base64.decode(jsonReader.nextString(), 2));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    private static f0.d E(JsonReader jsonReader) throws IOException {
        f0.d.a aVarA = f0.d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("files")) {
                aVarA.b(n(jsonReader, new a() { // from class: com.google.firebase.crashlytics.h.p.h0.g
                    @Override // com.google.firebase.crashlytics.h.p.h0.j.a
                    public final Object a(JsonReader jsonReader2) {
                        return j.D(jsonReader2);
                    }
                }));
            } else if (strNextName.equals("orgId")) {
                aVarA.c(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    private static f0.e.AbstractC0227e F(JsonReader jsonReader) throws IOException {
        f0.e.AbstractC0227e.a aVarA = f0.e.AbstractC0227e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "buildVersion":
                    aVarA.b(jsonReader.nextString());
                    break;
                case "jailbroken":
                    aVarA.c(jsonReader.nextBoolean());
                    break;
                case "version":
                    aVarA.e(jsonReader.nextString());
                    break;
                case "platform":
                    aVarA.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f0.e.d.a.c G(JsonReader jsonReader) throws IOException {
        f0.e.d.a.c.AbstractC0224a abstractC0224aA = f0.e.d.a.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "pid":
                    abstractC0224aA.d(jsonReader.nextInt());
                    break;
                case "processName":
                    abstractC0224aA.e(jsonReader.nextString());
                    break;
                case "defaultProcess":
                    abstractC0224aA.b(jsonReader.nextBoolean());
                    break;
                case "importance":
                    abstractC0224aA.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0224aA.a();
    }

    private static f0 H(JsonReader jsonReader) throws IOException {
        f0.b bVarB = f0.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "ndkPayload":
                    bVarB.i(E(jsonReader));
                    break;
                case "sdkVersion":
                    bVarB.k(jsonReader.nextString());
                    break;
                case "appQualitySessionId":
                    bVarB.c(jsonReader.nextString());
                    break;
                case "appExitInfo":
                    bVarB.b(m(jsonReader));
                    break;
                case "buildVersion":
                    bVarB.d(jsonReader.nextString());
                    break;
                case "gmpAppId":
                    bVarB.g(jsonReader.nextString());
                    break;
                case "installationUuid":
                    bVarB.h(jsonReader.nextString());
                    break;
                case "firebaseInstallationId":
                    bVarB.f(jsonReader.nextString());
                    break;
                case "platform":
                    bVarB.j(jsonReader.nextInt());
                    break;
                case "displayVersion":
                    bVarB.e(jsonReader.nextString());
                    break;
                case "session":
                    bVarB.l(J(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVarB.a();
    }

    private static f0.e.d.AbstractC0226e.b I(JsonReader jsonReader) throws IOException {
        f0.e.d.AbstractC0226e.b.a aVarA = f0.e.d.AbstractC0226e.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("variantId")) {
                aVarA.c(jsonReader.nextString());
            } else if (strNextName.equals("rolloutId")) {
                aVarA.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    private static f0.e J(JsonReader jsonReader) throws IOException {
        f0.e.b bVarA = f0.e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "startedAt":
                    bVarA.m(jsonReader.nextLong());
                    break;
                case "appQualitySessionId":
                    bVarA.c(jsonReader.nextString());
                    break;
                case "identifier":
                    bVarA.k(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case "endedAt":
                    bVarA.f(Long.valueOf(jsonReader.nextLong()));
                    break;
                case "device":
                    bVarA.e(q(jsonReader));
                    break;
                case "events":
                    bVarA.g(n(jsonReader, new a() { // from class: com.google.firebase.crashlytics.h.p.h0.a
                        @Override // com.google.firebase.crashlytics.h.p.h0.j.a
                        public final Object a(JsonReader jsonReader2) {
                            return j.r(jsonReader2);
                        }
                    }));
                    break;
                case "os":
                    bVarA.l(F(jsonReader));
                    break;
                case "app":
                    bVarA.b(l(jsonReader));
                    break;
                case "user":
                    bVarA.n(K(jsonReader));
                    break;
                case "generator":
                    bVarA.h(jsonReader.nextString());
                    break;
                case "crashed":
                    bVarA.d(jsonReader.nextBoolean());
                    break;
                case "generatorType":
                    bVarA.i(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVarA.a();
    }

    private static f0.e.f K(JsonReader jsonReader) throws IOException {
        f0.e.f.a aVarA = f0.e.f.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals("identifier")) {
                aVarA.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    private static f0.e.a l(JsonReader jsonReader) throws IOException {
        f0.e.a.AbstractC0212a abstractC0212aA = f0.e.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "identifier":
                    abstractC0212aA.e(jsonReader.nextString());
                    break;
                case "developmentPlatform":
                    abstractC0212aA.b(jsonReader.nextString());
                    break;
                case "developmentPlatformVersion":
                    abstractC0212aA.c(jsonReader.nextString());
                    break;
                case "version":
                    abstractC0212aA.g(jsonReader.nextString());
                    break;
                case "installationUuid":
                    abstractC0212aA.f(jsonReader.nextString());
                    break;
                case "displayVersion":
                    abstractC0212aA.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0212aA.a();
    }

    private static f0.a m(JsonReader jsonReader) throws IOException {
        f0.a.b bVarA = f0.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "buildIdMappingForArch":
                    bVarA.b(n(jsonReader, new a() { // from class: com.google.firebase.crashlytics.h.p.h0.c
                        @Override // com.google.firebase.crashlytics.h.p.h0.j.a
                        public final Object a(JsonReader jsonReader2) {
                            return j.o(jsonReader2);
                        }
                    }));
                    break;
                case "pid":
                    bVarA.d(jsonReader.nextInt());
                    break;
                case "pss":
                    bVarA.f(jsonReader.nextLong());
                    break;
                case "rss":
                    bVarA.h(jsonReader.nextLong());
                    break;
                case "timestamp":
                    bVarA.i(jsonReader.nextLong());
                    break;
                case "processName":
                    bVarA.e(jsonReader.nextString());
                    break;
                case "reasonCode":
                    bVarA.g(jsonReader.nextInt());
                    break;
                case "traceFile":
                    bVarA.j(jsonReader.nextString());
                    break;
                case "importance":
                    bVarA.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVarA.a();
    }

    private static <T> List<T> n(JsonReader jsonReader, a<T> aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.a(jsonReader));
        }
        jsonReader.endArray();
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f0.a.AbstractC0210a o(JsonReader jsonReader) throws IOException {
        f0.a.AbstractC0210a.AbstractC0211a abstractC0211aA = f0.a.AbstractC0210a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "libraryName":
                    abstractC0211aA.d(jsonReader.nextString());
                    break;
                case "arch":
                    abstractC0211aA.b(jsonReader.nextString());
                    break;
                case "buildId":
                    abstractC0211aA.c(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0211aA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f0.c p(JsonReader jsonReader) throws IOException {
        f0.c.a aVarA = f0.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(RoomNotification.KEY)) {
                aVarA.b(jsonReader.nextString());
            } else if (strNextName.equals("value")) {
                aVarA.c(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    private static f0.e.c q(JsonReader jsonReader) throws IOException {
        f0.e.c.a aVarA = f0.e.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "simulator":
                    aVarA.i(jsonReader.nextBoolean());
                    break;
                case "manufacturer":
                    aVarA.e(jsonReader.nextString());
                    break;
                case "ram":
                    aVarA.h(jsonReader.nextLong());
                    break;
                case "arch":
                    aVarA.b(jsonReader.nextInt());
                    break;
                case "diskSpace":
                    aVarA.d(jsonReader.nextLong());
                    break;
                case "cores":
                    aVarA.c(jsonReader.nextInt());
                    break;
                case "model":
                    aVarA.f(jsonReader.nextString());
                    break;
                case "state":
                    aVarA.j(jsonReader.nextInt());
                    break;
                case "modelClass":
                    aVarA.g(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f0.e.d r(JsonReader jsonReader) throws IOException {
        f0.e.d.b bVarA = f0.e.d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "device":
                    bVarA.c(u(jsonReader));
                    break;
                case "rollouts":
                    bVarA.e(A(jsonReader));
                    break;
                case "app":
                    bVarA.b(s(jsonReader));
                    break;
                case "log":
                    bVarA.d(y(jsonReader));
                    break;
                case "type":
                    bVarA.g(jsonReader.nextString());
                    break;
                case "timestamp":
                    bVarA.f(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVarA.a();
    }

    private static f0.e.d.a s(JsonReader jsonReader) throws IOException {
        f0.e.d.a.AbstractC0213a abstractC0213aA = f0.e.d.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "appProcessDetails":
                    abstractC0213aA.b(n(jsonReader, new a() { // from class: com.google.firebase.crashlytics.h.p.h0.e
                        @Override // com.google.firebase.crashlytics.h.p.h0.j.a
                        public final Object a(JsonReader jsonReader2) {
                            return j.G(jsonReader2);
                        }
                    }));
                    break;
                case "background":
                    abstractC0213aA.c(Boolean.valueOf(jsonReader.nextBoolean()));
                    break;
                case "execution":
                    abstractC0213aA.f(v(jsonReader));
                    break;
                case "internalKeys":
                    abstractC0213aA.g(n(jsonReader, new a() { // from class: com.google.firebase.crashlytics.h.p.h0.i
                        @Override // com.google.firebase.crashlytics.h.p.h0.j.a
                        public final Object a(JsonReader jsonReader2) {
                            return j.p(jsonReader2);
                        }
                    }));
                    break;
                case "customAttributes":
                    abstractC0213aA.e(n(jsonReader, new a() { // from class: com.google.firebase.crashlytics.h.p.h0.i
                        @Override // com.google.firebase.crashlytics.h.p.h0.j.a
                        public final Object a(JsonReader jsonReader2) {
                            return j.p(jsonReader2);
                        }
                    }));
                    break;
                case "uiOrientation":
                    abstractC0213aA.h(jsonReader.nextInt());
                    break;
                case "currentProcessDetails":
                    abstractC0213aA.d(G(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0213aA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f0.e.d.a.b.AbstractC0214a t(JsonReader jsonReader) throws IOException {
        f0.e.d.a.b.AbstractC0214a.AbstractC0215a abstractC0215aA = f0.e.d.a.b.AbstractC0214a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "name":
                    abstractC0215aA.c(jsonReader.nextString());
                    break;
                case "size":
                    abstractC0215aA.d(jsonReader.nextLong());
                    break;
                case "uuid":
                    abstractC0215aA.f(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case "baseAddress":
                    abstractC0215aA.b(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0215aA.a();
    }

    private static f0.e.d.c u(JsonReader jsonReader) throws IOException {
        f0.e.d.c.a aVarA = f0.e.d.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "batteryLevel":
                    aVarA.b(Double.valueOf(jsonReader.nextDouble()));
                    break;
                case "batteryVelocity":
                    aVarA.c(jsonReader.nextInt());
                    break;
                case "orientation":
                    aVarA.e(jsonReader.nextInt());
                    break;
                case "diskUsed":
                    aVarA.d(jsonReader.nextLong());
                    break;
                case "ramUsed":
                    aVarA.g(jsonReader.nextLong());
                    break;
                case "proximityOn":
                    aVarA.f(jsonReader.nextBoolean());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    private static f0.e.d.a.b v(JsonReader jsonReader) throws IOException {
        f0.e.d.a.b.AbstractC0216b abstractC0216bA = f0.e.d.a.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "appExitInfo":
                    abstractC0216bA.b(m(jsonReader));
                    break;
                case "threads":
                    abstractC0216bA.f(n(jsonReader, new a() { // from class: com.google.firebase.crashlytics.h.p.h0.f
                        @Override // com.google.firebase.crashlytics.h.p.h0.j.a
                        public final Object a(JsonReader jsonReader2) {
                            return j.C(jsonReader2);
                        }
                    }));
                    break;
                case "signal":
                    abstractC0216bA.e(B(jsonReader));
                    break;
                case "binaries":
                    abstractC0216bA.c(n(jsonReader, new a() { // from class: com.google.firebase.crashlytics.h.p.h0.h
                        @Override // com.google.firebase.crashlytics.h.p.h0.j.a
                        public final Object a(JsonReader jsonReader2) {
                            return j.t(jsonReader2);
                        }
                    }));
                    break;
                case "exception":
                    abstractC0216bA.d(w(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0216bA.a();
    }

    private static f0.e.d.a.b.c w(JsonReader jsonReader) throws IOException {
        f0.e.d.a.b.c.AbstractC0217a abstractC0217aA = f0.e.d.a.b.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "frames":
                    abstractC0217aA.c(n(jsonReader, d.a));
                    break;
                case "reason":
                    abstractC0217aA.e(jsonReader.nextString());
                    break;
                case "type":
                    abstractC0217aA.f(jsonReader.nextString());
                    break;
                case "causedBy":
                    abstractC0217aA.b(w(jsonReader));
                    break;
                case "overflowCount":
                    abstractC0217aA.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0217aA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f0.e.d.a.b.AbstractC0220e.AbstractC0222b x(JsonReader jsonReader) throws IOException {
        f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a abstractC0223aA = f0.e.d.a.b.AbstractC0220e.AbstractC0222b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "offset":
                    abstractC0223aA.d(jsonReader.nextLong());
                    break;
                case "symbol":
                    abstractC0223aA.f(jsonReader.nextString());
                    break;
                case "pc":
                    abstractC0223aA.e(jsonReader.nextLong());
                    break;
                case "file":
                    abstractC0223aA.b(jsonReader.nextString());
                    break;
                case "importance":
                    abstractC0223aA.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0223aA.a();
    }

    private static f0.e.d.AbstractC0225d y(JsonReader jsonReader) throws IOException {
        f0.e.d.AbstractC0225d.a aVarA = f0.e.d.AbstractC0225d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals("content")) {
                aVarA.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f0.e.d.AbstractC0226e z(JsonReader jsonReader) throws IOException {
        f0.e.d.AbstractC0226e.a aVarA = f0.e.d.AbstractC0226e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "parameterKey":
                    aVarA.b(jsonReader.nextString());
                    break;
                case "templateVersion":
                    aVarA.e(jsonReader.nextLong());
                    break;
                case "rolloutVariant":
                    aVarA.d(I(jsonReader));
                    break;
                case "parameterValue":
                    aVarA.c(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    public f0 L(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                f0 f0VarH = H(jsonReader);
                jsonReader.close();
                return f0VarH;
            } catch (Throwable th) {
                try {
                    jsonReader.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IllegalStateException e2) {
            throw new IOException(e2);
        }
    }

    public String M(f0 f0Var) {
        return a.b(f0Var);
    }

    public f0.e.d a(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                f0.e.d dVarR = r(jsonReader);
                jsonReader.close();
                return dVarR;
            } catch (Throwable th) {
                try {
                    jsonReader.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IllegalStateException e2) {
            throw new IOException(e2);
        }
    }

    public String b(f0.e.d dVar) {
        return a.b(dVar);
    }
}
