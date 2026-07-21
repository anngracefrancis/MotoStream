package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import cm.aptoide.pt.BuildConfig;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzapr extends zzaqb {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f14043c = CollectionUtils.g("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f14045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f14050j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f14051k;
    private final Object l;
    private final zzbgz m;
    private final Activity n;
    private zzbin o;
    private ImageView p;
    private LinearLayout q;
    private zzaqc r;
    private PopupWindow s;
    private RelativeLayout t;
    private ViewGroup u;

    public zzapr(zzbgz zzbgzVar, zzaqc zzaqcVar) {
        super(zzbgzVar, "resize");
        this.f14044d = "top-right";
        this.f14045e = true;
        this.f14046f = 0;
        this.f14047g = 0;
        this.f14048h = -1;
        this.f14049i = 0;
        this.f14050j = 0;
        this.f14051k = -1;
        this.l = new Object();
        this.m = zzbgzVar;
        this.n = zzbgzVar.a();
        this.r = zzaqcVar;
    }

    public final void h(int i2, int i3, boolean z) {
        synchronized (this.l) {
            this.f14046f = i2;
            this.f14047g = i3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0233  */
    /* JADX WARN: Code duplicated, block: B:121:0x0235 A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:138:0x0291, B:139:0x0296, B:141:0x0298, B:143:0x02ba, B:145:0x02be, B:147:0x02ce, B:149:0x02fe, B:153:0x0330, B:154:0x0364, B:184:0x03ba, B:191:0x03e9, B:192:0x0401, B:193:0x0420, B:195:0x0428, B:196:0x042f, B:197:0x0455, B:200:0x0458, B:202:0x0468, B:204:0x0472, B:206:0x0484, B:207:0x049b, B:203:0x046d, B:185:0x03c1, B:186:0x03c8, B:187:0x03cf, B:188:0x03d6, B:189:0x03dc, B:190:0x03e3, B:156:0x0368, B:159:0x0372, B:162:0x037c, B:165:0x0386, B:168:0x0390, B:171:0x039a, B:148:0x02fb, B:209:0x049d, B:210:0x04a2, B:121:0x0235, B:123:0x0239, B:124:0x024a, B:130:0x0276, B:132:0x027a, B:136:0x0289, B:133:0x027d, B:135:0x0285, B:127:0x026e, B:129:0x0274, B:68:0x014b, B:70:0x014f, B:71:0x0155, B:98:0x01a2, B:106:0x0213, B:108:0x0216, B:110:0x0219, B:112:0x021d, B:99:0x01b0, B:102:0x01e0, B:100:0x01c1, B:101:0x01d4, B:103:0x01e3, B:104:0x01fa, B:105:0x020a, B:73:0x0159, B:76:0x0163, B:79:0x016d, B:82:0x0177, B:85:0x0181, B:88:0x018b, B:116:0x0225, B:117:0x022b, B:212:0x04a4, B:213:0x04a9), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0239 A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:138:0x0291, B:139:0x0296, B:141:0x0298, B:143:0x02ba, B:145:0x02be, B:147:0x02ce, B:149:0x02fe, B:153:0x0330, B:154:0x0364, B:184:0x03ba, B:191:0x03e9, B:192:0x0401, B:193:0x0420, B:195:0x0428, B:196:0x042f, B:197:0x0455, B:200:0x0458, B:202:0x0468, B:204:0x0472, B:206:0x0484, B:207:0x049b, B:203:0x046d, B:185:0x03c1, B:186:0x03c8, B:187:0x03cf, B:188:0x03d6, B:189:0x03dc, B:190:0x03e3, B:156:0x0368, B:159:0x0372, B:162:0x037c, B:165:0x0386, B:168:0x0390, B:171:0x039a, B:148:0x02fb, B:209:0x049d, B:210:0x04a2, B:121:0x0235, B:123:0x0239, B:124:0x024a, B:130:0x0276, B:132:0x027a, B:136:0x0289, B:133:0x027d, B:135:0x0285, B:127:0x026e, B:129:0x0274, B:68:0x014b, B:70:0x014f, B:71:0x0155, B:98:0x01a2, B:106:0x0213, B:108:0x0216, B:110:0x0219, B:112:0x021d, B:99:0x01b0, B:102:0x01e0, B:100:0x01c1, B:101:0x01d4, B:103:0x01e3, B:104:0x01fa, B:105:0x020a, B:73:0x0159, B:76:0x0163, B:79:0x016d, B:82:0x0177, B:85:0x0181, B:88:0x018b, B:116:0x0225, B:117:0x022b, B:212:0x04a4, B:213:0x04a9), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x024a A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:138:0x0291, B:139:0x0296, B:141:0x0298, B:143:0x02ba, B:145:0x02be, B:147:0x02ce, B:149:0x02fe, B:153:0x0330, B:154:0x0364, B:184:0x03ba, B:191:0x03e9, B:192:0x0401, B:193:0x0420, B:195:0x0428, B:196:0x042f, B:197:0x0455, B:200:0x0458, B:202:0x0468, B:204:0x0472, B:206:0x0484, B:207:0x049b, B:203:0x046d, B:185:0x03c1, B:186:0x03c8, B:187:0x03cf, B:188:0x03d6, B:189:0x03dc, B:190:0x03e3, B:156:0x0368, B:159:0x0372, B:162:0x037c, B:165:0x0386, B:168:0x0390, B:171:0x039a, B:148:0x02fb, B:209:0x049d, B:210:0x04a2, B:121:0x0235, B:123:0x0239, B:124:0x024a, B:130:0x0276, B:132:0x027a, B:136:0x0289, B:133:0x027d, B:135:0x0285, B:127:0x026e, B:129:0x0274, B:68:0x014b, B:70:0x014f, B:71:0x0155, B:98:0x01a2, B:106:0x0213, B:108:0x0216, B:110:0x0219, B:112:0x021d, B:99:0x01b0, B:102:0x01e0, B:100:0x01c1, B:101:0x01d4, B:103:0x01e3, B:104:0x01fa, B:105:0x020a, B:73:0x0159, B:76:0x0163, B:79:0x016d, B:82:0x0177, B:85:0x0181, B:88:0x018b, B:116:0x0225, B:117:0x022b, B:212:0x04a4, B:213:0x04a9), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x026c  */
    /* JADX WARN: Code duplicated, block: B:127:0x026e A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:138:0x0291, B:139:0x0296, B:141:0x0298, B:143:0x02ba, B:145:0x02be, B:147:0x02ce, B:149:0x02fe, B:153:0x0330, B:154:0x0364, B:184:0x03ba, B:191:0x03e9, B:192:0x0401, B:193:0x0420, B:195:0x0428, B:196:0x042f, B:197:0x0455, B:200:0x0458, B:202:0x0468, B:204:0x0472, B:206:0x0484, B:207:0x049b, B:203:0x046d, B:185:0x03c1, B:186:0x03c8, B:187:0x03cf, B:188:0x03d6, B:189:0x03dc, B:190:0x03e3, B:156:0x0368, B:159:0x0372, B:162:0x037c, B:165:0x0386, B:168:0x0390, B:171:0x039a, B:148:0x02fb, B:209:0x049d, B:210:0x04a2, B:121:0x0235, B:123:0x0239, B:124:0x024a, B:130:0x0276, B:132:0x027a, B:136:0x0289, B:133:0x027d, B:135:0x0285, B:127:0x026e, B:129:0x0274, B:68:0x014b, B:70:0x014f, B:71:0x0155, B:98:0x01a2, B:106:0x0213, B:108:0x0216, B:110:0x0219, B:112:0x021d, B:99:0x01b0, B:102:0x01e0, B:100:0x01c1, B:101:0x01d4, B:103:0x01e3, B:104:0x01fa, B:105:0x020a, B:73:0x0159, B:76:0x0163, B:79:0x016d, B:82:0x0177, B:85:0x0181, B:88:0x018b, B:116:0x0225, B:117:0x022b, B:212:0x04a4, B:213:0x04a9), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x0274 A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:138:0x0291, B:139:0x0296, B:141:0x0298, B:143:0x02ba, B:145:0x02be, B:147:0x02ce, B:149:0x02fe, B:153:0x0330, B:154:0x0364, B:184:0x03ba, B:191:0x03e9, B:192:0x0401, B:193:0x0420, B:195:0x0428, B:196:0x042f, B:197:0x0455, B:200:0x0458, B:202:0x0468, B:204:0x0472, B:206:0x0484, B:207:0x049b, B:203:0x046d, B:185:0x03c1, B:186:0x03c8, B:187:0x03cf, B:188:0x03d6, B:189:0x03dc, B:190:0x03e3, B:156:0x0368, B:159:0x0372, B:162:0x037c, B:165:0x0386, B:168:0x0390, B:171:0x039a, B:148:0x02fb, B:209:0x049d, B:210:0x04a2, B:121:0x0235, B:123:0x0239, B:124:0x024a, B:130:0x0276, B:132:0x027a, B:136:0x0289, B:133:0x027d, B:135:0x0285, B:127:0x026e, B:129:0x0274, B:68:0x014b, B:70:0x014f, B:71:0x0155, B:98:0x01a2, B:106:0x0213, B:108:0x0216, B:110:0x0219, B:112:0x021d, B:99:0x01b0, B:102:0x01e0, B:100:0x01c1, B:101:0x01d4, B:103:0x01e3, B:104:0x01fa, B:105:0x020a, B:73:0x0159, B:76:0x0163, B:79:0x016d, B:82:0x0177, B:85:0x0181, B:88:0x018b, B:116:0x0225, B:117:0x022b, B:212:0x04a4, B:213:0x04a9), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x027a A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:138:0x0291, B:139:0x0296, B:141:0x0298, B:143:0x02ba, B:145:0x02be, B:147:0x02ce, B:149:0x02fe, B:153:0x0330, B:154:0x0364, B:184:0x03ba, B:191:0x03e9, B:192:0x0401, B:193:0x0420, B:195:0x0428, B:196:0x042f, B:197:0x0455, B:200:0x0458, B:202:0x0468, B:204:0x0472, B:206:0x0484, B:207:0x049b, B:203:0x046d, B:185:0x03c1, B:186:0x03c8, B:187:0x03cf, B:188:0x03d6, B:189:0x03dc, B:190:0x03e3, B:156:0x0368, B:159:0x0372, B:162:0x037c, B:165:0x0386, B:168:0x0390, B:171:0x039a, B:148:0x02fb, B:209:0x049d, B:210:0x04a2, B:121:0x0235, B:123:0x0239, B:124:0x024a, B:130:0x0276, B:132:0x027a, B:136:0x0289, B:133:0x027d, B:135:0x0285, B:127:0x026e, B:129:0x0274, B:68:0x014b, B:70:0x014f, B:71:0x0155, B:98:0x01a2, B:106:0x0213, B:108:0x0216, B:110:0x0219, B:112:0x021d, B:99:0x01b0, B:102:0x01e0, B:100:0x01c1, B:101:0x01d4, B:103:0x01e3, B:104:0x01fa, B:105:0x020a, B:73:0x0159, B:76:0x0163, B:79:0x016d, B:82:0x0177, B:85:0x0181, B:88:0x018b, B:116:0x0225, B:117:0x022b, B:212:0x04a4, B:213:0x04a9), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x027d A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:138:0x0291, B:139:0x0296, B:141:0x0298, B:143:0x02ba, B:145:0x02be, B:147:0x02ce, B:149:0x02fe, B:153:0x0330, B:154:0x0364, B:184:0x03ba, B:191:0x03e9, B:192:0x0401, B:193:0x0420, B:195:0x0428, B:196:0x042f, B:197:0x0455, B:200:0x0458, B:202:0x0468, B:204:0x0472, B:206:0x0484, B:207:0x049b, B:203:0x046d, B:185:0x03c1, B:186:0x03c8, B:187:0x03cf, B:188:0x03d6, B:189:0x03dc, B:190:0x03e3, B:156:0x0368, B:159:0x0372, B:162:0x037c, B:165:0x0386, B:168:0x0390, B:171:0x039a, B:148:0x02fb, B:209:0x049d, B:210:0x04a2, B:121:0x0235, B:123:0x0239, B:124:0x024a, B:130:0x0276, B:132:0x027a, B:136:0x0289, B:133:0x027d, B:135:0x0285, B:127:0x026e, B:129:0x0274, B:68:0x014b, B:70:0x014f, B:71:0x0155, B:98:0x01a2, B:106:0x0213, B:108:0x0216, B:110:0x0219, B:112:0x021d, B:99:0x01b0, B:102:0x01e0, B:100:0x01c1, B:101:0x01d4, B:103:0x01e3, B:104:0x01fa, B:105:0x020a, B:73:0x0159, B:76:0x0163, B:79:0x016d, B:82:0x0177, B:85:0x0181, B:88:0x018b, B:116:0x0225, B:117:0x022b, B:212:0x04a4, B:213:0x04a9), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0285 A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:138:0x0291, B:139:0x0296, B:141:0x0298, B:143:0x02ba, B:145:0x02be, B:147:0x02ce, B:149:0x02fe, B:153:0x0330, B:154:0x0364, B:184:0x03ba, B:191:0x03e9, B:192:0x0401, B:193:0x0420, B:195:0x0428, B:196:0x042f, B:197:0x0455, B:200:0x0458, B:202:0x0468, B:204:0x0472, B:206:0x0484, B:207:0x049b, B:203:0x046d, B:185:0x03c1, B:186:0x03c8, B:187:0x03cf, B:188:0x03d6, B:189:0x03dc, B:190:0x03e3, B:156:0x0368, B:159:0x0372, B:162:0x037c, B:165:0x0386, B:168:0x0390, B:171:0x039a, B:148:0x02fb, B:209:0x049d, B:210:0x04a2, B:121:0x0235, B:123:0x0239, B:124:0x024a, B:130:0x0276, B:132:0x027a, B:136:0x0289, B:133:0x027d, B:135:0x0285, B:127:0x026e, B:129:0x0274, B:68:0x014b, B:70:0x014f, B:71:0x0155, B:98:0x01a2, B:106:0x0213, B:108:0x0216, B:110:0x0219, B:112:0x021d, B:99:0x01b0, B:102:0x01e0, B:100:0x01c1, B:101:0x01d4, B:103:0x01e3, B:104:0x01fa, B:105:0x020a, B:73:0x0159, B:76:0x0163, B:79:0x016d, B:82:0x0177, B:85:0x0181, B:88:0x018b, B:116:0x0225, B:117:0x022b, B:212:0x04a4, B:213:0x04a9), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0291 A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:138:0x0291, B:139:0x0296, B:141:0x0298, B:143:0x02ba, B:145:0x02be, B:147:0x02ce, B:149:0x02fe, B:153:0x0330, B:154:0x0364, B:184:0x03ba, B:191:0x03e9, B:192:0x0401, B:193:0x0420, B:195:0x0428, B:196:0x042f, B:197:0x0455, B:200:0x0458, B:202:0x0468, B:204:0x0472, B:206:0x0484, B:207:0x049b, B:203:0x046d, B:185:0x03c1, B:186:0x03c8, B:187:0x03cf, B:188:0x03d6, B:189:0x03dc, B:190:0x03e3, B:156:0x0368, B:159:0x0372, B:162:0x037c, B:165:0x0386, B:168:0x0390, B:171:0x039a, B:148:0x02fb, B:209:0x049d, B:210:0x04a2, B:121:0x0235, B:123:0x0239, B:124:0x024a, B:130:0x0276, B:132:0x027a, B:136:0x0289, B:133:0x027d, B:135:0x0285, B:127:0x026e, B:129:0x0274, B:68:0x014b, B:70:0x014f, B:71:0x0155, B:98:0x01a2, B:106:0x0213, B:108:0x0216, B:110:0x0219, B:112:0x021d, B:99:0x01b0, B:102:0x01e0, B:100:0x01c1, B:101:0x01d4, B:103:0x01e3, B:104:0x01fa, B:105:0x020a, B:73:0x0159, B:76:0x0163, B:79:0x016d, B:82:0x0177, B:85:0x0181, B:88:0x018b, B:116:0x0225, B:117:0x022b, B:212:0x04a4, B:213:0x04a9), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0298 A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:138:0x0291, B:139:0x0296, B:141:0x0298, B:143:0x02ba, B:145:0x02be, B:147:0x02ce, B:149:0x02fe, B:153:0x0330, B:154:0x0364, B:184:0x03ba, B:191:0x03e9, B:192:0x0401, B:193:0x0420, B:195:0x0428, B:196:0x042f, B:197:0x0455, B:200:0x0458, B:202:0x0468, B:204:0x0472, B:206:0x0484, B:207:0x049b, B:203:0x046d, B:185:0x03c1, B:186:0x03c8, B:187:0x03cf, B:188:0x03d6, B:189:0x03dc, B:190:0x03e3, B:156:0x0368, B:159:0x0372, B:162:0x037c, B:165:0x0386, B:168:0x0390, B:171:0x039a, B:148:0x02fb, B:209:0x049d, B:210:0x04a2, B:121:0x0235, B:123:0x0239, B:124:0x024a, B:130:0x0276, B:132:0x027a, B:136:0x0289, B:133:0x027d, B:135:0x0285, B:127:0x026e, B:129:0x0274, B:68:0x014b, B:70:0x014f, B:71:0x0155, B:98:0x01a2, B:106:0x0213, B:108:0x0216, B:110:0x0219, B:112:0x021d, B:99:0x01b0, B:102:0x01e0, B:100:0x01c1, B:101:0x01d4, B:103:0x01e3, B:104:0x01fa, B:105:0x020a, B:73:0x0159, B:76:0x0163, B:79:0x016d, B:82:0x0177, B:85:0x0181, B:88:0x018b, B:116:0x0225, B:117:0x022b, B:212:0x04a4, B:213:0x04a9), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x02ba A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:138:0x0291, B:139:0x0296, B:141:0x0298, B:143:0x02ba, B:145:0x02be, B:147:0x02ce, B:149:0x02fe, B:153:0x0330, B:154:0x0364, B:184:0x03ba, B:191:0x03e9, B:192:0x0401, B:193:0x0420, B:195:0x0428, B:196:0x042f, B:197:0x0455, B:200:0x0458, B:202:0x0468, B:204:0x0472, B:206:0x0484, B:207:0x049b, B:203:0x046d, B:185:0x03c1, B:186:0x03c8, B:187:0x03cf, B:188:0x03d6, B:189:0x03dc, B:190:0x03e3, B:156:0x0368, B:159:0x0372, B:162:0x037c, B:165:0x0386, B:168:0x0390, B:171:0x039a, B:148:0x02fb, B:209:0x049d, B:210:0x04a2, B:121:0x0235, B:123:0x0239, B:124:0x024a, B:130:0x0276, B:132:0x027a, B:136:0x0289, B:133:0x027d, B:135:0x0285, B:127:0x026e, B:129:0x0274, B:68:0x014b, B:70:0x014f, B:71:0x0155, B:98:0x01a2, B:106:0x0213, B:108:0x0216, B:110:0x0219, B:112:0x021d, B:99:0x01b0, B:102:0x01e0, B:100:0x01c1, B:101:0x01d4, B:103:0x01e3, B:104:0x01fa, B:105:0x020a, B:73:0x0159, B:76:0x0163, B:79:0x016d, B:82:0x0177, B:85:0x0181, B:88:0x018b, B:116:0x0225, B:117:0x022b, B:212:0x04a4, B:213:0x04a9), top: B:220:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0195  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void i(Map<String, String> map) {
        boolean z;
        int[] iArrW;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        ViewParent parent;
        byte b2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        synchronized (this.l) {
            if (this.n == null) {
                e("Not an activity context. Cannot resize.");
                return;
            }
            if (this.m.o() == null) {
                e("Webview is not yet available, size is not set.");
                return;
            }
            if (this.m.o().e()) {
                e("Is interstitial. Cannot resize an interstitial.");
                return;
            }
            if (this.m.m()) {
                e("Cannot resize an expanded banner.");
                return;
            }
            if (!TextUtils.isEmpty(map.get("width"))) {
                zzk.zzlg();
                this.f14051k = zzaxi.Q(map.get("width"));
            }
            if (!TextUtils.isEmpty(map.get("height"))) {
                zzk.zzlg();
                this.f14048h = zzaxi.Q(map.get("height"));
            }
            if (!TextUtils.isEmpty(map.get("offsetX"))) {
                zzk.zzlg();
                this.f14049i = zzaxi.Q(map.get("offsetX"));
            }
            if (!TextUtils.isEmpty(map.get("offsetY"))) {
                zzk.zzlg();
                this.f14050j = zzaxi.Q(map.get("offsetY"));
            }
            if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
                this.f14045e = Boolean.parseBoolean(map.get("allowOffscreen"));
            }
            String str = map.get("customClosePosition");
            if (!TextUtils.isEmpty(str)) {
                this.f14044d = str;
            }
            if (!(this.f14051k >= 0 && this.f14048h >= 0)) {
                e("Invalid width and height options. Cannot resize.");
                return;
            }
            Window window = this.n.getWindow();
            if (window != null && window.getDecorView() != null) {
                int[] iArrS = zzk.zzlg().S(this.n);
                int[] iArrW2 = zzk.zzlg().W(this.n);
                int i13 = iArrS[0];
                int i14 = iArrS[1];
                int i15 = this.f14051k;
                byte b3 = -1;
                if (i15 < 50 || i15 > i13) {
                    zzbad.i("Width is too small or too large.");
                } else {
                    int i16 = this.f14048h;
                    if (i16 < 50 || i16 > i14) {
                        zzbad.i("Height is too small or too large.");
                    } else {
                        if (i16 != i14 || i15 != i13) {
                            if (this.f14045e) {
                                String str2 = this.f14044d;
                                switch (str2.hashCode()) {
                                    case -1364013995:
                                        if (!str2.equals("center")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 2;
                                        }
                                        break;
                                    case -1012429441:
                                        if (!str2.equals("top-left")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 0;
                                        }
                                        break;
                                    case -655373719:
                                        if (!str2.equals("bottom-left")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 3;
                                        }
                                        break;
                                    case 1163912186:
                                        if (!str2.equals("bottom-right")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 5;
                                        }
                                        break;
                                    case 1288627767:
                                        if (!str2.equals("bottom-center")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 4;
                                        }
                                        break;
                                    case 1755462605:
                                        if (!str2.equals("top-center")) {
                                            b2 = -1;
                                        } else {
                                            b2 = 1;
                                        }
                                        break;
                                    default:
                                        b2 = -1;
                                        break;
                                }
                                if (b2 == 0) {
                                    i7 = this.f14046f + this.f14049i;
                                    i8 = this.f14047g;
                                    i9 = this.f14050j;
                                } else {
                                    if (b2 != 1) {
                                        if (b2 != 2) {
                                            if (b2 == 3) {
                                                i7 = this.f14046f + this.f14049i;
                                                i11 = this.f14047g + this.f14050j;
                                                i12 = this.f14048h;
                                            } else if (b2 == 4) {
                                                i7 = ((this.f14046f + this.f14049i) + (this.f14051k / 2)) - 25;
                                                i11 = this.f14047g + this.f14050j;
                                                i12 = this.f14048h;
                                            } else if (b2 != 5) {
                                                i7 = ((this.f14046f + this.f14049i) + this.f14051k) - 50;
                                                i8 = this.f14047g;
                                                i9 = this.f14050j;
                                            } else {
                                                i7 = ((this.f14046f + this.f14049i) + this.f14051k) - 50;
                                                i11 = this.f14047g + this.f14050j;
                                                i12 = this.f14048h;
                                            }
                                            i10 = (i11 + i12) - 50;
                                        } else {
                                            i7 = ((this.f14046f + this.f14049i) + (this.f14051k / 2)) - 25;
                                            i10 = ((this.f14047g + this.f14050j) + (this.f14048h / 2)) - 25;
                                        }
                                        if (i7 >= 0 || i7 + 50 > i13 || i10 < iArrW2[0] || i10 + 50 > iArrW2[1]) {
                                        }
                                        if (!z) {
                                            iArr = null;
                                        } else if (this.f14045e) {
                                            iArr = new int[]{this.f14046f + this.f14049i, this.f14047g + this.f14050j};
                                        } else {
                                            int[] iArrS2 = zzk.zzlg().S(this.n);
                                            iArrW = zzk.zzlg().W(this.n);
                                            i2 = iArrS2[0];
                                            i3 = this.f14046f + this.f14049i;
                                            i4 = this.f14047g + this.f14050j;
                                            if (i3 < 0) {
                                                i3 = 0;
                                            } else {
                                                i5 = this.f14051k;
                                                if (i3 + i5 > i2) {
                                                    i3 = i2 - i5;
                                                }
                                            }
                                            if (i4 < iArrW[0]) {
                                                i4 = iArrW[0];
                                            } else {
                                                i6 = this.f14048h;
                                                if (i4 + i6 > iArrW[1]) {
                                                    i4 = iArrW[1] - i6;
                                                }
                                            }
                                            iArr = new int[]{i3, i4};
                                        }
                                        if (iArr == null) {
                                            e("Resize location out of screen or close button is not visible.");
                                            return;
                                        }
                                        zzyt.a();
                                        int iA = zzazt.a(this.n, this.f14051k);
                                        zzyt.a();
                                        int iA2 = zzazt.a(this.n, this.f14048h);
                                        parent = this.m.getView().getParent();
                                        if (parent != null || !(parent instanceof ViewGroup)) {
                                            e("Webview is detached, probably in the middle of a resize or expand.");
                                            return;
                                        }
                                        ((ViewGroup) parent).removeView(this.m.getView());
                                        PopupWindow popupWindow = this.s;
                                        if (popupWindow == null) {
                                            this.u = (ViewGroup) parent;
                                            zzk.zzlg();
                                            Bitmap bitmapZ = zzaxi.Z(this.m.getView());
                                            ImageView imageView = new ImageView(this.n);
                                            this.p = imageView;
                                            imageView.setImageBitmap(bitmapZ);
                                            this.o = this.m.o();
                                            this.u.addView(this.p);
                                        } else {
                                            popupWindow.dismiss();
                                        }
                                        RelativeLayout relativeLayout = new RelativeLayout(this.n);
                                        this.t = relativeLayout;
                                        relativeLayout.setBackgroundColor(0);
                                        this.t.setLayoutParams(new ViewGroup.LayoutParams(iA, iA2));
                                        zzk.zzlg();
                                        PopupWindow popupWindowC = zzaxi.c(this.t, iA, iA2, false);
                                        this.s = popupWindowC;
                                        popupWindowC.setOutsideTouchable(true);
                                        this.s.setTouchable(true);
                                        this.s.setClippingEnabled(!this.f14045e);
                                        this.t.addView(this.m.getView(), -1, -1);
                                        this.q = new LinearLayout(this.n);
                                        zzyt.a();
                                        int iA3 = zzazt.a(this.n, 50);
                                        zzyt.a();
                                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA3, zzazt.a(this.n, 50));
                                        String str3 = this.f14044d;
                                        switch (str3.hashCode()) {
                                            case -1364013995:
                                                if (str3.equals("center")) {
                                                    b3 = 2;
                                                }
                                                break;
                                            case -1012429441:
                                                if (str3.equals("top-left")) {
                                                    b3 = 0;
                                                }
                                                break;
                                            case -655373719:
                                                if (str3.equals("bottom-left")) {
                                                    b3 = 3;
                                                }
                                                break;
                                            case 1163912186:
                                                if (str3.equals("bottom-right")) {
                                                    b3 = 5;
                                                }
                                                break;
                                            case 1288627767:
                                                if (str3.equals("bottom-center")) {
                                                    b3 = 4;
                                                }
                                                break;
                                            case 1755462605:
                                                if (str3.equals("top-center")) {
                                                    b3 = 1;
                                                }
                                                break;
                                        }
                                        if (b3 == 0) {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(9);
                                        } else if (b3 == 1) {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(14);
                                        } else if (b3 == 2) {
                                            layoutParams.addRule(13);
                                        } else if (b3 == 3) {
                                            layoutParams.addRule(12);
                                            layoutParams.addRule(9);
                                        } else if (b3 == 4) {
                                            layoutParams.addRule(12);
                                            layoutParams.addRule(14);
                                        } else if (b3 != 5) {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(11);
                                        } else {
                                            layoutParams.addRule(12);
                                            layoutParams.addRule(11);
                                        }
                                        this.q.setOnClickListener(new j3(this));
                                        this.q.setContentDescription("Close button");
                                        this.t.addView(this.q, layoutParams);
                                        try {
                                            PopupWindow popupWindow2 = this.s;
                                            View decorView = window.getDecorView();
                                            zzyt.a();
                                            int iA4 = zzazt.a(this.n, iArr[0]);
                                            zzyt.a();
                                            popupWindow2.showAtLocation(decorView, 0, iA4, zzazt.a(this.n, iArr[1]));
                                            int i17 = iArr[0];
                                            int i18 = iArr[1];
                                            zzaqc zzaqcVar = this.r;
                                            if (zzaqcVar != null) {
                                                zzaqcVar.b(i17, i18, this.f14051k, this.f14048h);
                                            }
                                            this.m.A(zzbin.j(iA, iA2));
                                            b(iArr[0], iArr[1] - zzk.zzlg().W(this.n)[0], this.f14051k, this.f14048h);
                                            g("resized");
                                            return;
                                        } catch (RuntimeException e2) {
                                            String strValueOf = String.valueOf(e2.getMessage());
                                            e(strValueOf.length() != 0 ? "Cannot show popup window: ".concat(strValueOf) : new String("Cannot show popup window: "));
                                            this.t.removeView(this.m.getView());
                                            ViewGroup viewGroup = this.u;
                                            if (viewGroup != null) {
                                                viewGroup.removeView(this.p);
                                                this.u.addView(this.m.getView());
                                                this.m.A(this.o);
                                            }
                                            return;
                                        }
                                    }
                                    i7 = ((this.f14046f + this.f14049i) + (this.f14051k / 2)) - 25;
                                    i8 = this.f14047g;
                                    i9 = this.f14050j;
                                }
                                i10 = i8 + i9;
                                if (i7 >= 0) {
                                }
                            }
                            z = true;
                            if (!z) {
                                iArr = null;
                            } else if (this.f14045e) {
                                iArr = new int[]{this.f14046f + this.f14049i, this.f14047g + this.f14050j};
                            } else {
                                int[] iArrS3 = zzk.zzlg().S(this.n);
                                iArrW = zzk.zzlg().W(this.n);
                                i2 = iArrS3[0];
                                i3 = this.f14046f + this.f14049i;
                                i4 = this.f14047g + this.f14050j;
                                if (i3 < 0) {
                                    i3 = 0;
                                } else {
                                    i5 = this.f14051k;
                                    if (i3 + i5 > i2) {
                                        i3 = i2 - i5;
                                    }
                                }
                                if (i4 < iArrW[0]) {
                                    i4 = iArrW[0];
                                } else {
                                    i6 = this.f14048h;
                                    if (i4 + i6 > iArrW[1]) {
                                        i4 = iArrW[1] - i6;
                                    }
                                }
                                iArr = new int[]{i3, i4};
                            }
                            if (iArr == null) {
                                e("Resize location out of screen or close button is not visible.");
                                return;
                            }
                            zzyt.a();
                            int iA5 = zzazt.a(this.n, this.f14051k);
                            zzyt.a();
                            int iA6 = zzazt.a(this.n, this.f14048h);
                            parent = this.m.getView().getParent();
                            if (parent != null) {
                            }
                            e("Webview is detached, probably in the middle of a resize or expand.");
                            return;
                        }
                        zzbad.i("Cannot resize to a full-screen ad.");
                    }
                }
                z = false;
                if (!z) {
                    iArr = null;
                } else if (this.f14045e) {
                    iArr = new int[]{this.f14046f + this.f14049i, this.f14047g + this.f14050j};
                } else {
                    int[] iArrS4 = zzk.zzlg().S(this.n);
                    iArrW = zzk.zzlg().W(this.n);
                    i2 = iArrS4[0];
                    i3 = this.f14046f + this.f14049i;
                    i4 = this.f14047g + this.f14050j;
                    if (i3 < 0) {
                        i3 = 0;
                    } else {
                        i5 = this.f14051k;
                        if (i3 + i5 > i2) {
                            i3 = i2 - i5;
                        }
                    }
                    if (i4 < iArrW[0]) {
                        i4 = iArrW[0];
                    } else {
                        i6 = this.f14048h;
                        if (i4 + i6 > iArrW[1]) {
                            i4 = iArrW[1] - i6;
                        }
                    }
                    iArr = new int[]{i3, i4};
                }
                if (iArr == null) {
                    e("Resize location out of screen or close button is not visible.");
                    return;
                }
                zzyt.a();
                int iA7 = zzazt.a(this.n, this.f14051k);
                zzyt.a();
                int iA8 = zzazt.a(this.n, this.f14048h);
                parent = this.m.getView().getParent();
                if (parent != null) {
                }
                e("Webview is detached, probably in the middle of a resize or expand.");
                return;
            }
            e("Activity context is not ready, cannot get window or decor view.");
        }
    }

    public final void j(int i2, int i3) {
        this.f14046f = i2;
        this.f14047g = i3;
    }

    public final boolean k() {
        boolean z;
        synchronized (this.l) {
            z = this.s != null;
        }
        return z;
    }

    public final void l(boolean z) {
        synchronized (this.l) {
            PopupWindow popupWindow = this.s;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.t.removeView(this.m.getView());
                ViewGroup viewGroup = this.u;
                if (viewGroup != null) {
                    viewGroup.removeView(this.p);
                    this.u.addView(this.m.getView());
                    this.m.A(this.o);
                }
                if (z) {
                    g(BuildConfig.APTOIDE_THEME);
                    zzaqc zzaqcVar = this.r;
                    if (zzaqcVar != null) {
                        zzaqcVar.c();
                    }
                }
                this.s = null;
                this.t = null;
                this.u = null;
                this.q = null;
            }
        }
    }
}
