package cm.aptoide.pt.networking.image;

import android.content.Context;
import com.bumptech.glide.Registry;
import com.bumptech.glide.c;
import com.bumptech.glide.d;
import com.bumptech.glide.load.engine.a0.g;
import com.bumptech.glide.load.engine.a0.i;
import com.bumptech.glide.load.engine.z.k;
import com.bumptech.glide.n.b;
import com.bumptech.glide.p.h;

/* JADX INFO: loaded from: classes.dex */
public class GlideModifications implements b {
    @Override // com.bumptech.glide.n.b
    public void applyOptions(Context context, d dVar) {
        dVar.c(h.u0(com.bumptech.glide.load.b.PREFER_RGB_565));
        i iVarA = new i.a(context).a();
        dVar.d(new g(iVarA.d()));
        dVar.b(new k(iVarA.b()));
    }

    @Override // com.bumptech.glide.n.b
    public void registerComponents(Context context, c cVar, Registry registry) {
    }
}
