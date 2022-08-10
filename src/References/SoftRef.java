package References;

import java.lang.ref.SoftReference;

public class SoftRef {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        SoftReference softBuilder = new SoftReference(builder);
        builder = null;

        // так можно вернуть strong ссылку и очистить soft ссылку
        builder = (StringBuilder) softBuilder.get();
        softBuilder.clear();


    }
}
