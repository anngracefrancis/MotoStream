package com.airbnb.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: compiled from: PointFParser.java */
/* JADX INFO: loaded from: classes.dex */
public class y implements j0<PointF> {
    public static final y a = new y();

    private y() {
    }

    @Override // com.airbnb.lottie.u.j0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(JsonReader jsonReader, float f2) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        if (jsonTokenPeek == JsonToken.BEGIN_ARRAY) {
            return p.e(jsonReader, f2);
        }
        if (jsonTokenPeek == JsonToken.BEGIN_OBJECT) {
            return p.e(jsonReader, f2);
        }
        if (jsonTokenPeek == JsonToken.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f2, ((float) jsonReader.nextDouble()) * f2);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + jsonTokenPeek);
    }
}
