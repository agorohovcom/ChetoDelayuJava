package Files1.Zip.PoVideo;

// Видео: https://www.youtube.com/watch?v=xoEpbDRP5dM&ab_channel=%D0%98%D0%B7%D1%83%D1%87%D0%B0%D0%B5%D0%BCJava

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SozdanieFailaVFormateZipPoVideo {

    private static final String FILE = "test.zip";

    public static void main(String[] args) throws Exception {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(FILE));

//        // 1 - создаём архив и кладём туда 2 текстовых файла
//        ZipEntry ze1 = new ZipEntry("name1.txt");
//        zos.putNextEntry(ze1);
//        zos.write("SUPER1".getBytes());
//
//        ZipEntry ze2 = new ZipEntry("name2.txt");
//        zos.putNextEntry(ze2);
//        zos.write("SUPER2".getBytes());

        // 2 - архивируем всё содержимое папки
        createZipDir(zos, new File(".").listFiles(), "");

        zos.close();
    }

    private static void createZipDir(ZipOutputStream zos, File[] files, String path) throws Exception {
        for(File f : files){
            if(f.isDirectory()){
                createZipDir(zos, f.listFiles(), path + f.getName() + File.pathSeparator);
            } else if(!f.getName().equals(FILE)){
                ZipEntry ze = new ZipEntry(path + f.getName());
                zos.putNextEntry(ze);

                FileInputStream fis = new FileInputStream(f);
                byte[] buffer = new byte[1024];
                int size = -1;
                while((size = fis.read()) != -1){
                    zos.write(buffer, 0, size);
                }
            }
        }
    }
}
