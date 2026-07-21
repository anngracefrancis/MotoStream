package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class DebugImage implements r2 {
    public static final String JVM = "jvm";
    public static final String PROGUARD = "proguard";
    private String arch;
    private String codeFile;
    private String codeId;
    private String debugFile;
    private String debugId;
    private String imageAddr;
    private Long imageSize;
    private String type;
    private Map<String, Object> unknown;
    private String uuid;

    public static final class a implements l2<DebugImage> {
        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DebugImage a(n2 n2Var, w1 w1Var) throws Exception {
            DebugImage debugImage = new DebugImage();
            n2Var.b();
            HashMap map = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String strB = n2Var.B();
                strB.hashCode();
                switch (strB) {
                    case "debug_file":
                        debugImage.debugFile = n2Var.N0();
                        break;
                    case "image_addr":
                        debugImage.imageAddr = n2Var.N0();
                        break;
                    case "image_size":
                        debugImage.imageSize = n2Var.G0();
                        break;
                    case "code_file":
                        debugImage.codeFile = n2Var.N0();
                        break;
                    case "arch":
                        debugImage.arch = n2Var.N0();
                        break;
                    case "type":
                        debugImage.type = n2Var.N0();
                        break;
                    case "uuid":
                        debugImage.uuid = n2Var.N0();
                        break;
                    case "debug_id":
                        debugImage.debugId = n2Var.N0();
                        break;
                    case "code_id":
                        debugImage.codeId = n2Var.N0();
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        n2Var.R0(w1Var, map, strB);
                        break;
                }
            }
            n2Var.j();
            debugImage.setUnknown(map);
            return debugImage;
        }
    }

    public String getArch() {
        return this.arch;
    }

    public String getCodeFile() {
        return this.codeFile;
    }

    public String getCodeId() {
        return this.codeId;
    }

    public String getDebugFile() {
        return this.debugFile;
    }

    public String getDebugId() {
        return this.debugId;
    }

    public String getImageAddr() {
        return this.imageAddr;
    }

    public Long getImageSize() {
        return this.imageSize;
    }

    public String getType() {
        return this.type;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public String getUuid() {
        return this.uuid;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.uuid != null) {
            h3Var.k("uuid").b(this.uuid);
        }
        if (this.type != null) {
            h3Var.k("type").b(this.type);
        }
        if (this.debugId != null) {
            h3Var.k("debug_id").b(this.debugId);
        }
        if (this.debugFile != null) {
            h3Var.k("debug_file").b(this.debugFile);
        }
        if (this.codeId != null) {
            h3Var.k("code_id").b(this.codeId);
        }
        if (this.codeFile != null) {
            h3Var.k("code_file").b(this.codeFile);
        }
        if (this.imageAddr != null) {
            h3Var.k("image_addr").b(this.imageAddr);
        }
        if (this.imageSize != null) {
            h3Var.k("image_size").e(this.imageSize);
        }
        if (this.arch != null) {
            h3Var.k("arch").b(this.arch);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.unknown.get(str));
            }
        }
        h3Var.d();
    }

    public void setArch(String str) {
        this.arch = str;
    }

    public void setCodeFile(String str) {
        this.codeFile = str;
    }

    public void setCodeId(String str) {
        this.codeId = str;
    }

    public void setDebugFile(String str) {
        this.debugFile = str;
    }

    public void setDebugId(String str) {
        this.debugId = str;
    }

    public void setImageAddr(String str) {
        this.imageAddr = str;
    }

    public void setImageSize(Long l) {
        this.imageSize = l;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setImageSize(long j2) {
        this.imageSize = Long.valueOf(j2);
    }
}
