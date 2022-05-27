package Files.Zip.PoVideo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

// Видео: https://www.youtube.com/watch?v=_vNwJMNHj0w&ab_channel=%D0%98%D0%B7%D1%83%D1%87%D0%B0%D0%B5%D0%BCJava

public class ChtenieArchivaPoVideo {

    public static void main(String[] args) throws IOException {
        readZip();
    }

    private static void readZip() throws IOException {
        ZipFile zf = new ZipFile("C:/Users/Sanchio/Desktop/dirForJRTasks/6/archive.zip");

        zf.stream().forEach(new MyZip(zf));
    }
}

class MyZip implements Consumer<ZipEntry> {
    private ZipFile zf;

    public MyZip(ZipFile zf) {
        this.zf = zf;
    }

    @Override
    public void accept(ZipEntry ze) {
        try {
            System.out.println("Entry: " + ze.getName());
            if (!ze.isDirectory()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(zf.getInputStream(ze)));
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("------------------>>>>>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
