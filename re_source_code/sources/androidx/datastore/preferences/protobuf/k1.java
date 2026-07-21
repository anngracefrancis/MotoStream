package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: TextFormatEscaper.java */
/* JADX INFO: loaded from: classes.dex */
final class k1 {

    /* JADX INFO: compiled from: TextFormatEscaper.java */
    static class a implements b {
        final /* synthetic */ h a;

        a(h hVar) {
            this.a = hVar;
        }

        @Override // androidx.datastore.preferences.protobuf.k1.b
        public byte a(int i2) {
            return this.a.f(i2);
        }

        @Override // androidx.datastore.preferences.protobuf.k1.b
        public int size() {
            return this.a.size();
        }
    }

    /* JADX INFO: compiled from: TextFormatEscaper.java */
    private interface b {
        byte a(int i2);

        int size();
    }

    static String a(h hVar) {
        return b(new a(hVar));
    }

    static String b(b bVar) {
        StringBuilder sb = new StringBuilder(bVar.size());
        for (int i2 = 0; i2 < bVar.size(); i2++) {
            byte bA = bVar.a(i2);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                        } else {
                            sb.append((char) bA);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    static String c(String str) {
        return a(h.o(str));
    }
}
