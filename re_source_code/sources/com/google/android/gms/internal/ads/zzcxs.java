package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcxs {
    public final List<zzcxm> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzcxo f15744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<zzcxt> f15745c;

    private zzcxs(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        List<zzcxm> listEmptyList = Collections.emptyList();
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        zzcxo zzcxoVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if ("responses".equals(strNextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(strNextName2)) {
                        listEmptyList = new ArrayList<>();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            listEmptyList.add(new zzcxm(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (strNextName2.equals("common")) {
                        zzcxoVar = new zzcxo(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (strNextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String strNextString = null;
                    Map<String, String> mapJ = null;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        if ("name".equals(strNextName3)) {
                            strNextString = jsonReader.nextString();
                        } else if ("info".equals(strNextName3)) {
                            mapJ = zzazc.j(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (strNextString != null) {
                        arrayList.add(new zzcxt(strNextString, mapJ));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.f15745c = arrayList;
        this.a = listEmptyList;
        this.f15744b = zzcxoVar == null ? new zzcxo(new JsonReader(new StringReader("{}"))) : zzcxoVar;
    }

    public static zzcxs a(Reader reader) throws zzcxp {
        try {
            try {
                zzcxs zzcxsVar = new zzcxs(new JsonReader(reader));
                IOUtils.a(reader);
                return zzcxsVar;
            } catch (Throwable th) {
                IOUtils.a(reader);
                throw th;
            }
        } catch (IOException | IllegalStateException | NumberFormatException | JSONException e2) {
            throw new zzcxp("unable to parse ServerResponse", e2);
        }
    }
}
